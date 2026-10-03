package net.ibizsys.paas.report.jr;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.report.IPrintService;
import net.ibizsys.paas.report.IReportService;
import net.ibizsys.paas.report.ReportServiceBase;
import net.ibizsys.paas.report.ReportServiceGlobal;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 * JasperReport打印服务对象
 * 
 * @author Administrator
 *
 */
public abstract class JRReportServiceBase extends ReportServiceBase implements IJRReportService {
	private static final Log log = LogFactory.getLog(JRReportServiceBase.class);

	public final static String PARAM_ACTIVEENTITY = "SRFAE";
	public final static String PARAM_WEBCONTEXT = "SRFWC";
	public final static String PARAM_REPORTSERVICE = "SRFRS";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IReportService#getReportFile(net.ibizsys.paas.web.IWebContext, org.hibernate.SessionFactory, java.lang.String, java.lang.String)
	 */
	@Override
	public String getReportFile(IWebContext iWebContext, SessionFactory sessionFactory, String strContentType, String strPrintFileFolder) throws Exception {
		String strTempFilePath = this.createTempFilePath(strContentType);

		IService iService = this.getDEModel().getService(sessionFactory);
		if (this.hasSubReport()) {
			ArrayList<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
			SimpleEntity iEntity = new SimpleEntity();
			ArrayList<IEntity> entityList = new ArrayList<IEntity>();
			if (!StringHelper.isNullOrEmpty(this.getDEDataSetName())) {
				// 指定了结果集合
				DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(iWebContext);
				deDataSetFetchContextImpl.setSessionFactory(sessionFactory);
				deDataSetFetchContextImpl.setActiveDataObject(iEntity);

				fillFetchConditions(deDataSetFetchContextImpl);
				fillDEDataSetFetchContext(deDataSetFetchContextImpl);

				// fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);

				DBFetchResult fetchResult = iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);
				if (fetchResult.getRetCode() == Errors.OK) {
					try {
						fetchResult.getDataSet().cacheDataRow();
						IDataTable iDataTable = fetchResult.getDataSet().getDataTable(0);
						for (int i = 0; i < iDataTable.getCachedRowCount(); i++) {
							SimpleEntity simpleEntity = new SimpleEntity();
							DataObject.fromDataRow(simpleEntity, iDataTable.getCachedRow(i));
							entityList.add(simpleEntity);
						}
						fetchResult.getDataSet().close();
					} catch (Exception ex) {
						fetchResult.getDataSet().close();
						throw ex;
					}
				}
			} else {
				entityList.add(iEntity);
			}

			for (IEntity childItem : entityList) {
				java.util.Iterator<String> subReportIds = this.getSubReportIds();
				while (subReportIds.hasNext()) {
					String strSubReportId = subReportIds.next();
					IJRReportService childJRReportService = (IJRReportService) ReportServiceGlobal.getReportService(strSubReportId);
					List<JasperPrint> list = childJRReportService.getReportJasperPrints(childItem, iWebContext, sessionFactory, strContentType, strPrintFileFolder);
					jasperPrintList.addAll(list);
				}
			}

			generateReportFile(jasperPrintList, strTempFilePath, strContentType);
			return strTempFilePath;
		} else {
			if (StringHelper.isNullOrEmpty(this.getDEDataSetName())) {
				throw new Exception("没有指定报表数据集合");
			}

			String strReportFile = strPrintFileFolder + getReportFilePath();
			strReportFile = iWebContext.getRequest().getRealPath(strReportFile);

			Map parameters = new HashMap();

			parameters.put(PARAM_WEBCONTEXT, iWebContext);
			parameters.put(PARAM_REPORTSERVICE, this);
			parameters.put(JRPrintServiceBase.PARAM_PRINTSERVICE, this);
			this.fillParameters(parameters);
			this.fillParametersEx(parameters);
			// 指定了结果集合
			DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(iWebContext);
			deDataSetFetchContextImpl.setSessionFactory(iService.getSessionFactory());

			fillFetchConditions(deDataSetFetchContextImpl);
			fillDEDataSetFetchContext(deDataSetFetchContextImpl);

			// DBFetchResult fetchResult = iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);
			// if (fetchResult.getRetCode() == Errors.OK) {
			// try {
			// this.generateReportFile(strReportFile, strTempFilePath, parameters, strContentType, fetchResult.getDataSet());
			// fetchResult.getDataSet().close();
			// } catch (Exception ex) {
			// fetchResult.getDataSet().close();
			// throw ex;
			// }
			// }

			this.generateReportFile(strReportFile, strTempFilePath, parameters, strContentType, iService, deDataSetFetchContextImpl, this.getDEDataSetName());
			return strTempFilePath;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.jr.IJRReportService#getReportJasperPrints(net.ibizsys.paas.entity.IEntity, net.ibizsys.paas.web.IWebContext, org.hibernate.SessionFactory, java.lang.String, java.lang.String)
	 */
	@Override
	public List<JasperPrint> getReportJasperPrints(IEntity iEntity, IWebContext iWebContext, SessionFactory sessionFactory, String strContentType, String strPrintFileFolder) throws Exception {
		IService iService = this.getDEModel().getService(sessionFactory);
		ArrayList<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		if (hasSubReport()) {
			ArrayList<IEntity> entityList = new ArrayList<IEntity>();
			if (!StringHelper.isNullOrEmpty(this.getDEDataSetName())) {
				// 指定了结果集合
				DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(iWebContext);
				deDataSetFetchContextImpl.setSessionFactory(sessionFactory);
				deDataSetFetchContextImpl.setActiveDataObject(iEntity);

				fillFetchConditions(deDataSetFetchContextImpl);
				fillDEDataSetFetchContext(deDataSetFetchContextImpl);

				// fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);

				DBFetchResult fetchResult = iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);
				if (fetchResult.getRetCode() == Errors.OK) {
					try {
						fetchResult.getDataSet().cacheDataRow();
						IDataTable iDataTable = fetchResult.getDataSet().getDataTable(0);
						for (int i = 0; i < iDataTable.getCachedRowCount(); i++) {
							SimpleEntity simpleEntity = new SimpleEntity();
							DataObject.fromDataRow(simpleEntity, iDataTable.getCachedRow(i));
							entityList.add(simpleEntity);
						}
						fetchResult.getDataSet().close();
					} catch (Exception ex) {
						fetchResult.getDataSet().close();
						throw ex;
					}
				}
			} else {
				entityList.add(iEntity);
			}

			for (IEntity childItem : entityList) {
				java.util.Iterator<String> subReportIds = this.getSubReportIds();
				while (subReportIds.hasNext()) {
					String strSubReportId = subReportIds.next();
					IJRReportService childJRReportService = (IJRReportService) ReportServiceGlobal.getReportService(strSubReportId);
					List<JasperPrint> list = childJRReportService.getReportJasperPrints(childItem, iWebContext, sessionFactory, strContentType, strPrintFileFolder);
					jasperPrintList.addAll(list);
				}
			}
		} else {
			String strReportFile = strPrintFileFolder + getReportFilePath();
			strReportFile = iWebContext.getRequest().getRealPath(strReportFile);

			Map parameters = new HashMap();

			parameters.put(PARAM_WEBCONTEXT, iWebContext);
			parameters.put(PARAM_ACTIVEENTITY, iEntity);
			parameters.put(PARAM_REPORTSERVICE, this);
			parameters.put(JRPrintServiceBase.PARAM_PRINTSERVICE, this);
			this.fillParameters(parameters);
			this.fillParametersEx(parameters);
			if (!StringHelper.isNullOrEmpty(this.getDEDataSetName())) {

				// 指定了结果集合
				DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(iWebContext);
				deDataSetFetchContextImpl.setSessionFactory(iService.getSessionFactory());
				deDataSetFetchContextImpl.setActiveDataObject(iEntity);

				fillFetchConditions(deDataSetFetchContextImpl);
				fillDEDataSetFetchContext(deDataSetFetchContextImpl);

				jasperPrintList.add(createJasperPrint(strReportFile, parameters, iService, deDataSetFetchContextImpl, this.getDEDataSetName()));
				// DBFetchResult fetchResult = iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);
				// if (fetchResult.getRetCode() == Errors.OK) {
				// try {
				// jasperPrintList.add(this.createJasperPrint(strReportFile, parameters, fetchResult.getDataSet()));
				// fetchResult.getDataSet().close();
				// } catch (Exception ex) {
				// fetchResult.getDataSet().close();
				// throw ex;
				// }
				// }
			}
		}

		return jasperPrintList;
	}

