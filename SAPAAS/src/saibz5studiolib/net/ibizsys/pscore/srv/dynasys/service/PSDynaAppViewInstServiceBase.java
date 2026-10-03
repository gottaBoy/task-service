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
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppViewInstDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppViewInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppView;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInstBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVerInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVerInstBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppVCInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppViewInstServiceBase
extends PSCoreSysServiceBase<PSDynaAppViewInst> {
    private static final Log log = LogFactory.getLog(PSDynaAppViewInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_UPDATEDYNAMODEL = "UpdateDynaModel";
    private PSDynaAppViewInstDEModel pSDynaAppViewInstDEModel;
    private PSDynaAppViewInstDAO pSDynaAppViewInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstService";
    }

    public PSDynaAppViewInstDEModel getPSDynaAppViewInstDEModel() {
        if (this.pSDynaAppViewInstDEModel == null) {
            try {
                this.pSDynaAppViewInstDEModel = (PSDynaAppViewInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppViewInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppViewInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaAppViewInstDEModel();
    }

    public PSDynaAppViewInstDAO getPSDynaAppViewInstDAO() {
        if (this.pSDynaAppViewInstDAO == null) {
            try {
                this.pSDynaAppViewInstDAO = (PSDynaAppViewInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppViewInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppViewInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaAppViewInstDAO();
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
            this.updateDynaModel((PSDynaAppViewInst)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void updateDynaModel(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDYNAMODEL, 0, pSDynaAppViewInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDynaAppViewInst, ACTION_UPDATEDYNAMODEL);
        final PSDynaAppViewInst pSDynaAppViewInst2 = pSDynaAppViewInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDynaAppViewInstServiceBase.this.getService(), PSDynaAppViewInstServiceBase.ACTION_UPDATEDYNAMODEL, 40, pSDynaAppViewInst2, null).getResult() != 1) {
                    PSDynaAppViewInstServiceBase.this.onUpdateDynaModel(pSDynaAppViewInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDYNAMODEL, 99, pSDynaAppViewInst, null);
        }
    }

    protected void onUpdateDynaModel(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateDynaModel]");
    }

    protected void onFillParentInfo(PSDynaAppViewInst pSDynaAppViewInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEWINST_PSDYNAAPPVIEW_PSDYNAAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService", (SessionFactory)this.getSessionFactory());
            PSDynaAppView pSDynaAppView = (PSDynaAppView)iService.getDEModel().createEntity();
            pSDynaAppView.set("PSDYNAAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaAppView);
            } else {
                iService.get(pSDynaAppView);
            }
            this.onFillParentInfo_PSDynaAppView(pSDynaAppViewInst, pSDynaAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEWINST_PSDYNAAPP_PSDYNAAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService", (SessionFactory)this.getSessionFactory());
            PSDynaApp pSDynaApp = (PSDynaApp)iService.getDEModel().createEntity();
            pSDynaApp.set("PSDYNAAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaApp);
            } else {
                iService.get(pSDynaApp);
            }
            this.onFillParentInfo_PSDynaApp(pSDynaAppViewInst, pSDynaApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEWINST_PSDYNAINST_PSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDynaInst pSDynaInst = (PSDynaInst)iService.getDEModel().createEntity();
            pSDynaInst.set("PSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaInst);
            } else {
                iService.get(pSDynaInst);
            }
            this.onFillParentInfo_PSDynaInst(pSDynaAppViewInst, pSDynaInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEWINST_PSDYNAWFVERINST_PSDYNAWFVERINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerInstService", (SessionFactory)this.getSessionFactory());
            PSDynaWFVerInst pSDynaWFVerInst = (PSDynaWFVerInst)iService.getDEModel().createEntity();
            pSDynaWFVerInst.set("PSDYNAWFVERINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaWFVerInst);
            } else {
                iService.get(pSDynaWFVerInst);
            }
            this.onFillParentInfo_PSDynaWFVerInst(pSDynaAppViewInst, pSDynaWFVerInst);
            return;
        }
        super.onFillParentInfo(pSDynaAppViewInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDynaAppView(PSDynaAppViewInst pSDynaAppViewInst, PSDynaAppView pSDynaAppView) throws Exception {
        pSDynaAppViewInst.setPSDynaAppViewId(pSDynaAppView.getPSDynaAppViewId());
        pSDynaAppViewInst.setPSDynaAppViewName(pSDynaAppView.getPSDynaAppViewName());
    }

    protected void onFillParentInfo_PSDynaApp(PSDynaAppViewInst pSDynaAppViewInst, PSDynaApp pSDynaApp) throws Exception {
        pSDynaAppViewInst.setPSDynaAppId(pSDynaApp.getPSDynaAppId());
        pSDynaAppViewInst.setPSDynaAppName(pSDynaApp.getPSDynaAppName());
    }

    protected void onFillParentInfo_PSDynaInst(PSDynaAppViewInst pSDynaAppViewInst, PSDynaInst pSDynaInst) throws Exception {
        pSDynaAppViewInst.setPSDynaInstId(pSDynaInst.getPSDynaInstId());
        pSDynaAppViewInst.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
    }

    protected void onFillParentInfo_PSDynaWFVerInst(PSDynaAppViewInst pSDynaAppViewInst, PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        pSDynaAppViewInst.setPSDynaWFVerInstId(pSDynaWFVerInst.getPSDynaWFVerInstId());
        pSDynaAppViewInst.setPSDynaWFVerInstName(pSDynaWFVerInst.getPSDynaWFVerInstName());
    }

    protected void onFillEntityFullInfo(PSDynaAppViewInst pSDynaAppViewInst, boolean bl) throws Exception {
        if (bl) {
            if (pSDynaAppViewInst.getInstVer() == null) {
                pSDynaAppViewInst.setInstVer((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDynaAppViewInst.getMobViewFlag() == null) {
                pSDynaAppViewInst.setMobViewFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSDynaAppViewInst, bl);
        this.onFillEntityFullInfo_PSDynaAppView(pSDynaAppViewInst, bl);
        this.onFillEntityFullInfo_PSDynaApp(pSDynaAppViewInst, bl);
        this.onFillEntityFullInfo_PSDynaInst(pSDynaAppViewInst, bl);
        this.onFillEntityFullInfo_PSDynaWFVerInst(pSDynaAppViewInst, bl);
    }

    protected void onFillEntityFullInfo_PSDynaAppView(PSDynaAppViewInst pSDynaAppViewInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaApp(PSDynaAppViewInst pSDynaAppViewInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaInst(PSDynaAppViewInst pSDynaAppViewInst, boolean bl) throws Exception {
        if (pSDynaAppViewInst.isPSDynaInstIdDirty()) {
            if (pSDynaAppViewInst.getPSDynaInstId() != null) {
                if (pSDynaAppViewInst.getPSDynaInstId() == null || pSDynaAppViewInst.getPSDynaInstName() == null) {
                    PSDynaInst pSDynaInst = pSDynaAppViewInst.getPSDynaInst();
                    pSDynaAppViewInst.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
                }
            } else {
                pSDynaAppViewInst.setPSDynaInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDynaWFVerInst(PSDynaAppViewInst pSDynaAppViewInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDynaAppViewInst pSDynaAppViewInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaAppViewInst, bl);
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaAppView(PSDynaAppViewBase pSDynaAppViewBase) throws Exception {
        return this.selectByPSDynaAppView(pSDynaAppViewBase, "", -1);
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaAppView(PSDynaAppViewBase pSDynaAppViewBase, String string) throws Exception {
        return this.selectByPSDynaAppView(pSDynaAppViewBase, string, -1);
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaAppView(PSDynaAppViewBase pSDynaAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAAPPVIEWID", (Object)pSDynaAppViewBase.getPSDynaAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase) throws Exception {
        return this.selectByPSDynaApp(pSDynaAppBase, "", -1);
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase, String string) throws Exception {
        return this.selectByPSDynaApp(pSDynaAppBase, string, -1);
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAAPPID", (Object)pSDynaAppBase.getPSDynaAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, "", -1);
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, string, -1);
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string, int n) throws Exception {
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

    public ArrayList<PSDynaAppViewInst> selectByPSDynaWFVerInst(PSDynaWFVerInstBase pSDynaWFVerInstBase) throws Exception {
        return this.selectByPSDynaWFVerInst(pSDynaWFVerInstBase, "", -1);
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaWFVerInst(PSDynaWFVerInstBase pSDynaWFVerInstBase, String string) throws Exception {
        return this.selectByPSDynaWFVerInst(pSDynaWFVerInstBase, string, -1);
    }

    public ArrayList<PSDynaAppViewInst> selectByPSDynaWFVerInst(PSDynaWFVerInstBase pSDynaWFVerInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAWFVERINSTID", (Object)pSDynaWFVerInstBase.getPSDynaWFVerInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaWFVerInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaWFVerInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaAppView(pSDynaAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAAPPVIEWINST_PSDYNAAPPVIEW_PSDYNAAPPVIEWID", "", iDataEntityModel.getName(), "PSDYNAAPPVIEWINST", iDataEntityModel.getDataInfo(pSDynaAppView), arrayList.get(0)));
        }
    }

    public void resetPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaAppView(pSDynaAppView);
        for (PSDynaAppViewInst pSDynaAppViewInst : arrayList) {
            PSDynaAppViewInst pSDynaAppViewInst2 = (PSDynaAppViewInst)this.getDEModel().createEntity();
            pSDynaAppViewInst2.setPSDynaAppViewInstId(pSDynaAppViewInst.getPSDynaAppViewInstId());
            pSDynaAppViewInst2.setPSDynaAppViewId(null);
            this.update(pSDynaAppViewInst2);
        }
    }

    public void removeByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
        final PSDynaAppView pSDynaAppView2 = pSDynaAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewInstServiceBase.this.onBeforeRemoveByPSDynaAppView(pSDynaAppView2);
                PSDynaAppViewInstServiceBase.this.internalRemoveByPSDynaAppView(pSDynaAppView2);
                PSDynaAppViewInstServiceBase.this.onAfterRemoveByPSDynaAppView(pSDynaAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
    }

    protected void internalRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaAppView(pSDynaAppView);
        this.onBeforeRemoveByPSDynaAppView(pSDynaAppView, arrayList);
        for (PSDynaAppViewInst pSDynaAppViewInst : arrayList) {
            this.remove(pSDynaAppViewInst);
        }
        this.onAfterRemoveByPSDynaAppView(pSDynaAppView, arrayList);
    }

    protected void onAfterRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView, ArrayList<PSDynaAppViewInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaAppView(PSDynaAppView pSDynaAppView, ArrayList<PSDynaAppViewInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    public void resetPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaApp(pSDynaApp);
        for (PSDynaAppViewInst pSDynaAppViewInst : arrayList) {
            PSDynaAppViewInst pSDynaAppViewInst2 = (PSDynaAppViewInst)this.getDEModel().createEntity();
            pSDynaAppViewInst2.setPSDynaAppViewInstId(pSDynaAppViewInst.getPSDynaAppViewInstId());
            pSDynaAppViewInst2.setPSDynaAppId(null);
            this.update(pSDynaAppViewInst2);
        }
    }

    public void removeByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        final PSDynaApp pSDynaApp2 = pSDynaApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewInstServiceBase.this.onBeforeRemoveByPSDynaApp(pSDynaApp2);
                PSDynaAppViewInstServiceBase.this.internalRemoveByPSDynaApp(pSDynaApp2);
                PSDynaAppViewInstServiceBase.this.onAfterRemoveByPSDynaApp(pSDynaApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    protected void internalRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaApp(pSDynaApp);
        this.onBeforeRemoveByPSDynaApp(pSDynaApp, arrayList);
        for (PSDynaAppViewInst pSDynaAppViewInst : arrayList) {
            this.remove(pSDynaAppViewInst);
        }
        this.onAfterRemoveByPSDynaApp(pSDynaApp, arrayList);
    }

    protected void onAfterRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaApp(PSDynaApp pSDynaApp, ArrayList<PSDynaAppViewInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaApp(PSDynaApp pSDynaApp, ArrayList<PSDynaAppViewInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    public void resetPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaInst(pSDynaInst);
        for (PSDynaAppViewInst pSDynaAppViewInst : arrayList) {
            PSDynaAppViewInst pSDynaAppViewInst2 = (PSDynaAppViewInst)this.getDEModel().createEntity();
            pSDynaAppViewInst2.setPSDynaAppViewInstId(pSDynaAppViewInst.getPSDynaAppViewInstId());
            pSDynaAppViewInst2.setPSDynaInstId(null);
            this.update(pSDynaAppViewInst2);
        }
    }

    public void removeByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        final PSDynaInst pSDynaInst2 = pSDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewInstServiceBase.this.onBeforeRemoveByPSDynaInst(pSDynaInst2);
                PSDynaAppViewInstServiceBase.this.internalRemoveByPSDynaInst(pSDynaInst2);
                PSDynaAppViewInstServiceBase.this.onAfterRemoveByPSDynaInst(pSDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaInst(pSDynaInst);
        this.onBeforeRemoveByPSDynaInst(pSDynaInst, arrayList);
        for (PSDynaAppViewInst pSDynaAppViewInst : arrayList) {
            this.remove(pSDynaAppViewInst);
        }
        this.onAfterRemoveByPSDynaInst(pSDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDynaAppViewInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDynaAppViewInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaWFVerInst(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaWFVerInst(pSDynaWFVerInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAWFVERINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaWFVerInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAAPPVIEWINST_PSDYNAWFVERINST_PSDYNAWFVERINSTID", "", iDataEntityModel.getName(), "PSDYNAAPPVIEWINST", iDataEntityModel.getDataInfo(pSDynaWFVerInst), arrayList.get(0)));
        }
    }

    public void resetPSDynaWFVerInst(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaWFVerInst(pSDynaWFVerInst);
        for (PSDynaAppViewInst pSDynaAppViewInst : arrayList) {
            PSDynaAppViewInst pSDynaAppViewInst2 = (PSDynaAppViewInst)this.getDEModel().createEntity();
            pSDynaAppViewInst2.setPSDynaAppViewInstId(pSDynaAppViewInst.getPSDynaAppViewInstId());
            pSDynaAppViewInst2.setPSDynaWFVerInstId(null);
            this.update(pSDynaAppViewInst2);
        }
    }

    public void removeByPSDynaWFVerInst(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        final PSDynaWFVerInst pSDynaWFVerInst2 = pSDynaWFVerInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewInstServiceBase.this.onBeforeRemoveByPSDynaWFVerInst(pSDynaWFVerInst2);
                PSDynaAppViewInstServiceBase.this.internalRemoveByPSDynaWFVerInst(pSDynaWFVerInst2);
                PSDynaAppViewInstServiceBase.this.onAfterRemoveByPSDynaWFVerInst(pSDynaWFVerInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaWFVerInst(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
    }

    protected void internalRemoveByPSDynaWFVerInst(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
        ArrayList<PSDynaAppViewInst> arrayList = this.selectByPSDynaWFVerInst(pSDynaWFVerInst);
        this.onBeforeRemoveByPSDynaWFVerInst(pSDynaWFVerInst, arrayList);
        for (PSDynaAppViewInst pSDynaAppViewInst : arrayList) {
            this.remove(pSDynaAppViewInst);
        }
        this.onAfterRemoveByPSDynaWFVerInst(pSDynaWFVerInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaWFVerInst(PSDynaWFVerInst pSDynaWFVerInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaWFVerInst(PSDynaWFVerInst pSDynaWFVerInst, ArrayList<PSDynaAppViewInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaWFVerInst(PSDynaWFVerInst pSDynaWFVerInst, ArrayList<PSDynaAppViewInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
        PSDynaAppVCInstService pSDynaAppVCInstService = (PSDynaAppVCInstService)ServiceGlobal.getService(PSDynaAppVCInstService.class, (SessionFactory)this.getSessionFactory());
        pSDynaAppVCInstService.testRemoveByPSDynaAppViewInst(pSDynaAppViewInst);
        pSDynaAppVCInstService.removeByPSDynaAppViewInst(pSDynaAppViewInst);
        super.onBeforeRemove(pSDynaAppViewInst);
    }

    protected void replaceParentInfo(PSDynaAppViewInst pSDynaAppViewInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaAppViewInst, cloneSession);
        if (pSDynaAppViewInst.getPSDynaAppViewId() != null && (iEntity = cloneSession.getEntity("PSDYNAAPPVIEW", (Object)pSDynaAppViewInst.getPSDynaAppViewId())) != null) {
            this.onFillParentInfo_PSDynaAppView(pSDynaAppViewInst, (PSDynaAppView)iEntity);
        }
        if (pSDynaAppViewInst.getPSDynaAppId() != null && (iEntity = cloneSession.getEntity("PSDYNAAPP", (Object)pSDynaAppViewInst.getPSDynaAppId())) != null) {
            this.onFillParentInfo_PSDynaApp(pSDynaAppViewInst, (PSDynaApp)iEntity);
        }
        if (pSDynaAppViewInst.getPSDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDYNAINST", (Object)pSDynaAppViewInst.getPSDynaInstId())) != null) {
            this.onFillParentInfo_PSDynaInst(pSDynaAppViewInst, (PSDynaInst)iEntity);
        }
        if (pSDynaAppViewInst.getPSDynaWFVerInstId() != null && (iEntity = cloneSession.getEntity("PSDYNAWFVERINST", (Object)pSDynaAppViewInst.getPSDynaWFVerInstId())) != null) {
            this.onFillParentInfo_PSDynaWFVerInst(pSDynaAppViewInst, (PSDynaWFVerInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaAppViewInst pSDynaAppViewInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaAppViewInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Caption(bl, pSDynaAppViewInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModel(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaViewParam(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaViewParam2(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaViewParam3(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaViewParam4(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaViewParam5(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaViewParam6(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewActions(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstVer(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobViewFlag(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PDVTParam(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedViewType(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppId(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewId(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewInstId(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewInstName(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstName(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerInstId(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCaption(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewActions(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam2(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam5(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam6(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam2(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam3(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam4(bl, pSDynaAppViewInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaAppViewInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isCaptionDirty() : !pSDynaAppViewInst.isCaptionDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSDynaAppViewInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModel(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isDynaModelDirty() : !pSDynaAppViewInst.isDynaModelDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getDynaModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaModel_Default(pSDynaAppViewInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaViewParam(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isDynaViewParamDirty() : !pSDynaAppViewInst.isDynaViewParamDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getDynaViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaViewParam_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaViewParam2(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isDynaViewParam2Dirty() : !pSDynaAppViewInst.isDynaViewParam2Dirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getDynaViewParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaViewParam2_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAVIEWPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaViewParam3(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isDynaViewParam3Dirty() : !pSDynaAppViewInst.isDynaViewParam3Dirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getDynaViewParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaViewParam3_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAVIEWPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaViewParam4(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isDynaViewParam4Dirty() : !pSDynaAppViewInst.isDynaViewParam4Dirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getDynaViewParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaViewParam4_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAVIEWPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaViewParam5(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isDynaViewParam5Dirty() : !pSDynaAppViewInst.isDynaViewParam5Dirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getDynaViewParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaViewParam5_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAVIEWPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaViewParam6(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isDynaViewParam6Dirty() : !pSDynaAppViewInst.isDynaViewParam6Dirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getDynaViewParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaViewParam6_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAVIEWPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableViewActions(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isEnableViewActionsDirty() : !pSDynaAppViewInst.isEnableViewActionsDirty()) {
            return null;
        }
        Integer n = pSDynaAppViewInst.getEnableViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewActions_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEVIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstVer(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isInstVerDirty() : !pSDynaAppViewInst.isInstVerDirty()) {
            return null;
        }
        Integer n = pSDynaAppViewInst.getInstVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InstVer_Default(pSDynaAppViewInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isMemoDirty() : !pSDynaAppViewInst.isMemoDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaAppViewInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobViewFlag(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isMobViewFlagDirty() : !pSDynaAppViewInst.isMobViewFlagDirty()) {
            return null;
        }
        Integer n = pSDynaAppViewInst.getMobViewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MobViewFlag_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PDVTParam(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isPDVTParamDirty() : !pSDynaAppViewInst.isPDVTParamDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getPDVTParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PDVTParam_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PDVTPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedViewType(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isPredefinedViewTypeDirty() : !pSDynaAppViewInst.isPredefinedViewTypeDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getPredefinedViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedViewType_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppId(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isPSDynaAppIdDirty() && !bl2 : !pSDynaAppViewInst.isPSDynaAppIdDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getPSDynaAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppId_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewId(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isPSDynaAppViewIdDirty() && !bl2 : !pSDynaAppViewInst.isPSDynaAppViewIdDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getPSDynaAppViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewId_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewInstId(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isPSDynaAppViewInstIdDirty() && !bl2 : !pSDynaAppViewInst.isPSDynaAppViewInstIdDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getPSDynaAppViewInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewInstId_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewInstName(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isPSDynaAppViewInstNameDirty() && !bl2 : !pSDynaAppViewInst.isPSDynaAppViewInstNameDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getPSDynaAppViewInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewInstName_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isPSDynaInstIdDirty() && !bl2 : !pSDynaAppViewInst.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getPSDynaInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDynaAppViewInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstName(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isPSDynaInstNameDirty() && !bl2 : !pSDynaAppViewInst.isPSDynaInstNameDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getPSDynaInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstName_Default(pSDynaAppViewInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaWFVerInstId(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isPSDynaWFVerInstIdDirty() : !pSDynaAppViewInst.isPSDynaWFVerInstIdDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getPSDynaWFVerInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerInstId_Default(pSDynaAppViewInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_SubCaption(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isSubCaptionDirty() : !pSDynaAppViewInst.isSubCaptionDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getSubCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCaption_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isTitleDirty() : !pSDynaAppViewInst.isTitleDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewActions(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isViewActionsDirty() : !pSDynaAppViewInst.isViewActionsDirty()) {
            return null;
        }
        Integer n = pSDynaAppViewInst.getViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewActions_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isViewParamDirty() : !pSDynaAppViewInst.isViewParamDirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam2(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isViewParam2Dirty() : !pSDynaAppViewInst.isViewParam2Dirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getViewParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam2_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam5(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isViewParam5Dirty() : !pSDynaAppViewInst.isViewParam5Dirty()) {
            return null;
        }
        Integer n = pSDynaAppViewInst.getViewParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam5_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam6(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isViewParam6Dirty() : !pSDynaAppViewInst.isViewParam6Dirty()) {
            return null;
        }
        Integer n = pSDynaAppViewInst.getViewParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam6_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isWFViewParamDirty() : !pSDynaAppViewInst.isWFViewParamDirty()) {
            return null;
        }
        Integer n = pSDynaAppViewInst.getWFViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFViewParam_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam2(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isWFViewParam2Dirty() : !pSDynaAppViewInst.isWFViewParam2Dirty()) {
            return null;
        }
        Integer n = pSDynaAppViewInst.getWFViewParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFViewParam2_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam3(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isWFViewParam3Dirty() : !pSDynaAppViewInst.isWFViewParam3Dirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getWFViewParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFViewParam3_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam4(boolean bl, PSDynaAppViewInst pSDynaAppViewInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppViewInst.isWFViewParam4Dirty() : !pSDynaAppViewInst.isWFViewParam4Dirty()) {
            return null;
        }
        String string = pSDynaAppViewInst.getWFViewParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFViewParam4_Default(pSDynaAppViewInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaAppViewInst pSDynaAppViewInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaAppViewInst, bl);
    }

    protected void onSyncIndexEntities(PSDynaAppViewInst pSDynaAppViewInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaAppViewInst, bl);
    }

    public Object getDataContextValue(PSDynaAppViewInst pSDynaAppViewInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaAppViewInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSDynaInst pSDynaInst = pSDynaAppViewInst.getPSDynaInst();
        if (pSDynaInst != null && pSDynaInst.contains(string)) {
            return pSDynaInst.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaAppViewInst pSDynaAppViewInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaAppViewInst, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DYNAMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAVIEWPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaViewParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAVIEWPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaViewParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAVIEWPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaViewParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAVIEWPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaViewParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAVIEWPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaViewParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobViewFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PDVTPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PDVTParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam4_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_DynaViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAVIEWPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaViewParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAVIEWPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaViewParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAVIEWPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaViewParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAVIEWPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaViewParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAVIEWPARAM5", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaViewParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAVIEWPARAM6", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_MobViewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PDVTParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PDVTPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEVIEWTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_SubCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBCAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_ViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM2", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVIEWPARAM3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFViewParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVIEWPARAM4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaAppViewInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
        super.onUpdateParent(pSDynaAppViewInst);
    }

    @Override
    protected void exportCurXmlModel(PSDynaAppViewInst pSDynaAppViewInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNAAPPVIEWINST");
        if (!bl) {
            pSDynaAppViewInst.setCreateDate(null);
            pSDynaAppViewInst.setCreateMan(null);
            pSDynaAppViewInst.setDynaViewParam(null);
            pSDynaAppViewInst.setDynaViewParam2(null);
            pSDynaAppViewInst.setDynaViewParam3(null);
            pSDynaAppViewInst.setDynaViewParam4(null);
            pSDynaAppViewInst.setDynaViewParam5(null);
            pSDynaAppViewInst.setDynaViewParam6(null);
            pSDynaAppViewInst.setPSDynaAppName(null);
            pSDynaAppViewInst.setPSDynaAppViewInstId(null);
            pSDynaAppViewInst.setPSDynaAppViewName(null);
            pSDynaAppViewInst.setPSDynaInstName(null);
            pSDynaAppViewInst.setUpdateDate(null);
            pSDynaAppViewInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaAppViewInst, xmlNode, bl);
        }
    }
}

