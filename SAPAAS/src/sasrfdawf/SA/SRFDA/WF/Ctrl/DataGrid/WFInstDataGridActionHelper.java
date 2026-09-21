/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Ctrl.Data.WFInstance
 */
package SA.SRFDA.WF.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import SRFWF.Ctrl.Data.WFInstance;
import java.util.TreeMap;

public class WFInstDataGridActionHelper
extends BaseDADataGridActionHelper {
    public static final String ACTION_CANCELWF = "cancelwf";
    public static final String ACTION_RESTARTWF = "restartwf";
    protected String strDataLockKey = "";

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_CANCELWF, (boolean)true) == 0) {
            this.OnCancelWorkflow();
            return true;
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_RESTARTWF, (boolean)true) == 0) {
            this.OnRestartWorkflow();
            return true;
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnCancelWorkflow() {
        SRFExDGAjaxActionResult cancelActionResult = new SRFExDGAjaxActionResult();
        cancelActionResult.setReload(true);
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            cancelActionResult.setRetCode(1);
            cancelActionResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            this.getPage().Output(cancelActionResult.ToJSONString());
            return true;
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        TreeMap<String, IDEHelper> deHelperMap = new TreeMap<String, IDEHelper>();
        int i = 0;
        while (i < keys.length) {
            String strKeyValue = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                WFInstance wfInstance = new WFInstance();
                wfInstance.setWFINSTANCEID(strKeyValue);
                callResult = this.getDEDataCtrl().Get((BaseDataEntity)wfInstance);
                if (callResult.getRetCode() != 0) {
                    cancelActionResult.From(callResult);
                    cancelActionResult.setErrorInfo(StringHelper.Format((String)"\u53d6\u6d88\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    this.getPage().Output(cancelActionResult.ToJSONString());
                    return true;
                }
                String strMajorText = wfInstance.getWFINSTANCENAME();
                String strWFId = wfInstance.getWFWORKFLOWID();
                IDEHelper iDEHelper = null;
                if (deHelperMap.containsKey(wfInstance.getUSERDATA4())) {
                    iDEHelper = (IDEHelper)deHelperMap.get(wfInstance.getUSERDATA4());
                } else {
                    iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(wfInstance.getUSERDATA4());
                    if (iDEHelper == null) {
                        cancelActionResult.setRetCode(1);
                        cancelActionResult.setErrorInfo(StringHelper.Format((String)"\u53d6\u6d88\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)wfInstance.getUSERDATA4()));
                        this.getPage().Output(cancelActionResult.ToJSONString());
                        return true;
                    }
                    deHelperMap.put(wfInstance.getUSERDATA4(), iDEHelper);
                }
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), iDEHelper.GetKeyDEFHelper().GetDEFValue(wfInstance.getUSERDATA()));
                callResult = this.OnTestDataAction(iDEHelper, dataEntity, "WFCANCEL");
                if (callResult.getRetCode() != 0) {
                    cancelActionResult.From(callResult);
                    cancelActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u53d6\u6d88\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo(), (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, cancelActionResult.getErrorInfo());
                    this.getPage().Output(cancelActionResult.ToJSONString());
                    return true;
                }
                WFCallResult wfCallResult = wfClientAPI.UserClose(strWFId, this.getWebContext().getCurUserId(), wfInstance.getUSERDATA(), "", "", iDEHelper.getId(), "");
                if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                    cancelActionResult.From((CallResult)wfCallResult);
                    cancelActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u53d6\u6d88\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo(), (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, cancelActionResult.getErrorInfo());
                    this.getPage().Output(cancelActionResult.ToJSONString());
                    return true;
                }
            }
            ++i;
        }
        cancelActionResult.setRetCode(0);
        cancelActionResult.AppendJSCode("alert('\u53d6\u6d88\u6570\u636e\u5de5\u4f5c\u6d41\u6210\u529f\uff01');");
        this.getPage().Output(cancelActionResult.ToJSONString());
        return true;
    }

    protected boolean OnRestartWorkflow() {
        SRFExDGAjaxActionResult restartActionResult = new SRFExDGAjaxActionResult();
        restartActionResult.setReload(true);
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            restartActionResult.setRetCode(1);
            restartActionResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            this.getPage().Output(restartActionResult.ToJSONString());
            return true;
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        TreeMap<String, IDEHelper> deHelperMap = new TreeMap<String, IDEHelper>();
        int i = 0;
        while (i < keys.length) {
            String strKeyValue = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                WFInstance wfInstance = new WFInstance();
                wfInstance.setWFINSTANCEID(strKeyValue);
                callResult = this.getDEDataCtrl().Get((BaseDataEntity)wfInstance);
                if (callResult.getRetCode() != 0) {
                    restartActionResult.From(callResult);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"\u91cd\u542f\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
                String strMajorText = wfInstance.getWFINSTANCENAME();
                String strWFId = wfInstance.getWFWORKFLOWID();
                IDEHelper iDEHelper = null;
                if (deHelperMap.containsKey(wfInstance.getUSERDATA4())) {
                    iDEHelper = (IDEHelper)deHelperMap.get(wfInstance.getUSERDATA4());
                } else {
                    iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(wfInstance.getUSERDATA4());
                    if (iDEHelper == null) {
                        restartActionResult.setRetCode(1);
                        restartActionResult.setErrorInfo(StringHelper.Format((String)"\u91cd\u542f\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)wfInstance.getUSERDATA4()));
                        this.getPage().Output(restartActionResult.ToJSONString());
                        return true;
                    }
                    deHelperMap.put(wfInstance.getUSERDATA4(), iDEHelper);
                }
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), iDEHelper.GetKeyDEFHelper().GetDEFValue(wfInstance.getUSERDATA()));
                callResult = this.OnTestDataAction(iDEHelper, dataEntity, "WFRESTART");
                if (callResult.getRetCode() != 0) {
                    restartActionResult.From(callResult);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u91cd\u542f\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo(), (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, restartActionResult.getErrorInfo());
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
                WFCallResult wfCallResult = wfClientAPI.Restart(strWFId, this.getWebContext().getCurUserId(), wfInstance.getUSERDATA(), "", "", iDEHelper.getId());
                if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                    restartActionResult.From((CallResult)wfCallResult);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u91cd\u542f\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo(), (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, restartActionResult.getErrorInfo());
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
            }
            ++i;
        }
        restartActionResult.setRetCode(0);
        restartActionResult.AppendJSCode("alert('\u91cd\u542f\u6570\u636e\u5de5\u4f5c\u6d41\u6210\u529f\uff01');");
        this.getPage().Output(restartActionResult.ToJSONString());
        return true;
    }
}

