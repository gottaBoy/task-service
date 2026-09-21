/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEDataLog
 *  SA.SRFDA.Ctrl.Data.DataNotify
 *  SA.SRFDA.Ctrl.Data.MsgSendQueue
 *  SA.SRFDA.Ctrl.Data.MsgTemplate
 *  SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelper
 *  SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelperContext
 *  SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyBaseLogicConfig
 *  SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyCustomLogicConfig
 *  SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyGroupLogicConfig
 *  SA.SRFDA.Ctrl.DataNotify.Model.DataNotifySingleLogicConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataNotify;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEDataLog;
import SA.SRFDA.Ctrl.Data.DataNotify;
import SA.SRFDA.Ctrl.Data.MsgSendQueue;
import SA.SRFDA.Ctrl.Data.MsgTemplate;
import SA.SRFDA.Ctrl.DataNotify.DataNotifyGrooveEngine;
import SA.SRFDA.Ctrl.DataNotify.DefaultDataNotifyHelperContext;
import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelper;
import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelperContext;
import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyBaseLogicConfig;
import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyCustomLogicConfig;
import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyGroupLogicConfig;
import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifySingleLogicConfig;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.MSG.Ctrl.MsgTemplateHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultDataNotifyHelper
implements IDataNotifyHelper {
    private static Log log = LogFactory.getLog(DefaultDataNotifyHelper.class);
    protected IDEDataCtrl iMsgTemplateDataCtrl = null;
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected String strDBStorage = "";
    protected Vector<Integer> msgTypes = new Vector();

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        CallResult callResult = new CallResult();
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.msgTypes.add(2);
        this.msgTypes.add(1);
        this.msgTypes.add(8);
        this.msgTypes.add(4);
        this.msgTypes.add(16);
        this.iMsgTemplateDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0076", "SYSTEM", null);
        if (this.iMsgTemplateDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0076"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        this.strDBStorage = this.iMsgTemplateDataCtrl.GetDEHelper().GetDBStorage();
        return callResult;
    }

    public CallResult Notify(IDEDataCtrl iDEDataCtrl, DataNotify dataNotify, BaseDataEntity lastDataEntity, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)dataNotify.getNOTIFYTYPE(), (String)"TIME", (boolean)true) == 0) {
            return this.DoTimeNotify(iDEDataCtrl, dataNotify, lastDataEntity, dataEntity, false);
        }
        if (StringHelper.Compare((String)dataNotify.getNOTIFYTYPE(), (String)"TIMEEX", (boolean)true) == 0) {
            return this.DoTimeNotify(iDEDataCtrl, dataNotify, lastDataEntity, dataEntity, true);
        }
        if (StringHelper.Compare((String)dataNotify.getNOTIFYTYPE(), (String)"NORMAL", (boolean)true) == 0) {
            return this.DoNormalNotify(iDEDataCtrl, dataNotify, lastDataEntity, dataEntity);
        }
        return new CallResult();
    }

    protected CallResult DoTimeNotify(IDEDataCtrl iDEDataCtrl, DataNotify dataNotify, BaseDataEntity lastDataEntity, BaseDataEntity dataEntity, boolean bEnableModel) {
        IDEDataCtrl iMsgSendQueueDataCtrl;
        CallResult callResult = new CallResult();
        IDEHelper iDEHelper = iDEDataCtrl.GetDEHelper();
        String strDEData = dataEntity.GetParamStringValue(iDEHelper.GetKeyDEFHelper().getName(), "");
        if (bEnableModel) {
            DefaultDataNotifyHelperContext defaultDataNotifyHelperContext = new DefaultDataNotifyHelperContext();
            defaultDataNotifyHelperContext.setDEHelper(iDEHelper);
            defaultDataNotifyHelperContext.setDataEntity(dataEntity);
            defaultDataNotifyHelperContext.setLastDataEntity(lastDataEntity);
            callResult = this.TestGroupLogic(defaultDataNotifyHelperContext, dataNotify.getValueChangeModelConfig());
            if (callResult.IsError()) {
                return callResult;
            }
            Boolean bRet = false;
            if (callResult.getUserObject() != null && callResult.getUserObject() instanceof Boolean) {
                bRet = (Boolean)callResult.getUserObject();
            }
            callResult.Reset();
            if (!bRet.booleanValue()) {
                return callResult;
            }
        }
        this.RemoveLastTimeNotify(dataNotify.getDATANOTIFYID(), strDEData);
        IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(dataNotify.getTIMEFIELDID());
        if (iDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDEHelper.getId(), (Object)dataNotify.getTIMEFIELDID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        Object objValue = dataEntity.GetParamValue(iDEFHelper.getName());
        if (objValue == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u5c5e\u6027[%1$s]\u503c\u4e3a\u7a7a", (Object)iDEFHelper.getName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        long nTime = DateParser.GetTime((Object)objValue);
        if (nTime == -1L) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u5c5e\u6027[%1$s]\u503c\u7c7b\u578b\u4e0d\u6b63\u786e\uff0c%2$s", (Object)iDEFHelper.getName(), (Object)objValue));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        long nTimeArg = dataNotify.getTIMEARG() * 1000;
        if (!StringHelper.IsNullOrEmpty((String)dataNotify.getTIMEUNIT())) {
            if (StringHelper.Compare((String)dataNotify.getTIMEUNIT(), (String)"MINUTE", (boolean)true) == 0) {
                nTimeArg *= 60L;
            }
            if (StringHelper.Compare((String)dataNotify.getTIMEUNIT(), (String)"HOUR", (boolean)true) == 0) {
                nTimeArg *= 3600L;
            }
            if (StringHelper.Compare((String)dataNotify.getTIMEUNIT(), (String)"DAY", (boolean)true) == 0) {
                nTimeArg *= 86400L;
            }
        }
        nTime = StringHelper.Compare((String)dataNotify.getTIMECOND(), (String)"BEFORE", (boolean)true) == 0 ? (nTime -= nTimeArg) : (nTime += nTimeArg);
        Vector<MsgSendQueue> list = new Vector<MsgSendQueue>();
        callResult = this.GetMsgSendQueues(iDEHelper, dataNotify, null, dataEntity, list);
        if (callResult.IsError()) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strSenderTag = StringHelper.Format((String)"[%1$s][%2$s]", (Object)dataNotify.getDATANOTIFYID(), (Object)strDEData);
        Vector<String> msgSendQueueIds = new Vector<String>();
        Timestamp ts = new Timestamp(nTime);
        String strMsgToAccountIds = dataNotify.getMsgToAccountIds();
        for (String strField : dataNotify.getContextUserList()) {
            String strAccountId = dataEntity.GetParamStringValue(strField, "");
            if (StringHelper.IsNullOrEmpty((String)strAccountId)) continue;
            if (!StringHelper.IsNullOrEmpty((String)strMsgToAccountIds)) {
                strMsgToAccountIds = String.valueOf(strMsgToAccountIds) + ";";
            }
            strMsgToAccountIds = String.valueOf(strMsgToAccountIds) + (String)strAccountId;
        }
        String strMsgToAddresses = "";
        for (String strField : dataNotify.getContextAddressList()) {
            String strAddresses = dataEntity.GetParamStringValue(strField, "");
            if (StringHelper.IsNullOrEmpty((String)strAddresses)) continue;
            if (!StringHelper.IsNullOrEmpty((String)strMsgToAddresses)) {
                strMsgToAddresses = String.valueOf(strMsgToAddresses) + ";";
            }
            strMsgToAddresses = String.valueOf(strMsgToAddresses) + strAddresses;
        }
        try {
            iMsgSendQueueDataCtrl = iDEDataCtrl.GetRelatedDataCtrl("DE0077");
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
        for (MsgSendQueue msgSendQueue : list) {
            msgSendQueue.SetParamValue("SRF_PERSONID", (Object)"SYSTEM");
            msgSendQueue.setDSTUSERS(strMsgToAccountIds);
            msgSendQueue.setDSTADDRESSES(strMsgToAddresses);
            msgSendQueue.SetParamValue("PLANSENDTIME", (Object)ts);
            msgSendQueue.setSENDTAG(strSenderTag);
            BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)msgSendQueue, (boolean)false);
            callResult = iMsgSendQueueDataCtrl.Save(true, (BaseDataEntity)msgSendQueue);
            if (callResult.IsError()) {
                log.warn((Object)StringHelper.Format((String)"\u4fdd\u5b58\u53d1\u9001\u6570\u636e\u961f\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                continue;
            }
            msgSendQueueIds.add(msgSendQueue.getMSGSENDQUEUEID());
        }
        return callResult;
    }

    protected void RemoveLastTimeNotify(String strNotifyId, String strDEData) {
        String strSenderTag = StringHelper.Format((String)"[%1$s][%2$s]", (Object)strNotifyId, (Object)strDEData);
        String strSQL = StringHelper.Format((String)"DELETE FROM T_SRFMSGSENDQUEUE WHERE SENDTAG='%1$S'", (Object)strSenderTag);
        CallResult callResult = BaseDEDataCtrl.ExecuteWithoutResultEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strDBStorage, (String)strSQL, null);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u6e05\u9664\u4e0a\u6b21\u53d1\u9001\u6570\u636e\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public void RemoveTimeNotify(String strNotifyId, String strDEData) {
        String strSenderTag = StringHelper.Format((String)"[%1$s][%2$s]", (Object)strNotifyId, (Object)strDEData);
        String strSQL = StringHelper.Format((String)"DELETE FROM T_SRFMSGSENDQUEUE WHERE SENDTAG='%1$S'", (Object)strSenderTag);
        CallResult callResult = BaseDEDataCtrl.ExecuteWithoutResultEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strDBStorage, (String)strSQL, null);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u6e05\u9664\u4e0a\u6b21\u53d1\u9001\u6570\u636e\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected CallResult DoNormalNotify(IDEDataCtrl iDEDataCtrl, DataNotify dataNotify, BaseDataEntity lastDataEntity, BaseDataEntity dataEntity) {
        IDEDataCtrl iMsgSendQueueDataCtrl;
        CallResult callResult = new CallResult();
        IDEHelper iDEHelper = iDEDataCtrl.GetDEHelper();
        DefaultDataNotifyHelperContext defaultDataNotifyHelperContext = new DefaultDataNotifyHelperContext();
        defaultDataNotifyHelperContext.setDEHelper(iDEHelper);
        defaultDataNotifyHelperContext.setDataEntity(dataEntity);
        defaultDataNotifyHelperContext.setLastDataEntity(lastDataEntity);
        callResult = this.TestGroupLogic(defaultDataNotifyHelperContext, dataNotify.getValueChangeModelConfig());
        if (callResult.IsError()) {
            return callResult;
        }
        Boolean bRet = false;
        if (callResult.getUserObject() != null && callResult.getUserObject() instanceof Boolean) {
            bRet = (Boolean)callResult.getUserObject();
        }
        callResult.Reset();
        if (!bRet.booleanValue()) {
            return callResult;
        }
        Vector<MsgSendQueue> list = new Vector<MsgSendQueue>();
        callResult = this.GetMsgSendQueues(iDEHelper, dataNotify, lastDataEntity, dataEntity, list);
        if (callResult.IsError()) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strMsgToAccountIds = dataNotify.getMsgToAccountIds();
        for (String strField : dataNotify.getContextUserList()) {
            String strAccountId = dataEntity.GetParamStringValue(strField, "");
            if (StringHelper.IsNullOrEmpty((String)strAccountId)) continue;
            if (!StringHelper.IsNullOrEmpty((String)strMsgToAccountIds)) {
                strMsgToAccountIds = String.valueOf(strMsgToAccountIds) + ";";
            }
            strMsgToAccountIds = String.valueOf(strMsgToAccountIds) + (String)strAccountId;
        }
        String strMsgToAddresses = "";
        for (String strField : dataNotify.getContextAddressList()) {
            String strAddresses = dataEntity.GetParamStringValue(strField, "");
            if (StringHelper.IsNullOrEmpty((String)strAddresses)) continue;
            if (!StringHelper.IsNullOrEmpty((String)strMsgToAddresses)) {
                strMsgToAddresses = String.valueOf(strMsgToAddresses) + ";";
            }
            strMsgToAddresses = String.valueOf(strMsgToAddresses) + strAddresses;
        }
        try {
            iMsgSendQueueDataCtrl = iDEDataCtrl.GetRelatedDataCtrl("DE0077");
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
        for (MsgSendQueue msgSendQueue : list) {
            msgSendQueue.SetParamValue("SRF_PERSONID", (Object)"SYSTEM");
            msgSendQueue.setDSTUSERS(strMsgToAccountIds);
            msgSendQueue.setDSTADDRESSES(strMsgToAddresses);
            BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)msgSendQueue, (boolean)false);
            callResult = iMsgSendQueueDataCtrl.Save(true, (BaseDataEntity)msgSendQueue);
            if (!callResult.IsError()) continue;
            log.warn((Object)StringHelper.Format((String)"\u4fdd\u5b58\u53d1\u9001\u6570\u636e\u961f\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return callResult;
    }

    protected CallResult TestGroupLogic(IDataNotifyHelperContext iDataNotifyHelperContext, DataNotifyGroupLogicConfig groupLogic) {
        CallResult callResult = null;
        boolean bRet = false;
        boolean bAndMode = StringHelper.Compare((String)groupLogic.getCondition(), (String)"AND", (boolean)true) == 0;
        for (DataNotifyBaseLogicConfig logicItem : groupLogic.getChildLogics()) {
            if (logicItem instanceof DataNotifyGroupLogicConfig) {
                callResult = this.TestGroupLogic(iDataNotifyHelperContext, (DataNotifyGroupLogicConfig)logicItem);
            } else if (logicItem instanceof DataNotifySingleLogicConfig) {
                callResult = this.TestSingleLogic(iDataNotifyHelperContext, (DataNotifySingleLogicConfig)logicItem);
            } else if (logicItem instanceof DataNotifyCustomLogicConfig) {
                callResult = this.TestCustomLogic(iDataNotifyHelperContext, (DataNotifyCustomLogicConfig)logicItem);
            }
            if (callResult.IsError()) {
                return callResult;
            }
            if (((Boolean)callResult.getUserObject()).booleanValue()) {
                bRet = true;
                if (bAndMode) continue;
                break;
            }
            bRet = false;
            if (bAndMode) break;
        }
        if (groupLogic.isNot()) {
            boolean bl = bRet = !bRet;
        }
        if (callResult == null) {
            callResult = new CallResult();
        }
        callResult.setUserObject((Object)bRet);
        return callResult;
    }

    protected CallResult TestSingleLogic(IDataNotifyHelperContext iDataNotifyHelperContext, DataNotifySingleLogicConfig singleLogic) {
        CallResult callResult = new CallResult();
        IDEFHelper iDEFHelper = iDataNotifyHelperContext.getDEHelper().GetDEFHelper(singleLogic.getDEField());
        if (iDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDataNotifyHelperContext.getDEHelper().getId(), (Object)singleLogic.getDEField()));
            return callResult;
        }
        if (StringHelper.Compare((String)singleLogic.getValueCondition(), (String)"CHANGE", (boolean)true) == 0) {
            Object oldValue = null;
            Object newValue = null;
            if (iDataNotifyHelperContext.getLastDataEntity() != null) {
                oldValue = iDataNotifyHelperContext.getLastDataEntity().GetParamValue(iDEFHelper.getName());
            }
            if (iDataNotifyHelperContext.getDataEntity() != null) {
                newValue = iDataNotifyHelperContext.getDataEntity().GetParamValue(iDEFHelper.getName());
            }
            if (oldValue == null && newValue == null) {
                callResult.setUserObject((Object)false);
                return callResult;
            }
            if (oldValue == null || newValue == null) {
                callResult.setUserObject((Object)true);
                return callResult;
            }
            boolean bRet = DataTypeParse.Compare((String)iDEFHelper.GetDataType(), (Object)oldValue, (Object)newValue) != 0L;
            callResult.setUserObject((Object)bRet);
            return callResult;
        }
        Object objValue = null;
        BaseDataEntity dataEntity = null;
        if (StringHelper.Compare((String)singleLogic.getValueCondition(), (String)"BEFORE", (boolean)true) == 0) {
            if (iDataNotifyHelperContext.getLastDataEntity() != null) {
                dataEntity = iDataNotifyHelperContext.getLastDataEntity();
                objValue = iDataNotifyHelperContext.getLastDataEntity().GetParamValue(iDEFHelper.getName());
            }
        } else if (iDataNotifyHelperContext.getDataEntity() != null) {
            dataEntity = iDataNotifyHelperContext.getDataEntity();
            objValue = iDataNotifyHelperContext.getDataEntity().GetParamValue(iDEFHelper.getName());
        }
        boolean bRet = false;
        String strCondition = singleLogic.getCondition();
        if (StringHelper.Compare((String)strCondition, (String)"ISNOTNULL", (boolean)true) == 0) {
            bRet = objValue != null;
        } else if (StringHelper.Compare((String)strCondition, (String)"ISNULL", (boolean)true) == 0) {
            bRet = objValue == null;
        } else {
            Object objValue2 = null;
            if (!StringHelper.IsNullOrEmpty((String)singleLogic.getParamName())) {
                callResult = MacroHelper.GetValue((String)singleLogic.getParamName(), (ISRFDAGlobalHelper)this.iDAGlobalHelper, null, (BaseDataEntity)dataEntity);
                if (callResult.IsError()) {
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                objValue2 = callResult.getUserObject();
                if (objValue2 != null && objValue2 instanceof String) {
                    objValue2 = iDEFHelper.GetDEFValue((String)objValue2);
                }
            } else {
                objValue2 = iDEFHelper.GetDEFValue(singleLogic.getValue());
            }
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                bRet = DataTypeParse.Compare((String)iDEFHelper.GetDataType(), (Object)objValue, (Object)objValue2) == 0L;
            } else if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                bRet = DataTypeParse.Compare((String)iDEFHelper.GetDataType(), (Object)objValue, (Object)objValue2) != 0L;
            } else if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
                bRet = DataTypeParse.Compare((String)iDEFHelper.GetDataType(), (Object)objValue, (Object)objValue2) > 0L;
            } else if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
                bRet = DataTypeParse.Compare((String)iDEFHelper.GetDataType(), (Object)objValue, (Object)objValue2) >= 0L;
            } else if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
                bRet = DataTypeParse.Compare((String)iDEFHelper.GetDataType(), (Object)objValue, (Object)objValue2) < 0L;
            } else if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
                bRet = DataTypeParse.Compare((String)iDEFHelper.GetDataType(), (Object)objValue, (Object)objValue2) <= 0L;
            } else if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                bRet = false;
                if (objValue != null && objValue2 != null) {
                    bRet = objValue.toString().toUpperCase().indexOf(objValue2.toString().toUpperCase()) != -1;
                }
            } else {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u903b\u8f91\u7b26\u53f7[%1$s]", (Object)strCondition));
            }
        }
        callResult.setUserObject((Object)bRet);
        return callResult;
    }

    protected CallResult TestCustomLogic(IDataNotifyHelperContext iDataNotifyHelperContext, DataNotifyCustomLogicConfig customLogic) {
        CallResult callResult = new CallResult();
        DataNotifyGrooveEngine dnGrooveEngine = new DataNotifyGrooveEngine();
        callResult = dnGrooveEngine.EvalWithReturn(iDataNotifyHelperContext, customLogic.getCondition());
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    public CallResult QueueNotify(IDEDataCtrl iDEDataCtrl, int nEventType, BaseDataEntity lastDataEntity, BaseDataEntity dataEntity) {
        IDEDataCtrl iDEDataLogDataCtrl;
        CallResult callResult = new CallResult();
        String strDEId = iDEDataCtrl.GetDEHelper().getId();
        DEDataLog dataLog = new DEDataLog();
        dataLog.setDEID(strDEId);
        if (lastDataEntity != null) {
            dataLog.setOLDDATA(BaseDataEntity.ToString((BaseDataEntity)lastDataEntity));
        }
        if (dataEntity != null) {
            dataLog.setNEWDATA(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
        }
        try {
            iDEDataLogDataCtrl = iDEDataCtrl.GetRelatedDataCtrl("DE0116");
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
        dataLog.setEVENTTYPE(nEventType);
        dataLog.SetParamValue("SRF_PERSONID", (Object)"SYSTEM");
        dataLog.SetParamValue("SRF_CHECKKEY", (Object)0);
        dataLog.SetParamValue("SRF_RETDATA", (Object)0);
        callResult = iDEDataLogDataCtrl.Save(true, (BaseDataEntity)dataLog);
        return callResult;
    }

    protected CallResult GetMsgSendQueues(IDEHelper iDEHelper, DataNotify dataNotify, BaseDataEntity lastDataEntity, BaseDataEntity dataEntity, Vector<MsgSendQueue> list) {
        CallResult callResult = new CallResult();
        MsgTemplate msgTemplate = new MsgTemplate();
        msgTemplate.setMSGTEMPLATEID(dataNotify.getMSGTEMPLATEID());
        callResult = this.iMsgTemplateDataCtrl.Get((BaseDataEntity)msgTemplate);
        if (callResult.IsError()) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u6d88\u606f\u6a21\u677f[%1$s]\u5931\u8d25\uff0c%2$s", (Object)dataNotify.getMSGTEMPLATEID(), (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        for (int nMsgType : this.msgTypes) {
            if ((dataNotify.getMSGTYPE() & nMsgType) == 0) continue;
            callResult = MsgTemplateHelper.GetMsgSendQueue(nMsgType, msgTemplate, iDEHelper, dataEntity, lastDataEntity, this.iDAGlobalHelper, null, null, "", null);
            if (callResult.IsError()) {
                return callResult;
            }
            MsgSendQueue msq = (MsgSendQueue)callResult.getUserObject();
            list.add(msq);
        }
        return callResult;
    }
}

