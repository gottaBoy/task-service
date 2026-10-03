/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DEDSCtrl;
import SA.SRFDA.Ctrl.Data.DEDataAction;
import SA.SRFDA.Ctrl.Data.DataAudit;
import SA.SRFDA.Ctrl.Data.DataAuditDetail;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import SA.SRFDA.Ctrl.Utility.KeyHelper;
import SA.SRFDA.Security.IDataAccHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDataAccHelper
implements IDataAccHelper {
    private static final Log log = LogFactory.getLog(BaseDataAccHelper.class);
    protected IDEHelper iDEHelper = null;
    protected boolean bMajorDE = true;
    protected String strMajorDEId = "";
    protected ISRFDAGlobalHelper contextHelperEx = null;
    protected Hashtable<String, DEDataAction> dataActionMap = null;
    protected Hashtable<String, Vector<DEDSCtrl>> dsCtrlMap = null;
    private boolean bMultiMajorDEMode = false;
    protected String strDataActions = "";

    @Override
    public void Init(ISRFDAGlobalHelper contextHelperEx, IDEHelper iDEHelper) {
        this.iDEHelper = iDEHelper;
        this.bMultiMajorDEMode = this.iDEHelper.IsMultiMajorDE();
        this.strMajorDEId = this.iDEHelper.GetMajorDEId();
        this.bMajorDE = StringHelper.Compare((String)this.strMajorDEId, (String)this.iDEHelper.getId(), (boolean)true) == 0;
        this.contextHelperEx = contextHelperEx;
        Vector<DEDSCtrl> dsCtrls = new Vector<DEDSCtrl>();
        CallResult callResult = contextHelperEx.getDAModelHelper().GetDEDSCtrls(this.iDEHelper.getId(), dsCtrls);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u72b6\u6001\u63a7\u5236\u5931\u8d25\uff0c%2$s", (Object)this.iDEHelper.getId(), (Object)callResult.getErrorInfo()));
            return;
        }
        if (dsCtrls.size() > 0) {
            this.dsCtrlMap = new Hashtable();
        }
        for (DEDSCtrl dsCtrl : dsCtrls) {
            String strDenyActions = dsCtrl.getDENYACTIONS();
            if (StringHelper.IsNullOrEmpty((String)strDenyActions) || StringHelper.IsNullOrEmpty((String)dsCtrl.getDEFVALUE())) continue;
            IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(dsCtrl.getDEFID());
            if (iDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dsCtrl.getDEFID()));
                continue;
            }
            dsCtrl.setDEFHelper(iDEFHelper);
            dsCtrl.InitCtrlFields();
            String[] actions = strDenyActions.split("[|]");
            int i = 0;
            while (i < actions.length) {
                String strAction = actions[i];
                if (!StringHelper.IsNullOrEmpty((String)(strAction = strAction.trim()))) {
                    strAction = strAction.toUpperCase();
                    Vector<DEDSCtrl> values = null;
                    if (!this.dsCtrlMap.containsKey(strAction)) {
                        values = new Vector<DEDSCtrl>();
                        this.dsCtrlMap.put(strAction, values);
                    } else {
                        values = this.dsCtrlMap.get(strAction);
                    }
                    values.add(dsCtrl);
                }
                ++i;
            }
        }
        Hashtable<String, DEDataAction> dataActionMap = this.GetDataActionMap(contextHelperEx);
        if (dataActionMap == null) {
            log.error((Object)callResult.getErrorInfo());
            return;
        }
        for (String strKey : dataActionMap.keySet()) {
            if (!StringHelper.IsNullOrEmpty((String)this.strDataActions)) {
                this.strDataActions = String.valueOf(this.strDataActions) + "|";
            }
            this.strDataActions = String.valueOf(this.strDataActions) + strKey;
        }
        this.OnInit();
    }

    protected void OnInit() {
    }

    protected IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    @Override
    public DEDSCtrl FindFieldCtrl(BaseDataEntity dataEntity) {
        if (this.dsCtrlMap == null) {
            return null;
        }
        Vector<DEDSCtrl> dedsCtrls = this.dsCtrlMap.get("NONE");
        if (dedsCtrls == null) {
            return null;
        }
        for (DEDSCtrl dsctrl : dedsCtrls) {
            String strValue;
            if (!dataEntity.ContainesParam(dsctrl.getDEFHelper().getName()) || StringHelper.Compare((String)(strValue = dataEntity.GetParamStringValue(dsctrl.getDEFHelper().getName(), "")), (String)dsctrl.getDEFVALUE(), (boolean)true) != 0) continue;
            return dsctrl;
        }
        return null;
    }

    @Override
    public CallResult Test(ISRFDAWebContext webContext, BaseDataEntity dataEntity, String strAction) {
        return this.InternalTest(webContext, this.contextHelperEx, webContext.getCurUserId(), dataEntity, strAction);
    }

    public CallResult InternalTest(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, String strCurPersonId, BaseDataEntity dataEntity, String strAction) {
        CallResult callResult = new CallResult();
        BaseDataEntity curDataEntity = null;
        strAction = strAction.toUpperCase();
        String strMajorDEPickupField = "";
        if (this.isMultiMajorDEMode() && StringHelper.IsNullOrEmpty((String)(strMajorDEPickupField = this.getDEHelper().CalcMajorDEPickupField(dataEntity)))) {
            if (curDataEntity == null) {
                callResult = this.GetCurDataEntity(dataEntity, strCurPersonId);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
                curDataEntity = (BaseDataEntity)callResult.getUserObject();
            }
            strMajorDEPickupField = this.getDEHelper().CalcMajorDEPickupField(curDataEntity);
        }
        if (this.dsCtrlMap != null && this.dsCtrlMap.containsKey(strAction)) {
            if (curDataEntity == null) {
                callResult = this.GetCurDataEntity(dataEntity, strCurPersonId);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
                curDataEntity = (BaseDataEntity)callResult.getUserObject();
            }
            Vector<DEDSCtrl> values = this.dsCtrlMap.get(strAction);
            for (DEDSCtrl dsctrl : values) {
                String strValue;
                if (!curDataEntity.ContainesParam(dsctrl.getDEFHelper().getName()) || StringHelper.Compare((String)(strValue = curDataEntity.GetParamStringValue(dsctrl.getDEFHelper().getName(), "")), (String)dsctrl.getDEFVALUE(), (boolean)true) != 0) continue;
                callResult.setRetCode(2);
                callResult.setErrorInfo(dsctrl.getDEDSCTRLNAME());
                log.debug((Object)StringHelper.Format((String)"\u6570\u636e\u8bbf\u95ee\u63a7\u5236[%1$s][%2$s]\u62d2\u7edd\u64cd\u4f5c", (Object)strAction, (Object)dsctrl.getDEDSCTRLNAME()));
                return callResult;
            }
        }
        if (!this.bMajorDE) {
            Hashtable<String, DEDataAction> dataActionMap = this.GetDataActionMap(globalHelper);
            if (dataActionMap == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u64cd\u4f5c\u6620\u5c04", (Object)this.iDEHelper.getId()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            boolean bMajorDE = true;
            String strMajorDEAction = strAction;
            if (dataActionMap.containsKey(strAction)) {
                DEDataAction dataAction = dataActionMap.get(strAction);
                bMajorDE = dataAction.isMAPTOMAJOR();
                strMajorDEAction = dataAction.getMAJORDEACTION();
            } else {
                bMajorDE = true;
                if (StringHelper.Compare((String)strAction, (String)"CREATE", (boolean)true) == 0 || StringHelper.Compare((String)strAction, (String)"DELETE", (boolean)true) == 0) {
                    strMajorDEAction = "UPDATE";
                }
            }
            if (bMajorDE) {
                IDEHelper iMajorDEHelper;
                IDEHelper iDEHelper = iMajorDEHelper = this.isMultiMajorDEMode() ? this.iDEHelper.GetMajorDEHelper(strMajorDEPickupField) : this.iDEHelper.GetMajorDEHelper();
                if (iMajorDEHelper == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u4e3b\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)this.iDEHelper.getId()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                BaseDataEntity temp = new BaseDataEntity();
                if (StringHelper.Compare((String)strAction, (String)"CREATE", (boolean)true) == 0) {
                    temp.SetParamValue(iMajorDEHelper.GetKeyDEFHelper().getName(), dataEntity.GetParamValue(this.isMultiMajorDEMode() ? strMajorDEPickupField : this.iDEHelper.GetMajorDEPickupField()));
                } else {
                    if (curDataEntity == null) {
                        callResult = this.GetCurDataEntity(dataEntity, strCurPersonId);
                        if (callResult.getRetCode() != 0) {
                            return callResult;
                        }
                        curDataEntity = (BaseDataEntity)callResult.getUserObject();
                    }
                    temp.SetParamValue(iMajorDEHelper.GetKeyDEFHelper().getName(), curDataEntity.GetParamValue(this.isMultiMajorDEMode() ? strMajorDEPickupField : this.iDEHelper.GetMajorDEPickupField()));
                }
                if (webContext != null) {
                    return iMajorDEHelper.GetDataAccHelper().Test(webContext, temp, strMajorDEAction);
                }
                return iMajorDEHelper.GetDataAccHelper().Test(webContext, temp, strMajorDEAction);
            }
        }
        if (StringHelper.Compare((String)strCurPersonId, (String)"SYSTEM", (boolean)true) == 0) {
            callResult.setUserObject((Object)true);
            return callResult;
        }
        if (StringHelper.Compare((String)strAction, (String)"CREATE", (boolean)true) == 0) {
            return webContext.GetUserRoleHelper().TestUserRoleDataAction(this.iDEHelper.getId(), strAction);
        }
        String strValue = dataEntity.GetParamStringValue(this.iDEHelper.GetKeyDEFHelper().getName(), "");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
            return callResult;
        }
        if (KeyHelper.IsTempKey(strValue)) {
            callResult.setUserObject((Object)true);
            return callResult;
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        daQueryModelHelper = webContext.GetUserQueryModelStorage().FindDAQueryModelHelper(this.iDEHelper, strAction);
        if (daQueryModelHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6570\u636e\u67e5\u8be2\u5bf9\u8c61\u65e0\u6548");
            return callResult;
        }
        DefaultDAQueryModelUserContext qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(daQueryModelHelper.GetQMDeclareScript());
        script.Append(qmUserContext.GetQMDeclareScript());
        script.Append(daQueryModelHelper.GetQueryModelScript());
        Vector<String> userConditions = new Vector<String>();
        daQueryModelHelper.FillMajorConditions(userConditions);
        String strKeyCondition = daQueryModelHelper.GetConditionSQL(qmUserContext, this.iDEHelper.GetKeyDEFHelper(), "", "=", strValue);
        if (StringHelper.IsNullOrEmpty((String)strKeyCondition)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u4e3b\u952e\u6761\u4ef6");
            return callResult;
        }
        if (strKeyCondition.indexOf("UPPER(") != -1) {
            log.warn((Object)StringHelper.Format((String)"\u4e3b\u952e\u6761\u4ef6[%1$s]\u5305\u62ec[UPPER\u8f6c\u6362]\uff0c\u8bf7\u68c0\u67e5\u5c5e\u6027\u7684\u67e5\u8be2\u5927\u5c0f\u5199\u654f\u611f\u8bbe\u7f6e", (Object)strKeyCondition));
        }
        userConditions.add(strKeyCondition);
        if (userConditions.size() != 0) {
            script.Append(" WHERE ");
            boolean bFirst = true;
            for (String strCondition : userConditions) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    script.Append(" AND ");
                }
                script.Append("(%1$s)", (Object)strCondition);
            }
        }
        Vector<CallParam> list = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(list, webContext, globalHelper, strCurPersonId);
        qmUserContext.FillQMDeclareParams(list, webContext, globalHelper, strCurPersonId);
        daQueryModelHelper.FillCallParams(list, webContext, globalHelper, strCurPersonId);
        StringBuilderEx info = new StringBuilderEx();
        info.Append("\u6570\u636e\u6743\u9650\u68c0\u67e5\u4ee3\u7801[%1$s][%2$s][%3$s]\r\n%4$s\r\n", (Object)this.iDEHelper.getId(), (Object)strAction, (Object)strValue, (Object)script.toString());
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                CallParam callParam = list.get(i);
                info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                ++i;
            }
        }
        log.info((Object)info.toString());
        BaseDataEntity temp = new BaseDataEntity();
        callResult = BaseDEDataCtrl.SelectSingleEx(globalHelper, this.iDEHelper.GetDBStorage(), script.toString(), list, temp);
        if (callResult.getRetCode() == 0) {
            callResult.setUserObject((Object)true);
            return callResult;
        }
        if (callResult.getRetCode() == 3) {
            callResult.setRetCode(2);
            return callResult;
        }
        return callResult;
    }

    private Hashtable<String, DEDataAction> GetDataActionMap(ISRFDAGlobalHelper globalHelper) {
        if (this.dataActionMap != null) {
            return this.dataActionMap;
        }
        this.dataActionMap = new Hashtable();
        Vector<DEDataAction> dataActions = new Vector<DEDataAction>();
        CallResult callResult = globalHelper.getDAModelHelper().GetDEDataActions(this.iDEHelper.getId(), dataActions);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9644\u5c5e\u5b9e\u4f53[%1$s]\u64cd\u4f5c\u6620\u5c04\u5931\u8d25\uff0c%2$s", (Object)this.iDEHelper.getId(), (Object)callResult.getErrorInfo()));
            return null;
        }
        for (DEDataAction dataAction : dataActions) {
            this.dataActionMap.put(dataAction.getDEDATAACTIONNAME().toUpperCase(), dataAction);
        }
        return this.dataActionMap;
    }

    @Override
    public CallResult GetDataActionMap(String strAction, ISRFDAGlobalHelper globalHelper, DEDataAction dataAction) {
        CallResult callResult = new CallResult();
        Hashtable<String, DEDataAction> dataActionMap = this.GetDataActionMap(globalHelper);
        if (dataActionMap == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u64cd\u4f5c\u6620\u5c04", (Object)this.iDEHelper.getId()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        dataAction.setISMAPTOMAJOR(true);
        if (dataActionMap.containsKey(strAction.toUpperCase())) {
            DEDataAction dataAction2 = dataActionMap.get(strAction.toUpperCase());
            dataAction2.CopyTo(dataAction, true);
        } else if (StringHelper.Compare((String)strAction, (String)"CREATE", (boolean)true) == 0 || StringHelper.Compare((String)strAction, (String)"DELETE", (boolean)true) == 0) {
            dataAction.setMAJORDEACTION("UPDATE");
        } else {
            dataAction.setMAJORDEACTION(strAction);
        }
        return callResult;
    }

    @Override
    public CallResult Audit(String strAuditInfo, ISRFDATransactionManager iTransactionMgr, ISRFDAWebContext webContext, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity, String strAction) {
        return this.Audit(strAuditInfo, iTransactionMgr, webContext.getCurUserId(), webContext.getRemoteAddr(), dataEntity, lastDataEntity, strAction);
    }

    @Override
    public CallResult Audit(String strAuditInfo, ISRFDATransactionManager iTransactionMgr, String strOpPersonId, String strFromIpAddress, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity, String strAction) {
        CallResult callResult = new CallResult();
        IDEHelper iMajorDEHelper = null;
        String strMajorDEPickupField = "";
        if (!this.bMajorDE) {
            if (this.isMultiMajorDEMode()) {
                strMajorDEPickupField = this.getDEHelper().CalcMajorDEPickupField(dataEntity);
            }
            IDEHelper iDEHelper = iMajorDEHelper = this.isMultiMajorDEMode() ? this.iDEHelper.GetMajorDEHelper(strMajorDEPickupField) : this.iDEHelper.GetMajorDEHelper();
            if (iMajorDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u4e3b\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)this.iDEHelper.getId()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
        }
        if (!this.iDEHelper.IsEnableAudit()) {
            if (this.bMajorDE) {
                return callResult;
            }
            if (!iMajorDEHelper.IsEnableAudit()) {
                return callResult;
            }
        }
        String strDataInfo = this.iDEHelper.GetDataInfo(dataEntity);
        boolean bFirst = true;
        StringBuilderEx info = new StringBuilderEx();
        if (!StringHelper.IsNullOrEmpty((String)strAuditInfo)) {
            info.Append(strAuditInfo);
            bFirst = false;
        }
        Vector<DataAuditDetail> dataAuditDetails = null;
        if (lastDataEntity != null) {
            for (IDEFHelper iDEFHelper : this.iDEHelper.GetDEFHelpers()) {
                if (!iDEFHelper.IsEnableAudit()) continue;
                Object objNewValue = dataEntity.GetParamValue(iDEFHelper.getName());
                Object objOldValue = lastDataEntity.GetParamValue(iDEFHelper.getName());
                if (objNewValue == null && objOldValue == null || objNewValue != null && objOldValue != null && DataTypeParse.Compare((String)iDEFHelper.GetStdDataType(), (Object)objNewValue, (Object)objOldValue) == 0L) continue;
                String strNewValueText = "";
                String strOldValueText = "";
                if (iDEFHelper instanceof IPickupDEFHelper) {
                    IPickupDEFHelper pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
                    if (dataEntity != null) {
                        strNewValueText = dataEntity.GetParamStringValue(pickupDEFHelper.GetPickupTextDEFHelper().getName(), "");
                    }
                    if (lastDataEntity != null) {
                        strOldValueText = lastDataEntity.GetParamStringValue(pickupDEFHelper.GetPickupTextDEFHelper().getName(), "");
                    }
                } else {
                    CodeListConfig codeListConfig = null;
                    String strCodeList = iDEFHelper.GetCodeList();
                    if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
                        codeListConfig = this.contextHelperEx.getCodeListMgr().GetCodeListConfig(strCodeList);
                        if (objNewValue != null && codeListConfig != null) {
                            strNewValueText = codeListConfig.GetCodeListValueWithStyle(objNewValue.toString(), true);
                        }
                        if (objOldValue != null && codeListConfig != null) {
                            strOldValueText = codeListConfig.GetCodeListValueWithStyle(objOldValue.toString(), true);
                        }
                    } else {
                        String strItemFormat = iDEFHelper.GetFormCtrl().GetItemFormat();
                        if (StringHelper.IsNullOrEmpty((String)strItemFormat)) {
                            strItemFormat = "%1$s";
                        }
                        if (objNewValue != null) {
                            strNewValueText = StringHelper.Format((String)strItemFormat, (Object)objNewValue);
                        }
                        if (objOldValue != null) {
                            strOldValueText = StringHelper.Format((String)strItemFormat, (Object)objOldValue);
                        }
                    }
                    if (this.iDEHelper.IsLogAuditDetail()) {
                        DataAuditDetail dataAuditDetail = new DataAuditDetail();
                        dataAuditDetail.setDATAAUDITDETAILNAME(iDEFHelper.getName());
                        if (objOldValue != null) {
                            dataAuditDetail.setOLDVALUE(objOldValue.toString());
                        }
                        if (objNewValue != null) {
                            dataAuditDetail.setNEWVALUE(objNewValue.toString());
                        }
                        dataAuditDetail.setOLDTEXT(strOldValueText);
                        dataAuditDetail.setNEWTEXT(strNewValueText);
                        if (dataAuditDetails == null) {
                            dataAuditDetails = new Vector<DataAuditDetail>();
                        }
                        dataAuditDetails.add(dataAuditDetail);
                    }
                }
                if (bFirst) {
                    bFirst = false;
                } else {
                    info.Append("\r\n");
                }
                String strAuditInfoFormat = iDEFHelper.GetAuditInfoFormat();
                info.Append(strAuditInfoFormat, (Object)iDEFHelper.getLogicName(""), (Object)strOldValueText, (Object)strNewValueText);
            }
        }
        DataAudit dataAudit = new DataAudit();
        dataAudit.SetParamValue("SRF_CHECKKEY", 0);
        if (dataAuditDetails == null) {
            dataAudit.SetParamValue("SRF_RETDATA", 0);
        }
        dataAudit.setOPPERSONID(strOpPersonId);
        dataAudit.setIPADDRESS(strFromIpAddress);
        dataAudit.setOBJECTTYPE(this.iDEHelper.getId());
        dataAudit.setOBJECTID(dataEntity.GetParamStringValue(this.iDEHelper.GetKeyDEFHelper().getName(), ""));
        dataAudit.setAUDITINFO(info.toString());
        dataAudit.setAUDITTYPE(strAction);
        dataAudit.setDATAAUDITNAME(StringHelper.Format((String)"[ %1$s ] %2$s", (Object)strAction, (Object)strDataInfo));
        IDEDataCtrl auditDataCtrl = this.contextHelperEx.getDAModelStorage().FindDEDataCtrl("DE0060", "SYSTEM", null);
        if (auditDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5ba1\u8ba1\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            return callResult;
        }
        if (iTransactionMgr != null) {
            iTransactionMgr.Register(auditDataCtrl);
        }
        if ((callResult = auditDataCtrl.Save(true, dataAudit)).getRetCode() != 0) {
            return callResult;
        }
        if (dataAuditDetails != null) {
            IDEDataCtrl auditDetailDataCtrl = this.contextHelperEx.getDAModelStorage().FindDEDataCtrl("DE0107", "SYSTEM", null);
            if (auditDetailDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5ba1\u8ba1\u660e\u7ec6\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
                return callResult;
            }
            if (iTransactionMgr != null) {
                iTransactionMgr.Register(auditDetailDataCtrl);
            }
            for (DataAuditDetail dataAuditDetail : dataAuditDetails) {
                dataAuditDetail.setDATAAUDITID(dataAudit.getDATAAUDITID());
                dataAuditDetail.SetParamValue("SRF_CHECKKEY", 0);
                dataAuditDetail.SetParamValue("SRF_RETDATA", 0);
                callResult = auditDetailDataCtrl.Save(true, dataAuditDetail);
                if (callResult.getRetCode() == 0) continue;
                return callResult;
            }
        }
        if (!this.bMajorDE) {
            BaseDataEntity temp = new BaseDataEntity();
            temp.SetParamValue(iMajorDEHelper.GetKeyDEFHelper().getName(), dataEntity.GetParamValue(this.iDEHelper.GetMajorDEPickupField()));
            IDEDataCtrl iMajorDEDataCtrl = iMajorDEHelper.GetDEDataCtrl("SYSTEM", null);
            if (iMajorDEDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)iMajorDEHelper.getId()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (iTransactionMgr != null) {
                iTransactionMgr.Register(iMajorDEDataCtrl);
            }
            if ((callResult = iMajorDEDataCtrl.Get(temp)).getRetCode() != 0) {
                return callResult;
            }
            return iMajorDEHelper.GetDataAccHelper().Audit(StringHelper.Format((String)"[ %1$s ] %2$s", (Object)strAction, (Object)strDataInfo), iTransactionMgr, strOpPersonId, strFromIpAddress, temp, null, "UPDATE");
        }
        return callResult;
    }

    @Override
    public String GetDataActions() {
        return this.strDataActions;
    }

    protected boolean isMultiMajorDEMode() {
        return this.bMultiMajorDEMode;
    }

    protected CallResult GetCurDataEntity(BaseDataEntity dataEntity, String strCurPersonId) {
        CallResult callResult = new CallResult();
        BaseDataEntity curDataEntity = new BaseDataEntity();
        dataEntity.CopyTo(curDataEntity, true);
        String strValue = dataEntity.GetParamStringValue(this.iDEHelper.GetKeyDEFHelper().getName(), "");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            strValue = dataEntity.GetParamStringValue("SRFDATEMPKEYID", "");
        }
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
            return callResult;
        }
        if (KeyHelper.IsTempKey(strValue)) {
            callResult.setUserObject((Object)curDataEntity);
            return callResult;
        }
        callResult = this.iDEHelper.GetDEDataCtrl(strCurPersonId, null).Get(curDataEntity);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject((Object)curDataEntity);
        return callResult;
    }
}

