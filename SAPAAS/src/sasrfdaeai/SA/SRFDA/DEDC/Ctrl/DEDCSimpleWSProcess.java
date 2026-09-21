/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.DEDC.Ctrl.DEDCProcess
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFDA.EAI.Api.SimpleWSStub;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DEDCSimpleWSProcess
extends DEDCProcess {
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        BaseDataEntity serviceMap = dedcContext.GetDataEntity(strSrcDataEntity);
        if (serviceMap == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        String strWSPath = dedcContext.GetGlobalHelper().getRegisterMgr().GetRegistryParam(processConfig.getDEDCProcess().getPARAM1(), "");
        if (StringHelper.IsNullOrEmpty((String)strWSPath)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ce8\u518c\u8868[%1$s]\u6ca1\u6709\u6307\u5b9a\u6709\u6548WS\u8def\u5f84", (Object)processConfig.getDEDCProcess().getPARAM1()));
            return callResult;
        }
        try {
            SimpleWSStub simpleWS = new SimpleWSStub(strWSPath);
            String strCallParam = BaseDataEntity.ToString((BaseDataEntity)serviceMap);
            SimpleWSStub.Call call = new SimpleWSStub.Call();
            call.setIn0(strCallParam);
            SimpleWSStub.CallResponse ret = simpleWS.Call(call);
            String strRet = ret.getCallReturn();
            BaseDataEntity retDataEntity = BaseDataEntity.FromString((String)strRet);
            if (retDataEntity == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"SimpleWS\u8fd4\u56de\u7ed3\u679c\u65e0\u6cd5\u8f6c\u6362\u4e3aBaseDataEntity", (Object)strRet));
                dedcContext.Log(1, (Object)this, StringHelper.Format((String)"SimpleWS\u8fd4\u56de\u7ed3\u679c[%1$s]\u65e0\u6cd5\u8f6c\u6362\u4e3aBaseDataEntity", (Object)strRet));
                return callResult;
            }
            retDataEntity.CopyTo(serviceMap, true);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u8c03\u7528SimpleWS\u51fa\u73b0\u5f02\u5e38,%1$s", (Object)ex.getMessage()));
            ex.printStackTrace();
            return callResult;
        }
        return callResult;
    }
}

