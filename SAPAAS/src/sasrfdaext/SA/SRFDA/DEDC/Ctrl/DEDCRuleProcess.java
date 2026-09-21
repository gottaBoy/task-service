/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.Conditions
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.DEDC.Ctrl.DEDCGrooveEngine;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleBaseLogicConfig;
import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleConfig;
import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleLogicGroupConfig;
import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleLogicItemConfig;
import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleProcessConfig;
import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleUserLogicItemConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.Conditions;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

public class DEDCRuleProcess
extends DEDCProcess {
    private static String TAG_CONFIGID = "{435CD415-CA19-4CD2-B1BC-D3D69A27B7FD}";

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
        dstDataEntity = dedcContext.GetDataEntity(strDstDataEntity);
        if (dstDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strDstDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u76ee\u6807\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strDstDataEntity));
        String strParamId = processConfig.getDEDCProcess().getPARAMID();
        String strDataType = processConfig.getDEDCProcess().getPARAM1();
        String strDefaultValue = processConfig.getDEDCProcess().getPARAM2();
        String strRuleXML = processConfig.getDEDCProcess().getPARAM6();
        DEDCRuleProcessConfig ruleProcessConfig = null;
        Object objValue = processConfig.getDEDCProcess().GetParamValue(TAG_CONFIGID);
        if (objValue == null) {
            ruleProcessConfig = new DEDCRuleProcessConfig();
            XMLConfig.LoadFromXML((String)strRuleXML, (XMLConfig)ruleProcessConfig);
            processConfig.getDEDCProcess().SetParamValue(TAG_CONFIGID, (Object)ruleProcessConfig);
        } else {
            ruleProcessConfig = (DEDCRuleProcessConfig)((Object)objValue);
        }
        IDEHelper iDEHelper = dedcContext.GetDEHelper();
        if (!StringHelper.IsNullOrEmpty((String)processConfig.getDEDCProcess().getDEID()) && StringHelper.Compare((String)iDEHelper.getId(), (String)processConfig.getDEDCProcess().getDEID(), (boolean)true) != 0 && (iDEHelper = dedcContext.GetGlobalHelper().getDAModelStorage().FindDEHelper(processConfig.getDEDCProcess().getDEID())) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)processConfig.getDEDCProcess().getDEID()));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5b9e\u4f53\u5bf9\u8c61[%1$s][%2$s]", (Object)iDEHelper.getId(), (Object)iDEHelper.getName()));
        boolean bDefault = true;
        Iterator iterator = ruleProcessConfig.iterator();
        while (iterator.hasNext()) {
            DEDCRuleConfig ruleConfig = (DEDCRuleConfig)((Object)iterator.next());
            callResult = this.TestLogicGroup(dedcContext, ruleConfig, srcDataEntity, iDEHelper);
            if (callResult.IsError()) {
                return callResult;
            }
            if (!((Boolean)callResult.getUserObject()).booleanValue()) continue;
            strDefaultValue = ruleConfig.getRuleValue();
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u89c4\u5219[%1$s]\u7b26\u5408\u8981\u6c42\uff0c\u7ed3\u679c\u503c[%2$s]", (Object)ruleConfig.getLogicName(), (Object)strDefaultValue));
            bDefault = false;
            break;
        }
        if (bDefault) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6ca1\u6709\u89c4\u5219\u7b26\u5408\u8981\u6c42\uff0c\u4f7f\u7528\u9ed8\u8ba4\u503c[%1$s]", (Object)strDefaultValue));
        }
        if ((callResult = MacroHelper.GetValue((String)strDefaultValue, (ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (String)dedcContext.GetPersonId(), (BaseDataEntity)srcDataEntity)).IsError()) {
            return callResult;
        }
        Object objDest = callResult.getUserObject();
        if (objDest != null && objDest instanceof String) {
            if (StringHelper.IsNullOrEmpty((String)strDataType)) {
                IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(strParamId);
                if (iDEFHelper != null) {
                    objDest = iDEFHelper.GetDEFValue((String)objDest);
                }
            } else {
                objDest = DataTypeParse.Parse((String)strDataType, (String)((String)objDest));
            }
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8bbe\u7f6e\u76ee\u6807\u6570\u636e\u5bf9\u8c61\u5c5e\u6027[%1$s]\u503c[%2$s]", (Object)strParamId, (Object)objDest));
        dstDataEntity.SetParamValue(strParamId, objDest);
        return callResult;
    }

    public CallResult TestLogicGroup(IDEDataCtrlEngineContext dedcContext, DEDCRuleLogicGroupConfig logicGroupConfig, BaseDataEntity srcDataEntity, IDEHelper iDEHelper) {
        CallResult callResult = new CallResult();
        boolean bRet = false;
        if (logicGroupConfig.getChildLogics().size() != 0) {
            boolean bAnd = StringHelper.Compare((String)logicGroupConfig.getLogic(), (String)"AND", (boolean)true) == 0;
            for (DEDCRuleBaseLogicConfig logicConfig : logicGroupConfig.getChildLogics()) {
                if (logicConfig instanceof DEDCRuleLogicGroupConfig) {
                    callResult = this.TestLogicGroup(dedcContext, (DEDCRuleLogicGroupConfig)logicConfig, srcDataEntity, iDEHelper);
                } else if (logicConfig instanceof DEDCRuleLogicItemConfig) {
                    callResult = this.TestLogicItem(dedcContext, (DEDCRuleLogicItemConfig)logicConfig, srcDataEntity, iDEHelper);
                } else if (logicConfig instanceof DEDCRuleUserLogicItemConfig) {
                    callResult = this.TestUserLogicItem(dedcContext, (DEDCRuleUserLogicItemConfig)logicConfig, srcDataEntity);
                }
                if (callResult.IsError()) {
                    return callResult;
                }
                bRet = (Boolean)callResult.getUserObject();
                if (bAnd && !bRet || !bAnd && bRet) break;
            }
        }
        if (logicGroupConfig.isNot()) {
            bRet = !bRet;
        }
        callResult.setUserObject((Object)bRet);
        return callResult;
    }

    public CallResult TestLogicItem(IDEDataCtrlEngineContext dedcContext, DEDCRuleLogicItemConfig logicItemConfig, BaseDataEntity srcDataEntity, IDEHelper iDEHelper) {
        IDEFHelper iDEFHelper;
        CallResult callResult = new CallResult();
        boolean bRet = false;
        String strParam = logicItemConfig.getParam();
        Object objValue = srcDataEntity.GetParamValue(strParam);
        if (objValue instanceof String && (iDEFHelper = iDEHelper.GetDEFHelper(strParam)) != null) {
            objValue = iDEFHelper.GetDEFValue((String)objValue);
        }
        String strDebugInfo = "";
        if (dedcContext.isDebugOutput()) {
            strDebugInfo = String.valueOf(strDebugInfo) + StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)strParam, (Object)objValue);
            strDebugInfo = String.valueOf(strDebugInfo) + StringHelper.Format((String)" [%1$s] ", (Object)logicItemConfig.getLogic());
        }
        int nCondition = Conditions.FromString((String)logicItemConfig.getLogic());
        block0 : switch (nCondition) {
            case 8: {
                bRet = objValue != null;
                break;
            }
            case 7: {
                bRet = objValue == null;
                break;
            }
            default: {
                String strArg = logicItemConfig.getArg();
                if (StringHelper.IsNullOrEmpty((String)strArg)) break;
                callResult = MacroHelper.GetValue((String)strArg, (ISRFDAWebContext)dedcContext.GetWebContext(), (ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (String)dedcContext.GetPersonId(), (BaseDataEntity)srcDataEntity);
                if (callResult.IsError()) {
                    dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8ba1\u7b97\u5b8f\u53d8\u91cf[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strArg, (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                int nDataType = DataTypeHelper.GetObjectDataType((Object)objValue);
                Object objDest = callResult.getUserObject();
                if (objDest instanceof String) {
                    objDest = DataTypeParse.Parse((int)nDataType, (String)((String)objDest));
                }
                if (dedcContext.isDebugOutput()) {
                    strDebugInfo = String.valueOf(strDebugInfo) + StringHelper.Format((String)"\u76ee\u6807\u503c\u53c2\u6570[%1$s ==> %2$s]", (Object)strArg, (Object)objDest);
                }
                switch (nCondition) {
                    case 2: {
                        bRet = DataTypeParse.Compare((int)nDataType, (Object)objValue, (Object)objDest) > 0L;
                        break block0;
                    }
                    case 3: {
                        bRet = DataTypeParse.Compare((int)nDataType, (Object)objValue, (Object)objDest) >= 0L;
                        break block0;
                    }
                    case 1: {
                        bRet = DataTypeParse.Compare((int)nDataType, (Object)objValue, (Object)objDest) == 0L;
                        break block0;
                    }
                    case 4: {
                        bRet = DataTypeParse.Compare((int)nDataType, (Object)objValue, (Object)objDest) < 0L;
                        break block0;
                    }
                    case 5: {
                        bRet = DataTypeParse.Compare((int)nDataType, (Object)objValue, (Object)objDest) <= 0L;
                        break block0;
                    }
                    case 6: {
                        bRet = DataTypeParse.Compare((int)nDataType, (Object)objValue, (Object)objDest) != 0L;
                        break block0;
                    }
                }
                bRet = false;
            }
        }
        if (dedcContext.isDebugOutput()) {
            strDebugInfo = String.valueOf(strDebugInfo) + StringHelper.Format((String)"\u7ed3\u679c\u4e3a[%1$s]", (Object)bRet);
            dedcContext.DebugOutput((Object)this, strDebugInfo);
        }
        callResult.setUserObject((Object)bRet);
        return callResult;
    }

    public CallResult TestUserLogicItem(IDEDataCtrlEngineContext dedcContext, DEDCRuleUserLogicItemConfig logicItemConfig, BaseDataEntity srcDataEntity) {
        CallResult callResult = new CallResult();
        boolean bRet = false;
        DEDCGrooveEngine grooveEngine = new DEDCGrooveEngine();
        String strCode = logicItemConfig.getCode();
        callResult = grooveEngine.EvalWithReturn(dedcContext, strCode);
        if (callResult.IsError()) {
            return callResult;
        }
        Object objValue = callResult.getUserObject();
        if (objValue != null && objValue instanceof Boolean) {
            bRet = (Boolean)objValue;
        }
        callResult.setUserObject((Object)bRet);
        return callResult;
    }
}

