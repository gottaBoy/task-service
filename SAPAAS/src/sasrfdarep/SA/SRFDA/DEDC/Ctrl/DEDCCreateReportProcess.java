/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.Data.Report
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.DEDC.Ctrl.DEDCProcess
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.SimpleWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.Data.Report;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFDA.Report.Web.ReportActionHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.SimpleWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.File;
import java.util.Date;

public class DEDCCreateReportProcess
extends DEDCProcess {
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        BaseDataEntity srcDataEntity = null;
        srcDataEntity = dedcContext.GetDataEntity(strSrcDataEntity);
        if (srcDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        String strReportId = processConfig.getDEDCProcess().getPARAM1();
        if (StringHelper.IsNullOrEmpty((String)strReportId)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u62a5\u8868\u7f16\u53f7"));
            return callResult;
        }
        Report report = new Report();
        callResult = dedcContext.GetGlobalHelper().getDAModelHelper().GetReport(strReportId, report);
        if (callResult.getRetCode() != 0) {
            dedcContext.Log(1, (Object)this, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u62a5\u8868[%1$s]\uff0c%2$s", (Object)strReportId, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u62a5\u8868\u7f16\u53f7[%1$s]", (Object)strReportId));
        BaseDataEntity dstDataEntity = new BaseDataEntity();
        srcDataEntity.CopyTo(dstDataEntity, true);
        callResult = this.FillDataEntity(dedcContext, processConfig, srcDataEntity, dstDataEntity);
        if (callResult.IsError()) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u586b\u5145\u76ee\u6807\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
            return callResult;
        }
        String strReportType = processConfig.getDEDCProcess().getPARAM3();
        ReportActionHelper reportActionHelper = null;
        String strReportObject = report.getREPORTOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strReportObject)) {
            reportActionHelper = new ReportActionHelper();
        } else {
            Object obj = ObjectHelper.Create((String)strReportObject);
            if (obj == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u62a5\u8868\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strReportObject));
                dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
                return callResult;
            }
            if (!(obj instanceof ReportActionHelper)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u62a5\u8868\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strReportObject));
                dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
                return callResult;
            }
            reportActionHelper = (ReportActionHelper)obj;
        }
        ISRFDAWebContext iDAWebContext = null;
        boolean bSimpleWebContext = processConfig.getDEDCProcess().getPARAM9();
        if (bSimpleWebContext) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u4f7f\u7528\u6570\u636e\u5bf9\u8c61\u4eff\u771f\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61"));
            SimpleWebContext simpleWebContext = new SimpleWebContext(dedcContext.GetGlobalHelper(), dstDataEntity);
            simpleWebContext.setCurUserId(dedcContext.GetPersonId());
            iDAWebContext = simpleWebContext;
        } else {
            iDAWebContext = dedcContext.GetWebContext();
        }
        String strReportFile = reportActionHelper.GetReportFile(iDAWebContext, dedcContext.GetGlobalHelper(), report, strReportType);
        if (StringHelper.IsNullOrEmpty((String)strReportFile)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u751f\u6210\u62a5\u8868\u6587\u4ef6\u5931\u8d25"));
            dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
            return callResult;
        }
        String strReportName = processConfig.getDEDCProcess().getPARAM12();
        if (!StringHelper.IsNullOrEmpty((String)strReportName)) {
            strReportName = StringHelper.Format((String)strReportName, (Object)new Date());
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u62a5\u8868\u540d\u79f0[%1$s]", (Object)strReportName));
        if (!StringHelper.IsNullOrEmpty((String)strReportName)) {
            String strNewFolder = StringHelper.Format((String)"%1$sreportfile%2$s%3$s", (Object)dedcContext.GetGlobalHelper().GetTempPath(), (Object)File.separator, (Object)Helper.GenGuid());
            File folder = new File(strNewFolder);
            if (!folder.mkdirs()) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5efa\u7acb\u62a5\u8868\u76ee\u5f55[%1$s]", (Object)strNewFolder));
                dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
                return callResult;
            }
            File reportFile = new File(strReportFile);
            strReportName = String.valueOf(strNewFolder = String.valueOf(strNewFolder) + File.separator) + strReportName;
            if (!reportFile.renameTo(new File(strReportName))) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u91cd\u547d\u540d\u62a5\u8868\u6587\u4ef6[%1$s]\u5230[%2$s]\u5931\u8d25", (Object)strReportFile, (Object)strReportName));
                dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
                return callResult;
            }
            strReportFile = strReportName;
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u62a5\u8868\u4fdd\u5b58\u8def\u5f84[%1$s]", (Object)strReportFile));
        }
        srcDataEntity.SetParamValue(processConfig.getDEDCProcess().getPARAM11(), (Object)strReportFile);
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8bbe\u7f6e\u6e90\u6570\u636e\u5bf9\u8c61\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)processConfig.getDEDCProcess().getPARAM11(), (Object)strReportFile));
        callResult.Reset();
        return callResult;
    }
}

