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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCCodeSnippetDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCCodeSnippetDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetRefService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCCodeSnippetServiceBase
extends PSCoreSysServiceBase<PSDCCodeSnippet> {
    private static final Log log = LogFactory.getLog(PSDCCodeSnippetServiceBase.class);
    public static final String DATASET_ALL = "All";
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURDCAPP = "CurDCApp";
    public static final String DATASET_CURDCCL = "CurDCCL";
    public static final String DATASET_CURDCDB = "CurDCDB";
    public static final String DATASET_CURDCDE = "CurDCDE";
    public static final String DATASET_CURDCDEACTION = "CurDCDEAction";
    public static final String DATASET_CURDCNONE = "CurDCNone";
    public static final String DATASET_CURDCSYS = "CurDCSys";
    public static final String DATASET_CURDCVIEW = "CurDCView";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_GETMODELCODE = "GetModelCode";
    public static final String ACTION_PUBLISH = "PUBLISH";
    private PSDCCodeSnippetDEModel pSDCCodeSnippetDEModel;
    private PSDCCodeSnippetDAO pSDCCodeSnippetDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService";
    }

    public PSDCCodeSnippetDEModel getPSDCCodeSnippetDEModel() {
        if (this.pSDCCodeSnippetDEModel == null) {
            try {
                this.pSDCCodeSnippetDEModel = (PSDCCodeSnippetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCCodeSnippetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCCodeSnippetDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCCodeSnippetDEModel();
    }

    public PSDCCodeSnippetDAO getPSDCCodeSnippetDAO() {
        if (this.pSDCCodeSnippetDAO == null) {
            try {
                this.pSDCCodeSnippetDAO = (PSDCCodeSnippetDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCCodeSnippetDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCCodeSnippetDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCCodeSnippetDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_ALL, (boolean)true) == 0) {
            return this.fetchAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCAPP, (boolean)true) == 0) {
            return this.fetchCurDCApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCCL, (boolean)true) == 0) {
            return this.fetchCurDCCL(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCDB, (boolean)true) == 0) {
            return this.fetchCurDCDB(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCDE, (boolean)true) == 0) {
            return this.fetchCurDCDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCDEACTION, (boolean)true) == 0) {
            return this.fetchCurDCDEAction(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCNONE, (boolean)true) == 0) {
            return this.fetchCurDCNone(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCSYS, (boolean)true) == 0) {
            return this.fetchCurDCSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCVIEW, (boolean)true) == 0) {
            return this.fetchCurDCView(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_GETMODELCODE, (boolean)true) == 0) {
            this.getModelCode((PSDCCodeSnippet)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PUBLISH, (boolean)true) == 0) {
            this.publish((PSDCCodeSnippet)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_ALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCCL(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCCL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCDB(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCDB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCDEAction(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCDEACTION, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCNone(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCNONE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCVIEW, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void getModelCode(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETMODELCODE, 0, pSDCCodeSnippet, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCCodeSnippet, ACTION_GETMODELCODE);
        final PSDCCodeSnippet pSDCCodeSnippet2 = pSDCCodeSnippet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCCodeSnippetServiceBase.this.getService(), PSDCCodeSnippetServiceBase.ACTION_GETMODELCODE, 40, pSDCCodeSnippet2, null).getResult() != 1) {
                    PSDCCodeSnippetServiceBase.this.onGetModelCode(pSDCCodeSnippet2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETMODELCODE, 99, pSDCCodeSnippet, null);
        }
    }

    protected void onGetModelCode(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetModelCode]");
    }

    public void publish(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PUBLISH, 0, pSDCCodeSnippet, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCCodeSnippet, ACTION_PUBLISH);
        final PSDCCodeSnippet pSDCCodeSnippet2 = pSDCCodeSnippet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCCodeSnippetServiceBase.this.getService(), PSDCCodeSnippetServiceBase.ACTION_PUBLISH, 40, pSDCCodeSnippet2, null).getResult() != 1) {
                    PSDCCodeSnippetServiceBase.this.onPublish(pSDCCodeSnippet2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PUBLISH, 99, pSDCCodeSnippet, null);
        }
    }

    protected void onPublish(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PUBLISH]");
    }

    protected void onFillParentInfo(PSDCCodeSnippet pSDCCodeSnippet, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCODESNIPPET_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCCodeSnippet, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCODESNIPPET_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCCodeSnippet, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDCCodeSnippet, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCCodeSnippet pSDCCodeSnippet, PSDevCenter pSDevCenter) throws Exception {
        pSDCCodeSnippet.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCCodeSnippet.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCCodeSnippet pSDCCodeSnippet, PSDevSln pSDevSln) throws Exception {
        pSDCCodeSnippet.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCCodeSnippet.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDCCodeSnippet pSDCCodeSnippet, boolean bl) throws Exception {
        if (bl && pSDCCodeSnippet.getAllDCFlag() == null) {
            pSDCCodeSnippet.setAllDCFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSDCCodeSnippet, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCCodeSnippet, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCCodeSnippet, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCCodeSnippet pSDCCodeSnippet, boolean bl) throws Exception {
        if (pSDCCodeSnippet.isPSDevCenterIdDirty()) {
            if (pSDCCodeSnippet.getPSDevCenterId() != null) {
                if (pSDCCodeSnippet.getPSDevCenterId() == null || pSDCCodeSnippet.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCCodeSnippet.getPSDevCenter();
                    pSDCCodeSnippet.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCCodeSnippet.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCCodeSnippet pSDCCodeSnippet, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDCCodeSnippet pSDCCodeSnippet, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCCodeSnippet, bl);
    }

    public ArrayList<PSDCCodeSnippet> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCCodeSnippet> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCCodeSnippet> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCCodeSnippet> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCCodeSnippet> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCCodeSnippet> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCCodeSnippet> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCCODESNIPPET_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCCODESNIPPET", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCCodeSnippet> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCCodeSnippet pSDCCodeSnippet : arrayList) {
            PSDCCodeSnippet pSDCCodeSnippet2 = (PSDCCodeSnippet)this.getDEModel().createEntity();
            pSDCCodeSnippet2.setPSDCCodeSnippetId(pSDCCodeSnippet.getPSDCCodeSnippetId());
            pSDCCodeSnippet2.setPSDevCenterId(null);
            this.update(pSDCCodeSnippet2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCCodeSnippetServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCCodeSnippetServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCCodeSnippetServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCCodeSnippet> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCCodeSnippet pSDCCodeSnippet : arrayList) {
            this.remove(pSDCCodeSnippet);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCCodeSnippet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCCodeSnippet> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCCodeSnippet> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCCODESNIPPET_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDCCODESNIPPET", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCCodeSnippet> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCCodeSnippet pSDCCodeSnippet : arrayList) {
            PSDCCodeSnippet pSDCCodeSnippet2 = (PSDCCodeSnippet)this.getDEModel().createEntity();
            pSDCCodeSnippet2.setPSDCCodeSnippetId(pSDCCodeSnippet.getPSDCCodeSnippetId());
            pSDCCodeSnippet2.setPSDevSlnId(null);
            this.update(pSDCCodeSnippet2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCCodeSnippetServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCCodeSnippetServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCCodeSnippetServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCCodeSnippet> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCCodeSnippet pSDCCodeSnippet : arrayList) {
            this.remove(pSDCCodeSnippet);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCCodeSnippet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCCodeSnippet> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCCodeSnippetRefService)ServiceGlobal.getService(PSDCCodeSnippetRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCCodeSnippetRefServiceBase)pSCoreSysServiceBase).testRemoveByPSDCCodeSnippet(pSDCCodeSnippet);
        ((PSDCCodeSnippetRefServiceBase)pSCoreSysServiceBase).removeByPSDCCodeSnippet(pSDCCodeSnippet);
        pSCoreSysServiceBase = (PSDCCodeSnippetRefService)ServiceGlobal.getService(PSDCCodeSnippetRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCCodeSnippetRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDCCodeSnippet(pSDCCodeSnippet);
        pSCoreSysServiceBase = (PSDevSlnPipelineStageService)ServiceGlobal.getService(PSDevSlnPipelineStageService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStageServiceBase)pSCoreSysServiceBase).testRemoveByPSDCCodeSnippet(pSDCCodeSnippet);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDCCodeSnippet(pSDCCodeSnippet);
        pSCoreSysServiceBase = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineServiceBase)pSCoreSysServiceBase).testRemoveByPSDCCodeSnippet(pSDCCodeSnippet);
        super.onBeforeRemove(pSDCCodeSnippet);
    }

    protected void replaceParentInfo(PSDCCodeSnippet pSDCCodeSnippet, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCCodeSnippet, cloneSession);
        if (pSDCCodeSnippet.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCCodeSnippet.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCCodeSnippet, (PSDevCenter)iEntity);
        }
        if (pSDCCodeSnippet.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCCodeSnippet.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCCodeSnippet, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCCodeSnippet pSDCCodeSnippet, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCCodeSnippet, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllDCFlag(bl, pSDCCodeSnippet, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeCat(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeTarget(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Keywords(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetId(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetName(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMode(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSDCCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCCodeSnippet, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllDCFlag(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isAllDCFlagDirty() && !bl2 : !pSDCCodeSnippet.isAllDCFlagDirty()) {
            return null;
        }
        Integer n = pSDCCodeSnippet.getAllDCFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLDCFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllDCFlag_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLDCFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeCat(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isCodeCatDirty() && !bl2 : !pSDCCodeSnippet.isCodeCatDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getCodeCat();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODECAT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeCat_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODECAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeTarget(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isCodeTargetDirty() && !bl2 : !pSDCCodeSnippet.isCodeTargetDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getCodeTarget();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETARGET");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeTarget_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETARGET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Keywords(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isKeywordsDirty() : !pSDCCodeSnippet.isKeywordsDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getKeywords();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Keywords_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYWORDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isMemoDirty() : !pSDCCodeSnippet.isMemoDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCCodeSnippetId(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isPSDCCodeSnippetIdDirty() && !bl2 : !pSDCCodeSnippet.isPSDCCodeSnippetIdDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getPSDCCodeSnippetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetId_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCCodeSnippetName(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isPSDCCodeSnippetNameDirty() && !bl2 : !pSDCCodeSnippet.isPSDCCodeSnippetNameDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getPSDCCodeSnippetName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetName_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isPSDevCenterIdDirty() && !bl2 : !pSDCCodeSnippet.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isPSDevCenterNameDirty() && !bl2 : !pSDCCodeSnippet.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isPSDevSlnIdDirty() : !pSDCCodeSnippet.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMode(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isRefModeDirty() : !pSDCCodeSnippet.isRefModeDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getRefMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMode_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isTemplCodeDirty() : !pSDCCodeSnippet.isTemplCodeDirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSDCCodeSnippet pSDCCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippet.isTemplCode2Dirty() : !pSDCCodeSnippet.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSDCCodeSnippet.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default(pSDCCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCCodeSnippet pSDCCodeSnippet, boolean bl) throws Exception {
        super.onSyncEntity(pSDCCodeSnippet, bl);
    }

    protected void onSyncIndexEntities(PSDCCodeSnippet pSDCCodeSnippet, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCCodeSnippet, bl);
    }

    public Object getDataContextValue(PSDCCodeSnippet pSDCCodeSnippet, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCCodeSnippet, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevCenter pSDevCenter = pSDCCodeSnippet.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCCodeSnippet, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLDCFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllDCFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODECAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODETARGET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeTarget_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYWORDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Keywords_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllDCFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODECAT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeTarget_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODETARGET", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_Keywords_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYWORDS", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_PSDCCodeSnippetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCodeSnippetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE2", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCCodeSnippet)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        super.onUpdateParent(pSDCCodeSnippet);
    }

    @Override
    protected void exportCurXmlModel(PSDCCodeSnippet pSDCCodeSnippet, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCCODESNIPPET");
        if (!bl) {
            pSDCCodeSnippet.setCreateDate(null);
            pSDCCodeSnippet.setCreateMan(null);
            pSDCCodeSnippet.setPSDCCodeSnippetId(null);
            pSDCCodeSnippet.setUpdateDate(null);
            pSDCCodeSnippet.setUpdateMan(null);
            super.exportCurXmlModel(pSDCCodeSnippet, xmlNode, bl);
        }
    }
}

