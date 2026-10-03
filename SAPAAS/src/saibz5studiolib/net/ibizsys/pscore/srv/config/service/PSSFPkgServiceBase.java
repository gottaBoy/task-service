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
import net.ibizsys.pscore.srv.config.dao.PSSFPkgDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFPkgDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPkg;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgCat;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgCatBase;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSubSysBase;
import net.ibizsys.pscore.srv.config.service.PSSFPkgVerService;
import net.ibizsys.pscore.srv.config.service.PSSFPkgVerServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStylePkgService;
import net.ibizsys.pscore.srv.config.service.PSSFStylePkgServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPkgServiceBase
extends PSCoreSysServiceBase<PSSFPkg> {
    private static final Log log = LogFactory.getLog(PSSFPkgServiceBase.class);
    public static final String DATASET_CURSF = "CurSF";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFPkgDEModel pSSFPkgDEModel;
    private PSSFPkgDAO pSSFPkgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFPkgService";
    }

    public PSSFPkgDEModel getPSSFPkgDEModel() {
        if (this.pSSFPkgDEModel == null) {
            try {
                this.pSSFPkgDEModel = (PSSFPkgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFPkgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPkgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFPkgDEModel();
    }

    public PSSFPkgDAO getPSSFPkgDAO() {
        if (this.pSSFPkgDAO == null) {
            try {
                this.pSSFPkgDAO = (PSSFPkgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFPkgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPkgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFPkgDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSF, (boolean)true) == 0) {
            return this.fetchCurSF(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSFPkg pSSFPkg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPKG_PSDEVCENTER_PSDCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDC(pSSFPkg, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPKG_PSSFPKGCAT_PSSFPKGCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgCatService", (SessionFactory)this.getSessionFactory());
            PSSFPkgCat pSSFPkgCat = (PSSFPkgCat)iService.getDEModel().createEntity();
            pSSFPkgCat.set("PSSFPKGCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFPkgCat);
            } else {
                iService.get(pSSFPkgCat);
            }
            this.onFillParentInfo_PSSFPkgCat(pSSFPkg, pSSFPkgCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPKG_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSSFPkg, pSSF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPKG_PSSUBSYS_PSSUBSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysService", (SessionFactory)this.getSessionFactory());
            PSSubSys pSSubSys = (PSSubSys)iService.getDEModel().createEntity();
            pSSubSys.set("PSSUBSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSys);
            } else {
                iService.get(pSSubSys);
            }
            this.onFillParentInfo_PSSubSys(pSSFPkg, pSSubSys);
            return;
        }
        super.onFillParentInfo(pSSFPkg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDC(PSSFPkg pSSFPkg, PSDevCenter pSDevCenter) throws Exception {
        pSSFPkg.setPSDCId(pSDevCenter.getPSDevCenterId());
        pSSFPkg.setPSDCName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSFPkgCat(PSSFPkg pSSFPkg, PSSFPkgCat pSSFPkgCat) throws Exception {
        pSSFPkg.setPSSFPkgCatId(pSSFPkgCat.getPSSFPkgCatId());
        pSSFPkg.setPSSFPkgCatName(pSSFPkgCat.getPSSFPkgCatName());
    }

    protected void onFillParentInfo_PSSF(PSSFPkg pSSFPkg, PSSF pSSF) throws Exception {
        pSSFPkg.setPSSFId(pSSF.getPSSFId());
        pSSFPkg.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillParentInfo_PSSubSys(PSSFPkg pSSFPkg, PSSubSys pSSubSys) throws Exception {
        pSSFPkg.setPSSubSysId(pSSubSys.getPSSubSysId());
        pSSFPkg.setPSSubSysName(pSSubSys.getPSSubSysName());
    }

    protected void onFillEntityFullInfo(PSSFPkg pSSFPkg, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSFPkg, bl);
        this.onFillEntityFullInfo_PSDC(pSSFPkg, bl);
        this.onFillEntityFullInfo_PSSFPkgCat(pSSFPkg, bl);
        this.onFillEntityFullInfo_PSSF(pSSFPkg, bl);
        this.onFillEntityFullInfo_PSSubSys(pSSFPkg, bl);
    }

    protected void onFillEntityFullInfo_PSDC(PSSFPkg pSSFPkg, boolean bl) throws Exception {
        if (pSSFPkg.isPSDCIdDirty()) {
            if (pSSFPkg.getPSDCId() != null) {
                if (pSSFPkg.getPSDCId() == null || pSSFPkg.getPSDCName() == null) {
                    PSDevCenter pSDevCenter = pSSFPkg.getPSDC();
                    pSSFPkg.setPSDCName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSSFPkg.setPSDCName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFPkgCat(PSSFPkg pSSFPkg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSF(PSSFPkg pSSFPkg, boolean bl) throws Exception {
        if (pSSFPkg.isPSSFIdDirty()) {
            if (pSSFPkg.getPSSFId() != null) {
                if (pSSFPkg.getPSSFId() == null || pSSFPkg.getPSSFName() == null) {
                    PSSF pSSF = pSSFPkg.getPSSF();
                    pSSFPkg.setPSSFName(pSSF.getPSSFName());
                }
            } else {
                pSSFPkg.setPSSFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubSys(PSSFPkg pSSFPkg, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFPkg pSSFPkg, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFPkg, bl);
    }

    public ArrayList<PSSFPkg> selectByPSDC(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSSFPkg> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSSFPkg> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSSFPkg> selectByPSSFPkgCat(PSSFPkgCatBase pSSFPkgCatBase) throws Exception {
        return this.selectByPSSFPkgCat(pSSFPkgCatBase, "", -1);
    }

    public ArrayList<PSSFPkg> selectByPSSFPkgCat(PSSFPkgCatBase pSSFPkgCatBase, String string) throws Exception {
        return this.selectByPSSFPkgCat(pSSFPkgCatBase, string, -1);
    }

    public ArrayList<PSSFPkg> selectByPSSFPkgCat(PSSFPkgCatBase pSSFPkgCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFPKGCATID", (Object)pSSFPkgCatBase.getPSSFPkgCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFPkgCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFPkgCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFPkg> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSSFPkg> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSSFPkg> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFPkg> selectByPSSubSys(PSSubSysBase pSSubSysBase) throws Exception {
        return this.selectByPSSubSys(pSSubSysBase, "", -1);
    }

    public ArrayList<PSSFPkg> selectByPSSubSys(PSSubSysBase pSSubSysBase, String string) throws Exception {
        return this.selectByPSSubSys(pSSubSysBase, string, -1);
    }

    public ArrayList<PSSFPkg> selectByPSSubSys(PSSubSysBase pSSubSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSID", (Object)pSSubSysBase.getPSSubSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSDC(pSDevCenter);
        for (PSSFPkg pSSFPkg : arrayList) {
            PSSFPkg pSSFPkg2 = (PSSFPkg)this.getDEModel().createEntity();
            pSSFPkg2.setPSSFPkgId(pSSFPkg.getPSSFPkgId());
            pSSFPkg2.setPSDCId(null);
            this.update(pSSFPkg2);
        }
    }

    public void removeByPSDC(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPkgServiceBase.this.onBeforeRemoveByPSDC(pSDevCenter2);
                PSSFPkgServiceBase.this.internalRemoveByPSDC(pSDevCenter2);
                PSSFPkgServiceBase.this.onAfterRemoveByPSDC(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSDC(pSDevCenter);
        this.onBeforeRemoveByPSDC(pSDevCenter, arrayList);
        for (PSSFPkg pSSFPkg : arrayList) {
            this.remove(pSSFPkg);
        }
        this.onAfterRemoveByPSDC(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSSFPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSSFPkg> arrayList) throws Exception {
    }

    public void testRemoveByPSSFPkgCat(PSSFPkgCat pSSFPkgCat) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSSFPkgCat(pSSFPkgCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFPKGCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSFPkgCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFPKG_PSSFPKGCAT_PSSFPKGCATID", "", iDataEntityModel.getName(), "PSSFPKG", iDataEntityModel.getDataInfo(pSSFPkgCat), arrayList.get(0)));
        }
    }

    public void resetPSSFPkgCat(PSSFPkgCat pSSFPkgCat) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSSFPkgCat(pSSFPkgCat);
        for (PSSFPkg pSSFPkg : arrayList) {
            PSSFPkg pSSFPkg2 = (PSSFPkg)this.getDEModel().createEntity();
            pSSFPkg2.setPSSFPkgId(pSSFPkg.getPSSFPkgId());
            pSSFPkg2.setPSSFPkgCatId(null);
            this.update(pSSFPkg2);
        }
    }

    public void removeByPSSFPkgCat(PSSFPkgCat pSSFPkgCat) throws Exception {
        final PSSFPkgCat pSSFPkgCat2 = pSSFPkgCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPkgServiceBase.this.onBeforeRemoveByPSSFPkgCat(pSSFPkgCat2);
                PSSFPkgServiceBase.this.internalRemoveByPSSFPkgCat(pSSFPkgCat2);
                PSSFPkgServiceBase.this.onAfterRemoveByPSSFPkgCat(pSSFPkgCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPkgCat(PSSFPkgCat pSSFPkgCat) throws Exception {
    }

    protected void internalRemoveByPSSFPkgCat(PSSFPkgCat pSSFPkgCat) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSSFPkgCat(pSSFPkgCat);
        this.onBeforeRemoveByPSSFPkgCat(pSSFPkgCat, arrayList);
        for (PSSFPkg pSSFPkg : arrayList) {
            this.remove(pSSFPkg);
        }
        this.onAfterRemoveByPSSFPkgCat(pSSFPkgCat, arrayList);
    }

    protected void onAfterRemoveByPSSFPkgCat(PSSFPkgCat pSSFPkgCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPkgCat(PSSFPkgCat pSSFPkgCat, ArrayList<PSSFPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPkgCat(PSSFPkgCat pSSFPkgCat, ArrayList<PSSFPkg> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSSF(pSSF);
        for (PSSFPkg pSSFPkg : arrayList) {
            PSSFPkg pSSFPkg2 = (PSSFPkg)this.getDEModel().createEntity();
            pSSFPkg2.setPSSFPkgId(pSSFPkg.getPSSFPkgId());
            pSSFPkg2.setPSSFId(null);
            this.update(pSSFPkg2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPkgServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSSFPkgServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSSFPkgServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSSFPkg pSSFPkg : arrayList) {
            this.remove(pSSFPkg);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSSFPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSSFPkg> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSSubSys(pSSubSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFPKG_PSSUBSYS_PSSUBSYSID", "", iDataEntityModel.getName(), "PSSFPKG", iDataEntityModel.getDataInfo(pSSubSys), arrayList.get(0)));
        }
    }

    public void resetPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSSubSys(pSSubSys);
        for (PSSFPkg pSSFPkg : arrayList) {
            PSSFPkg pSSFPkg2 = (PSSFPkg)this.getDEModel().createEntity();
            pSSFPkg2.setPSSFPkgId(pSSFPkg.getPSSFPkgId());
            pSSFPkg2.setPSSubSysId(null);
            this.update(pSSFPkg2);
        }
    }

    public void removeByPSSubSys(PSSubSys pSSubSys) throws Exception {
        final PSSubSys pSSubSys2 = pSSubSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPkgServiceBase.this.onBeforeRemoveByPSSubSys(pSSubSys2);
                PSSFPkgServiceBase.this.internalRemoveByPSSubSys(pSSubSys2);
                PSSFPkgServiceBase.this.onAfterRemoveByPSSubSys(pSSubSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void internalRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSSFPkg> arrayList = this.selectByPSSubSys(pSSubSys);
        this.onBeforeRemoveByPSSubSys(pSSubSys, arrayList);
        for (PSSFPkg pSSFPkg : arrayList) {
            this.remove(pSSFPkg);
        }
        this.onAfterRemoveByPSSubSys(pSSubSys, arrayList);
    }

    protected void onAfterRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSys(PSSubSys pSSubSys, ArrayList<PSSFPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSys(PSSubSys pSSubSys, ArrayList<PSSFPkg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFPkg pSSFPkg) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCSFPkgService)ServiceGlobal.getService(PSDCSFPkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSFPkgServiceBase)pSCoreSysServiceBase).testRemoveByPSSFPkg(pSSFPkg);
        ((PSDCSFPkgServiceBase)pSCoreSysServiceBase).resetPSSFPkg(pSSFPkg);
        pSCoreSysServiceBase = (PSSFPkgVerService)ServiceGlobal.getService(PSSFPkgVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPkgVerServiceBase)pSCoreSysServiceBase).testRemoveByPSSFPkg(pSSFPkg);
        ((PSSFPkgVerServiceBase)pSCoreSysServiceBase).removeByPSSFPkg(pSSFPkg);
        pSCoreSysServiceBase = (PSSFStylePkgService)ServiceGlobal.getService(PSSFStylePkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStylePkgServiceBase)pSCoreSysServiceBase).testRemoveByPSSFPkg(pSSFPkg);
        super.onBeforeRemove(pSSFPkg);
    }

    protected void replaceParentInfo(PSSFPkg pSSFPkg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFPkg, cloneSession);
        if (pSSFPkg.getPSDCId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSSFPkg.getPSDCId())) != null) {
            this.onFillParentInfo_PSDC(pSSFPkg, (PSDevCenter)iEntity);
        }
        if (pSSFPkg.getPSSFPkgCatId() != null && (iEntity = cloneSession.getEntity("PSSFPKGCAT", (Object)pSSFPkg.getPSSFPkgCatId())) != null) {
            this.onFillParentInfo_PSSFPkgCat(pSSFPkg, (PSSFPkgCat)iEntity);
        }
        if (pSSFPkg.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSFPkg.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSSFPkg, (PSSF)iEntity);
        }
        if (pSSFPkg.getPSSubSysId() != null && (iEntity = cloneSession.getEntity("PSSUBSYS", (Object)pSSFPkg.getPSSubSysId())) != null) {
            this.onFillParentInfo_PSSubSys(pSSFPkg, (PSSubSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFPkg pSSFPkg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFPkg, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSFPkg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OSLic(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgTag(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgTag2(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCId(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCName(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgCatId(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgId(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgName(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysId(bl, pSSFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFPkg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isMemoDirty() : !pSSFPkg.isMemoDirty()) {
            return null;
        }
        String string = pSSFPkg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_OSLic(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isOSLicDirty() : !pSSFPkg.isOSLicDirty()) {
            return null;
        }
        String string = pSSFPkg.getOSLic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OSLic_Default(pSSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OSLIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgTag(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPkgTagDirty() : !pSSFPkg.isPkgTagDirty()) {
            return null;
        }
        String string = pSSFPkg.getPkgTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgTag_Default(pSSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgTag2(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPkgTag2Dirty() : !pSSFPkg.isPkgTag2Dirty()) {
            return null;
        }
        String string = pSSFPkg.getPkgTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgTag2_Default(pSSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCId(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPSDCIdDirty() : !pSSFPkg.isPSDCIdDirty()) {
            return null;
        }
        String string = pSSFPkg.getPSDCId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCId_Default(pSSFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCName(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPSDCNameDirty() : !pSSFPkg.isPSDCNameDirty()) {
            return null;
        }
        String string = pSSFPkg.getPSDCName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCName_Default(pSSFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPSSFIdDirty() : !pSSFPkg.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSFPkg.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPSSFNameDirty() : !pSSFPkg.isPSSFNameDirty()) {
            return null;
        }
        String string = pSSFPkg.getPSSFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgCatId(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPSSFPkgCatIdDirty() : !pSSFPkg.isPSSFPkgCatIdDirty()) {
            return null;
        }
        String string = pSSFPkg.getPSSFPkgCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgCatId_Default(pSSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgId(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPSSFPkgIdDirty() && !bl2 : !pSSFPkg.isPSSFPkgIdDirty()) {
            return null;
        }
        String string = pSSFPkg.getPSSFPkgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgId_Default(pSSFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFPkgName(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPSSFPkgNameDirty() && !bl2 : !pSSFPkg.isPSSFPkgNameDirty()) {
            return null;
        }
        String string = pSSFPkg.getPSSFPkgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgName_Default(pSSFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysId(boolean bl, PSSFPkg pSSFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkg.isPSSubSysIdDirty() : !pSSFPkg.isPSSubSysIdDirty()) {
            return null;
        }
        String string = pSSFPkg.getPSSubSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysId_Default(pSSFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFPkg pSSFPkg, boolean bl) throws Exception {
        super.onSyncEntity(pSSFPkg, bl);
    }

    protected void onSyncIndexEntities(PSSFPkg pSSFPkg, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFPkg, bl);
    }

    public Object getDataContextValue(PSSFPkg pSSFPkg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFPkg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSFPkg pSSFPkg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFPkg, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"OSLIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OSLic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_OSLic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OSLIC", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSubSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSFPkg pSSFPkg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFPkg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFPkg pSSFPkg) throws Exception {
        super.onUpdateParent(pSSFPkg);
    }

    @Override
    protected void exportCurXmlModel(PSSFPkg pSSFPkg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFPKG");
        if (!bl) {
            pSSFPkg.setCreateDate(null);
            pSSFPkg.setCreateMan(null);
            pSSFPkg.setPSSFPkgCatName(null);
            pSSFPkg.setPSSFPkgId(null);
            pSSFPkg.setUpdateDate(null);
            pSSFPkg.setUpdateMan(null);
            super.exportCurXmlModel(pSSFPkg, xmlNode, bl);
        }
    }
}

