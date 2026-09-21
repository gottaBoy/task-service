/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.security;

import java.util.ArrayList;
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDEFieldDiffItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDER1NModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.entity.IEntityActionSupporter;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.security.IUserRoleMgr2;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DEModelUtil;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.DataAudit;
import net.ibizsys.psrt.srv.common.entity.DataAuditDetail;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.common.service.DataAuditDetailService;
import net.ibizsys.psrt.srv.common.service.DataAuditService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDataAccMgr
implements IDEDataAccMgr {
    private static final Log log = LogFactory.getLog(DEDataAccMgr.class);
    public static final String SYSUNIRES_PREFIX = "SRFUR__";
    public static final int LEN_SYSUNIRES_PREFIX = 7;
    private IDataEntityModel iDEModel = null;
    protected String strDataActions = "";

    @Override
    public void init(IDataEntityModel iDEModel) throws Exception {
        this.iDEModel = iDEModel;
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    protected IDataEntityModel getDEModel() {
        return this.iDEModel;
    }

    @Override
    public CallResult test(IWebContext webContext, IEntity dataEntity, String strAction) throws Exception {
        return this.test(webContext, dataEntity, strAction, false);
    }

    protected CallResult internalTest(IWebContext webContext, String strCurPersonId, IEntity dataEntity, String strAction, boolean bCache) throws Exception {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (StringHelper.isNullOrEmpty(strAction) || StringHelper.compare(strAction, "NONE", true) == 0) {
            return callResult;
        }
        if (StringHelper.compare(strAction, "DENY", true) == 0) {
            callResult.setRetCode(2);
            return callResult;
        }
        if (this.iDEModel.getDataAccCtrlMode() == 0) {
            return callResult;
        }
        strAction = strAction.toUpperCase();
        String strValue = "";
        if (dataEntity != null) {
            strValue = DataObject.getStringValue(dataEntity, this.iDEModel.getKeyDEField().getName(), "");
        }
        if (this.iDEModel.getDataAccCtrlMode() == 2 || this.iDEModel.getDataAccCtrlMode() == 3) {
            String strMajorAction;
            IDER1N iDER1N = this.getDEModel().getAccMasterDER(dataEntity);
            if (iDER1N == null) {
                if (!StringHelper.isNullOrEmpty(strValue) && !KeyValueHelper.isTempKey(strValue)) {
                    dataEntity = this.getFullEntity(webContext, dataEntity, bCache);
                    iDER1N = this.getDEModel().getAccMasterDER(dataEntity);
                }
                if (iDER1N == null) {
                    throw new Exception(webContext.getLocalization("ERROR.STD.NOMAJORDATAENTITY", "\u65e0\u6cd5\u627e\u5230\u6743\u9650\u4e3b\u5b9e\u4f53"));
                }
            }
            if (StringHelper.isNullOrEmpty(strMajorAction = this.getDEModel().getMapDEOPPrivTag(strAction, iDER1N.getName())) && this.iDEModel.getDataAccCtrlMode() == 2) {
                strMajorAction = StringHelper.compare(strAction, "READ", true) == 0 ? "READ" : "UPDATE";
            }
            if (!StringHelper.isNullOrEmpty(strMajorAction)) {
                IDataEntityModel majorDEModel = ((IDER1NModel)iDER1N).getMajorDEModel();
                Object objValue = dataEntity.get(iDER1N.getPickupDEFName());
                return webContext.getUserPrivilegeMgr().testDataAccessAction(webContext, majorDEModel, objValue, strMajorAction);
            }
        }
        if (StringHelper.compare(strAction, "CREATE", true) == 0 || StringHelper.compare(strAction, "UPDATE", true) == 0 && StringHelper.isNullOrEmpty(strValue)) {
            if (webContext.isSuperUser() || webContext.isOrgAdmin()) {
                return callResult;
            }
            return this.testUserRoleDataAction(webContext, dataEntity, strValue, "CREATE");
        }
        if (StringHelper.compare(strAction, "WFSTART", true) == 0 && StringHelper.isNullOrEmpty(strValue)) {
            if (webContext.isSuperUser() || webContext.isOrgAdmin()) {
                return callResult;
            }
            return this.testUserRoleDataAction(webContext, dataEntity, strValue, "WFSTART");
        }
        if (StringHelper.isNullOrEmpty(strValue)) {
            callResult.setRetCode(2);
            callResult.setErrorInfo(webContext.getLocalization("ERROR.STD.SYS.ACCESSDENY", "\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c"));
            return callResult;
        }
        if (KeyValueHelper.isTempKey(strValue)) {
            return callResult;
        }
        if (StringHelper.compare(strAction, "READ", true) != 0) {
            if (StringHelper.compare(strAction, "WFSTART", true) == 0 || strAction.indexOf("WF") != 0) {
                dataEntity = this.getFullEntity(webContext, dataEntity, bCache);
                if (this.getDEModel().testDataInWF(dataEntity) != null) {
                    callResult.setRetCode(2);
                    callResult.setErrorInfo(webContext.getLocalization("ERROR.STD.WF.DATAINPROCESS", "\u6570\u636e\u5728\u6d41\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u8fdb\u884c\u64cd\u4f5c"));
                    return callResult;
                }
            }
            if (this.getDEModel().hasDEMainState()) {
                dataEntity = this.getFullEntity(webContext, dataEntity, bCache);
                IDEMainState iDEMainState = this.getDEModel().getDEMainState(dataEntity);
                if (iDEMainState != null && !iDEMainState.testDEOPPriv(strAction)) {
                    callResult.setRetCode(2);
                    callResult.setErrorInfo(this.getDEModel().getDEMainStateDenyMsg(iDEMainState, dataEntity, 2, strAction));
                    return callResult;
                }
            }
        }
        if (webContext.isSuperUser()) {
            return callResult;
        }
        if (webContext.isOrgAdmin()) {
            dataEntity = this.getFullEntity(webContext, dataEntity, bCache);
            Object objOrgId = this.getDEModel().getOrgId(dataEntity);
            if (objOrgId != null && StringHelper.compare(objOrgId.toString(), webContext.getCurOrgId(), false) == 0) {
                return callResult;
            }
        }
        return this.testUserRoleDataAction(webContext, dataEntity, strValue, strAction);
    }

    @Override
    public void audit(String strAuditInfo, IWebContext webContext, IEntity dataEntity, IEntity lastDataEntity, String strAction) throws Exception {
        if (webContext != null) {
            this.audit(strAuditInfo, webContext.getCurUserId(), webContext.getCurUserName(), webContext.getRemoteAddr(), dataEntity, lastDataEntity, strAction);
            return;
        }
        if (ActionContext.getCurrent() != null) {
            IActionContext iActionContext = ActionContext.getCurrent();
            this.audit(strAuditInfo, iActionContext.getOperator(), iActionContext.getOperatorName(), iActionContext.getRemoteAddr(), dataEntity, lastDataEntity, strAction);
            return;
        }
        this.audit(strAuditInfo, "", "", "", dataEntity, lastDataEntity, strAction);
    }

    @Override
    public void audit(String strAuditInfo, String strOpPersonId, String strOpPersonName, String strFromIpAddress, IEntity dataEntity, IEntity lastDataEntity, String strAction) throws Exception {
        IService<DataAuditDetail> dataAuditDetailService;
        IDataEntityModel majorDEModel = null;
        String strMajorDEPickupField = "";
        if (this.iDEModel.getDataAccCtrlMode() == 2 || this.iDEModel.getDataAccCtrlMode() == 3) {
            IDER1N iDER1N = this.getDEModel().getAccMasterDER(dataEntity);
            if (iDER1N == null) {
                throw new Exception(WebContext.getCurrent().getLocalization("ERROR.STD.NOMAJORDATAENTITY", "\u65e0\u6cd5\u627e\u5230\u6743\u9650\u4e3b\u5b9e\u4f53"));
            }
            strMajorDEPickupField = iDER1N.getPickupDEFName();
            majorDEModel = ((IDER1NModel)iDER1N).getMajorDEModel();
        }
        if (!this.iDEModel.isEnableAudit()) {
            if (majorDEModel == null) {
                return;
            }
            if (!majorDEModel.isEnableAudit()) {
                return;
            }
        }
        String strDataInfo = this.iDEModel.getDataInfo(dataEntity);
        boolean bFirst = true;
        StringBuilderEx info = new StringBuilderEx();
        if (!StringHelper.isNullOrEmpty(strAuditInfo)) {
            info.append(strAuditInfo);
            bFirst = false;
        }
        ArrayList<IDEFieldDiffItem> deFieldDiffItemList = null;
        if (lastDataEntity != null) {
            deFieldDiffItemList = DEModelUtil.getDEDataDiffItems(this.getDEModel(), dataEntity, lastDataEntity, true);
            for (IDEFieldDiffItem iDEFieldDiffItem : deFieldDiffItemList) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    info.append("\r\n");
                }
                String strAuditInfoFormat = iDEFieldDiffItem.getDEField().getAuditInfoFormat();
                info.append(strAuditInfoFormat, iDEFieldDiffItem.getDEField().getLogicName(""), iDEFieldDiffItem.getOldText(), iDEFieldDiffItem.getNewText());
            }
        }
        if (StringHelper.isNullOrEmpty(this.getDEModel().getAuditDEName())) {
            DataAudit dataAudit = new DataAudit();
            dataAudit.setDataAuditId(KeyValueHelper.genGuidEx());
            dataAudit.setOpPersonId(strOpPersonId);
            dataAudit.setOpPersonName(strOpPersonName);
            dataAudit.setIPAddress(strFromIpAddress);
            dataAudit.setObjectType(this.iDEModel.getId());
            dataAudit.setObjectId(DataObject.getStringValue(dataEntity, this.iDEModel.getKeyDEField().getName(), ""));
            dataAudit.setAuditInfo(info.toString());
            dataAudit.setAuditType(strAction);
            dataAudit.setDataAuditName(StringHelper.format("[%1$s]%2$s", strAction, strDataInfo));
            EntityBase.setIgnoreCheckKey(dataAudit, false);
            DataAuditService dataAuditService = (DataAuditService)ServiceGlobal.getService(DataAuditService.class);
            dataAuditService.create(dataAudit, false);
            if (this.getDEModel().isLogAuditDetail() && deFieldDiffItemList != null) {
                dataAuditDetailService = (DataAuditDetailService)ServiceGlobal.getService(DataAuditDetailService.class);
                for (IDEFieldDiffItem iDEFieldDiffItem : deFieldDiffItemList) {
                    DataAuditDetail dataAuditDetail = new DataAuditDetail();
                    dataAuditDetail.setDataAuditDetailName(iDEFieldDiffItem.getDEField().getName());
                    if (iDEFieldDiffItem.getOldValue() != null) {
                        dataAuditDetail.setOldValue(iDEFieldDiffItem.getOldValue().toString());
                    }
                    if (iDEFieldDiffItem.getNewValue() != null) {
                        dataAuditDetail.setNewValue(iDEFieldDiffItem.getNewValue().toString());
                    }
                    dataAuditDetail.setOldText(iDEFieldDiffItem.getOldText());
                    dataAuditDetail.setNewText(iDEFieldDiffItem.getNewText());
                    dataAuditDetail.setDataAuditId(dataAudit.getDataAuditId());
                    ((ServiceBase)dataAuditDetailService).create(dataAuditDetail, false);
                }
            }
        } else {
            IService dataAuditService = DEModelGlobal.getDEModel(this.getDEModel().getAuditDEName()).getService();
            Object dataAudit = dataAuditService.getDEModel().createEntity();
            dataAudit.set(dataAuditService.getDEModel().getKeyDEField().getName(), KeyValueHelper.genGuidEx());
            dataAudit.set("OPPERSONID", strOpPersonId);
            dataAudit.set("OPPERSONNAME", strOpPersonName);
            dataAudit.set("IPADDRESS", strFromIpAddress);
            dataAudit.set("OBJECTTYPE", this.iDEModel.getId());
            dataAudit.set("OBJECTID", DataObject.getStringValue(dataEntity, this.iDEModel.getKeyDEField().getName(), ""));
            dataAudit.set("AUDITINFO", info.toString());
            dataAudit.set("AUDITTYPE", strAction);
            dataAudit.set(dataAuditService.getDEModel().getMajorDEField().getName(), StringHelper.format("[%1$s]%2$s", strAction, strDataInfo));
            EntityBase.setIgnoreCheckKey(dataAudit, false);
            dataAuditService.create(dataAudit, false);
            if (this.getDEModel().isLogAuditDetail() && deFieldDiffItemList != null && !StringHelper.isNullOrEmpty(this.getDEModel().getAuditDetailDEName())) {
                dataAuditDetailService = DEModelGlobal.getDEModel(this.getDEModel().getAuditDetailDEName()).getService();
                for (IDEFieldDiffItem iDEFieldDiffItem : deFieldDiffItemList) {
                    Object dataAuditDetail = dataAuditDetailService.getDEModel().createEntity();
                    dataAuditDetail.set(dataAuditDetailService.getDEModel().getMajorDEField().getName(), iDEFieldDiffItem.getDEField().getName());
                    if (iDEFieldDiffItem.getOldValue() != null) {
                        dataAuditDetail.set("OLDVALUE", iDEFieldDiffItem.getOldValue().toString());
                    }
                    if (iDEFieldDiffItem.getNewValue() != null) {
                        dataAuditDetail.set("NEWVALUE", iDEFieldDiffItem.getNewValue().toString());
                    }
                    dataAuditDetail.set("OLDTEXT", iDEFieldDiffItem.getOldText());
                    dataAuditDetail.set("NEWTEXT", iDEFieldDiffItem.getNewText());
                    dataAuditDetail.set(dataAuditService.getDEModel().getKeyDEField().getName(), dataAudit.get(dataAuditService.getDEModel().getKeyDEField().getName()));
                    dataAuditDetailService.create((DataAuditDetail)dataAuditDetail, false);
                }
            }
        }
        if (majorDEModel != null) {
            Object temp = majorDEModel.createEntity();
            temp.set(majorDEModel.getKeyDEField().getName(), dataEntity.get(strMajorDEPickupField));
            majorDEModel.getService().get(temp);
            majorDEModel.getDEDataAccMgr().audit(StringHelper.format("[%1$s]%2$s", strAction, strDataInfo), strOpPersonId, strOpPersonName, strFromIpAddress, (IEntity)temp, null, "UPDATE");
        }
    }

    public String getDataActions() {
        return this.strDataActions;
    }

    protected IService getService() throws Exception {
        return this.getDEModel().getService();
    }

    @Override
    public CallResult test(IWebContext webContext, Object objKey, String strAction) throws Exception {
        return this.test(webContext, objKey, strAction, false);
    }

    protected IEntity getFullEntity(IWebContext webContext, IEntity iEntity, boolean bCache) throws Exception {
        Object objRet;
        if (iEntity.isFullEntity()) {
            return iEntity;
        }
        if (iEntity instanceof IEntityActionSupporter && ((IEntityActionSupporter)((Object)iEntity)).getActionHelper() != null) {
            ((IEntityActionSupporter)((Object)iEntity)).get();
            return iEntity;
        }
        String strKeyTag = null;
        if (bCache && (objRet = webContext.getAttribute(strKeyTag = StringHelper.format("%1$s_%2$s", this, iEntity.get(this.getDEModel().getKeyDEField().getName())))) != null) {
            IEntity fullEntity = (IEntity)objRet;
            fullEntity.copyTo(iEntity, true);
            return iEntity;
        }
        this.getDEModel().getService().executeAction("GET", iEntity);
        if (bCache) {
            Object fullEntity = this.getDEModel().createEntity();
            iEntity.copyTo((IDataObject)fullEntity, false);
            webContext.setAttribute(strKeyTag, fullEntity);
        }
        return iEntity;
    }

    protected IEntity getFullEntity2(IWebContext webContext, IEntity iEntity, boolean bCache) throws Exception {
        Object objRet;
        if (iEntity.isFullEntity()) {
            return iEntity;
        }
        String strKeyTag = null;
        if (bCache && (objRet = webContext.getAttribute(strKeyTag = StringHelper.format("%1$s_%2$s", this, iEntity.get(this.getDEModel().getKeyDEField().getName())))) != null) {
            IEntity fullEntity = (IEntity)objRet;
            fullEntity.copyTo(iEntity, true);
            return iEntity;
        }
        this.getDEModel().getService().executeAction("GET", iEntity);
        if (bCache) {
            Object fullEntity = this.getDEModel().createEntity();
            iEntity.copyTo((IDataObject)fullEntity, false);
            webContext.setAttribute(strKeyTag, fullEntity);
        }
        return iEntity;
    }

    @Override
    public CallResult test(IWebContext webContext, Object objKey, String strAction, boolean bCache) throws Exception {
        Object objRet;
        if (StringHelper.isNullOrEmpty(strAction) || StringHelper.compare(strAction, "NONE", true) == 0) {
            return new CallResult();
        }
        if (StringHelper.compare(strAction, "DENY", true) == 0) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(2);
            return callResult;
        }
        if (strAction.indexOf(SYSUNIRES_PREFIX) == 0 && !webContext.getUserPrivilegeMgr().test(webContext, strAction.substring(7))) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(2);
            return callResult;
        }
        String strKeyTag = null;
        if (bCache && (objRet = webContext.getAttribute(strKeyTag = StringHelper.format("%1$s_%2$s_%3$s", this, objKey, strAction))) != null && objRet instanceof CallResult) {
            CallResult callResult = new CallResult();
            callResult.from((CallResult)objRet);
            return callResult;
        }
        Object iEntity = this.getDEModel().createEntity();
        iEntity.set(this.getDEModel().getKeyDEField().getName(), objKey);
        return this.test(webContext, (IEntity)iEntity, strAction, bCache);
    }

    @Override
    public CallResult test(IWebContext webContext, IEntity dataEntity, String strAction, boolean bCache) throws Exception {
        Object objRet;
        if (StringHelper.isNullOrEmpty(strAction) || StringHelper.compare(strAction, "NONE", true) == 0) {
            return new CallResult();
        }
        if (StringHelper.compare(strAction, "DENY", true) == 0) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(2);
            return callResult;
        }
        if (strAction.indexOf(SYSUNIRES_PREFIX) == 0) {
            if (!webContext.getUserPrivilegeMgr().test(webContext, strAction.substring(7))) {
                CallResult callResult = new CallResult();
                callResult.setRetCode(2);
                return callResult;
            }
            return new CallResult();
        }
        String strKeyTag = null;
        if (bCache && (objRet = webContext.getAttribute(strKeyTag = StringHelper.format("%1$s_%2$s_%3$s", this, dataEntity.get(this.getDEModel().getKeyDEField().getName()), strAction))) != null && objRet instanceof CallResult) {
            CallResult callResult = new CallResult();
            callResult.from((CallResult)objRet);
            return callResult;
        }
        CallResult ret = null;
        if (dataEntity != null) {
            if (dataEntity.isFullEntity()) {
                ret = this.internalTest(webContext, webContext.getCurUserId(), dataEntity, strAction, bCache);
            } else if (dataEntity instanceof IEntityActionSupporter) {
                IEntityActionSupporter iEntityActionSupporter = (IEntityActionSupporter)((Object)dataEntity);
                IEntityActionHelper lastEntityActionHelper = iEntityActionSupporter.getActionHelper();
                final IWebContext iWebContext = webContext;
                final boolean bCache2 = bCache;
                iEntityActionSupporter.setActionHelper(new getFullEntityActionHelper(this){

                    @Override
                    public boolean get(IEntity iEntity, boolean bTryMode) throws Exception {
                        this.getFullEntity2(iWebContext, iEntity, bCache2);
                        return true;
                    }
                });
                ret = this.internalTest(webContext, webContext.getCurUserId(), dataEntity, strAction, bCache);
                iEntityActionSupporter.setActionHelper(lastEntityActionHelper);
            } else {
                ret = this.internalTest(webContext, webContext.getCurUserId(), dataEntity, strAction, bCache);
            }
        } else {
            ret = this.internalTest(webContext, webContext.getCurUserId(), dataEntity, strAction, bCache);
        }
        if (bCache) {
            CallResult callResult = new CallResult();
            callResult.from(ret);
            webContext.setAttribute(strKeyTag, callResult);
        }
        return ret;
    }

    protected CallResult testUserRoleDataAction(IWebContext webContext, IEntity dataEntity, String strKeyValue, String strAction) throws Exception {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (this.getDEModel().getDataAccCtrlArch() == 1) {
            IUserRoleMgr iUserRoleMgr = webContext.getUserRoleMgr();
            if (StringHelper.compare(strAction, "CREATE", true) == 0 || StringHelper.compare(strAction, "WFSTART", true) == 0) {
                callResult.setRetCode(iUserRoleMgr.testUserRoleDataAction(this.getDEModel(), dataEntity, strAction) ? 0 : 2);
                return callResult;
            }
            ArrayList<UserRoleData> list = iUserRoleMgr.getUserRoleDatas(this.getDEModel().getId(), strAction);
            if (list != null) {
                ArrayList<String> condList = new ArrayList<String>();
                for (UserRoleData userRoleData : list) {
                    String strCode = iUserRoleMgr.getUserRoleDataCond(this.getService(), userRoleData);
                    if (StringHelper.isNullOrEmpty(strCode)) continue;
                    condList.add(strCode);
                }
                if (condList.size() == 0) {
                    callResult.setRetCode(2);
                    return callResult;
                }
                boolean bOk = false;
                IDEField orgIdDEField = this.getDEModel().getDEFieldByPDT("ORGID", true);
                IDEField secIdDEField = this.getDEModel().getDEFieldByPDT("ORGSECTORID", true);
                DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
                deDataSetFetchContextImpl.setStartRow(0);
                deDataSetFetchContextImpl.setPageSize(1);
                DEDataSetFetchContext.enableOrgDRCond(deDataSetFetchContextImpl, orgIdDEField, secIdDEField, condList);
                DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("DEFIELD");
                deDataSetCondImpl.setCondOp("EQ");
                deDataSetCondImpl.setDEFName(this.getDEModel().getKeyDEField().getName());
                deDataSetCondImpl.setCondValue(strKeyValue);
                deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);
                deDataSetFetchContextImpl.setFetchTotalRow(false);
                long nBeginTime = System.currentTimeMillis();
                try {
                    SessionFactoryManager.addRef();
                    DBFetchResult fetchResult = this.getService().getDAO().fetchDEDataQuery(deDataSetFetchContextImpl, "DEFAULT", false);
                    if (fetchResult.getDataSet().getDataTable(0).getCachedRowCount() == -1) {
                        fetchResult.getDataSet().cacheDataRow();
                    }
                    if (fetchResult.getDataSet().getDataTable(0).getCachedRowCount() > 0) {
                        bOk = true;
                    }
                    fetchResult.getDataSet().close();
                    if (!bOk) {
                        callResult.setRetCode(2);
                    }
                    long nTime = System.currentTimeMillis() - nBeginTime;
                    log.debug((Object)StringHelper.format("\u67e5\u8be2\u8017\u65f6[%1$s]", nTime));
                    SessionFactoryManager.releaseRef(false);
                    return callResult;
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.format("\u5b9e\u4f53[%1$s]\u6743\u9650\u68c0\u67e5\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%2$s", this.getDEModel().getName(), ex.getMessage()), (Throwable)ex);
                    SessionFactoryManager.releaseRef(false);
                    throw ex;
                }
            }
            callResult.setRetCode(2);
            return callResult;
        }
        if (this.getDEModel().getDataAccCtrlArch() == 2) {
            IUserRoleMgr2 iUserRoleMgr2 = WebContext.getUserRoleMgr2(webContext);
            if (StringHelper.compare(strAction, "CREATE", true) == 0 || StringHelper.compare(strAction, "WFSTART", true) == 0) {
                callResult.setRetCode(iUserRoleMgr2.testDEOPPrivRoleAction(webContext, this.getDEModel(), dataEntity, strAction) ? 0 : 2);
                return callResult;
            }
            DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
            String strCode = iUserRoleMgr2.getDEOPPrivRoleCond(this.getService(), strAction, deDataSetFetchContextImpl);
            ArrayList<String> condList = new ArrayList<String>();
            if (!StringHelper.isNullOrEmpty(strCode)) {
                condList.add(strCode);
            }
            if (condList.size() == 0) {
                callResult.setRetCode(2);
                return callResult;
            }
            boolean bOk = false;
            IDEField orgIdDEField = this.getDEModel().getDEFieldByPDT("ORGID", true);
            IDEField secIdDEField = this.getDEModel().getDEFieldByPDT("ORGSECTORID", true);
            deDataSetFetchContextImpl.setStartRow(0);
            deDataSetFetchContextImpl.setPageSize(1);
            DEDataSetFetchContext.enableOrgDRCond(deDataSetFetchContextImpl, orgIdDEField, secIdDEField, condList);
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("DEFIELD");
            deDataSetCondImpl.setCondOp("EQ");
            deDataSetCondImpl.setDEFName(this.getDEModel().getKeyDEField().getName());
            deDataSetCondImpl.setCondValue(strKeyValue);
            deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);
            deDataSetFetchContextImpl.setFetchTotalRow(false);
            long nBeginTime = System.currentTimeMillis();
            try {
                SessionFactoryManager.addRef();
                DBFetchResult fetchResult = this.getService().getDAO().fetchDEDataQuery(deDataSetFetchContextImpl, "DEFAULT", false);
                if (fetchResult.getDataSet().getDataTable(0).getCachedRowCount() == -1) {
                    fetchResult.getDataSet().cacheDataRow();
                }
                if (fetchResult.getDataSet().getDataTable(0).getCachedRowCount() > 0) {
                    bOk = true;
                }
                fetchResult.getDataSet().close();
                if (!bOk) {
                    callResult.setRetCode(2);
                }
                long nTime = System.currentTimeMillis() - nBeginTime;
                log.debug((Object)StringHelper.format("\u67e5\u8be2\u8017\u65f6[%1$s]", nTime));
                SessionFactoryManager.releaseRef(false);
                return callResult;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u5b9e\u4f53[%1$s]\u6743\u9650\u68c0\u67e5\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%2$s", this.getDEModel().getName(), ex.getMessage()), (Throwable)ex);
                SessionFactoryManager.releaseRef(false);
                throw ex;
            }
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb[%1$s]", this.getDEModel().getDataAccCtrlArch()));
    }

    protected abstract class getFullEntityActionHelper
    implements IEntityActionHelper {
        protected getFullEntityActionHelper() {
        }

        @Override
        public void create(IEntity iEntity) throws Exception {
            throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
        }

        @Override
        public void update(IEntity iEntity) throws Exception {
            throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
        }

        @Override
        public void save(IEntity iEntity) throws Exception {
            throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
        }

        @Override
        public void remove(IEntity iEntity) throws Exception {
            throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
        }

        @Override
        public boolean select(IEntity iEntity, boolean bTryMode) throws Exception {
            throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
        }
    }
}

