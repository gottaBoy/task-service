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
import net.ibizsys.pscore.srv.appdesign.service.PSAppPkgService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPkgServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSPFPkgVerDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFPkgVerDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPkg;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVer;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerCDNService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerCDNServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStylePkgService;
import net.ibizsys.pscore.srv.config.service.PSPFStylePkgServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPkgVerServiceBase
extends PSCoreSysServiceBase<PSPFPkgVer> {
    private static final Log log = LogFactory.getLog(PSPFPkgVerServiceBase.class);
    public static final String DATASET_CURPFPKG = "CurPFPkg";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFPkgVerDEModel pSPFPkgVerDEModel;
    private PSPFPkgVerDAO pSPFPkgVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFPkgVerService";
    }

    public PSPFPkgVerDEModel getPSPFPkgVerDEModel() {
        if (this.pSPFPkgVerDEModel == null) {
            try {
                this.pSPFPkgVerDEModel = (PSPFPkgVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPkgVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPkgVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFPkgVerDEModel();
    }

    public PSPFPkgVerDAO getPSPFPkgVerDAO() {
        if (this.pSPFPkgVerDAO == null) {
            try {
                this.pSPFPkgVerDAO = (PSPFPkgVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFPkgVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPkgVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFPkgVerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPFPKG, (boolean)true) == 0) {
            return this.fetchCurPFPkg(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurPFPkg(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPFPKG, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSPFPkgVer pSPFPkgVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKGVER_PSDEVCENTER_PSDCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDC(pSPFPkgVer, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKGVER_PSPFPKG_PSPFPKGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgService", (SessionFactory)this.getSessionFactory());
            PSPFPkg pSPFPkg = (PSPFPkg)iService.getDEModel().createEntity();
            pSPFPkg.set("PSPFPKGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFPkg);
            } else {
                iService.get((IEntity)pSPFPkg);
            }
            this.onFillParentInfo_PSPFPkg(pSPFPkgVer, pSPFPkg);
            return;
        }
        super.onFillParentInfo((IEntity)pSPFPkgVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDC(PSPFPkgVer pSPFPkgVer, PSDevCenter pSDevCenter) throws Exception {
        pSPFPkgVer.setPSDCId(pSDevCenter.getPSDevCenterId());
        pSPFPkgVer.setPSDCName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSPFPkg(PSPFPkgVer pSPFPkgVer, PSPFPkg pSPFPkg) throws Exception {
        pSPFPkgVer.setPSPFPkgId(pSPFPkg.getPSPFPkgId());
        pSPFPkgVer.setPSPFPkgName(pSPFPkg.getPSPFPkgName());
    }

    protected void onFillEntityFullInfo(PSPFPkgVer pSPFPkgVer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSPFPkgVer, bl);
        this.onFillEntityFullInfo_PSDC(pSPFPkgVer, bl);
        this.onFillEntityFullInfo_PSPFPkg(pSPFPkgVer, bl);
    }

    protected void onFillEntityFullInfo_PSDC(PSPFPkgVer pSPFPkgVer, boolean bl) throws Exception {
        if (pSPFPkgVer.isPSDCIdDirty()) {
            if (pSPFPkgVer.getPSDCId() != null) {
                if (pSPFPkgVer.getPSDCId() == null || pSPFPkgVer.getPSDCName() == null) {
                    PSDevCenter pSDevCenter = pSPFPkgVer.getPSDC();
                    pSPFPkgVer.setPSDCName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSPFPkgVer.setPSDCName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPFPkg(PSPFPkgVer pSPFPkgVer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPFPkgVer pSPFPkgVer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPFPkgVer, bl);
    }

    public ArrayList<PSPFPkgVer> selectByPSDC(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSPFPkgVer> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSPFPkgVer> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFPkgVer> selectByPSPFPkg(PSPFPkgBase pSPFPkgBase) throws Exception {
        return this.selectByPSPFPkg(pSPFPkgBase, "", -1);
    }

    public ArrayList<PSPFPkgVer> selectByPSPFPkg(PSPFPkgBase pSPFPkgBase, String string) throws Exception {
        return this.selectByPSPFPkg(pSPFPkgBase, string, -1);
    }

    public ArrayList<PSPFPkgVer> selectByPSPFPkg(PSPFPkgBase pSPFPkgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPKGID", (Object)pSPFPkgBase.getPSPFPkgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPkgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPkgCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFPkgVer> arrayList = this.selectByPSDC(pSDevCenter);
        for (PSPFPkgVer pSPFPkgVer : arrayList) {
            PSPFPkgVer pSPFPkgVer2 = (PSPFPkgVer)this.getDEModel().createEntity();
            pSPFPkgVer2.setPSPFPkgVerId(pSPFPkgVer.getPSPFPkgVerId());
            pSPFPkgVer2.setPSDCId(null);
            this.update(pSPFPkgVer2);
        }
    }

    public void removeByPSDC(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgVerServiceBase.this.onBeforeRemoveByPSDC(pSDevCenter2);
                PSPFPkgVerServiceBase.this.internalRemoveByPSDC(pSDevCenter2);
                PSPFPkgVerServiceBase.this.onAfterRemoveByPSDC(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFPkgVer> arrayList = this.selectByPSDC(pSDevCenter);
        this.onBeforeRemoveByPSDC(pSDevCenter, arrayList);
        for (PSPFPkgVer pSPFPkgVer : arrayList) {
            this.remove((IEntity)pSPFPkgVer);
        }
        this.onAfterRemoveByPSDC(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSPFPkgVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSPFPkgVer> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
    }

    public void resetPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        ArrayList<PSPFPkgVer> arrayList = this.selectByPSPFPkg(pSPFPkg);
        for (PSPFPkgVer pSPFPkgVer : arrayList) {
            PSPFPkgVer pSPFPkgVer2 = (PSPFPkgVer)this.getDEModel().createEntity();
            pSPFPkgVer2.setPSPFPkgVerId(pSPFPkgVer.getPSPFPkgVerId());
            pSPFPkgVer2.setPSPFPkgId(null);
            this.update(pSPFPkgVer2);
        }
    }

    public void removeByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        final PSPFPkg pSPFPkg2 = pSPFPkg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgVerServiceBase.this.onBeforeRemoveByPSPFPkg(pSPFPkg2);
                PSPFPkgVerServiceBase.this.internalRemoveByPSPFPkg(pSPFPkg2);
                PSPFPkgVerServiceBase.this.onAfterRemoveByPSPFPkg(pSPFPkg2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
    }

    protected void internalRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        ArrayList<PSPFPkgVer> arrayList = this.selectByPSPFPkg(pSPFPkg);
        this.onBeforeRemoveByPSPFPkg(pSPFPkg, arrayList);
        for (PSPFPkgVer pSPFPkgVer : arrayList) {
            this.remove((IEntity)pSPFPkgVer);
        }
        this.onAfterRemoveByPSPFPkg(pSPFPkg, arrayList);
    }

    protected void onAfterRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPkg(PSPFPkg pSPFPkg, ArrayList<PSPFPkgVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPkg(PSPFPkg pSPFPkg, ArrayList<PSPFPkgVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFPkgVer pSPFPkgVer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPkgServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPkgVer(pSPFPkgVer);
        ((PSAppPkgServiceBase)pSCoreSysServiceBase).resetPSPFPkgVer(pSPFPkgVer);
        pSCoreSysServiceBase = (PSPFPkgVerCDNService)ServiceGlobal.getService(PSPFPkgVerCDNService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPkgVerCDNServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPkgVer(pSPFPkgVer);
        pSCoreSysServiceBase = (PSPFStylePkgService)ServiceGlobal.getService(PSPFStylePkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStylePkgServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPkgVer(pSPFPkgVer);
        super.onBeforeRemove(pSPFPkgVer);
    }

    protected void replaceParentInfo(PSPFPkgVer pSPFPkgVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPFPkgVer, cloneSession);
        if (pSPFPkgVer.getPSDCId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSPFPkgVer.getPSDCId())) != null) {
            this.onFillParentInfo_PSDC(pSPFPkgVer, (PSDevCenter)iEntity);
        }
        if (pSPFPkgVer.getPSPFPkgId() != null && (iEntity = cloneSession.getEntity("PSPFPKG", (Object)pSPFPkgVer.getPSPFPkgId())) != null) {
            this.onFillParentInfo_PSPFPkg(pSPFPkgVer, (PSPFPkg)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFPkgVer pSPFPkgVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPFPkgVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSPFPkgVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam(bl, pSPFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam2(bl, pSPFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam3(bl, pSPFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam4(bl, pSPFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCId(bl, pSPFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCName(bl, pSPFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgId(bl, pSPFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgVerId(bl, pSPFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgVerName(bl, pSPFPkgVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPFPkgVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isMemoDirty() : !pSPFPkgVer.isMemoDirty()) {
            return null;
        }
        String string = pSPFPkgVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPFPkgVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isPkgParamDirty() : !pSPFPkgVer.isPkgParamDirty()) {
            return null;
        }
        String string = pSPFPkgVer.getPkgParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam_Default((IEntity)pSPFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgParam2(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isPkgParam2Dirty() : !pSPFPkgVer.isPkgParam2Dirty()) {
            return null;
        }
        String string = pSPFPkgVer.getPkgParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam2_Default((IEntity)pSPFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgParam3(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isPkgParam3Dirty() : !pSPFPkgVer.isPkgParam3Dirty()) {
            return null;
        }
        String string = pSPFPkgVer.getPkgParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam3_Default((IEntity)pSPFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgParam4(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isPkgParam4Dirty() : !pSPFPkgVer.isPkgParam4Dirty()) {
            return null;
        }
        String string = pSPFPkgVer.getPkgParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam4_Default((IEntity)pSPFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCId(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isPSDCIdDirty() : !pSPFPkgVer.isPSDCIdDirty()) {
            return null;
        }
        String string = pSPFPkgVer.getPSDCId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCId_Default((IEntity)pSPFPkgVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCName(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isPSDCNameDirty() : !pSPFPkgVer.isPSDCNameDirty()) {
            return null;
        }
        String string = pSPFPkgVer.getPSDCName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCName_Default((IEntity)pSPFPkgVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPkgId(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isPSPFPkgIdDirty() : !pSPFPkgVer.isPSPFPkgIdDirty()) {
            return null;
        }
        String string = pSPFPkgVer.getPSPFPkgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgId_Default((IEntity)pSPFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPkgVerId(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isPSPFPkgVerIdDirty() && !bl2 : !pSPFPkgVer.isPSPFPkgVerIdDirty()) {
            return null;
        }
        String string = pSPFPkgVer.getPSPFPkgVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgVerId_Default((IEntity)pSPFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPkgVerName(boolean bl, PSPFPkgVer pSPFPkgVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVer.isPSPFPkgVerNameDirty() && !bl2 : !pSPFPkgVer.isPSPFPkgVerNameDirty()) {
            return null;
        }
        String string = pSPFPkgVer.getPSPFPkgVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgVerName_Default((IEntity)pSPFPkgVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPFPkgVer pSPFPkgVer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPFPkgVer, bl);
    }

    protected void onSyncIndexEntities(PSPFPkgVer pSPFPkgVer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPFPkgVer, bl);
    }

    public Object getDataContextValue(PSPFPkgVer pSPFPkgVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPFPkgVer, string, iDataContextParam)) != null) {
            return object;
        }
        PSPFPkg pSPFPkg = pSPFPkgVer.getPSPFPkg();
        if (pSPFPkg != null && pSPFPkg.contains(string)) {
            return pSPFPkg.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPFPkgVer pSPFPkgVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPFPkgVer, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PKGPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgVerName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM2", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM3", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM4", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_PSPFPkgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPkgVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPkgVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPFPkgVer pSPFPkgVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPFPkgVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFPkgVer pSPFPkgVer) throws Exception {
        super.onUpdateParent((IEntity)pSPFPkgVer);
    }

    @Override
    protected void exportCurXmlModel(PSPFPkgVer pSPFPkgVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFPKGVER");
        if (!bl) {
            pSPFPkgVer.setCreateDate(null);
            pSPFPkgVer.setCreateMan(null);
            pSPFPkgVer.setPSPFPkgName(null);
            pSPFPkgVer.setPSPFPkgVerId(null);
            pSPFPkgVer.setUpdateDate(null);
            pSPFPkgVer.setUpdateMan(null);
            super.exportCurXmlModel(pSPFPkgVer, xmlNode, bl);
        }
    }
}

