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
package net.ibizsys.pscore.srv.dynasys.service;

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
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaWFVerInstDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaWFVerInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInstBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVerBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVerInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaWFVerInstServiceBase
extends PSCoreSysServiceBase<PSDynaWFVerInst> {
    private static final Log log = LogFactory.getLog(PSDynaWFVerInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_UPDATEDYNAMODEL = "UpdateDynaModel";
    private PSDynaWFVerInstDEModel pSDynaWFVerInstDEModel;
    private PSDynaWFVerInstDAO pSDynaWFVerInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerInstService";
    }

    public PSDynaWFVerInstDEModel getPSDynaWFVerInstDEModel() {
        if (this.pSDynaWFVerInstDEModel == null) {
            try {
                this.pSDynaWFVerInstDEModel = (PSDynaWFVerInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaWFVerInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaWFVerInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaWFVerInstDEModel();
    }

    public PSDynaWFVerInstDAO getPSDynaWFVerInstDAO() {
        if (this.pSDynaWFVerInstDAO == null) {
            try {
                this.pSDynaWFVerInstDAO = (PSDynaWFVerInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaWFVerInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaWFVerInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaWFVerInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEDYNAMODEL, (boolean)true) == 0) {
            this.updateDynaModel((PSDynaWFVerInst)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void updateDynaModel(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDYNAMODEL, 0, (IEntity)pSDynaWFVerInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDynaWFVerInst, ACTION_UPDATEDYNAMODEL);
        final PSDynaWFVerInst pSDynaWFVerInst2 = pSDynaWFVerInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDynaWFVerInstServiceBase.this.getService(), PSDynaWFVerInstServiceBase.ACTION_UPDATEDYNAMODEL, 40, (IEntity)pSDynaWFVerInst2, null).getResult() != 1) {
                    PSDynaWFVerInstServiceBase.this.onUpdateDynaModel(pSDynaWFVerInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDYNAMODEL, 99, (IEntity)pSDynaWFVerInst, null);
        }
    }

    protected void onUpdateDynaModel(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateDynaModel]");
    }

    protected void onFillParentInfo(PSDynaWFVerInst pSDynaWFVerInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAWFVERINST_PSDYNAINST_PSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDynaInst pSDynaInst = (PSDynaInst)iService.getDEModel().createEntity();
            pSDynaInst.set("PSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaInst);
            } else {
                iService.get((IEntity)pSDynaInst);
            }
            this.onFillParentInfo_PSDynaInst(pSDynaWFVerInst, pSDynaInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAWFVERINST_PSDYNAWFVER_PSDYNAWFVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService", (SessionFactory)this.getSessionFactory());
            PSDynaWFVer pSDynaWFVer = (PSDynaWFVer)iService.getDEModel().createEntity();
            pSDynaWFVer.set("PSDYNAWFVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaWFVer);
            } else {
                iService.get((IEntity)pSDynaWFVer);
            }
            this.onFillParentInfo_PSDynaWFVer(pSDynaWFVerInst, pSDynaWFVer);
            return;
        }
        super.onFillParentInfo((IEntity)pSDynaWFVerInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDynaInst(PSDynaWFVerInst pSDynaWFVerInst, PSDynaInst pSDynaInst) throws Exception {
        pSDynaWFVerInst.setPSDynaInstId(pSDynaInst.getPSDynaInstId());
        pSDynaWFVerInst.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
    }

    protected void onFillParentInfo_PSDynaWFVer(PSDynaWFVerInst pSDynaWFVerInst, PSDynaWFVer pSDynaWFVer) throws Exception {
        pSDynaWFVerInst.setPSDynaWFVerId(pSDynaWFVer.getPSDynaWFVerId());
        pSDynaWFVerInst.setPSDynaWFVerName(pSDynaWFVer.getPSDynaWFVerName());
    }

    protected void onFillEntityFullInfo(PSDynaWFVerInst pSDynaWFVerInst, boolean bl) throws Exception {
        if (bl) {
            if (pSDynaWFVerInst.getInstVer() == null) {
                pSDynaWFVerInst.setInstVer((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDynaWFVerInst.getValidFlag() == null) {
                pSDynaWFVerInst.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDynaWFVerInst, bl);
        this.onFillEntityFullInfo_PSDynaInst(pSDynaWFVerInst, bl);
        this.onFillEntityFullInfo_PSDynaWFVer(pSDynaWFVerInst, bl);
    }

    protected void onFillEntityFullInfo_PSDynaInst(PSDynaWFVerInst pSDynaWFVerInst, boolean bl) throws Exception {
        if (pSDynaWFVerInst.isPSDynaInstIdDirty()) {
            if (pSDynaWFVerInst.getPSDynaInstId() != null) {
                if (pSDynaWFVerInst.getPSDynaInstId() == null || pSDynaWFVerInst.getPSDynaInstName() == null) {
                    PSDynaInst pSDynaInst = pSDynaWFVerInst.getPSDynaInst();
                    pSDynaWFVerInst.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
                }
            } else {
                pSDynaWFVerInst.setPSDynaInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDynaWFVer(PSDynaWFVerInst pSDynaWFVerInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDynaWFVerInst pSDynaWFVerInst, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDynaWFVerInst, bl);
    }

    public ArrayList<PSDynaWFVerInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, "", -1);
    }

    public ArrayList<PSDynaWFVerInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, string, -1);
    }

    public ArrayList<PSDynaWFVerInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAINSTID", (Object)pSDynaInstBase.getPSDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaWFVerInst> selectByPSDynaWFVer(PSDynaWFVerBase pSDynaWFVerBase) throws Exception {
        return this.selectByPSDynaWFVer(pSDynaWFVerBase, "", -1);
    }

    public ArrayList<PSDynaWFVerInst> selectByPSDynaWFVer(PSDynaWFVerBase pSDynaWFVerBase, String string) throws Exception {
        return this.selectByPSDynaWFVer(pSDynaWFVerBase, string, -1);
    }

    public ArrayList<PSDynaWFVerInst> selectByPSDynaWFVer(PSDynaWFVerBase pSDynaWFVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAWFVERID", (Object)pSDynaWFVerBase.getPSDynaWFVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaWFVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaWFVerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaWFVerInst> arrayList = this.selectByPSDynaInst(pSDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAWFVERINST_PSDYNAINST_PSDYNAINSTID", "", iDataEntityModel.getName(), "PSDYNAWFVERINST", iDataEntityModel.getDataInfo((IEntity)pSDynaInst), arrayList.get(0)));
        }
    }

    public void resetPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaWFVerInst> arrayList = this.selectByPSDynaInst(pSDynaInst);
        for (PSDynaWFVerInst pSDynaWFVerInst : arrayList) {
            PSDynaWFVerInst pSDynaWFVerInst2 = (PSDynaWFVerInst)this.getDEModel().createEntity();
            pSDynaWFVerInst2.setPSDynaWFVerInstId(pSDynaWFVerInst.getPSDynaWFVerInstId());
            pSDynaWFVerInst2.setPSDynaInstId(null);
            this.update(pSDynaWFVerInst2);
        }
    }

    public void removeByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        final PSDynaInst pSDynaInst2 = pSDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaWFVerInstServiceBase.this.onBeforeRemoveByPSDynaInst(pSDynaInst2);
                PSDynaWFVerInstServiceBase.this.internalRemoveByPSDynaInst(pSDynaInst2);
                PSDynaWFVerInstServiceBase.this.onAfterRemoveByPSDynaInst(pSDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaWFVerInst> arrayList = this.selectByPSDynaInst(pSDynaInst);
        this.onBeforeRemoveByPSDynaInst(pSDynaInst, arrayList);
        for (PSDynaWFVerInst pSDynaWFVerInst : arrayList) {
            this.remove((IEntity)pSDynaWFVerInst);
        }
        this.onAfterRemoveByPSDynaInst(pSDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDynaWFVerInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDynaWFVerInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
        ArrayList<PSDynaWFVerInst> arrayList = this.selectByPSDynaWFVer(pSDynaWFVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAWFVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaWFVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAWFVERINST_PSDYNAWFVER_PSDYNAWFVERID", "", iDataEntityModel.getName(), "PSDYNAWFVERINST", iDataEntityModel.getDataInfo((IEntity)pSDynaWFVer), arrayList.get(0)));
        }
    }

    public void resetPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
        ArrayList<PSDynaWFVerInst> arrayList = this.selectByPSDynaWFVer(pSDynaWFVer);
        for (PSDynaWFVerInst pSDynaWFVerInst : arrayList) {
            PSDynaWFVerInst pSDynaWFVerInst2 = (PSDynaWFVerInst)this.getDEModel().createEntity();
            pSDynaWFVerInst2.setPSDynaWFVerInstId(pSDynaWFVerInst.getPSDynaWFVerInstId());
            pSDynaWFVerInst2.setPSDynaWFVerId(null);
            this.update(pSDynaWFVerInst2);
        }
    }

    public void removeByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
        final PSDynaWFVer pSDynaWFVer2 = pSDynaWFVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaWFVerInstServiceBase.this.onBeforeRemoveByPSDynaWFVer(pSDynaWFVer2);
                PSDynaWFVerInstServiceBase.this.internalRemoveByPSDynaWFVer(pSDynaWFVer2);
                PSDynaWFVerInstServiceBase.this.onAfterRemoveByPSDynaWFVer(pSDynaWFVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
    }

    protected void internalRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
        ArrayList<PSDynaWFVerInst> arrayList = this.selectByPSDynaWFVer(pSDynaWFVer);
        this.onBeforeRemoveByPSDynaWFVer(pSDynaWFVer, arrayList);
        for (PSDynaWFVerInst pSDynaWFVerInst : arrayList) {
            this.remove((IEntity)pSDynaWFVerInst);
        }
        this.onAfterRemoveByPSDynaWFVer(pSDynaWFVer, arrayList);
    }

    protected void onAfterRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer, ArrayList<PSDynaWFVerInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer, ArrayList<PSDynaWFVerInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        PSDynaAppViewInstService pSDynaAppViewInstService = (PSDynaAppViewInstService)ServiceGlobal.getService(PSDynaAppViewInstService.class, (SessionFactory)this.getSessionFactory());
        pSDynaAppViewInstService.testRemoveByPSDynaWFVerInst(pSDynaWFVerInst);
        super.onBeforeRemove(pSDynaWFVerInst);
    }

    protected void replaceParentInfo(PSDynaWFVerInst pSDynaWFVerInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDynaWFVerInst, cloneSession);
        if (pSDynaWFVerInst.getPSDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDYNAINST", (Object)pSDynaWFVerInst.getPSDynaInstId())) != null) {
            this.onFillParentInfo_PSDynaInst(pSDynaWFVerInst, (PSDynaInst)iEntity);
        }
        if (pSDynaWFVerInst.getPSDynaWFVerId() != null && (iEntity = cloneSession.getEntity("PSDYNAWFVER", (Object)pSDynaWFVerInst.getPSDynaWFVerId())) != null) {
            this.onFillParentInfo_PSDynaWFVer(pSDynaWFVerInst, (PSDynaWFVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaWFVerInst pSDynaWFVerInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDynaWFVerInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DynaModel(bl, pSDynaWFVerInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstVer(bl, pSDynaWFVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaWFVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDynaWFVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstName(bl, pSDynaWFVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerId(bl, pSDynaWFVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerInstId(bl, pSDynaWFVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerInstName(bl, pSDynaWFVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDynaWFVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFVersion(bl, pSDynaWFVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDynaWFVerInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DynaModel(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isDynaModelDirty() : !pSDynaWFVerInst.isDynaModelDirty()) {
            return null;
        }
        String string = pSDynaWFVerInst.getDynaModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaModel_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstVer(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isInstVerDirty() : !pSDynaWFVerInst.isInstVerDirty()) {
            return null;
        }
        Integer n = pSDynaWFVerInst.getInstVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InstVer_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isMemoDirty() : !pSDynaWFVerInst.isMemoDirty()) {
            return null;
        }
        String string = pSDynaWFVerInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isPSDynaInstIdDirty() && !bl2 : !pSDynaWFVerInst.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDynaWFVerInst.getPSDynaInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstName(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isPSDynaInstNameDirty() && !bl2 : !pSDynaWFVerInst.isPSDynaInstNameDirty()) {
            return null;
        }
        String string = pSDynaWFVerInst.getPSDynaInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstName_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaWFVerId(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isPSDynaWFVerIdDirty() : !pSDynaWFVerInst.isPSDynaWFVerIdDirty()) {
            return null;
        }
        String string = pSDynaWFVerInst.getPSDynaWFVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerId_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaWFVerInstId(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isPSDynaWFVerInstIdDirty() && !bl2 : !pSDynaWFVerInst.isPSDynaWFVerInstIdDirty()) {
            return null;
        }
        String string = pSDynaWFVerInst.getPSDynaWFVerInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerInstId_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaWFVerInstName(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isPSDynaWFVerInstNameDirty() && !bl2 : !pSDynaWFVerInst.isPSDynaWFVerInstNameDirty()) {
            return null;
        }
        String string = pSDynaWFVerInst.getPSDynaWFVerInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerInstName_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isValidFlagDirty() && !bl2 : !pSDynaWFVerInst.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDynaWFVerInst.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_WFVersion(boolean bl, PSDynaWFVerInst pSDynaWFVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVerInst.isWFVersionDirty() && !bl2 : !pSDynaWFVerInst.isWFVersionDirty()) {
            return null;
        }
        Integer n = pSDynaWFVerInst.getWFVersion();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVERSION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_WFVersion_Default((IEntity)pSDynaWFVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaWFVerInst pSDynaWFVerInst, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDynaWFVerInst, bl);
    }

    protected void onSyncIndexEntities(PSDynaWFVerInst pSDynaWFVerInst, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDynaWFVerInst, bl);
    }

    public Object getDataContextValue(PSDynaWFVerInst pSDynaWFVerInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDynaWFVerInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaWFVerInst pSDynaWFVerInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDynaWFVerInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFVersion_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DynaModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFVersion_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDynaWFVerInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        super.onUpdateParent((IEntity)pSDynaWFVerInst);
    }

    @Override
    protected void exportCurXmlModel(PSDynaWFVerInst pSDynaWFVerInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNAWFVERINST");
        if (!bl) {
            pSDynaWFVerInst.setCreateDate(null);
            pSDynaWFVerInst.setCreateMan(null);
            pSDynaWFVerInst.setPSDynaInstId(null);
            pSDynaWFVerInst.setPSDynaInstName(null);
            pSDynaWFVerInst.setPSDynaWFVerInstId(null);
            pSDynaWFVerInst.setPSDynaWFVerName(null);
            pSDynaWFVerInst.setUpdateDate(null);
            pSDynaWFVerInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaWFVerInst, xmlNode, bl);
        }
    }
}

