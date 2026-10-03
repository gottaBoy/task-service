/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DEDCDEFCompareProcess
extends DEDCProcess {
    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        String strDstDataEntity = processConfig.getDEDCProcess().getDSTDATAENTITY();
        BaseDataEntity srcDataEntity = null;
        BaseDataEntity dstDataEntity = null;
        srcDataEntity = dedcContext.GetDataEntity(strSrcDataEntity);
        if (srcDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        dstDataEntity = dedcContext.GetDataEntity(strDstDataEntity);
        if (dstDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strDstDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strDstDataEntity));
        String strSrcDEF = processConfig.getDEDCProcess().getPARAM1();
        String strDstDEF = processConfig.getDEDCProcess().getPARAM2();
        Object objSrcValue = srcDataEntity.GetParamValue(strSrcDEF);
        Object objDstValue = dstDataEntity.GetParamValue(strDstDEF);
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u5bf9\u8c61\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)strSrcDEF, (Object)objSrcValue));
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u76ee\u6807\u5bf9\u8c61\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)strDstDEF, (Object)objDstValue));
        long nRet = 0L;
        if (objSrcValue == null || objDstValue == null) {
            nRet = objSrcValue == null && objDstValue == null ? 0L : (objSrcValue == null ? -1L : 1L);
        } else {
            String strDataType = processConfig.getDEDCProcess().getPARAM3();
            if (StringHelper.IsNullOrEmpty((String)strDataType)) {
                strDataType = "VARCHAR";
            }
            nRet = DataTypeParse.Compare((String)strDataType, (Object)objSrcValue, (Object)objDstValue);
        }
        String strEnvDEF = processConfig.getDEDCProcess().getPARAM11();
        BaseDataEntity envDataEntity = dedcContext.GetDataEntity("%ENV%");
        if (nRet == 0L) {
            envDataEntity.SetParamValue(strEnvDEF, (Object)0);
        } else if (nRet > 0L) {
            envDataEntity.SetParamValue(strEnvDEF, (Object)1);
        } else {
            envDataEntity.SetParamValue(strEnvDEF, (Object)(-1));
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u56de\u5199\u73af\u5883\u53d8\u91cf\u5bf9\u8c61\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)strEnvDEF, (Object)envDataEntity.GetParamValue(strEnvDEF)));
        return callResult;
    }
}

