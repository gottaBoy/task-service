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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCSFPkgVerDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSFPkgVerDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSFPkg;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSFPkgBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSFPkgVer;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSFPkgVerServiceBase
extends PSCoreSysServiceBase<PSDCSFPkgVer> {
    private static final Log log = LogFactory.getLog(PSDCSFPkgVerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCSFPkgVerDEModel pSDCSFPkgVerDEModel;
    private PSDCSFPkgVerDAO pSDCSFPkgVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgVerService";
    }

    public PSDCSFPkgVerDEModel getPSDCSFPkgVerDEModel() {
        if (this.pSDCSFPkgVerDEModel == null) {
            try {
                this.pSDCSFPkgVerDEModel = (PSDCSFPkgVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSFPkgVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSFPkgVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCSFPkgVerDEModel();
    }

    public PSDCSFPkgVerDAO getPSDCSFPkgVerDAO() {
        if (this.pSDCSFPkgVerDAO == null) {
            try {
                this.pSDCSFPkgVerDAO = (PSDCSFPkgVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCSFPkgVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSFPkgVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCSFPkgVerDAO();
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

    protected void onFillParentInfo(PSDCSFPkgVer pSDCSFPkgVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSFPKGVER_PSDCSFPKG_PSDCSFPKGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgService", (SessionFactory)this.getSessionFactory());
            PSDCSFPkg pSDCSFPkg = (PSDCSFPkg)iService.getDEModel().createEntity();
            pSDCSFPkg.set("PSDCSFPKGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCSFPkg);
            } else {
                iService.get((IEntity)pSDCSFPkg);
            }
            this.onFillParentInfo_PSDCSFPkg(pSDCSFPkgVer, pSDCSFPkg);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCSFPkgVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCSFPkg(PSDCSFPkgVer pSDCSFPkgVer, PSDCSFPkg pSDCSFPkg) throws Exception {
        pSDCSFPkgVer.setPSDCSFPkgId(pSDCSFPkg.getPSDCSFPkgId());
        pSDCSFPkgVer.setPSDCSFPkgName(pSDCSFPkg.getPSDCSFPkgName());
    }

    protected void onFillEntityFullInfo(PSDCSFPkgVer pSDCSFPkgVer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDCSFPkgVer, bl);
        this.onFillEntityFullInfo_PSDCSFPkg(pSDCSFPkgVer, bl);
    }

    protected void onFillEntityFullInfo_PSDCSFPkg(PSDCSFPkgVer pSDCSFPkgVer, boolean bl) throws Exception {
        if (pSDCSFPkgVer.isPSDCSFPkgIdDirty()) {
            if (pSDCSFPkgVer.getPSDCSFPkgId() != null) {
                if (pSDCSFPkgVer.getPSDCSFPkgId() == null || pSDCSFPkgVer.getPSDCSFPkgName() == null) {
                    PSDCSFPkg pSDCSFPkg = pSDCSFPkgVer.getPSDCSFPkg();
                    pSDCSFPkgVer.setPSDCSFPkgName(pSDCSFPkg.getPSDCSFPkgName());
                }
            } else {
                pSDCSFPkgVer.setPSDCSFPkgName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCSFPkgVer pSDCSFPkgVer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCSFPkgVer, bl);
    }

    public ArrayList<PSDCSFPkgVer> selectByPSDCSFPkg(PSDCSFPkgBase pSDCSFPkgBase) throws Exception {
        return this.selectByPSDCSFPkg(pSDCSFPkgBase, "", -1);
    }

    public ArrayList<PSDCSFPkgVer> selectByPSDCSFPkg(PSDCSFPkgBase pSDCSFPkgBase, String string) throws Exception {
        return this.selectByPSDCSFPkg(pSDCSFPkgBase, string, -1);
    }

    public ArrayList<PSDCSFPkgVer> selectByPSDCSFPkg(PSDCSFPkgBase pSDCSFPkgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCSFPKGID", (Object)pSDCSFPkgBase.getPSDCSFPkgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCSFPkgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCSFPkgCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCSFPkg(PSDCSFPkg pSDCSFPkg) throws Exception {
    }

    public void resetPSDCSFPkg(PSDCSFPkg pSDCSFPkg) throws Exception {
        ArrayList<PSDCSFPkgVer> arrayList = this.selectByPSDCSFPkg(pSDCSFPkg);
        for (PSDCSFPkgVer pSDCSFPkgVer : arrayList) {
            PSDCSFPkgVer pSDCSFPkgVer2 = (PSDCSFPkgVer)this.getDEModel().createEntity();
            pSDCSFPkgVer2.setPSDCSFPkgVerId(pSDCSFPkgVer.getPSDCSFPkgVerId());
            pSDCSFPkgVer2.setPSDCSFPkgId(null);
            this.update(pSDCSFPkgVer2);
        }
    }

    public void removeByPSDCSFPkg(PSDCSFPkg pSDCSFPkg) throws Exception {
        final PSDCSFPkg pSDCSFPkg2 = pSDCSFPkg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSFPkgVerServiceBase.this.onBeforeRemoveByPSDCSFPkg(pSDCSFPkg2);
                PSDCSFPkgVerServiceBase.this.internalRemoveByPSDCSFPkg(pSDCSFPkg2);
                PSDCSFPkgVerServiceBase.this.onAfterRemoveByPSDCSFPkg(pSDCSFPkg2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCSFPkg(PSDCSFPkg pSDCSFPkg) throws Exception {
    }

    protected void internalRemoveByPSDCSFPkg(PSDCSFPkg pSDCSFPkg) throws Exception {
        ArrayList<PSDCSFPkgVer> arrayList = this.selectByPSDCSFPkg(pSDCSFPkg);
        this.onBeforeRemoveByPSDCSFPkg(pSDCSFPkg, arrayList);
        for (PSDCSFPkgVer pSDCSFPkgVer : arrayList) {
            this.remove((IEntity)pSDCSFPkgVer);
        }
        this.onAfterRemoveByPSDCSFPkg(pSDCSFPkg, arrayList);
    }

    protected void onAfterRemoveByPSDCSFPkg(PSDCSFPkg pSDCSFPkg) throws Exception {
    }

    protected void onBeforeRemoveByPSDCSFPkg(PSDCSFPkg pSDCSFPkg, ArrayList<PSDCSFPkgVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCSFPkg(PSDCSFPkg pSDCSFPkg, ArrayList<PSDCSFPkgVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCSFPkgVer pSDCSFPkgVer) throws Exception {
        super.onBeforeRemove(pSDCSFPkgVer);
    }

    protected void replaceParentInfo(PSDCSFPkgVer pSDCSFPkgVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCSFPkgVer, cloneSession);
        if (pSDCSFPkgVer.getPSDCSFPkgId() != null && (iEntity = cloneSession.getEntity("PSDCSFPKG", (Object)pSDCSFPkgVer.getPSDCSFPkgId())) != null) {
            this.onFillParentInfo_PSDCSFPkg(pSDCSFPkgVer, (PSDCSFPkg)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCSFPkgVer pSDCSFPkgVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCSFPkgVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCSFPkgVer pSDCSFPkgVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCSFPkgVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSFPkgId(bl, pSDCSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSFPkgName(bl, pSDCSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSFPkgVerId(bl, pSDCSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSFPkgVerName(bl, pSDCSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerParam(bl, pSDCSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag(bl, pSDCSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag2(bl, pSDCSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCSFPkgVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCSFPkgVer pSDCSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkgVer.isMemoDirty() : !pSDCSFPkgVer.isMemoDirty()) {
            return null;
        }
        String string = pSDCSFPkgVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDCSFPkgVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCSFPkgId(boolean bl, PSDCSFPkgVer pSDCSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkgVer.isPSDCSFPkgIdDirty() : !pSDCSFPkgVer.isPSDCSFPkgIdDirty()) {
            return null;
        }
        String string = pSDCSFPkgVer.getPSDCSFPkgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSFPkgId_Default((IEntity)pSDCSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSFPKGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSFPkgName(boolean bl, PSDCSFPkgVer pSDCSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkgVer.isPSDCSFPkgNameDirty() : !pSDCSFPkgVer.isPSDCSFPkgNameDirty()) {
            return null;
        }
        String string = pSDCSFPkgVer.getPSDCSFPkgName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSFPkgName_Default((IEntity)pSDCSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSFPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSFPkgVerId(boolean bl, PSDCSFPkgVer pSDCSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkgVer.isPSDCSFPkgVerIdDirty() && !bl2 : !pSDCSFPkgVer.isPSDCSFPkgVerIdDirty()) {
            return null;
        }
        String string = pSDCSFPkgVer.getPSDCSFPkgVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSFPKGVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSFPkgVerId_Default((IEntity)pSDCSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSFPKGVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSFPkgVerName(boolean bl, PSDCSFPkgVer pSDCSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkgVer.isPSDCSFPkgVerNameDirty() && !bl2 : !pSDCSFPkgVer.isPSDCSFPkgVerNameDirty()) {
            return null;
        }
        String string = pSDCSFPkgVer.getPSDCSFPkgVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSFPKGVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSFPkgVerName_Default((IEntity)pSDCSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSFPKGVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerParam(boolean bl, PSDCSFPkgVer pSDCSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkgVer.isVerParamDirty() : !pSDCSFPkgVer.isVerParamDirty()) {
            return null;
        }
        String string = pSDCSFPkgVer.getVerParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerParam_Default((IEntity)pSDCSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag(boolean bl, PSDCSFPkgVer pSDCSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkgVer.isVerTagDirty() : !pSDCSFPkgVer.isVerTagDirty()) {
            return null;
        }
        String string = pSDCSFPkgVer.getVerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag_Default((IEntity)pSDCSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag2(boolean bl, PSDCSFPkgVer pSDCSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkgVer.isVerTag2Dirty() : !pSDCSFPkgVer.isVerTag2Dirty()) {
            return null;
        }
        String string = pSDCSFPkgVer.getVerTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag2_Default((IEntity)pSDCSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCSFPkgVer pSDCSFPkgVer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCSFPkgVer, bl);
    }

    protected void onSyncIndexEntities(PSDCSFPkgVer pSDCSFPkgVer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCSFPkgVer, bl);
    }

    public Object getDataContextValue(PSDCSFPkgVer pSDCSFPkgVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCSFPkgVer, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCSFPkg pSDCSFPkg = pSDCSFPkgVer.getPSDCSFPkg();
        if (pSDCSFPkg != null && pSDCSFPkg.contains(string)) {
            return pSDCSFPkg.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCSFPkgVer pSDCSFPkgVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCSFPkgVer, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCSFPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSFPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSFPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSFPkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSFPKGVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSFPkgVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSFPKGVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSFPkgVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag2_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSFPkgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSFPKGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSFPkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSFPKGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSFPkgVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSFPKGVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSFPkgVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSFPKGVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_VerParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERPARAM", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDCSFPkgVer pSDCSFPkgVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCSFPkgVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCSFPkgVer pSDCSFPkgVer) throws Exception {
        super.onUpdateParent((IEntity)pSDCSFPkgVer);
    }

    @Override
    protected void exportCurXmlModel(PSDCSFPkgVer pSDCSFPkgVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCSFPKGVER");
        if (!bl) {
            pSDCSFPkgVer.setCreateDate(null);
            pSDCSFPkgVer.setCreateMan(null);
            pSDCSFPkgVer.setPSDCSFPkgVerId(null);
            pSDCSFPkgVer.setUpdateDate(null);
            pSDCSFPkgVer.setUpdateMan(null);
            super.exportCurXmlModel(pSDCSFPkgVer, xmlNode, bl);
        }
    }
}

