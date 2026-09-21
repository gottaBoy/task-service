/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DevReport
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.jasperreports.engine.JasperCompileManager
 */
package SA.SRFDA.Dev.Ctrl.Form;

import SA.SRFDA.Ctrl.Data.DevReport;
import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import net.sf.jasperreports.engine.JasperCompileManager;

public class DevReportFormActionHelper
extends BaseDAFormActionHelper {
    protected CallResult OnSaveActionAfterInsert(CallResult callResult, BaseDataEntity dataEntity) {
        if ((callResult = super.OnSaveActionAfterInsert(callResult, dataEntity)).getRetCode() != 0) {
            return callResult;
        }
        return this.ExecuteDevReportAction(dataEntity);
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity) {
        if ((callResult = super.OnSaveActionAfterUpdate(callResult, dataEntity)).getRetCode() != 0) {
            return callResult;
        }
        return this.ExecuteDevReportAction(dataEntity);
    }

    protected CallResult ExecuteDevReportAction(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strReportAction = this.getWebContext().GetPostValue("srfdevreport");
        if (StringHelper.IsNullOrEmpty((String)strReportAction)) {
            return callResult;
        }
        if (StringHelper.Compare((String)strReportAction, (String)"COMPILE", (boolean)true) == 0) {
            return this.Complie(dataEntity);
        }
        callResult.setRetCode(1);
        callResult.setErrorInfo("\u65e0\u6cd5\u8bc6\u522b\u7684\u62a5\u8868\u64cd\u4f5c\u6307\u4ee4");
        return callResult;
    }

    protected CallResult Complie(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        DevReport devReport = new DevReport();
        devReport.Proxy(dataEntity);
        String strTmpFile = this.getWebContext().getGlobalHelper().GetTempPath();
        strTmpFile = String.valueOf(strTmpFile) + Helper.GenGuid() + ".jrxml";
        try {
            OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strTmpFile), "UTF-8");
            out.write(devReport.getREPORTMODEL());
            out.flush();
            out.close();
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u4fdd\u5b58\u62a5\u8868\u5230\u4e34\u65f6\u6587\u4ef6[%1$s]\u51fa\u73b0\u9519\u8bef\uff0c%2$s", (Object)strTmpFile, (Object)ex.getMessage()));
            return callResult;
        }
        String strDstFile = this.getWebContext().getGlobalHelper().GetAppRootPath();
        strDstFile = String.valueOf(strDstFile) + devReport.getDSTPATH();
        try {
            JasperCompileManager.compileReportToFile((String)strTmpFile, (String)strDstFile);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u7f16\u8bd1\u62a5\u8868\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
        this.SetPageInfo("\u4fdd\u5b58\u5e76\u7f16\u8bd1\u62a5\u8868\u6210\u529f\uff01");
        callResult.Reset();
        return callResult;
    }
}

