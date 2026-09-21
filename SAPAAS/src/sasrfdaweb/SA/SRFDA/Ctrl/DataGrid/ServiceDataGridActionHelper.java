/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ServiceMgr
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.ServiceMgr;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;

public class ServiceDataGridActionHelper
extends BaseDADataGridActionHelper {
    public static final String ACTION_STARTSERVICE = "STARTSERVICE";
    public static final String ACTION_STOPSERVICE = "STOPSERVICE";

    @Override
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
        SRFExDGAjaxActionResult stopServiceResult = new SRFExDGAjaxActionResult();
        stopServiceResult.setReload(true);
        ServiceMgr serviceMgr = this.getWebContext().getGlobalHelper().getServiceMgr();
        if (serviceMgr == null) {
            stopServiceResult.setRetCode(1);
            stopServiceResult.setErrorInfo(StringHelper.Format((String)"\u7cfb\u7edf\u6ca1\u6709\u52a0\u8f7d\u670d\u52a1\u7ba1\u7406\u5668\uff0c\u65e0\u6cd5\u6267\u884c\u76f8\u5e94\u64cd\u4f5c\u3002"));
            this.getPage().Output(stopServiceResult.ToJSONString());
            return true;
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        int i = 0;
        while (i < keys.length) {
            CallResult callResult;
            String strKeyValue = keys[i];
            if (!(StringHelper.IsNullOrEmpty((String)strKeyValue) || (callResult = serviceMgr.StopService(strKeyValue)) != null && callResult.getRetCode() == 0)) {
                stopServiceResult.From(callResult);
                stopServiceResult.setErrorInfo(StringHelper.Format((String)"\u505c\u6b62\u670d\u52a1[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                this.getPage().PageLog((Object)this, 1, stopServiceResult.getErrorInfo());
                this.getPage().Output(stopServiceResult.ToJSONString());
                return true;
            }
            ++i;
        }
        stopServiceResult.setRetCode(0);
        stopServiceResult.AppendJSCode("alert('\u670d\u52a1\u5df2\u7ecf\u505c\u6b62\u3002');");
        this.getPage().Output(stopServiceResult.ToJSONString());
        return true;
    }

    protected boolean OnStartService() {
        SRFExDGAjaxActionResult startServiceResult = new SRFExDGAjaxActionResult();
        startServiceResult.setReload(true);
        ServiceMgr serviceMgr = this.getWebContext().getGlobalHelper().getServiceMgr();
        if (serviceMgr == null) {
            startServiceResult.setRetCode(1);
            startServiceResult.setErrorInfo(StringHelper.Format((String)"\u7cfb\u7edf\u6ca1\u6709\u52a0\u8f7d\u670d\u52a1\u7ba1\u7406\u5668\uff0c\u65e0\u6cd5\u6267\u884c\u76f8\u5e94\u64cd\u4f5c\u3002"));
            this.getPage().Output(startServiceResult.ToJSONString());
            return true;
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        int i = 0;
        while (i < keys.length) {
            CallResult callResult;
            String strKeyValue = keys[i];
            if (!(StringHelper.IsNullOrEmpty((String)strKeyValue) || (callResult = serviceMgr.StartService(strKeyValue)) != null && callResult.getRetCode() == 0)) {
                startServiceResult.From(callResult);
                startServiceResult.setErrorInfo(StringHelper.Format((String)"\u542f\u52a8\u670d\u52a1[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                this.getPage().PageLog((Object)this, 1, startServiceResult.getErrorInfo());
                this.getPage().Output(startServiceResult.ToJSONString());
                return true;
            }
            ++i;
        }
        startServiceResult.setRetCode(0);
        startServiceResult.AppendJSCode("alert('\u670d\u52a1\u5df2\u7ecf\u542f\u52a8\u3002');");
        this.getPage().Output(startServiceResult.ToJSONString());
        return true;
    }
}

