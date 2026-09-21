/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import java.util.Enumeration;
import java.util.Hashtable;

public class DEDCDEParamOutputProcess
extends DEDCProcess {
    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        if (!dedcContext.isDebugOutput()) {
            return callResult;
        }
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        String strDstDataEntity = processConfig.getDEDCProcess().getDSTDATAENTITY();
        if (!StringHelper.IsNullOrEmpty((String)strSrcDataEntity)) {
            BaseDataEntity srcDataEntity = null;
            srcDataEntity = dedcContext.GetDataEntity(strSrcDataEntity);
            if (srcDataEntity == null) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u5bf9\u8c611[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
                return callResult;
            }
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6570\u636e\u5bf9\u8c611[%1$s]\u5c5e\u6027\u4fe1\u606f:", (Object)strSrcDataEntity));
            this.OutputParam(dedcContext, srcDataEntity, processConfig.getDEDCProcess().getPARAM4());
        }
        if (!StringHelper.IsNullOrEmpty((String)strDstDataEntity)) {
            BaseDataEntity dstDataEntity = null;
            dstDataEntity = dedcContext.GetDataEntity(strDstDataEntity);
            if (dstDataEntity == null) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u5bf9\u8c612[%1$s]\u65e0\u6548", (Object)strDstDataEntity));
                return callResult;
            }
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\r\n\u6570\u636e\u5bf9\u8c612[%1$s]\u5c5e\u6027\u4fe1\u606f:", (Object)strDstDataEntity));
            this.OutputParam(dedcContext, dstDataEntity, processConfig.getDEDCProcess().getPARAM5());
        }
        return callResult;
    }

    private void OutputParam(IDEDataCtrlEngineContext dedcContext, BaseDataEntity dataEntity, String strParams) {
        BaseDataEntity outputDataEntity = null;
        if (StringHelper.IsNullOrEmpty((String)strParams)) {
            outputDataEntity = dataEntity;
        } else {
            outputDataEntity = new BaseDataEntity();
            dataEntity.CopyTo(outputDataEntity, strParams, false);
        }
        Hashtable paramList = outputDataEntity.getTotalParamList();
        if (paramList == null) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"<<\u6ca1\u6709\u5305\u62ec\u4efb\u4f55\u53d8\u91cf>>"));
            return;
        }
        Enumeration en = paramList.keys();
        while (en.hasMoreElements()) {
            Object objKey = en.nextElement();
            Object objValue = outputDataEntity.GetParamValue((String)objKey);
            if (objValue == null) {
                dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u503c\u4e3a\u7a7a", objKey));
                continue;
            }
            if (DateParser.isDateTimeType((Object)objValue)) {
                dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]==>[%3$tY-%3$tm-%3$td %3$tH:%3$tM:%3$tS]", objKey, (Object)objValue, (Object)objValue));
                continue;
            }
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", objKey, (Object)objValue));
        }
    }
}

