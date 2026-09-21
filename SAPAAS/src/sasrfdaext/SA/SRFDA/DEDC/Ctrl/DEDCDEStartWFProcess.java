/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;

public class DEDCDEStartWFProcess
extends DEDCProcess {
    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        String strWFWSUrl;
        WFClientAPI wfClientAPI;
        boolean bCommitTran;
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEDataCtrl iDataCtrl = null;
        String strDEID = processConfig.getDEDCProcess().getDEID();
        iDataCtrl = StringHelper.IsNullOrEmpty((String)strDEID) ? dedcContext.GetDataCtrl() : dedcContext.GetGlobalHelper().getDAModelStorage().FindDEDataCtrlEx(strDEID, dedcContext.GetDataCtrl());
        if (iDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEID));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5b9e\u4f53\u5bf9\u8c61[%1$s][%2$s]", (Object)iDataCtrl.GetDEHelper().getId(), (Object)iDataCtrl.GetDEHelper().getName()));
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        BaseDataEntity srcDataEntity = dedcContext.GetDataEntity(strSrcDataEntity);
        if (srcDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u5f53\u524d\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5f53\u524d\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        String strWFModeParam = processConfig.getDEDCProcess().getPARAM1();
        String strWFMode = "";
        if (!StringHelper.IsNullOrEmpty((String)strWFModeParam)) {
            strWFMode = srcDataEntity.GetParamStringValue(strWFModeParam, "");
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u6a21\u5f0f\u5c5e\u6027[%1$s]==>[%2$s]", (Object)strWFModeParam, (Object)strWFMode));
        }
        boolean bASPMode = false;
        if (dedcContext.GetWebContext() != null && dedcContext.GetWebContext() instanceof SRFExWebContext) {
            bASPMode = true;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5de5\u4f5c\u6d41JSP\u8c03\u7528\u6a21\u5f0f[%1$s]", (Object)((bASPMode = processConfig.getDEDCProcess().getPARAM9(bASPMode)) ? "\u662f" : "\u5426")));
        boolean bRefreshData = processConfig.getDEDCProcess().getPARAM10(true);
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u6267\u884c\u6210\u529f\u540e\u67e5\u8be2\u66f4\u65b0\u6570\u636e[%1$s]", (Object)(bRefreshData ? "\u662f" : "\u5426")));
        boolean bl = bCommitTran = processConfig.getDEDCProcess().getPARAM8() == 1;
        if (bCommitTran && iDataCtrl.getTransactionManager() != null) {
            iDataCtrl.getTransactionManager().CommitAndBegin();
        }
        if ((callResult = (wfClientAPI = new WFClientAPI()).Init(strWFWSUrl = dedcContext.GetGlobalHelper().getWebExConfig().GetValue("SRFDA", "WFWSURL", ""), bASPMode)) == null || callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strWFId = iDataCtrl.GetDEHelper().GetDEWFId(strWFMode);
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u7f16\u53f7[%1$s]", (Object)strWFId));
        String strKeyValue = srcDataEntity.GetParamStringValue(iDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), "");
        WFCallResult wfCallResult = wfClientAPI.StartNew(strWFId, dedcContext.GetPersonId(), strKeyValue, "", "", iDataCtrl.GetDEHelper().getId());
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u542f\u52a8\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            return callResult;
        }
        if (bRefreshData) {
            return iDataCtrl.Get(srcDataEntity);
        }
        return callResult;
    }
}