	protected void fillParameters(Map parameters) {

	}

	/**
	 * 填充参数扩展
	 * @param parameters
	 * @throws Exception
	 */
	protected void fillParametersEx(Map parameters) throws Exception{

		java.util.Iterator<ISystem> sysModels = SysModelGlobal.getAllSystems();
		while(sysModels.hasNext()){
			ISystem iSystem = sysModels.next();
			if(iSystem instanceof IJRReportServiceParamFiller){
				((IJRReportServiceParamFiller)iSystem).fillParameters(parameters, this);
			}
		}
	}
	
	/**
	 * 建立Jasper打印
	 * 
	 * @param strReportFullPath
	 * @param parameters
	 * @param iService
	 * @param deDataSetFetchContextImpl
	 * @param strDEDataSetName
	 * @return
	 * @throws Exception
	 */
	protected JasperPrint createJasperPrint(String strReportFullPath, Map parameters, IService iService, DEDataSetFetchContext deDataSetFetchContextImpl, String strDEDataSetName) throws Exception {
		// 查询并输出报表
		long nBeginTime = java.lang.System.currentTimeMillis();
		DBFetchResult dbFetchResult = null;
		try {
			deDataSetFetchContextImpl.setCacheDataSet(false);

			SessionFactoryManager.addRef();
			dbFetchResult = iService.getDAO().fetchDEDataSet(deDataSetFetchContextImpl, strDEDataSetName, false);

			// 产生报表
			JasperPrint jasperPrint = this.createJasperPrint(strReportFullPath, parameters, dbFetchResult.getDataSet());

			// 关闭结果集合
			dbFetchResult.getDataSet().close();

			SessionFactoryManager.releaseRef(false);
			long nTime = java.lang.System.currentTimeMillis() - nBeginTime;
			log.debug(StringHelper.format("查询耗时[%1$s]", nTime));

			return jasperPrint;
		} catch (Exception ex) {
			log.error(StringHelper.format("产生报表文件发生异常，%1$s", ex.getMessage()), ex);

			// 关闭结果集合
			if (dbFetchResult != null && dbFetchResult.getDataSet() != null) {
				dbFetchResult.getDataSet().close();
			}

			SessionFactoryManager.releaseRef(false);
			throw ex;
		}
	}

