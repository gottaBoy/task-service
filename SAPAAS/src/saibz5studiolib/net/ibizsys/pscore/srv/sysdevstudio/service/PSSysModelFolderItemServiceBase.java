/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysModelFolderItemDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelFolderItemDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolder;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderItem;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelFolderItemServiceBase
extends PSCoreSysServiceBase<PSSysModelFolderItem> {
    private static final Log log = LogFactory.getLog(PSSysModelFolderItemServiceBase.class);
    public static final String DATASET_CURUSER = "CurUser";
    public static final String DATASET_CURUSER2 = "CurUser2";
    public static final String DATASET_CURUSER3 = "CurUser3";
    public static final String DATASET_CURUSERALL = "CurUserAll";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysModelFolderItemDEModel pSSysModelFolderItemDEModel;
    private PSSysModelFolderItemDAO pSSysModelFolderItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderItemService";
    }

    public PSSysModelFolderItemDEModel getPSSysModelFolderItemDEModel() {
        if (this.pSSysModelFolderItemDEModel == null) {
            try {
                this.pSSysModelFolderItemDEModel = (PSSysModelFolderItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelFolderItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFolderItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelFolderItemDEModel();
    }

    public PSSysModelFolderItemDAO getPSSysModelFolderItemDAO() {
        if (this.pSSysModelFolderItemDAO == null) {
            try {
                this.pSSysModelFolderItemDAO = (PSSysModelFolderItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysModelFolderItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFolderItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelFolderItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER, (boolean)true) == 0) {
            return this.fetchCurUser(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER2, (boolean)true) == 0) {
            return this.fetchCurUser2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER3, (boolean)true) == 0) {
            return this.fetchCurUser3(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERALL, (boolean)true) == 0) {
            return this.fetchCurUserAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurUser(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER3, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysModelFolderItem pSSysModelFolderItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderService", (SessionFactory)this.getSessionFactory());
            PSSysModelFolder pSSysModelFolder = (PSSysModelFolder)iService.getDEModel().createEntity();
            pSSysModelFolder.set("PSSYSMODELFOLDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysModelFolder);
            } else {
                iService.get(pSSysModelFolder);
            }
            this.onFillParentInfo_PSSysModelFolder(pSSysModelFolderItem, pSSysModelFolder);
            return;
        }
        super.onFillParentInfo(pSSysModelFolderItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysModelFolder(PSSysModelFolderItem pSSysModelFolderItem, PSSysModelFolder pSSysModelFolder) throws Exception {
        pSSysModelFolderItem.setPSSysModelFolderId(pSSysModelFolder.getPSSysModelFolderId());
        pSSysModelFolderItem.setPSSysModelFolderName(pSSysModelFolder.getPSSysModelFolderName());
    }

    protected void onFillEntityFullInfo(PSSysModelFolderItem pSSysModelFolderItem, boolean bl) throws Exception {
        if (bl && pSSysModelFolderItem.getAllUserFlag() == null) {
            pSSysModelFolderItem.setAllUserFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysModelFolderItem, bl);
        this.onFillEntityFullInfo_PSSysModelFolder(pSSysModelFolderItem, bl);
    }

    protected void onFillEntityFullInfo_PSSysModelFolder(PSSysModelFolderItem pSSysModelFolderItem, boolean bl) throws Exception {
        if (pSSysModelFolderItem.isPSSysModelFolderIdDirty()) {
            if (pSSysModelFolderItem.getPSSysModelFolderId() != null) {
                if (pSSysModelFolderItem.getPSSysModelFolderId() == null || pSSysModelFolderItem.getPSSysModelFolderName() == null) {
                    PSSysModelFolder pSSysModelFolder = pSSysModelFolderItem.getPSSysModelFolder();
                    pSSysModelFolderItem.setPSSysModelFolderName(pSSysModelFolder.getPSSysModelFolderName());
                }
            } else {
                pSSysModelFolderItem.setPSSysModelFolderName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysModelFolderItem pSSysModelFolderItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysModelFolderItem, bl);
    }

    public ArrayList<PSSysModelFolderItem> selectByPSSysModelFolder(PSSysModelFolderBase pSSysModelFolderBase) throws Exception {
        return this.selectByPSSysModelFolder(pSSysModelFolderBase, "", -1);
    }

    public ArrayList<PSSysModelFolderItem> selectByPSSysModelFolder(PSSysModelFolderBase pSSysModelFolderBase, String string) throws Exception {
        return this.selectByPSSysModelFolder(pSSysModelFolderBase, string, -1);
    }

    public ArrayList<PSSysModelFolderItem> selectByPSSysModelFolder(PSSysModelFolderBase pSSysModelFolderBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELFOLDERID", (Object)pSSysModelFolderBase.getPSSysModelFolderId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelFolderCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelFolderCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
        ArrayList<PSSysModelFolderItem> arrayList = this.selectByPSSysModelFolder(pSSysModelFolder, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELFOLDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysModelFolder);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID", "", iDataEntityModel.getName(), "PSSYSMODELFOLDERITEM", iDataEntityModel.getDataInfo(pSSysModelFolder), arrayList.get(0)));
        }
    }

    public void resetPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
        ArrayList<PSSysModelFolderItem> arrayList = this.selectByPSSysModelFolder(pSSysModelFolder);
        for (PSSysModelFolderItem pSSysModelFolderItem : arrayList) {
            PSSysModelFolderItem pSSysModelFolderItem2 = (PSSysModelFolderItem)this.getDEModel().createEntity();
            pSSysModelFolderItem2.setPSSysModelFolderItemId(pSSysModelFolderItem.getPSSysModelFolderItemId());
            pSSysModelFolderItem2.setPSSysModelFolderId(null);
            this.update(pSSysModelFolderItem2);
        }
    }

    public void removeByPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
        final PSSysModelFolder pSSysModelFolder2 = pSSysModelFolder;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelFolderItemServiceBase.this.onBeforeRemoveByPSSysModelFolder(pSSysModelFolder2);
                PSSysModelFolderItemServiceBase.this.internalRemoveByPSSysModelFolder(pSSysModelFolder2);
                PSSysModelFolderItemServiceBase.this.onAfterRemoveByPSSysModelFolder(pSSysModelFolder2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
    }

    protected void internalRemoveByPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
        ArrayList<PSSysModelFolderItem> arrayList = this.selectByPSSysModelFolder(pSSysModelFolder);
        this.onBeforeRemoveByPSSysModelFolder(pSSysModelFolder, arrayList);
        for (PSSysModelFolderItem pSSysModelFolderItem : arrayList) {
            this.remove(pSSysModelFolderItem);
        }
        this.onAfterRemoveByPSSysModelFolder(pSSysModelFolder, arrayList);
    }

    protected void onAfterRemoveByPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelFolder(PSSysModelFolder pSSysModelFolder, ArrayList<PSSysModelFolderItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelFolder(PSSysModelFolder pSSysModelFolder, ArrayList<PSSysModelFolderItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelFolderItem pSSysModelFolderItem) throws Exception {
        super.onBeforeRemove(pSSysModelFolderItem);
    }

    protected void replaceParentInfo(PSSysModelFolderItem pSSysModelFolderItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysModelFolderItem, cloneSession);
        if (pSSysModelFolderItem.getPSSysModelFolderId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELFOLDER", (Object)pSSysModelFolderItem.getPSSysModelFolderId())) != null) {
            this.onFillParentInfo_PSSysModelFolder(pSSysModelFolderItem, (PSSysModelFolder)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelFolderItem pSSysModelFolderItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysModelFolderItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllUserFlag(bl, pSSysModelFolderItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconCls(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam2(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjId(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjName(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjType(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjTypeName(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFolderId(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFolderItemId(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFolderItemName(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFolderName(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioTag(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioTag2(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioType(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysModelFolderItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysModelFolderItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllUserFlag(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isAllUserFlagDirty() && !bl2 : !pSSysModelFolderItem.isAllUserFlagDirty()) {
            return null;
        }
        Integer n = pSSysModelFolderItem.getAllUserFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLUSERFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllUserFlag_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLUSERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isDataDirty() : !pSSysModelFolderItem.isDataDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconCls(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isIconClsDirty() : !pSSysModelFolderItem.isIconClsDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getIconCls();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconCls_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONCLS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isItemParamDirty() : !pSSysModelFolderItem.isItemParamDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getItemParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParam_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam2(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isItemParam2Dirty() : !pSSysModelFolderItem.isItemParam2Dirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getItemParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParam2_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isMemoDirty() : !pSSysModelFolderItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysModelFolderItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isOrderValueDirty() : !pSSysModelFolderItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysModelFolderItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjId(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isPSObjIdDirty() : !pSSysModelFolderItem.isPSObjIdDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getPSObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjId_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjName(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isPSObjNameDirty() : !pSSysModelFolderItem.isPSObjNameDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getPSObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjName_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjType(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isPSObjTypeDirty() && !bl2 : !pSSysModelFolderItem.isPSObjTypeDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getPSObjType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjType_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjTypeName(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isPSObjTypeNameDirty() : !pSSysModelFolderItem.isPSObjTypeNameDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getPSObjTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjTypeName_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelFolderId(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isPSSysModelFolderIdDirty() && !bl2 : !pSSysModelFolderItem.isPSSysModelFolderIdDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getPSSysModelFolderId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFolderId_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelFolderItemId(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isPSSysModelFolderItemIdDirty() && !bl2 : !pSSysModelFolderItem.isPSSysModelFolderItemIdDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getPSSysModelFolderItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFolderItemId_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelFolderItemName(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isPSSysModelFolderItemNameDirty() && !bl2 : !pSSysModelFolderItem.isPSSysModelFolderItemNameDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getPSSysModelFolderItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFolderItemName_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSMODELFOLDERID";
                String string4 = this.checkFieldDupRule(this.getPSSysModelFolderItemDEModel(), "PSSYSMODELFOLDERITEMNAME", string3, pSSysModelFolderItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSMODELFOLDERITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelFolderName(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isPSSysModelFolderNameDirty() : !pSSysModelFolderItem.isPSSysModelFolderNameDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getPSSysModelFolderName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFolderName_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioTag(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isStudioTagDirty() : !pSSysModelFolderItem.isStudioTagDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getStudioTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioTag_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioTag2(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isStudioTag2Dirty() : !pSSysModelFolderItem.isStudioTag2Dirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getStudioTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioTag2_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioType(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isStudioTypeDirty() : !pSSysModelFolderItem.isStudioTypeDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getStudioType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioType_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isUserTagDirty() : !pSSysModelFolderItem.isUserTagDirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysModelFolderItem pSSysModelFolderItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolderItem.isUserTag2Dirty() : !pSSysModelFolderItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysModelFolderItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysModelFolderItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysModelFolderItem pSSysModelFolderItem, boolean bl) throws Exception {
        super.onSyncEntity(pSSysModelFolderItem, bl);
    }

    protected void onSyncIndexEntities(PSSysModelFolderItem pSSysModelFolderItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysModelFolderItem, bl);
    }

    public Object getDataContextValue(PSSysModelFolderItem pSSysModelFolderItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysModelFolderItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysModelFolder pSSysModelFolder = pSSysModelFolderItem.getPSSysModelFolder();
        if (pSSysModelFolder != null && pSSysModelFolder.contains(string)) {
            return pSSysModelFolder.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelFolderItem pSSysModelFolderItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysModelFolderItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLUSERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllUserFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONCLS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconCls_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFOLDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFolderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFOLDERITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFolderItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFOLDERITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFolderItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllUserFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconCls_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONCLS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJTYPENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelFolderId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFOLDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelFolderItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFOLDERITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelFolderItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFOLDERITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldSysValueRule("PSSYSMODELFOLDERITEMNAME", iEntity, bl2, "E0A2B595-89FB-4FE5-B030-67127DAA9614", "\u5185\u5bb9\u4e0d\u5305\u62ec\u4ee5\u4e0b\u5b57\u7b26\uff1a\uff1f\u3001*\u3001\\\u3001<\u3001>\u3001[\u3001]\u3001{\u3001}\u3001:\u3001@\u3001/", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u5305\u62ec\u4ee5\u4e0b\u5b57\u7b26\uff1a\uff1f\u3001*\u3001\\\u3001<\u3001>\u3001[\u3001]\u3001{\u3001}\u3001:\u3001@\u3001/)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelFolderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFOLDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StudioTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StudioTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StudioType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysModelFolderItem pSSysModelFolderItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysModelFolderItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelFolderItem pSSysModelFolderItem) throws Exception {
        super.onUpdateParent(pSSysModelFolderItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelFolderItem pSSysModelFolderItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELFOLDERITEM");
        if (!bl) {
            pSSysModelFolderItem.setCreateDate(null);
            pSSysModelFolderItem.setCreateMan(null);
            pSSysModelFolderItem.setPSSysModelFolderItemId(null);
            pSSysModelFolderItem.setUpdateDate(null);
            pSSysModelFolderItem.setUpdateMan(null);
            super.exportCurXmlModel(pSSysModelFolderItem, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysModelFolderItem pSSysModelFolderItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysModelFolderItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELFOLDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSMODELFOLDER#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELFOLDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELFOLDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELFOLDERNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFOLDER", (boolean)true) == 0) {
            iEntity.set("PSSYSMODELFOLDERID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSMODELFOLDERID"};
    }

    @Override
    public String getModelV2Tag(PSSysModelFolderItem pSSysModelFolderItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysModelFolderItem.getPSSysModelFolderItemName())) {
            return pSSysModelFolderItem.getPSSysModelFolderItemName();
        }
        return super.getModelV2Tag(pSSysModelFolderItem);
    }

    @Override
    public boolean setModelV2Tag(PSSysModelFolderItem pSSysModelFolderItem, String string) {
        pSSysModelFolderItem.setPSSysModelFolderItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSMODELFOLDERITEMNAME", "");
        map.put("PSSYSMODELFOLDERID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysModelFolderItem pSSysModelFolderItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysModelFolderItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysModelFolderItem, true);
        pSSysModelFolderItem.set("PSSYSMODELFOLDERITEMNAME", string);
        if (this.select(pSSysModelFolderItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysModelFolderItem, true);
        return super.getModelV2Entity(pSSysModelFolderItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysModelFolderItem pSSysModelFolderItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysModelFolderItem, objectNode, string, string2, n);
    }
}

