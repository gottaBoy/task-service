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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSysSyncDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSysSyncDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSysSync;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSysSyncServiceBase
extends PSCoreSysServiceBase<PSDevPrdSysSync> {
    private static final Log log = LogFactory.getLog(PSDevPrdSysSyncServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevPrdSysSyncDEModel pSDevPrdSysSyncDEModel;
    private PSDevPrdSysSyncDAO pSDevPrdSysSyncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncService";
    }

    public PSDevPrdSysSyncDEModel getPSDevPrdSysSyncDEModel() {
        if (this.pSDevPrdSysSyncDEModel == null) {
            try {
                this.pSDevPrdSysSyncDEModel = (PSDevPrdSysSyncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSysSyncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSysSyncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdSysSyncDEModel();
    }

    public PSDevPrdSysSyncDAO getPSDevPrdSysSyncDAO() {
        if (this.pSDevPrdSysSyncDAO == null) {
            try {
                this.pSDevPrdSysSyncDAO = (PSDevPrdSysSyncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSysSyncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSysSyncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdSysSyncDAO();
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

    protected void onFillParentInfo(PSDevPrdSysSync pSDevPrdSysSync, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSYSSYNC_PSDEVPRDSYS_DSTPSDEVPRDSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSys pSDevPrdSys = (PSDevPrdSys)iService.getDEModel().createEntity();
            pSDevPrdSys.set("PSDEVPRDSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrdSys);
            } else {
                iService.get((IEntity)pSDevPrdSys);
            }
            this.onFillParentInfo_DstPSDevPrdSys(pSDevPrdSysSync, pSDevPrdSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSYSSYNC_PSDEVPRDSYS_SRCPSDEVPRDSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSys pSDevPrdSys = (PSDevPrdSys)iService.getDEModel().createEntity();
            pSDevPrdSys.set("PSDEVPRDSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrdSys);
            } else {
                iService.get((IEntity)pSDevPrdSys);
            }
            this.onFillParentInfo_SrcPSDevPrdSys(pSDevPrdSysSync, pSDevPrdSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSYSSYNC_PSDEVPRD_PSDEVPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService", (SessionFactory)this.getSessionFactory());
            PSDevPrd pSDevPrd = (PSDevPrd)iService.getDEModel().createEntity();
            pSDevPrd.set("PSDEVPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrd);
            } else {
                iService.get((IEntity)pSDevPrd);
            }
            this.onFillParentInfo_PSDevPrd(pSDevPrdSysSync, pSDevPrd);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevPrdSysSync, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDevPrdSys(PSDevPrdSysSync pSDevPrdSysSync, PSDevPrdSys pSDevPrdSys) throws Exception {
        pSDevPrdSysSync.setDstPSDevPrdSysId(pSDevPrdSys.getPSDevPrdSysId());
        pSDevPrdSysSync.setDstPSDevPrdSysName(pSDevPrdSys.getPSDevPrdSysName());
        if (pSDevPrdSys.getPSDevPrd() != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdSysSync, pSDevPrdSys.getPSDevPrd());
        }
    }

    protected void onFillParentInfo_SrcPSDevPrdSys(PSDevPrdSysSync pSDevPrdSysSync, PSDevPrdSys pSDevPrdSys) throws Exception {
        pSDevPrdSysSync.setSrcPSDevPrdSysId(pSDevPrdSys.getPSDevPrdSysId());
        pSDevPrdSysSync.setSrcPSDevPrdSysName(pSDevPrdSys.getPSDevPrdSysName());
        if (pSDevPrdSys.getPSDevPrd() != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdSysSync, pSDevPrdSys.getPSDevPrd());
        }
    }

    protected void onFillParentInfo_PSDevPrd(PSDevPrdSysSync pSDevPrdSysSync, PSDevPrd pSDevPrd) throws Exception {
        pSDevPrdSysSync.setPSDevPrdId(pSDevPrd.getPSDevPrdId());
        pSDevPrdSysSync.setPSDevPrdName(pSDevPrd.getPSDevPrdName());
    }

    protected void onFillEntityFullInfo(PSDevPrdSysSync pSDevPrdSysSync, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDevPrdSysSync, bl);
        this.onFillEntityFullInfo_DstPSDevPrdSys(pSDevPrdSysSync, bl);
        this.onFillEntityFullInfo_SrcPSDevPrdSys(pSDevPrdSysSync, bl);
        this.onFillEntityFullInfo_PSDevPrd(pSDevPrdSysSync, bl);
    }

    protected void onFillEntityFullInfo_DstPSDevPrdSys(PSDevPrdSysSync pSDevPrdSysSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SrcPSDevPrdSys(PSDevPrdSysSync pSDevPrdSysSync, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrd(PSDevPrdSysSync pSDevPrdSysSync, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevPrdSysSync pSDevPrdSysSync, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevPrdSysSync, bl);
    }

    public ArrayList<PSDevPrdSysSync> selectByDstPSDevPrdSys(PSDevPrdSysBase pSDevPrdSysBase) throws Exception {
        return this.selectByDstPSDevPrdSys(pSDevPrdSysBase, "", -1);
    }

    public ArrayList<PSDevPrdSysSync> selectByDstPSDevPrdSys(PSDevPrdSysBase pSDevPrdSysBase, String string) throws Exception {
        return this.selectByDstPSDevPrdSys(pSDevPrdSysBase, string, -1);
    }

    public ArrayList<PSDevPrdSysSync> selectByDstPSDevPrdSys(PSDevPrdSysBase pSDevPrdSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEVPRDSYSID", (Object)pSDevPrdSysBase.getPSDevPrdSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDevPrdSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDevPrdSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdSysSync> selectBySrcPSDevPrdSys(PSDevPrdSysBase pSDevPrdSysBase) throws Exception {
        return this.selectBySrcPSDevPrdSys(pSDevPrdSysBase, "", -1);
    }

    public ArrayList<PSDevPrdSysSync> selectBySrcPSDevPrdSys(PSDevPrdSysBase pSDevPrdSysBase, String string) throws Exception {
        return this.selectBySrcPSDevPrdSys(pSDevPrdSysBase, string, -1);
    }

    public ArrayList<PSDevPrdSysSync> selectBySrcPSDevPrdSys(PSDevPrdSysBase pSDevPrdSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDEVPRDSYSID", (Object)pSDevPrdSysBase.getPSDevPrdSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDevPrdSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDevPrdSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdSysSync> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, "", -1);
    }

    public ArrayList<PSDevPrdSysSync> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, string, -1);
    }

    public ArrayList<PSDevPrdSysSync> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDID", (Object)pSDevPrdBase.getPSDevPrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDstPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        ArrayList<PSDevPrdSysSync> arrayList = this.selectByDstPSDevPrdSys(pSDevPrdSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrdSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSYSSYNC_PSDEVPRDSYS_DSTPSDEVPRDSYSID", "", iDataEntityModel.getName(), "PSDEVPRDSYSSYNC", iDataEntityModel.getDataInfo((IEntity)pSDevPrdSys), arrayList.get(0)));
        }
    }

    public void resetDstPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        ArrayList<PSDevPrdSysSync> arrayList = this.selectByDstPSDevPrdSys(pSDevPrdSys);
        for (PSDevPrdSysSync pSDevPrdSysSync : arrayList) {
            PSDevPrdSysSync pSDevPrdSysSync2 = (PSDevPrdSysSync)this.getDEModel().createEntity();
            pSDevPrdSysSync2.setPSDevPrdSysSyncId(pSDevPrdSysSync.getPSDevPrdSysSyncId());
            pSDevPrdSysSync2.setDstPSDevPrdSysId(null);
            this.update(pSDevPrdSysSync2);
        }
    }

    public void removeByDstPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        final PSDevPrdSys pSDevPrdSys2 = pSDevPrdSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSysSyncServiceBase.this.onBeforeRemoveByDstPSDevPrdSys(pSDevPrdSys2);
                PSDevPrdSysSyncServiceBase.this.internalRemoveByDstPSDevPrdSys(pSDevPrdSys2);
                PSDevPrdSysSyncServiceBase.this.onAfterRemoveByDstPSDevPrdSys(pSDevPrdSys2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
    }

    protected void internalRemoveByDstPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        ArrayList<PSDevPrdSysSync> arrayList = this.selectByDstPSDevPrdSys(pSDevPrdSys);
        this.onBeforeRemoveByDstPSDevPrdSys(pSDevPrdSys, arrayList);
        for (PSDevPrdSysSync pSDevPrdSysSync : arrayList) {
            this.remove((IEntity)pSDevPrdSysSync);
        }
        this.onAfterRemoveByDstPSDevPrdSys(pSDevPrdSys, arrayList);
    }

    protected void onAfterRemoveByDstPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDevPrdSys(PSDevPrdSys pSDevPrdSys, ArrayList<PSDevPrdSysSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDevPrdSys(PSDevPrdSys pSDevPrdSys, ArrayList<PSDevPrdSysSync> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        ArrayList<PSDevPrdSysSync> arrayList = this.selectBySrcPSDevPrdSys(pSDevPrdSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrdSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSYSSYNC_PSDEVPRDSYS_SRCPSDEVPRDSYSID", "", iDataEntityModel.getName(), "PSDEVPRDSYSSYNC", iDataEntityModel.getDataInfo((IEntity)pSDevPrdSys), arrayList.get(0)));
        }
    }

    public void resetSrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        ArrayList<PSDevPrdSysSync> arrayList = this.selectBySrcPSDevPrdSys(pSDevPrdSys);
        for (PSDevPrdSysSync pSDevPrdSysSync : arrayList) {
            PSDevPrdSysSync pSDevPrdSysSync2 = (PSDevPrdSysSync)this.getDEModel().createEntity();
            pSDevPrdSysSync2.setPSDevPrdSysSyncId(pSDevPrdSysSync.getPSDevPrdSysSyncId());
            pSDevPrdSysSync2.setSrcPSDevPrdSysId(null);
            this.update(pSDevPrdSysSync2);
        }
    }

    public void removeBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        final PSDevPrdSys pSDevPrdSys2 = pSDevPrdSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSysSyncServiceBase.this.onBeforeRemoveBySrcPSDevPrdSys(pSDevPrdSys2);
                PSDevPrdSysSyncServiceBase.this.internalRemoveBySrcPSDevPrdSys(pSDevPrdSys2);
                PSDevPrdSysSyncServiceBase.this.onAfterRemoveBySrcPSDevPrdSys(pSDevPrdSys2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
    }

    protected void internalRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        ArrayList<PSDevPrdSysSync> arrayList = this.selectBySrcPSDevPrdSys(pSDevPrdSys);
        this.onBeforeRemoveBySrcPSDevPrdSys(pSDevPrdSys, arrayList);
        for (PSDevPrdSysSync pSDevPrdSysSync : arrayList) {
            this.remove((IEntity)pSDevPrdSysSync);
        }
        this.onAfterRemoveBySrcPSDevPrdSys(pSDevPrdSys, arrayList);
    }

    protected void onAfterRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys, ArrayList<PSDevPrdSysSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys, ArrayList<PSDevPrdSysSync> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdSysSync> arrayList = this.selectByPSDevPrd(pSDevPrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSYSSYNC_PSDEVPRD_PSDEVPRDID", "", iDataEntityModel.getName(), "PSDEVPRDSYSSYNC", iDataEntityModel.getDataInfo((IEntity)pSDevPrd), arrayList.get(0)));
        }
    }

    public void resetPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdSysSync> arrayList = this.selectByPSDevPrd(pSDevPrd);
        for (PSDevPrdSysSync pSDevPrdSysSync : arrayList) {
            PSDevPrdSysSync pSDevPrdSysSync2 = (PSDevPrdSysSync)this.getDEModel().createEntity();
            pSDevPrdSysSync2.setPSDevPrdSysSyncId(pSDevPrdSysSync.getPSDevPrdSysSyncId());
            pSDevPrdSysSync2.setPSDevPrdId(null);
            this.update(pSDevPrdSysSync2);
        }
    }

    public void removeByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        final PSDevPrd pSDevPrd2 = pSDevPrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSysSyncServiceBase.this.onBeforeRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdSysSyncServiceBase.this.internalRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdSysSyncServiceBase.this.onAfterRemoveByPSDevPrd(pSDevPrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void internalRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdSysSync> arrayList = this.selectByPSDevPrd(pSDevPrd);
        this.onBeforeRemoveByPSDevPrd(pSDevPrd, arrayList);
        for (PSDevPrdSysSync pSDevPrdSysSync : arrayList) {
            this.remove((IEntity)pSDevPrdSysSync);
        }
        this.onAfterRemoveByPSDevPrd(pSDevPrd, arrayList);
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdSysSync> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdSysSync> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
        PSDevPrdSysSyncItemService pSDevPrdSysSyncItemService = (PSDevPrdSysSyncItemService)ServiceGlobal.getService(PSDevPrdSysSyncItemService.class, (SessionFactory)this.getSessionFactory());
        pSDevPrdSysSyncItemService.testRemoveByPSDevPrdSysSync(pSDevPrdSysSync);
        pSDevPrdSysSyncItemService.removeByPSDevPrdSysSync(pSDevPrdSysSync);
        super.onBeforeRemove(pSDevPrdSysSync);
    }

    protected void replaceParentInfo(PSDevPrdSysSync pSDevPrdSysSync, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevPrdSysSync, cloneSession);
        if (pSDevPrdSysSync.getDstPSDevPrdSysId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSYS", (Object)pSDevPrdSysSync.getDstPSDevPrdSysId())) != null) {
            this.onFillParentInfo_DstPSDevPrdSys(pSDevPrdSysSync, (PSDevPrdSys)iEntity);
        }
        if (pSDevPrdSysSync.getSrcPSDevPrdSysId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSYS", (Object)pSDevPrdSysSync.getSrcPSDevPrdSysId())) != null) {
            this.onFillParentInfo_SrcPSDevPrdSys(pSDevPrdSysSync, (PSDevPrdSys)iEntity);
        }
        if (pSDevPrdSysSync.getPSDevPrdId() != null && (iEntity = cloneSession.getEntity("PSDEVPRD", (Object)pSDevPrdSysSync.getPSDevPrdId())) != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdSysSync, (PSDevPrd)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdSysSync pSDevPrdSysSync, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevPrdSysSync, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdSysSync pSDevPrdSysSync, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DstPSDevPrdSysId(bl, pSDevPrdSysSync, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevPrdSysSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdId(bl, pSDevPrdSysSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSysSyncId(bl, pSDevPrdSysSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSysSyncName(bl, pSDevPrdSysSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDevPrdSysId(bl, pSDevPrdSysSync, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevPrdSysSync, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DstPSDevPrdSysId(boolean bl, PSDevPrdSysSync pSDevPrdSysSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSync.isDstPSDevPrdSysIdDirty() && !bl2 : !pSDevPrdSysSync.isDstPSDevPrdSysIdDirty()) {
            return null;
        }
        String string = pSDevPrdSysSync.getDstPSDevPrdSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEVPRDSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDevPrdSysId_Default((IEntity)pSDevPrdSysSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEVPRDSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevPrdSysSync pSDevPrdSysSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSync.isMemoDirty() : !pSDevPrdSysSync.isMemoDirty()) {
            return null;
        }
        String string = pSDevPrdSysSync.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevPrdSysSync, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdId(boolean bl, PSDevPrdSysSync pSDevPrdSysSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSync.isPSDevPrdIdDirty() && !bl2 : !pSDevPrdSysSync.isPSDevPrdIdDirty()) {
            return null;
        }
        String string = pSDevPrdSysSync.getPSDevPrdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdId_Default((IEntity)pSDevPrdSysSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSysSyncId(boolean bl, PSDevPrdSysSync pSDevPrdSysSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSync.isPSDevPrdSysSyncIdDirty() && !bl2 : !pSDevPrdSysSync.isPSDevPrdSysSyncIdDirty()) {
            return null;
        }
        String string = pSDevPrdSysSync.getPSDevPrdSysSyncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSysSyncId_Default((IEntity)pSDevPrdSysSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSysSyncName(boolean bl, PSDevPrdSysSync pSDevPrdSysSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSync.isPSDevPrdSysSyncNameDirty() && !bl2 : !pSDevPrdSysSync.isPSDevPrdSysSyncNameDirty()) {
            return null;
        }
        String string = pSDevPrdSysSync.getPSDevPrdSysSyncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSysSyncName_Default((IEntity)pSDevPrdSysSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDevPrdSysId(boolean bl, PSDevPrdSysSync pSDevPrdSysSync, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSync.isSrcPSDevPrdSysIdDirty() && !bl2 : !pSDevPrdSysSync.isSrcPSDevPrdSysIdDirty()) {
            return null;
        }
        String string = pSDevPrdSysSync.getSrcPSDevPrdSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEVPRDSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDevPrdSysId_Default((IEntity)pSDevPrdSysSync, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEVPRDSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevPrdSysSync pSDevPrdSysSync, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevPrdSysSync, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdSysSync pSDevPrdSysSync, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevPrdSysSync, bl);
    }

    public Object getDataContextValue(PSDevPrdSysSync pSDevPrdSysSync, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevPrdSysSync, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdSysSync pSDevPrdSysSync, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevPrdSysSync, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEVPRDSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDevPrdSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEVPRDSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDevPrdSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSYSSYNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSysSyncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSYSSYNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSysSyncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEVPRDSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDevPrdSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEVPRDSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDevPrdSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DstPSDevPrdSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEVPRDSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDevPrdSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEVPRDSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDevPrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSysSyncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSYSSYNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSysSyncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSYSSYNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDevPrdSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEVPRDSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDevPrdSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEVPRDSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevPrdSysSync)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
        super.onUpdateParent((IEntity)pSDevPrdSysSync);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdSysSync pSDevPrdSysSync, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDSYSSYNC");
        if (!bl) {
            pSDevPrdSysSync.setCreateDate(null);
            pSDevPrdSysSync.setCreateMan(null);
            pSDevPrdSysSync.setPSDevPrdSysSyncId(null);
            pSDevPrdSysSync.setUpdateDate(null);
            pSDevPrdSysSync.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdSysSync, xmlNode, bl);
        }
    }
}