	/**
	 * 建立Jasper打印
	 * 
	 * @param strReportFullPath
	 * @param parameters
	 * @param objData
	 * @return
	 * @throws Exception
	 */
	protected JasperPrint createJasperPrint(String strReportFullPath, Map parameters, Object objData) throws Exception {
		try {
			if (objData == null) {
				// if(StringHelper.compare(strContentType,
				// IPrintService.CONTENTTYPE_PDF, true) == 0)
				// {
				// JasperRunManager.runReportToPdfFile(strPrintFormPath,strTempPath,
				// parameters);
				// return;
				// }
				//
				// if(StringHelper.compare(strContentType,
				// IPrintService.CONTENTTYPE_EXCEL, true) == 0)
				// {
				// JasperPrint report =
				// JasperFillManager.fillReport(strPrintFormPath,parameters);
				// JRAbstractExporter exporter = new JExcelApiExporter();
				// exporter.setParameter(JRExporterParameter.JASPER_PRINT,
				// report);
				// exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new
				// File(strTempPath));
				// exporter.exportReport();
				// return;
				// }
			} else {
				if (objData instanceof IDataSet) {
					IDataSet iDataSet = (IDataSet) objData;
					JasperPrint jasperPrint = JasperFillManager.fillReport(strReportFullPath, parameters, getJRDataSource(iDataSet.getDataTable(0)));
					return jasperPrint;
				} else if (objData instanceof ArrayList) {
					ArrayList<IEntity> dataEntities = (ArrayList<IEntity>) objData;
					JasperPrint jasperPrint = JasperFillManager.fillReport(strReportFullPath, parameters, getJRDataSource(dataEntities));
					return jasperPrint;
				}
			}

			throw new Exception(StringHelper.format("无法识别数据对象"));
		} catch (Exception e) {
			log.error(e);
			throw e;
		}

	}

