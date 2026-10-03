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
import net.ibizsys.pscore.srv.config.dao.PSPFPkgVerCDNDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFPkgVerCDNDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFCDN;
import net.ibizsys.pscore.srv.config.entity.PSPFCDNBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPkg;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVer;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVerBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVerCDN;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPkgVerCDNServiceBase
extends PSCoreSysServiceBase<PSPFPkgVerCDN> {
    private static final Log log = LogFactory.getLog(PSPFPkgVerCDNServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFPkgVerCDNDEModel pSPFPkgVerCDNDEModel;
    private PSPFPkgVerCDNDAO pSPFPkgVerCDNDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFPkgVerCDNService";
    }

    public PSPFPkgVerCDNDEModel getPSPFPkgVerCDNDEModel() {
        if (this.pSPFPkgVerCDNDEModel == null) {
            try {
                this.pSPFPkgVerCDNDEModel = (PSPFPkgVerCDNDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPkgVerCDNDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPkgVerCDNDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFPkgVerCDNDEModel();
    }

    public PSPFPkgVerCDNDAO getPSPFPkgVerCDNDAO() {
        if (this.pSPFPkgVerCDNDAO == null) {
            try {
                this.pSPFPkgVerCDNDAO = (PSPFPkgVerCDNDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFPkgVerCDNDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPkgVerCDNDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFPkgVerCDNDAO();
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

    protected void onFillParentInfo(PSPFPkgVerCDN pSPFPkgVerCDN, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKGVERCDN_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSPFPkgVerCDN, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKGVERCDN_PSPFCDN_PSPFCDNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFCDNService", (SessionFactory)this.getSessionFactory());
            PSPFCDN pSPFCDN = (PSPFCDN)iService.getDEModel().createEntity();
            pSPFCDN.set("PSPFCDNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFCDN);
            } else {
                iService.get(pSPFCDN);
            }
            this.onFillParentInfo_PSPFCDN(pSPFPkgVerCDN, pSPFCDN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKGVERCDN_PSPFPKGVER_PSPFPKGVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgVerService", (SessionFactory)this.getSessionFactory());
            PSPFPkgVer pSPFPkgVer = (PSPFPkgVer)iService.getDEModel().createEntity();
            pSPFPkgVer.set("PSPFPKGVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPkgVer);
            } else {
                iService.get(pSPFPkgVer);
            }
            this.onFillParentInfo_PSPFPkgVer(pSPFPkgVerCDN, pSPFPkgVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKGVERCDN_PSPFPKG_PSPFPKGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgService", (SessionFactory)this.getSessionFactory());
            PSPFPkg pSPFPkg = (PSPFPkg)iService.getDEModel().createEntity();
            pSPFPkg.set("PSPFPKGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPkg);
            } else {
                iService.get(pSPFPkg);
            }
            this.onFillParentInfo_PSPFPkg(pSPFPkgVerCDN, pSPFPkg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPKGVERCDN_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFPkgVerCDN, pSPF);
            return;
        }
        super.onFillParentInfo(pSPFPkgVerCDN, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSPFPkgVerCDN pSPFPkgVerCDN, PSDevCenter pSDevCenter) throws Exception {
        pSPFPkgVerCDN.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSPFPkgVerCDN.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSPFCDN(PSPFPkgVerCDN pSPFPkgVerCDN, PSPFCDN pSPFCDN) throws Exception {
        pSPFPkgVerCDN.setPSPFCDNId(pSPFCDN.getPSPFCDNId());
        pSPFPkgVerCDN.setPSPFCDNName(pSPFCDN.getPSPFCDNName());
    }

    protected void onFillParentInfo_PSPFPkgVer(PSPFPkgVerCDN pSPFPkgVerCDN, PSPFPkgVer pSPFPkgVer) throws Exception {
        pSPFPkgVerCDN.setPSPFPkgVerId(pSPFPkgVer.getPSPFPkgVerId());
        pSPFPkgVerCDN.setPSPFPkgVerName(pSPFPkgVer.getPSPFPkgVerName());
    }

    protected void onFillParentInfo_PSPFPkg(PSPFPkgVerCDN pSPFPkgVerCDN, PSPFPkg pSPFPkg) throws Exception {
        pSPFPkgVerCDN.setPSPFPkgId(pSPFPkg.getPSPFPkgId());
        pSPFPkgVerCDN.setPSPFPkgName(pSPFPkg.getPSPFPkgName());
    }

    protected void onFillParentInfo_PSPF(PSPFPkgVerCDN pSPFPkgVerCDN, PSPF pSPF) throws Exception {
        pSPFPkgVerCDN.setPSPFId(pSPF.getPSPFId());
        pSPFPkgVerCDN.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillEntityFullInfo(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPFPkgVerCDN, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSPFPkgVerCDN, bl);
        this.onFillEntityFullInfo_PSPFCDN(pSPFPkgVerCDN, bl);
        this.onFillEntityFullInfo_PSPFPkgVer(pSPFPkgVerCDN, bl);
        this.onFillEntityFullInfo_PSPFPkg(pSPFPkgVerCDN, bl);
        this.onFillEntityFullInfo_PSPF(pSPFPkgVerCDN, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
        if (pSPFPkgVerCDN.isPSDevCenterIdDirty()) {
            if (pSPFPkgVerCDN.getPSDevCenterId() != null) {
                if (pSPFPkgVerCDN.getPSDevCenterId() == null || pSPFPkgVerCDN.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSPFPkgVerCDN.getPSDevCenter();
                    pSPFPkgVerCDN.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSPFPkgVerCDN.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPFCDN(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFPkgVer(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFPkg(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
        if (pSPFPkgVerCDN.isPSPFPkgIdDirty()) {
            if (pSPFPkgVerCDN.getPSPFPkgId() != null) {
                if (pSPFPkgVerCDN.getPSPFPkgId() == null || pSPFPkgVerCDN.getPSPFPkgName() == null) {
                    PSPFPkg pSPFPkg = pSPFPkgVerCDN.getPSPFPkg();
                    pSPFPkgVerCDN.setPSPFPkgName(pSPFPkg.getPSPFPkgName());
                }
            } else {
                pSPFPkgVerCDN.setPSPFPkgName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPF(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
        if (pSPFPkgVerCDN.isPSPFIdDirty()) {
            if (pSPFPkgVerCDN.getPSPFId() != null) {
                if (pSPFPkgVerCDN.getPSPFId() == null || pSPFPkgVerCDN.getPSPFName() == null) {
                    PSPF pSPF = pSPFPkgVerCDN.getPSPF();
                    pSPFPkgVerCDN.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSPFPkgVerCDN.setPSPFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFPkgVerCDN, bl);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFPkgVerCDN> selectByPSPFCDN(PSPFCDNBase pSPFCDNBase) throws Exception {
        return this.selectByPSPFCDN(pSPFCDNBase, "", -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPFCDN(PSPFCDNBase pSPFCDNBase, String string) throws Exception {
        return this.selectByPSPFCDN(pSPFCDNBase, string, -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPFCDN(PSPFCDNBase pSPFCDNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFCDNID", (Object)pSPFCDNBase.getPSPFCDNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCDNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCDNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPFPkgVer(PSPFPkgVerBase pSPFPkgVerBase) throws Exception {
        return this.selectByPSPFPkgVer(pSPFPkgVerBase, "", -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPFPkgVer(PSPFPkgVerBase pSPFPkgVerBase, String string) throws Exception {
        return this.selectByPSPFPkgVer(pSPFPkgVerBase, string, -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPFPkgVer(PSPFPkgVerBase pSPFPkgVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPKGVERID", (Object)pSPFPkgVerBase.getPSPFPkgVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPkgVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPkgVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPFPkg(PSPFPkgBase pSPFPkgBase) throws Exception {
        return this.selectByPSPFPkg(pSPFPkgBase, "", -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPFPkg(PSPFPkgBase pSPFPkgBase, String string) throws Exception {
        return this.selectByPSPFPkg(pSPFPkgBase, string, -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPFPkg(PSPFPkgBase pSPFPkgBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFPkgVerCDN> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFPkgVerCDN> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPKGVERCDN_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSPFPKGVERCDN", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            PSPFPkgVerCDN pSPFPkgVerCDN2 = (PSPFPkgVerCDN)this.getDEModel().createEntity();
            pSPFPkgVerCDN2.setPSPFPkgVerCDNId(pSPFPkgVerCDN.getPSPFPkgVerCDNId());
            pSPFPkgVerCDN2.setPSDevCenterId(null);
            this.update(pSPFPkgVerCDN2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgVerCDNServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSPFPkgVerCDNServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSPFPkgVerCDNServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            this.remove(pSPFPkgVerCDN);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    public void testRemoveByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPFCDN(pSPFCDN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFCDN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFCDN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPKGVERCDN_PSPFCDN_PSPFCDNID", "", iDataEntityModel.getName(), "PSPFPKGVERCDN", iDataEntityModel.getDataInfo(pSPFCDN), arrayList.get(0)));
        }
    }

    public void resetPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPFCDN(pSPFCDN);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            PSPFPkgVerCDN pSPFPkgVerCDN2 = (PSPFPkgVerCDN)this.getDEModel().createEntity();
            pSPFPkgVerCDN2.setPSPFPkgVerCDNId(pSPFPkgVerCDN.getPSPFPkgVerCDNId());
            pSPFPkgVerCDN2.setPSPFCDNId(null);
            this.update(pSPFPkgVerCDN2);
        }
    }

    public void removeByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
        final PSPFCDN pSPFCDN2 = pSPFCDN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgVerCDNServiceBase.this.onBeforeRemoveByPSPFCDN(pSPFCDN2);
                PSPFPkgVerCDNServiceBase.this.internalRemoveByPSPFCDN(pSPFCDN2);
                PSPFPkgVerCDNServiceBase.this.onAfterRemoveByPSPFCDN(pSPFCDN2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
    }

    protected void internalRemoveByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPFCDN(pSPFCDN);
        this.onBeforeRemoveByPSPFCDN(pSPFCDN, arrayList);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            this.remove(pSPFPkgVerCDN);
        }
        this.onAfterRemoveByPSPFCDN(pSPFCDN, arrayList);
    }

    protected void onAfterRemoveByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
    }

    protected void onBeforeRemoveByPSPFCDN(PSPFCDN pSPFCDN, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFCDN(PSPFCDN pSPFCDN, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPFPkgVer(pSPFPkgVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPKGVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPkgVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPKGVERCDN_PSPFPKGVER_PSPFPKGVERID", "", iDataEntityModel.getName(), "PSPFPKGVERCDN", iDataEntityModel.getDataInfo(pSPFPkgVer), arrayList.get(0)));
        }
    }

    public void resetPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPFPkgVer(pSPFPkgVer);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            PSPFPkgVerCDN pSPFPkgVerCDN2 = (PSPFPkgVerCDN)this.getDEModel().createEntity();
            pSPFPkgVerCDN2.setPSPFPkgVerCDNId(pSPFPkgVerCDN.getPSPFPkgVerCDNId());
            pSPFPkgVerCDN2.setPSPFPkgVerId(null);
            this.update(pSPFPkgVerCDN2);
        }
    }

    public void removeByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
        final PSPFPkgVer pSPFPkgVer2 = pSPFPkgVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgVerCDNServiceBase.this.onBeforeRemoveByPSPFPkgVer(pSPFPkgVer2);
                PSPFPkgVerCDNServiceBase.this.internalRemoveByPSPFPkgVer(pSPFPkgVer2);
                PSPFPkgVerCDNServiceBase.this.onAfterRemoveByPSPFPkgVer(pSPFPkgVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
    }

    protected void internalRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPFPkgVer(pSPFPkgVer);
        this.onBeforeRemoveByPSPFPkgVer(pSPFPkgVer, arrayList);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            this.remove(pSPFPkgVerCDN);
        }
        this.onAfterRemoveByPSPFPkgVer(pSPFPkgVer, arrayList);
    }

    protected void onAfterRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPFPkg(pSPFPkg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPKG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPkg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPKGVERCDN_PSPFPKG_PSPFPKGID", "", iDataEntityModel.getName(), "PSPFPKGVERCDN", iDataEntityModel.getDataInfo(pSPFPkg), arrayList.get(0)));
        }
    }

    public void resetPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPFPkg(pSPFPkg);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            PSPFPkgVerCDN pSPFPkgVerCDN2 = (PSPFPkgVerCDN)this.getDEModel().createEntity();
            pSPFPkgVerCDN2.setPSPFPkgVerCDNId(pSPFPkgVerCDN.getPSPFPkgVerCDNId());
            pSPFPkgVerCDN2.setPSPFPkgId(null);
            this.update(pSPFPkgVerCDN2);
        }
    }

    public void removeByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        final PSPFPkg pSPFPkg2 = pSPFPkg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgVerCDNServiceBase.this.onBeforeRemoveByPSPFPkg(pSPFPkg2);
                PSPFPkgVerCDNServiceBase.this.internalRemoveByPSPFPkg(pSPFPkg2);
                PSPFPkgVerCDNServiceBase.this.onAfterRemoveByPSPFPkg(pSPFPkg2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
    }

    protected void internalRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPFPkg(pSPFPkg);
        this.onBeforeRemoveByPSPFPkg(pSPFPkg, arrayList);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            this.remove(pSPFPkgVerCDN);
        }
        this.onAfterRemoveByPSPFPkg(pSPFPkg, arrayList);
    }

    protected void onAfterRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPkg(PSPFPkg pSPFPkg, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPkg(PSPFPkg pSPFPkg, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPF(pSPF);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            PSPFPkgVerCDN pSPFPkgVerCDN2 = (PSPFPkgVerCDN)this.getDEModel().createEntity();
            pSPFPkgVerCDN2.setPSPFPkgVerCDNId(pSPFPkgVerCDN.getPSPFPkgVerCDNId());
            pSPFPkgVerCDN2.setPSPFId(null);
            this.update(pSPFPkgVerCDN2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPkgVerCDNServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFPkgVerCDNServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFPkgVerCDNServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPkgVerCDN> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFPkgVerCDN pSPFPkgVerCDN : arrayList) {
            this.remove(pSPFPkgVerCDN);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFPkgVerCDN> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFPkgVerCDN pSPFPkgVerCDN) throws Exception {
        super.onBeforeRemove(pSPFPkgVerCDN);
    }

    protected void replaceParentInfo(PSPFPkgVerCDN pSPFPkgVerCDN, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFPkgVerCDN, cloneSession);
        if (pSPFPkgVerCDN.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSPFPkgVerCDN.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSPFPkgVerCDN, (PSDevCenter)iEntity);
        }
        if (pSPFPkgVerCDN.getPSPFCDNId() != null && (iEntity = cloneSession.getEntity("PSPFCDN", (Object)pSPFPkgVerCDN.getPSPFCDNId())) != null) {
            this.onFillParentInfo_PSPFCDN(pSPFPkgVerCDN, (PSPFCDN)iEntity);
        }
        if (pSPFPkgVerCDN.getPSPFPkgVerId() != null && (iEntity = cloneSession.getEntity("PSPFPKGVER", (Object)pSPFPkgVerCDN.getPSPFPkgVerId())) != null) {
            this.onFillParentInfo_PSPFPkgVer(pSPFPkgVerCDN, (PSPFPkgVer)iEntity);
        }
        if (pSPFPkgVerCDN.getPSPFPkgId() != null && (iEntity = cloneSession.getEntity("PSPFPKG", (Object)pSPFPkgVerCDN.getPSPFPkgId())) != null) {
            this.onFillParentInfo_PSPFPkg(pSPFPkgVerCDN, (PSPFPkg)iEntity);
        }
        if (pSPFPkgVerCDN.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFPkgVerCDN.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFPkgVerCDN, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFPkgVerCDN, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSPFPkgVerCDN, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam2(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam3(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam4(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFCDNId(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgId(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgName(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgVerCDNId(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgVerCDNName(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgVerId(bl, pSPFPkgVerCDN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFPkgVerCDN, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isMemoDirty() : !pSPFPkgVerCDN.isMemoDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPkgParamDirty() : !pSPFPkgVerCDN.isPkgParamDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPkgParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam2(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPkgParam2Dirty() : !pSPFPkgVerCDN.isPkgParam2Dirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPkgParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam2_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam3(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPkgParam3Dirty() : !pSPFPkgVerCDN.isPkgParam3Dirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPkgParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam3_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam4(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPkgParam4Dirty() : !pSPFPkgVerCDN.isPkgParam4Dirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPkgParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam4_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSDevCenterIdDirty() : !pSPFPkgVerCDN.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSDevCenterNameDirty() : !pSPFPkgVerCDN.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFCDNId(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSPFCDNIdDirty() && !bl2 : !pSPFPkgVerCDN.isPSPFCDNIdDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSPFCDNId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCDNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFCDNId_Default(pSPFPkgVerCDN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCDNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSPFIdDirty() && !bl2 : !pSPFPkgVerCDN.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSPFNameDirty() && !bl2 : !pSPFPkgVerCDN.isPSPFNameDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSPFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPkgId(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSPFPkgIdDirty() && !bl2 : !pSPFPkgVerCDN.isPSPFPkgIdDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSPFPkgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgId_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPkgName(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSPFPkgNameDirty() && !bl2 : !pSPFPkgVerCDN.isPSPFPkgNameDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSPFPkgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgName_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPkgVerCDNId(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSPFPkgVerCDNIdDirty() && !bl2 : !pSPFPkgVerCDN.isPSPFPkgVerCDNIdDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSPFPkgVerCDNId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERCDNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgVerCDNId_Default(pSPFPkgVerCDN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERCDNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPkgVerCDNName(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSPFPkgVerCDNNameDirty() && !bl2 : !pSPFPkgVerCDN.isPSPFPkgVerCDNNameDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSPFPkgVerCDNName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERCDNNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgVerCDNName_Default(pSPFPkgVerCDN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERCDNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPkgVerId(boolean bl, PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPkgVerCDN.isPSPFPkgVerIdDirty() && !bl2 : !pSPFPkgVerCDN.isPSPFPkgVerIdDirty()) {
            return null;
        }
        String string = pSPFPkgVerCDN.getPSPFPkgVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgVerId_Default(pSPFPkgVerCDN, bl2, bl3);
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

    protected void onSyncEntity(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
        super.onSyncEntity(pSPFPkgVerCDN, bl);
    }

    protected void onSyncIndexEntities(PSPFPkgVerCDN pSPFPkgVerCDN, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFPkgVerCDN, bl);
    }

    public Object getDataContextValue(PSPFPkgVerCDN pSPFPkgVerCDN, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFPkgVerCDN, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFPkgVerCDN pSPFPkgVerCDN, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFPkgVerCDN, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCDNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCDNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCDNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCDNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGVERCDNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgVerCDNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGVERCDNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgVerCDNName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSPFCDNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCDNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFCDNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCDNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSPFPkgVerCDNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGVERCDNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPkgVerCDNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGVERCDNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPFPkgVerCDN pSPFPkgVerCDN) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFPkgVerCDN)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFPkgVerCDN pSPFPkgVerCDN) throws Exception {
        super.onUpdateParent(pSPFPkgVerCDN);
    }

    @Override
    protected void exportCurXmlModel(PSPFPkgVerCDN pSPFPkgVerCDN, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFPKGVERCDN");
        if (!bl) {
            pSPFPkgVerCDN.setCreateDate(null);
            pSPFPkgVerCDN.setCreateMan(null);
            pSPFPkgVerCDN.setPSPFPkgVerCDNId(null);
            pSPFPkgVerCDN.setPSPFPkgVerName(null);
            pSPFPkgVerCDN.setUpdateDate(null);
            pSPFPkgVerCDN.setUpdateMan(null);
            super.exportCurXmlModel(pSPFPkgVerCDN, xmlNode, bl);
        }
    }
}

