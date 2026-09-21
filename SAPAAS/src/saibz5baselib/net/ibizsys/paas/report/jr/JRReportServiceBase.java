/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.jasperreports.engine.JRDataSource
 *  net.sf.jasperreports.engine.JRExporterParameter
 *  net.sf.jasperreports.engine.JasperFillManager
 *  net.sf.jasperreports.engine.JasperPrint
 *  net.sf.jasperreports.engine.JasperRunManager
 *  net.sf.jasperreports.engine.export.JExcelApiExporter
 *  net.sf.jasperreports.engine.export.JRPdfExporter
 *  net.sf.jasperreports.engine.export.JRXhtmlExporter
 *  net.sf.jasperreports.engine.export.JRXlsExporter
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.report.jr;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.report.ReportServiceBase;
import net.ibizsys.paas.report.ReportServiceGlobal;
import net.ibizsys.paas.report.jr.DataTableJRDataSource;
import net.ibizsys.paas.report.jr.EntitiesJRDataSource;
import net.ibizsys.paas.report.jr.IJRReportService;
import net.ibizsys.paas.report.jr.IJRReportServiceParamFiller;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class JRReportServiceBase
extends ReportServiceBase
implements IJRReportService {
    private static final Log log = LogFactory.getLog(JRReportServiceBase.class);
    public static final String PARAM_ACTIVEENTITY = "SRFAE";
    public static final String PARAM_WEBCONTEXT = "SRFWC";
    public static final String PARAM_REPORTSERVICE = "SRFRS";

    @Override
    public String getReportFile(IWebContext iWebContext, SessionFactory sessionFactory, String strContentType, String strPrintFileFolder) throws Exception {
        String strTempFilePath = this.createTempFilePath(strContentType);
        IService iService = this.getDEModel().getService(sessionFactory);
        if (this.hasSubReport()) {
            ArrayList<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
            SimpleEntity iEntity = new SimpleEntity();
            ArrayList<SimpleEntity> entityList = new ArrayList<SimpleEntity>();
            if (!StringHelper.isNullOrEmpty(this.getDEDataSetName())) {
                DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext(iWebContext);
                dEDataSetFetchContext.setSessionFactory(sessionFactory);
                dEDataSetFetchContext.setActiveDataObject(iEntity);
                this.fillFetchConditions(dEDataSetFetchContext);
                this.fillDEDataSetFetchContext(dEDataSetFetchContext);
                DBFetchResult fetchResult = iService.fetchDataSet(this.getDEDataSetName(), dEDataSetFetchContext);
                if (fetchResult.getRetCode() == 0) {
                    try {
                        fetchResult.getDataSet().cacheDataRow();
                        IDataTable iDataTable = fetchResult.getDataSet().getDataTable(0);
                        int i = 0;
                        while (i < iDataTable.getCachedRowCount()) {
                            SimpleEntity simpleEntity = new SimpleEntity();
                            DataObject.fromDataRow(simpleEntity, iDataTable.getCachedRow(i));
                            entityList.add(simpleEntity);
                            ++i;
                        }
                        fetchResult.getDataSet().close();
                    }
                    catch (Exception ex) {
                        fetchResult.getDataSet().close();
                        throw ex;
                    }
                }
            } else {
                entityList.add(iEntity);
            }
            for (IEntity iEntity2 : entityList) {
                Iterator<String> subReportIds = this.getSubReportIds();
                while (subReportIds.hasNext()) {
                    String strSubReportId = subReportIds.next();
                    IJRReportService childJRReportService = (IJRReportService)ReportServiceGlobal.getReportService(strSubReportId);
                    List<JasperPrint> list = childJRReportService.getReportJasperPrints(iEntity2, iWebContext, sessionFactory, strContentType, strPrintFileFolder);
                    jasperPrintList.addAll(list);
                }
            }
            this.generateReportFile(jasperPrintList, strTempFilePath, strContentType);
            return strTempFilePath;
        }
        if (StringHelper.isNullOrEmpty(this.getDEDataSetName())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u62a5\u8868\u6570\u636e\u96c6\u5408");
        }
        String strReportFile = String.valueOf(strPrintFileFolder) + this.getReportFilePath();
        strReportFile = iWebContext.getRequest().getRealPath(strReportFile);
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(PARAM_WEBCONTEXT, iWebContext);
        parameters.put(PARAM_REPORTSERVICE, this);
        parameters.put("SRFPS", this);
        this.fillParameters(parameters);
        this.fillParametersEx(parameters);
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(iWebContext);
        deDataSetFetchContextImpl.setSessionFactory(iService.getSessionFactory());
        this.fillFetchConditions(deDataSetFetchContextImpl);
        this.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
        this.generateReportFile(strReportFile, strTempFilePath, parameters, strContentType, iService, deDataSetFetchContextImpl, this.getDEDataSetName());
        return strTempFilePath;
    }

    @Override
    public List<JasperPrint> getReportJasperPrints(IEntity iEntity, IWebContext iWebContext, SessionFactory sessionFactory, String strContentType, String strPrintFileFolder) throws Exception {
        IService iService = this.getDEModel().getService(sessionFactory);
        ArrayList<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
        if (this.hasSubReport()) {
            ArrayList<IEntity> entityList = new ArrayList<IEntity>();
            if (!StringHelper.isNullOrEmpty(this.getDEDataSetName())) {
                DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(iWebContext);
                deDataSetFetchContextImpl.setSessionFactory(sessionFactory);
                deDataSetFetchContextImpl.setActiveDataObject(iEntity);
                this.fillFetchConditions(deDataSetFetchContextImpl);
                this.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
                DBFetchResult fetchResult = iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);
                if (fetchResult.getRetCode() == 0) {
                    try {
                        fetchResult.getDataSet().cacheDataRow();
                        IDataTable iDataTable = fetchResult.getDataSet().getDataTable(0);
                        int i = 0;
                        while (i < iDataTable.getCachedRowCount()) {
                            SimpleEntity simpleEntity = new SimpleEntity();
                            DataObject.fromDataRow(simpleEntity, iDataTable.getCachedRow(i));
                            entityList.add(simpleEntity);
                            ++i;
                        }
                        fetchResult.getDataSet().close();
                    }
                    catch (Exception ex) {
                        fetchResult.getDataSet().close();
                        throw ex;
                    }
                }
            } else {
                entityList.add(iEntity);
            }
            for (IEntity childItem : entityList) {
                Iterator<String> subReportIds = this.getSubReportIds();
                while (subReportIds.hasNext()) {
                    String strSubReportId = subReportIds.next();
                    IJRReportService childJRReportService = (IJRReportService)ReportServiceGlobal.getReportService(strSubReportId);
                    List<JasperPrint> list = childJRReportService.getReportJasperPrints(childItem, iWebContext, sessionFactory, strContentType, strPrintFileFolder);
                    jasperPrintList.addAll(list);
                }
            }
        } else {
            String strReportFile = String.valueOf(strPrintFileFolder) + this.getReportFilePath();
            strReportFile = iWebContext.getRequest().getRealPath(strReportFile);
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put(PARAM_WEBCONTEXT, iWebContext);
            parameters.put(PARAM_ACTIVEENTITY, iEntity);
            parameters.put(PARAM_REPORTSERVICE, this);
            parameters.put("SRFPS", this);
            this.fillParameters(parameters);
            this.fillParametersEx(parameters);
            if (!StringHelper.isNullOrEmpty(this.getDEDataSetName())) {
                DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(iWebContext);
                deDataSetFetchContextImpl.setSessionFactory(iService.getSessionFactory());
                deDataSetFetchContextImpl.setActiveDataObject(iEntity);
                this.fillFetchConditions(deDataSetFetchContextImpl);
                this.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
                jasperPrintList.add(this.createJasperPrint(strReportFile, parameters, iService, deDataSetFetchContextImpl, this.getDEDataSetName()));
            }
        }
        return jasperPrintList;
    }

    protected void fillParameters(Map parameters) {
    }

    protected void fillParametersEx(Map parameters) throws Exception {
        Iterator<ISystem> sysModels = SysModelGlobal.getAllSystems();
        while (sysModels.hasNext()) {
            ISystem iSystem = sysModels.next();
            if (!(iSystem instanceof IJRReportServiceParamFiller)) continue;
            ((IJRReportServiceParamFiller)((Object)iSystem)).fillParameters(parameters, this);
        }
    }

    protected JasperPrint createJasperPrint(String strReportFullPath, Map parameters, IService iService, DEDataSetFetchContext deDataSetFetchContextImpl, String strDEDataSetName) throws Exception {
        long nBeginTime = System.currentTimeMillis();
        DBFetchResult dbFetchResult = null;
        try {
            deDataSetFetchContextImpl.setCacheDataSet(false);
            SessionFactoryManager.addRef();
            dbFetchResult = iService.getDAO().fetchDEDataSet(deDataSetFetchContextImpl, strDEDataSetName, false);
            JasperPrint jasperPrint = this.createJasperPrint(strReportFullPath, parameters, dbFetchResult.getDataSet());
            dbFetchResult.getDataSet().close();
            SessionFactoryManager.releaseRef(false);
            long nTime = System.currentTimeMillis() - nBeginTime;
            log.debug((Object)StringHelper.format("\u67e5\u8be2\u8017\u65f6[%1$s]", nTime));
            return jasperPrint;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u4ea7\u751f\u62a5\u8868\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            if (dbFetchResult != null && dbFetchResult.getDataSet() != null) {
                dbFetchResult.getDataSet().close();
            }
            SessionFactoryManager.releaseRef(false);
            throw ex;
        }
    }

    protected JasperPrint createJasperPrint(String strReportFullPath, Map parameters, Object objData) throws Exception {
        try {
            if (objData != null) {
                if (objData instanceof IDataSet) {
                    IDataSet iDataSet = (IDataSet)objData;
                    JasperPrint jasperPrint = JasperFillManager.fillReport((String)strReportFullPath, (Map)parameters, (JRDataSource)this.getJRDataSource(iDataSet.getDataTable(0)));
                    return jasperPrint;
                }
                if (objData instanceof ArrayList) {
                    ArrayList dataEntities = (ArrayList)objData;
                    JasperPrint jasperPrint = JasperFillManager.fillReport((String)strReportFullPath, (Map)parameters, (JRDataSource)this.getJRDataSource(dataEntities));
                    return jasperPrint;
                }
            }
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u6570\u636e\u5bf9\u8c61"));
        }
        catch (Exception e) {
            log.error((Object)e);
            throw e;
        }
    }

    protected void generateReportFile(ArrayList<JasperPrint> jasperPrintList, String strTempPath, String strContentType) throws Exception {
        try {
            Object exporter = null;
            exporter = StringHelper.compare(strContentType, "PDF", true) == 0 ? new JRPdfExporter() : (StringHelper.compare(strContentType, "EXCEL", true) == 0 ? new JRXlsExporter() : (StringHelper.compare(strContentType, "HTML", true) == 0 ? new JRXhtmlExporter() : new JRPdfExporter()));
            exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, (Object)strTempPath);
            exporter.exportReport();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u5bfc\u51fa\u62a5\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            log.error((Object)ex);
            throw ex;
        }
    }

    protected void generateReportFile(String strPrintFormPath, String strTempPath, Map parameters, String strContentType, IService iService, DEDataSetFetchContext deDataSetFetchContextImpl, String strDEDataSetName) throws Exception {
        long nBeginTime = System.currentTimeMillis();
        DBFetchResult dbFetchResult = null;
        try {
            deDataSetFetchContextImpl.setCacheDataSet(false);
            SessionFactoryManager.addRef();
            dbFetchResult = iService.getDAO().fetchDEDataSet(deDataSetFetchContextImpl, strDEDataSetName, false);
            this.generateReportFile(strPrintFormPath, strTempPath, parameters, strContentType, dbFetchResult.getDataSet());
            dbFetchResult.getDataSet().close();
            SessionFactoryManager.releaseRef(false);
            long nTime = System.currentTimeMillis() - nBeginTime;
            log.debug((Object)StringHelper.format("\u67e5\u8be2\u8017\u65f6[%1$s]", nTime));
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u4ea7\u751f\u62a5\u8868\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            if (dbFetchResult != null && dbFetchResult.getDataSet() != null) {
                dbFetchResult.getDataSet().close();
            }
            SessionFactoryManager.releaseRef(false);
            throw ex;
        }
    }

    protected void generateReportFile(String strPrintFormPath, String strTempPath, Map parameters, String strContentType, Object objData) throws Exception {
        try {
            if (objData == null) {
                if (StringHelper.compare(strContentType, "PDF", true) == 0) {
                    JasperRunManager.runReportToPdfFile((String)strPrintFormPath, (String)strTempPath, (Map)parameters);
                    return;
                }
                if (StringHelper.compare(strContentType, "HTML", true) == 0) {
                    JasperRunManager.runReportToHtmlFile((String)strPrintFormPath, (String)strTempPath, (Map)parameters);
                    return;
                }
                if (StringHelper.compare(strContentType, "EXCEL", true) == 0) {
                    JasperPrint report = JasperFillManager.fillReport((String)strPrintFormPath, (Map)parameters);
                    JExcelApiExporter exporter = new JExcelApiExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, (Object)report);
                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, (Object)new File(strTempPath));
                    exporter.exportReport();
                    return;
                }
            } else if (objData instanceof IDataSet) {
                IDataSet iDataSet = (IDataSet)objData;
                if (StringHelper.compare(strContentType, "PDF", true) == 0) {
                    JasperRunManager.runReportToPdfFile((String)strPrintFormPath, (String)strTempPath, (Map)parameters, (JRDataSource)this.getJRDataSource(iDataSet.getDataTable(0)));
                    return;
                }
                if (StringHelper.compare(strContentType, "HTML", true) == 0) {
                    JasperRunManager.runReportToHtmlFile((String)strPrintFormPath, (String)strTempPath, (Map)parameters, (JRDataSource)this.getJRDataSource(iDataSet.getDataTable(0)));
                    return;
                }
                if (StringHelper.compare(strContentType, "EXCEL", true) == 0) {
                    JasperPrint report = JasperFillManager.fillReport((String)strPrintFormPath, (Map)parameters, iDataSet == null ? null : this.getJRDataSource(iDataSet.getDataTable(0)));
                    JExcelApiExporter exporter = new JExcelApiExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, (Object)report);
                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, (Object)new File(strTempPath));
                    exporter.exportReport();
                    return;
                }
            } else if (objData instanceof ArrayList) {
                ArrayList dataEntities = (ArrayList)objData;
                if (StringHelper.compare(strContentType, "PDF", true) == 0) {
                    JasperRunManager.runReportToPdfFile((String)strPrintFormPath, (String)strTempPath, (Map)parameters, dataEntities == null ? null : this.getJRDataSource(dataEntities));
                    return;
                }
                if (StringHelper.compare(strContentType, "HTML", true) == 0) {
                    JasperRunManager.runReportToHtmlFile((String)strPrintFormPath, (String)strTempPath, (Map)parameters, dataEntities == null ? null : this.getJRDataSource(dataEntities));
                    return;
                }
                if (StringHelper.compare(strContentType, "EXCEL", true) == 0) {
                    JasperPrint report = JasperFillManager.fillReport((String)strPrintFormPath, (Map)parameters, dataEntities == null ? null : this.getJRDataSource(dataEntities));
                    JExcelApiExporter exporter = new JExcelApiExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, (Object)report);
                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, (Object)new File(strTempPath));
                    exporter.exportReport();
                    return;
                }
            }
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6253\u5370\u5185\u5bb9\u683c\u5f0f[%1$s]", strContentType));
        }
        catch (Exception e) {
            log.error((Object)e);
            throw e;
        }
    }

    protected JRDataSource getJRDataSource(IDataTable dataTable) {
        return new DataTableJRDataSource(dataTable);
    }

    protected JRDataSource getJRDataSource(ArrayList<IEntity> dataEntities) {
        return new EntitiesJRDataSource(dataEntities);
    }

    protected String createTempFilePath(String strContentType) throws Exception {
        String strExt = "";
        strExt = StringHelper.compare(strContentType, "PDF", true) == 0 ? ".pdf" : (StringHelper.compare(strContentType, "EXCEL", true) == 0 ? ".xls" : (StringHelper.compare(strContentType, "HTML", true) == 0 ? ".html" : ".pdf"));
        String strTempFilePath = File.createTempFile("report_", strExt).getPath();
        return strTempFilePath;
    }

    @Override
    public String getCodeListText(String strCodeListId, String strValue) throws Exception {
        return CodeListGlobal.getCodeList(strCodeListId).getCodeListText(strValue, true);
    }
}

