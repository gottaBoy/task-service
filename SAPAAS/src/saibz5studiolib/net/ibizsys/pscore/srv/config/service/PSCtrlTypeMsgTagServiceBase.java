/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSCtrlTypeMsgTagDAO;
import net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeMsgTagDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlMsgTag;
import net.ibizsys.pscore.srv.config.entity.PSCtrlMsgTagBase;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeMsgTag;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeMsgTagServiceBase
extends PSCoreSysServiceBase<PSCtrlTypeMsgTag> {
    private static final Log log = LogFactory.getLog(PSCtrlTypeMsgTagServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCtrlTypeMsgTagDEModel pSCtrlTypeMsgTagDEModel;
    private PSCtrlTypeMsgTagDAO pSCtrlTypeMsgTagDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSCtrlTypeMsgTagService";
    }

    public PSCtrlTypeMsgTagDEModel getPSCtrlTypeMsgTagDEModel() {
        if (this.pSCtrlTypeMsgTagDEModel == null) {
            try {
                this.pSCtrlTypeMsgTagDEModel = (PSCtrlTypeMsgTagDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeMsgTagDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeMsgTagDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCtrlTypeMsgTagDEModel();
    }

    public PSCtrlTypeMsgTagDAO getPSCtrlTypeMsgTagDAO() {
        if (this.pSCtrlTypeMsgTagDAO == null) {
            try {
                this.pSCtrlTypeMsgTagDAO = (PSCtrlTypeMsgTagDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSCtrlTypeMsgTagDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeMsgTagDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCtrlTypeMsgTagDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLTYPEMSGTAG_PSCTRLMSGTAG_PSCTRLMSGTAGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlMsgTagService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsgTag pSCtrlMsgTag = (PSCtrlMsgTag)iService.getDEModel().createEntity();
            pSCtrlMsgTag.set("PSCTRLMSGTAGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlMsgTag);
            } else {
                iService.get(pSCtrlMsgTag);
            }
            this.onFillParentInfo_PSCtrlMsg(pSCtrlTypeMsgTag, pSCtrlMsgTag);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLTYPEMSGTAG_PSCTRLTYPE_PSCTRLTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeService", (SessionFactory)this.getSessionFactory());
            PSCtrlType pSCtrlType = (PSCtrlType)iService.getDEModel().createEntity();
            pSCtrlType.set("PSCTRLTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlType);
            } else {
                iService.get(pSCtrlType);
            }
            this.onFillParentInfo_PSCtrlType(pSCtrlTypeMsgTag, pSCtrlType);
            return;
        }
        super.onFillParentInfo(pSCtrlTypeMsgTag, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlMsg(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, PSCtrlMsgTag pSCtrlMsgTag) throws Exception {
        pSCtrlTypeMsgTag.setPSCtrlMsgTagId(pSCtrlMsgTag.getPSCtrlMsgTagId());
        pSCtrlTypeMsgTag.setPSCtrlMsgTagName(pSCtrlMsgTag.getPSCtrlMsgTagName());
    }

    protected void onFillParentInfo_PSCtrlType(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, PSCtrlType pSCtrlType) throws Exception {
        pSCtrlTypeMsgTag.setPSCtrlTypeId(pSCtrlType.getPSCtrlTypeId());
        pSCtrlTypeMsgTag.setPSCtrlTypeName(pSCtrlType.getPSCtrlTypeName());
    }

    protected boolean onFillEntityKeyValue(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSCtrlTypeMsgTag.get("PSCTRLTYPEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSCtrlTypeMsgTag.get("PSCTRLMSGTAGID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSCtrlTypeMsgTag.set(this.getPSCtrlTypeMsgTagDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl) throws Exception {
        if (bl && pSCtrlTypeMsgTag.getValidFlag() == null) {
            pSCtrlTypeMsgTag.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSCtrlTypeMsgTag, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSCtrlTypeMsgTag, bl);
        this.onFillEntityFullInfo_PSCtrlType(pSCtrlTypeMsgTag, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlType(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl) throws Exception {
        super.onWriteBackParent(pSCtrlTypeMsgTag, bl);
    }

    public ArrayList<PSCtrlTypeMsgTag> selectByPSCtrlMsg(PSCtrlMsgTagBase pSCtrlMsgTagBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgTagBase, "", -1);
    }

    public ArrayList<PSCtrlTypeMsgTag> selectByPSCtrlMsg(PSCtrlMsgTagBase pSCtrlMsgTagBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgTagBase, string, -1);
    }

    public ArrayList<PSCtrlTypeMsgTag> selectByPSCtrlMsg(PSCtrlMsgTagBase pSCtrlMsgTagBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLMSGTAGID", (Object)pSCtrlMsgTagBase.getPSCtrlMsgTagId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlMsgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlMsgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCtrlTypeMsgTag> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, "", -1);
    }

    public ArrayList<PSCtrlTypeMsgTag> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, string, -1);
    }

    public ArrayList<PSCtrlTypeMsgTag> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLTYPEID", (Object)pSCtrlTypeBase.getPSCtrlTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsgTag pSCtrlMsgTag) throws Exception {
        ArrayList<PSCtrlTypeMsgTag> arrayList = this.selectByPSCtrlMsg(pSCtrlMsgTag, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSGTAG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlMsgTag);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLTYPEMSGTAG_PSCTRLMSGTAG_PSCTRLMSGTAGID", "", iDataEntityModel.getName(), "PSCTRLTYPEMSGTAG", iDataEntityModel.getDataInfo(pSCtrlMsgTag), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsgTag pSCtrlMsgTag) throws Exception {
        ArrayList<PSCtrlTypeMsgTag> arrayList = this.selectByPSCtrlMsg(pSCtrlMsgTag);
        for (PSCtrlTypeMsgTag pSCtrlTypeMsgTag : arrayList) {
            PSCtrlTypeMsgTag pSCtrlTypeMsgTag2 = (PSCtrlTypeMsgTag)this.getDEModel().createEntity();
            pSCtrlTypeMsgTag2.setPSCtrlTypeMsgTagId(pSCtrlTypeMsgTag.getPSCtrlTypeMsgTagId());
            pSCtrlTypeMsgTag2.setPSCtrlMsgTagId(null);
            this.update(pSCtrlTypeMsgTag2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsgTag pSCtrlMsgTag) throws Exception {
        final PSCtrlMsgTag pSCtrlMsgTag2 = pSCtrlMsgTag;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlTypeMsgTagServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsgTag2);
                PSCtrlTypeMsgTagServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsgTag2);
                PSCtrlTypeMsgTagServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsgTag2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsgTag pSCtrlMsgTag) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsgTag pSCtrlMsgTag) throws Exception {
        ArrayList<PSCtrlTypeMsgTag> arrayList = this.selectByPSCtrlMsg(pSCtrlMsgTag);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsgTag, arrayList);
        for (PSCtrlTypeMsgTag pSCtrlTypeMsgTag : arrayList) {
            this.remove(pSCtrlTypeMsgTag);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsgTag, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsgTag pSCtrlMsgTag) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsgTag pSCtrlMsgTag, ArrayList<PSCtrlTypeMsgTag> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsgTag pSCtrlMsgTag, ArrayList<PSCtrlTypeMsgTag> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    public void resetPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSCtrlTypeMsgTag> arrayList = this.selectByPSCtrlType(pSCtrlType);
        for (PSCtrlTypeMsgTag pSCtrlTypeMsgTag : arrayList) {
            PSCtrlTypeMsgTag pSCtrlTypeMsgTag2 = (PSCtrlTypeMsgTag)this.getDEModel().createEntity();
            pSCtrlTypeMsgTag2.setPSCtrlTypeMsgTagId(pSCtrlTypeMsgTag.getPSCtrlTypeMsgTagId());
            pSCtrlTypeMsgTag2.setPSCtrlTypeId(null);
            this.update(pSCtrlTypeMsgTag2);
        }
    }

    public void removeByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        final PSCtrlType pSCtrlType2 = pSCtrlType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlTypeMsgTagServiceBase.this.onBeforeRemoveByPSCtrlType(pSCtrlType2);
                PSCtrlTypeMsgTagServiceBase.this.internalRemoveByPSCtrlType(pSCtrlType2);
                PSCtrlTypeMsgTagServiceBase.this.onAfterRemoveByPSCtrlType(pSCtrlType2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void internalRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSCtrlTypeMsgTag> arrayList = this.selectByPSCtrlType(pSCtrlType);
        this.onBeforeRemoveByPSCtrlType(pSCtrlType, arrayList);
        for (PSCtrlTypeMsgTag pSCtrlTypeMsgTag : arrayList) {
            this.remove(pSCtrlTypeMsgTag);
        }
        this.onAfterRemoveByPSCtrlType(pSCtrlType, arrayList);
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSCtrlTypeMsgTag> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSCtrlTypeMsgTag> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCtrlTypeMsgTag pSCtrlTypeMsgTag) throws Exception {
        super.onBeforeRemove(pSCtrlTypeMsgTag);
    }

    protected void replaceParentInfo(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCtrlTypeMsgTag, cloneSession);
        if (pSCtrlTypeMsgTag.getPSCtrlMsgTagId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSGTAG", (Object)pSCtrlTypeMsgTag.getPSCtrlMsgTagId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSCtrlTypeMsgTag, (PSCtrlMsgTag)iEntity);
        }
        if (pSCtrlTypeMsgTag.getPSCtrlTypeId() != null && (iEntity = cloneSession.getEntity("PSCTRLTYPE", (Object)pSCtrlTypeMsgTag.getPSCtrlTypeId())) != null) {
            this.onFillParentInfo_PSCtrlType(pSCtrlTypeMsgTag, (PSCtrlType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCtrlTypeMsgTag, bl);
    }

    protected void onCheckEntity(boolean bl, PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSCtrlTypeMsgTag, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCtrlTypeMsgTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgTagId(bl, pSCtrlTypeMsgTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeId(bl, pSCtrlTypeMsgTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeMsgTagId(bl, pSCtrlTypeMsgTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeMsgTagName(bl, pSCtrlTypeMsgTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSCtrlTypeMsgTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCtrlTypeMsgTag, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeMsgTag.isContentDirty() : !pSCtrlTypeMsgTag.isContentDirty()) {
            return null;
        }
        String string = pSCtrlTypeMsgTag.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSCtrlTypeMsgTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeMsgTag.isMemoDirty() : !pSCtrlTypeMsgTag.isMemoDirty()) {
            return null;
        }
        String string = pSCtrlTypeMsgTag.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCtrlTypeMsgTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlMsgTagId(boolean bl, PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeMsgTag.isPSCtrlMsgTagIdDirty() && !bl2 : !pSCtrlTypeMsgTag.isPSCtrlMsgTagIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeMsgTag.getPSCtrlMsgTagId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGTAGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgTagId_Default(pSCtrlTypeMsgTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGTAGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeId(boolean bl, PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeMsgTag.isPSCtrlTypeIdDirty() && !bl2 : !pSCtrlTypeMsgTag.isPSCtrlTypeIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeMsgTag.getPSCtrlTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeId_Default(pSCtrlTypeMsgTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeMsgTagId(boolean bl, PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeMsgTag.isPSCtrlTypeMsgTagIdDirty() && !bl2 : !pSCtrlTypeMsgTag.isPSCtrlTypeMsgTagIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeMsgTag.getPSCtrlTypeMsgTagId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEMSGTAGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeMsgTagId_Default(pSCtrlTypeMsgTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEMSGTAGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeMsgTagName(boolean bl, PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeMsgTag.isPSCtrlTypeMsgTagNameDirty() && !bl2 : !pSCtrlTypeMsgTag.isPSCtrlTypeMsgTagNameDirty()) {
            return null;
        }
        String string = pSCtrlTypeMsgTag.getPSCtrlTypeMsgTagName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEMSGTAGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeMsgTagName_Default(pSCtrlTypeMsgTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEMSGTAGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeMsgTag.isValidFlagDirty() && !bl2 : !pSCtrlTypeMsgTag.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSCtrlTypeMsgTag.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSCtrlTypeMsgTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl) throws Exception {
        super.onSyncEntity(pSCtrlTypeMsgTag, bl);
    }

    protected void onSyncIndexEntities(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCtrlTypeMsgTag, bl);
    }

    public Object getDataContextValue(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCtrlTypeMsgTag, string, iDataContextParam)) != null) {
            return object;
        }
        PSCtrlMsgTag pSCtrlMsgTag = pSCtrlTypeMsgTag.getPSCtrlMsg();
        if (pSCtrlMsgTag != null && pSCtrlMsgTag.contains(string)) {
            return pSCtrlMsgTag.get(string);
        }
        PSCtrlType pSCtrlType = pSCtrlTypeMsgTag.getPSCtrlType();
        if (pSCtrlType != null && pSCtrlType.contains(string)) {
            return pSCtrlType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCtrlTypeMsgTag, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGTAGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgTagId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGTAGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgTagName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEMSGTAGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeMsgTagId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEMSGTAGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeMsgTagName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgTagId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGTAGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgTagName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGTAGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeMsgTagId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEMSGTAGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeMsgTagName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEMSGTAGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSCtrlTypeMsgTag pSCtrlTypeMsgTag) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCtrlTypeMsgTag)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCtrlTypeMsgTag pSCtrlTypeMsgTag) throws Exception {
        super.onUpdateParent(pSCtrlTypeMsgTag);
    }

    @Override
    protected void exportCurXmlModel(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCTRLTYPEMSGTAG");
        if (!bl) {
            pSCtrlTypeMsgTag.setCreateDate(null);
            pSCtrlTypeMsgTag.setCreateMan(null);
            pSCtrlTypeMsgTag.setPSCtrlTypeMsgTagId(null);
            pSCtrlTypeMsgTag.setUpdateDate(null);
            pSCtrlTypeMsgTag.setUpdateMan(null);
            super.exportCurXmlModel(pSCtrlTypeMsgTag, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSCtrlTypeMsgTag pSCtrlTypeMsgTag, PSSystem pSSystem) throws Exception {
        PSCtrlTypeMsgTag pSCtrlTypeMsgTag2 = new PSCtrlTypeMsgTag();
        pSCtrlTypeMsgTag2.setPSCtrlTypeId(pSCtrlTypeMsgTag.getPSCtrlTypeId());
        pSCtrlTypeMsgTag2.setPSCtrlMsgTagId(pSCtrlTypeMsgTag.getPSCtrlMsgTagId());
        if (this.selectOne(pSCtrlTypeMsgTag2, true)) {
            return pSCtrlTypeMsgTag2.getPSCtrlTypeMsgTagId();
        }
        return super.getEntityFolderKeyValue(pSCtrlTypeMsgTag, pSSystem);
    }
}

