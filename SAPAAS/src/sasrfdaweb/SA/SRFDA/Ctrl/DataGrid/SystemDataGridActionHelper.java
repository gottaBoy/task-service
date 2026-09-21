/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DASystem
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.Data.DASystem;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;

public class SystemDataGridActionHelper
extends BaseDADataGridActionHelper {
    @Override
    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"GOTOSYSTEM", (boolean)true) == 0) {
            this.OnGotoSystem();
            return true;
        }
        return super.OnCustomAction(strAction);
    }

    protected void OnGotoSystem() {
        SRFExDGAjaxActionResult customActionResult = new SRFExDGAjaxActionResult();
        customActionResult.setReload(false);
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        if (StringHelper.IsNullOrEmpty((String)strKeys)) {
            customActionResult.setRetCode(5);
            customActionResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf");
            this.getPage().Output(customActionResult.ToJSONString());
            return;
        }
        DASystem daSystem = new DASystem();
        daSystem.setSYSTEMID(strKeys);
        CallResult callResult = this.getDEDataCtrl().Get((BaseDataEntity)daSystem);
        if (callResult.getRetCode() != 0) {
            customActionResult.From(callResult);
            this.getPage().Output(customActionResult.ToJSONString());
            return;
        }
        StringBuilderEx script = new StringBuilderEx();
        String strAddr = daSystem.getSYSTEMADDR();
        if (StringHelper.IsNullOrEmpty((String)strAddr)) {
            script.Append("alert('\u7cfb\u7edf\u6ca1\u6709\u6307\u5b9a\u8def\u5f84\uff0c\u8bf7\u786e\u8ba4!');");
        } else {
            script.Append("top.location.href='%1$s';", (Object)strAddr);
        }
        this.getWebContext().Logout();
        customActionResult.setRetCode(0);
        customActionResult.setJSCode(script.toString());
        this.getPage().Output(customActionResult.ToJSONString());
    }
}

