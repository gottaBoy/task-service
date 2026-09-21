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
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysModelSyncDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysModelSyncDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrcBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelSync;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelSyncBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelSyncService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelSyncServiceBase
extends PSCoreSysServiceBase<PSSysModelSync> {
    private static final Log log = LogFactory.getLog(PSSysModelSyncServiceBase.class);
    private PSSysModelSyncDEModel pSSysModelSyncDEModel;
    private PSSysModelSyncDAO pSSysModelSyncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysModelSyncService";
    }

    public PSSysModelSyncDEModel getPSSysModelSyncDEModel() {
        if (this.pSSysModelSyncDEModel == null) {
            try {
                this.pSSysModelSyncDEModel = (PSSysModelSyncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysModelSyncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelSyncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelSyncDEModel();
    }

    public PSSysModelSyncDAO getPSSysModelSyncDAO() {
        if (this.pSSysModelSyncDAO == null) {
            try {
                this.pSSysModelSyncDAO = (PSSysModelSyncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysModelSyncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelSyncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelSyncDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSSysModelSync pSSysModelSync, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELSYNC_PSDEVSLNSYSSRC_PSDEVSLNSYSSRCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrcService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysSrc pSDevSlnSysSrc = (PSDevSlnSysSrc)iService.getDEModel().createEntity();
            pSDevSlnSysSrc.set("PSDEVSLNSYSSRCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysSrc);
            } else {
                iService.get((IEntity)pSDevSlnSysSrc);
            }
            this.onFillParentInfo_PSDevSlnSysSrc(pSSysModelSync, pSDevSlnSysSrc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELSYNC_PSSYSMODELSYNC_PPSSYSMODELSYNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysModelSyncService", (SessionFactory)this.getSessionFactory());
            PSSysModelSync pSSysModelSync2 = (PSSysModelSync)iService.getDEModel().createEntity();
            pSSysModelSync2.set("PSSYSMODELSYNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelSync2);
            } else {
                iService.get((IEntity)pSSysModelSync2);
            }
            this.onFillParentInfo_PPSysModelSync(pSSysModelSync, pSSysModelSync2);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysModelSync, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnSysSrc(PSSysModelSync pSSysModelSync, PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
        pSSysModelSync.setPSDevSlnSysSrcId(pSDevSlnSysSrc.getPSDevSlnSysSrcId());
        pSSysModelSync.setPSDevSlnSysSrcName(pSDevSlnSysSrc.getPSDevSlnSysSrcName());
    }

    protected void onFillParentInfo_PPSysModelSync(PSSysModelSync pSSysModelSync, PSSysModelSync pSSysModelSync2) throws Exception {
        pSSysModelSync.setPPSSysModelSyncId(pSSysModelSync2.getPSSysModelSyncId());
        pSSysModelSync.setPPSSysModelSyncName(pSSysModelSync2.getPSSysModelSyncName());
    }

    protected void onFillEntityFullInfo(PSSysModelSync pSSysModelSync, boolean bl) throws Exception {
        if (bl) {
            if (pSSysModelSync.getExpandFlag() == null) {
                pSSysModelSync.setExpandFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysModelSync.getGroupFlag() == null) {
                pSSysModelSync.setGroupFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysModelSync, bl);
        this.onFillEntityFullInfo_PSDevSlnSysSrc(pSSysModelSync, bl);
        this.onFillEntityFullInfo_PPSysModelSync(pSSysModelSync, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnSysSrc(PSSysModelSync pSSysModelSync, boolean bl) throws Exception {
        if (pSSysModelSync.isPSDevSlnSysSrcIdDirty()) {
            if (pSSysModelSync.getPSDevSlnSysSrcId() != null) {
                if (pSSysModelSync.getPSDevSlnSysSrcId() == null || pSSysModelSync.getPSDevSlnSysSrcName() == null) {
                    PSDevSlnSysSrc pSDevSlnSysSrc = pSSysModelSync.getPSDevSlnSysSrc();
                    pSSysModelSync.setPSDevSlnSysSrcName(pSDevSlnSysSrc.getPSDevSlnSysSrcName());
                }
            } else {
                pSSysModelSync.setPSDevSlnSysSrcName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSysModelSync(PSSysModelSync pSSysModelSync, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysModelSync pSSysModelSync, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysModelSync, bl);
    }

    public ArrayList<PSSysModelSync> selectByPSDevSlnSysSrc(PSDevSlnSysSrcBase pSDevSlnSysSrcBase) throws Exception {
        return this.selectByPSDevSlnSysSrc(pSDevSlnSysSrcBase, "", -1);
    }

    public ArrayList<PSSysModelSync> selectByPSDevSlnSysSrc(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, String string) throws Exception {
        return this.selectByPSDevSlnSysSrc(pSDevSlnSysSrcBase, string, -1);
    }

    public ArrayList<PSSysModelSync> selectByPSDevSlnSysSrc(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSSRCID", (Object)pSDevSlnSysSrcBase.getPSDevSlnSysSrcId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysSrcCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysSrcCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelSync> selectByPPSysModelSync(PSSysModelSyncBase pSSysModelSyncBase) throws Exception {
        return this.selectByPPSysModelSync(pSSysModelSyncBase, "", -1);
    }

    public ArrayList<PSSysModelSync> selectByPPSysModelSync(PSSysModelSyncBase pSSysModelSyncBase, String string) throws Exception {
        return this.selectByPPSysModelSync(pSSysModelSyncBase, string, -1);
    }

    public ArrayList<PSSysModelSync> selectByPPSysModelSync(PSSysModelSyncBase pSSysModelSyncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSMODELSYNCID", (Object)pSSysModelSyncBase.getPSSysModelSyncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSysModelSyncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSysModelSyncCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnSysSrc(PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
    }

    public void resetPSDevSlnSysSrc(PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
        ArrayList<PSSysModelSync> arrayList = this.selectByPSDevSlnSysSrc(pSDevSlnSysSrc);
        for (PSSysModelSync pSSysModelSync : arrayList) {
            PSSysModelSync pSSysModelSync2 = (PSSysModelSync)this.getDEModel().createEntity();
            pSSysModelSync2.setPSSysModelSyncId(pSSysModelSync.getPSSysModelSyncId());
            pSSysModelSync2.setPSDevSlnSysSrcId(null);
            this.update(pSSysModelSync2);
        }
    }

    public void removeByPSDevSlnSysSrc(PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
        final PSDevSlnSysSrc pSDevSlnSysSrc2 = pSDevSlnSysSrc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelSyncServiceBase.this.onBeforeRemoveByPSDevSlnSysSrc(pSDevSlnSysSrc2);
                PSSysModelSyncServiceBase.this.internalRemoveByPSDevSlnSysSrc(pSDevSlnSysSrc2);
                PSSysModelSyncServiceBase.this.onAfterRemoveByPSDevSlnSysSrc(pSDevSlnSysSrc2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysSrc(PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysSrc(PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
        ArrayList<PSSysModelSync> arrayList = this.selectByPSDevSlnSysSrc(pSDevSlnSysSrc);
        this.onBeforeRemoveByPSDevSlnSysSrc(pSDevSlnSysSrc, arrayList);
        for (PSSysModelSync pSSysModelSync : arrayList) {
            this.remove((IEntity)pSSysModelSync);
        }
        this.onAfterRemoveByPSDevSlnSysSrc(pSDevSlnSysSrc, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysSrc(PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysSrc(PSDevSlnSysSrc pSDevSlnSysSrc, ArrayList<PSSysModelSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysSrc(PSDevSlnSysSrc pSDevSlnSysSrc, ArrayList<PSSysModelSync> arrayList) throws Exception {
    }

    public void testRemoveByPPSysModelSync(PSSysModelSync pSSysModelSync) throws Exception {
    }

    public void resetPPSysModelSync(PSSysModelSync pSSysModelSync) throws Exception {
        ArrayList<PSSysModelSync> arrayList = this.selectByPPSysModelSync(pSSysModelSync);
        for (PSSysModelSync pSSysModelSync2 : arrayList) {
            PSSysModelSync pSSysModelSync3 = (PSSysModelSync)this.getDEModel().createEntity();
            pSSysModelSync3.setPSSysModelSyncId(pSSysModelSync2.getPSSysModelSyncId());
            pSSysModelSync3.setPPSSysModelSyncId(null);
            this.update(pSSysModelSync3);
        }
    }

    public void removeByPPSysModelSync(PSSysModelSync pSSysModelSync) throws Exception {
        final PSSysModelSync pSSysModelSync2 = pSSysModelSync;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelSyncServiceBase.this.onBeforeRemoveByPPSysModelSync(pSSysModelSync2);
                PSSysModelSyncServiceBase.this.internalRemoveByPPSysModelSync(pSSysModelSync2);
                PSSysModelSyncServiceBase.this.onAfterRemoveByPPSysModelSync(pSSysModelSync2);
            }
        });
    }

    protected void onBeforeRemoveByPPSysModelSync(PSSysModelSync pSSysModelSync) throws Exception {
    }

    protected void internalRemoveByPPSysModelSync(PSSysModelSync pSSysModelSync) throws Exception {
        ArrayList<PSSysModelSync> arrayList = this.selectByPPSysModelSync(pSSysModelSync);
        this.onBeforeRemoveByPPSysModelSync(pSSysModelSync, arrayList);
        for (PSSysModelSync pSSysModelSync2 : arrayList) {
            this.remove((IEntity)pSSysModelSync2);
        }
        this.onAfterRemoveByPPSysModelSync(pSSysModelSync, arrayList);
    }

    protected void onAfterRemoveByPPSysModelSync(PSSysModelSync pSSysModelSync) throws Exception {
    }

    protected void onBeforeRemoveByPPSysModelSync(PSSysModelSync pSSysModelSync, ArrayList<PSSysModelSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSysModelSync(PSSysModelSync pSSysModelSync, ArrayList<PSSysModelSync> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelSync pSSysModelSync) throws Exception {
        PSSysModelSyncService pSSysModelSyncService = (PSSysModelSyncService)ServiceGlobal.getService(PSSysModelSyncService.class, (SessionFactory)this.getSessionFactory());
        pSSysModelSyncService.testRemoveByPPSysModelSync(pSSysModelSync);
        pSSysModelSyncService.removeByPPSysModelSync(pSSysModelSync);
        super.onBeforeRemove(pSSysModelSync);
    }

    protected void replaceParentInfo(PSSysModelSync pSSysModelSync, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysModelSync, cloneSession);
        if (pSSysModelSync.getPSDevSlnSysSrcId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSSRC", (Object)pSSysModelSync.getPSDevSlnSysSrcId())) != null) {
            this.onFillParentInfo_PSDevSlnSysSrc(pSSysModelSync, (PSDevSlnSysSrc)iEntity);
        }
        if (pSSysModelSync.getPPSSysModelSyncId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELSYNC", (Object)pSSysModelSync.getPPSSysModelSyncId())) != null) {
            this.onFillParentInfo_PPSysModelSync(pSSysModelSync, (PSSysModelSync)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelSync pSSysModelSync, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysModelSync, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CurVer(bl, pSSysModelSync, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpandFlag(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupFlag(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysModelSyncId(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysSrcId(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysSrcName(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelType(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelSyncId(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelSyncName(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcVer(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncFlag(bl, pSSysModelSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysModelSync, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CurVer(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isCurVerDirty() : !pSSysModelSync.isCurVerDirty()) {
            return null;
        }
        Integer n = pSSysModelSync.getCurVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CurVer_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpandFlag(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isExpandFlagDirty() && !bl2 : !pSSysModelSync.isExpandFlagDirty()) {
            return null;
        }
        Integer n = pSSysModelSync.getExpandFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPANDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ExpandFlag_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPANDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupFlag(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isGroupFlagDirty() && !bl2 : !pSSysModelSync.isGroupFlagDirty()) {
            return null;
        }
        Integer n = pSSysModelSync.getGroupFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_GroupFlag_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isLogicNameDirty() : !pSSysModelSync.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysModelSync.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysModelSyncId(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isPPSSysModelSyncIdDirty() : !pSSysModelSync.isPPSSysModelSyncIdDirty()) {
            return null;
        }
        String string = pSSysModelSync.getPPSSysModelSyncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysModelSyncId_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSMODELSYNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysSrcId(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isPSDevSlnSysSrcIdDirty() && !bl2 : !pSSysModelSync.isPSDevSlnSysSrcIdDirty()) {
            return null;
        }
        String string = pSSysModelSync.getPSDevSlnSysSrcId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysSrcId_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysSrcName(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isPSDevSlnSysSrcNameDirty() && !bl2 : !pSSysModelSync.isPSDevSlnSysSrcNameDirty()) {
            return null;
        }
        String string = pSSysModelSync.getPSDevSlnSysSrcName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysSrcName_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isPSModelIdDirty() && !bl2 : !pSSysModelSync.isPSModelIdDirty()) {
            return null;
        }
        String string = pSSysModelSync.getPSModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isPSModelNameDirty() && !bl2 : !pSSysModelSync.isPSModelNameDirty()) {
            return null;
        }
        String string = pSSysModelSync.getPSModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelType(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isPSModelTypeDirty() && !bl2 : !pSSysModelSync.isPSModelTypeDirty()) {
            return null;
        }
        String string = pSSysModelSync.getPSModelType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelType_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelSyncId(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isPSSysModelSyncIdDirty() && !bl2 : !pSSysModelSync.isPSSysModelSyncIdDirty()) {
            return null;
        }
        String string = pSSysModelSync.getPSSysModelSyncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELSYNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelSyncId_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELSYNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelSyncName(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isPSSysModelSyncNameDirty() && !bl2 : !pSSysModelSync.isPSSysModelSyncNameDirty()) {
            return null;
        }
        String string = pSSysModelSync.getPSSysModelSyncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELSYNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelSyncName_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELSYNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isPSSystemIdDirty() && !bl2 : !pSSysModelSync.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysModelSync.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysModelSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_SrcVer(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isSrcVerDirty() : !pSSysModelSync.isSrcVerDirty()) {
            return null;
        }
        Integer n = pSSysModelSync.getSrcVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SrcVer_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncFlag(boolean bl, PSSysModelSync pSSysModelSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelSync.isSyncFlagDirty() : !pSSysModelSync.isSyncFlagDirty()) {
            return null;
        }
        Integer n = pSSysModelSync.getSyncFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncFlag_Default((IEntity)pSSysModelSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysModelSync pSSysModelSync, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysModelSync, bl);
    }

    protected void onSyncIndexEntities(PSSysModelSync pSSysModelSync, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysModelSync, bl);
    }

    public Object getDataContextValue(PSSysModelSync pSSysModelSync, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysModelSync, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelSync pSSysModelSync, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysModelSync, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CurVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPANDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ExpandFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_GroupFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSMODELSYNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysModelSyncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSMODELSYNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysModelSyncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrcName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELSYNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelSyncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELSYNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelSyncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SrcVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SyncFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_CurVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpandFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysModelSyncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSMODELSYNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysModelSyncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSMODELSYNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysSrcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysSrcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelSyncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELSYNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelSyncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELSYNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSSysModelSync pSSysModelSync) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysModelSync)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelSync pSSysModelSync) throws Exception {
        super.onUpdateParent((IEntity)pSSysModelSync);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelSync pSSysModelSync, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELSYNC");
        if (!bl) {
            pSSysModelSync.setCreateDate(null);
            pSSysModelSync.setCreateMan(null);
            pSSysModelSync.setGroupFlag(null);
            pSSysModelSync.setPSSysModelSyncId(null);
            pSSysModelSync.setUpdateDate(null);
            pSSysModelSync.setUpdateMan(null);
            super.exportCurXmlModel(pSSysModelSync, xmlNode, bl);
        }
    }
}

