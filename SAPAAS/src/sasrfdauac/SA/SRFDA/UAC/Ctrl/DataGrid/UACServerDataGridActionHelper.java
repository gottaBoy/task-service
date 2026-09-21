/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 */
package SA.SRFDA.UAC.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.UAC.Api.UACClientAPI;
import SA.SRFDA.UAC.Ctrl.Data.UACServer;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;

public class UACServerDataGridActionHelper
extends BaseDADataGridActionHelper {
    public static final String ACTION_UPDATEPOLICY = "UPDATEPOLICY";
    public static final String ACTION_PUBLISHWEBFILE = "PUBLISHWEBFILE";

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_UPDATEPOLICY, (boolean)true) == 0) {
            return this.OnUpdatePolicy();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_PUBLISHWEBFILE, (boolean)true) == 0) {
            return this.OnPublishWebFile();
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnUpdatePolicy() {
        SRFExDGAjaxActionResult updatePolicyResult = new SRFExDGAjaxActionResult();
        updatePolicyResult.setReload(true);
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        IDEDataCtrl uacDataCtrl = this.getPage().getDEHelper().GetDEDataCtrl(this.getWebContext().getCurUserId(), (ISRFDAWebContext)this.getWebContext());
        int i = 0;
        while (i < keys.length) {
            String strKeyValue = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                UACServer uacServer = new UACServer();
                uacServer.setUACSERVERID(strKeyValue);
                CallResult callResult = uacDataCtrl.Get((BaseDataEntity)uacServer);
                if (callResult.IsError()) {
                    updatePolicyResult.From(callResult);
                    updatePolicyResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u670d\u52a1\u5668[%1$s]\u8ba4\u8bc1\u7b56\u7565\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                    this.getPage().PageLog((Object)this, 1, updatePolicyResult.getErrorInfo());
                    this.getPage().Output(updatePolicyResult.ToJSONString());
                    return true;
                }
                UACClientAPI uacClientAPI = new UACClientAPI();
                String strUACUrl = uacServer.getSERVERURL();
                if (!StringHelper.IsNullOrEmpty((String)strUACUrl) && strUACUrl.charAt(strUACUrl.length() - 1) != '/') {
                    strUACUrl = String.valueOf(strUACUrl) + "/";
                }
                if ((callResult = uacClientAPI.Init(strUACUrl = String.valueOf(strUACUrl) + "wsservices/UACService?wsdl", true)) == null || callResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u7edf\u4e00\u8ba4\u8bc1\u670d\u52a1\u5668WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    updatePolicyResult.setRetCode(1);
                    updatePolicyResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u7edf\u4e00\u8ba4\u8bc1\u670d\u52a1\u5668WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    this.getPage().Output(updatePolicyResult.ToJSONString());
                    return true;
                }
                callResult = uacClientAPI.UpdatePolicy(strKeyValue, this.getWebContext().getCurUserId());
                if (callResult == null || callResult.getRetCode() != 0) {
                    updatePolicyResult.From(callResult);
                    updatePolicyResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u7edf\u4e00\u8ba4\u8bc1\u670d\u52a1\u5668[%1$s]\u7b56\u7565\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                    this.getPage().PageLog((Object)this, 1, updatePolicyResult.getErrorInfo());
                    this.getPage().Output(updatePolicyResult.ToJSONString());
                    return true;
                }
            }
            ++i;
        }
        updatePolicyResult.setRetCode(0);
        updatePolicyResult.AppendJSCode("alert('\u6210\u529f\u53d1\u9001\u5411\u670d\u52a1\u5668\u53d1\u9001\u66f4\u65b0\u6307\u4ee4\uff01\u8bf7\u7a0d\u5019\u91cd\u8bd5\u3002');");
        this.getPage().Output(updatePolicyResult.ToJSONString());
        return true;
    }

    protected boolean OnPublishWebFile() {
        SRFExDGAjaxActionResult updatePolicyResult = new SRFExDGAjaxActionResult();
        updatePolicyResult.setReload(true);
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        IDEDataCtrl uacDataCtrl = this.getPage().getDEHelper().GetDEDataCtrl(this.getWebContext().getCurUserId(), (ISRFDAWebContext)this.getWebContext());
        int i = 0;
        while (i < keys.length) {
            String strKeyValue = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                UACServer uacServer = new UACServer();
                uacServer.setUACSERVERID(strKeyValue);
                CallResult callResult = uacDataCtrl.Get((BaseDataEntity)uacServer);
                if (callResult.IsError()) {
                    updatePolicyResult.From(callResult);
                    updatePolicyResult.setErrorInfo(StringHelper.Format((String)"\u53d1\u5e03\u670d\u52a1\u5668[%1$s]\u7f51\u7ad9\u6587\u4ef6\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                    this.getPage().PageLog((Object)this, 1, updatePolicyResult.getErrorInfo());
                    this.getPage().Output(updatePolicyResult.ToJSONString());
                    return true;
                }
                UACClientAPI uacClientAPI = new UACClientAPI();
                String strUACUrl = uacServer.getSERVERURL();
                if (!StringHelper.IsNullOrEmpty((String)strUACUrl) && strUACUrl.charAt(strUACUrl.length() - 1) != '/') {
                    strUACUrl = String.valueOf(strUACUrl) + "/";
                }
                if ((callResult = uacClientAPI.Init(strUACUrl = String.valueOf(strUACUrl) + "wsservices/UACService?wsdl", true)) == null || callResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u7edf\u4e00\u8ba4\u8bc1\u670d\u52a1\u5668WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    updatePolicyResult.setRetCode(1);
                    updatePolicyResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u7edf\u4e00\u8ba4\u8bc1\u670d\u52a1\u5668WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    this.getPage().Output(updatePolicyResult.ToJSONString());
                    return true;
                }
                callResult = uacClientAPI.PublishWebFile(strKeyValue, this.getWebContext().getCurUserId());
                if (callResult == null || callResult.getRetCode() != 0) {
                    updatePolicyResult.From(callResult);
                    updatePolicyResult.setErrorInfo(StringHelper.Format((String)"\u53d1\u5e03\u670d\u52a1\u5668[%1$s]\u7f51\u7ad9\u6587\u4ef6\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                    this.getPage().PageLog((Object)this, 1, updatePolicyResult.getErrorInfo());
                    this.getPage().Output(updatePolicyResult.ToJSONString());
                    return true;
                }
            }
            ++i;
        }
        updatePolicyResult.setRetCode(0);
        updatePolicyResult.AppendJSCode("alert('\u6210\u529f\u53d1\u9001\u5411\u670d\u52a1\u5668\u53d1\u9001\u53d1\u5e03\u6587\u4ef6\u6307\u4ee4\uff01\u8bf7\u7a0d\u5019\u91cd\u8bd5\u3002');");
        this.getPage().Output(updatePolicyResult.ToJSONString());
        return true;
    }
}

