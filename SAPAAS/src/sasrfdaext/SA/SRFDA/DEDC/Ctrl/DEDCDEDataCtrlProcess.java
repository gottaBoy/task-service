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
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class DEDCDEDataCtrlProcess
extends DEDCProcess {
    public static final String DEDATACTRL_INSERT = "INSERT";
    public static final String DEDATACTRL_UPDATE = "UPDATE";
    public static final String DEDATACTRL_SAVE = "SAVE";
    public static final String DEDATACTRL_DELETE = "DELETE";
    public static final String DEDATACTRL_CHECKKEYSTATE = "CHECKKEYSTATE";
    public static final String DEDATACTRL_GET = "GET";
    public static final String DEDATACTRL_CUSTOMCALL = "CUSTOMCALL";
    public static final String DEDATACTRL_CUSTOMPROCCALL = "CUSTOMPROCCALL";
    public static final String DEDATACTRL_CUSTOMRAWPROCCALL = "CUSTOMRAWPROCCALL";

    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEDataCtrl iDataCtrl = null;
        String strDEID = processConfig.getDEDCProcess().getDEID();
        try {
            iDataCtrl = StringHelper.IsNullOrEmpty((String)strDEID) ? dedcContext.GetDataCtrl() : dedcContext.GetDataCtrl().GetRelatedDataCtrl(strDEID);
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
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
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        String strAction = processConfig.getDEDCProcess().getPARAM1();
        String strActionMode = processConfig.getDEDCProcess().getPARAM3();
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5904\u7406[%1$s][%2$s]", (Object)strAction, (Object)strActionMode));
        int nCheckKey = processConfig.getDEDCProcess().GetParamIntValue("PARAM9", 1);
        int nRetData = processConfig.getDEDCProcess().GetParamIntValue("PARAM10", 1);
        int nDALog = processConfig.getDEDCProcess().GetParamIntValue("PARAM8", 1);
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u68c0\u67e5\u4e3b\u952e[%1$s]", (Object)(nCheckKey == 1 ? "\u662f" : "\u5426")));
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8fd4\u56de\u6570\u636e[%1$s]", (Object)(nRetData == 1 ? "\u662f" : "\u5426")));
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"DALOG[%1$s]", (Object)(nDALog == 1 ? "\u662f" : "\u5426")));
        srcDataEntity.SetParamValue("SRF_CHECKKEY", (Object)nCheckKey);
        srcDataEntity.SetParamValue("SRF_RETDATA", (Object)nRetData);
        srcDataEntity.SetParamValue("SRF_DALOG", (Object)nDALog);
        if (StringHelper.Compare((String)strAction, (String)DEDATACTRL_INSERT, (boolean)true) == 0) {
            Vector errors = new Vector();
            callResult = iDataCtrl.TestSave(true, srcDataEntity, errors);
            if (callResult.IsError()) {
                return callResult;
            }
            if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
                return iDataCtrl.Save(true, srcDataEntity);
            }
            return iDataCtrl.Save(true, strActionMode, srcDataEntity);
        }
        if (StringHelper.Compare((String)strAction, (String)DEDATACTRL_UPDATE, (boolean)true) == 0) {
            Vector errors = new Vector();
            callResult = iDataCtrl.TestSave(false, srcDataEntity, errors);
            if (callResult.IsError()) {
                return callResult;
            }
            if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
                return iDataCtrl.Save(false, srcDataEntity);
            }
            return iDataCtrl.Save(false, strActionMode, srcDataEntity);
        }
        if (StringHelper.Compare((String)strAction, (String)DEDATACTRL_SAVE, (boolean)true) == 0) {
            Vector errors;
            String strKeyField = iDataCtrl.GetDEHelper().GetKeyDEFHelper().getName();
            String strKeyValue = srcDataEntity.GetParamStringValue(strKeyField, "");
            boolean bInsert = StringHelper.IsNullOrEmpty((String)strKeyValue);
            if (!bInsert) {
                BaseDataEntity checkkeyparam = new BaseDataEntity();
                srcDataEntity.CopyTo(checkkeyparam, strKeyField, true);
                callResult = iDataCtrl.CheckKeyState(checkkeyparam);
                if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
                    callResult.setRetCode(1);
                    return callResult;
                }
                int nState = (Integer)callResult.getUserObject();
                if (nState == 0) {
                    bInsert = true;
                } else if (nState == 1) {
                    bInsert = false;
                } else {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u8981\u4fdd\u5b58\u7684\u6570\u636e[%1$s]\u5df2\u7ecf\u88ab\u5220\u9664", (Object)strKeyValue));
                    return callResult;
                }
            }
            if ((callResult = iDataCtrl.TestSave(bInsert, strActionMode, srcDataEntity, errors = new Vector())).IsError()) {
                return callResult;
            }
            srcDataEntity.SetParamValue("SRF_CHECKKEY", (Object)0);
            if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
                return iDataCtrl.Save(bInsert, srcDataEntity);
            }
            return iDataCtrl.Save(bInsert, strActionMode, srcDataEntity);
        }
        if (StringHelper.Compare((String)strAction, (String)DEDATACTRL_DELETE, (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
                return iDataCtrl.Remove(srcDataEntity);
            }
            return iDataCtrl.Remove(strActionMode, srcDataEntity);
        }
        if (StringHelper.Compare((String)strAction, (String)DEDATACTRL_CHECKKEYSTATE, (boolean)true) == 0) {
            callResult = iDataCtrl.CheckKeyState(srcDataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
            return callResult;
        }
        if (StringHelper.Compare((String)strAction, (String)DEDATACTRL_GET, (boolean)true) == 0) {
            callResult = iDataCtrl.Get(srcDataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
            return callResult;
        }
        if (StringHelper.Compare((String)strAction, (String)DEDATACTRL_CUSTOMCALL, (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u81ea\u5b9a\u4e49\u64cd\u4f5c"));
                return callResult;
            }
            return iDataCtrl.CustomCall(strActionMode, srcDataEntity);
        }
        if (StringHelper.Compare((String)strAction, (String)DEDATACTRL_CUSTOMPROCCALL, (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8981\u8c03\u7528\u7684\u5b58\u50a8\u8fc7\u7a0b"));
                return callResult;
            }
            return iDataCtrl.CustomProcCall(strActionMode, srcDataEntity);
        }
        if (StringHelper.Compare((String)strAction, (String)DEDATACTRL_CUSTOMRAWPROCCALL, (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8981\u8c03\u7528\u7684\u5b58\u50a8\u8fc7\u7a0b"));
                return callResult;
            }
            return iDataCtrl.CustomRawProcCall(strActionMode, srcDataEntity);
        }
        callResult.setRetCode(1);
        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5904\u7406[%1$s]", (Object)strAction));
        return callResult;
    }
}

