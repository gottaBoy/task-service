/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.Data.DEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDCDESelectAndLoopCallProcess
extends DEDCProcess {
    private static final Log log = LogFactory.getLog(DEDCDESelectAndLoopCallProcess.class);

    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        BaseDataEntity srcDataEntity = dedcContext.GetDataEntity(strSrcDataEntity);
        if (srcDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        Vector list = new Vector();
        callResult = dedcContext.GetDataCtrl().Select(srcDataEntity, list);
        if (callResult.IsError()) {
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u67e5\u8be2\u83b7\u53d6\u6570\u636e\u8bb0\u5f55[%1$s]", (Object)list.size()));
        Vector<DEDataCtrl> dedcs = dedcContext.GetDEHelper().GetDEDC("INTERNALCALL", processConfig.getDEDCProcess().getPARAM3());
        if (dedcs == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u64cd\u4f5c\u914d\u7f6e[%1$s]", (Object)processConfig.getDEDCProcess().getPARAM3()));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6267\u884c\u5185\u90e8\u8c03\u7528[%1$s]", (Object)processConfig.getDEDCProcess().getPARAM3()));
        for (DEDataCtrl dedc : dedcs) {
            callResult = dedcContext.InternalCall(dedc, list, processConfig.getDEDCProcess().getPARAM3());
        }
        return callResult;
    }
}

