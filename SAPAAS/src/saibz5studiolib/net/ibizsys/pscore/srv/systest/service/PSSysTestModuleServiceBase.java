/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.systest.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.dao.PSSysTestModuleDAO;
import net.ibizsys.pscore.srv.systest.demodel.PSSysTestModuleDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestDataBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestModule;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestModuleBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrjBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTestModuleServiceBase
extends PSCoreSysServiceBase<PSSysTestModule> {
    private static final Log log = LogFactory.getLog(PSSysTestModuleServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURPRJ = "CurPrj";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSAPI = "CurSysAPI";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysTestModuleDEModel pSSysTestModuleDEModel;
    private PSSysTestModuleDAO pSSysTestModuleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService";
    }

    public PSSysTestModuleDEModel getPSSysTestModuleDEModel() {
        if (this.pSSysTestModuleDEModel == null) {
            try {
                this.pSSysTestModuleDEModel = (PSSysTestModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTestModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTestModuleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTestModuleDEModel();
    }

    public PSSysTestModuleDAO getPSSysTestModuleDAO() {
        if (this.pSSysTestModuleDAO == null) {
            try {
                this.pSSysTestModuleDAO = (PSSysTestModuleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.systest.dao.PSSysTestModuleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTestModuleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTestModuleDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPRJ, (boolean)true) == 0) {
            return this.fetchCurPrj(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPI, (boolean)true) == 0) {
            return this.fetchCurSysAPI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPrj(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPRJ, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAPI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSAPI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysTestModule pSSysTestModule, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTMODULE_PSSYSTESTDATA_PSSYSTESTDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestDataService", (SessionFactory)this.getSessionFactory());
            PSSysTestData pSSysTestData = (PSSysTestData)iService.getDEModel().createEntity();
            pSSysTestData.set("PSSYSTESTDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTestData);
            } else {
                iService.get((IEntity)pSSysTestData);
            }
            this.onFillParentInfo_PSSysTestData(pSSysTestModule, pSSysTestData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTMODULE_PSSYSTESTMODULE_PPSSYSTESTMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService", (SessionFactory)this.getSessionFactory());
            PSSysTestModule pSSysTestModule2 = (PSSysTestModule)iService.getDEModel().createEntity();
            pSSysTestModule2.set("PSSYSTESTMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTestModule2);
            } else {
                iService.get((IEntity)pSSysTestModule2);
            }
            this.onFillParentInfo_PPSSysTestModule(pSSysTestModule, pSSysTestModule2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTMODULE_PSSYSTESTPRJ_PSSYSTESTPRJID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService", (SessionFactory)this.getSessionFactory());
            PSSysTestPrj pSSysTestPrj = (PSSysTestPrj)iService.getDEModel().createEntity();
            pSSysTestPrj.set("PSSYSTESTPRJID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTestPrj);
            } else {
                iService.get((IEntity)pSSysTestPrj);
            }
            this.onFillParentInfo_PSSysTestPrj(pSSysTestModule, pSSysTestPrj);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysTestModule, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysTestData(PSSysTestModule pSSysTestModule, PSSysTestData pSSysTestData) throws Exception {
        pSSysTestModule.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
        pSSysTestModule.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
    }

    protected void onFillParentInfo_PPSSysTestModule(PSSysTestModule pSSysTestModule, PSSysTestModule pSSysTestModule2) throws Exception {
        pSSysTestModule.setPPSSysTestModuleId(pSSysTestModule2.getPSSysTestModuleId());
        pSSysTestModule.setPPSSysTestModuleName(pSSysTestModule2.getPSSysTestModuleName());
        if (pSSysTestModule2.getPSSysTestPrj() != null) {
            this.onFillParentInfo_PSSysTestPrj(pSSysTestModule, pSSysTestModule2.getPSSysTestPrj());
        }
    }

    protected void onFillParentInfo_PSSysTestPrj(PSSysTestModule pSSysTestModule, PSSysTestPrj pSSysTestPrj) throws Exception {
        pSSysTestModule.setPSSysAppId(pSSysTestPrj.getPSSysAppId());
        pSSysTestModule.setPSSysServiceAPIId(pSSysTestPrj.getPSSysServiceAPIId());
        pSSysTestModule.setPSSysTestPrjId(pSSysTestPrj.getPSSysTestPrjId());
        pSSysTestModule.setPSSysTestPrjName(pSSysTestPrj.getPSSysTestPrjName());
    }

    protected void onFillEntityFullInfo(PSSysTestModule pSSysTestModule, boolean bl) throws Exception {
        if (bl && pSSysTestModule.getOrderValue() == null) {
            pSSysTestModule.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "1000", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysTestModule, bl);
        this.onFillEntityFullInfo_PSSysTestData(pSSysTestModule, bl);
        this.onFillEntityFullInfo_PPSSysTestModule(pSSysTestModule, bl);
        this.onFillEntityFullInfo_PSSysTestPrj(pSSysTestModule, bl);
    }

    protected void onFillEntityFullInfo_PSSysTestData(PSSysTestModule pSSysTestModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSysTestModule(PSSysTestModule pSSysTestModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTestPrj(PSSysTestModule pSSysTestModule, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysTestModule pSSysTestModule, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysTestModule, bl);
    }

    public ArrayList<PSSysTestModule> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, "", -1);
    }

    public ArrayList<PSSysTestModule> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, string, -1);
    }

    public ArrayList<PSSysTestModule> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTDATAID", (Object)pSSysTestDataBase.getPSSysTestDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTestDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTestDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestModule> selectByPPSSysTestModule(PSSysTestModuleBase pSSysTestModuleBase) throws Exception {
        return this.selectByPPSSysTestModule(pSSysTestModuleBase, "", -1);
    }

    public ArrayList<PSSysTestModule> selectByPPSSysTestModule(PSSysTestModuleBase pSSysTestModuleBase, String string) throws Exception {
        return this.selectByPPSSysTestModule(pSSysTestModuleBase, string, -1);
    }

    public ArrayList<PSSysTestModule> selectByPPSSysTestModule(PSSysTestModuleBase pSSysTestModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSTESTMODULEID", (Object)pSSysTestModuleBase.getPSSysTestModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysTestModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysTestModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestModule> selectByPSSysTestPrj(PSSysTestPrjBase pSSysTestPrjBase) throws Exception {
        return this.selectByPSSysTestPrj(pSSysTestPrjBase, "", -1);
    }

    public ArrayList<PSSysTestModule> selectByPSSysTestPrj(PSSysTestPrjBase pSSysTestPrjBase, String string) throws Exception {
        return this.selectByPSSysTestPrj(pSSysTestPrjBase, string, -1);
    }

    public ArrayList<PSSysTestModule> selectByPSSysTestPrj(PSSysTestPrjBase pSSysTestPrjBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTPRJID", (Object)pSSysTestPrjBase.getPSSysTestPrjId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTestPrjCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTestPrjCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTestModule> arrayList = this.selectByPSSysTestData(pSSysTestData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTESTDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTestData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTMODULE_PSSYSTESTDATA_PSSYSTESTDATAID", "", iDataEntityModel.getName(), "PSSYSTESTMODULE", iDataEntityModel.getDataInfo((IEntity)pSSysTestData), arrayList.get(0)));
        }
    }

    public void resetPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTestModule> arrayList = this.selectByPSSysTestData(pSSysTestData);
        for (PSSysTestModule pSSysTestModule : arrayList) {
            PSSysTestModule pSSysTestModule2 = (PSSysTestModule)this.getDEModel().createEntity();
            pSSysTestModule2.setPSSysTestModuleId(pSSysTestModule.getPSSysTestModuleId());
            pSSysTestModule2.setPSSysTestDataId(null);
            this.update(pSSysTestModule2);
        }
    }

    public void removeByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        final PSSysTestData pSSysTestData2 = pSSysTestData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestModuleServiceBase.this.onBeforeRemoveByPSSysTestData(pSSysTestData2);
                PSSysTestModuleServiceBase.this.internalRemoveByPSSysTestData(pSSysTestData2);
                PSSysTestModuleServiceBase.this.onAfterRemoveByPSSysTestData(pSSysTestData2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void internalRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTestModule> arrayList = this.selectByPSSysTestData(pSSysTestData);
        this.onBeforeRemoveByPSSysTestData(pSSysTestData, arrayList);
        for (PSSysTestModule pSSysTestModule : arrayList) {
            this.remove((IEntity)pSSysTestModule);
        }
        this.onAfterRemoveByPSSysTestData(pSSysTestData, arrayList);
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTestModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTestModule> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
    }

    public void resetPPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
        ArrayList<PSSysTestModule> arrayList = this.selectByPPSSysTestModule(pSSysTestModule);
        for (PSSysTestModule pSSysTestModule2 : arrayList) {
            PSSysTestModule pSSysTestModule3 = (PSSysTestModule)this.getDEModel().createEntity();
            pSSysTestModule3.setPSSysTestModuleId(pSSysTestModule2.getPSSysTestModuleId());
            pSSysTestModule3.setPPSSysTestModuleId(null);
            this.update(pSSysTestModule3);
        }
    }

    public void removeByPPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
        final PSSysTestModule pSSysTestModule2 = pSSysTestModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestModuleServiceBase.this.onBeforeRemoveByPPSSysTestModule(pSSysTestModule2);
                PSSysTestModuleServiceBase.this.internalRemoveByPPSSysTestModule(pSSysTestModule2);
                PSSysTestModuleServiceBase.this.onAfterRemoveByPPSSysTestModule(pSSysTestModule2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
    }

    protected void internalRemoveByPPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
        ArrayList<PSSysTestModule> arrayList = this.selectByPPSSysTestModule(pSSysTestModule);
        this.onBeforeRemoveByPPSSysTestModule(pSSysTestModule, arrayList);
        for (PSSysTestModule pSSysTestModule2 : arrayList) {
            this.remove((IEntity)pSSysTestModule2);
        }
        this.onAfterRemoveByPPSSysTestModule(pSSysTestModule, arrayList);
    }

    protected void onAfterRemoveByPPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysTestModule(PSSysTestModule pSSysTestModule, ArrayList<PSSysTestModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysTestModule(PSSysTestModule pSSysTestModule, ArrayList<PSSysTestModule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
        ArrayList<PSSysTestModule> arrayList = this.selectByPSSysTestPrj(pSSysTestPrj, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTESTPRJ");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTestPrj);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTMODULE_PSSYSTESTPRJ_PSSYSTESTPRJID", "", iDataEntityModel.getName(), "PSSYSTESTMODULE", iDataEntityModel.getDataInfo((IEntity)pSSysTestPrj), arrayList.get(0)));
        }
    }

    public void resetPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
        ArrayList<PSSysTestModule> arrayList = this.selectByPSSysTestPrj(pSSysTestPrj);
        for (PSSysTestModule pSSysTestModule : arrayList) {
            PSSysTestModule pSSysTestModule2 = (PSSysTestModule)this.getDEModel().createEntity();
            pSSysTestModule2.setPSSysTestModuleId(pSSysTestModule.getPSSysTestModuleId());
            pSSysTestModule2.setPSSysTestPrjId(null);
            this.update(pSSysTestModule2);
        }
    }

    public void removeByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
        final PSSysTestPrj pSSysTestPrj2 = pSSysTestPrj;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestModuleServiceBase.this.onBeforeRemoveByPSSysTestPrj(pSSysTestPrj2);
                PSSysTestModuleServiceBase.this.internalRemoveByPSSysTestPrj(pSSysTestPrj2);
                PSSysTestModuleServiceBase.this.onAfterRemoveByPSSysTestPrj(pSSysTestPrj2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
    }

    protected void internalRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
        ArrayList<PSSysTestModule> arrayList = this.selectByPSSysTestPrj(pSSysTestPrj);
        this.onBeforeRemoveByPSSysTestPrj(pSSysTestPrj, arrayList);
        for (PSSysTestModule pSSysTestModule : arrayList) {
            this.remove((IEntity)pSSysTestModule);
        }
        this.onAfterRemoveByPSSysTestPrj(pSSysTestPrj, arrayList);
    }

    protected void onAfterRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj, ArrayList<PSSysTestModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj, ArrayList<PSSysTestModule> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTestModule pSSysTestModule) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTestModule(pSSysTestModule);
        pSCoreSysServiceBase = (PSSysTestModuleService)ServiceGlobal.getService(PSSysTestModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestModuleServiceBase)pSCoreSysServiceBase).testRemoveByPPSSysTestModule(pSSysTestModule);
        ((PSSysTestModuleServiceBase)pSCoreSysServiceBase).removeByPPSSysTestModule(pSSysTestModule);
        super.onBeforeRemove(pSSysTestModule);
    }

    protected void replaceParentInfo(PSSysTestModule pSSysTestModule, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysTestModule, cloneSession);
        if (pSSysTestModule.getPSSysTestDataId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTDATA", (Object)pSSysTestModule.getPSSysTestDataId())) != null) {
            this.onFillParentInfo_PSSysTestData(pSSysTestModule, (PSSysTestData)iEntity);
        }
        if (pSSysTestModule.getPPSSysTestModuleId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTMODULE", (Object)pSSysTestModule.getPPSSysTestModuleId())) != null) {
            this.onFillParentInfo_PPSSysTestModule(pSSysTestModule, (PSSysTestModule)iEntity);
        }
        if (pSSysTestModule.getPSSysTestPrjId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTPRJ", (Object)pSSysTestModule.getPSSysTestPrjId())) != null) {
            this.onFillParentInfo_PSSysTestPrj(pSSysTestModule, (PSSysTestPrj)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTestModule pSSysTestModule, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysTestModule, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysTestModule, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleTag(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleTag2(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleType(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysTestModuleId(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestDataId(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestModuleId(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestModuleName(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestPrjId(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParams(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilTag(bl, pSSysTestModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysTestModule, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isCodeNameDirty() : !pSSysTestModule.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysTestModule.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSSYSTESTPRJID";
                String string4 = this.checkFieldDupRule(this.getPSSysTestModuleDEModel(), "CODENAME", string3, pSSysTestModule, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isDataDirty() : !pSSysTestModule.isDataDirty()) {
            return null;
        }
        String string = pSSysTestModule.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isMemoDirty() : !pSSysTestModule.isMemoDirty()) {
            return null;
        }
        String string = pSSysTestModule.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysTestModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModuleTag(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isModuleTagDirty() : !pSSysTestModule.isModuleTagDirty()) {
            return null;
        }
        String string = pSSysTestModule.getModuleTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleTag_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleTag2(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isModuleTag2Dirty() : !pSSysTestModule.isModuleTag2Dirty()) {
            return null;
        }
        String string = pSSysTestModule.getModuleTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleTag2_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleType(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isModuleTypeDirty() && !bl2 : !pSSysTestModule.isModuleTypeDirty()) {
            return null;
        }
        String string = pSSysTestModule.getModuleType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleType_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isOrderValueDirty() : !pSSysTestModule.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysTestModule.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysTestModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysTestModuleId(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isPPSSysTestModuleIdDirty() : !pSSysTestModule.isPPSSysTestModuleIdDirty()) {
            return null;
        }
        String string = pSSysTestModule.getPPSSysTestModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysTestModuleId_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSTESTMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestDataId(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isPSSysTestDataIdDirty() : !pSSysTestModule.isPSSysTestDataIdDirty()) {
            return null;
        }
        String string = pSSysTestModule.getPSSysTestDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestDataId_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestModuleId(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isPSSysTestModuleIdDirty() && !bl2 : !pSSysTestModule.isPSSysTestModuleIdDirty()) {
            return null;
        }
        String string = pSSysTestModule.getPSSysTestModuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTMODULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestModuleId_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestModuleName(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isPSSysTestModuleNameDirty() && !bl2 : !pSSysTestModule.isPSSysTestModuleNameDirty()) {
            return null;
        }
        String string = pSSysTestModule.getPSSysTestModuleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTMODULENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestModuleName_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTMODULENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestPrjId(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isPSSysTestPrjIdDirty() && !bl2 : !pSSysTestModule.isPSSysTestPrjIdDirty()) {
            return null;
        }
        String string = pSSysTestModule.getPSSysTestPrjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTPRJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestPrjId_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTPRJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isUserCatDirty() : !pSSysTestModule.isUserCatDirty()) {
            return null;
        }
        String string = pSSysTestModule.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isUserParamsDirty() : !pSSysTestModule.isUserParamsDirty()) {
            return null;
        }
        String string = pSSysTestModule.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isUserTagDirty() : !pSSysTestModule.isUserTagDirty()) {
            return null;
        }
        String string = pSSysTestModule.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isUserTag2Dirty() : !pSSysTestModule.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysTestModule.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isUserTag3Dirty() : !pSSysTestModule.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysTestModule.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isUserTag4Dirty() : !pSSysTestModule.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysTestModule.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParams(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isUtilParamsDirty() : !pSSysTestModule.isUtilParamsDirty()) {
            return null;
        }
        String string = pSSysTestModule.getUtilParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParams_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilTag(boolean bl, PSSysTestModule pSSysTestModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestModule.isUtilTagDirty() : !pSSysTestModule.isUtilTagDirty()) {
            return null;
        }
        String string = pSSysTestModule.getUtilTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilTag_Default((IEntity)pSSysTestModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysTestModule pSSysTestModule, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysTestModule, bl);
    }

    protected void onSyncIndexEntities(PSSysTestModule pSSysTestModule, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysTestModule, bl);
    }

    public Object getDataContextValue(PSSysTestModule pSSysTestModule, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysTestModule, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysTestPrj pSSysTestPrj = pSSysTestModule.getPSSysTestPrj();
        if (pSSysTestPrj != null && pSSysTestPrj.contains(string)) {
            return pSSysTestPrj.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTestModule pSSysTestModule, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysTestModule, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSTESTMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysTestModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSTESTMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysTestModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTPRJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestPrjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTPRJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestPrjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilTag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ModuleTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModuleTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModuleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSSysTestModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSTESTMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysTestModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSTESTMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysTestDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestPrjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTPRJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestPrjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTPRJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysTestModule pSSysTestModule) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysTestModule)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTestModule pSSysTestModule) throws Exception {
        super.onUpdateParent((IEntity)pSSysTestModule);
    }

    @Override
    protected void exportCurXmlModel(PSSysTestModule pSSysTestModule, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTESTMODULE");
        if (!bl) {
            pSSysTestModule.setCreateDate(null);
            pSSysTestModule.setCreateMan(null);
            pSSysTestModule.setPSSysTestModuleId(null);
            pSSysTestModule.setUpdateDate(null);
            pSSysTestModule.setUpdateMan(null);
            super.exportCurXmlModel(pSSysTestModule, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysTestModule pSSysTestModule, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysTestModule, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTPRJID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTESTPRJ#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTPRJID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTMODULE_PSSYSTESTPRJ_PSSYSTESTPRJID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTPRJID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTPRJNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTESTPRJ", (boolean)true) == 0) {
            iEntity.set("PSSYSTESTPRJID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTESTPRJID"};
    }

    @Override
    public String getModelV2Tag(PSSysTestModule pSSysTestModule) {
        if (!StringHelper.isNullOrEmpty((String)pSSysTestModule.getCodeName())) {
            return pSSysTestModule.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysTestModule.getCodeName())) {
            return pSSysTestModule.getCodeName();
        }
        return super.getModelV2Tag(pSSysTestModule);
    }

    @Override
    public boolean setModelV2Tag(PSSysTestModule pSSysTestModule, String string) {
        pSSysTestModule.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSTESTPRJID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysTestModule pSSysTestModule, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysTestModule.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysTestModule, true);
        pSSysTestModule.set("CODENAME", string);
        if (this.select(pSSysTestModule, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysTestModule, true);
        return super.getModelV2Entity(pSSysTestModule, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysTestModule pSSysTestModule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysTestModule, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6d4b\u8bd5\u7528\u4f8b>", "DER1N_PSSYSTESTCASE_PSSYSTESTMODULE_PSSYSTESTMODULEID", "PSSYSTESTMODULEID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSSysTestModuleServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6d4b\u8bd5\u7528\u4f8b>");
            } else if (PSSysTestModuleServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssystestcases");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSTESTCASE_PSSYSTESTMODULE_PSSYSTESTMODULEID|PSSYSTESTMODULEID");
            pSMOSFile2.setFileTag3("PSSYSTESTCASE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSTESTCASE_PSSYSTESTMODULE_PSSYSTESTMODULEID", "PSSYSTESTMODULEID", pSMOSFile.getPSModelId(), "", "")) {
                PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysTestCaseService, "DER1N_PSSYSTESTCASE_PSSYSTESTMODULE_PSSYSTESTMODULEID", "PSSYSTESTMODULEID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSSysTestCaseService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysTestModuleServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSSysTestModuleServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6d4b\u8bd5\u7528\u4f8b>", (boolean)false) == 0 || PSSysTestModuleServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysTestCases", (boolean)true) == 0) {
            PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysTestCaseService, "DER1N_PSSYSTESTCASE_PSSYSTESTMODULE_PSSYSTESTMODULEID", "PSSYSTESTMODULEID", pSMOSFile.getPSModelId(), "", "");
            ArrayList arrayList2 = pSSysTestCaseService.selectEx((ISelectContext)selectContext);
            for (PSSysTestCase pSSysTestCase : arrayList2) {
                PSMOSFile pSMOSFile2 = pSSysTestCaseService.getFile(pSMOSFile, (IEntity)pSSysTestCase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSTESTCASE_PSSYSTESTMODULE_PSSYSTESTMODULEID", (boolean)false) == 0) {
            if (PSSysTestModuleServiceBase.getMOSVer() == 1) {
                return "<\u6d4b\u8bd5\u7528\u4f8b>";
            }
            if (PSSysTestModuleServiceBase.getMOSVer() == 2) {
                return "pssystestcases";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}

