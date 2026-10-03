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
import net.ibizsys.pscore.srv.config.dao.PSSysUIActionDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSysUIActionDEModel;
import net.ibizsys.pscore.srv.config.entity.PSImageTempl;
import net.ibizsys.pscore.srv.config.entity.PSImageTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSSysLanRes;
import net.ibizsys.pscore.srv.config.entity.PSSysLanResBase;
import net.ibizsys.pscore.srv.config.entity.PSSysUIAction;
import net.ibizsys.pscore.srv.config.service.PSPFUATemplService;
import net.ibizsys.pscore.srv.config.service.PSPFUATemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemService;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUIActionServiceBase
extends PSCoreSysServiceBase<PSSysUIAction> {
    private static final Log log = LogFactory.getLog(PSSysUIActionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysUIActionDEModel pSSysUIActionDEModel;
    private PSSysUIActionDAO pSSysUIActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysUIActionService";
    }

    public PSSysUIActionDEModel getPSSysUIActionDEModel() {
        if (this.pSSysUIActionDEModel == null) {
            try {
                this.pSSysUIActionDEModel = (PSSysUIActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysUIActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUIActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysUIActionDEModel();
    }

    public PSSysUIActionDAO getPSSysUIActionDAO() {
        if (this.pSSysUIActionDAO == null) {
            try {
                this.pSSysUIActionDAO = (PSSysUIActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSysUIActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUIActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysUIActionDAO();
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

    protected void onFillParentInfo(PSSysUIAction pSSysUIAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUIACTION_PSIMAGETEMPL_PSIMAGETEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSImageTemplService", (SessionFactory)this.getSessionFactory());
            PSImageTempl pSImageTempl = (PSImageTempl)iService.getDEModel().createEntity();
            pSImageTempl.set("PSIMAGETEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSImageTempl);
            } else {
                iService.get(pSImageTempl);
            }
            this.onFillParentInfo_PSImageTempl(pSSysUIAction, pSImageTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUIACTION_PSSYSLANRES_CAPPSSYSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysLanResService", (SessionFactory)this.getSessionFactory());
            PSSysLanRes pSSysLanRes = (PSSysLanRes)iService.getDEModel().createEntity();
            pSSysLanRes.set("PSSYSLANRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysLanRes);
            } else {
                iService.get(pSSysLanRes);
            }
            this.onFillParentInfo_CapPSSysLanRes(pSSysUIAction, pSSysLanRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUIACTION_PSSYSLANRES_TIPPSSYSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysLanResService", (SessionFactory)this.getSessionFactory());
            PSSysLanRes pSSysLanRes = (PSSysLanRes)iService.getDEModel().createEntity();
            pSSysLanRes.set("PSSYSLANRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysLanRes);
            } else {
                iService.get(pSSysLanRes);
            }
            this.onFillParentInfo_TipPSSysLanRes(pSSysUIAction, pSSysLanRes);
            return;
        }
        super.onFillParentInfo(pSSysUIAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSImageTempl(PSSysUIAction pSSysUIAction, PSImageTempl pSImageTempl) throws Exception {
        pSSysUIAction.setPSImageTemplId(pSImageTempl.getPSImageTemplId());
        pSSysUIAction.setPSImageTemplName(pSImageTempl.getPSImageTemplName());
    }

    protected void onFillParentInfo_CapPSSysLanRes(PSSysUIAction pSSysUIAction, PSSysLanRes pSSysLanRes) throws Exception {
        pSSysUIAction.setCapPSSysLanResId(pSSysLanRes.getPSSysLanResId());
        pSSysUIAction.setCapPSSysLanResName(pSSysLanRes.getPSSysLanResName());
    }

    protected void onFillParentInfo_TipPSSysLanRes(PSSysUIAction pSSysUIAction, PSSysLanRes pSSysLanRes) throws Exception {
        pSSysUIAction.setTipPSSysLanResId(pSSysLanRes.getPSSysLanResId());
        pSSysUIAction.setTipPSSysLanResName(pSSysLanRes.getPSSysLanResName());
    }

    protected void onFillEntityFullInfo(PSSysUIAction pSSysUIAction, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysUIAction, bl);
        this.onFillEntityFullInfo_PSImageTempl(pSSysUIAction, bl);
        this.onFillEntityFullInfo_CapPSSysLanRes(pSSysUIAction, bl);
        this.onFillEntityFullInfo_TipPSSysLanRes(pSSysUIAction, bl);
    }

    protected void onFillEntityFullInfo_PSImageTempl(PSSysUIAction pSSysUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSSysLanRes(PSSysUIAction pSSysUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TipPSSysLanRes(PSSysUIAction pSSysUIAction, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysUIAction pSSysUIAction, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysUIAction, bl);
    }

    public ArrayList<PSSysUIAction> selectByPSImageTempl(PSImageTemplBase pSImageTemplBase) throws Exception {
        return this.selectByPSImageTempl(pSImageTemplBase, "", -1);
    }

    public ArrayList<PSSysUIAction> selectByPSImageTempl(PSImageTemplBase pSImageTemplBase, String string) throws Exception {
        return this.selectByPSImageTempl(pSImageTemplBase, string, -1);
    }

    public ArrayList<PSSysUIAction> selectByPSImageTempl(PSImageTemplBase pSImageTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSIMAGETEMPLID", (Object)pSImageTemplBase.getPSImageTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSImageTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSImageTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUIAction> selectByCapPSSysLanRes(PSSysLanResBase pSSysLanResBase) throws Exception {
        return this.selectByCapPSSysLanRes(pSSysLanResBase, "", -1);
    }

    public ArrayList<PSSysUIAction> selectByCapPSSysLanRes(PSSysLanResBase pSSysLanResBase, String string) throws Exception {
        return this.selectByCapPSSysLanRes(pSSysLanResBase, string, -1);
    }

    public ArrayList<PSSysUIAction> selectByCapPSSysLanRes(PSSysLanResBase pSSysLanResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSSYSLANRESID", (Object)pSSysLanResBase.getPSSysLanResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSSysLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSSysLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUIAction> selectByTipPSSysLanRes(PSSysLanResBase pSSysLanResBase) throws Exception {
        return this.selectByTipPSSysLanRes(pSSysLanResBase, "", -1);
    }

    public ArrayList<PSSysUIAction> selectByTipPSSysLanRes(PSSysLanResBase pSSysLanResBase, String string) throws Exception {
        return this.selectByTipPSSysLanRes(pSSysLanResBase, string, -1);
    }

    public ArrayList<PSSysUIAction> selectByTipPSSysLanRes(PSSysLanResBase pSSysLanResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIPPSSYSLANRESID", (Object)pSSysLanResBase.getPSSysLanResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTipPSSysLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTipPSSysLanResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSImageTempl(PSImageTempl pSImageTempl) throws Exception {
        ArrayList<PSSysUIAction> arrayList = this.selectByPSImageTempl(pSImageTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSIMAGETEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSImageTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUIACTION_PSIMAGETEMPL_PSIMAGETEMPLID", "", iDataEntityModel.getName(), "PSSYSUIACTION", iDataEntityModel.getDataInfo(pSImageTempl), arrayList.get(0)));
        }
    }

    public void resetPSImageTempl(PSImageTempl pSImageTempl) throws Exception {
        ArrayList<PSSysUIAction> arrayList = this.selectByPSImageTempl(pSImageTempl);
        for (PSSysUIAction pSSysUIAction : arrayList) {
            PSSysUIAction pSSysUIAction2 = (PSSysUIAction)this.getDEModel().createEntity();
            pSSysUIAction2.setPSSysUIActionId(pSSysUIAction.getPSSysUIActionId());
            pSSysUIAction2.setPSImageTemplId(null);
            this.update(pSSysUIAction2);
        }
    }

    public void removeByPSImageTempl(PSImageTempl pSImageTempl) throws Exception {
        final PSImageTempl pSImageTempl2 = pSImageTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUIActionServiceBase.this.onBeforeRemoveByPSImageTempl(pSImageTempl2);
                PSSysUIActionServiceBase.this.internalRemoveByPSImageTempl(pSImageTempl2);
                PSSysUIActionServiceBase.this.onAfterRemoveByPSImageTempl(pSImageTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSImageTempl(PSImageTempl pSImageTempl) throws Exception {
    }

    protected void internalRemoveByPSImageTempl(PSImageTempl pSImageTempl) throws Exception {
        ArrayList<PSSysUIAction> arrayList = this.selectByPSImageTempl(pSImageTempl);
        this.onBeforeRemoveByPSImageTempl(pSImageTempl, arrayList);
        for (PSSysUIAction pSSysUIAction : arrayList) {
            this.remove(pSSysUIAction);
        }
        this.onAfterRemoveByPSImageTempl(pSImageTempl, arrayList);
    }

    protected void onAfterRemoveByPSImageTempl(PSImageTempl pSImageTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSImageTempl(PSImageTempl pSImageTempl, ArrayList<PSSysUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSImageTempl(PSImageTempl pSImageTempl, ArrayList<PSSysUIAction> arrayList) throws Exception {
    }

    public void testRemoveByCapPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSSysUIAction> arrayList = this.selectByCapPSSysLanRes(pSSysLanRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSLANRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysLanRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUIACTION_PSSYSLANRES_CAPPSSYSLANRESID", "", iDataEntityModel.getName(), "PSSYSUIACTION", iDataEntityModel.getDataInfo(pSSysLanRes), arrayList.get(0)));
        }
    }

    public void resetCapPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSSysUIAction> arrayList = this.selectByCapPSSysLanRes(pSSysLanRes);
        for (PSSysUIAction pSSysUIAction : arrayList) {
            PSSysUIAction pSSysUIAction2 = (PSSysUIAction)this.getDEModel().createEntity();
            pSSysUIAction2.setPSSysUIActionId(pSSysUIAction.getPSSysUIActionId());
            pSSysUIAction2.setCapPSSysLanResId(null);
            this.update(pSSysUIAction2);
        }
    }

    public void removeByCapPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        final PSSysLanRes pSSysLanRes2 = pSSysLanRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUIActionServiceBase.this.onBeforeRemoveByCapPSSysLanRes(pSSysLanRes2);
                PSSysUIActionServiceBase.this.internalRemoveByCapPSSysLanRes(pSSysLanRes2);
                PSSysUIActionServiceBase.this.onAfterRemoveByCapPSSysLanRes(pSSysLanRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
    }

    protected void internalRemoveByCapPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSSysUIAction> arrayList = this.selectByCapPSSysLanRes(pSSysLanRes);
        this.onBeforeRemoveByCapPSSysLanRes(pSSysLanRes, arrayList);
        for (PSSysUIAction pSSysUIAction : arrayList) {
            this.remove(pSSysUIAction);
        }
        this.onAfterRemoveByCapPSSysLanRes(pSSysLanRes, arrayList);
    }

    protected void onAfterRemoveByCapPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSSysLanRes(PSSysLanRes pSSysLanRes, ArrayList<PSSysUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSSysLanRes(PSSysLanRes pSSysLanRes, ArrayList<PSSysUIAction> arrayList) throws Exception {
    }

    public void testRemoveByTipPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSSysUIAction> arrayList = this.selectByTipPSSysLanRes(pSSysLanRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSLANRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysLanRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUIACTION_PSSYSLANRES_TIPPSSYSLANRESID", "", iDataEntityModel.getName(), "PSSYSUIACTION", iDataEntityModel.getDataInfo(pSSysLanRes), arrayList.get(0)));
        }
    }

    public void resetTipPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSSysUIAction> arrayList = this.selectByTipPSSysLanRes(pSSysLanRes);
        for (PSSysUIAction pSSysUIAction : arrayList) {
            PSSysUIAction pSSysUIAction2 = (PSSysUIAction)this.getDEModel().createEntity();
            pSSysUIAction2.setPSSysUIActionId(pSSysUIAction.getPSSysUIActionId());
            pSSysUIAction2.setTipPSSysLanResId(null);
            this.update(pSSysUIAction2);
        }
    }

    public void removeByTipPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        final PSSysLanRes pSSysLanRes2 = pSSysLanRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUIActionServiceBase.this.onBeforeRemoveByTipPSSysLanRes(pSSysLanRes2);
                PSSysUIActionServiceBase.this.internalRemoveByTipPSSysLanRes(pSSysLanRes2);
                PSSysUIActionServiceBase.this.onAfterRemoveByTipPSSysLanRes(pSSysLanRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
    }

    protected void internalRemoveByTipPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSSysUIAction> arrayList = this.selectByTipPSSysLanRes(pSSysLanRes);
        this.onBeforeRemoveByTipPSSysLanRes(pSSysLanRes, arrayList);
        for (PSSysUIAction pSSysUIAction : arrayList) {
            this.remove(pSSysUIAction);
        }
        this.onAfterRemoveByTipPSSysLanRes(pSSysLanRes, arrayList);
    }

    protected void onAfterRemoveByTipPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSSysLanRes(PSSysLanRes pSSysLanRes, ArrayList<PSSysUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSSysLanRes(PSSysLanRes pSSysLanRes, ArrayList<PSSysUIAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysUIAction pSSysUIAction) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUIAction(pSSysUIAction);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByRepPSSysUIAction(pSSysUIAction);
        pSCoreSysServiceBase = (PSPFUATemplService)ServiceGlobal.getService(PSPFUATemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFUATemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUIAction(pSSysUIAction);
        pSCoreSysServiceBase = (PSSysTBItemService)ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTBItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUIAction(pSSysUIAction);
        super.onBeforeRemove(pSSysUIAction);
    }

    protected void replaceParentInfo(PSSysUIAction pSSysUIAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysUIAction, cloneSession);
        if (pSSysUIAction.getPSImageTemplId() != null && (iEntity = cloneSession.getEntity("PSIMAGETEMPL", (Object)pSSysUIAction.getPSImageTemplId())) != null) {
            this.onFillParentInfo_PSImageTempl(pSSysUIAction, (PSImageTempl)iEntity);
        }
        if (pSSysUIAction.getCapPSSysLanResId() != null && (iEntity = cloneSession.getEntity("PSSYSLANRES", (Object)pSSysUIAction.getCapPSSysLanResId())) != null) {
            this.onFillParentInfo_CapPSSysLanRes(pSSysUIAction, (PSSysLanRes)iEntity);
        }
        if (pSSysUIAction.getTipPSSysLanResId() != null && (iEntity = cloneSession.getEntity("PSSYSLANRES", (Object)pSSysUIAction.getTipPSSysLanResId())) != null) {
            this.onFillParentInfo_TipPSSysLanRes(pSSysUIAction, (PSSysLanRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysUIAction pSSysUIAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysUIAction, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionTarget(bl, pSSysUIAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSSysLanResId(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEOPPriv(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemObj(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSImageTemplId(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUIActionId(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUIActionName(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSSysLanResId(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToggleMode(bl, pSSysUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysUIAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionTarget(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isActionTargetDirty() : !pSSysUIAction.isActionTargetDirty()) {
            return null;
        }
        String string = pSSysUIAction.getActionTarget();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionTarget_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTARGET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSSysLanResId(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isCapPSSysLanResIdDirty() : !pSSysUIAction.isCapPSSysLanResIdDirty()) {
            return null;
        }
        String string = pSSysUIAction.getCapPSSysLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSSysLanResId_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSSYSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isCaptionDirty() && !bl2 : !pSSysUIAction.isCaptionDirty()) {
            return null;
        }
        String string = pSSysUIAction.getCaption();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isCodeNameDirty() : !pSSysUIAction.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysUIAction.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEOPPriv(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isDEOPPrivDirty() : !pSSysUIAction.isDEOPPrivDirty()) {
            return null;
        }
        String string = pSSysUIAction.getDEOPPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEOPPriv_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEOPPRIV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemObj(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isItemObjDirty() : !pSSysUIAction.isItemObjDirty()) {
            return null;
        }
        String string = pSSysUIAction.getItemObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemObj_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isMemoDirty() : !pSSysUIAction.isMemoDirty()) {
            return null;
        }
        String string = pSSysUIAction.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSImageTemplId(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isPSImageTemplIdDirty() : !pSSysUIAction.isPSImageTemplIdDirty()) {
            return null;
        }
        String string = pSSysUIAction.getPSImageTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSImageTemplId_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSIMAGETEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUIActionId(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isPSSysUIActionIdDirty() && !bl2 : !pSSysUIAction.isPSSysUIActionIdDirty()) {
            return null;
        }
        String string = pSSysUIAction.getPSSysUIActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUIACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUIActionId_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUIActionName(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isPSSysUIActionNameDirty() && !bl2 : !pSSysUIAction.isPSSysUIActionNameDirty()) {
            return null;
        }
        String string = pSSysUIAction.getPSSysUIActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUIACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUIActionName_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUIACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSSysLanResId(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isTipPSSysLanResIdDirty() : !pSSysUIAction.isTipPSSysLanResIdDirty()) {
            return null;
        }
        String string = pSSysUIAction.getTipPSSysLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSSysLanResId_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSSYSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToggleMode(boolean bl, PSSysUIAction pSSysUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUIAction.isToggleModeDirty() : !pSSysUIAction.isToggleModeDirty()) {
            return null;
        }
        Integer n = pSSysUIAction.getToggleMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ToggleMode_Default(pSSysUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOGGLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysUIAction pSSysUIAction, boolean bl) throws Exception {
        super.onSyncEntity(pSSysUIAction, bl);
    }

    protected void onSyncIndexEntities(PSSysUIAction pSSysUIAction, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysUIAction, bl);
    }

    public Object getDataContextValue(PSSysUIAction pSSysUIAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysUIAction, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysUIAction pSSysUIAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysUIAction, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONTARGET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionTarget_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSSYSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSSysLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSSYSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSSysLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEOPPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEOPPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSIMAGETEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSImageTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSIMAGETEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSImageTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSSYSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSSysLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSSYSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSSysLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOGGLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToggleMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionTarget_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONTARGET", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSSysLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSSYSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSSysLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSSYSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DEOPPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEOPPRIV", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_PSImageTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSIMAGETEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSImageTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSIMAGETEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSSysLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSSYSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSSysLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSSYSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToggleMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSSysUIAction pSSysUIAction) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysUIAction)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysUIAction pSSysUIAction) throws Exception {
        super.onUpdateParent(pSSysUIAction);
    }

    @Override
    protected void exportCurXmlModel(PSSysUIAction pSSysUIAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSUIACTION");
        if (!bl) {
            pSSysUIAction.setCreateDate(null);
            pSSysUIAction.setCreateMan(null);
            pSSysUIAction.setPSImageTemplName(null);
            pSSysUIAction.setUpdateDate(null);
            pSSysUIAction.setUpdateMan(null);
            super.exportCurXmlModel(pSSysUIAction, xmlNode, bl);
        }
    }
}

