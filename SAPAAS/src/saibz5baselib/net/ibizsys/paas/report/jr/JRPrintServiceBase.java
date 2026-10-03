package net.ibizsys.paas.report.jr;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.report.IPrintService;
import net.ibizsys.paas.report.PrintServiceBase;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JExcelApiExporter;

/**
 * JasperReport 打印服务
 * 
 * @author Administrator
 *
 */
public abstract class JRPrintServiceBase extends PrintServiceBase {
	public final static String PARAM_ACTIVEENTITY = "SRFAE";
	public final static String PARAM_WEBCONTEXT = "SRFWC";
	public final static String PARAM_PRINTSERVICE = "SRFPS";

	private static final Log log = LogFactory.getLog(JRPrintServiceBase.class);

	@Override
	protected String getPrintFile(ArrayList<IEntity> entityList, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception {
		String strReportFile = strPrintFileFolder + getReportFilePath();
		strReportFile = iWebContext.getRequest().getRealPath(strReportFile);

		String strTempFilePath = java.io.File.createTempFile("print_", ".pdf").getPath();
		//
		Map parameters = new HashMap();

		parameters.put(PARAM_WEBCONTEXT, iWebContext);
		parameters.put(PARAM_PRINTSERVICE, this);
		parameters.put(JRReportServiceBase.PARAM_REPORTSERVICE, this);

		this.fillParameters(parameters);
		this.fillParametersEx(parameters);
		this.generatePrintFile(strReportFile, strTempFilePath, parameters, strContentType, entityList);

		return strTempFilePath;
	}

	@Override
	protected String getPrintFile(IEntity entity, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception {
		String strReportFile = strPrintFileFolder + getReportFilePath();
		strReportFile = iWebContext.getRequest().getRealPath(strReportFile);

		String strTempFilePath = java.io.File.createTempFile("print_", ".pdf").getPath();
		//
		Map parameters = new HashMap();

		parameters.put(PARAM_WEBCONTEXT, iWebContext);
		parameters.put(PARAM_ACTIVEENTITY, entity);
		parameters.put(PARAM_PRINTSERVICE, this);
		parameters.put(JRReportServiceBase.PARAM_REPORTSERVICE, this);

		this.fillParameters(parameters);
		this.fillParametersEx(parameters);
		if (!StringHelper.isNullOrEmpty(this.getDetailDEDataSetName())) {

			// 指定了结果集合
			DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(iWebContext);
			deDataSetFetchContextImpl.setSessionFactory(iService.getSessionFactory());
			deDataSetFetchContextImpl.setActiveDataObject(entity);

			fillFetchConditions(deDataSetFetchContextImpl);
			fillDEDataSetFetchContext(deDataSetFetchContextImpl);

			IService detailService = DEModelGlobal.getDEModel(this.getDetailDEName()).getService(iService.getSessionFactory());
			DBFetchResult fetchResult = detailService.fetchDataSet(this.getDetailDEDataSetName(), deDataSetFetchContextImpl);
			if (fetchResult.getRetCode() == Errors.OK) {
				try {
					this.generatePrintFile(strReportFile, strTempFilePath, parameters, strContentType, fetchResult.getDataSet());
					fetchResult.getDataSet().close();
				} catch (Exception ex) {
					fetchResult.getDataSet().close();
					throw ex;
				}
			}
		} else {
			this.generatePrintFile(strReportFile, strTempFilePath, parameters, strContentType, null);
		}

		return strTempFilePath;

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
			if(iSystem instanceof IJRPrintServiceParamFiller){
				((IJRPrintServiceParamFiller)iSystem).fillParameters(parameters, this);
			}
		}
	}

	/**
	 * 导出打印报表
	 * @param strPrintFormPath
	 * @param strTempPath
	 * @param parameters
	 * @param strContentType
	 * @param objData
	 * @throws Exception
	 */
	protected void generatePrintFile(String strPrintFormPath, String strTempPath, Map parameters, String strContentType, Object objData) throws Exception {
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

	// /**
	// * 获取报表临时文件路径
	// * @return
	// */
	// protected String GetTmpFilePath()
	// {
	// if(StringHelper.compare(strContentType, Report.TAG_REPORTTYPE_PDF, true) == 0)
	// return StringHelper.Format("%1$s%2$s.pdf", this.globalHelper.GetTempPath(),Helper.GenGuid());
	// return StringHelper.Format("%1$s%2$s", globalHelper.GetTempPath(),Helper.GenGuid());
	// }
	//

	// /**
	// * 完成事务查询
	// * @param nMode
	// * @param iServiceWork
	// * @throws Exception
	// */
	// protected DBFetchResult doServiceFetchWork(IDEDataSetFetchContext iDEDataSetFetchContext,IDAO iDAO,String strDEDataSetName, boolean bTempMode) throws Exception
	// {
	// long nBeginTime = java.lang.System.currentTimeMillis();
	// try
	// {
	// SessionFactoryManager.addRef();
	// DBFetchResult dbFetchResult = iDAO.fetchDEDataSet(iDEDataSetFetchContext, strDEDataSetName, bTempMode);
	// SessionFactoryManager.releaseRef(false);
	// long nTime = java.lang.System.currentTimeMillis() - nBeginTime;
	// log.debug(StringHelper.format("查询耗时[%1$s]", nTime));
	// return dbFetchResult;
	// }
	// catch (Exception ex)
	// {
	// log.error(StringHelper.format("实体[%1$s]doServiceFetchWork发生异常，%2$s",this.getDEModel().getName(),ex.getMessage()), ex);
	// SessionFactoryManager.releaseRef(false);
	// throw ex;
	// }
	// }
	//

}