	/**
	 * 产生报表文件
	 * 
	 * @param jasperPrintList
	 * @param strTempPath
	 * @param strContentType
	 * @throws Exception
	 */
	protected void generateReportFile(ArrayList<JasperPrint> jasperPrintList, String strTempPath, String strContentType) throws Exception {
		try {
			JRExporter exporter = null;
			if (StringHelper.compare(strContentType, IReportService.CONTENTTYPE_PDF, true) == 0) {
				exporter = new JRPdfExporter();
			} else if (StringHelper.compare(strContentType, IReportService.CONTENTTYPE_EXCEL, true) == 0) {
				exporter = new JRXlsExporter();
			} else if (StringHelper.compare(strContentType, IReportService.CONTENTTYPE_HTML, true) == 0) {
				exporter = new JRXhtmlExporter();
			} else
				exporter = new JRPdfExporter();

			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, strTempPath);
			exporter.exportReport();
		} catch (Exception ex) {
			log.error(StringHelper.format("导出报表发生异常，%1$s", ex.getMessage()), ex);
			log.error(ex);
			throw ex;
		}
	}

	/**
	 * 产生报表文件，通过游标的方式解决问题
	 * 
	 * @param strPrintFormPath
	 * @param strTempPath
	 * @param parameters
	 * @param strContentType
	 * @param iService
	 * @param iDEDataSetFetchContext
	 * @param strDEDataSetName
	 * @throws Exception
	 */
	protected void generateReportFile(String strPrintFormPath, String strTempPath, Map parameters, String strContentType, IService iService, DEDataSetFetchContext deDataSetFetchContextImpl, String strDEDataSetName) throws Exception {
		// 查询并输出报表
		long nBeginTime = java.lang.System.currentTimeMillis();
		DBFetchResult dbFetchResult = null;
		try {
			deDataSetFetchContextImpl.setCacheDataSet(false);

			SessionFactoryManager.addRef();
			dbFetchResult = iService.getDAO().fetchDEDataSet(deDataSetFetchContextImpl, strDEDataSetName, false);

			// 产生报表
			this.generateReportFile(strPrintFormPath, strTempPath, parameters, strContentType, dbFetchResult.getDataSet());

			// 关闭结果集合
			dbFetchResult.getDataSet().close();

			SessionFactoryManager.releaseRef(false);
			long nTime = java.lang.System.currentTimeMillis() - nBeginTime;
			log.debug(StringHelper.format("查询耗时[%1$s]", nTime));
		} catch (Exception ex) {
			log.error(StringHelper.format("产生报表文件发生异常，%1$s", ex.getMessage()), ex);

			// 关闭结果集合
			if (dbFetchResult != null && dbFetchResult.getDataSet() != null) {
				dbFetchResult.getDataSet().close();
			}

			SessionFactoryManager.releaseRef(false);
			throw ex;
		}
	}

	/**
	 * 导出打印报表
	 * 
	 * @param strPrintFormPath
	 * @param strTempPath
	 * @param parameters
	 * @param strContentType
	 * @param objData
	 * @throws Exception
	 */
	protected void generateReportFile(String strPrintFormPath, String strTempPath, Map parameters, String strContentType, Object objData) throws Exception {
		try {
			if (objData == null) {
				if (StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_PDF, true) == 0) {
					JasperRunManager.runReportToPdfFile(strPrintFormPath, strTempPath, parameters);
					return;
				}

				if (StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_HTML, true) == 0) {
					JasperRunManager.runReportToHtmlFile(strPrintFormPath, strTempPath, parameters);
					return;
				}

				if (StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_EXCEL, true) == 0) {
					JasperPrint report = JasperFillManager.fillReport(strPrintFormPath, parameters);
					JRAbstractExporter exporter = new JExcelApiExporter();
					exporter.setParameter(JRExporterParameter.JASPER_PRINT, report);
					exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(strTempPath));
					exporter.exportReport();
					return;
				}
			} else {
				if (objData instanceof IDataSet) {
					IDataSet iDataSet = (IDataSet) objData;
					if (StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_PDF, true) == 0) {
						JasperRunManager.runReportToPdfFile(strPrintFormPath, strTempPath, parameters, getJRDataSource(iDataSet.getDataTable(0)));
						return;
					}

					if (StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_HTML, true) == 0) {
						JasperRunManager.runReportToHtmlFile(strPrintFormPath, strTempPath, parameters, getJRDataSource(iDataSet.getDataTable(0)));
						return;
					}

					if (StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_EXCEL, true) == 0) {
						JasperPrint report = JasperFillManager.fillReport(strPrintFormPath, parameters, (iDataSet == null) ? null : getJRDataSource(iDataSet.getDataTable(0)));
						JRAbstractExporter exporter = new JExcelApiExporter();
						exporter.setParameter(JRExporterParameter.JASPER_PRINT, report);
						exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(strTempPath));
						exporter.exportReport();
						return;
					}
				} else if (objData instanceof ArrayList) {
					ArrayList<IEntity> dataEntities = (ArrayList<IEntity>) objData;
					if (StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_PDF, true) == 0) {
						JasperRunManager.runReportToPdfFile(strPrintFormPath, strTempPath, parameters, (dataEntities == null) ? null : getJRDataSource(dataEntities));
						return;
					}

					if (StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_HTML, true) == 0) {
						JasperRunManager.runReportToHtmlFile(strPrintFormPath, strTempPath, parameters, (dataEntities == null) ? null : getJRDataSource(dataEntities));
						return;
					}

					if (StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_EXCEL, true) == 0) {
						JasperPrint report = JasperFillManager.fillReport(strPrintFormPath, parameters, (dataEntities == null) ? null : getJRDataSource(dataEntities));
						JRAbstractExporter exporter = new JExcelApiExporter();
						exporter.setParameter(JRExporterParameter.JASPER_PRINT, report);
						exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(strTempPath));
						exporter.exportReport();
						return;
					}
				}
			}

			throw new Exception(StringHelper.format("无法识别的打印内容格式[%1$s]", strContentType));
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 获取报表数据源
	 * 
	 * @param dataTable
	 * @return
	 */
	protected JRDataSource getJRDataSource(IDataTable dataTable) {
		return new DataTableJRDataSource(dataTable);
	}

	/**
	 * 获取报表数据源
	 * 
	 * @param dataTable
	 * @return
	 */
	protected JRDataSource getJRDataSource(ArrayList<IEntity> dataEntities) {
		return new EntitiesJRDataSource(dataEntities);
	}

	protected String createTempFilePath(String strContentType) throws Exception {
		String strExt = "";
		if (StringHelper.compare(strContentType, IReportService.CONTENTTYPE_PDF, true) == 0) {
			strExt = ".pdf";
		} else if (StringHelper.compare(strContentType, IReportService.CONTENTTYPE_EXCEL, true) == 0) {
			strExt = ".xls";
		} else if (StringHelper.compare(strContentType, IReportService.CONTENTTYPE_HTML, true) == 0) {
			strExt = ".html";
		} else
			strExt = ".pdf";

		String strTempFilePath = java.io.File.createTempFile("report_", strExt).getPath();
		return strTempFilePath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.jr.IJRReportService#getCodeListText(java.lang.String, java.lang.String)
	 */
	@Override
	public String getCodeListText(String strCodeListId, String strValue) throws Exception {
		return CodeListGlobal.getCodeList(strCodeListId).getCodeListText(strValue, true);
	}

}
