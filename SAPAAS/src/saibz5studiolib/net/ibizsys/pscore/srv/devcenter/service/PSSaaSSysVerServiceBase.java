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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSSaaSSysVerDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSSaaSSysVerDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSys;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAPIService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAPIServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryItem;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryItemBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepoBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSSaaSSysDBService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSSaaSSysDBServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSaaSSysVerServiceBase
extends PSCoreSysServiceBase<PSSaaSSysVer> {
    private static final Log log = LogFactory.getLog(PSSaaSSysVerServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSaaSSysVerDEModel pSSaaSSysVerDEModel;
    private PSSaaSSysVerDAO pSSaaSSysVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService";
    }

    public PSSaaSSysVerDEModel getPSSaaSSysVerDEModel() {
        if (this.pSSaaSSysVerDEModel == null) {
            try {
                this.pSSaaSSysVerDEModel = (PSSaaSSysVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSSaaSSysVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSaaSSysVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSaaSSysVerDEModel();
    }

    public PSSaaSSysVerDAO getPSSaaSSysVerDAO() {
        if (this.pSSaaSSysVerDAO == null) {
            try {
                this.pSSaaSSysVerDAO = (PSSaaSSysVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSSaaSSysVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSaaSSysVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSaaSSysVerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSaaSSysVer pSSaaSSysVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSVER_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysVer pSDevSlnSysVer = (PSDevSlnSysVer)iService.getDEModel().createEntity();
            pSDevSlnSysVer.set("PSDEVSLNSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysVer);
            } else {
                iService.get(pSDevSlnSysVer);
            }
            this.onFillParentInfo_PSDevSlnSysVer(pSSaaSSysVer, pSDevSlnSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSVER_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSSaaSSysVer, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSVER_PSREGISTRYITEM_PSREGISTRYITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRegistryItemService", (SessionFactory)this.getSessionFactory());
            PSRegistryItem pSRegistryItem = (PSRegistryItem)iService.getDEModel().createEntity();
            pSRegistryItem.set("PSREGISTRYITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSRegistryItem);
            } else {
                iService.get(pSRegistryItem);
            }
            this.onFillParentInfo_PSRegistryItem(pSSaaSSysVer, pSRegistryItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSVER_PSREGISTRYREPO_PSREGISTRYREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService", (SessionFactory)this.getSessionFactory());
            PSRegistryRepo pSRegistryRepo = (PSRegistryRepo)iService.getDEModel().createEntity();
            pSRegistryRepo.set("PSREGISTRYREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSRegistryRepo);
            } else {
                iService.get(pSRegistryRepo);
            }
            this.onFillParentInfo_PSRegistryRepo(pSSaaSSysVer, pSRegistryRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSVER_PSSAASSYS_PSSAASSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService", (SessionFactory)this.getSessionFactory());
            PSSaaSSys pSSaaSSys = (PSSaaSSys)iService.getDEModel().createEntity();
            pSSaaSSys.set("PSSAASSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSaaSSys);
            } else {
                iService.get(pSSaaSSys);
            }
            this.onFillParentInfo_PSSaaSSys(pSSaaSSysVer, pSSaaSSys);
            return;
        }
        super.onFillParentInfo(pSSaaSSysVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnSysVer(PSSaaSSysVer pSSaaSSysVer, PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        pSSaaSSysVer.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
        pSSaaSSysVer.setPSDevSlnSysVerName(pSDevSlnSysVer.getPSDevSlnSysVerName());
        pSSaaSSysVer.setPSSysModelInstId(pSDevSlnSysVer.getPSSysModelInstId());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSSaaSSysVer pSSaaSSysVer, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSSaaSSysVer.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSSaaSSysVer.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSRegistryItem(PSSaaSSysVer pSSaaSSysVer, PSRegistryItem pSRegistryItem) throws Exception {
        pSSaaSSysVer.setPSRegistryItemId(pSRegistryItem.getPSRegistryItemId());
        pSSaaSSysVer.setPSRegistryItemName(pSRegistryItem.getPSRegistryItemName());
    }

    protected void onFillParentInfo_PSRegistryRepo(PSSaaSSysVer pSSaaSSysVer, PSRegistryRepo pSRegistryRepo) throws Exception {
        pSSaaSSysVer.setPSRegistryRepoId(pSRegistryRepo.getPSRegistryRepoId());
        pSSaaSSysVer.setPSRegistryRepoName(pSRegistryRepo.getPSRegistryRepoName());
    }

    protected void onFillParentInfo_PSSaaSSys(PSSaaSSysVer pSSaaSSysVer, PSSaaSSys pSSaaSSys) throws Exception {
        pSSaaSSysVer.setPSSaaSSysId(pSSaaSSys.getPSSaaSSysId());
        pSSaaSSysVer.setPSSaaSSysName(pSSaaSSys.getPSSaaSSysName());
    }

    protected void onFillEntityFullInfo(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
        if (bl && pSSaaSSysVer.getValidFlag() == null) {
            pSSaaSSysVer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSaaSSysVer, bl);
        this.onFillEntityFullInfo_PSDevSlnSysVer(pSSaaSSysVer, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSSaaSSysVer, bl);
        this.onFillEntityFullInfo_PSRegistryItem(pSSaaSSysVer, bl);
        this.onFillEntityFullInfo_PSRegistryRepo(pSSaaSSysVer, bl);
        this.onFillEntityFullInfo_PSSaaSSys(pSSaaSSysVer, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnSysVer(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
        if (pSSaaSSysVer.isPSDevSlnSysIdDirty()) {
            if (pSSaaSSysVer.getPSDevSlnSysId() != null) {
                if (pSSaaSSysVer.getPSDevSlnSysId() == null || pSSaaSSysVer.getPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSSaaSSysVer.getPSDevSlnSys();
                    pSSaaSSysVer.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSSaaSSysVer.setPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSRegistryItem(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSRegistryRepo(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSaaSSys(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
        super.onWriteBackParent(pSSaaSSysVer, bl);
    }

    public ArrayList<PSSaaSSysVer> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, "", -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, string, -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSVERID", (Object)pSDevSlnSysVerBase.getPSDevSlnSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSaaSSysVer> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSaaSSysVer> selectByPSRegistryItem(PSRegistryItemBase pSRegistryItemBase) throws Exception {
        return this.selectByPSRegistryItem(pSRegistryItemBase, "", -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSRegistryItem(PSRegistryItemBase pSRegistryItemBase, String string) throws Exception {
        return this.selectByPSRegistryItem(pSRegistryItemBase, string, -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSRegistryItem(PSRegistryItemBase pSRegistryItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSREGISTRYITEMID", (Object)pSRegistryItemBase.getPSRegistryItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSRegistryItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSRegistryItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSaaSSysVer> selectByPSRegistryRepo(PSRegistryRepoBase pSRegistryRepoBase) throws Exception {
        return this.selectByPSRegistryRepo(pSRegistryRepoBase, "", -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSRegistryRepo(PSRegistryRepoBase pSRegistryRepoBase, String string) throws Exception {
        return this.selectByPSRegistryRepo(pSRegistryRepoBase, string, -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSRegistryRepo(PSRegistryRepoBase pSRegistryRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSREGISTRYREPOID", (Object)pSRegistryRepoBase.getPSRegistryRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSRegistryRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSRegistryRepoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSaaSSysVer> selectByPSSaaSSys(PSSaaSSysBase pSSaaSSysBase) throws Exception {
        return this.selectByPSSaaSSys(pSSaaSSysBase, "", -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSSaaSSys(PSSaaSSysBase pSSaaSSysBase, String string) throws Exception {
        return this.selectByPSSaaSSys(pSSaaSSysBase, string, -1);
    }

    public ArrayList<PSSaaSSysVer> selectByPSSaaSSys(PSSaaSSysBase pSSaaSSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSID", (Object)pSSaaSSysBase.getPSSaaSSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSVER_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", "", iDataEntityModel.getName(), "PSSAASSYSVER", iDataEntityModel.getDataInfo(pSDevSlnSysVer), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            PSSaaSSysVer pSSaaSSysVer2 = (PSSaaSSysVer)this.getDEModel().createEntity();
            pSSaaSSysVer2.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
            pSSaaSSysVer2.setPSDevSlnSysVerId(null);
            this.update(pSSaaSSysVer2);
        }
    }

    public void removeByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        final PSDevSlnSysVer pSDevSlnSysVer2 = pSDevSlnSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysVerServiceBase.this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSSaaSSysVerServiceBase.this.internalRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSSaaSSysVerServiceBase.this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            this.remove(pSSaaSSysVer);
        }
        this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSVER_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSSAASSYSVER", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            PSSaaSSysVer pSSaaSSysVer2 = (PSSaaSSysVer)this.getDEModel().createEntity();
            pSSaaSSysVer2.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
            pSSaaSSysVer2.setPSDevSlnSysId(null);
            this.update(pSSaaSSysVer2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysVerServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSSaaSSysVerServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSSaaSSysVerServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            this.remove(pSSaaSSysVer);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSRegistryItem(PSRegistryItem pSRegistryItem) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSRegistryItem(pSRegistryItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSREGISTRYITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSRegistryItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSVER_PSREGISTRYITEM_PSREGISTRYITEMID", "", iDataEntityModel.getName(), "PSSAASSYSVER", iDataEntityModel.getDataInfo(pSRegistryItem), arrayList.get(0)));
        }
    }

    public void resetPSRegistryItem(PSRegistryItem pSRegistryItem) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSRegistryItem(pSRegistryItem);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            PSSaaSSysVer pSSaaSSysVer2 = (PSSaaSSysVer)this.getDEModel().createEntity();
            pSSaaSSysVer2.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
            pSSaaSSysVer2.setPSRegistryItemId(null);
            this.update(pSSaaSSysVer2);
        }
    }

    public void removeByPSRegistryItem(PSRegistryItem pSRegistryItem) throws Exception {
        final PSRegistryItem pSRegistryItem2 = pSRegistryItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysVerServiceBase.this.onBeforeRemoveByPSRegistryItem(pSRegistryItem2);
                PSSaaSSysVerServiceBase.this.internalRemoveByPSRegistryItem(pSRegistryItem2);
                PSSaaSSysVerServiceBase.this.onAfterRemoveByPSRegistryItem(pSRegistryItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSRegistryItem(PSRegistryItem pSRegistryItem) throws Exception {
    }

    protected void internalRemoveByPSRegistryItem(PSRegistryItem pSRegistryItem) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSRegistryItem(pSRegistryItem);
        this.onBeforeRemoveByPSRegistryItem(pSRegistryItem, arrayList);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            this.remove(pSSaaSSysVer);
        }
        this.onAfterRemoveByPSRegistryItem(pSRegistryItem, arrayList);
    }

    protected void onAfterRemoveByPSRegistryItem(PSRegistryItem pSRegistryItem) throws Exception {
    }

    protected void onBeforeRemoveByPSRegistryItem(PSRegistryItem pSRegistryItem, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSRegistryItem(PSRegistryItem pSRegistryItem, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSRegistryRepo(pSRegistryRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSREGISTRYREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSRegistryRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSVER_PSREGISTRYREPO_PSREGISTRYREPOID", "", iDataEntityModel.getName(), "PSSAASSYSVER", iDataEntityModel.getDataInfo(pSRegistryRepo), arrayList.get(0)));
        }
    }

    public void resetPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSRegistryRepo(pSRegistryRepo);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            PSSaaSSysVer pSSaaSSysVer2 = (PSSaaSSysVer)this.getDEModel().createEntity();
            pSSaaSSysVer2.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
            pSSaaSSysVer2.setPSRegistryRepoId(null);
            this.update(pSSaaSSysVer2);
        }
    }

    public void removeByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
        final PSRegistryRepo pSRegistryRepo2 = pSRegistryRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysVerServiceBase.this.onBeforeRemoveByPSRegistryRepo(pSRegistryRepo2);
                PSSaaSSysVerServiceBase.this.internalRemoveByPSRegistryRepo(pSRegistryRepo2);
                PSSaaSSysVerServiceBase.this.onAfterRemoveByPSRegistryRepo(pSRegistryRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
    }

    protected void internalRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSRegistryRepo(pSRegistryRepo);
        this.onBeforeRemoveByPSRegistryRepo(pSRegistryRepo, arrayList);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            this.remove(pSSaaSSysVer);
        }
        this.onAfterRemoveByPSRegistryRepo(pSRegistryRepo, arrayList);
    }

    protected void onAfterRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSSaaSSys(pSSaaSSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSAASSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSaaSSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSVER_PSSAASSYS_PSSAASSYSID", "", iDataEntityModel.getName(), "PSSAASSYSVER", iDataEntityModel.getDataInfo(pSSaaSSys), arrayList.get(0)));
        }
    }

    public void resetPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSSaaSSys(pSSaaSSys);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            PSSaaSSysVer pSSaaSSysVer2 = (PSSaaSSysVer)this.getDEModel().createEntity();
            pSSaaSSysVer2.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
            pSSaaSSysVer2.setPSSaaSSysId(null);
            this.update(pSSaaSSysVer2);
        }
    }

    public void removeByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        final PSSaaSSys pSSaaSSys2 = pSSaaSSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysVerServiceBase.this.onBeforeRemoveByPSSaaSSys(pSSaaSSys2);
                PSSaaSSysVerServiceBase.this.internalRemoveByPSSaaSSys(pSSaaSSys2);
                PSSaaSSysVerServiceBase.this.onAfterRemoveByPSSaaSSys(pSSaaSSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
    }

    protected void internalRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        ArrayList<PSSaaSSysVer> arrayList = this.selectByPSSaaSSys(pSSaaSSys);
        this.onBeforeRemoveByPSSaaSSys(pSSaaSSys, arrayList);
        for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
            this.remove(pSSaaSSysVer);
        }
        this.onAfterRemoveByPSSaaSSys(pSSaaSSys, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys, ArrayList<PSSaaSSysVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSaaSSysAPIService)ServiceGlobal.getService(PSSaaSSysAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSaaSSysAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSaaSSysVer(pSSaaSSysVer);
        pSCoreSysServiceBase = (PSSaaSSysAppService)ServiceGlobal.getService(PSSaaSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSaaSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSaaSSysVer(pSSaaSSysVer);
        pSCoreSysServiceBase = (PSSaaSSysDBService)ServiceGlobal.getService(PSSaaSSysDBService.class, (SessionFactory)this.getSessionFactory());
        ((PSSaaSSysDBServiceBase)pSCoreSysServiceBase).testRemoveByPSSaaSSysVer(pSSaaSSysVer);
        super.onBeforeRemove(pSSaaSSysVer);
    }

    protected void replaceParentInfo(PSSaaSSysVer pSSaaSSysVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSaaSSysVer, cloneSession);
        if (pSSaaSSysVer.getPSDevSlnSysVerId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSVER", (Object)pSSaaSSysVer.getPSDevSlnSysVerId())) != null) {
            this.onFillParentInfo_PSDevSlnSysVer(pSSaaSSysVer, (PSDevSlnSysVer)iEntity);
        }
        if (pSSaaSSysVer.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSSaaSSysVer.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSSaaSSysVer, (PSDevSlnSys)iEntity);
        }
        if (pSSaaSSysVer.getPSRegistryItemId() != null && (iEntity = cloneSession.getEntity("PSREGISTRYITEM", (Object)pSSaaSSysVer.getPSRegistryItemId())) != null) {
            this.onFillParentInfo_PSRegistryItem(pSSaaSSysVer, (PSRegistryItem)iEntity);
        }
        if (pSSaaSSysVer.getPSRegistryRepoId() != null && (iEntity = cloneSession.getEntity("PSREGISTRYREPO", (Object)pSSaaSSysVer.getPSRegistryRepoId())) != null) {
            this.onFillParentInfo_PSRegistryRepo(pSSaaSSysVer, (PSRegistryRepo)iEntity);
        }
        if (pSSaaSSysVer.getPSSaaSSysId() != null && (iEntity = cloneSession.getEntity("PSSAASSYS", (Object)pSSaaSSysVer.getPSSaaSSysId())) != null) {
            this.onFillParentInfo_PSSaaSSys(pSSaaSSysVer, (PSSaaSSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSaaSSysVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DBTypes(bl, pSSaaSSysVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysName(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysVerId(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRegistryItemId(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRegistryRepoId(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysId(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysVerId(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysVerName(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag2(bl, pSSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSaaSSysVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DBTypes(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isDBTypesDirty() && !bl2 : !pSSaaSSysVer.isDBTypesDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getDBTypes();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPES");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBTypes_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isMemoDirty() : !pSSaaSSysVer.isMemoDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSaaSSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isPSDevSlnSysIdDirty() : !pSSaaSSysVer.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysName(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isPSDevSlnSysNameDirty() : !pSSaaSSysVer.isPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysName_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysVerId(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isPSDevSlnSysVerIdDirty() && !bl2 : !pSSaaSSysVer.isPSDevSlnSysVerIdDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getPSDevSlnSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysVerId_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRegistryItemId(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isPSRegistryItemIdDirty() : !pSSaaSSysVer.isPSRegistryItemIdDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getPSRegistryItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRegistryItemId_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSREGISTRYITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRegistryRepoId(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isPSRegistryRepoIdDirty() : !pSSaaSSysVer.isPSRegistryRepoIdDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getPSRegistryRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRegistryRepoId_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSREGISTRYREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysId(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isPSSaaSSysIdDirty() && !bl2 : !pSSaaSSysVer.isPSSaaSSysIdDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getPSSaaSSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysId_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysVerId(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isPSSaaSSysVerIdDirty() && !bl2 : !pSSaaSSysVer.isPSSaaSSysVerIdDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getPSSaaSSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysVerId_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysVerName(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isPSSaaSSysVerNameDirty() && !bl2 : !pSSaaSSysVer.isPSSaaSSysVerNameDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getPSSaaSSysVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysVerName_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isUserCatDirty() : !pSSaaSSysVer.isUserCatDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isUserTagDirty() : !pSSaaSSysVer.isUserTagDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSaaSSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isUserTag2Dirty() : !pSSaaSSysVer.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSaaSSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isUserTag3Dirty() : !pSSaaSSysVer.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSaaSSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isUserTag4Dirty() : !pSSaaSSysVer.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSaaSSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isValidFlagDirty() : !pSSaaSSysVer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSaaSSysVer.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSaaSSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_VerTag(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isVerTagDirty() : !pSSaaSSysVer.isVerTagDirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getVerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag_Default(pSSaaSSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_VerTag2(boolean bl, PSSaaSSysVer pSSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysVer.isVerTag2Dirty() : !pSSaaSSysVer.isVerTag2Dirty()) {
            return null;
        }
        String string = pSSaaSSysVer.getVerTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag2_Default(pSSaaSSysVer, bl2, bl3);
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

    protected void onSyncEntity(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
        super.onSyncEntity(pSSaaSSysVer, bl);
    }

    protected void onSyncIndexEntities(PSSaaSSysVer pSSaaSSysVer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSaaSSysVer, bl);
    }

    public Object getDataContextValue(PSSaaSSysVer pSSaaSSysVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSaaSSysVer, string, iDataContextParam)) != null) {
            return object;
        }
        PSSaaSSys pSSaaSSys = pSSaaSSysVer.getPSSaaSSys();
        if (pSSaaSSys != null && pSSaaSSys.contains(string)) {
            return pSSaaSSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSaaSSysVer pSSaaSSysVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSaaSSysVer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBTypes_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSREGISTRYITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSREGISTRYITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSREGISTRYREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSREGISTRYREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DBTypes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPES", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRegistryItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRegistryItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRegistryRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRegistryRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected boolean onMergeChild(String string, String string2, PSSaaSSysVer pSSaaSSysVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSaaSSysVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        super.onUpdateParent(pSSaaSSysVer);
    }

    @Override
    protected void exportCurXmlModel(PSSaaSSysVer pSSaaSSysVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSAASSYSVER");
        if (!bl) {
            pSSaaSSysVer.setCreateDate(null);
            pSSaaSSysVer.setCreateMan(null);
            pSSaaSSysVer.setPSRegistryItemName(null);
            pSSaaSSysVer.setPSRegistryRepoName(null);
            pSSaaSSysVer.setPSSaaSSysVerId(null);
            pSSaaSSysVer.setUpdateDate(null);
            pSSaaSSysVer.setUpdateMan(null);
            super.exportCurXmlModel(pSSaaSSysVer, xmlNode, bl);
        }
    }
}

