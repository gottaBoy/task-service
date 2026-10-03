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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSystemSrcDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemSrcDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemSrc;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemSrcServiceBase
extends PSCoreSysServiceBase<PSSystemSrc> {
    private static final Log log = LogFactory.getLog(PSSystemSrcServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSystemSrcDEModel pSSystemSrcDEModel;
    private PSSystemSrcDAO pSSystemSrcDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSystemSrcService";
    }

    public PSSystemSrcDEModel getPSSystemSrcDEModel() {
        if (this.pSSystemSrcDEModel == null) {
            try {
                this.pSSystemSrcDEModel = (PSSystemSrcDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemSrcDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemSrcDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSystemSrcDEModel();
    }

    public PSSystemSrcDAO getPSSystemSrcDAO() {
        if (this.pSSystemSrcDAO == null) {
            try {
                this.pSSystemSrcDAO = (PSSystemSrcDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSystemSrcDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemSrcDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSystemSrcDAO();
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

    protected void onFillParentInfo(PSSystemSrc pSSystemSrc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMSRC_PSDEVSLNSYS_SRCPSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_SrcPSDevSlnSys(pSSystemSrc, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMSRC_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSystemSrc, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSystemSrc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_SrcPSDevSlnSys(PSSystemSrc pSSystemSrc, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSSystemSrc.setSrcPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSSystemSrc.setSrcPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSSystem(PSSystemSrc pSSystemSrc, PSSystem pSSystem) throws Exception {
        pSSystemSrc.setPSSystemId(pSSystem.getPSSystemId());
        pSSystemSrc.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected boolean onFillEntityKeyValue(PSSystemSrc pSSystemSrc, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSystemSrc.get("PSSYSTEMID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSystemSrc.get("SOURCEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSystemSrc.set(this.getPSSystemSrcDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSystemSrc pSSystemSrc, boolean bl) throws Exception {
        if (bl && pSSystemSrc.getValidFlag() == null) {
            pSSystemSrc.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSystemSrc, bl);
        this.onFillEntityFullInfo_SrcPSDevSlnSys(pSSystemSrc, bl);
        this.onFillEntityFullInfo_PSSystem(pSSystemSrc, bl);
    }

    protected void onFillEntityFullInfo_SrcPSDevSlnSys(PSSystemSrc pSSystemSrc, boolean bl) throws Exception {
        if (pSSystemSrc.isSrcPSDevSlnSysIdDirty()) {
            if (pSSystemSrc.getSrcPSDevSlnSysId() != null) {
                if (pSSystemSrc.getSrcPSDevSlnSysId() == null || pSSystemSrc.getSrcPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSSystemSrc.getSrcPSDevSlnSys();
                    pSSystemSrc.setSrcPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSSystemSrc.setSrcPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSystemSrc pSSystemSrc, boolean bl) throws Exception {
        if (pSSystemSrc.isPSSystemIdDirty()) {
            if (pSSystemSrc.getPSSystemId() != null) {
                if (pSSystemSrc.getPSSystemId() == null || pSSystemSrc.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSystemSrc.getPSSystem();
                    pSSystemSrc.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSystemSrc.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSystemSrc pSSystemSrc, boolean bl) throws Exception {
        super.onWriteBackParent(pSSystemSrc, bl);
    }

    public ArrayList<PSSystemSrc> selectBySrcPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectBySrcPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSSystemSrc> selectBySrcPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectBySrcPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSSystemSrc> selectBySrcPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemSrc> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSystemSrc> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSystemSrc> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetSrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSSystemSrc> arrayList = this.selectBySrcPSDevSlnSys(pSDevSlnSys);
        for (PSSystemSrc pSSystemSrc : arrayList) {
            PSSystemSrc pSSystemSrc2 = (PSSystemSrc)this.getDEModel().createEntity();
            pSSystemSrc2.setPSSystemSrcId(pSSystemSrc.getPSSystemSrcId());
            pSSystemSrc2.setSrcPSDevSlnSysId(null);
            this.update(pSSystemSrc2);
        }
    }

    public void removeBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemSrcServiceBase.this.onBeforeRemoveBySrcPSDevSlnSys(pSDevSlnSys2);
                PSSystemSrcServiceBase.this.internalRemoveBySrcPSDevSlnSys(pSDevSlnSys2);
                PSSystemSrcServiceBase.this.onAfterRemoveBySrcPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSSystemSrc> arrayList = this.selectBySrcPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveBySrcPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSSystemSrc pSSystemSrc : arrayList) {
            this.remove(pSSystemSrc);
        }
        this.onAfterRemoveBySrcPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSSystemSrc> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSSystemSrc> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemSrc> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSystemSrc pSSystemSrc : arrayList) {
            PSSystemSrc pSSystemSrc2 = (PSSystemSrc)this.getDEModel().createEntity();
            pSSystemSrc2.setPSSystemSrcId(pSSystemSrc.getPSSystemSrcId());
            pSSystemSrc2.setPSSystemId(null);
            this.update(pSSystemSrc2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemSrcServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSystemSrcServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSystemSrcServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemSrc> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSystemSrc pSSystemSrc : arrayList) {
            this.remove(pSSystemSrc);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemSrc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemSrc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSystemSrc pSSystemSrc) throws Exception {
        super.onBeforeRemove(pSSystemSrc);
    }

    protected void replaceParentInfo(PSSystemSrc pSSystemSrc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSystemSrc, cloneSession);
        if (pSSystemSrc.getSrcPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSSystemSrc.getSrcPSDevSlnSysId())) != null) {
            this.onFillParentInfo_SrcPSDevSlnSys(pSSystemSrc, (PSDevSlnSys)iEntity);
        }
        if (pSSystemSrc.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSystemSrc.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSystemSrc, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSystemSrc pSSystemSrc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSystemSrc, bl);
    }

    protected void onCheckEntity(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSystemSrc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSystemSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSystemSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemSrcId(bl, pSSystemSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemSrcName(bl, pSSystemSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SourceId(bl, pSSystemSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDevSlnSysId(bl, pSSystemSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDevSlnSysName(bl, pSSystemSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSystemSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSystemSrc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemSrc.isMemoDirty() : !pSSystemSrc.isMemoDirty()) {
            return null;
        }
        String string = pSSystemSrc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSystemSrc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemSrc.isPSSystemIdDirty() && !bl2 : !pSSystemSrc.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSystemSrc.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSystemSrc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemSrc.isPSSystemNameDirty() && !bl2 : !pSSystemSrc.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSystemSrc.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSystemSrc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemSrcId(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemSrc.isPSSystemSrcIdDirty() && !bl2 : !pSSystemSrc.isPSSystemSrcIdDirty()) {
            return null;
        }
        String string = pSSystemSrc.getPSSystemSrcId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMSRCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemSrcId_Default(pSSystemSrc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMSRCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemSrcName(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemSrc.isPSSystemSrcNameDirty() && !bl2 : !pSSystemSrc.isPSSystemSrcNameDirty()) {
            return null;
        }
        String string = pSSystemSrc.getPSSystemSrcName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMSRCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemSrcName_Default(pSSystemSrc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMSRCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SourceId(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemSrc.isSourceIdDirty() && !bl2 : !pSSystemSrc.isSourceIdDirty()) {
            return null;
        }
        String string = pSSystemSrc.getSourceId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SOURCEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SourceId_Default(pSSystemSrc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSystemSrcDEModel(), "SOURCEID", string3, pSSystemSrc, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("SOURCEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDevSlnSysId(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemSrc.isSrcPSDevSlnSysIdDirty() : !pSSystemSrc.isSrcPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSSystemSrc.getSrcPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDevSlnSysId_Default(pSSystemSrc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDevSlnSysName(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemSrc.isSrcPSDevSlnSysNameDirty() : !pSSystemSrc.isSrcPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSSystemSrc.getSrcPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDevSlnSysName_Default(pSSystemSrc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSystemSrc pSSystemSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemSrc.isValidFlagDirty() && !bl2 : !pSSystemSrc.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSystemSrc.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSystemSrc, bl2, bl3);
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

    protected void onSyncEntity(PSSystemSrc pSSystemSrc, boolean bl) throws Exception {
        super.onSyncEntity(pSSystemSrc, bl);
    }

    protected void onSyncIndexEntities(PSSystemSrc pSSystemSrc, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSystemSrc, bl);
    }

    public Object getDataContextValue(PSSystemSrc pSSystemSrc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSystemSrc, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSystemSrc pSSystemSrc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSystemSrc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMSRCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemSrcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMSRCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemSrcName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDevSlnSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSystemSrcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMSRCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemSrcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMSRCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SOURCEID", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSystemSrc pSSystemSrc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSystemSrc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSystemSrc pSSystemSrc) throws Exception {
        super.onUpdateParent(pSSystemSrc);
    }

    @Override
    protected void exportCurXmlModel(PSSystemSrc pSSystemSrc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTEMSRC");
        if (!bl) {
            pSSystemSrc.setCreateDate(null);
            pSSystemSrc.setCreateMan(null);
            pSSystemSrc.setPSSystemId(null);
            pSSystemSrc.setPSSystemName(null);
            pSSystemSrc.setPSSystemSrcId(null);
            pSSystemSrc.setSrcPSDevSlnSysId(null);
            pSSystemSrc.setSrcPSDevSlnSysName(null);
            pSSystemSrc.setUpdateDate(null);
            pSSystemSrc.setUpdateMan(null);
            super.exportCurXmlModel(pSSystemSrc, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSystemSrc pSSystemSrc, PSSystem pSSystem) throws Exception {
        PSSystemSrc pSSystemSrc2 = new PSSystemSrc();
        pSSystemSrc2.setPSSystemId(pSSystemSrc.getPSSystemId());
        pSSystemSrc2.setSourceId(pSSystemSrc.getSourceId());
        if (this.selectOne(pSSystemSrc2, true)) {
            return pSSystemSrc2.getPSSystemSrcId();
        }
        return super.getEntityFolderKeyValue(pSSystemSrc, pSSystem);
    }
}

