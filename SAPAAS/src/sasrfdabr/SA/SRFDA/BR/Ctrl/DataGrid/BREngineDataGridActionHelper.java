/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 */
package SA.SRFDA.BR.Ctrl.DataGrid;

import SA.SRFDA.BR.Client.BRClientAPI;
import SA.SRFDA.BR.Ctrl.Data.BREngine;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;

public class BREngineDataGridActionHelper
extends BaseDADataGridActionHelper {
    public static final String ACTION_RESETBRENGINE = "RESETBRENGINE";

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_RESETBRENGINE, (boolean)true) == 0) {
            return this.OnResetBREngine();
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnResetBREngine() {
        SRFExDGAjaxActionResult resetBRInstResult = new SRFExDGAjaxActionResult();
        resetBRInstResult.setReload(true);
        BRClientAPI brClientAPI = new BRClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFBR", "BRWSURL", "");
        CallResult callResult = brClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u89c4\u683c\u5f15\u64ceWS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            resetBRInstResult.setRetCode(1);
            resetBRInstResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u89c4\u683c\u5f15\u64ceWS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            this.getPage().Output(resetBRInstResult.ToJSONString());
            return true;
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        int i = 0;
        while (i < keys.length) {
            String strKeyValue = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                BREngine brEngine = new BREngine();
                brEngine.setBRENGINEID(strKeyValue);
                callResult = this.getDEDataCtrl().Get((BaseDataEntity)brEngine);
                if (callResult.getRetCode() != 0) {
                    resetBRInstResult.From(callResult);
                    resetBRInstResult.setErrorInfo(StringHelper.Format((String)"\u91cd\u7f6e\u89c4\u5219\u5f15\u64ce\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    this.getPage().Output(resetBRInstResult.ToJSONString());
                    return true;
                }
                callResult = brClientAPI.Manage(brEngine.getBRENGINEID(), ACTION_RESETBRENGINE, brEngine, this.getWebContext().getCurUserId());
                if (callResult.IsError()) {
                    resetBRInstResult.From(callResult);
                    resetBRInstResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u91cd\u7f6e\u89c4\u5219\u5f15\u64ce\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo(), (Object)brEngine.getBRENGINENAME()));
                    this.getPage().PageLog((Object)this, 1, resetBRInstResult.getErrorInfo());
                    this.getPage().Output(resetBRInstResult.ToJSONString());
                    return true;
                }
            }
            ++i;
        }
        resetBRInstResult.setRetCode(0);
        resetBRInstResult.AppendJSCode("alert('\u91cd\u7f6e\u89c4\u5219\u5f15\u64ce\u6210\u529f\uff01');");
        this.getPage().Output(resetBRInstResult.ToJSONString());
        return true;
    }
}

