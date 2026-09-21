/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DEDCDEPrepareProcess
extends DEDCProcess {
    public static final String DEACTION_CREATENEW = "CREATENEW";
    public static final String DEACTION_CREATEFROM = "CREATEFROM";
    public static final String DEACTION_COPY = "COPY";
    public static final String DEACTION_COPYRESET = "COPYRESET";

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
        String strDEAction = processConfig.getDEDCProcess().getDEACTION();
        if (StringHelper.Compare((String)DEACTION_CREATENEW, (String)strDEAction, (boolean)true) == 0) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u65b0\u5efa\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strDstDataEntity));
            dstDataEntity = new BaseDataEntity();
            dedcContext.SetDataEntity(strDstDataEntity, dstDataEntity);
        } else if (StringHelper.Compare((String)DEACTION_CREATEFROM, (String)strDEAction, (boolean)true) == 0) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u65b0\u5efa\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]\uff0c\u5e76\u62f7\u8d1d\u6e90\u6570\u636e\u5bf9\u8c61[%2$s]", (Object)strDstDataEntity, (Object)strSrcDataEntity));
            dstDataEntity = new BaseDataEntity();
            srcDataEntity.CopyTo(dstDataEntity, true);
            dedcContext.SetDataEntity(strDstDataEntity, dstDataEntity);
        } else if (StringHelper.Compare((String)DEACTION_COPY, (String)strDEAction, (boolean)true) == 0) {
            dstDataEntity = dedcContext.GetDataEntity(strDstDataEntity);
            if (dstDataEntity == null) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strDstDataEntity));
                return callResult;
            }
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]\uff0c\u62f7\u8d1d\u6e90\u6570\u636e\u5bf9\u8c61[%2$s]\uff0c\u539f\u6709\u7684\u503c\u4e0d\u91cd\u7f6e", (Object)strDstDataEntity, (Object)strSrcDataEntity));
            srcDataEntity.CopyTo(dstDataEntity, false);
        } else if (StringHelper.Compare((String)DEACTION_COPYRESET, (String)strDEAction, (boolean)true) == 0) {
            dstDataEntity = dedcContext.GetDataEntity(strDstDataEntity);
            if (dstDataEntity == null) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strDstDataEntity));
                return callResult;
            }
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]\uff0c\u62f7\u8d1d\u6e90\u6570\u636e\u5bf9\u8c61[%2$s]\uff0c\u539f\u6709\u7684\u503c\u91cd\u7f6e", (Object)strDstDataEntity, (Object)strSrcDataEntity));
            srcDataEntity.CopyTo(dstDataEntity, true);
        } else {
            dstDataEntity = dedcContext.GetDataEntity(strDstDataEntity);
            if (dstDataEntity == null) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strDstDataEntity));
                return callResult;
            }
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strDstDataEntity));
        }
        callResult = this.FillDataEntity(dedcContext, processConfig, srcDataEntity, dstDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.FillDataEntityEx(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        boolean bConvertToDEFValue = processConfig.getDEDCProcess().getPARAM9();
        boolean bIgnoreConvertError = processConfig.getDEDCProcess().getPARAM10();
        if (bConvertToDEFValue) {
            IDEHelper iDEHelper = dedcContext.GetDEHelper();
            String strDEID = processConfig.getDEDCProcess().getDEID();
            if (!StringHelper.IsNullOrEmpty((String)strDEID) && StringHelper.Compare((String)strDEID, (String)iDEHelper.getId(), (boolean)true) != 0 && (iDEHelper = dedcContext.GetGlobalHelper().getDAModelStorage().FindDEHelper(strDEID)) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEID));
                return callResult;
            }
            for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                Object objValue = dstDataEntity.GetParamValue(iDEFHelper.getName());
                if (objValue == null || !(objValue instanceof String) || StringHelper.IsNullOrEmpty((String)((String)objValue))) continue;
                Object objValue2 = iDEFHelper.GetDEFValue((String)objValue);
                if (objValue2 == null) {
                    dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f6c\u6362\u503c[%2$s]\u5931\u8d25", (Object)iDEFHelper.getName(), (Object)objValue));
                    if (!bIgnoreConvertError) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f6c\u6362\u503c[%2$s]\u5931\u8d25", (Object)iDEFHelper.getName(), (Object)objValue));
                        return callResult;
                    }
                }
                dstDataEntity.SetParamValue(iDEFHelper.getName(), objValue2);
            }
        }
        return callResult;
    }
}

