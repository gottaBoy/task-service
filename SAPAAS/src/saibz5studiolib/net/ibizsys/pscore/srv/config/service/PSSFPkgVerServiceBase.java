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
import net.ibizsys.pscore.srv.config.dao.PSSFPkgVerDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFPkgVerDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFPkg;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgVer;
import net.ibizsys.pscore.srv.config.service.PSSFStylePkgService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPkgVerServiceBase
extends PSCoreSysServiceBase<PSSFPkgVer> {
    private static final Log log = LogFactory.getLog(PSSFPkgVerServiceBase.class);
    public static final String DATASET_CURSFPKG = "CurSFPkg";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFPkgVerDEModel pSSFPkgVerDEModel;
    private PSSFPkgVerDAO pSSFPkgVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFPkgVerService";
    }

    public PSSFPkgVerDEModel getPSSFPkgVerDEModel() {
        if (this.pSSFPkgVerDEModel == null) {
            try {
                this.pSSFPkgVerDEModel = (PSSFPkgVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFPkgVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPkgVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFPkgVerDEModel();
    }

    public PSSFPkgVerDAO getPSSFPkgVerDAO() {
        if (this.pSSFPkgVerDAO == null) {
            try {
                this.pSSFPkgVerDAO = (PSSFPkgVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFPkgVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPkgVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFPkgVerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSFPKG, (boolean)true) == 0) {
            return this.fetchCurSFPkg(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSFPkg(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSFPKG, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSFPkgVer pSSFPkgVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPKGVER_PSDEVCENTER_PSDCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDC(pSSFPkgVer, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPKGVER_PSSFPKG_PSSFPKGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgService", (SessionFactory)this.getSessionFactory());
            PSSFPkg pSSFPkg = (PSSFPkg)iService.getDEModel().createEntity();
            pSSFPkg.set("PSSFPKGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFPkg);
            } else {
                iService.get(pSSFPkg);
            }
            this.onFillParentInfo_PSSFPkg(pSSFPkgVer, pSSFPkg);
            return;
        }
        super.onFillParentInfo(pSSFPkgVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDC(PSSFPkgVer pSSFPkgVer, PSDevCenter pSDevCenter) throws Exception {
        pSSFPkgVer.setPSDCId(pSDevCenter.getPSDevCenterId());
        pSSFPkgVer.setPSDCName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSFPkg(PSSFPkgVer pSSFPkgVer, PSSFPkg pSSFPkg) throws Exception {
        pSSFPkgVer.setPSSFPkgId(pSSFPkg.getPSSFPkgId());
        pSSFPkgVer.setPSSFPkgName(pSSFPkg.getPSSFPkgName());
    }

    protected void onFillEntityFullInfo(PSSFPkgVer pSSFPkgVer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSFPkgVer, bl);
        this.onFillEntityFullInfo_PSDC(pSSFPkgVer, bl);
        this.onFillEntityFullInfo_PSSFPkg(pSSFPkgVer, bl);
    }

    protected void onFillEntityFullInfo_PSDC(PSSFPkgVer pSSFPkgVer, boolean bl) throws Exception {
        if (pSSFPkgVer.isPSDCIdDirty()) {
            if (pSSFPkgVer.getPSDCId() != null) {
                if (pSSFPkgVer.getPSDCId() == null || pSSFPkgVer.getPSDCName() == null) {
                    PSDevCenter pSDevCenter = pSSFPkgVer.getPSDC();
                    pSSFPkgVer.setPSDCName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSSFPkgVer.setPSDCName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFPkg(PSSFPkgVer pSSFPkgVer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFPkgVer pSSFPkgVer, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFPkgVer, bl);
    }

    public ArrayList<PSSFPkgVer> selectByPSDC(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSSFPkgVer> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSSFPkgVer> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFPkgVer> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase) throws Exception {
        return this.selectByPSSFPkg(pSSFPkgBase, "", -1);
    }

    public ArrayList<PSSFPkgVer> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase, String string) throws Exception {
        return this.selectByPSSFPkg(pSSFPkgBase, string, -1);
    }

    public ArrayList<PSSFPkgVer> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSFPkgVer> arrayList = this.selectByPSDC(pSDevCenter);
        for (PSSFPkgVer pSSFPkgVer : arrayList) {
            PSSFPkgVer pSSFPkgVer2 = (PSSFPkgVer)this.getDEModel().createEntity();
            pSSFPkgVer2.setPSSFPkgVerId(pSSFPkgVer.getPSSFPkgVerId());
            pSSFPkgVer2.setPSDCId(null);
            this.update(pSSFPkgVer2);
        }
    }

    public void removeByPSDC(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPkgVerServiceBase.this.onBeforeRemoveByPSDC(pSDevCenter2);
                PSSFPkgVerServiceBase.this.internalRemoveByPSDC(pSDevCenter2);
                PSSFPkgVerServiceBase.this.onAfterRemoveByPSDC(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSFPkgVer> arrayList = this.selectByPSDC(pSDevCenter);
        this.onBeforeRemoveByPSDC(pSDevCenter, arrayList);
        for (PSSFPkgVer pSSFPkgVer : arrayList) {
            this.remove(pSSFPkgVer);
        }
        this.onAfterRemoveByPSDC(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSSFPkgVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSSFPkgVer> arrayList) throws Exception {
    }

    public void testRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    public void resetPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        ArrayList<PSSFPkgVer> arrayList = this.selectByPSSFPkg(pSSFPkg);
        for (PSSFPkgVer pSSFPkgVer : arrayList) {
            PSSFPkgVer pSSFPkgVer2 = (PSSFPkgVer)this.getDEModel().createEntity();
            pSSFPkgVer2.setPSSFPkgVerId(pSSFPkgVer.getPSSFPkgVerId());
            pSSFPkgVer2.setPSSFPkgId(null);
            this.update(pSSFPkgVer2);
        }
    }

    public void removeByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        final PSSFPkg pSSFPkg2 = pSSFPkg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPkgVerServiceBase.this.onBeforeRemoveByPSSFPkg(pSSFPkg2);
                PSSFPkgVerServiceBase.this.internalRemoveByPSSFPkg(pSSFPkg2);
                PSSFPkgVerServiceBase.this.onAfterRemoveByPSSFPkg(pSSFPkg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    protected void internalRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        ArrayList<PSSFPkgVer> arrayList = this.selectByPSSFPkg(pSSFPkg);
        this.onBeforeRemoveByPSSFPkg(pSSFPkg, arrayList);
        for (PSSFPkgVer pSSFPkgVer : arrayList) {
            this.remove(pSSFPkgVer);
        }
        this.onAfterRemoveByPSSFPkg(pSSFPkg, arrayList);
    }

    protected void onAfterRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPkg(PSSFPkg pSSFPkg, ArrayList<PSSFPkgVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPkg(PSSFPkg pSSFPkg, ArrayList<PSSFPkgVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFPkgVer pSSFPkgVer) throws Exception {
        PSSFStylePkgService pSSFStylePkgService = (PSSFStylePkgService)ServiceGlobal.getService(PSSFStylePkgService.class, (SessionFactory)this.getSessionFactory());
        pSSFStylePkgService.testRemoveByPSSFPkgVer(pSSFPkgVer);
        super.onBeforeRemove(pSSFPkgVer);
    }

    protected void replaceParentInfo(PSSFPkgVer pSSFPkgVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFPkgVer, cloneSession);
        if (pSSFPkgVer.getPSDCId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSSFPkgVer.getPSDCId())) != null) {
            this.onFillParentInfo_PSDC(pSSFPkgVer, (PSDevCenter)iEntity);
        }
        if (pSSFPkgVer.getPSSFPkgId() != null && (iEntity = cloneSession.getEntity("PSSFPKG", (Object)pSSFPkgVer.getPSSFPkgId())) != null) {
            this.onFillParentInfo_PSSFPkg(pSSFPkgVer, (PSSFPkg)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFPkgVer pSSFPkgVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFPkgVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSFPkgVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCId(bl, pSSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCName(bl, pSSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgId(bl, pSSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgVerId(bl, pSSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgVerName(bl, pSSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubSysVer(bl, pSSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerParam(bl, pSSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag(bl, pSSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag2(bl, pSSFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFPkgVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isMemoDirty() : !pSSFPkgVer.isMemoDirty()) {
            return null;
        }
        String string = pSSFPkgVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFPkgVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCId(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isPSDCIdDirty() : !pSSFPkgVer.isPSDCIdDirty()) {
            return null;
        }
        String string = pSSFPkgVer.getPSDCId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCId_Default(pSSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCName(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isPSDCNameDirty() : !pSSFPkgVer.isPSDCNameDirty()) {
            return null;
        }
        String string = pSSFPkgVer.getPSDCName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCName_Default(pSSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgId(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isPSSFPkgIdDirty() : !pSSFPkgVer.isPSSFPkgIdDirty()) {
            return null;
        }
        String string = pSSFPkgVer.getPSSFPkgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgId_Default(pSSFPkgVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFPkgVerId(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isPSSFPkgVerIdDirty() && !bl2 : !pSSFPkgVer.isPSSFPkgVerIdDirty()) {
            return null;
        }
        String string = pSSFPkgVer.getPSSFPkgVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgVerId_Default(pSSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgVerName(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isPSSFPkgVerNameDirty() && !bl2 : !pSSFPkgVer.isPSSFPkgVerNameDirty()) {
            return null;
        }
        String string = pSSFPkgVer.getPSSFPkgVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgVerName_Default(pSSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubSysVer(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isSubSysVerDirty() : !pSSFPkgVer.isSubSysVerDirty()) {
            return null;
        }
        Integer n = pSSFPkgVer.getSubSysVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SubSysVer_Default(pSSFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBSYSVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerParam(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isVerParamDirty() : !pSSFPkgVer.isVerParamDirty()) {
            return null;
        }
        String string = pSSFPkgVer.getVerParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerParam_Default(pSSFPkgVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_VerTag(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isVerTagDirty() : !pSSFPkgVer.isVerTagDirty()) {
            return null;
        }
        String string = pSSFPkgVer.getVerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag_Default(pSSFPkgVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_VerTag2(boolean bl, PSSFPkgVer pSSFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgVer.isVerTag2Dirty() : !pSSFPkgVer.isVerTag2Dirty()) {
            return null;
        }
        String string = pSSFPkgVer.getVerTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag2_Default(pSSFPkgVer, bl2, bl3);
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

    protected void onSyncEntity(PSSFPkgVer pSSFPkgVer, boolean bl) throws Exception {
        super.onSyncEntity(pSSFPkgVer, bl);
    }

    protected void onSyncIndexEntities(PSSFPkgVer pSSFPkgVer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFPkgVer, bl);
    }

    public Object getDataContextValue(PSSFPkgVer pSSFPkgVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFPkgVer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSFPkgVer pSSFPkgVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFPkgVer, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBSYSVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubSysVer_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSFPkgVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubSysVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSSFPkgVer pSSFPkgVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFPkgVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFPkgVer pSSFPkgVer) throws Exception {
        super.onUpdateParent(pSSFPkgVer);
    }

    @Override
    protected void exportCurXmlModel(PSSFPkgVer pSSFPkgVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFPKGVER");
        if (!bl) {
            pSSFPkgVer.setCreateDate(null);
            pSSFPkgVer.setCreateMan(null);
            pSSFPkgVer.setPSSFPkgName(null);
            pSSFPkgVer.setPSSFPkgVerId(null);
            pSSFPkgVer.setUpdateDate(null);
            pSSFPkgVer.setUpdateMan(null);
            super.exportCurXmlModel(pSSFPkgVer, xmlNode, bl);
        }
    }
}

