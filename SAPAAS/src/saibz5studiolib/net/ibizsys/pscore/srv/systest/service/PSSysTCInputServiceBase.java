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
 *  net.ibizsys.paas.db.SelectCond
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
import net.ibizsys.paas.db.SelectCond;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValueBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.dao.PSSysTCInputDAO;
import net.ibizsys.pscore.srv.systest.demodel.PSSysTCInputDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCInput;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCaseBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestDataBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTCAssertService;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTCInputServiceBase
extends PSCoreSysServiceBase<PSSysTCInput> {
    private static final Log log = LogFactory.getLog(PSSysTCInputServiceBase.class);
    public static final String DATASET_CURTESTCASE = "CurTestCase";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysTCInputDEModel pSSysTCInputDEModel;
    private PSSysTCInputDAO pSSysTCInputDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.systest.service.PSSysTCInputService";
    }

    public PSSysTCInputDEModel getPSSysTCInputDEModel() {
        if (this.pSSysTCInputDEModel == null) {
            try {
                this.pSSysTCInputDEModel = (PSSysTCInputDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTCInputDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTCInputDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTCInputDEModel();
    }

    public PSSysTCInputDAO getPSSysTCInputDAO() {
        if (this.pSSysTCInputDAO == null) {
            try {
                this.pSSysTCInputDAO = (PSSysTCInputDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.systest.dao.PSSysTCInputDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTCInputDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTCInputDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURTESTCASE, (boolean)true) == 0) {
            return this.fetchCurTestCase(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURTESTCASE, (boolean)true) == 0) {
            return this.fetchTempCurTestCase(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurTestCase(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURTESTCASE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurTestCase(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURTESTCASE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysTCInput pSSysTCInput, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTCINPUT_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSSysTCInput, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTCINPUT_PSSYSSAMPLEVALUE_DEFPSSYSSAMPLEVALUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService", (SessionFactory)this.getSessionFactory());
            PSSysSampleValue pSSysSampleValue = (PSSysSampleValue)iService.getDEModel().createEntity();
            pSSysSampleValue.set("PSSYSSAMPLEVALUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSampleValue);
            } else {
                iService.get(pSSysSampleValue);
            }
            this.onFillParentInfo_DEFPSSysSampleValue(pSSysTCInput, pSSysSampleValue);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTCINPUT_PSSYSTESTCASE_PSSYSTESTCASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService", (SessionFactory)this.getSessionFactory());
            PSSysTestCase pSSysTestCase = (PSSysTestCase)iService.getDEModel().createEntity();
            pSSysTestCase.set("PSSYSTESTCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTestCase);
            } else {
                iService.get(pSSysTestCase);
            }
            this.onFillParentInfo_PSSysTestCase(pSSysTCInput, pSSysTestCase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTCINPUT_PSSYSTESTDATA_PSSYSTESTDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestDataService", (SessionFactory)this.getSessionFactory());
            PSSysTestData pSSysTestData = (PSSysTestData)iService.getDEModel().createEntity();
            pSSysTestData.set("PSSYSTESTDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTestData);
            } else {
                iService.get(pSSysTestData);
            }
            this.onFillParentInfo_PSSysTestData(pSSysTCInput, pSSysTestData);
            return;
        }
        super.onFillParentInfo(pSSysTCInput, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEAction(PSSysTCInput pSSysTCInput, PSDEAction pSDEAction) throws Exception {
        pSSysTCInput.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSSysTCInput.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_DEFPSSysSampleValue(PSSysTCInput pSSysTCInput, PSSysSampleValue pSSysSampleValue) throws Exception {
        pSSysTCInput.setDEFPSSysSampleValueId(pSSysSampleValue.getPSSysSampleValueId());
        pSSysTCInput.setDEFPSSysSampleValueName(pSSysSampleValue.getPSSysSampleValueName());
    }

    protected void onFillParentInfo_PSSysTestCase(PSSysTCInput pSSysTCInput, PSSysTestCase pSSysTestCase) throws Exception {
        pSSysTCInput.setPSDEFId(pSSysTestCase.getPSDEFId());
        pSSysTCInput.setPSDEId(pSSysTestCase.getPSDEId());
        pSSysTCInput.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
        pSSysTCInput.setPSSysTestCaseName(pSSysTestCase.getPSSysTestCaseName());
        pSSysTCInput.setTargetType(pSSysTestCase.getTargetType());
    }

    protected void onFillParentInfo_PSSysTestData(PSSysTCInput pSSysTCInput, PSSysTestData pSSysTestData) throws Exception {
        pSSysTCInput.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
        pSSysTCInput.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
    }

    protected void onFillEntityFullInfo(PSSysTCInput pSSysTCInput, boolean bl) throws Exception {
        if (bl) {
            if (pSSysTCInput.getInputType() == null) {
                pSSysTCInput.setInputType((String)this.getDefaultValue(this.getWebContext(), "", "DATA", 25));
            }
            if (pSSysTCInput.getPSSysTCInputName() == null) {
                pSSysTCInput.setPSSysTCInputName((String)this.getDefaultValue(this.getWebContext(), "USER", "input", 25));
            }
            if (pSSysTCInput.getValidFlag() == null) {
                pSSysTCInput.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysTCInput, bl);
        this.onFillEntityFullInfo_PSDEAction(pSSysTCInput, bl);
        this.onFillEntityFullInfo_DEFPSSysSampleValue(pSSysTCInput, bl);
        this.onFillEntityFullInfo_PSSysTestCase(pSSysTCInput, bl);
        this.onFillEntityFullInfo_PSSysTestData(pSSysTCInput, bl);
    }

    protected void onFillEntityFullInfo_PSDEAction(PSSysTCInput pSSysTCInput, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DEFPSSysSampleValue(PSSysTCInput pSSysTCInput, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTestCase(PSSysTCInput pSSysTCInput, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTestData(PSSysTCInput pSSysTCInput, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysTCInput pSSysTCInput, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysTCInput, bl);
    }

    public ArrayList<PSSysTCInput> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysTCInput> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysTCInput> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTCInput> selectByDEFPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase) throws Exception {
        return this.selectByDEFPSSysSampleValue(pSSysSampleValueBase, "", -1);
    }

    public ArrayList<PSSysTCInput> selectByDEFPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase, String string) throws Exception {
        return this.selectByDEFPSSysSampleValue(pSSysSampleValueBase, string, -1);
    }

    public ArrayList<PSSysTCInput> selectByDEFPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DEFPSSYSSAMPLEVALUEID", (Object)pSSysSampleValueBase.getPSSysSampleValueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDEFPSSysSampleValueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDEFPSSysSampleValueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTCInput> selectByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase) throws Exception {
        return this.selectByPSSysTestCase(pSSysTestCaseBase, "", -1);
    }

    public ArrayList<PSSysTCInput> selectByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase, String string) throws Exception {
        return this.selectByPSSysTestCase(pSSysTestCaseBase, string, -1);
    }

    public ArrayList<PSSysTCInput> selectByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTCASEID", (Object)pSSysTestCaseBase.getPSSysTestCaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTestCaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTestCaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTCInput> selectTempByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase) throws Exception {
        return this.selectTempByPSSysTestCase(pSSysTestCaseBase, "");
    }

    public ArrayList<PSSysTCInput> selectTempByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTCASEID", (Object)pSSysTestCaseBase.getPSSysTestCaseId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysTestCaseCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysTestCaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTCInput> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, "", -1);
    }

    public ArrayList<PSSysTCInput> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, string, -1);
    }

    public ArrayList<PSSysTCInput> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTCINPUT_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSTCINPUT", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            PSSysTCInput pSSysTCInput2 = (PSSysTCInput)this.getDEModel().createEntity();
            pSSysTCInput2.setPSSysTCInputId(pSSysTCInput.getPSSysTCInputId());
            pSSysTCInput2.setPSDEActionId(null);
            this.update(pSSysTCInput2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCInputServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSSysTCInputServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSSysTCInputServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            this.remove(pSSysTCInput);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    public void testRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByDEFPSSysSampleValue(pSSysSampleValue, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSAMPLEVALUE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSampleValue);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTCINPUT_PSSYSSAMPLEVALUE_DEFPSSYSSAMPLEVALUEID", "", iDataEntityModel.getName(), "PSSYSTCINPUT", iDataEntityModel.getDataInfo(pSSysSampleValue), arrayList.get(0)));
        }
    }

    public void resetDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByDEFPSSysSampleValue(pSSysSampleValue);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            PSSysTCInput pSSysTCInput2 = (PSSysTCInput)this.getDEModel().createEntity();
            pSSysTCInput2.setPSSysTCInputId(pSSysTCInput.getPSSysTCInputId());
            pSSysTCInput2.setDEFPSSysSampleValueId(null);
            this.update(pSSysTCInput2);
        }
    }

    public void removeByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        final PSSysSampleValue pSSysSampleValue2 = pSSysSampleValue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCInputServiceBase.this.onBeforeRemoveByDEFPSSysSampleValue(pSSysSampleValue2);
                PSSysTCInputServiceBase.this.internalRemoveByDEFPSSysSampleValue(pSSysSampleValue2);
                PSSysTCInputServiceBase.this.onAfterRemoveByDEFPSSysSampleValue(pSSysSampleValue2);
            }
        });
    }

    protected void onBeforeRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
    }

    protected void internalRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByDEFPSSysSampleValue(pSSysSampleValue);
        this.onBeforeRemoveByDEFPSSysSampleValue(pSSysSampleValue, arrayList);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            this.remove(pSSysTCInput);
        }
        this.onAfterRemoveByDEFPSSysSampleValue(pSSysSampleValue, arrayList);
    }

    protected void onAfterRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
    }

    protected void onBeforeRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    public void resetPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByPSSysTestCase(pSSysTestCase);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            PSSysTCInput pSSysTCInput2 = (PSSysTCInput)this.getDEModel().createEntity();
            pSSysTCInput2.setPSSysTCInputId(pSSysTCInput.getPSSysTCInputId());
            pSSysTCInput2.setPSSysTestCaseId(null);
            this.update(pSSysTCInput2);
        }
    }

    public void resetTempPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectTempByPSSysTestCase(pSSysTestCase);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            PSSysTCInput pSSysTCInput2 = (PSSysTCInput)this.getDEModel().createEntity();
            pSSysTCInput2.setPSSysTCInputId(pSSysTCInput.getPSSysTCInputId());
            pSSysTCInput2.setPSSysTestCaseId(null);
            this.updateTemp(pSSysTCInput2);
        }
    }

    public void removeByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        final PSSysTestCase pSSysTestCase2 = pSSysTestCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCInputServiceBase.this.onBeforeRemoveByPSSysTestCase(pSSysTestCase2);
                PSSysTCInputServiceBase.this.internalRemoveByPSSysTestCase(pSSysTestCase2);
                PSSysTCInputServiceBase.this.onAfterRemoveByPSSysTestCase(pSSysTestCase2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    protected void internalRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByPSSysTestCase(pSSysTestCase);
        this.onBeforeRemoveByPSSysTestCase(pSSysTestCase, arrayList);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            this.remove(pSSysTCInput);
        }
        this.onAfterRemoveByPSSysTestCase(pSSysTestCase, arrayList);
    }

    protected void onAfterRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByPSSysTestData(pSSysTestData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTESTDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTestData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTCINPUT_PSSYSTESTDATA_PSSYSTESTDATAID", "", iDataEntityModel.getName(), "PSSYSTCINPUT", iDataEntityModel.getDataInfo(pSSysTestData), arrayList.get(0)));
        }
    }

    public void resetPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByPSSysTestData(pSSysTestData);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            PSSysTCInput pSSysTCInput2 = (PSSysTCInput)this.getDEModel().createEntity();
            pSSysTCInput2.setPSSysTCInputId(pSSysTCInput.getPSSysTCInputId());
            pSSysTCInput2.setPSSysTestDataId(null);
            this.update(pSSysTCInput2);
        }
    }

    public void removeByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        final PSSysTestData pSSysTestData2 = pSSysTestData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCInputServiceBase.this.onBeforeRemoveByPSSysTestData(pSSysTestData2);
                PSSysTCInputServiceBase.this.internalRemoveByPSSysTestData(pSSysTestData2);
                PSSysTCInputServiceBase.this.onAfterRemoveByPSSysTestData(pSSysTestData2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void internalRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectByPSSysTestData(pSSysTestData);
        this.onBeforeRemoveByPSSysTestData(pSSysTestData, arrayList);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            this.remove(pSSysTCInput);
        }
        this.onAfterRemoveByPSSysTestData(pSSysTestData, arrayList);
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTCInput pSSysTCInput) throws Exception {
        PSSysTCAssertService pSSysTCAssertService = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        pSSysTCAssertService.testRemoveByPSSysTCInput(pSSysTCInput);
        super.onBeforeRemove(pSSysTCInput);
    }

    protected void onBeforeRemoveTemp(PSSysTCInput pSSysTCInput) throws Exception {
        PSSysTCAssertService pSSysTCAssertService = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        pSSysTCAssertService.resetTempPSSysTCInput(pSSysTCInput);
        super.onBeforeRemoveTemp(pSSysTCInput);
    }

    public void removeTempByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        final PSSysTestCase pSSysTestCase2 = pSSysTestCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCInputServiceBase.this.onBeforeRemoveTempByPSSysTestCase(pSSysTestCase2);
                PSSysTCInputServiceBase.this.internalRemoveTempByPSSysTestCase(pSSysTestCase2);
                PSSysTCInputServiceBase.this.onAfterRemoveTempByPSSysTestCase(pSSysTestCase2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    protected void internalRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        ArrayList<PSSysTCInput> arrayList = this.selectTempByPSSysTestCase(pSSysTestCase);
        this.onBeforeRemoveTempByPSSysTestCase(pSSysTestCase, arrayList);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            this.removeTemp(pSSysTCInput);
        }
        this.onAfterRemoveTempByPSSysTestCase(pSSysTestCase, arrayList);
    }

    protected void onAfterRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase, ArrayList<PSSysTCInput> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSSysTCInput pSSysTCInput) throws Exception {
        super.getRelatedDataTempMajor(pSSysTCInput);
    }

    protected void updateRelatedDataTempMajor(PSSysTCInput pSSysTCInput, PSSysTCInput pSSysTCInput2) throws Exception {
        super.updateRelatedDataTempMajor(pSSysTCInput, pSSysTCInput2);
    }

    protected void replaceParentInfo(PSSysTCInput pSSysTCInput, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysTCInput, cloneSession);
        if (pSSysTCInput.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysTCInput.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSSysTCInput, (PSDEAction)iEntity);
        }
        if (pSSysTCInput.getDEFPSSysSampleValueId() != null && (iEntity = cloneSession.getEntity("PSSYSSAMPLEVALUE", (Object)pSSysTCInput.getDEFPSSysSampleValueId())) != null) {
            this.onFillParentInfo_DEFPSSysSampleValue(pSSysTCInput, (PSSysSampleValue)iEntity);
        }
        if (pSSysTCInput.getPSSysTestCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTCASE", (Object)pSSysTCInput.getPSSysTestCaseId())) != null) {
            this.onFillParentInfo_PSSysTestCase(pSSysTCInput, (PSSysTestCase)iEntity);
        }
        if (pSSysTCInput.getPSSysTestDataId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTDATA", (Object)pSSysTCInput.getPSSysTestDataId())) != null) {
            this.onFillParentInfo_PSSysTestData(pSSysTCInput, (PSSysTestData)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTCInput pSSysTCInput, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysTCInput, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionParams(bl, pSSysTCInput, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFPSSysSampleValueId(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFValue(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InputTag(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InputTag2(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InputTag3(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InputTag4(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InputType(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InputValues(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTCInputId(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTCInputName(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestCaseId(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestDataId(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestDataSN(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysTCInput, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysTCInput, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionParams(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isActionParamsDirty() : !pSSysTCInput.isActionParamsDirty()) {
            return null;
        }
        String string = pSSysTCInput.getActionParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionParams_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isCustomCodeDirty() : !pSSysTCInput.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysTCInput.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFPSSysSampleValueId(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isDEFPSSysSampleValueIdDirty() : !pSSysTCInput.isDEFPSSysSampleValueIdDirty()) {
            return null;
        }
        String string = pSSysTCInput.getDEFPSSysSampleValueId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFPSSysSampleValueId_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFPSSYSSAMPLEVALUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFValue(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isDEFValueDirty() : !pSSysTCInput.isDEFValueDirty()) {
            return null;
        }
        String string = pSSysTCInput.getDEFValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFValue_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InputTag(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isInputTagDirty() : !pSSysTCInput.isInputTagDirty()) {
            return null;
        }
        String string = pSSysTCInput.getInputTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InputTag_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPUTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InputTag2(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isInputTag2Dirty() : !pSSysTCInput.isInputTag2Dirty()) {
            return null;
        }
        String string = pSSysTCInput.getInputTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InputTag2_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPUTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InputTag3(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isInputTag3Dirty() : !pSSysTCInput.isInputTag3Dirty()) {
            return null;
        }
        String string = pSSysTCInput.getInputTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InputTag3_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPUTTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InputTag4(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isInputTag4Dirty() : !pSSysTCInput.isInputTag4Dirty()) {
            return null;
        }
        String string = pSSysTCInput.getInputTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InputTag4_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPUTTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InputType(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isInputTypeDirty() : !pSSysTCInput.isInputTypeDirty()) {
            return null;
        }
        String string = pSSysTCInput.getInputType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InputType_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPUTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InputValues(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isInputValuesDirty() : !pSSysTCInput.isInputValuesDirty()) {
            return null;
        }
        String string = pSSysTCInput.getInputValues();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InputValues_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPUTVALUES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isMemoDirty() : !pSSysTCInput.isMemoDirty()) {
            return null;
        }
        String string = pSSysTCInput.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysTCInput, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isOrderValueDirty() && !bl2 : !pSSysTCInput.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysTCInput.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysTCInput, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isPSDEActionIdDirty() : !pSSysTCInput.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysTCInput.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTCInputId(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isPSSysTCInputIdDirty() && !bl2 : !pSSysTCInput.isPSSysTCInputIdDirty()) {
            return null;
        }
        String string = pSSysTCInput.getPSSysTCInputId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTCINPUTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTCInputId_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTCINPUTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTCInputName(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isPSSysTCInputNameDirty() && !bl2 : !pSSysTCInput.isPSSysTCInputNameDirty()) {
            return null;
        }
        String string = pSSysTCInput.getPSSysTCInputName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTCINPUTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTCInputName_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTCINPUTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTESTCASEID";
                String string4 = this.checkFieldDupRule(this.getPSSysTCInputDEModel(), "PSSYSTCINPUTNAME", string3, pSSysTCInput, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSTCINPUTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestCaseId(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isPSSysTestCaseIdDirty() : !pSSysTCInput.isPSSysTestCaseIdDirty()) {
            return null;
        }
        String string = pSSysTCInput.getPSSysTestCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestCaseId_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTCASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestDataId(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isPSSysTestDataIdDirty() : !pSSysTCInput.isPSSysTestDataIdDirty()) {
            return null;
        }
        String string = pSSysTCInput.getPSSysTestDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestDataId_Default(pSSysTCInput, bl2, bl3);
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

    protected EntityFieldError onCheckField_TestDataSN(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isTestDataSNDirty() : !pSSysTCInput.isTestDataSNDirty()) {
            return null;
        }
        Integer n = pSSysTCInput.getTestDataSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TestDataSN_Default(pSSysTCInput, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTDATASN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isUserCatDirty() : !pSSysTCInput.isUserCatDirty()) {
            return null;
        }
        String string = pSSysTCInput.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysTCInput, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isUserTagDirty() : !pSSysTCInput.isUserTagDirty()) {
            return null;
        }
        String string = pSSysTCInput.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysTCInput, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isUserTag2Dirty() : !pSSysTCInput.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysTCInput.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysTCInput, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isUserTag3Dirty() : !pSSysTCInput.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysTCInput.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysTCInput, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isUserTag4Dirty() : !pSSysTCInput.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysTCInput.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysTCInput, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysTCInput pSSysTCInput, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCInput.isValidFlagDirty() : !pSSysTCInput.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysTCInput.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysTCInput, bl2, bl3);
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

    protected void onSyncEntity(PSSysTCInput pSSysTCInput, boolean bl) throws Exception {
        super.onSyncEntity(pSSysTCInput, bl);
    }

    protected void onSyncIndexEntities(PSSysTCInput pSSysTCInput, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysTCInput, bl);
    }

    public Object getDataContextValue(PSSysTCInput pSSysTCInput, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysTCInput, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysTestCase pSSysTestCase = pSSysTCInput.getPSSysTestCase();
        if (pSSysTestCase != null && pSSysTestCase.contains(string)) {
            return pSSysTestCase.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTCInput pSSysTCInput, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysTCInput, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFPSSYSSAMPLEVALUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFPSSysSampleValueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFPSSYSSAMPLEVALUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFPSSysSampleValueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPUTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InputTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPUTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InputTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPUTTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InputTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPUTTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InputTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPUTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InputType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPUTVALUES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InputValues_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTCINPUTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTCInputId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTCINPUTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTCInputName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTCASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestCaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTCASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestCaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTDATASN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestDataSN_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEFPSSysSampleValueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFPSSYSSAMPLEVALUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEFPSSysSampleValueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFPSSYSSAMPLEVALUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEFValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFVALUE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InputTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPUTTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InputTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPUTTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InputTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPUTTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InputTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPUTTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InputType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPUTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InputValues_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPUTVALUES", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysTCInputId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTCINPUTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTCInputName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTCINPUTNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSSYSTCINPUTNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestCaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTCASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestCaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTCASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_TargetType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestDataSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysTCInput pSSysTCInput) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysTCInput)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTCInput pSSysTCInput) throws Exception {
        super.onUpdateParent(pSSysTCInput);
    }

    protected void onCopyDetails(PSSysTCInput pSSysTCInput, Object object) throws Exception {
        PSSysTCInput pSSysTCInput2 = new PSSysTCInput();
        pSSysTCInput2.set("PSSYSTCINPUTID", object);
        String string = DataObject.getStringValue((Object)pSSysTCInput.get("PSSYSTCINPUTID"));
        super.onCopyDetails(pSSysTCInput, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysTCInput pSSysTCInput, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTCINPUT");
        if (!bl) {
            pSSysTCInput.setCreateDate(null);
            pSSysTCInput.setCreateMan(null);
            pSSysTCInput.setDEFPSSysSampleValueName(null);
            pSSysTCInput.setPSSysTCInputId(null);
            pSSysTCInput.setPSSysTestCaseName(null);
            pSSysTCInput.setUpdateDate(null);
            pSSysTCInput.setUpdateMan(null);
            pSSysTCInput.setPSDEFId(null);
            pSSysTCInput.setPSDEId(null);
            pSSysTCInput.setPSSysTestCaseId(null);
            pSSysTCInput.setPSSysTestCaseName(null);
            pSSysTCInput.setTargetType(null);
            super.exportCurXmlModel(pSSysTCInput, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysTCInput pSSysTCInput, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSSysTCInput, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysTCInput pSSysTCInput, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSSysTCInput, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysTCInput pSSysTCInput, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysTCInput, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTCASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTESTCASE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTCASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTCINPUT_PSSYSTESTCASE_PSSYSTESTCASEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTCASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTCASENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTESTCASE", (boolean)true) == 0) {
            iEntity.set("PSSYSTESTCASEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTESTCASEID"};
    }

    @Override
    public String getModelV2Tag(PSSysTCInput pSSysTCInput) {
        if (!StringHelper.isNullOrEmpty((String)pSSysTCInput.getPSSysTCInputName())) {
            return pSSysTCInput.getPSSysTCInputName();
        }
        return super.getModelV2Tag(pSSysTCInput);
    }

    @Override
    public boolean setModelV2Tag(PSSysTCInput pSSysTCInput, String string) {
        pSSysTCInput.setPSSysTCInputName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSTCINPUTNAME", "");
        map.put("PSSYSTESTCASEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysTCInput pSSysTCInput, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysTCInput.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysTCInput, true);
        pSSysTCInput.set("PSSYSTCINPUTNAME", string);
        if (this.select(pSSysTCInput, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysTCInput, true);
        return super.getModelV2Entity(pSSysTCInput, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysTCInput pSSysTCInput, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysTCInput, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysTCInput pSSysTCInput, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("PSSYSTCINPUTNAME", "input");
    }
}

