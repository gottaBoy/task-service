/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.PrintForm
 *  SA.SRFDA.Ctrl.Data.PrintLog
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFDA.Web.SRFDAHttpServletContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.sf.jasperreports.engine.JRDataSource
 *  net.sf.jasperreports.engine.JasperRunManager
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Ctrl.Data.PrintLog;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.DAJRDataSource;
import SA.SRFDA.Report.Utility.PDFPrintHelper;
import SA.SRFDA.Report.Utility.PrintDialogMode;
import SA.SRFDA.Report.Web.PrintFormActionHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.ISRFExWebContext;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrintFormBuilder
extends SRFDAHttpServlet {
    private static final Log log = LogFactory.getLog(PrintFormBuilder.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CallResult callResult;
        this.addTimeOutHeaders(response);
        String strReportType = this.getInitParameter("REPORTTYPE");
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(request, response, this.getServletContext());
        PrintForm printForm = new PrintForm();
        String strDEId = servletContext.GetParamValue("SRFDEID");
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            this.SendbackError(servletContext, "\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u5b9e\u4f53\u7f16\u53f7", strReportType, request, response);
            return;
        }
        IDEHelper iDEHelper = servletContext.getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
        if (iDEHelper == null) {
            this.SendbackError(servletContext, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId), strReportType, request, response);
            return;
        }
        IDEDataCtrl iDEDataCtrl = iDEHelper.GetDEDataCtrl(servletContext.getCurUserId(), null);
        if (iDEDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId));
            this.SendbackError(servletContext, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId), strReportType, request, response);
            return;
        }
        String strFormName = servletContext.GetParamValue("PRINTFORM");
        if (StringHelper.IsNullOrEmpty((String)strFormName)) {
            strFormName = "DEFAULT";
        }
        if ((callResult = servletContext.getGlobalHelper().getDAModelHelper().GetDEPrintForm(strDEId, strFormName, printForm)).getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6307\u5b9a\u62a5\u8868[%2$s]\uff0c%3$s", (Object)strDEId, (Object)strFormName, (Object)callResult.getErrorInfo()));
            this.SendbackError(servletContext, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6307\u5b9a\u62a5\u8868[%2$s]\uff0c%3$s", (Object)strDEId, (Object)strFormName, (Object)callResult.getErrorInfo()), strReportType, request, response);
            return;
        }
        String strKey = iDEHelper.GetKeyDEFHelper().getName();
        String strKeyValue = servletContext.GetParamValue(strKey);
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            this.SendbackError(servletContext, StringHelper.Format((String)"\u6ca1\u6709\u4f20\u5165\u5b9e\u4f53[%1$s]\u6570\u636e\u952e\u503c", (Object)strDEId), strReportType, request, response);
            return;
        }
        if (printForm.getENABLEMP()) {
            this.DoMulitplePrintInDataSource(strReportType, strDEId, iDEHelper, iDEDataCtrl, printForm, strKey, strKeyValue, servletContext, request, response);
            return;
        }
        String strPrintMode = servletContext.GetParamValue("PRINTMODE");
        if (StringHelper.Compare((String)strPrintMode, (String)"MULTIPLE", (boolean)true) == 0 && StringHelper.Compare((String)strReportType, (String)"PDF", (boolean)true) == 0) {
            this.DoMulitplePrint(strReportType, strDEId, iDEHelper, strKey, strKeyValue, servletContext, request, response);
            return;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(strKey, DataTypeParse.Parse((String)iDEHelper.GetKeyDEFHelper().GetStdDataType(), (String)strKeyValue));
        callResult = iDEHelper.GetDataAccHelper().Test((ISRFDAWebContext)servletContext, dataEntity, "READ");
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u68c0\u67e5\u7528\u6237\u6570\u636e\u6743\u9650\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()));
            this.SendbackError(servletContext, StringHelper.Format((String)"\u68c0\u67e5\u7528\u6237\u6570\u636e\u6743\u9650\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()), strReportType, request, response);
            return;
        }
        callResult = StringHelper.IsNullOrEmpty((String)printForm.getGETACTION()) ? iDEDataCtrl.Get(dataEntity) : iDEDataCtrl.CustomCall(printForm.getGETACTION(), dataEntity);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s][%2$s]\u5931\u8d25\uff0c%3$s", (Object)strDEId, (Object)strKeyValue, (Object)callResult.getErrorInfo()));
            this.SendbackError(servletContext, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s][%2$s]\u5931\u8d25\uff0c%3$s", (Object)strDEId, (Object)strKeyValue, (Object)callResult.getErrorInfo()), strReportType, request, response);
            return;
        }
        if (printForm.getENABLECOLPRIV()) {
            IUserPrivilegeMgr iUserPrivilegeMgr = servletContext.GetUserPrivilegeMgr();
            for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                int nRet;
                if (!iDEFHelper.IsEnableDEFieldPriv() || (nRet = iUserPrivilegeMgr.TestColumn((ISRFExWebContext)servletContext, StringHelper.Format((String)"%1$s|%2$s", (Object)iDEHelper.getId(), (Object)iDEFHelper.getId()))) != 0) continue;
                dataEntity.RemoveParam(iDEFHelper.getName());
            }
        }
        PrintFormActionHelper printFormActionHelper = null;
        String strReportObject = printForm.getFORMOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strReportObject)) {
            printFormActionHelper = new PrintFormActionHelper();
        } else {
            Object obj = ObjectHelper.Create((String)strReportObject);
            if (obj == null) {
                this.SendbackError(servletContext, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6253\u5370\u8868\u5355\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strReportObject), strReportType, request, response);
                return;
            }
            if (!(obj instanceof PrintFormActionHelper)) {
                this.SendbackError(servletContext, StringHelper.Format((String)"\u6253\u5370\u8868\u5355\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strReportObject), strReportType, request, response);
                return;
            }
            printFormActionHelper = (PrintFormActionHelper)obj;
        }
        String strReportFile = printFormActionHelper.GetPrintFormFile(dataEntity, (ISRFDAWebContext)servletContext, (ISRFDAGlobalHelper)servletContext.getGlobalHelper(), printForm, strReportType);
        if (StringHelper.IsNullOrEmpty((String)strReportFile)) {
            log.error((Object)StringHelper.Format((String)"\u751f\u6210\u62a5\u8868\u6587\u4ef6\u5931\u8d25"));
            return;
        }
        if (PrintFormBuilder.SendBackFile(strReportFile, strReportType, request, response) && printForm.getENABLELOG()) {
            PrintLog printLog = new PrintLog();
            printLog.setPRINTFORMID(printForm.getPRINTFORMID());
            printLog.setFORMDATA(strKeyValue);
            IDEDataCtrl printLogDataCtrl = servletContext.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0202", (ISRFDAWebContext)servletContext);
            if (printLogDataCtrl != null) {
                printLogDataCtrl.Save(true, (BaseDataEntity)printLog);
            }
        }
    }

    protected void DoMulitplePrintInDataSource(String strReportType, String strDEId, IDEHelper iDEHelper, IDEDataCtrl iDEDataCtrl, PrintForm printForm, String strKey, String strKeyMultiValue, SRFDAHttpServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        String[] arrKeyValue;
        Vector<BaseDataEntity> dataEntities = new Vector<BaseDataEntity>();
        String[] stringArray = arrKeyValue = strKeyMultiValue.split(",");
        int n = arrKeyValue.length;
        int n2 = 0;
        while (n2 < n) {
            String strKeyValue = stringArray[n2];
            BaseDataEntity dataEntity = new BaseDataEntity();
            dataEntity.SetParamValue(strKey, DataTypeParse.Parse((String)iDEHelper.GetKeyDEFHelper().GetStdDataType(), (String)strKeyValue));
            CallResult callResult = iDEHelper.GetDataAccHelper().Test((ISRFDAWebContext)servletContext, dataEntity, "READ");
            if (callResult.getRetCode() != 0) {
                this.SendbackError(servletContext, StringHelper.Format((String)"\u68c0\u67e5\u7528\u6237\u6570\u636e\u6743\u9650\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()), strReportType, request, response);
                return;
            }
            callResult = StringHelper.IsNullOrEmpty((String)printForm.getGETACTION()) ? iDEDataCtrl.Get(dataEntity) : iDEDataCtrl.CustomCall(printForm.getGETACTION(), dataEntity);
            if (callResult.getRetCode() != 0) {
                this.SendbackError(servletContext, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s][%2$s]\u5931\u8d25\uff0c%3$s", (Object)strDEId, (Object)strKeyValue, (Object)callResult.getErrorInfo()), strReportType, request, response);
                return;
            }
            if (printForm.getENABLECOLPRIV()) {
                IUserPrivilegeMgr iUserPrivilegeMgr = servletContext.GetUserPrivilegeMgr();
                for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                    int nRet;
                    if (!iDEFHelper.IsEnableDEFieldPriv() || (nRet = iUserPrivilegeMgr.TestColumn((ISRFExWebContext)servletContext, StringHelper.Format((String)"%1$s|%2$s", (Object)iDEHelper.getId(), (Object)iDEFHelper.getId()))) != 0) continue;
                    dataEntity.RemoveParam(iDEFHelper.getName());
                }
            }
            dataEntities.add(dataEntity);
            ++n2;
        }
        PrintFormActionHelper printFormActionHelper = null;
        String strReportObject = printForm.getFORMOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strReportObject)) {
            printFormActionHelper = new PrintFormActionHelper();
        } else {
            Object obj = ObjectHelper.Create((String)strReportObject);
            if (obj == null) {
                this.SendbackError(servletContext, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6253\u5370\u8868\u5355\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strReportObject), strReportType, request, response);
                return;
            }
            if (!(obj instanceof PrintFormActionHelper)) {
                this.SendbackError(servletContext, StringHelper.Format((String)"\u6253\u5370\u8868\u5355\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strReportObject), strReportType, request, response);
                return;
            }
            printFormActionHelper = (PrintFormActionHelper)obj;
        }
        String strReportFile = printFormActionHelper.GetPrintFormFile(dataEntities, (ISRFDAWebContext)servletContext, (ISRFDAGlobalHelper)servletContext.getGlobalHelper(), printForm, strReportType);
        if (StringHelper.IsNullOrEmpty((String)strReportFile)) {
            log.error((Object)StringHelper.Format((String)"\u751f\u6210\u62a5\u8868\u6587\u4ef6\u5931\u8d25"));
            return;
        }
        if (PrintFormBuilder.SendBackFile(strReportFile, strReportType, request, response) && printForm.getENABLELOG()) {
            PrintLog printLog = new PrintLog();
            printLog.setPRINTFORMID(printForm.getPRINTFORMID());
            printLog.setFORMDATA(strKeyMultiValue);
            IDEDataCtrl printLogDataCtrl = servletContext.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0202", (ISRFDAWebContext)servletContext);
            if (printLogDataCtrl != null) {
                printLogDataCtrl.Save(true, (BaseDataEntity)printLog);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void DoMulitplePrint(String strReportType, String strDEId, IDEHelper iDEHelper, String strKey, String strKeyMultiValue, SRFDAHttpServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        block21: {
            iDEDataCtrl = iDEHelper.GetDEDataCtrl(servletContext.getCurUserId(), null);
            if (iDEDataCtrl == null) {
                this.SendbackError(servletContext, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId), strReportType, request, response);
                return;
            }
            strFormName = servletContext.GetParamValue("PRINTFORM");
            if (StringHelper.IsNullOrEmpty((String)strFormName)) {
                strFormName = "DEFAULT";
            }
            printForm = new PrintForm();
            callResult = servletContext.getGlobalHelper().getDAModelHelper().GetDEPrintForm(strDEId, strFormName, printForm);
            if (callResult.getRetCode() != 0) {
                this.SendbackError(servletContext, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6307\u5b9a\u62a5\u8868[%2$s]\uff0c%3$s", (Object)strDEId, (Object)strFormName, (Object)callResult.getErrorInfo()), strReportType, request, response);
                return;
            }
            arrPdfFiles = new ArrayList<String>();
            var18_15 = arrKeyValue = strKeyMultiValue.split(",");
            var17_17 = arrKeyValue.length;
            var16_20 = 0;
            while (var16_20 < var17_17) {
                block22: {
                    strKeyValue = var18_15[var16_20];
                    dataEntity = new BaseDataEntity();
                    dataEntity.SetParamValue(strKey, DataTypeParse.Parse((String)iDEHelper.GetKeyDEFHelper().GetStdDataType(), (String)strKeyValue));
                    callResult = iDEHelper.GetDataAccHelper().Test((ISRFDAWebContext)servletContext, dataEntity, "READ");
                    if (callResult.getRetCode() != 0) {
                        this.SendbackError(servletContext, StringHelper.Format((String)"\u68c0\u67e5\u7528\u6237\u6570\u636e\u6743\u9650\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()), strReportType, request, response);
                        return;
                    }
                    callResult = StringHelper.IsNullOrEmpty((String)printForm.getGETACTION()) != false ? iDEDataCtrl.Get(dataEntity) : iDEDataCtrl.CustomCall(printForm.getGETACTION(), dataEntity);
                    if (callResult.getRetCode() != 0) {
                        this.SendbackError(servletContext, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s][%2$s]\u5931\u8d25\uff0c%3$s", (Object)strDEId, (Object)strKeyValue, (Object)callResult.getErrorInfo()), strReportType, request, response);
                        return;
                    }
                    if (printForm.getENABLECOLPRIV()) {
                        iUserPrivilegeMgr = servletContext.GetUserPrivilegeMgr();
                        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                            if (!iDEFHelper.IsEnableDEFieldPriv() || (nRet = iUserPrivilegeMgr.TestColumn((ISRFExWebContext)servletContext, StringHelper.Format((String)"%1$s|%2$s", (Object)iDEHelper.getId(), (Object)iDEFHelper.getId()))) != 0) continue;
                            dataEntity.RemoveParam(iDEFHelper.getName());
                        }
                    }
                    printFormActionHelper = null;
                    strReportObject = printForm.getFORMOBJECT();
                    if (!StringHelper.IsNullOrEmpty((String)strReportObject)) break block22;
                    printFormActionHelper = new PrintFormActionHelper();
                    ** GOTO lbl49
                }
                obj = ObjectHelper.Create((String)strReportObject);
                if (obj == null) {
                    this.SendbackError(servletContext, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6253\u5370\u8868\u5355\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strReportObject), strReportType, request, response);
                } else if (!(obj instanceof PrintFormActionHelper)) {
                    this.SendbackError(servletContext, StringHelper.Format((String)"\u6253\u5370\u8868\u5355\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strReportObject), strReportType, request, response);
                } else {
                    printFormActionHelper = (PrintFormActionHelper)obj;
lbl49:
                    // 2 sources

                    servletContext.SetParamValue(strKey, strKeyValue);
                    strReportFile = printFormActionHelper.GetPrintFormFile(dataEntity, (ISRFDAWebContext)servletContext, (ISRFDAGlobalHelper)servletContext.getGlobalHelper(), printForm, strReportType);
                    if (StringHelper.IsNullOrEmpty((String)strReportFile)) {
                        PrintFormBuilder.log.error((Object)StringHelper.Format((String)"\u751f\u6210\u62a5\u8868\u6587\u4ef6\u5931\u8d25[%1$s]", (Object)strKeyValue));
                    } else {
                        arrPdfFiles.add(strReportFile);
                    }
                }
                ++var16_20;
            }
            strMergedPdfURL = this.GetTmpFilePath(servletContext, strReportType, "MERGED_");
            pdfPrintHelper = new PDFPrintHelper(strMergedPdfURL, arrPdfFiles, this.OnGetPrintDialogMode(servletContext));
            try {
                try {
                    pdfPrintHelper.DoMerge();
                }
                catch (Exception e) {
                    this.SendbackError(servletContext, StringHelper.Format((String)"\u5408\u5e76\u6587\u4ef6\u51fa\u73b0\u9519\u8bef\uff01"), strReportType, request, response);
                    e.printStackTrace();
                    pdfPrintHelper.Close();
                    break block21;
                }
            }
            catch (Throwable var18_16) {
                pdfPrintHelper.Close();
                throw var18_16;
            }
            pdfPrintHelper.Close();
        }
        if (PrintFormBuilder.SendBackFile(strMergedPdfURL, strReportType, request, response) && printForm.getENABLELOG()) {
            printLog = new PrintLog();
            printLog.setPRINTFORMID(printForm.getPRINTFORMID());
            printLog.setFORMDATA(strKeyMultiValue);
            printLogDataCtrl = servletContext.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0202", (ISRFDAWebContext)servletContext);
            if (printLogDataCtrl != null) {
                printLogDataCtrl.Save(true, (BaseDataEntity)printLog);
            }
        }
    }

    protected String OnGetPrintDialogMode(SRFDAHttpServletContext servletContext) {
        String strPrintDialogMode = servletContext.GetParamValue("PRINTDIALOGMODE");
        if (StringHelper.IsNullOrEmpty((String)strPrintDialogMode)) {
            strPrintDialogMode = servletContext.getWebExConfig().GetValue("SRFDA", "PRINTDIALOGMODE", PrintDialogMode.NONE);
        }
        return strPrintDialogMode;
    }

    protected void SendbackError(SRFDAHttpServletContext servletContext, String strError, String strReportType, HttpServletRequest request, HttpServletResponse response) {
        log.error((Object)strError);
        String strPrintFormPath = String.valueOf(servletContext.GetAppRootPath()) + "srfreport" + File.separator + "printform" + File.separator + "error.jasper";
        String strTempFilePath = this.GetTmpFilePath(servletContext, strReportType);
        TreeMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("ERROR_INFO", strError);
        try {
            JasperRunManager.runReportToPdfFile((String)strPrintFormPath, (String)strTempFilePath, parameters, (JRDataSource)new DAJRDataSource(null));
            PrintFormBuilder.SendBackFile(strTempFilePath, strReportType, request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static boolean SendBackFile(String strReportFile, String strReportType, HttpServletRequest request, HttpServletResponse response) {
        boolean bRet = true;
        try {
            if (StringHelper.Compare((String)strReportType, (String)"PDF", (boolean)true) == 0) {
                response.setContentType("application/pdf");
            }
            BufferedInputStream bis = null;
            FilterOutputStream bos = null;
            try {
                try {
                    int bytesRead;
                    bis = new BufferedInputStream(new FileInputStream(strReportFile));
                    bos = new BufferedOutputStream((OutputStream)response.getOutputStream());
                    byte[] buff = new byte[2048];
                    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                        ((BufferedOutputStream)bos).write(buff, 0, bytesRead);
                    }
                }
                catch (IOException e) {
                    bRet = false;
                    System.out.println("\u51fa\u73b0IOException." + e);
                    if (bis != null) {
                        bis.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                }
            }
            finally {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            }
        }
        catch (Exception ex) {
            bRet = false;
            ex.printStackTrace();
        }
        return bRet;
    }

    protected String GetTmpFilePath(SRFDAHttpServletContext servletContext, String strReportType, String strPrefix) {
        String strFileName = String.valueOf(strPrefix) + Helper.GenGuid();
        if (StringHelper.Compare((String)strReportType, (String)"PDF", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s%2$s.pdf", (Object)servletContext.GetTempPath(), (Object)strFileName);
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)strReportType, (Object)strFileName);
    }

    protected String GetTmpFilePath(SRFDAHttpServletContext servletContext, String strReportType) {
        return this.GetTmpFilePath(servletContext, strReportType, "");
    }
}

