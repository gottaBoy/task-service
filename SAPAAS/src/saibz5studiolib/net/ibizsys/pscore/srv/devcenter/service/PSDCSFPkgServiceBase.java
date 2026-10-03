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
import net.ibizsys.pscore.srv.config.entity.PSSFPkg;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCSFPkgDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSFPkgDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSFPkg;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSFPkgServiceBase
extends PSCoreSysServiceBase<PSDCSFPkg> {
    private static final Log log = LogFactory.getLog(PSDCSFPkgServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCSFPkgDEModel pSDCSFPkgDEModel;
    private PSDCSFPkgDAO pSDCSFPkgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgService";
    }

    public PSDCSFPkgDEModel getPSDCSFPkgDEModel() {
        if (this.pSDCSFPkgDEModel == null) {
            try {
                this.pSDCSFPkgDEModel = (PSDCSFPkgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSFPkgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSFPkgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCSFPkgDEModel();
    }

    public PSDCSFPkgDAO getPSDCSFPkgDAO() {
        if (this.pSDCSFPkgDAO == null) {
            try {
                this.pSDCSFPkgDAO = (PSDCSFPkgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCSFPkgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSFPkgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCSFPkgDAO();
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

    protected void onFillParentInfo(PSDCSFPkg pSDCSFPkg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSFPKG_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCSFPkg, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSFPKG_PSSFPKG_PSSFPKGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgService", (SessionFactory)this.getSessionFactory());
            PSSFPkg pSSFPkg = (PSSFPkg)iService.getDEModel().createEntity();
            pSSFPkg.set("PSSFPKGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFPkg);
            } else {
                iService.get(pSSFPkg);
            }
            this.onFillParentInfo_PSSFPkg(pSDCSFPkg, pSSFPkg);
            return;
        }
        super.onFillParentInfo(pSDCSFPkg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCSFPkg pSDCSFPkg, PSDevCenter pSDevCenter) throws Exception {
        pSDCSFPkg.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCSFPkg.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSFPkg(PSDCSFPkg pSDCSFPkg, PSSFPkg pSSFPkg) throws Exception {
        pSDCSFPkg.setPSSFPkgId(pSSFPkg.getPSSFPkgId());
        pSDCSFPkg.setPSSFPkgName(pSSFPkg.getPSSFPkgName());
    }

    protected void onFillEntityFullInfo(PSDCSFPkg pSDCSFPkg, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCSFPkg, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCSFPkg, bl);
        this.onFillEntityFullInfo_PSSFPkg(pSDCSFPkg, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCSFPkg pSDCSFPkg, boolean bl) throws Exception {
        if (pSDCSFPkg.isPSDevCenterIdDirty()) {
            if (pSDCSFPkg.getPSDevCenterId() != null) {
                if (pSDCSFPkg.getPSDevCenterId() == null || pSDCSFPkg.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCSFPkg.getPSDevCenter();
                    pSDCSFPkg.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCSFPkg.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFPkg(PSDCSFPkg pSDCSFPkg, boolean bl) throws Exception {
        if (pSDCSFPkg.isPSSFPkgIdDirty()) {
            if (pSDCSFPkg.getPSSFPkgId() != null) {
                if (pSDCSFPkg.getPSSFPkgId() == null || pSDCSFPkg.getPSSFPkgName() == null) {
                    PSSFPkg pSSFPkg = pSDCSFPkg.getPSSFPkg();
                    pSDCSFPkg.setPSSFPkgName(pSSFPkg.getPSSFPkgName());
                }
            } else {
                pSDCSFPkg.setPSSFPkgName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCSFPkg pSDCSFPkg, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCSFPkg, bl);
    }

    public ArrayList<PSDCSFPkg> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCSFPkg> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCSFPkg> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCSFPkg> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase) throws Exception {
        return this.selectByPSSFPkg(pSSFPkgBase, "", -1);
    }

    public ArrayList<PSDCSFPkg> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase, String string) throws Exception {
        return this.selectByPSSFPkg(pSSFPkgBase, string, -1);
    }

    public ArrayList<PSDCSFPkg> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFPKGID", (Object)pSSFPkgBase.getPSSFPkgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFPkgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFPkgCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSFPkg> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCSFPkg pSDCSFPkg : arrayList) {
            PSDCSFPkg pSDCSFPkg2 = (PSDCSFPkg)this.getDEModel().createEntity();
            pSDCSFPkg2.setPSDCSFPkgId(pSDCSFPkg.getPSDCSFPkgId());
            pSDCSFPkg2.setPSDevCenterId(null);
            this.update(pSDCSFPkg2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSFPkgServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCSFPkgServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCSFPkgServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSFPkg> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCSFPkg pSDCSFPkg : arrayList) {
            this.remove(pSDCSFPkg);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSFPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSFPkg> arrayList) throws Exception {
    }

    public void testRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    public void resetPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        ArrayList<PSDCSFPkg> arrayList = this.selectByPSSFPkg(pSSFPkg);
        for (PSDCSFPkg pSDCSFPkg : arrayList) {
            PSDCSFPkg pSDCSFPkg2 = (PSDCSFPkg)this.getDEModel().createEntity();
            pSDCSFPkg2.setPSDCSFPkgId(pSDCSFPkg.getPSDCSFPkgId());
            pSDCSFPkg2.setPSSFPkgId(null);
            this.update(pSDCSFPkg2);
        }
    }

    public void removeByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        final PSSFPkg pSSFPkg2 = pSSFPkg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSFPkgServiceBase.this.onBeforeRemoveByPSSFPkg(pSSFPkg2);
                PSDCSFPkgServiceBase.this.internalRemoveByPSSFPkg(pSSFPkg2);
                PSDCSFPkgServiceBase.this.onAfterRemoveByPSSFPkg(pSSFPkg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    protected void internalRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        ArrayList<PSDCSFPkg> arrayList = this.selectByPSSFPkg(pSSFPkg);
        this.onBeforeRemoveByPSSFPkg(pSSFPkg, arrayList);
        for (PSDCSFPkg pSDCSFPkg : arrayList) {
            this.remove(pSDCSFPkg);
        }
        this.onAfterRemoveByPSSFPkg(pSSFPkg, arrayList);
    }

    protected void onAfterRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPkg(PSSFPkg pSSFPkg, ArrayList<PSDCSFPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPkg(PSSFPkg pSSFPkg, ArrayList<PSDCSFPkg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCSFPkg pSDCSFPkg) throws Exception {
        PSDCSFPkgVerService pSDCSFPkgVerService = (PSDCSFPkgVerService)ServiceGlobal.getService(PSDCSFPkgVerService.class, (SessionFactory)this.getSessionFactory());
        pSDCSFPkgVerService.testRemoveByPSDCSFPkg(pSDCSFPkg);
        pSDCSFPkgVerService.removeByPSDCSFPkg(pSDCSFPkg);
        super.onBeforeRemove(pSDCSFPkg);
    }

    protected void replaceParentInfo(PSDCSFPkg pSDCSFPkg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCSFPkg, cloneSession);
        if (pSDCSFPkg.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCSFPkg.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCSFPkg, (PSDevCenter)iEntity);
        }
        if (pSDCSFPkg.getPSSFPkgId() != null && (iEntity = cloneSession.getEntity("PSSFPKG", (Object)pSDCSFPkg.getPSSFPkgId())) != null) {
            this.onFillParentInfo_PSSFPkg(pSDCSFPkg, (PSSFPkg)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCSFPkg pSDCSFPkg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCSFPkg, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCSFPkg pSDCSFPkg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCSFPkg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSFPkgId(bl, pSDCSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSFPkgName(bl, pSDCSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgId(bl, pSDCSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgName(bl, pSDCSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCSFPkg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCSFPkg pSDCSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkg.isMemoDirty() : !pSDCSFPkg.isMemoDirty()) {
            return null;
        }
        String string = pSDCSFPkg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCSFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCSFPkgId(boolean bl, PSDCSFPkg pSDCSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkg.isPSDCSFPkgIdDirty() && !bl2 : !pSDCSFPkg.isPSDCSFPkgIdDirty()) {
            return null;
        }
        String string = pSDCSFPkg.getPSDCSFPkgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSFPKGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSFPkgId_Default(pSDCSFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCSFPkgName(boolean bl, PSDCSFPkg pSDCSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkg.isPSDCSFPkgNameDirty() && !bl2 : !pSDCSFPkg.isPSDCSFPkgNameDirty()) {
            return null;
        }
        String string = pSDCSFPkg.getPSDCSFPkgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSFPKGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSFPkgName_Default(pSDCSFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCSFPkg pSDCSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkg.isPSDevCenterIdDirty() : !pSDCSFPkg.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCSFPkg.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCSFPkg pSDCSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkg.isPSDevCenterNameDirty() : !pSDCSFPkg.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCSFPkg.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgId(boolean bl, PSDCSFPkg pSDCSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkg.isPSSFPkgIdDirty() : !pSDCSFPkg.isPSSFPkgIdDirty()) {
            return null;
        }
        String string = pSDCSFPkg.getPSSFPkgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgId_Default(pSDCSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgName(boolean bl, PSDCSFPkg pSDCSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSFPkg.isPSSFPkgNameDirty() : !pSDCSFPkg.isPSSFPkgNameDirty()) {
            return null;
        }
        String string = pSDCSFPkg.getPSSFPkgName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgName_Default(pSDCSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCSFPkg pSDCSFPkg, boolean bl) throws Exception {
        super.onSyncEntity(pSDCSFPkg, bl);
    }

    protected void onSyncIndexEntities(PSDCSFPkg pSDCSFPkg, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCSFPkg, bl);
    }

    public Object getDataContextValue(PSDCSFPkg pSDCSFPkg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCSFPkg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCSFPkg pSDCSFPkg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCSFPkg, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
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

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCSFPkg pSDCSFPkg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCSFPkg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCSFPkg pSDCSFPkg) throws Exception {
        super.onUpdateParent(pSDCSFPkg);
    }

    @Override
    protected void exportCurXmlModel(PSDCSFPkg pSDCSFPkg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCSFPKG");
        if (!bl) {
            pSDCSFPkg.setCreateDate(null);
            pSDCSFPkg.setCreateMan(null);
            pSDCSFPkg.setPSDCSFPkgId(null);
            pSDCSFPkg.setUpdateDate(null);
            pSDCSFPkg.setUpdateMan(null);
            super.exportCurXmlModel(pSDCSFPkg, xmlNode, bl);
        }
    }
}

