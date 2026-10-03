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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepFuncItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepFuncItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAppBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDepFuncItemServiceBase
extends PSCoreSysServiceBase<PSDevSlnMSDepFuncItem> {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepFuncItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    private PSDevSlnMSDepFuncItemDEModel pSDevSlnMSDepFuncItemDEModel;
    private PSDevSlnMSDepFuncItemDAO pSDevSlnMSDepFuncItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemService";
    }

    public PSDevSlnMSDepFuncItemDEModel getPSDevSlnMSDepFuncItemDEModel() {
        if (this.pSDevSlnMSDepFuncItemDEModel == null) {
            try {
                this.pSDevSlnMSDepFuncItemDEModel = (PSDevSlnMSDepFuncItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepFuncItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepFuncItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnMSDepFuncItemDEModel();
    }

    public PSDevSlnMSDepFuncItemDAO getPSDevSlnMSDepFuncItemDAO() {
        if (this.pSDevSlnMSDepFuncItemDAO == null) {
            try {
                this.pSDevSlnMSDepFuncItemDAO = (PSDevSlnMSDepFuncItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepFuncItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepFuncItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnMSDepFuncItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchTempFormType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNCITEM_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc = (PSDevSlnMSDepFunc)iService.getDEModel().createEntity();
            pSDevSlnMSDepFunc.set("PSDEVSLNMSDEPFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnMSDepFunc);
            } else {
                iService.get(pSDevSlnMSDepFunc);
            }
            this.onFillParentInfo_PSDevSlnMSDepFunc(pSDevSlnMSDepFuncItem, pSDevSlnMSDepFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNCITEM_PSDEVSLNSYSAPI_PSDEVSLNSYSAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysAPI pSDevSlnSysAPI = (PSDevSlnSysAPI)iService.getDEModel().createEntity();
            pSDevSlnSysAPI.set("PSDEVSLNSYSAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysAPI);
            } else {
                iService.get(pSDevSlnSysAPI);
            }
            this.onFillParentInfo_PSDevSlnSysAPI(pSDevSlnMSDepFuncItem, pSDevSlnSysAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNCITEM_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysApp pSDevSlnSysApp = (PSDevSlnSysApp)iService.getDEModel().createEntity();
            pSDevSlnSysApp.set("PSDEVSLNSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysApp);
            } else {
                iService.get(pSDevSlnSysApp);
            }
            this.onFillParentInfo_PSDevSlnSysApp(pSDevSlnMSDepFuncItem, pSDevSlnSysApp);
            return;
        }
        super.onFillParentInfo(pSDevSlnMSDepFuncItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnMSDepFunc(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        pSDevSlnMSDepFuncItem.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
        pSDevSlnMSDepFuncItem.setPSDevSlnMSDepFuncName(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncName());
    }

    protected void onFillParentInfo_PSDevSlnSysAPI(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        pSDevSlnMSDepFuncItem.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
        pSDevSlnMSDepFuncItem.setPSDevSlnSysAPIName(pSDevSlnSysAPI.getPSDevSlnSysAPIName());
        pSDevSlnMSDepFuncItem.setPSSysServiceAPIId(pSDevSlnSysAPI.getPSSysServiceAPIId());
    }

    protected void onFillParentInfo_PSDevSlnSysApp(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        pSDevSlnMSDepFuncItem.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
        pSDevSlnMSDepFuncItem.setPSDevSlnSysAppName(pSDevSlnSysApp.getPSDevSlnSysAppName());
        pSDevSlnMSDepFuncItem.setPSSysAppId(pSDevSlnSysApp.getPSSysAppId());
    }

    protected void onFillEntityFullInfo(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl) throws Exception {
        if (bl && pSDevSlnMSDepFuncItem.getValidFlag() == null) {
            pSDevSlnMSDepFuncItem.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDevSlnMSDepFuncItem, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDepFunc(pSDevSlnMSDepFuncItem, bl);
        this.onFillEntityFullInfo_PSDevSlnSysAPI(pSDevSlnMSDepFuncItem, bl);
        this.onFillEntityFullInfo_PSDevSlnSysApp(pSDevSlnMSDepFuncItem, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDepFunc(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysAPI(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysApp(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnMSDepFuncItem, bl);
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase) throws Exception {
        return this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFuncBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFuncBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPFUNCID", (Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnMSDepFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnMSDepFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectTempByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase) throws Exception {
        return this.selectTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFuncBase, "");
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectTempByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPFUNCID", (Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDevSlnMSDepFuncCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDevSlnMSDepFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSAPIID", (Object)pSDevSlnSysAPIBase.getPSDevSlnSysAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFuncItem> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSAPPID", (Object)pSDevSlnSysAppBase.getPSDevSlnSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    public void resetPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem2 = (PSDevSlnMSDepFuncItem)this.getDEModel().createEntity();
            pSDevSlnMSDepFuncItem2.setPSDevSlnMSDepFuncItemId(pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncItemId());
            pSDevSlnMSDepFuncItem2.setPSDevSlnMSDepFuncId(null);
            this.update(pSDevSlnMSDepFuncItem2);
        }
    }

    public void resetTempPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem2 = (PSDevSlnMSDepFuncItem)this.getDEModel().createEntity();
            pSDevSlnMSDepFuncItem2.setPSDevSlnMSDepFuncItemId(pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncItemId());
            pSDevSlnMSDepFuncItem2.setPSDevSlnMSDepFuncId(null);
            this.updateTemp(pSDevSlnMSDepFuncItem2);
        }
    }

    public void removeByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        final PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = pSDevSlnMSDepFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncItemServiceBase.this.onBeforeRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
                PSDevSlnMSDepFuncItemServiceBase.this.internalRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
                PSDevSlnMSDepFuncItemServiceBase.this.onAfterRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        this.onBeforeRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc, arrayList);
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            this.remove(pSDevSlnMSDepFuncItem);
        }
        this.onAfterRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, ArrayList<PSDevSlnMSDepFuncItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, ArrayList<PSDevSlnMSDepFuncItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSysAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPFUNCITEM_PSDEVSLNSYSAPI_PSDEVSLNSYSAPIID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPFUNCITEM", iDataEntityModel.getDataInfo(pSDevSlnSysAPI), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem2 = (PSDevSlnMSDepFuncItem)this.getDEModel().createEntity();
            pSDevSlnMSDepFuncItem2.setPSDevSlnMSDepFuncItemId(pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncItemId());
            pSDevSlnMSDepFuncItem2.setPSDevSlnSysAPIId(null);
            this.update(pSDevSlnMSDepFuncItem2);
        }
    }

    public void removeByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        final PSDevSlnSysAPI pSDevSlnSysAPI2 = pSDevSlnSysAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncItemServiceBase.this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDevSlnMSDepFuncItemServiceBase.this.internalRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDevSlnMSDepFuncItemServiceBase.this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            this.remove(pSDevSlnMSDepFuncItem);
        }
        this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDevSlnMSDepFuncItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDevSlnMSDepFuncItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPFUNCITEM_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPFUNCITEM", iDataEntityModel.getDataInfo(pSDevSlnSysApp), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem2 = (PSDevSlnMSDepFuncItem)this.getDEModel().createEntity();
            pSDevSlnMSDepFuncItem2.setPSDevSlnMSDepFuncItemId(pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncItemId());
            pSDevSlnMSDepFuncItem2.setPSDevSlnSysAppId(null);
            this.update(pSDevSlnMSDepFuncItem2);
        }
    }

    public void removeByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        final PSDevSlnSysApp pSDevSlnSysApp2 = pSDevSlnSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncItemServiceBase.this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDevSlnMSDepFuncItemServiceBase.this.internalRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDevSlnMSDepFuncItemServiceBase.this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            this.remove(pSDevSlnMSDepFuncItem);
        }
        this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDevSlnMSDepFuncItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDevSlnMSDepFuncItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem) throws Exception {
        super.onBeforeRemove(pSDevSlnMSDepFuncItem);
    }

    public void removeTempByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        final PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = pSDevSlnMSDepFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncItemServiceBase.this.onBeforeRemoveTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
                PSDevSlnMSDepFuncItemServiceBase.this.internalRemoveTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
                PSDevSlnMSDepFuncItemServiceBase.this.onAfterRemoveTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    protected void internalRemoveTempByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.selectTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        this.onBeforeRemoveTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc, arrayList);
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            this.removeTemp(pSDevSlnMSDepFuncItem);
        }
        this.onAfterRemoveTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc, arrayList);
    }

    protected void onAfterRemoveTempByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, ArrayList<PSDevSlnMSDepFuncItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, ArrayList<PSDevSlnMSDepFuncItem> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnMSDepFuncItem, cloneSession);
        if (pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPFUNC", (Object)pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDepFunc(pSDevSlnMSDepFuncItem, (PSDevSlnMSDepFunc)iEntity);
        }
        if (pSDevSlnMSDepFuncItem.getPSDevSlnSysAPIId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPI", (Object)pSDevSlnMSDepFuncItem.getPSDevSlnSysAPIId())) != null) {
            this.onFillParentInfo_PSDevSlnSysAPI(pSDevSlnMSDepFuncItem, (PSDevSlnSysAPI)iEntity);
        }
        if (pSDevSlnMSDepFuncItem.getPSDevSlnSysAppId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPP", (Object)pSDevSlnMSDepFuncItem.getPSDevSlnSysAppId())) != null) {
            this.onFillParentInfo_PSDevSlnSysApp(pSDevSlnMSDepFuncItem, (PSDevSlnSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnMSDepFuncItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AuthCheckTokenUri(bl, pSDevSlnMSDepFuncItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientId(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientSecret(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthMode(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemType(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepFuncId(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepFuncItemId(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepFuncItemName(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAPIId(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAppId(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnMSDepFuncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnMSDepFuncItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AuthCheckTokenUri(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isAuthCheckTokenUriDirty() : !pSDevSlnMSDepFuncItem.isAuthCheckTokenUriDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getAuthCheckTokenUri();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthCheckTokenUri_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCHECKTOKENURI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthClientId(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isAuthClientIdDirty() : !pSDevSlnMSDepFuncItem.isAuthClientIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getAuthClientId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientId_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCLIENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthClientSecret(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isAuthClientSecretDirty() : !pSDevSlnMSDepFuncItem.isAuthClientSecretDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getAuthClientSecret();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientSecret_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCLIENTSECRET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthMode(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isAuthModeDirty() : !pSDevSlnMSDepFuncItem.isAuthModeDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getAuthMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthMode_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemType(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isItemTypeDirty() && !bl2 : !pSDevSlnMSDepFuncItem.isItemTypeDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemType_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isMemoDirty() : !pSDevSlnMSDepFuncItem.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDepFuncId(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isPSDevSlnMSDepFuncIdDirty() && !bl2 : !pSDevSlnMSDepFuncItem.isPSDevSlnMSDepFuncIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepFuncId_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepFuncItemId(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isPSDevSlnMSDepFuncItemIdDirty() && !bl2 : !pSDevSlnMSDepFuncItem.isPSDevSlnMSDepFuncItemIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepFuncItemId_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepFuncItemName(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isPSDevSlnMSDepFuncItemNameDirty() && !bl2 : !pSDevSlnMSDepFuncItem.isPSDevSlnMSDepFuncItemNameDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepFuncItemName_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAPIId(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isPSDevSlnSysAPIIdDirty() : !pSDevSlnMSDepFuncItem.isPSDevSlnSysAPIIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getPSDevSlnSysAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAPIId_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVSLNMSDEPFUNCID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnMSDepFuncItemDEModel(), "PSDEVSLNSYSAPIID", string3, pSDevSlnMSDepFuncItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNSYSAPIID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAppId(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isPSDevSlnSysAppIdDirty() : !pSDevSlnMSDepFuncItem.isPSDevSlnSysAppIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFuncItem.getPSDevSlnSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAppId_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVSLNMSDEPFUNCID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnMSDepFuncItemDEModel(), "PSDEVSLNSYSAPPID", string3, pSDevSlnMSDepFuncItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNSYSAPPID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFuncItem.isValidFlagDirty() && !bl2 : !pSDevSlnMSDepFuncItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepFuncItem.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnMSDepFuncItem, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnMSDepFuncItem, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnMSDepFuncItem, bl);
    }

    public Object getDataContextValue(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnMSDepFuncItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnMSDepFunc pSDevSlnMSDepFunc = pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFunc();
        if (pSDevSlnMSDepFunc != null && pSDevSlnMSDepFunc.contains(string)) {
            return pSDevSlnMSDepFunc.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnMSDepFuncItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AUTHCHECKTOKENURI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthCheckTokenUri_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTSECRET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientSecret_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPFUNCITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepFuncItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPFUNCITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepFuncItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AuthCheckTokenUri_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCHECKTOKENURI", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthClientId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCLIENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthClientSecret_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCLIENTSECRET", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_ItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_PSDevSlnMSDepFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepFuncItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPFUNCITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepFuncItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPFUNCITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnMSDepFuncItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem) throws Exception {
        super.onUpdateParent(pSDevSlnMSDepFuncItem);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNMSDEPFUNCITEM");
        if (!bl) {
            pSDevSlnMSDepFuncItem.setCreateDate(null);
            pSDevSlnMSDepFuncItem.setCreateMan(null);
            pSDevSlnMSDepFuncItem.setPSDevSlnMSDepFuncItemId(null);
            pSDevSlnMSDepFuncItem.setUpdateDate(null);
            pSDevSlnMSDepFuncItem.setUpdateMan(null);
            pSDevSlnMSDepFuncItem.setPSDevSlnMSDepFuncId(null);
            pSDevSlnMSDepFuncItem.setPSDevSlnMSDepFuncName(null);
            super.exportCurXmlModel(pSDevSlnMSDepFuncItem, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem) throws Exception {
        return pSDevSlnMSDepFuncItem.getItemType();
    }
}

