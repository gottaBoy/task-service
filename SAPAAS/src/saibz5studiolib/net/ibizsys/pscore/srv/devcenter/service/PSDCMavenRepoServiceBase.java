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
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCMavenRepoDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMavenRepoDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMavenRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMavenRepoServiceBase
extends PSCoreSysServiceBase<PSDCMavenRepo> {
    private static final Log log = LogFactory.getLog(PSDCMavenRepoServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_INITDCDEFAULT = "InitDCDefault";
    private PSDCMavenRepoDEModel pSDCMavenRepoDEModel;
    private PSDCMavenRepoDAO pSDCMavenRepoDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMavenRepoService";
    }

    public PSDCMavenRepoDEModel getPSDCMavenRepoDEModel() {
        if (this.pSDCMavenRepoDEModel == null) {
            try {
                this.pSDCMavenRepoDEModel = (PSDCMavenRepoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMavenRepoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMavenRepoDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCMavenRepoDEModel();
    }

    public PSDCMavenRepoDAO getPSDCMavenRepoDAO() {
        if (this.pSDCMavenRepoDAO == null) {
            try {
                this.pSDCMavenRepoDAO = (PSDCMavenRepoDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCMavenRepoDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMavenRepoDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCMavenRepoDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITDCDEFAULT, (boolean)true) == 0) {
            this.initDCDefault((PSDCMavenRepo)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void initDCDefault(PSDCMavenRepo pSDCMavenRepo) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDCDEFAULT, 0, pSDCMavenRepo, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCMavenRepo, ACTION_INITDCDEFAULT);
        final PSDCMavenRepo pSDCMavenRepo2 = pSDCMavenRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCMavenRepoServiceBase.this.getService(), PSDCMavenRepoServiceBase.ACTION_INITDCDEFAULT, 40, pSDCMavenRepo2, null).getResult() != 1) {
                    PSDCMavenRepoServiceBase.this.onInitDCDefault(pSDCMavenRepo2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDCDEFAULT, 99, pSDCMavenRepo, null);
        }
    }

    protected void onInitDCDefault(PSDCMavenRepo pSDCMavenRepo) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitDCDefault]");
    }

    protected void onFillParentInfo(PSDCMavenRepo pSDCMavenRepo, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMAVENREPO_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCMavenRepo, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMAVENREPO_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCMavenRepo, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDCMavenRepo, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCMavenRepo pSDCMavenRepo, PSDevCenter pSDevCenter) throws Exception {
        pSDCMavenRepo.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCMavenRepo.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCMavenRepo pSDCMavenRepo, PSDevSln pSDevSln) throws Exception {
        pSDCMavenRepo.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCMavenRepo.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDCMavenRepo pSDCMavenRepo, boolean bl) throws Exception {
        if (bl) {
            if (pSDCMavenRepo.getDefaultFlag() == null) {
                pSDCMavenRepo.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCMavenRepo.getValidFlag() == null) {
                pSDCMavenRepo.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDCMavenRepo, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCMavenRepo, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCMavenRepo, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCMavenRepo pSDCMavenRepo, boolean bl) throws Exception {
        if (pSDCMavenRepo.isPSDevCenterIdDirty()) {
            if (pSDCMavenRepo.getPSDevCenterId() != null) {
                if (pSDCMavenRepo.getPSDevCenterId() == null || pSDCMavenRepo.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCMavenRepo.getPSDevCenter();
                    pSDCMavenRepo.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCMavenRepo.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCMavenRepo pSDCMavenRepo, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDCMavenRepo pSDCMavenRepo, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCMavenRepo, bl);
    }

    public ArrayList<PSDCMavenRepo> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCMavenRepo> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCMavenRepo> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCMavenRepo> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCMavenRepo> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCMavenRepo> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCMavenRepo> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMAVENREPO_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCMAVENREPO", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCMavenRepo> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCMavenRepo pSDCMavenRepo : arrayList) {
            PSDCMavenRepo pSDCMavenRepo2 = (PSDCMavenRepo)this.getDEModel().createEntity();
            pSDCMavenRepo2.setPSDCMavenRepoId(pSDCMavenRepo.getPSDCMavenRepoId());
            pSDCMavenRepo2.setPSDevCenterId(null);
            this.update(pSDCMavenRepo2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMavenRepoServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCMavenRepoServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCMavenRepoServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCMavenRepo> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCMavenRepo pSDCMavenRepo : arrayList) {
            this.remove(pSDCMavenRepo);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCMavenRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCMavenRepo> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCMavenRepo> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMAVENREPO_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDCMAVENREPO", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCMavenRepo> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCMavenRepo pSDCMavenRepo : arrayList) {
            PSDCMavenRepo pSDCMavenRepo2 = (PSDCMavenRepo)this.getDEModel().createEntity();
            pSDCMavenRepo2.setPSDCMavenRepoId(pSDCMavenRepo.getPSDCMavenRepoId());
            pSDCMavenRepo2.setPSDevSlnId(null);
            this.update(pSDCMavenRepo2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMavenRepoServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCMavenRepoServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCMavenRepoServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCMavenRepo> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCMavenRepo pSDCMavenRepo : arrayList) {
            this.remove(pSDCMavenRepo);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCMavenRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCMavenRepo> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCMavenRepo pSDCMavenRepo) throws Exception {
        PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnService.testRemoveByPSDCMavenRepo(pSDCMavenRepo);
        super.onBeforeRemove(pSDCMavenRepo);
    }

    protected void replaceParentInfo(PSDCMavenRepo pSDCMavenRepo, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCMavenRepo, cloneSession);
        if (pSDCMavenRepo.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCMavenRepo.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCMavenRepo, (PSDevCenter)iEntity);
        }
        if (pSDCMavenRepo.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCMavenRepo.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCMavenRepo, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCMavenRepo pSDCMavenRepo, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCMavenRepo, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ConnStr(bl, pSDCMavenRepo, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MavenPasswd(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MavenUserName(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param3(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param4(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMavenRepoId(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMavenRepoName(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROPasswd(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROUserName(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCMavenRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCMavenRepo, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isConnStrDirty() && !bl2 : !pSDCMavenRepo.isConnStrDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getConnStr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isDefaultFlagDirty() && !bl2 : !pSDCMavenRepo.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDCMavenRepo.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEVCENTERID";
                String string2 = this.checkFieldDupRule(this.getPSDCMavenRepoDEModel(), "DEFAULTFLAG", string, pSDCMavenRepo, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MavenPasswd(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isMavenPasswdDirty() : !pSDCMavenRepo.isMavenPasswdDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getMavenPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MavenPasswd_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAVENPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MavenUserName(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isMavenUserNameDirty() : !pSDCMavenRepo.isMavenUserNameDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getMavenUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MavenUserName_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAVENUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isMemoDirty() : !pSDCMavenRepo.isMemoDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCMavenRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isParamDirty() : !pSDCMavenRepo.isParamDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param2(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isParam2Dirty() : !pSDCMavenRepo.isParam2Dirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param3(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isParam3Dirty() : !pSDCMavenRepo.isParam3Dirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param3_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param4(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isParam4Dirty() : !pSDCMavenRepo.isParam4Dirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param4_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMavenRepoId(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isPSDCMavenRepoIdDirty() && !bl2 : !pSDCMavenRepo.isPSDCMavenRepoIdDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getPSDCMavenRepoId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMAVENREPOID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMavenRepoId_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMAVENREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMavenRepoName(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isPSDCMavenRepoNameDirty() && !bl2 : !pSDCMavenRepo.isPSDCMavenRepoNameDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getPSDCMavenRepoName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMAVENREPONAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMavenRepoName_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMAVENREPONAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isPSDevCenterIdDirty() : !pSDCMavenRepo.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCMavenRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isPSDevCenterNameDirty() : !pSDCMavenRepo.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCMavenRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isPSDevSlnIdDirty() : !pSDCMavenRepo.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROPasswd(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isROPasswdDirty() : !pSDCMavenRepo.isROPasswdDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getROPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROPasswd_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROUserName(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isROUserNameDirty() : !pSDCMavenRepo.isROUserNameDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getROUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROUserName_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isUserTagDirty() : !pSDCMavenRepo.isUserTagDirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDCMavenRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isUserTag2Dirty() : !pSDCMavenRepo.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDCMavenRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isUserTag3Dirty() : !pSDCMavenRepo.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isUserTag4Dirty() : !pSDCMavenRepo.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDCMavenRepo.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDCMavenRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCMavenRepo pSDCMavenRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMavenRepo.isValidFlagDirty() && !bl2 : !pSDCMavenRepo.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCMavenRepo.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCMavenRepo, bl2, bl3);
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

    protected void onSyncEntity(PSDCMavenRepo pSDCMavenRepo, boolean bl) throws Exception {
        super.onSyncEntity(pSDCMavenRepo, bl);
    }

    protected void onSyncIndexEntities(PSDCMavenRepo pSDCMavenRepo, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCMavenRepo, bl);
    }

    public Object getDataContextValue(PSDCMavenRepo pSDCMavenRepo, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCMavenRepo, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCMavenRepo pSDCMavenRepo, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCMavenRepo, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONNSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConnStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAVENPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MavenPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAVENUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MavenUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMAVENREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMavenRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMAVENREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMavenRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROUserName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ConnStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNSTR", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MavenPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAVENPASSWD", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MavenUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAVENUSERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_Param_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMavenRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMAVENREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMavenRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMAVENREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPASSWD", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROUSERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSDCMavenRepo pSDCMavenRepo) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCMavenRepo)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCMavenRepo pSDCMavenRepo) throws Exception {
        super.onUpdateParent(pSDCMavenRepo);
    }

    @Override
    protected void exportCurXmlModel(PSDCMavenRepo pSDCMavenRepo, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMAVENREPO");
        if (!bl) {
            pSDCMavenRepo.setCreateDate(null);
            pSDCMavenRepo.setCreateMan(null);
            pSDCMavenRepo.setPSDCMavenRepoId(null);
            pSDCMavenRepo.setPSDevSlnName(null);
            pSDCMavenRepo.setUpdateDate(null);
            pSDCMavenRepo.setUpdateMan(null);
            super.exportCurXmlModel(pSDCMavenRepo, xmlNode, bl);
        }
    }
}

