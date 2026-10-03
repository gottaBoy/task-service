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
import net.ibizsys.pscore.srv.config.dao.PSSysTBItemDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSysTBItemDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCssTempl;
import net.ibizsys.pscore.srv.config.entity.PSCssTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSImageTempl;
import net.ibizsys.pscore.srv.config.entity.PSImageTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSSysTBItem;
import net.ibizsys.pscore.srv.config.entity.PSSysTBItemBase;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbar;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbarBase;
import net.ibizsys.pscore.srv.config.entity.PSSysUIAction;
import net.ibizsys.pscore.srv.config.entity.PSSysUIActionBase;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTBItemServiceBase
extends PSCoreSysServiceBase<PSSysTBItem> {
    private static final Log log = LogFactory.getLog(PSSysTBItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysTBItemDEModel pSSysTBItemDEModel;
    private PSSysTBItemDAO pSSysTBItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysTBItemService";
    }

    public PSSysTBItemDEModel getPSSysTBItemDEModel() {
        if (this.pSSysTBItemDEModel == null) {
            try {
                this.pSSysTBItemDEModel = (PSSysTBItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysTBItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTBItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTBItemDEModel();
    }

    public PSSysTBItemDAO getPSSysTBItemDAO() {
        if (this.pSSysTBItemDAO == null) {
            try {
                this.pSSysTBItemDAO = (PSSysTBItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSysTBItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTBItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTBItemDAO();
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

    protected void onFillParentInfo(PSSysTBItem pSSysTBItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTBITEM_PSCSSTEMPL_PSCSSTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCssTemplService", (SessionFactory)this.getSessionFactory());
            PSCssTempl pSCssTempl = (PSCssTempl)iService.getDEModel().createEntity();
            pSCssTempl.set("PSCSSTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCssTempl);
            } else {
                iService.get(pSCssTempl);
            }
            this.onFillParentInfo_Pscsstempl(pSSysTBItem, pSCssTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTBITEM_PSIMAGETEMPL_PSIMAGETEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSImageTemplService", (SessionFactory)this.getSessionFactory());
            PSImageTempl pSImageTempl = (PSImageTempl)iService.getDEModel().createEntity();
            pSImageTempl.set("PSIMAGETEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSImageTempl);
            } else {
                iService.get(pSImageTempl);
            }
            this.onFillParentInfo_Psimagetempl(pSSysTBItem, pSImageTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTBITEM_PSSYSTBITEM_PPSSYSTBITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysTBItemService", (SessionFactory)this.getSessionFactory());
            PSSysTBItem pSSysTBItem2 = (PSSysTBItem)iService.getDEModel().createEntity();
            pSSysTBItem2.set("PSSYSTBITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTBItem2);
            } else {
                iService.get(pSSysTBItem2);
            }
            this.onFillParentInfo_PPSSysTBItem(pSSysTBItem, pSSysTBItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTBITEM_PSSYSTOOLBAR_PSSYSTOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysToolbarService", (SessionFactory)this.getSessionFactory());
            PSSysToolbar pSSysToolbar = (PSSysToolbar)iService.getDEModel().createEntity();
            pSSysToolbar.set("PSSYSTOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysToolbar);
            } else {
                iService.get(pSSysToolbar);
            }
            this.onFillParentInfo_PSSysToolbar(pSSysTBItem, pSSysToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTBITEM_PSSYSUIACTION_PSSYSUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysUIActionService", (SessionFactory)this.getSessionFactory());
            PSSysUIAction pSSysUIAction = (PSSysUIAction)iService.getDEModel().createEntity();
            pSSysUIAction.set("PSSYSUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUIAction);
            } else {
                iService.get(pSSysUIAction);
            }
            this.onFillParentInfo_PSSysUIAction(pSSysTBItem, pSSysUIAction);
            return;
        }
        super.onFillParentInfo(pSSysTBItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Pscsstempl(PSSysTBItem pSSysTBItem, PSCssTempl pSCssTempl) throws Exception {
        pSSysTBItem.setPSCssTemplId(pSCssTempl.getPSCssTemplId());
        pSSysTBItem.setPSCssTemplName(pSCssTempl.getPSCssTemplName());
    }

    protected void onFillParentInfo_Psimagetempl(PSSysTBItem pSSysTBItem, PSImageTempl pSImageTempl) throws Exception {
        pSSysTBItem.setPSImageTemplId(pSImageTempl.getPSImageTemplId());
        pSSysTBItem.setPSImageTemplName(pSImageTempl.getPSImageTemplName());
    }

    protected void onFillParentInfo_PPSSysTBItem(PSSysTBItem pSSysTBItem, PSSysTBItem pSSysTBItem2) throws Exception {
        pSSysTBItem.setPPSSysTBItemId(pSSysTBItem2.getPSSysTBItemId());
        pSSysTBItem.setPPSSysTBItemName(pSSysTBItem2.getPSSysTBItemName());
    }

    protected void onFillParentInfo_PSSysToolbar(PSSysTBItem pSSysTBItem, PSSysToolbar pSSysToolbar) throws Exception {
        pSSysTBItem.setPSSysToolbarId(pSSysToolbar.getPSSysToolbarId());
        pSSysTBItem.setPSSysToolbarName(pSSysToolbar.getPSSysToolbarName());
    }

    protected void onFillParentInfo_PSSysUIAction(PSSysTBItem pSSysTBItem, PSSysUIAction pSSysUIAction) throws Exception {
        pSSysTBItem.setPSSysUIActionId(pSSysUIAction.getPSSysUIActionId());
        pSSysTBItem.setPSSysUIActionName(pSSysUIAction.getPSSysUIActionName());
    }

    protected void onFillEntityFullInfo(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysTBItem, bl);
        this.onFillEntityFullInfo_Pscsstempl(pSSysTBItem, bl);
        this.onFillEntityFullInfo_Psimagetempl(pSSysTBItem, bl);
        this.onFillEntityFullInfo_PPSSysTBItem(pSSysTBItem, bl);
        this.onFillEntityFullInfo_PSSysToolbar(pSSysTBItem, bl);
        this.onFillEntityFullInfo_PSSysUIAction(pSSysTBItem, bl);
    }

    protected void onFillEntityFullInfo_Pscsstempl(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
        if (pSSysTBItem.isPSCssTemplIdDirty()) {
            if (pSSysTBItem.getPSCssTemplId() != null) {
                if (pSSysTBItem.getPSCssTemplId() == null || pSSysTBItem.getPSCssTemplName() == null) {
                    PSCssTempl pSCssTempl = pSSysTBItem.getPscsstempl();
                    pSSysTBItem.setPSCssTemplName(pSCssTempl.getPSCssTemplName());
                }
            } else {
                pSSysTBItem.setPSCssTemplName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Psimagetempl(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
        if (pSSysTBItem.isPSImageTemplIdDirty()) {
            if (pSSysTBItem.getPSImageTemplId() != null) {
                if (pSSysTBItem.getPSImageTemplId() == null || pSSysTBItem.getPSImageTemplName() == null) {
                    PSImageTempl pSImageTempl = pSSysTBItem.getPsimagetempl();
                    pSSysTBItem.setPSImageTemplName(pSImageTempl.getPSImageTemplName());
                }
            } else {
                pSSysTBItem.setPSImageTemplName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSSysTBItem(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysToolbar(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUIAction(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysTBItem, bl);
    }

    public ArrayList<PSSysTBItem> selectByPscsstempl(PSCssTemplBase pSCssTemplBase) throws Exception {
        return this.selectByPscsstempl(pSCssTemplBase, "", -1);
    }

    public ArrayList<PSSysTBItem> selectByPscsstempl(PSCssTemplBase pSCssTemplBase, String string) throws Exception {
        return this.selectByPscsstempl(pSCssTemplBase, string, -1);
    }

    public ArrayList<PSSysTBItem> selectByPscsstempl(PSCssTemplBase pSCssTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCSSTEMPLID", (Object)pSCssTemplBase.getPSCssTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPscsstemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPscsstemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTBItem> selectByPsimagetempl(PSImageTemplBase pSImageTemplBase) throws Exception {
        return this.selectByPsimagetempl(pSImageTemplBase, "", -1);
    }

    public ArrayList<PSSysTBItem> selectByPsimagetempl(PSImageTemplBase pSImageTemplBase, String string) throws Exception {
        return this.selectByPsimagetempl(pSImageTemplBase, string, -1);
    }

    public ArrayList<PSSysTBItem> selectByPsimagetempl(PSImageTemplBase pSImageTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSIMAGETEMPLID", (Object)pSImageTemplBase.getPSImageTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsimagetemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsimagetemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTBItem> selectByPPSSysTBItem(PSSysTBItemBase pSSysTBItemBase) throws Exception {
        return this.selectByPPSSysTBItem(pSSysTBItemBase, "", -1);
    }

    public ArrayList<PSSysTBItem> selectByPPSSysTBItem(PSSysTBItemBase pSSysTBItemBase, String string) throws Exception {
        return this.selectByPPSSysTBItem(pSSysTBItemBase, string, -1);
    }

    public ArrayList<PSSysTBItem> selectByPPSSysTBItem(PSSysTBItemBase pSSysTBItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSTBITEMID", (Object)pSSysTBItemBase.getPSSysTBItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysTBItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysTBItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTBItem> selectByPSSysToolbar(PSSysToolbarBase pSSysToolbarBase) throws Exception {
        return this.selectByPSSysToolbar(pSSysToolbarBase, "", -1);
    }

    public ArrayList<PSSysTBItem> selectByPSSysToolbar(PSSysToolbarBase pSSysToolbarBase, String string) throws Exception {
        return this.selectByPSSysToolbar(pSSysToolbarBase, string, -1);
    }

    public ArrayList<PSSysTBItem> selectByPSSysToolbar(PSSysToolbarBase pSSysToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTOOLBARID", (Object)pSSysToolbarBase.getPSSysToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTBItem> selectByPSSysUIAction(PSSysUIActionBase pSSysUIActionBase) throws Exception {
        return this.selectByPSSysUIAction(pSSysUIActionBase, "", -1);
    }

    public ArrayList<PSSysTBItem> selectByPSSysUIAction(PSSysUIActionBase pSSysUIActionBase, String string) throws Exception {
        return this.selectByPSSysUIAction(pSSysUIActionBase, string, -1);
    }

    public ArrayList<PSSysTBItem> selectByPSSysUIAction(PSSysUIActionBase pSSysUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUIACTIONID", (Object)pSSysUIActionBase.getPSSysUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUIActionCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPscsstempl(PSCssTempl pSCssTempl) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPscsstempl(pSCssTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCSSTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCssTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTBITEM_PSCSSTEMPL_PSCSSTEMPLID", "", iDataEntityModel.getName(), "PSSYSTBITEM", iDataEntityModel.getDataInfo(pSCssTempl), arrayList.get(0)));
        }
    }

    public void resetPscsstempl(PSCssTempl pSCssTempl) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPscsstempl(pSCssTempl);
        for (PSSysTBItem pSSysTBItem : arrayList) {
            PSSysTBItem pSSysTBItem2 = (PSSysTBItem)this.getDEModel().createEntity();
            pSSysTBItem2.setPSSysTBItemId(pSSysTBItem.getPSSysTBItemId());
            pSSysTBItem2.setPSCssTemplId(null);
            this.update(pSSysTBItem2);
        }
    }

    public void removeByPscsstempl(PSCssTempl pSCssTempl) throws Exception {
        final PSCssTempl pSCssTempl2 = pSCssTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTBItemServiceBase.this.onBeforeRemoveByPscsstempl(pSCssTempl2);
                PSSysTBItemServiceBase.this.internalRemoveByPscsstempl(pSCssTempl2);
                PSSysTBItemServiceBase.this.onAfterRemoveByPscsstempl(pSCssTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPscsstempl(PSCssTempl pSCssTempl) throws Exception {
    }

    protected void internalRemoveByPscsstempl(PSCssTempl pSCssTempl) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPscsstempl(pSCssTempl);
        this.onBeforeRemoveByPscsstempl(pSCssTempl, arrayList);
        for (PSSysTBItem pSSysTBItem : arrayList) {
            this.remove(pSSysTBItem);
        }
        this.onAfterRemoveByPscsstempl(pSCssTempl, arrayList);
    }

    protected void onAfterRemoveByPscsstempl(PSCssTempl pSCssTempl) throws Exception {
    }

    protected void onBeforeRemoveByPscsstempl(PSCssTempl pSCssTempl, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPscsstempl(PSCssTempl pSCssTempl, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    public void testRemoveByPsimagetempl(PSImageTempl pSImageTempl) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPsimagetempl(pSImageTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSIMAGETEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSImageTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTBITEM_PSIMAGETEMPL_PSIMAGETEMPLID", "", iDataEntityModel.getName(), "PSSYSTBITEM", iDataEntityModel.getDataInfo(pSImageTempl), arrayList.get(0)));
        }
    }

    public void resetPsimagetempl(PSImageTempl pSImageTempl) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPsimagetempl(pSImageTempl);
        for (PSSysTBItem pSSysTBItem : arrayList) {
            PSSysTBItem pSSysTBItem2 = (PSSysTBItem)this.getDEModel().createEntity();
            pSSysTBItem2.setPSSysTBItemId(pSSysTBItem.getPSSysTBItemId());
            pSSysTBItem2.setPSImageTemplId(null);
            this.update(pSSysTBItem2);
        }
    }

    public void removeByPsimagetempl(PSImageTempl pSImageTempl) throws Exception {
        final PSImageTempl pSImageTempl2 = pSImageTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTBItemServiceBase.this.onBeforeRemoveByPsimagetempl(pSImageTempl2);
                PSSysTBItemServiceBase.this.internalRemoveByPsimagetempl(pSImageTempl2);
                PSSysTBItemServiceBase.this.onAfterRemoveByPsimagetempl(pSImageTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPsimagetempl(PSImageTempl pSImageTempl) throws Exception {
    }

    protected void internalRemoveByPsimagetempl(PSImageTempl pSImageTempl) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPsimagetempl(pSImageTempl);
        this.onBeforeRemoveByPsimagetempl(pSImageTempl, arrayList);
        for (PSSysTBItem pSSysTBItem : arrayList) {
            this.remove(pSSysTBItem);
        }
        this.onAfterRemoveByPsimagetempl(pSImageTempl, arrayList);
    }

    protected void onAfterRemoveByPsimagetempl(PSImageTempl pSImageTempl) throws Exception {
    }

    protected void onBeforeRemoveByPsimagetempl(PSImageTempl pSImageTempl, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsimagetempl(PSImageTempl pSImageTempl, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysTBItem(PSSysTBItem pSSysTBItem) throws Exception {
    }

    public void resetPPSSysTBItem(PSSysTBItem pSSysTBItem) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPPSSysTBItem(pSSysTBItem);
        for (PSSysTBItem pSSysTBItem2 : arrayList) {
            PSSysTBItem pSSysTBItem3 = (PSSysTBItem)this.getDEModel().createEntity();
            pSSysTBItem3.setPSSysTBItemId(pSSysTBItem2.getPSSysTBItemId());
            pSSysTBItem3.setPPSSysTBItemId(null);
            this.update(pSSysTBItem3);
        }
    }

    public void removeByPPSSysTBItem(PSSysTBItem pSSysTBItem) throws Exception {
        final PSSysTBItem pSSysTBItem2 = pSSysTBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTBItemServiceBase.this.onBeforeRemoveByPPSSysTBItem(pSSysTBItem2);
                PSSysTBItemServiceBase.this.internalRemoveByPPSSysTBItem(pSSysTBItem2);
                PSSysTBItemServiceBase.this.onAfterRemoveByPPSSysTBItem(pSSysTBItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysTBItem(PSSysTBItem pSSysTBItem) throws Exception {
    }

    protected void internalRemoveByPPSSysTBItem(PSSysTBItem pSSysTBItem) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPPSSysTBItem(pSSysTBItem);
        this.onBeforeRemoveByPPSSysTBItem(pSSysTBItem, arrayList);
        for (PSSysTBItem pSSysTBItem2 : arrayList) {
            this.remove(pSSysTBItem2);
        }
        this.onAfterRemoveByPPSSysTBItem(pSSysTBItem, arrayList);
    }

    protected void onAfterRemoveByPPSSysTBItem(PSSysTBItem pSSysTBItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysTBItem(PSSysTBItem pSSysTBItem, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysTBItem(PSSysTBItem pSSysTBItem, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
    }

    public void resetPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPSSysToolbar(pSSysToolbar);
        for (PSSysTBItem pSSysTBItem : arrayList) {
            PSSysTBItem pSSysTBItem2 = (PSSysTBItem)this.getDEModel().createEntity();
            pSSysTBItem2.setPSSysTBItemId(pSSysTBItem.getPSSysTBItemId());
            pSSysTBItem2.setPSSysToolbarId(null);
            this.update(pSSysTBItem2);
        }
    }

    public void removeByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        final PSSysToolbar pSSysToolbar2 = pSSysToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTBItemServiceBase.this.onBeforeRemoveByPSSysToolbar(pSSysToolbar2);
                PSSysTBItemServiceBase.this.internalRemoveByPSSysToolbar(pSSysToolbar2);
                PSSysTBItemServiceBase.this.onAfterRemoveByPSSysToolbar(pSSysToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
    }

    protected void internalRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPSSysToolbar(pSSysToolbar);
        this.onBeforeRemoveByPSSysToolbar(pSSysToolbar, arrayList);
        for (PSSysTBItem pSSysTBItem : arrayList) {
            this.remove(pSSysTBItem);
        }
        this.onAfterRemoveByPSSysToolbar(pSSysToolbar, arrayList);
    }

    protected void onAfterRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPSSysUIAction(pSSysUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTBITEM_PSSYSUIACTION_PSSYSUIACTIONID", "", iDataEntityModel.getName(), "PSSYSTBITEM", iDataEntityModel.getDataInfo(pSSysUIAction), arrayList.get(0)));
        }
    }

    public void resetPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPSSysUIAction(pSSysUIAction);
        for (PSSysTBItem pSSysTBItem : arrayList) {
            PSSysTBItem pSSysTBItem2 = (PSSysTBItem)this.getDEModel().createEntity();
            pSSysTBItem2.setPSSysTBItemId(pSSysTBItem.getPSSysTBItemId());
            pSSysTBItem2.setPSSysUIActionId(null);
            this.update(pSSysTBItem2);
        }
    }

    public void removeByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        final PSSysUIAction pSSysUIAction2 = pSSysUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTBItemServiceBase.this.onBeforeRemoveByPSSysUIAction(pSSysUIAction2);
                PSSysTBItemServiceBase.this.internalRemoveByPSSysUIAction(pSSysUIAction2);
                PSSysTBItemServiceBase.this.onAfterRemoveByPSSysUIAction(pSSysUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
    }

    protected void internalRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        ArrayList<PSSysTBItem> arrayList = this.selectByPSSysUIAction(pSSysUIAction);
        this.onBeforeRemoveByPSSysUIAction(pSSysUIAction, arrayList);
        for (PSSysTBItem pSSysTBItem : arrayList) {
            this.remove(pSSysTBItem);
        }
        this.onAfterRemoveByPSSysUIAction(pSSysUIAction, arrayList);
    }

    protected void onAfterRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction, ArrayList<PSSysTBItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTBItem pSSysTBItem) throws Exception {
        PSSysTBItemService pSSysTBItemService = (PSSysTBItemService)ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)this.getSessionFactory());
        pSSysTBItemService.testRemoveByPPSSysTBItem(pSSysTBItem);
        pSSysTBItemService.resetPPSSysTBItem(pSSysTBItem);
        super.onBeforeRemove(pSSysTBItem);
    }

    protected void replaceParentInfo(PSSysTBItem pSSysTBItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysTBItem, cloneSession);
        if (pSSysTBItem.getPSCssTemplId() != null && (iEntity = cloneSession.getEntity("PSCSSTEMPL", (Object)pSSysTBItem.getPSCssTemplId())) != null) {
            this.onFillParentInfo_Pscsstempl(pSSysTBItem, (PSCssTempl)iEntity);
        }
        if (pSSysTBItem.getPSImageTemplId() != null && (iEntity = cloneSession.getEntity("PSIMAGETEMPL", (Object)pSSysTBItem.getPSImageTemplId())) != null) {
            this.onFillParentInfo_Psimagetempl(pSSysTBItem, (PSImageTempl)iEntity);
        }
        if (pSSysTBItem.getPPSSysTBItemId() != null && (iEntity = cloneSession.getEntity("PSSYSTBITEM", (Object)pSSysTBItem.getPPSSysTBItemId())) != null) {
            this.onFillParentInfo_PPSSysTBItem(pSSysTBItem, (PSSysTBItem)iEntity);
        }
        if (pSSysTBItem.getPSSysToolbarId() != null && (iEntity = cloneSession.getEntity("PSSYSTOOLBAR", (Object)pSSysTBItem.getPSSysToolbarId())) != null) {
            this.onFillParentInfo_PSSysToolbar(pSSysTBItem, (PSSysToolbar)iEntity);
        }
        if (pSSysTBItem.getPSSysUIActionId() != null && (iEntity = cloneSession.getEntity("PSSYSUIACTION", (Object)pSSysTBItem.getPSSysUIActionId())) != null) {
            this.onFillParentInfo_PSSysUIAction(pSSysTBItem, (PSSysUIAction)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysTBItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Caption(bl, pSSysTBItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelTag(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelValue(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysTBItemId(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCssTemplId(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCssTemplName(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSImageTemplId(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSImageTemplName(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTBItemId(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTBItemName(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysToolbarId(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUIActionId(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowMode(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TBItemType(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSSysTBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysTBItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isCaptionDirty() : !pSSysTBItem.isCaptionDirty()) {
            return null;
        }
        String string = pSSysTBItem.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSSysTBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Height(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isHeightDirty() : !pSSysTBItem.isHeightDirty()) {
            return null;
        }
        Double d = pSSysTBItem.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelTag(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isLevelTagDirty() : !pSSysTBItem.isLevelTagDirty()) {
            return null;
        }
        String string = pSSysTBItem.getLevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelTag_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelValue(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isLevelValueDirty() : !pSSysTBItem.isLevelValueDirty()) {
            return null;
        }
        Integer n = pSSysTBItem.getLevelValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LevelValue_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isMemoDirty() : !pSSysTBItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysTBItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysTBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isOrderValueDirty() && !bl2 : !pSSysTBItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysTBItem.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysTBItemId(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isPPSSysTBItemIdDirty() : !pSSysTBItem.isPPSSysTBItemIdDirty()) {
            return null;
        }
        String string = pSSysTBItem.getPPSSysTBItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysTBItemId_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSTBITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCssTemplId(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isPSCssTemplIdDirty() : !pSSysTBItem.isPSCssTemplIdDirty()) {
            return null;
        }
        String string = pSSysTBItem.getPSCssTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCssTemplId_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCSSTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCssTemplName(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isPSCssTemplNameDirty() : !pSSysTBItem.isPSCssTemplNameDirty()) {
            return null;
        }
        String string = pSSysTBItem.getPSCssTemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCssTemplName_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCSSTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSImageTemplId(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isPSImageTemplIdDirty() : !pSSysTBItem.isPSImageTemplIdDirty()) {
            return null;
        }
        String string = pSSysTBItem.getPSImageTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSImageTemplId_Default(pSSysTBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSImageTemplName(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isPSImageTemplNameDirty() : !pSSysTBItem.isPSImageTemplNameDirty()) {
            return null;
        }
        String string = pSSysTBItem.getPSImageTemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSImageTemplName_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSIMAGETEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTBItemId(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isPSSysTBItemIdDirty() && !bl2 : !pSSysTBItem.isPSSysTBItemIdDirty()) {
            return null;
        }
        String string = pSSysTBItem.getPSSysTBItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTBITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTBItemId_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTBITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTBItemName(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isPSSysTBItemNameDirty() && !bl2 : !pSSysTBItem.isPSSysTBItemNameDirty()) {
            return null;
        }
        String string = pSSysTBItem.getPSSysTBItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTBITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTBItemName_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTBITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysToolbarId(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isPSSysToolbarIdDirty() && !bl2 : !pSSysTBItem.isPSSysToolbarIdDirty()) {
            return null;
        }
        String string = pSSysTBItem.getPSSysToolbarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTOOLBARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysToolbarId_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUIActionId(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isPSSysUIActionIdDirty() : !pSSysTBItem.isPSSysUIActionIdDirty()) {
            return null;
        }
        String string = pSSysTBItem.getPSSysUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUIActionId_Default(pSSysTBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ShowMode(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isShowModeDirty() : !pSSysTBItem.isShowModeDirty()) {
            return null;
        }
        String string = pSSysTBItem.getShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShowMode_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TBItemType(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isTBItemTypeDirty() && !bl2 : !pSSysTBItem.isTBItemTypeDirty()) {
            return null;
        }
        String string = pSSysTBItem.getTBItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TBITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TBItemType_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TBITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Width(boolean bl, PSSysTBItem pSSysTBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTBItem.isWidthDirty() : !pSSysTBItem.isWidthDirty()) {
            return null;
        }
        Double d = pSSysTBItem.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default(pSSysTBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
        super.onSyncEntity(pSSysTBItem, bl);
    }

    protected void onSyncIndexEntities(PSSysTBItem pSSysTBItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysTBItem, bl);
    }

    public Object getDataContextValue(PSSysTBItem pSSysTBItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysTBItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysToolbar pSSysToolbar = pSSysTBItem.getPSSysToolbar();
        if (pSSysToolbar != null && pSSysToolbar.contains(string)) {
            return pSSysToolbar.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTBItem pSSysTBItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysTBItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSTBITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysTBItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSTBITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysTBItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCSSTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCssTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCSSTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCssTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSIMAGETEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSImageTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSIMAGETEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSImageTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTBITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTBItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTBITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTBItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TBITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TBItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LevelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEVELTAG", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LevelValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSSysTBItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSTBITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysTBItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSTBITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCssTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCSSTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCssTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCSSTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysTBItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTBITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTBItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTBITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ShowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHOWMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TBItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TBITEMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSysTBItem pSSysTBItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysTBItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTBItem pSSysTBItem) throws Exception {
        super.onUpdateParent(pSSysTBItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysTBItem pSSysTBItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTBITEM");
        if (!bl) {
            pSSysTBItem.setCreateDate(null);
            pSSysTBItem.setCreateMan(null);
            pSSysTBItem.setLevelTag(null);
            pSSysTBItem.setLevelValue(null);
            pSSysTBItem.setPSSysTBItemId(null);
            pSSysTBItem.setUpdateDate(null);
            pSSysTBItem.setUpdateMan(null);
            super.exportCurXmlModel(pSSysTBItem, xmlNode, bl);
        }
    }
}

