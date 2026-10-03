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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSysDiffItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSysDiffItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffRep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffRepBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSysDiffItemServiceBase
extends PSCoreSysServiceBase<PSDevSysDiffItem> {
    private static final Log log = LogFactory.getLog(PSDevSysDiffItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_EXECUTESYNCACTION = "X_EXECUTESYNCACTION";
    public static final String ACTION_MARKUPDATEDST = "MARKUPDATEDST";
    public static final String ACTION_MARKUPDATENONE = "MARKUPDATENONE";
    public static final String ACTION_MARKUPDATESRC = "MARKUPDATESRC";
    private PSDevSysDiffItemDEModel pSDevSysDiffItemDEModel;
    private PSDevSysDiffItemDAO pSDevSysDiffItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffItemService";
    }

    public PSDevSysDiffItemDEModel getPSDevSysDiffItemDEModel() {
        if (this.pSDevSysDiffItemDEModel == null) {
            try {
                this.pSDevSysDiffItemDEModel = (PSDevSysDiffItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSysDiffItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSysDiffItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSysDiffItemDEModel();
    }

    public PSDevSysDiffItemDAO getPSDevSysDiffItemDAO() {
        if (this.pSDevSysDiffItemDAO == null) {
            try {
                this.pSDevSysDiffItemDAO = (PSDevSysDiffItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSysDiffItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSysDiffItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSysDiffItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_EXECUTESYNCACTION, (boolean)true) == 0) {
            this.executeSyncAction((PSDevSysDiffItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_MARKUPDATEDST, (boolean)true) == 0) {
            this.markUpdateDst((PSDevSysDiffItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_MARKUPDATENONE, (boolean)true) == 0) {
            this.markUpdateNone((PSDevSysDiffItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_MARKUPDATESRC, (boolean)true) == 0) {
            this.markUpdateSrc((PSDevSysDiffItem)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void executeSyncAction(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_EXECUTESYNCACTION, 0, pSDevSysDiffItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSysDiffItem, ACTION_X_EXECUTESYNCACTION);
        final PSDevSysDiffItem pSDevSysDiffItem2 = pSDevSysDiffItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSysDiffItemServiceBase.this.getService(), PSDevSysDiffItemServiceBase.ACTION_X_EXECUTESYNCACTION, 40, pSDevSysDiffItem2, null).getResult() != 1) {
                    PSDevSysDiffItemServiceBase.this.onExecuteSyncAction(pSDevSysDiffItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_EXECUTESYNCACTION, 99, pSDevSysDiffItem, null);
        }
    }

    protected void onExecuteSyncAction(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_EXECUTESYNCACTION]");
    }

    public void markUpdateDst(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_MARKUPDATEDST, 0, pSDevSysDiffItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSysDiffItem, ACTION_MARKUPDATEDST);
        final PSDevSysDiffItem pSDevSysDiffItem2 = pSDevSysDiffItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSysDiffItemServiceBase.this.getService(), PSDevSysDiffItemServiceBase.ACTION_MARKUPDATEDST, 40, pSDevSysDiffItem2, null).getResult() != 1) {
                    PSDevSysDiffItemServiceBase.this.onMarkUpdateDst(pSDevSysDiffItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_MARKUPDATEDST, 99, pSDevSysDiffItem, null);
        }
    }

    protected void onMarkUpdateDst(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[MARKUPDATEDST]");
    }

    public void markUpdateNone(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_MARKUPDATENONE, 0, pSDevSysDiffItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSysDiffItem, ACTION_MARKUPDATENONE);
        final PSDevSysDiffItem pSDevSysDiffItem2 = pSDevSysDiffItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSysDiffItemServiceBase.this.getService(), PSDevSysDiffItemServiceBase.ACTION_MARKUPDATENONE, 40, pSDevSysDiffItem2, null).getResult() != 1) {
                    PSDevSysDiffItemServiceBase.this.onMarkUpdateNone(pSDevSysDiffItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_MARKUPDATENONE, 99, pSDevSysDiffItem, null);
        }
    }

    protected void onMarkUpdateNone(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[MARKUPDATENONE]");
    }

    public void markUpdateSrc(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_MARKUPDATESRC, 0, pSDevSysDiffItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSysDiffItem, ACTION_MARKUPDATESRC);
        final PSDevSysDiffItem pSDevSysDiffItem2 = pSDevSysDiffItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSysDiffItemServiceBase.this.getService(), PSDevSysDiffItemServiceBase.ACTION_MARKUPDATESRC, 40, pSDevSysDiffItem2, null).getResult() != 1) {
                    PSDevSysDiffItemServiceBase.this.onMarkUpdateSrc(pSDevSysDiffItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_MARKUPDATESRC, 99, pSDevSysDiffItem, null);
        }
    }

    protected void onMarkUpdateSrc(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[MARKUPDATESRC]");
    }

    protected void onFillParentInfo(PSDevSysDiffItem pSDevSysDiffItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSYSDIFFITEM_PSDEVSYSDIFFITEM_PPSDEVSYSDIFFITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffItemService", (SessionFactory)this.getSessionFactory());
            PSDevSysDiffItem pSDevSysDiffItem2 = (PSDevSysDiffItem)iService.getDEModel().createEntity();
            pSDevSysDiffItem2.set("PSDEVSYSDIFFITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSysDiffItem2);
            } else {
                iService.get(pSDevSysDiffItem2);
            }
            this.onFillParentInfo_PPSDevSysDiffItem(pSDevSysDiffItem, pSDevSysDiffItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSYSDIFFITEM_PSDEVSYSDIFFREP_PSDEVSYSDIFFREPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffRepService", (SessionFactory)this.getSessionFactory());
            PSDevSysDiffRep pSDevSysDiffRep = (PSDevSysDiffRep)iService.getDEModel().createEntity();
            pSDevSysDiffRep.set("PSDEVSYSDIFFREPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSysDiffRep);
            } else {
                iService.get(pSDevSysDiffRep);
            }
            this.onFillParentInfo_PSDevSysDiffRep(pSDevSysDiffItem, pSDevSysDiffRep);
            return;
        }
        super.onFillParentInfo(pSDevSysDiffItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem, PSDevSysDiffItem pSDevSysDiffItem2) throws Exception {
        pSDevSysDiffItem.setPPSDevSysDiffItemId(pSDevSysDiffItem2.getPSDevSysDiffItemId());
        pSDevSysDiffItem.setPPSDevSysDiffItemName(pSDevSysDiffItem2.getPSDevSysDiffItemName());
    }

    protected void onFillParentInfo_PSDevSysDiffRep(PSDevSysDiffItem pSDevSysDiffItem, PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        pSDevSysDiffItem.setPSDevSysDiffRepId(pSDevSysDiffRep.getPSDevSysDiffRepId());
        pSDevSysDiffItem.setPSDevSysDiffRepName(pSDevSysDiffRep.getPSDevSysDiffRepName());
    }

    protected void onFillEntityFullInfo(PSDevSysDiffItem pSDevSysDiffItem, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSysDiffItem.getPSDevSysDiffItemName() == null) {
                pSDevSysDiffItem.setPSDevSysDiffItemName((String)this.getDefaultValue(this.getWebContext(), "", "\u5dee\u5f02\u9879", 25));
            }
            if (pSDevSysDiffItem.getSyncResult() == null) {
                pSDevSysDiffItem.setSyncResult((Integer)this.getDefaultValue(this.getWebContext(), "", "2", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevSysDiffItem, bl);
        this.onFillEntityFullInfo_PPSDevSysDiffItem(pSDevSysDiffItem, bl);
        this.onFillEntityFullInfo_PSDevSysDiffRep(pSDevSysDiffItem, bl);
    }

    protected void onFillEntityFullInfo_PPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem, boolean bl) throws Exception {
        if (pSDevSysDiffItem.isPPSDevSysDiffItemIdDirty()) {
            if (pSDevSysDiffItem.getPPSDevSysDiffItemId() != null) {
                if (pSDevSysDiffItem.getPPSDevSysDiffItemId() == null || pSDevSysDiffItem.getPPSDevSysDiffItemName() == null) {
                    PSDevSysDiffItem pSDevSysDiffItem2 = pSDevSysDiffItem.getPPSDevSysDiffItem();
                    pSDevSysDiffItem.setPPSDevSysDiffItemName(pSDevSysDiffItem2.getPSDevSysDiffItemName());
                }
            } else {
                pSDevSysDiffItem.setPPSDevSysDiffItemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSysDiffRep(PSDevSysDiffItem pSDevSysDiffItem, boolean bl) throws Exception {
        if (pSDevSysDiffItem.isPSDevSysDiffRepIdDirty()) {
            if (pSDevSysDiffItem.getPSDevSysDiffRepId() != null) {
                if (pSDevSysDiffItem.getPSDevSysDiffRepId() == null || pSDevSysDiffItem.getPSDevSysDiffRepName() == null) {
                    PSDevSysDiffRep pSDevSysDiffRep = pSDevSysDiffItem.getPSDevSysDiffRep();
                    pSDevSysDiffItem.setPSDevSysDiffRepName(pSDevSysDiffRep.getPSDevSysDiffRepName());
                }
            } else {
                pSDevSysDiffItem.setPSDevSysDiffRepName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSysDiffItem pSDevSysDiffItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSysDiffItem, bl);
    }

    public ArrayList<PSDevSysDiffItem> selectByPPSDevSysDiffItem(PSDevSysDiffItemBase pSDevSysDiffItemBase) throws Exception {
        return this.selectByPPSDevSysDiffItem(pSDevSysDiffItemBase, "", -1);
    }

    public ArrayList<PSDevSysDiffItem> selectByPPSDevSysDiffItem(PSDevSysDiffItemBase pSDevSysDiffItemBase, String string) throws Exception {
        return this.selectByPPSDevSysDiffItem(pSDevSysDiffItemBase, string, -1);
    }

    public ArrayList<PSDevSysDiffItem> selectByPPSDevSysDiffItem(PSDevSysDiffItemBase pSDevSysDiffItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEVSYSDIFFITEMID", (Object)pSDevSysDiffItemBase.getPSDevSysDiffItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDevSysDiffItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDevSysDiffItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSysDiffItem> selectByPSDevSysDiffRep(PSDevSysDiffRepBase pSDevSysDiffRepBase) throws Exception {
        return this.selectByPSDevSysDiffRep(pSDevSysDiffRepBase, "", -1);
    }

    public ArrayList<PSDevSysDiffItem> selectByPSDevSysDiffRep(PSDevSysDiffRepBase pSDevSysDiffRepBase, String string) throws Exception {
        return this.selectByPSDevSysDiffRep(pSDevSysDiffRepBase, string, -1);
    }

    public ArrayList<PSDevSysDiffItem> selectByPSDevSysDiffRep(PSDevSysDiffRepBase pSDevSysDiffRepBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSYSDIFFREPID", (Object)pSDevSysDiffRepBase.getPSDevSysDiffRepId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSysDiffRepCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSysDiffRepCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
    }

    public void resetPPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        ArrayList<PSDevSysDiffItem> arrayList = this.selectByPPSDevSysDiffItem(pSDevSysDiffItem);
        for (PSDevSysDiffItem pSDevSysDiffItem2 : arrayList) {
            PSDevSysDiffItem pSDevSysDiffItem3 = (PSDevSysDiffItem)this.getDEModel().createEntity();
            pSDevSysDiffItem3.setPSDevSysDiffItemId(pSDevSysDiffItem2.getPSDevSysDiffItemId());
            pSDevSysDiffItem3.setPPSDevSysDiffItemId(null);
            this.update(pSDevSysDiffItem3);
        }
    }

    public void removeByPPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        final PSDevSysDiffItem pSDevSysDiffItem2 = pSDevSysDiffItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSysDiffItemServiceBase.this.onBeforeRemoveByPPSDevSysDiffItem(pSDevSysDiffItem2);
                PSDevSysDiffItemServiceBase.this.internalRemoveByPPSDevSysDiffItem(pSDevSysDiffItem2);
                PSDevSysDiffItemServiceBase.this.onAfterRemoveByPPSDevSysDiffItem(pSDevSysDiffItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
    }

    protected void internalRemoveByPPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        ArrayList<PSDevSysDiffItem> arrayList = this.selectByPPSDevSysDiffItem(pSDevSysDiffItem);
        this.onBeforeRemoveByPPSDevSysDiffItem(pSDevSysDiffItem, arrayList);
        for (PSDevSysDiffItem pSDevSysDiffItem2 : arrayList) {
            this.remove(pSDevSysDiffItem2);
        }
        this.onAfterRemoveByPPSDevSysDiffItem(pSDevSysDiffItem, arrayList);
    }

    protected void onAfterRemoveByPPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem, ArrayList<PSDevSysDiffItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDevSysDiffItem(PSDevSysDiffItem pSDevSysDiffItem, ArrayList<PSDevSysDiffItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSysDiffRep(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
    }

    public void resetPSDevSysDiffRep(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        ArrayList<PSDevSysDiffItem> arrayList = this.selectByPSDevSysDiffRep(pSDevSysDiffRep);
        for (PSDevSysDiffItem pSDevSysDiffItem : arrayList) {
            PSDevSysDiffItem pSDevSysDiffItem2 = (PSDevSysDiffItem)this.getDEModel().createEntity();
            pSDevSysDiffItem2.setPSDevSysDiffItemId(pSDevSysDiffItem.getPSDevSysDiffItemId());
            pSDevSysDiffItem2.setPSDevSysDiffRepId(null);
            this.update(pSDevSysDiffItem2);
        }
    }

    public void removeByPSDevSysDiffRep(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        final PSDevSysDiffRep pSDevSysDiffRep2 = pSDevSysDiffRep;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSysDiffItemServiceBase.this.onBeforeRemoveByPSDevSysDiffRep(pSDevSysDiffRep2);
                PSDevSysDiffItemServiceBase.this.internalRemoveByPSDevSysDiffRep(pSDevSysDiffRep2);
                PSDevSysDiffItemServiceBase.this.onAfterRemoveByPSDevSysDiffRep(pSDevSysDiffRep2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSysDiffRep(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
    }

    protected void internalRemoveByPSDevSysDiffRep(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        ArrayList<PSDevSysDiffItem> arrayList = this.selectByPSDevSysDiffRep(pSDevSysDiffRep);
        this.onBeforeRemoveByPSDevSysDiffRep(pSDevSysDiffRep, arrayList);
        for (PSDevSysDiffItem pSDevSysDiffItem : arrayList) {
            this.remove(pSDevSysDiffItem);
        }
        this.onAfterRemoveByPSDevSysDiffRep(pSDevSysDiffRep, arrayList);
    }

    protected void onAfterRemoveByPSDevSysDiffRep(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSysDiffRep(PSDevSysDiffRep pSDevSysDiffRep, ArrayList<PSDevSysDiffItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSysDiffRep(PSDevSysDiffRep pSDevSysDiffRep, ArrayList<PSDevSysDiffItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        PSDevSysDiffItemService pSDevSysDiffItemService = (PSDevSysDiffItemService)ServiceGlobal.getService(PSDevSysDiffItemService.class, (SessionFactory)this.getSessionFactory());
        pSDevSysDiffItemService.testRemoveByPPSDevSysDiffItem(pSDevSysDiffItem);
        pSDevSysDiffItemService.resetPPSDevSysDiffItem(pSDevSysDiffItem);
        super.onBeforeRemove(pSDevSysDiffItem);
    }

    protected void replaceParentInfo(PSDevSysDiffItem pSDevSysDiffItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSysDiffItem, cloneSession);
        if (pSDevSysDiffItem.getPPSDevSysDiffItemId() != null && (iEntity = cloneSession.getEntity("PSDEVSYSDIFFITEM", (Object)pSDevSysDiffItem.getPPSDevSysDiffItemId())) != null) {
            this.onFillParentInfo_PPSDevSysDiffItem(pSDevSysDiffItem, (PSDevSysDiffItem)iEntity);
        }
        if (pSDevSysDiffItem.getPSDevSysDiffRepId() != null && (iEntity = cloneSession.getEntity("PSDEVSYSDIFFREP", (Object)pSDevSysDiffItem.getPSDevSysDiffRepId())) != null) {
            this.onFillParentInfo_PSDevSysDiffRep(pSDevSysDiffItem, (PSDevSysDiffRep)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSysDiffItem pSDevSysDiffItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSysDiffItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DiffType(bl, pSDevSysDiffItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjType(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSysDiffItemId(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSysDiffItemName(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSysDiffItemId(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSysDiffItemName(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSysDiffRepId(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSysDiffRepName(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjId(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjName(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncAction(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncResult(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncResultInfo(bl, pSDevSysDiffItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSysDiffItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DiffType(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isDiffTypeDirty() && !bl2 : !pSDevSysDiffItem.isDiffTypeDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getDiffType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DIFFTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DiffType_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DIFFTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isMemoDirty() : !pSDevSysDiffItem.isMemoDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSysDiffItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ObjType(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isObjTypeDirty() : !pSDevSysDiffItem.isObjTypeDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjType_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSysDiffItemId(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPPSDevSysDiffItemIdDirty() : !pSDevSysDiffItem.isPPSDevSysDiffItemIdDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPPSDevSysDiffItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSysDiffItemId_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSYSDIFFITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSysDiffItemName(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPPSDevSysDiffItemNameDirty() : !pSDevSysDiffItem.isPPSDevSysDiffItemNameDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPPSDevSysDiffItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSysDiffItemName_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSYSDIFFITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSDEIdDirty() : !pSDevSysDiffItem.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSDENameDirty() : !pSDevSysDiffItem.isPSDENameDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSysDiffItemId(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSDevSysDiffItemIdDirty() && !bl2 : !pSDevSysDiffItem.isPSDevSysDiffItemIdDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSDevSysDiffItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSysDiffItemId_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSysDiffItemName(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSDevSysDiffItemNameDirty() && !bl2 : !pSDevSysDiffItem.isPSDevSysDiffItemNameDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSDevSysDiffItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSysDiffItemName_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSysDiffRepId(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSDevSysDiffRepIdDirty() && !bl2 : !pSDevSysDiffItem.isPSDevSysDiffRepIdDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSDevSysDiffRepId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFREPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSysDiffRepId_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFREPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSysDiffRepName(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSDevSysDiffRepNameDirty() && !bl2 : !pSDevSysDiffItem.isPSDevSysDiffRepNameDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSDevSysDiffRepName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFREPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSysDiffRepName_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFREPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjId(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSObjIdDirty() && !bl2 : !pSDevSysDiffItem.isPSObjIdDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSObjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjId_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjName(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSObjNameDirty() && !bl2 : !pSDevSysDiffItem.isPSObjNameDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSObjName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjName_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSSysAppIdDirty() : !pSDevSysDiffItem.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isPSSysAppNameDirty() : !pSDevSysDiffItem.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getPSSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncAction(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isSyncActionDirty() && !bl2 : !pSDevSysDiffItem.isSyncActionDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getSyncAction();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCACTION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncAction_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncResult(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isSyncResultDirty() : !pSDevSysDiffItem.isSyncResultDirty()) {
            return null;
        }
        Integer n = pSDevSysDiffItem.getSyncResult();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncResult_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCRESULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncResultInfo(boolean bl, PSDevSysDiffItem pSDevSysDiffItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffItem.isSyncResultInfoDirty() : !pSDevSysDiffItem.isSyncResultInfoDirty()) {
            return null;
        }
        String string = pSDevSysDiffItem.getSyncResultInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncResultInfo_Default(pSDevSysDiffItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCRESULTINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSysDiffItem pSDevSysDiffItem, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSysDiffItem, bl);
    }

    protected void onSyncIndexEntities(PSDevSysDiffItem pSDevSysDiffItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSysDiffItem, bl);
    }

    public Object getDataContextValue(PSDevSysDiffItem pSDevSysDiffItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSysDiffItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSysDiffRep pSDevSysDiffRep = pSDevSysDiffItem.getPSDevSysDiffRep();
        if (pSDevSysDiffRep != null && pSDevSysDiffRep.contains(string)) {
            return pSDevSysDiffRep.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSysDiffItem pSDevSysDiffItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSysDiffItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DIFFTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DiffType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSYSDIFFITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSysDiffItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSYSDIFFITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSysDiffItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSYSDIFFITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSysDiffItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSYSDIFFITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSysDiffItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSYSDIFFREPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSysDiffRepId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSYSDIFFREPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSysDiffRepName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCRESULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncResult_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCRESULTINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncResultInfo_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DiffType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DIFFTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_ObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OBJTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevSysDiffItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSYSDIFFITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevSysDiffItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSYSDIFFITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSysDiffItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSYSDIFFITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSysDiffItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSYSDIFFITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSysDiffRepId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSYSDIFFREPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSysDiffRepName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSYSDIFFREPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCACTION", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncResult_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncResultInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCRESULTINFO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected boolean onMergeChild(String string, String string2, PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSysDiffItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSysDiffItem pSDevSysDiffItem) throws Exception {
        super.onUpdateParent(pSDevSysDiffItem);
    }

    @Override
    protected void exportCurXmlModel(PSDevSysDiffItem pSDevSysDiffItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSYSDIFFITEM");
        if (!bl) {
            pSDevSysDiffItem.setDiffType(null);
            pSDevSysDiffItem.setMemo(null);
            pSDevSysDiffItem.setObjType(null);
            pSDevSysDiffItem.setPSDEId(null);
            pSDevSysDiffItem.setPSDEName(null);
            pSDevSysDiffItem.setPSObjId(null);
            pSDevSysDiffItem.setPSObjName(null);
            pSDevSysDiffItem.setPSSysAppId(null);
            pSDevSysDiffItem.setPSSysAppName(null);
            pSDevSysDiffItem.setSyncResult(null);
            pSDevSysDiffItem.setSyncResultInfo(null);
            super.exportCurXmlModel(pSDevSysDiffItem, xmlNode, bl);
        }
    }
}

