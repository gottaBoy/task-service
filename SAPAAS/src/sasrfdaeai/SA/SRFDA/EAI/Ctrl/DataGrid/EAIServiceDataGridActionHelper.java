/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 */
package SA.SRFDA.EAI.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.EAI.Api.EAIClientAPI;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;

public class EAIServiceDataGridActionHelper
extends BaseDADataGridActionHelper {
    public static final String ACTION_STARTSERVICE = "STARTSERVICE";
    public static final String ACTION_STOPSERVICE = "STOPSERVICE";

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_STARTSERVICE, (boolean)true) == 0) {
            return this.OnStartService();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_STOPSERVICE, (boolean)true) == 0) {
            return this.OnStopService();
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnStopService() {
        SRFExDGAjaxActionResult startServiceResult = new SRFExDGAjaxActionResult();
        startServiceResult.setReload(true);
        EAIClientAPI eaiClientAPI = new EAIClientAPI();
        String strEAIWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "EAIWSURL", "");
        CallResult callResult = eaiClientAPI.Init(strEAIWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u96c6\u6210WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            startServiceResult.setRetCode(1);
            startServiceResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u96c6\u6210WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            this.getPage().Output(startServiceResult.ToJSONString());
            return true;
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        int i = 0;
        while (i < keys.length) {
            String strKeyValue = keys[i];
            if (!(StringHelper.IsNullOrEmpty((String)strKeyValue) || (callResult = eaiClientAPI.StopService(strKeyValue, this.getWebContext().getCurUserId())) != null && callResult.getRetCode() == 0)) {
                startServiceResult.From(callResult);
                startServiceResult.setErrorInfo(StringHelper.Format((String)"\u505c\u6b62\u96c6\u6210\u670d\u52a1[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                this.getPage().PageLog((Object)this, 1, startServiceResult.getErrorInfo());
                this.getPage().Output(startServiceResult.ToJSONString());
                return true;
            }
            ++i;
        }
        startServiceResult.setRetCode(0);
        startServiceResult.AppendJSCode("alert('\u6210\u529f\u53d1\u9001\u505c\u6b62\u96c6\u6210\u670d\u52a1\u6307\u4ee4\uff01\u670d\u52a1\u505c\u6b62\u53ef\u80fd\u9700\u8981\u51e0\u5206\u949f\u65f6\u95f4\u3002');");
        this.getPage().Output(startServiceResult.ToJSONString());
        return true;
    }

    protected boolean OnStartService() {
        SRFExDGAjaxActionResult startServiceResult = new SRFExDGAjaxActionResult();
        startServiceResult.setReload(true);
        EAIClientAPI eaiClientAPI = new EAIClientAPI();
        String strEAIWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "EAIWSURL", "");
        CallResult callResult = eaiClientAPI.Init(strEAIWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u96c6\u6210WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            startServiceResult.setRetCode(1);
            startServiceResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u96c6\u6210WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            this.getPage().Output(startServiceResult.ToJSONString());
            return true;
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        int i = 0;
        while (i < keys.length) {
            String strKeyValue = keys[i];
            if (!(StringHelper.IsNullOrEmpty((String)strKeyValue) || (callResult = eaiClientAPI.StartService(strKeyValue, this.getWebContext().getCurUserId())) != null && callResult.getRetCode() == 0)) {
                startServiceResult.From(callResult);
                startServiceResult.setErrorInfo(StringHelper.Format((String)"\u542f\u52a8\u96c6\u6210\u670d\u52a1[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                this.getPage().PageLog((Object)this, 1, startServiceResult.getErrorInfo());
                this.getPage().Output(startServiceResult.ToJSONString());
                return true;
            }
            ++i;
        }
        startServiceResult.setRetCode(0);
        startServiceResult.AppendJSCode("alert('\u6210\u529f\u53d1\u9001\u542f\u52a8\u96c6\u6210\u670d\u52a1\u6307\u4ee4\uff01\u670d\u52a1\u542f\u52a8\u53ef\u80fd\u9700\u8981\u51e0\u5206\u949f\u65f6\u95f4\u3002');");
        this.getPage().Output(startServiceResult.ToJSONString());
        return true;
    }
}

