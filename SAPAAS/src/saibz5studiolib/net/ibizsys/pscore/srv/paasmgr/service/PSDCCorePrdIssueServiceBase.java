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
package net.ibizsys.pscore.srv.paasmgr.service;

import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSDCCorePrdIssueDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSDCCorePrdIssueDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCat;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCatBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFunc;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFuncBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdIssue;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdIssueBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDCCorePrdIssue;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCCorePrdIssueServiceBase
extends PSCoreSysServiceBase<PSDCCorePrdIssue> {
    private static final Log log = LogFactory.getLog(PSDCCorePrdIssueServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCCorePrdIssueDEModel pSDCCorePrdIssueDEModel;
    private PSDCCorePrdIssueDAO pSDCCorePrdIssueDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueService";
    }

    public PSDCCorePrdIssueDEModel getPSDCCorePrdIssueDEModel() {
        if (this.pSDCCorePrdIssueDEModel == null) {
            try {
                this.pSDCCorePrdIssueDEModel = (PSDCCorePrdIssueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSDCCorePrdIssueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCCorePrdIssueDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCCorePrdIssueDEModel();
    }

    public PSDCCorePrdIssueDAO getPSDCCorePrdIssueDAO() {
        if (this.pSDCCorePrdIssueDAO == null) {
            try {
                this.pSDCCorePrdIssueDAO = (PSDCCorePrdIssueDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSDCCorePrdIssueDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCCorePrdIssueDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCCorePrdIssueDAO();
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

    protected void onFillParentInfo(PSDCCorePrdIssue pSDCCorePrdIssue, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCOREPRDISSUE_PSCOREPRDCAT_PSCOREPRDCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService", (SessionFactory)this.getSessionFactory());
            PSCorePrdCat pSCorePrdCat = (PSCorePrdCat)iService.getDEModel().createEntity();
            pSCorePrdCat.set("PSCOREPRDCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCorePrdCat);
            } else {
                iService.get(pSCorePrdCat);
            }
            this.onFillParentInfo_PSCorePrdCat(pSDCCorePrdIssue, pSCorePrdCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCOREPRDISSUE_PSCOREPRDFUNC_PSCOREPRDFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService", (SessionFactory)this.getSessionFactory());
            PSCorePrdFunc pSCorePrdFunc = (PSCorePrdFunc)iService.getDEModel().createEntity();
            pSCorePrdFunc.set("PSCOREPRDFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCorePrdFunc);
            } else {
                iService.get(pSCorePrdFunc);
            }
            this.onFillParentInfo_PSCorePrdFunc(pSDCCorePrdIssue, pSCorePrdFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCOREPRDISSUE_PSCOREPRDISSUE_PSCOREPRDISSUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService", (SessionFactory)this.getSessionFactory());
            PSCorePrdIssue pSCorePrdIssue = (PSCorePrdIssue)iService.getDEModel().createEntity();
            pSCorePrdIssue.set("PSCOREPRDISSUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCorePrdIssue);
            } else {
                iService.get(pSCorePrdIssue);
            }
            this.onFillParentInfo_PSCorePrdIssue(pSDCCorePrdIssue, pSCorePrdIssue);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCOREPRDISSUE_PSCOREPRD_PSCOREPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService", (SessionFactory)this.getSessionFactory());
            PSCorePrd pSCorePrd = (PSCorePrd)iService.getDEModel().createEntity();
            pSCorePrd.set("PSCOREPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCorePrd);
            } else {
                iService.get(pSCorePrd);
            }
            this.onFillParentInfo_PSCorePrd(pSDCCorePrdIssue, pSCorePrd);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCOREPRDISSUE_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCCorePrdIssue, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSDCCorePrdIssue, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCorePrdCat(PSDCCorePrdIssue pSDCCorePrdIssue, PSCorePrdCat pSCorePrdCat) throws Exception {
        pSDCCorePrdIssue.setPSCorePrdCatId(pSCorePrdCat.getPSCorePrdCatId());
        pSDCCorePrdIssue.setPSCorePrdCatName(pSCorePrdCat.getPSCorePrdCatName());
    }

    protected void onFillParentInfo_PSCorePrdFunc(PSDCCorePrdIssue pSDCCorePrdIssue, PSCorePrdFunc pSCorePrdFunc) throws Exception {
        pSDCCorePrdIssue.setPSCorePrdFuncId(pSCorePrdFunc.getPSCorePrdFuncId());
        pSDCCorePrdIssue.setPSCorePrdFuncName(pSCorePrdFunc.getPSCorePrdFuncName());
    }

    protected void onFillParentInfo_PSCorePrdIssue(PSDCCorePrdIssue pSDCCorePrdIssue, PSCorePrdIssue pSCorePrdIssue) throws Exception {
        pSDCCorePrdIssue.setPSCorePrdIssueId(pSCorePrdIssue.getPSCorePrdIssueId());
        pSDCCorePrdIssue.setPSCorePrdIssueName(pSCorePrdIssue.getPSCorePrdIssueName());
    }

    protected void onFillParentInfo_PSCorePrd(PSDCCorePrdIssue pSDCCorePrdIssue, PSCorePrd pSCorePrd) throws Exception {
        pSDCCorePrdIssue.setPSCorePrdId(pSCorePrd.getPSCorePrdId());
        pSDCCorePrdIssue.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
        if (pSCorePrd.getPSCorePrdCat() != null) {
            this.onFillParentInfo_PSCorePrdCat(pSDCCorePrdIssue, pSCorePrd.getPSCorePrdCat());
        }
    }

    protected void onFillParentInfo_PSDevCenter(PSDCCorePrdIssue pSDCCorePrdIssue, PSDevCenter pSDevCenter) throws Exception {
        pSDCCorePrdIssue.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCCorePrdIssue.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCCorePrdIssue, bl);
        this.onFillEntityFullInfo_PSCorePrdCat(pSDCCorePrdIssue, bl);
        this.onFillEntityFullInfo_PSCorePrdFunc(pSDCCorePrdIssue, bl);
        this.onFillEntityFullInfo_PSCorePrdIssue(pSDCCorePrdIssue, bl);
        this.onFillEntityFullInfo_PSCorePrd(pSDCCorePrdIssue, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCCorePrdIssue, bl);
    }

    protected void onFillEntityFullInfo_PSCorePrdCat(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        if (pSDCCorePrdIssue.isPSCorePrdCatIdDirty()) {
            if (pSDCCorePrdIssue.getPSCorePrdCatId() != null) {
                if (pSDCCorePrdIssue.getPSCorePrdCatId() == null || pSDCCorePrdIssue.getPSCorePrdCatName() == null) {
                    PSCorePrdCat pSCorePrdCat = pSDCCorePrdIssue.getPSCorePrdCat();
                    pSDCCorePrdIssue.setPSCorePrdCatName(pSCorePrdCat.getPSCorePrdCatName());
                }
            } else {
                pSDCCorePrdIssue.setPSCorePrdCatName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCorePrdFunc(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        if (pSDCCorePrdIssue.isPSCorePrdFuncIdDirty()) {
            if (pSDCCorePrdIssue.getPSCorePrdFuncId() != null) {
                if (pSDCCorePrdIssue.getPSCorePrdFuncId() == null || pSDCCorePrdIssue.getPSCorePrdFuncName() == null) {
                    PSCorePrdFunc pSCorePrdFunc = pSDCCorePrdIssue.getPSCorePrdFunc();
                    pSDCCorePrdIssue.setPSCorePrdFuncName(pSCorePrdFunc.getPSCorePrdFuncName());
                }
            } else {
                pSDCCorePrdIssue.setPSCorePrdFuncName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCorePrdIssue(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        if (pSDCCorePrdIssue.isPSCorePrdIssueIdDirty()) {
            if (pSDCCorePrdIssue.getPSCorePrdIssueId() != null) {
                if (pSDCCorePrdIssue.getPSCorePrdIssueId() == null || pSDCCorePrdIssue.getPSCorePrdIssueName() == null) {
                    PSCorePrdIssue pSCorePrdIssue = pSDCCorePrdIssue.getPSCorePrdIssue();
                    pSDCCorePrdIssue.setPSCorePrdIssueName(pSCorePrdIssue.getPSCorePrdIssueName());
                }
            } else {
                pSDCCorePrdIssue.setPSCorePrdIssueName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCorePrd(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        if (pSDCCorePrdIssue.isPSCorePrdIdDirty()) {
            if (pSDCCorePrdIssue.getPSCorePrdId() != null) {
                PSCorePrd pSCorePrd;
                if (pSDCCorePrdIssue.getPSCorePrdId() == null || pSDCCorePrdIssue.getPSCorePrdName() == null) {
                    pSCorePrd = pSDCCorePrdIssue.getPSCorePrd();
                    pSDCCorePrdIssue.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSCorePrd = pSDCCorePrdIssue.getPSCorePrd()).getPSCorePrdCatId(), (Object)pSDCCorePrdIssue.getPSCorePrdCatId()) != 0L) {
                    pSDCCorePrdIssue.setPSCorePrdCatId(pSCorePrd.getPSCorePrdCatId());
                    this.onFillEntityFullInfo_PSCorePrdCat(pSDCCorePrdIssue, bl);
                }
            } else {
                pSDCCorePrdIssue.setPSCorePrdName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        if (pSDCCorePrdIssue.isPSDevCenterIdDirty()) {
            if (pSDCCorePrdIssue.getPSDevCenterId() != null) {
                if (pSDCCorePrdIssue.getPSDevCenterId() == null || pSDCCorePrdIssue.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCCorePrdIssue.getPSDevCenter();
                    pSDCCorePrdIssue.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCCorePrdIssue.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCCorePrdIssue, bl);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrdCat(PSCorePrdCatBase pSCorePrdCatBase) throws Exception {
        return this.selectByPSCorePrdCat(pSCorePrdCatBase, "", -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrdCat(PSCorePrdCatBase pSCorePrdCatBase, String string) throws Exception {
        return this.selectByPSCorePrdCat(pSCorePrdCatBase, string, -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrdCat(PSCorePrdCatBase pSCorePrdCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDCATID", (Object)pSCorePrdCatBase.getPSCorePrdCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrdFunc(PSCorePrdFuncBase pSCorePrdFuncBase) throws Exception {
        return this.selectByPSCorePrdFunc(pSCorePrdFuncBase, "", -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrdFunc(PSCorePrdFuncBase pSCorePrdFuncBase, String string) throws Exception {
        return this.selectByPSCorePrdFunc(pSCorePrdFuncBase, string, -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrdFunc(PSCorePrdFuncBase pSCorePrdFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDFUNCID", (Object)pSCorePrdFuncBase.getPSCorePrdFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrdIssue(PSCorePrdIssueBase pSCorePrdIssueBase) throws Exception {
        return this.selectByPSCorePrdIssue(pSCorePrdIssueBase, "", -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrdIssue(PSCorePrdIssueBase pSCorePrdIssueBase, String string) throws Exception {
        return this.selectByPSCorePrdIssue(pSCorePrdIssueBase, string, -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrdIssue(PSCorePrdIssueBase pSCorePrdIssueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDISSUEID", (Object)pSCorePrdIssueBase.getPSCorePrdIssueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdIssueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdIssueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, "", -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, string, -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDID", (Object)pSCorePrdBase.getPSCorePrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCCorePrdIssue> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
    }

    public void resetPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSCorePrdCat(pSCorePrdCat);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            PSDCCorePrdIssue pSDCCorePrdIssue2 = (PSDCCorePrdIssue)this.getDEModel().createEntity();
            pSDCCorePrdIssue2.setPSDCCorePrdIssueId(pSDCCorePrdIssue.getPSDCCorePrdIssueId());
            pSDCCorePrdIssue2.setPSCorePrdCatId(null);
            this.update(pSDCCorePrdIssue2);
        }
    }

    public void removeByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        final PSCorePrdCat pSCorePrdCat2 = pSCorePrdCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCCorePrdIssueServiceBase.this.onBeforeRemoveByPSCorePrdCat(pSCorePrdCat2);
                PSDCCorePrdIssueServiceBase.this.internalRemoveByPSCorePrdCat(pSCorePrdCat2);
                PSDCCorePrdIssueServiceBase.this.onAfterRemoveByPSCorePrdCat(pSCorePrdCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
    }

    protected void internalRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSCorePrdCat(pSCorePrdCat);
        this.onBeforeRemoveByPSCorePrdCat(pSCorePrdCat, arrayList);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            this.remove(pSDCCorePrdIssue);
        }
        this.onAfterRemoveByPSCorePrdCat(pSCorePrdCat, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdCat(PSCorePrdCat pSCorePrdCat, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
    }

    public void resetPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSCorePrdFunc(pSCorePrdFunc);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            PSDCCorePrdIssue pSDCCorePrdIssue2 = (PSDCCorePrdIssue)this.getDEModel().createEntity();
            pSDCCorePrdIssue2.setPSDCCorePrdIssueId(pSDCCorePrdIssue.getPSDCCorePrdIssueId());
            pSDCCorePrdIssue2.setPSCorePrdFuncId(null);
            this.update(pSDCCorePrdIssue2);
        }
    }

    public void removeByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        final PSCorePrdFunc pSCorePrdFunc2 = pSCorePrdFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCCorePrdIssueServiceBase.this.onBeforeRemoveByPSCorePrdFunc(pSCorePrdFunc2);
                PSDCCorePrdIssueServiceBase.this.internalRemoveByPSCorePrdFunc(pSCorePrdFunc2);
                PSDCCorePrdIssueServiceBase.this.onAfterRemoveByPSCorePrdFunc(pSCorePrdFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
    }

    protected void internalRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSCorePrdFunc(pSCorePrdFunc);
        this.onBeforeRemoveByPSCorePrdFunc(pSCorePrdFunc, arrayList);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            this.remove(pSDCCorePrdIssue);
        }
        this.onAfterRemoveByPSCorePrdFunc(pSCorePrdFunc, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
    }

    public void resetPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSCorePrdIssue(pSCorePrdIssue);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            PSDCCorePrdIssue pSDCCorePrdIssue2 = (PSDCCorePrdIssue)this.getDEModel().createEntity();
            pSDCCorePrdIssue2.setPSDCCorePrdIssueId(pSDCCorePrdIssue.getPSDCCorePrdIssueId());
            pSDCCorePrdIssue2.setPSCorePrdIssueId(null);
            this.update(pSDCCorePrdIssue2);
        }
    }

    public void removeByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        final PSCorePrdIssue pSCorePrdIssue2 = pSCorePrdIssue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCCorePrdIssueServiceBase.this.onBeforeRemoveByPSCorePrdIssue(pSCorePrdIssue2);
                PSDCCorePrdIssueServiceBase.this.internalRemoveByPSCorePrdIssue(pSCorePrdIssue2);
                PSDCCorePrdIssueServiceBase.this.onAfterRemoveByPSCorePrdIssue(pSCorePrdIssue2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
    }

    protected void internalRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSCorePrdIssue(pSCorePrdIssue);
        this.onBeforeRemoveByPSCorePrdIssue(pSCorePrdIssue, arrayList);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            this.remove(pSDCCorePrdIssue);
        }
        this.onAfterRemoveByPSCorePrdIssue(pSCorePrdIssue, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    public void resetPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSCorePrd(pSCorePrd);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            PSDCCorePrdIssue pSDCCorePrdIssue2 = (PSDCCorePrdIssue)this.getDEModel().createEntity();
            pSDCCorePrdIssue2.setPSDCCorePrdIssueId(pSDCCorePrdIssue.getPSDCCorePrdIssueId());
            pSDCCorePrdIssue2.setPSCorePrdId(null);
            this.update(pSDCCorePrdIssue2);
        }
    }

    public void removeByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        final PSCorePrd pSCorePrd2 = pSCorePrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCCorePrdIssueServiceBase.this.onBeforeRemoveByPSCorePrd(pSCorePrd2);
                PSDCCorePrdIssueServiceBase.this.internalRemoveByPSCorePrd(pSCorePrd2);
                PSDCCorePrdIssueServiceBase.this.onAfterRemoveByPSCorePrd(pSCorePrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void internalRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSCorePrd(pSCorePrd);
        this.onBeforeRemoveByPSCorePrd(pSCorePrd, arrayList);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            this.remove(pSDCCorePrdIssue);
        }
        this.onAfterRemoveByPSCorePrd(pSCorePrd, arrayList);
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCCOREPRDISSUE_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCCOREPRDISSUE", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            PSDCCorePrdIssue pSDCCorePrdIssue2 = (PSDCCorePrdIssue)this.getDEModel().createEntity();
            pSDCCorePrdIssue2.setPSDCCorePrdIssueId(pSDCCorePrdIssue.getPSDCCorePrdIssueId());
            pSDCCorePrdIssue2.setPSDevCenterId(null);
            this.update(pSDCCorePrdIssue2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCCorePrdIssueServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCCorePrdIssueServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCCorePrdIssueServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCCorePrdIssue> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCCorePrdIssue pSDCCorePrdIssue : arrayList) {
            this.remove(pSDCCorePrdIssue);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCCorePrdIssue> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCCorePrdIssue pSDCCorePrdIssue) throws Exception {
        super.onBeforeRemove(pSDCCorePrdIssue);
    }

    protected void replaceParentInfo(PSDCCorePrdIssue pSDCCorePrdIssue, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCCorePrdIssue, cloneSession);
        if (pSDCCorePrdIssue.getPSCorePrdCatId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDCAT", (Object)pSDCCorePrdIssue.getPSCorePrdCatId())) != null) {
            this.onFillParentInfo_PSCorePrdCat(pSDCCorePrdIssue, (PSCorePrdCat)iEntity);
        }
        if (pSDCCorePrdIssue.getPSCorePrdFuncId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDFUNC", (Object)pSDCCorePrdIssue.getPSCorePrdFuncId())) != null) {
            this.onFillParentInfo_PSCorePrdFunc(pSDCCorePrdIssue, (PSCorePrdFunc)iEntity);
        }
        if (pSDCCorePrdIssue.getPSCorePrdIssueId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDISSUE", (Object)pSDCCorePrdIssue.getPSCorePrdIssueId())) != null) {
            this.onFillParentInfo_PSCorePrdIssue(pSDCCorePrdIssue, (PSCorePrdIssue)iEntity);
        }
        if (pSDCCorePrdIssue.getPSCorePrdId() != null && (iEntity = cloneSession.getEntity("PSCOREPRD", (Object)pSDCCorePrdIssue.getPSCorePrdId())) != null) {
            this.onFillParentInfo_PSCorePrd(pSDCCorePrdIssue, (PSCorePrd)iEntity);
        }
        if (pSDCCorePrdIssue.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCCorePrdIssue.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCCorePrdIssue, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCCorePrdIssue, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_IssueMemo(bl, pSDCCorePrdIssue, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IssueReply(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IssueState(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdCatId(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdCatName(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdFuncId(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdFuncName(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdId(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdIssueId(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdIssueName(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdName(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCorePrdIssueId(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCorePrdIssueName(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReplyDate(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReplyMan(bl, pSDCCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCCorePrdIssue, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_IssueMemo(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isIssueMemoDirty() : !pSDCCorePrdIssue.isIssueMemoDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getIssueMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IssueMemo_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUEMEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IssueReply(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isIssueReplyDirty() : !pSDCCorePrdIssue.isIssueReplyDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getIssueReply();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IssueReply_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUEREPLY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IssueState(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isIssueStateDirty() && !bl2 : !pSDCCorePrdIssue.isIssueStateDirty()) {
            return null;
        }
        Integer n = pSDCCorePrdIssue.getIssueState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUESTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_IssueState_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUESTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdCatId(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSCorePrdCatIdDirty() : !pSDCCorePrdIssue.isPSCorePrdCatIdDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSCorePrdCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdCatId_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdCatName(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSCorePrdCatNameDirty() : !pSDCCorePrdIssue.isPSCorePrdCatNameDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSCorePrdCatName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdCatName_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDCATNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdFuncId(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSCorePrdFuncIdDirty() : !pSDCCorePrdIssue.isPSCorePrdFuncIdDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSCorePrdFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdFuncId_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdFuncName(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSCorePrdFuncNameDirty() : !pSDCCorePrdIssue.isPSCorePrdFuncNameDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSCorePrdFuncName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdFuncName_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdId(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSCorePrdIdDirty() : !pSDCCorePrdIssue.isPSCorePrdIdDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSCorePrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdId_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdIssueId(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSCorePrdIssueIdDirty() : !pSDCCorePrdIssue.isPSCorePrdIssueIdDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSCorePrdIssueId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdIssueId_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDISSUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdIssueName(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSCorePrdIssueNameDirty() : !pSDCCorePrdIssue.isPSCorePrdIssueNameDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSCorePrdIssueName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdIssueName_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDISSUENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdName(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSCorePrdNameDirty() : !pSDCCorePrdIssue.isPSCorePrdNameDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSCorePrdName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdName_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCCorePrdIssueId(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSDCCorePrdIssueIdDirty() && !bl2 : !pSDCCorePrdIssue.isPSDCCorePrdIssueIdDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSDCCorePrdIssueId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCOREPRDISSUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCorePrdIssueId_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCOREPRDISSUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCCorePrdIssueName(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSDCCorePrdIssueNameDirty() && !bl2 : !pSDCCorePrdIssue.isPSDCCorePrdIssueNameDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSDCCorePrdIssueName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCOREPRDISSUENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCorePrdIssueName_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCOREPRDISSUENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSDevCenterIdDirty() : !pSDCCorePrdIssue.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCCorePrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isPSDevCenterNameDirty() : !pSDCCorePrdIssue.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCCorePrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_ReplyDate(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isReplyDateDirty() : !pSDCCorePrdIssue.isReplyDateDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCCorePrdIssue.getReplyDate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReplyDate_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPLYDATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReplyMan(boolean bl, PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCorePrdIssue.isReplyManDirty() : !pSDCCorePrdIssue.isReplyManDirty()) {
            return null;
        }
        String string = pSDCCorePrdIssue.getReplyMan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReplyMan_Default(pSDCCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPLYMAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        super.onSyncEntity(pSDCCorePrdIssue, bl);
    }

    protected void onSyncIndexEntities(PSDCCorePrdIssue pSDCCorePrdIssue, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCCorePrdIssue, bl);
    }

    public Object getDataContextValue(PSDCCorePrdIssue pSDCCorePrdIssue, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCCorePrdIssue, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCCorePrdIssue pSDCCorePrdIssue, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCCorePrdIssue, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ISSUEMEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IssueMemo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ISSUEREPLY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IssueReply_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ISSUESTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IssueState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDISSUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdIssueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDISSUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdIssueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCOREPRDISSUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCorePrdIssueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCOREPRDISSUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCorePrdIssueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPLYDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReplyDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPLYMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReplyMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_IssueMemo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ISSUEMEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IssueReply_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ISSUEREPLY", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IssueState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSCorePrdCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdIssueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDISSUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdIssueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDISSUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCorePrdIssueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCOREPRDISSUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCorePrdIssueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCOREPRDISSUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ReplyDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ReplyMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REPLYMAN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCCorePrdIssue pSDCCorePrdIssue) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCCorePrdIssue)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCCorePrdIssue pSDCCorePrdIssue) throws Exception {
        super.onUpdateParent(pSDCCorePrdIssue);
    }

    @Override
    protected void exportCurXmlModel(PSDCCorePrdIssue pSDCCorePrdIssue, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCCOREPRDISSUE");
        if (!bl) {
            pSDCCorePrdIssue.setCreateDate(null);
            pSDCCorePrdIssue.setCreateMan(null);
            pSDCCorePrdIssue.setPSDCCorePrdIssueId(null);
            pSDCCorePrdIssue.setUpdateDate(null);
            pSDCCorePrdIssue.setUpdateMan(null);
            super.exportCurXmlModel(pSDCCorePrdIssue, xmlNode, bl);
        }
    }
}

