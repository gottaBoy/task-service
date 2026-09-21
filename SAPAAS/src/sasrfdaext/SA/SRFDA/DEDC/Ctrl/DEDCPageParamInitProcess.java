/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCPageProcess;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DEDCPageParamInitProcess
extends DEDCPageProcess {
    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        if (dedcContext.GetPage() == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5f53\u524d\u4e0a\u4e0b\u6587\u6ca1\u6709\u6307\u5b9a\u9875\u9762\u5bf9\u8c61"));
            dedcContext.Log(1, (Object)dedcContext, callResult.getErrorInfo());
            return callResult;
        }
        if (dedcContext.GetWebContext() == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5f53\u524d\u4e0a\u4e0b\u6587\u6ca1\u6709\u6307\u5b9a\u9875\u9762\u4e0a\u4e0b\u6587\u8bbf\u95ee\u5bf9\u8c61"));
            dedcContext.Log(1, (Object)dedcContext, callResult.getErrorInfo());
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
        DEDCPageParamInitProcess.FillWebContext(dedcContext, "DEPARAM", processConfig, srcDataEntity);
        DEDCPageParamInitProcess.FillPageParam(dedcContext, "PARAM5", processConfig, srcDataEntity);
        return callResult;
    }
}

