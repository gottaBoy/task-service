/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.entity.EntityBase
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
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysModelFolderDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelFolderDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolder;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderItem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderItemBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderItemService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderService;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelFolderServiceBase
extends PSCoreSysServiceBase<PSSysModelFolder> {
    private static final Log log = LogFactory.getLog(PSSysModelFolderServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURUSER = "CurUser";
    public static final String DATASET_CURUSER2 = "CurUser2";
    public static final String DATASET_CURUSER3 = "CurUser3";
    public static final String DATASET_CURUSERALL = "CurUserAll";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysModelFolderDEModel pSSysModelFolderDEModel;
    private PSSysModelFolderDAO pSSysModelFolderDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderService";
    }

    public PSSysModelFolderDEModel getPSSysModelFolderDEModel() {
        if (this.pSSysModelFolderDEModel == null) {
            try {
                this.pSSysModelFolderDEModel = (PSSysModelFolderDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelFolderDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFolderDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelFolderDEModel();
    }

    public PSSysModelFolderDAO getPSSysModelFolderDAO() {
        if (this.pSSysModelFolderDAO == null) {
            try {
                this.pSSysModelFolderDAO = (PSSysModelFolderDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysModelFolderDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFolderDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelFolderDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
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

    protected void onFillParentInfo(PSSysModelFolder pSSysModelFolder, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELFOLDER_PSSYSMODELFOLDER_PPSSYSMODELFOLDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderService", (SessionFactory)this.getSessionFactory());
            PSSysModelFolder pSSysModelFolder2 = (PSSysModelFolder)iService.getDEModel().createEntity();
            pSSysModelFolder2.set("PSSYSMODELFOLDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelFolder2);
            } else {
                iService.get((IEntity)pSSysModelFolder2);
            }
            this.onFillParentInfo_PPSSysModelFolder(pSSysModelFolder, pSSysModelFolder2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELFOLDER_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysModelFolder, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysModelFolder, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSSysModelFolder(PSSysModelFolder pSSysModelFolder, PSSysModelFolder pSSysModelFolder2) throws Exception {
        pSSysModelFolder.setPPSSysModelFolderId(pSSysModelFolder2.getPSSysModelFolderId());
        pSSysModelFolder.setPPSSysModelFolderName(pSSysModelFolder2.getPSSysModelFolderName());
    }

    protected void onFillParentInfo_PSSystem(PSSysModelFolder pSSysModelFolder, PSSystem pSSystem) throws Exception {
        pSSysModelFolder.setPSSystemId(pSSystem.getPSSystemId());
        pSSysModelFolder.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysModelFolder pSSysModelFolder, boolean bl) throws Exception {
        if (bl) {
            if (pSSysModelFolder.getAllUserFlag() == null) {
                pSSysModelFolder.setAllUserFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSysModelFolder.getFolderType() == null) {
                pSSysModelFolder.setFolderType((String)this.getDefaultValue(this.getWebContext(), "", "CUSTOM", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysModelFolder, bl);
        this.onFillEntityFullInfo_PPSSysModelFolder(pSSysModelFolder, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysModelFolder, bl);
    }

    protected void onFillEntityFullInfo_PPSSysModelFolder(PSSysModelFolder pSSysModelFolder, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysModelFolder pSSysModelFolder, boolean bl) throws Exception {
        if (pSSysModelFolder.isPSSystemIdDirty()) {
            if (pSSysModelFolder.getPSSystemId() != null) {
                if (pSSysModelFolder.getPSSystemId() == null || pSSysModelFolder.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysModelFolder.getPSSystem();
                    pSSysModelFolder.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysModelFolder.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysModelFolder pSSysModelFolder, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysModelFolder, bl);
    }

    public ArrayList<PSSysModelFolder> selectByPPSSysModelFolder(PSSysModelFolderBase pSSysModelFolderBase) throws Exception {
        return this.selectByPPSSysModelFolder(pSSysModelFolderBase, "", -1);
    }

    public ArrayList<PSSysModelFolder> selectByPPSSysModelFolder(PSSysModelFolderBase pSSysModelFolderBase, String string) throws Exception {
        return this.selectByPPSSysModelFolder(pSSysModelFolderBase, string, -1);
    }

    public ArrayList<PSSysModelFolder> selectByPPSSysModelFolder(PSSysModelFolderBase pSSysModelFolderBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSMODELFOLDERID", (Object)pSSysModelFolderBase.getPSSysModelFolderId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysModelFolderCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysModelFolderCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelFolder> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysModelFolder> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysModelFolder> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
        ArrayList<PSSysModelFolder> arrayList = this.selectByPPSSysModelFolder(pSSysModelFolder, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELFOLDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysModelFolder);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELFOLDER_PSSYSMODELFOLDER_PPSSYSMODELFOLDERID", "", iDataEntityModel.getName(), "PSSYSMODELFOLDER", iDataEntityModel.getDataInfo((IEntity)pSSysModelFolder), arrayList.get(0)));
        }
    }

    public void resetPPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
        ArrayList<PSSysModelFolder> arrayList = this.selectByPPSSysModelFolder(pSSysModelFolder);
        for (PSSysModelFolder pSSysModelFolder2 : arrayList) {
            PSSysModelFolder pSSysModelFolder3 = (PSSysModelFolder)this.getDEModel().createEntity();
            pSSysModelFolder3.setPSSysModelFolderId(pSSysModelFolder2.getPSSysModelFolderId());
            pSSysModelFolder3.setPPSSysModelFolderId(null);
            this.update(pSSysModelFolder3);
        }
    }

    public void removeByPPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
        final PSSysModelFolder pSSysModelFolder2 = pSSysModelFolder;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelFolderServiceBase.this.onBeforeRemoveByPPSSysModelFolder(pSSysModelFolder2);
                PSSysModelFolderServiceBase.this.internalRemoveByPPSSysModelFolder(pSSysModelFolder2);
                PSSysModelFolderServiceBase.this.onAfterRemoveByPPSSysModelFolder(pSSysModelFolder2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
    }

    protected void internalRemoveByPPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
        ArrayList<PSSysModelFolder> arrayList = this.selectByPPSSysModelFolder(pSSysModelFolder);
        this.onBeforeRemoveByPPSSysModelFolder(pSSysModelFolder, arrayList);
        for (PSSysModelFolder pSSysModelFolder2 : arrayList) {
            this.remove((IEntity)pSSysModelFolder2);
        }
        this.onAfterRemoveByPPSSysModelFolder(pSSysModelFolder, arrayList);
    }

    protected void onAfterRemoveByPPSSysModelFolder(PSSysModelFolder pSSysModelFolder) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysModelFolder(PSSysModelFolder pSSysModelFolder, ArrayList<PSSysModelFolder> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysModelFolder(PSSysModelFolder pSSysModelFolder, ArrayList<PSSysModelFolder> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysModelFolder> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELFOLDER_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSMODELFOLDER", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysModelFolder> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysModelFolder pSSysModelFolder : arrayList) {
            PSSysModelFolder pSSysModelFolder2 = (PSSysModelFolder)this.getDEModel().createEntity();
            pSSysModelFolder2.setPSSysModelFolderId(pSSysModelFolder.getPSSysModelFolderId());
            pSSysModelFolder2.setPSSystemId(null);
            this.update(pSSysModelFolder2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelFolderServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysModelFolderServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysModelFolderServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysModelFolder> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysModelFolder pSSysModelFolder : arrayList) {
            this.remove((IEntity)pSSysModelFolder);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysModelFolder> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysModelFolder> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelFolder pSSysModelFolder) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelFolderItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelFolder(pSSysModelFolder);
        pSCoreSysServiceBase = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelFolderServiceBase)pSCoreSysServiceBase).testRemoveByPPSSysModelFolder(pSSysModelFolder);
        super.onBeforeRemove(pSSysModelFolder);
    }

    protected void replaceParentInfo(PSSysModelFolder pSSysModelFolder, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysModelFolder, cloneSession);
        if (pSSysModelFolder.getPPSSysModelFolderId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELFOLDER", (Object)pSSysModelFolder.getPPSSysModelFolderId())) != null) {
            this.onFillParentInfo_PPSSysModelFolder(pSSysModelFolder, (PSSysModelFolder)iEntity);
        }
        if (pSSysModelFolder.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysModelFolder.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysModelFolder, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelFolder pSSysModelFolder, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysModelFolder, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllUserFlag(bl, pSSysModelFolder, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FolderType(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysModelFolderId(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjId(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjName(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjType(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFolderId(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFolderName(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysModelFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysModelFolder, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllUserFlag(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isAllUserFlagDirty() && !bl2 : !pSSysModelFolder.isAllUserFlagDirty()) {
            return null;
        }
        Integer n = pSSysModelFolder.getAllUserFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLUSERFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllUserFlag_Default((IEntity)pSSysModelFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_FolderType(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isFolderTypeDirty() && !bl2 : !pSSysModelFolder.isFolderTypeDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getFolderType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOLDERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FolderType_Default((IEntity)pSSysModelFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOLDERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isMemoDirty() : !pSSysModelFolder.isMemoDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysModelFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isOrderValueDirty() : !pSSysModelFolder.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysModelFolder.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysModelFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysModelFolderId(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isPPSSysModelFolderIdDirty() : !pSSysModelFolder.isPPSSysModelFolderIdDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getPPSSysModelFolderId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysModelFolderId_Default((IEntity)pSSysModelFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSMODELFOLDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjId(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isPSObjIdDirty() : !pSSysModelFolder.isPSObjIdDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getPSObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjId_Default((IEntity)pSSysModelFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSObjName(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isPSObjNameDirty() : !pSSysModelFolder.isPSObjNameDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getPSObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjName_Default((IEntity)pSSysModelFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSObjType(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isPSObjTypeDirty() : !pSSysModelFolder.isPSObjTypeDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getPSObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjType_Default((IEntity)pSSysModelFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isPSSysAppIdDirty() : !pSSysModelFolder.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSSysModelFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelFolderId(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isPSSysModelFolderIdDirty() && !bl2 : !pSSysModelFolder.isPSSysModelFolderIdDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getPSSysModelFolderId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFolderId_Default((IEntity)pSSysModelFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelFolderName(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isPSSysModelFolderNameDirty() && !bl2 : !pSSysModelFolder.isPSSysModelFolderNameDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getPSSysModelFolderName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFolderName_Default((IEntity)pSSysModelFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFOLDERNAME");
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
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PPSSYSMODELFOLDERID";
                String string4 = this.checkFieldDupRule(this.getPSSysModelFolderDEModel(), "PSSYSMODELFOLDERNAME", string3, pSSysModelFolder, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSMODELFOLDERNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isPSSystemIdDirty() : !pSSysModelFolder.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysModelFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isPSSystemNameDirty() : !pSSysModelFolder.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysModelFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isUserTagDirty() : !pSSysModelFolder.isUserTagDirty()) {
            return null;
        }
        String string = pSSysModelFolder.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysModelFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysModelFolder pSSysModelFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFolder.isUserTag2Dirty() : !pSSysModelFolder.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysModelFolder.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysModelFolder, bl2, bl3);
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

    protected void onSyncEntity(PSSysModelFolder pSSysModelFolder, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysModelFolder, bl);
    }

    protected void onSyncIndexEntities(PSSysModelFolder pSSysModelFolder, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysModelFolder, bl);
    }

    public Object getDataContextValue(PSSysModelFolder pSSysModelFolder, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysModelFolder, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelFolder pSSysModelFolder, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysModelFolder, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"FOLDERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FolderType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSMODELFOLDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysModelFolderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSMODELFOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysModelFolderName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFOLDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFolderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FolderType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FOLDERTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_PPSSysModelFolderId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSMODELFOLDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysModelFolderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSMODELFOLDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSSysModelFolderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFOLDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldSysValueRule("PSSYSMODELFOLDERNAME", iEntity, bl2, "E0A2B595-89FB-4FE5-B030-67127DAA9614", "\u5185\u5bb9\u4e0d\u5305\u62ec\u4ee5\u4e0b\u5b57\u7b26\uff1a\uff1f\u3001*\u3001\\\u3001<\u3001>\u3001[\u3001]\u3001{\u3001}\u3001:\u3001@\u3001/", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u5305\u62ec\u4ee5\u4e0b\u5b57\u7b26\uff1a\uff1f\u3001*\u3001\\\u3001<\u3001>\u3001[\u3001]\u3001{\u3001}\u3001:\u3001@\u3001/)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysModelFolder pSSysModelFolder) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysModelFolder)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelFolder pSSysModelFolder) throws Exception {
        super.onUpdateParent((IEntity)pSSysModelFolder);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelFolder pSSysModelFolder, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELFOLDER");
        if (!bl) {
            pSSysModelFolder.setCreateDate(null);
            pSSysModelFolder.setCreateMan(null);
            pSSysModelFolder.setPSSysModelFolderId(null);
            pSSysModelFolder.setUpdateDate(null);
            pSSysModelFolder.setUpdateMan(null);
            super.exportCurXmlModel(pSSysModelFolder, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysModelFolder pSSysModelFolder, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysModelFolder, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSMODELFOLDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSMODELFOLDER#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSMODELFOLDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSMODELFOLDER_PSSYSMODELFOLDER_PPSSYSMODELFOLDERID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSMODELFOLDER_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSMODELFOLDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSMODELFOLDERNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFOLDER", (boolean)true) == 0) {
            iEntity.set("PPSSYSMODELFOLDERID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSSYSMODELFOLDERID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysModelFolder pSSysModelFolder) {
        if (!StringHelper.isNullOrEmpty((String)pSSysModelFolder.getPSSysModelFolderName())) {
            return pSSysModelFolder.getPSSysModelFolderName();
        }
        return super.getModelV2Tag(pSSysModelFolder);
    }

    @Override
    public boolean setModelV2Tag(PSSysModelFolder pSSysModelFolder, String string) {
        pSSysModelFolder.setPSSysModelFolderName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSMODELFOLDERNAME", "");
        map.put("PSSYSMODELFOLDERNAME", "");
        map.put("PPSSYSMODELFOLDERID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysModelFolder pSSysModelFolder, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysModelFolder.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysModelFolder, true);
        pSSysModelFolder.set("PSSYSMODELFOLDERNAME", string);
        if (this.select(pSSysModelFolder, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysModelFolder, true);
        return super.getModelV2Entity(pSSysModelFolder, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysModelFolder pSSysModelFolder, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysModelFolder, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSMODELFOLDER_PSSYSMODELFOLDER_PPSSYSMODELFOLDERID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysModelFolder pSSysModelFolder, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELFOLDER#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSMODELFOLDERITEM", (Object)pSSysModelFolder.getPSSysModelFolderId()))).exists()) {
            pSCoreSysServiceBase = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysModelFolderItem();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysModelFolderItemServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysModelFolderItem)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSMODELFOLDERITEM", (Object)entityBase.getPSSysModelFolderItemId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSMODELFOLDER_PSSYSMODELFOLDER_PPSSYSMODELFOLDERID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELFOLDER#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSMODELFOLDER", (Object)pSSysModelFolder.getPSSysModelFolderId()))).exists()) {
            pSCoreSysServiceBase = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysModelFolder();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysModelFolderServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysModelFolder)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSMODELFOLDER", (Object)entityBase.getPSSysModelFolderId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysModelFolder, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysModelFolder pSSysModelFolder, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSSysModelFolderItem> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID")) {
            pSCoreSysServiceBase = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELFOLDER#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSMODELFOLDERITEM", (Object)pSSysModelFolder.getPSSysModelFolderId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSSysModelFolderItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysModelFolderItem>();
                object3 = ((PSSysModelFolderItemServiceBase)pSCoreSysServiceBase).selectByPSSysModelFolder(pSSysModelFolder);
                arrayNode = StringHelper.format((String)"PSSYSMODELFOLDER#%1$s", (Object)pSSysModelFolder.getPSSysModelFolderId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysModelFolderItem)object2.next();
                    object = ((PSSysModelFolderItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysModelFolderItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("pssysmodelfolderitemname")) {
                            string = objectNode.get("pssysmodelfolderitemname").asText();
                        }
                        if (objectNode2.has("pssysmodelfolderitemname")) {
                            string2 = objectNode2.get("pssysmodelfolderitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysModelFolderItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSMODELFOLDER_PSSYSMODELFOLDER_PPSSYSMODELFOLDERID")) {
            pSCoreSysServiceBase = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELFOLDER#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSMODELFOLDER", (Object)pSSysModelFolder.getPSSysModelFolderId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysModelFolderItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSSysModelFolderServiceBase)pSCoreSysServiceBase).selectByPPSSysModelFolder(pSSysModelFolder);
                arrayNode = StringHelper.format((String)"PSSYSMODELFOLDER#%1$s", (Object)pSSysModelFolder.getPSSysModelFolderId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysModelFolder)object2.next();
                    object = ((PSSysModelFolderServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysModelFolderItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("pssysmodelfoldername")) {
                            string = objectNode.get("pssysmodelfoldername").asText();
                        }
                        if (objectNode2.has("pssysmodelfoldername")) {
                            string2 = objectNode2.get("pssysmodelfoldername").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysModelFolder();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysModelFolder, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysModelFolder pSSysModelFolder) throws Exception {
        super.onEmptyModelV2(pSSysModelFolder);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysModelFolder pSSysModelFolder, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysModelFolderItem();
        entityBase.set("PSSYSMODELFOLDERID", pSSysModelFolder.getPSSysModelFolderId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysModelFolder();
        entityBase.set("PPSSYSMODELFOLDERID", pSSysModelFolder.getPSSysModelFolderId());
        pSCoreSysServiceBase = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysModelFolder, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysModelFolder pSSysModelFolder, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSysModelFolderServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysModelFolderItem();
                    ((PSSysModelFolderItemBase)object).setPSSysModelFolderId(pSSysModelFolder.getPSSysModelFolderId());
                    ((PSSysModelFolderItemBase)object).setPSSysModelFolderName(pSSysModelFolder.getPSSysModelFolderName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysModelFolderItem();
                        entityBase.setPSSysModelFolderId(pSSysModelFolder.getPSSysModelFolderId());
                        entityBase.setPSSysModelFolderName(pSSysModelFolder.getPSSysModelFolderName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysModelFolderServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysModelFolder();
                    ((PSSysModelFolderBase)object).setPPSSysModelFolderId(pSSysModelFolder.getPSSysModelFolderId());
                    ((PSSysModelFolderBase)object).setPPSSysModelFolderName(pSSysModelFolder.getPSSysModelFolderName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysModelFolder();
                        entityBase.setPPSSysModelFolderId(pSSysModelFolder.getPSSysModelFolderId());
                        entityBase.setPPSSysModelFolderName(pSSysModelFolder.getPSSysModelFolderName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysModelFolder, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysModelFolder pSSysModelFolder, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysModelFolderItems(pSSysModelFolder, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysModelFolder, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysModelFolderItems(PSSysModelFolder pSSysModelFolder, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSMODELFOLDERITEM", true), (boolean)false) == 0) {
            PSSysModelFolderItemService pSSysModelFolderItemService = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysModelFolderItem pSSysModelFolderItem = new PSSysModelFolderItem();
            pSSysModelFolderItem.setPSSysModelFolderItemId(pSMOSFile.getPSModelId());
            if (!pSSysModelFolderItemService.get((IEntity)pSSysModelFolderItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysModelFolderItem.getPSSysModelFolderId(), (String)pSSysModelFolder.getPSSysModelFolderId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysModelFolderItemService.exportModelV2(pSSysModelFolderItem);
            pSSysModelFolderItem.reset();
            if (!pSSysModelFolderItemService.setModelV2ResScope((IEntity)pSSysModelFolderItem, "PSSYSMODELFOLDER", pSSysModelFolder.getPSSysModelFolderId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysModelFolderItemService.importModelV2(pSSysModelFolderItem, objectNode);
            SessionFactoryManager.commit();
            return pSSysModelFolderItemService.getFile((IEntity)pSSysModelFolderItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysModelFolder pSSysModelFolder, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysModelFolderItems(pSSysModelFolder, list);
        super.onFillPasteHelps(pSSysModelFolder, list);
    }

    protected void onFillPasteHelps_PSSysModelFolderItems(PSSysModelFolder pSSysModelFolder, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSMODELFOLDERITEM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u6a21\u578b\u76ee\u5f55]\u7684[\u7cfb\u7edf\u6a21\u578b\u76ee\u5f55\u6210\u5458]");
        list.add(pSHelpSection);
    }
}

