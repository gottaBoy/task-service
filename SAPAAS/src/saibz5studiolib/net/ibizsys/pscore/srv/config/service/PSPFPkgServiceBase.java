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
import net.ibizsys.pscore.srv.appdesign.service.PSAppPkgService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPkgServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSPFPkgDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFPkgDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPkg;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgCat;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgCatBase;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerCDNService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerCDNServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStylePkgService;
import net.ibizsys.pscore.srv.config.service.PSPFStylePkgServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPkgServiceBase
extends PSCoreSysServiceBase<PSPFPkg> {
    private static final Log log = LogFactory.getLog(PSPFPkgServiceBase.class);
    public static final String DATASET_CURPF = "CurPF";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFPkgDEModel pSPFPkgDEModel;
    private PSPFPkgDAO pSPFPkgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFPkgService";
    }

    public PSPFPkgDEModel getPSPFPkgDEModel() {
        if (this.pSPFPkgDEModel == null) {
            try {
                this.pSPFPkgDEModel = (PSPFPkgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPkgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPkgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFPkgDEModel();
    }

    public PSPFPkgDAO getPSPFPkgDAO() {
        if (this.pSPFPkgDAO == null) {
            try {
                this.pSPFPkgDAO = (PSPFPkgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFPkgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPkgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFPkgDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPF, (boolean)true) == 0) {
            return this.fetchCurPF(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurPF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSPFPkg pSPFPkg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKG_PSDEVCENTER_PSDCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDC(pSPFPkg, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKG_PSPFPKGCAT_PSPFPKGCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgCatService", (SessionFactory)this.getSessionFactory());
            PSPFPkgCat pSPFPkgCat = (PSPFPkgCat)iService.getDEModel().createEntity();
            pSPFPkgCat.set("PSPFPKGCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPkgCat);
            } else {
                iService.get(pSPFPkgCat);
            }
            this.onFillParentInfo_PSPFPkgCat(pSPFPkg, pSPFPkgCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKG_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFPkg, pSPF);
            return;
        }
        super.onFillParentInfo(pSPFPkg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDC(PSPFPkg pSPFPkg, PSDevCenter pSDevCenter) throws Exception {
        pSPFPkg.setPSDCId(pSDevCenter.getPSDevCenterId());
        pSPFPkg.setPSDCName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSPFPkgCat(PSPFPkg pSPFPkg, PSPFPkgCat pSPFPkgCat) throws Exception {
        pSPFPkg.setPSPFPkgCatId(pSPFPkgCat.getPSPFPkgCatId());
        pSPFPkg.setPSPFPkgCatName(pSPFPkgCat.getPSPFPkgCatName());
    }

    protected void onFillParentInfo_PSPF(PSPFPkg pSPFPkg, PSPF pSPF) throws Exception {
        pSPFPkg.setPSPFId(pSPF.getPSPFId());
        pSPFPkg.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillEntityFullInfo(PSPFPkg pSPFPkg, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPFPkg, bl);
        this.onFillEntityFullInfo_PSDC(pSPFPkg, bl);
        this.onFillEntityFullInfo_PSPFPkgCat(pSPFPkg, bl);
        this.onFillEntityFullInfo_PSPF(pSPFPkg, bl);
    }

    protected void onFillEntityFullInfo_PSDC(PSPFPkg pSPFPkg, boolean bl) throws Exception {
        if (pSPFPkg.isPSDCIdDirty()) {
            if (pSPFPkg.getPSDCId() != null) {
                if (pSPFPkg.getPSDCId() == null || pSPFPkg.getPSDCName() == null) {
                    PSDevCenter pSDevCenter = pSPFPkg.getPSDC();
                    pSPFPkg.setPSDCName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSPFPkg.setPSDCName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPFPkgCat(PSPFPkg pSPFPkg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSPFPkg pSPFPkg, boolean bl) throws Exception {
        if (pSPFPkg.isPSPFIdDirty()) {
            if (pSPFPkg.getPSPFId() != null) {
                if (pSPFPkg.getPSPFId() == null || pSPFPkg.getPSPFName() == null) {
                    PSPF pSPF = pSPFPkg.getPSPF();
                    pSPFPkg.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSPFPkg.setPSPFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPFPkg pSPFPkg, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFPkg, bl);
    }

    public ArrayList<PSPFPkg> selectByPSDC(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSPFPkg> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSPFPkg> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFPkg> selectByPSPFPkgCat(PSPFPkgCatBase pSPFPkgCatBase) throws Exception {
        return this.selectByPSPFPkgCat(pSPFPkgCatBase, "", -1);
    }

    public ArrayList<PSPFPkg> selectByPSPFPkgCat(PSPFPkgCatBase pSPFPkgCatBase, String string) throws Exception {
        return this.selectByPSPFPkgCat(pSPFPkgCatBase, string, -1);
    }

    public ArrayList<PSPFPkg> selectByPSPFPkgCat(PSPFPkgCatBase pSPFPkgCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPKGCATID", (Object)pSPFPkgCatBase.getPSPFPkgCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPkgCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPkgCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFPkg> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFPkg> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFPkg> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFPkg> arrayList = this.selectByPSDC(pSDevCenter);
        for (PSPFPkg pSPFPkg : arrayList) {
            PSPFPkg pSPFPkg2 = (PSPFPkg)this.getDEModel().createEntity();
            pSPFPkg2.setPSPFPkgId(pSPFPkg.getPSPFPkgId());
            pSPFPkg2.setPSDCId(null);
            this.update(pSPFPkg2);
        }
    }

    public void removeByPSDC(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgServiceBase.this.onBeforeRemoveByPSDC(pSDevCenter2);
                PSPFPkgServiceBase.this.internalRemoveByPSDC(pSDevCenter2);
                PSPFPkgServiceBase.this.onAfterRemoveByPSDC(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFPkg> arrayList = this.selectByPSDC(pSDevCenter);
        this.onBeforeRemoveByPSDC(pSDevCenter, arrayList);
        for (PSPFPkg pSPFPkg : arrayList) {
            this.remove(pSPFPkg);
        }
        this.onAfterRemoveByPSDC(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSPFPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSPFPkg> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPkgCat(PSPFPkgCat pSPFPkgCat) throws Exception {
        ArrayList<PSPFPkg> arrayList = this.selectByPSPFPkgCat(pSPFPkgCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPKGCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPkgCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPKG_PSPFPKGCAT_PSPFPKGCATID", "", iDataEntityModel.getName(), "PSPFPKG", iDataEntityModel.getDataInfo(pSPFPkgCat), arrayList.get(0)));
        }
    }

    public void resetPSPFPkgCat(PSPFPkgCat pSPFPkgCat) throws Exception {
        ArrayList<PSPFPkg> arrayList = this.selectByPSPFPkgCat(pSPFPkgCat);
        for (PSPFPkg pSPFPkg : arrayList) {
            PSPFPkg pSPFPkg2 = (PSPFPkg)this.getDEModel().createEntity();
            pSPFPkg2.setPSPFPkgId(pSPFPkg.getPSPFPkgId());
            pSPFPkg2.setPSPFPkgCatId(null);
            this.update(pSPFPkg2);
        }
    }

    public void removeByPSPFPkgCat(PSPFPkgCat pSPFPkgCat) throws Exception {
        final PSPFPkgCat pSPFPkgCat2 = pSPFPkgCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgServiceBase.this.onBeforeRemoveByPSPFPkgCat(pSPFPkgCat2);
                PSPFPkgServiceBase.this.internalRemoveByPSPFPkgCat(pSPFPkgCat2);
                PSPFPkgServiceBase.this.onAfterRemoveByPSPFPkgCat(pSPFPkgCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPkgCat(PSPFPkgCat pSPFPkgCat) throws Exception {
    }

    protected void internalRemoveByPSPFPkgCat(PSPFPkgCat pSPFPkgCat) throws Exception {
        ArrayList<PSPFPkg> arrayList = this.selectByPSPFPkgCat(pSPFPkgCat);
        this.onBeforeRemoveByPSPFPkgCat(pSPFPkgCat, arrayList);
        for (PSPFPkg pSPFPkg : arrayList) {
            this.remove(pSPFPkg);
        }
        this.onAfterRemoveByPSPFPkgCat(pSPFPkgCat, arrayList);
    }

    protected void onAfterRemoveByPSPFPkgCat(PSPFPkgCat pSPFPkgCat) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPkgCat(PSPFPkgCat pSPFPkgCat, ArrayList<PSPFPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPkgCat(PSPFPkgCat pSPFPkgCat, ArrayList<PSPFPkg> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPkg> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPKG_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSPFPKG", iDataEntityModel.getDataInfo(pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPkg> arrayList = this.selectByPSPF(pSPF);
        for (PSPFPkg pSPFPkg : arrayList) {
            PSPFPkg pSPFPkg2 = (PSPFPkg)this.getDEModel().createEntity();
            pSPFPkg2.setPSPFPkgId(pSPFPkg.getPSPFPkgId());
            pSPFPkg2.setPSPFId(null);
            this.update(pSPFPkg2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFPkgServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFPkgServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPkg> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFPkg pSPFPkg : arrayList) {
            this.remove(pSPFPkg);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFPkg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFPkg pSPFPkg) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPkgServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPkg(pSPFPkg);
        ((PSAppPkgServiceBase)pSCoreSysServiceBase).resetPSPFPkg(pSPFPkg);
        pSCoreSysServiceBase = (PSPFPkgVerCDNService)ServiceGlobal.getService(PSPFPkgVerCDNService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPkgVerCDNServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPkg(pSPFPkg);
        pSCoreSysServiceBase = (PSPFPkgVerService)ServiceGlobal.getService(PSPFPkgVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPkgVerServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPkg(pSPFPkg);
        ((PSPFPkgVerServiceBase)pSCoreSysServiceBase).removeByPSPFPkg(pSPFPkg);
        pSCoreSysServiceBase = (PSPFStylePkgService)ServiceGlobal.getService(PSPFStylePkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStylePkgServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPkg(pSPFPkg);
        super.onBeforeRemove(pSPFPkg);
    }

    protected void replaceParentInfo(PSPFPkg pSPFPkg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFPkg, cloneSession);
        if (pSPFPkg.getPSDCId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSPFPkg.getPSDCId())) != null) {
            this.onFillParentInfo_PSDC(pSPFPkg, (PSDevCenter)iEntity);
        }
        if (pSPFPkg.getPSPFPkgCatId() != null && (iEntity = cloneSession.getEntity("PSPFPKGCAT", (Object)pSPFPkg.getPSPFPkgCatId())) != null) {
            this.onFillParentInfo_PSPFPkgCat(pSPFPkg, (PSPFPkgCat)iEntity);
        }
        if (pSPFPkg.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFPkg.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFPkg, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFPkg pSPFPkg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFPkg, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSPFPkg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OSLic(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam2(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam3(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam4(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgTag(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgTag2(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCId(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCName(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgCatId(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgId(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgName(bl, pSPFPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFPkg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isMemoDirty() : !pSPFPkg.isMemoDirty()) {
            return null;
        }
        String string = pSPFPkg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_OSLic(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isOSLicDirty() : !pSPFPkg.isOSLicDirty()) {
            return null;
        }
        String string = pSPFPkg.getOSLic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OSLic_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPkgParamDirty() : !pSPFPkg.isPkgParamDirty()) {
            return null;
        }
        String string = pSPFPkg.getPkgParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam2(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPkgParam2Dirty() : !pSPFPkg.isPkgParam2Dirty()) {
            return null;
        }
        String string = pSPFPkg.getPkgParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam2_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam3(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPkgParam3Dirty() : !pSPFPkg.isPkgParam3Dirty()) {
            return null;
        }
        String string = pSPFPkg.getPkgParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam3_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam4(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPkgParam4Dirty() : !pSPFPkg.isPkgParam4Dirty()) {
            return null;
        }
        String string = pSPFPkg.getPkgParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam4_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgTag(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPkgTagDirty() : !pSPFPkg.isPkgTagDirty()) {
            return null;
        }
        String string = pSPFPkg.getPkgTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgTag_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgTag2(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPkgTag2Dirty() : !pSPFPkg.isPkgTag2Dirty()) {
            return null;
        }
        String string = pSPFPkg.getPkgTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgTag2_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCId(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPSDCIdDirty() : !pSPFPkg.isPSDCIdDirty()) {
            return null;
        }
        String string = pSPFPkg.getPSDCId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCId_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCName(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPSDCNameDirty() : !pSPFPkg.isPSDCNameDirty()) {
            return null;
        }
        String string = pSPFPkg.getPSDCName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCName_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPSPFIdDirty() : !pSPFPkg.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFPkg.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSPFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPSPFNameDirty() : !pSPFPkg.isPSPFNameDirty()) {
            return null;
        }
        String string = pSPFPkg.getPSPFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default(pSPFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPkgCatId(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPSPFPkgCatIdDirty() : !pSPFPkg.isPSPFPkgCatIdDirty()) {
            return null;
        }
        String string = pSPFPkg.getPSPFPkgCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgCatId_Default(pSPFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPkgId(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPSPFPkgIdDirty() && !bl2 : !pSPFPkg.isPSPFPkgIdDirty()) {
            return null;
        }
        String string = pSPFPkg.getPSPFPkgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgId_Default(pSPFPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPkgName(boolean bl, PSPFPkg pSPFPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkg.isPSPFPkgNameDirty() && !bl2 : !pSPFPkg.isPSPFPkgNameDirty()) {
            return null;
        }
        String string = pSPFPkg.getPSPFPkgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgName_Default(pSPFPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPFPkg pSPFPkg, boolean bl) throws Exception {
        super.onSyncEntity(pSPFPkg, bl);
    }

    protected void onSyncIndexEntities(PSPFPkg pSPFPkg, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFPkg, bl);
    }

    public Object getDataContextValue(PSPFPkg pSPFPkg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFPkg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFPkg pSPFPkg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFPkg, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPkgCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPkgCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPFPkg pSPFPkg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFPkg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFPkg pSPFPkg) throws Exception {
        super.onUpdateParent(pSPFPkg);
    }

    @Override
    protected void exportCurXmlModel(PSPFPkg pSPFPkg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFPKG");
        if (!bl) {
            pSPFPkg.setCreateDate(null);
            pSPFPkg.setCreateMan(null);
            pSPFPkg.setPSPFPkgCatName(null);
            pSPFPkg.setPSPFPkgId(null);
            pSPFPkg.setUpdateDate(null);
            pSPFPkg.setUpdateMan(null);
            super.exportCurXmlModel(pSPFPkg, xmlNode, bl);
        }
    }
}

