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
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.report.jr;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.report.PrintServiceBase;
import net.ibizsys.paas.report.jr.DataTableJRDataSource;
import net.ibizsys.paas.report.jr.EntitiesJRDataSource;
import net.ibizsys.paas.report.jr.IJRPrintServiceParamFiller;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class JRPrintServiceBase
extends PrintServiceBase {
    public static final String PARAM_ACTIVEENTITY = "SRFAE";
    public static final String PARAM_WEBCONTEXT = "SRFWC";
    public static final String PARAM_PRINTSERVICE = "SRFPS";
    private static final Log log = LogFactory.getLog(JRPrintServiceBase.class);

    @Override
    protected String getPrintFile(ArrayList<IEntity> entityList, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception {
        String strReportFile = String.valueOf(strPrintFileFolder) + this.getReportFilePath();
        strReportFile = iWebContext.getRequest().getRealPath(strReportFile);
        String strTempFilePath = File.createTempFile("print_", ".pdf").getPath();
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(PARAM_WEBCONTEXT, iWebContext);
        parameters.put(PARAM_PRINTSERVICE, this);
        parameters.put("SRFRS", this);
        this.fillParameters(parameters);
        this.fillParametersEx(parameters);
        this.generatePrintFile(strReportFile, strTempFilePath, parameters, strContentType, entityList);
        return strTempFilePath;
    }

    @Override
    protected String getPrintFile(IEntity entity, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception {
        String strReportFile = String.valueOf(strPrintFileFolder) + this.getReportFilePath();
        strReportFile = iWebContext.getRequest().getRealPath(strReportFile);
        String strTempFilePath = File.createTempFile("print_", ".pdf").getPath();
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(PARAM_WEBCONTEXT, iWebContext);
        parameters.put(PARAM_ACTIVEENTITY, entity);
        parameters.put(PARAM_PRINTSERVICE, this);
        parameters.put("SRFRS", this);
        this.fillParameters(parameters);
        this.fillParametersEx(parameters);
        if (!StringHelper.isNullOrEmpty(this.getDetailDEDataSetName())) {
            DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(iWebContext);
            deDataSetFetchContextImpl.setSessionFactory(iService.getSessionFactory());
            deDataSetFetchContextImpl.setActiveDataObject(entity);
            this.fillFetchConditions(deDataSetFetchContextImpl);
            this.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
            IService detailService = DEModelGlobal.getDEModel(this.getDetailDEName()).getService(iService.getSessionFactory());
            DBFetchResult fetchResult = detailService.fetchDataSet(this.getDetailDEDataSetName(), deDataSetFetchContextImpl);
            if (fetchResult.getRetCode() == 0) {
                try {
                    this.generatePrintFile(strReportFile, strTempFilePath, parameters, strContentType, fetchResult.getDataSet());
                    fetchResult.getDataSet().close();
                }
                catch (Exception ex) {
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

    protected void fillParametersEx(Map parameters) throws Exception {
        Iterator<ISystem> sysModels = SysModelGlobal.getAllSystems();
        while (sysModels.hasNext()) {
            ISystem iSystem = sysModels.next();
            if (!(iSystem instanceof IJRPrintServiceParamFiller)) continue;
            ((IJRPrintServiceParamFiller)((Object)iSystem)).fillParameters(parameters, this);
        }
    }

    protected void generatePrintFile(String strPrintFormPath, String strTempPath, Map parameters, String strContentType, Object objData) throws Exception {
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
}

