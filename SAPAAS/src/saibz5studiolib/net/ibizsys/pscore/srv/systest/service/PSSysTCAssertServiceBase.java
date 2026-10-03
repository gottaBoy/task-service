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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.dao.PSSysTCAssertDAO;
import net.ibizsys.pscore.srv.systest.demodel.PSSysTCAssertDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCAssert;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCInput;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCInputBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCaseBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestDataBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTCAssertServiceBase
extends PSCoreSysServiceBase<PSSysTCAssert> {
    private static final Log log = LogFactory.getLog(PSSysTCAssertServiceBase.class);
    public static final String DATASET_CURTESTCASE = "CurTestCase";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysTCAssertDEModel pSSysTCAssertDEModel;
    private PSSysTCAssertDAO pSSysTCAssertDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.systest.service.PSSysTCAssertService";
    }

    public PSSysTCAssertDEModel getPSSysTCAssertDEModel() {
        if (this.pSSysTCAssertDEModel == null) {
            try {
                this.pSSysTCAssertDEModel = (PSSysTCAssertDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTCAssertDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTCAssertDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTCAssertDEModel();
    }

    public PSSysTCAssertDAO getPSSysTCAssertDAO() {
        if (this.pSSysTCAssertDAO == null) {
            try {
                this.pSSysTCAssertDAO = (PSSysTCAssertDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.systest.dao.PSSysTCAssertDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTCAssertDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTCAssertDAO();
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

    protected void onFillParentInfo(PSSysTCAssert pSSysTCAssert, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTCASSERT_PSDATAENTITY_DSTPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_DstPSDE(pSSysTCAssert, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTCASSERT_PSDEFIELD_DSTKEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_DstKeyPSDEF(pSSysTCAssert, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTCASSERT_PSSYSTCINPUT_PSSYSTCINPUTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTCInputService", (SessionFactory)this.getSessionFactory());
            PSSysTCInput pSSysTCInput = (PSSysTCInput)iService.getDEModel().createEntity();
            pSSysTCInput.set("PSSYSTCINPUTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTCInput);
            } else {
                iService.get(pSSysTCInput);
            }
            this.onFillParentInfo_PSSysTCInput(pSSysTCAssert, pSSysTCInput);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTCASSERT_PSSYSTESTCASE_PSSYSTESTCASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService", (SessionFactory)this.getSessionFactory());
            PSSysTestCase pSSysTestCase = (PSSysTestCase)iService.getDEModel().createEntity();
            pSSysTestCase.set("PSSYSTESTCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTestCase);
            } else {
                iService.get(pSSysTestCase);
            }
            this.onFillParentInfo_PSSysTestCase(pSSysTCAssert, pSSysTestCase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTCASSERT_PSSYSTESTDATA_PSSYSTESTDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestDataService", (SessionFactory)this.getSessionFactory());
            PSSysTestData pSSysTestData = (PSSysTestData)iService.getDEModel().createEntity();
            pSSysTestData.set("PSSYSTESTDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTestData);
            } else {
                iService.get(pSSysTestData);
            }
            this.onFillParentInfo_PSSysTestData(pSSysTCAssert, pSSysTestData);
            return;
        }
        super.onFillParentInfo(pSSysTCAssert, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDE(PSSysTCAssert pSSysTCAssert, PSDataEntity pSDataEntity) throws Exception {
        pSSysTCAssert.setDstPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysTCAssert.setDstPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_DstKeyPSDEF(PSSysTCAssert pSSysTCAssert, PSDEField pSDEField) throws Exception {
        pSSysTCAssert.setDstKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSSysTCAssert.setDstKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysTCInput(PSSysTCAssert pSSysTCAssert, PSSysTCInput pSSysTCInput) throws Exception {
        pSSysTCAssert.setPSSysTCInputId(pSSysTCInput.getPSSysTCInputId());
        pSSysTCAssert.setPSSysTCInputName(pSSysTCInput.getPSSysTCInputName());
    }

    protected void onFillParentInfo_PSSysTestCase(PSSysTCAssert pSSysTCAssert, PSSysTestCase pSSysTestCase) throws Exception {
        pSSysTCAssert.setPSDEId(pSSysTestCase.getPSDEId());
        pSSysTCAssert.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
        pSSysTCAssert.setPSSysTestCaseName(pSSysTestCase.getPSSysTestCaseName());
        pSSysTCAssert.setTargetType(pSSysTestCase.getTargetType());
    }

    protected void onFillParentInfo_PSSysTestData(PSSysTCAssert pSSysTCAssert, PSSysTestData pSSysTestData) throws Exception {
        pSSysTCAssert.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
        pSSysTCAssert.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
    }

    protected void onFillEntityFullInfo(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
        if (bl) {
            if (pSSysTCAssert.getPSSysTCAssertName() == null) {
                pSSysTCAssert.setPSSysTCAssertName((String)this.getDefaultValue(this.getWebContext(), "USER", "assert", 25));
            }
            if (pSSysTCAssert.getValidFlag() == null) {
                pSSysTCAssert.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysTCAssert, bl);
        this.onFillEntityFullInfo_DstPSDE(pSSysTCAssert, bl);
        this.onFillEntityFullInfo_DstKeyPSDEF(pSSysTCAssert, bl);
        this.onFillEntityFullInfo_PSSysTCInput(pSSysTCAssert, bl);
        this.onFillEntityFullInfo_PSSysTestCase(pSSysTCAssert, bl);
        this.onFillEntityFullInfo_PSSysTestData(pSSysTCAssert, bl);
    }

    protected void onFillEntityFullInfo_DstPSDE(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
        if (pSSysTCAssert.isDstPSDEIdDirty()) {
            if (pSSysTCAssert.getDstPSDEId() != null) {
                if (pSSysTCAssert.getDstPSDEId() == null || pSSysTCAssert.getDstPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysTCAssert.getDstPSDE();
                    pSSysTCAssert.setDstPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysTCAssert.setDstPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstKeyPSDEF(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
        if (pSSysTCAssert.isDstKeyPSDEFIdDirty()) {
            if (pSSysTCAssert.getDstKeyPSDEFId() != null) {
                if (pSSysTCAssert.getDstKeyPSDEFId() == null || pSSysTCAssert.getDstKeyPSDEFName() == null) {
                    PSDEField pSDEField = pSSysTCAssert.getDstKeyPSDEF();
                    pSSysTCAssert.setDstKeyPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysTCAssert.setDstKeyPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysTCInput(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTestCase(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTestData(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysTCAssert, bl);
    }

    public ArrayList<PSSysTCAssert> selectByDstPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByDstPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysTCAssert> selectByDstPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByDstPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysTCAssert> selectByDstPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTCAssert> selectByDstKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDstKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysTCAssert> selectByDstKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDstKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysTCAssert> selectByDstKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTKEYPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstKeyPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstKeyPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTCAssert> selectByPSSysTCInput(PSSysTCInputBase pSSysTCInputBase) throws Exception {
        return this.selectByPSSysTCInput(pSSysTCInputBase, "", -1);
    }

    public ArrayList<PSSysTCAssert> selectByPSSysTCInput(PSSysTCInputBase pSSysTCInputBase, String string) throws Exception {
        return this.selectByPSSysTCInput(pSSysTCInputBase, string, -1);
    }

    public ArrayList<PSSysTCAssert> selectByPSSysTCInput(PSSysTCInputBase pSSysTCInputBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTCINPUTID", (Object)pSSysTCInputBase.getPSSysTCInputId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTCInputCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTCInputCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTCAssert> selectTempByPSSysTCInput(PSSysTCInputBase pSSysTCInputBase) throws Exception {
        return this.selectTempByPSSysTCInput(pSSysTCInputBase, "");
    }

    public ArrayList<PSSysTCAssert> selectTempByPSSysTCInput(PSSysTCInputBase pSSysTCInputBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTCINPUTID", (Object)pSSysTCInputBase.getPSSysTCInputId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysTCInputCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysTCInputCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTCAssert> selectByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase) throws Exception {
        return this.selectByPSSysTestCase(pSSysTestCaseBase, "", -1);
    }

    public ArrayList<PSSysTCAssert> selectByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase, String string) throws Exception {
        return this.selectByPSSysTestCase(pSSysTestCaseBase, string, -1);
    }

    public ArrayList<PSSysTCAssert> selectByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTCAssert> selectTempByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase) throws Exception {
        return this.selectTempByPSSysTestCase(pSSysTestCaseBase, "");
    }

    public ArrayList<PSSysTCAssert> selectTempByPSSysTestCase(PSSysTestCaseBase pSSysTestCaseBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTCASEID", (Object)pSSysTestCaseBase.getPSSysTestCaseId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysTestCaseCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysTestCaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTCAssert> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, "", -1);
    }

    public ArrayList<PSSysTCAssert> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, string, -1);
    }

    public ArrayList<PSSysTCAssert> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string, int n) throws Exception {
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

    public void testRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByDstPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTCASSERT_PSDATAENTITY_DSTPSDEID", "", iDataEntityModel.getName(), "PSSYSTCASSERT", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByDstPSDE(pSDataEntity);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            PSSysTCAssert pSSysTCAssert2 = (PSSysTCAssert)this.getDEModel().createEntity();
            pSSysTCAssert2.setPSSysTCAssertId(pSSysTCAssert.getPSSysTCAssertId());
            pSSysTCAssert2.setDstPSDEId(null);
            this.update(pSSysTCAssert2);
        }
    }

    public void removeByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCAssertServiceBase.this.onBeforeRemoveByDstPSDE(pSDataEntity2);
                PSSysTCAssertServiceBase.this.internalRemoveByDstPSDE(pSDataEntity2);
                PSSysTCAssertServiceBase.this.onAfterRemoveByDstPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByDstPSDE(pSDataEntity);
        this.onBeforeRemoveByDstPSDE(pSDataEntity, arrayList);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            this.remove(pSSysTCAssert);
        }
        this.onAfterRemoveByDstPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    public void testRemoveByDstKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByDstKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTCASSERT_PSDEFIELD_DSTKEYPSDEFID", "", iDataEntityModel.getName(), "PSSYSTCASSERT", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetDstKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByDstKeyPSDEF(pSDEField);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            PSSysTCAssert pSSysTCAssert2 = (PSSysTCAssert)this.getDEModel().createEntity();
            pSSysTCAssert2.setPSSysTCAssertId(pSSysTCAssert.getPSSysTCAssertId());
            pSSysTCAssert2.setDstKeyPSDEFId(null);
            this.update(pSSysTCAssert2);
        }
    }

    public void removeByDstKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCAssertServiceBase.this.onBeforeRemoveByDstKeyPSDEF(pSDEField2);
                PSSysTCAssertServiceBase.this.internalRemoveByDstKeyPSDEF(pSDEField2);
                PSSysTCAssertServiceBase.this.onAfterRemoveByDstKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDstKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDstKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByDstKeyPSDEF(pSDEField);
        this.onBeforeRemoveByDstKeyPSDEF(pSDEField, arrayList);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            this.remove(pSSysTCAssert);
        }
        this.onAfterRemoveByDstKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDstKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDstKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByPSSysTCInput(pSSysTCInput, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTCINPUT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTCInput);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTCASSERT_PSSYSTCINPUT_PSSYSTCINPUTID", "", iDataEntityModel.getName(), "PSSYSTCASSERT", iDataEntityModel.getDataInfo(pSSysTCInput), arrayList.get(0)));
        }
    }

    public void resetPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByPSSysTCInput(pSSysTCInput);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            PSSysTCAssert pSSysTCAssert2 = (PSSysTCAssert)this.getDEModel().createEntity();
            pSSysTCAssert2.setPSSysTCAssertId(pSSysTCAssert.getPSSysTCAssertId());
            pSSysTCAssert2.setPSSysTCInputId(null);
            this.update(pSSysTCAssert2);
        }
    }

    public void resetTempPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectTempByPSSysTCInput(pSSysTCInput);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            PSSysTCAssert pSSysTCAssert2 = (PSSysTCAssert)this.getDEModel().createEntity();
            pSSysTCAssert2.setPSSysTCAssertId(pSSysTCAssert.getPSSysTCAssertId());
            pSSysTCAssert2.setPSSysTCInputId(null);
            this.updateTemp(pSSysTCAssert2);
        }
    }

    public void removeByPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
        final PSSysTCInput pSSysTCInput2 = pSSysTCInput;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCAssertServiceBase.this.onBeforeRemoveByPSSysTCInput(pSSysTCInput2);
                PSSysTCAssertServiceBase.this.internalRemoveByPSSysTCInput(pSSysTCInput2);
                PSSysTCAssertServiceBase.this.onAfterRemoveByPSSysTCInput(pSSysTCInput2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
    }

    protected void internalRemoveByPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByPSSysTCInput(pSSysTCInput);
        this.onBeforeRemoveByPSSysTCInput(pSSysTCInput, arrayList);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            this.remove(pSSysTCAssert);
        }
        this.onAfterRemoveByPSSysTCInput(pSSysTCInput, arrayList);
    }

    protected void onAfterRemoveByPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTCInput(PSSysTCInput pSSysTCInput, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTCInput(PSSysTCInput pSSysTCInput, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    public void resetPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByPSSysTestCase(pSSysTestCase);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            PSSysTCAssert pSSysTCAssert2 = (PSSysTCAssert)this.getDEModel().createEntity();
            pSSysTCAssert2.setPSSysTCAssertId(pSSysTCAssert.getPSSysTCAssertId());
            pSSysTCAssert2.setPSSysTestCaseId(null);
            this.update(pSSysTCAssert2);
        }
    }

    public void resetTempPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectTempByPSSysTestCase(pSSysTestCase);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            PSSysTCAssert pSSysTCAssert2 = (PSSysTCAssert)this.getDEModel().createEntity();
            pSSysTCAssert2.setPSSysTCAssertId(pSSysTCAssert.getPSSysTCAssertId());
            pSSysTCAssert2.setPSSysTestCaseId(null);
            this.updateTemp(pSSysTCAssert2);
        }
    }

    public void removeByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        final PSSysTestCase pSSysTestCase2 = pSSysTestCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCAssertServiceBase.this.onBeforeRemoveByPSSysTestCase(pSSysTestCase2);
                PSSysTCAssertServiceBase.this.internalRemoveByPSSysTestCase(pSSysTestCase2);
                PSSysTCAssertServiceBase.this.onAfterRemoveByPSSysTestCase(pSSysTestCase2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    protected void internalRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByPSSysTestCase(pSSysTestCase);
        this.onBeforeRemoveByPSSysTestCase(pSSysTestCase, arrayList);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            this.remove(pSSysTCAssert);
        }
        this.onAfterRemoveByPSSysTestCase(pSSysTestCase, arrayList);
    }

    protected void onAfterRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestCase(PSSysTestCase pSSysTestCase, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByPSSysTestData(pSSysTestData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTESTDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTestData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTCASSERT_PSSYSTESTDATA_PSSYSTESTDATAID", "", iDataEntityModel.getName(), "PSSYSTCASSERT", iDataEntityModel.getDataInfo(pSSysTestData), arrayList.get(0)));
        }
    }

    public void resetPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByPSSysTestData(pSSysTestData);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            PSSysTCAssert pSSysTCAssert2 = (PSSysTCAssert)this.getDEModel().createEntity();
            pSSysTCAssert2.setPSSysTCAssertId(pSSysTCAssert.getPSSysTCAssertId());
            pSSysTCAssert2.setPSSysTestDataId(null);
            this.update(pSSysTCAssert2);
        }
    }

    public void removeByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        final PSSysTestData pSSysTestData2 = pSSysTestData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCAssertServiceBase.this.onBeforeRemoveByPSSysTestData(pSSysTestData2);
                PSSysTCAssertServiceBase.this.internalRemoveByPSSysTestData(pSSysTestData2);
                PSSysTCAssertServiceBase.this.onAfterRemoveByPSSysTestData(pSSysTestData2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void internalRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectByPSSysTestData(pSSysTestData);
        this.onBeforeRemoveByPSSysTestData(pSSysTestData, arrayList);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            this.remove(pSSysTCAssert);
        }
        this.onAfterRemoveByPSSysTestData(pSSysTestData, arrayList);
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTCAssert pSSysTCAssert) throws Exception {
        super.onBeforeRemove(pSSysTCAssert);
    }

    public void removeTempByPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
        final PSSysTCInput pSSysTCInput2 = pSSysTCInput;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCAssertServiceBase.this.onBeforeRemoveTempByPSSysTCInput(pSSysTCInput2);
                PSSysTCAssertServiceBase.this.internalRemoveTempByPSSysTCInput(pSSysTCInput2);
                PSSysTCAssertServiceBase.this.onAfterRemoveTempByPSSysTCInput(pSSysTCInput2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
    }

    protected void internalRemoveTempByPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectTempByPSSysTCInput(pSSysTCInput);
        this.onBeforeRemoveTempByPSSysTCInput(pSSysTCInput, arrayList);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            this.removeTemp(pSSysTCAssert);
        }
        this.onAfterRemoveTempByPSSysTCInput(pSSysTCInput, arrayList);
    }

    protected void onAfterRemoveTempByPSSysTCInput(PSSysTCInput pSSysTCInput) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysTCInput(PSSysTCInput pSSysTCInput, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysTCInput(PSSysTCInput pSSysTCInput, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    public void removeTempByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        final PSSysTestCase pSSysTestCase2 = pSSysTestCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTCAssertServiceBase.this.onBeforeRemoveTempByPSSysTestCase(pSSysTestCase2);
                PSSysTCAssertServiceBase.this.internalRemoveTempByPSSysTestCase(pSSysTestCase2);
                PSSysTCAssertServiceBase.this.onAfterRemoveTempByPSSysTestCase(pSSysTestCase2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    protected void internalRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.selectTempByPSSysTestCase(pSSysTestCase);
        this.onBeforeRemoveTempByPSSysTestCase(pSSysTestCase, arrayList);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            this.removeTemp(pSSysTCAssert);
        }
        this.onAfterRemoveTempByPSSysTestCase(pSSysTestCase, arrayList);
    }

    protected void onAfterRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysTestCase(PSSysTestCase pSSysTestCase, ArrayList<PSSysTCAssert> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysTCAssert pSSysTCAssert, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysTCAssert, cloneSession);
        if (pSSysTCAssert.getDstPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysTCAssert.getDstPSDEId())) != null) {
            this.onFillParentInfo_DstPSDE(pSSysTCAssert, (PSDataEntity)iEntity);
        }
        if (pSSysTCAssert.getDstKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysTCAssert.getDstKeyPSDEFId())) != null) {
            this.onFillParentInfo_DstKeyPSDEF(pSSysTCAssert, (PSDEField)iEntity);
        }
        if (pSSysTCAssert.getPSSysTCInputId() != null && (iEntity = cloneSession.getEntity("PSSYSTCINPUT", (Object)pSSysTCAssert.getPSSysTCInputId())) != null) {
            this.onFillParentInfo_PSSysTCInput(pSSysTCAssert, (PSSysTCInput)iEntity);
        }
        if (pSSysTCAssert.getPSSysTestCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTCASE", (Object)pSSysTCAssert.getPSSysTestCaseId())) != null) {
            this.onFillParentInfo_PSSysTestCase(pSSysTCAssert, (PSSysTestCase)iEntity);
        }
        if (pSSysTCAssert.getPSSysTestDataId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTDATA", (Object)pSSysTCAssert.getPSSysTestDataId())) != null) {
            this.onFillParentInfo_PSSysTestData(pSSysTCAssert, (PSSysTestData)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysTCAssert, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AssertResult(bl, pSSysTCAssert, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AssertTag(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AssertTag2(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AssertTag3(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AssertTag4(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AssertType(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstKeyPSDEFId(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstKeyPSDEFName(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEId(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEName(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExceptionData(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExceptionData2(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExceptionName(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTCAssertId(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTCAssertName(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTCInputId(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestCaseId(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestDataId(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestDataSN(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysTCAssert, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysTCAssert, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AssertResult(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isAssertResultDirty() : !pSSysTCAssert.isAssertResultDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getAssertResult();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AssertResult_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSERTRESULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AssertTag(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isAssertTagDirty() : !pSSysTCAssert.isAssertTagDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getAssertTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AssertTag_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSERTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AssertTag2(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isAssertTag2Dirty() : !pSSysTCAssert.isAssertTag2Dirty()) {
            return null;
        }
        String string = pSSysTCAssert.getAssertTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AssertTag2_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSERTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AssertTag3(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isAssertTag3Dirty() : !pSSysTCAssert.isAssertTag3Dirty()) {
            return null;
        }
        String string = pSSysTCAssert.getAssertTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AssertTag3_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSERTTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AssertTag4(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isAssertTag4Dirty() : !pSSysTCAssert.isAssertTag4Dirty()) {
            return null;
        }
        String string = pSSysTCAssert.getAssertTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AssertTag4_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSERTTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AssertType(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isAssertTypeDirty() && !bl2 : !pSSysTCAssert.isAssertTypeDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getAssertType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSERTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AssertType_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSERTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isCustomCodeDirty() : !pSSysTCAssert.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstKeyPSDEFId(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isDstKeyPSDEFIdDirty() : !pSSysTCAssert.isDstKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getDstKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstKeyPSDEFId_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTKEYPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstKeyPSDEFName(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isDstKeyPSDEFNameDirty() : !pSSysTCAssert.isDstKeyPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getDstKeyPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstKeyPSDEFName_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTKEYPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEId(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isDstPSDEIdDirty() : !pSSysTCAssert.isDstPSDEIdDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getDstPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEId_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEName(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isDstPSDENameDirty() : !pSSysTCAssert.isDstPSDENameDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getDstPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEName_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExceptionData(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isExceptionDataDirty() : !pSSysTCAssert.isExceptionDataDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getExceptionData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExceptionData_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXCEPTIONDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExceptionData2(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isExceptionData2Dirty() : !pSSysTCAssert.isExceptionData2Dirty()) {
            return null;
        }
        String string = pSSysTCAssert.getExceptionData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExceptionData2_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXCEPTIONDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExceptionName(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isExceptionNameDirty() : !pSSysTCAssert.isExceptionNameDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getExceptionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExceptionName_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXCEPTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isMemoDirty() : !pSSysTCAssert.isMemoDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isOrderValueDirty() : !pSSysTCAssert.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysTCAssert.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTCAssertId(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isPSSysTCAssertIdDirty() && !bl2 : !pSSysTCAssert.isPSSysTCAssertIdDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getPSSysTCAssertId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTCASSERTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTCAssertId_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTCASSERTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTCAssertName(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isPSSysTCAssertNameDirty() && !bl2 : !pSSysTCAssert.isPSSysTCAssertNameDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getPSSysTCAssertName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTCASSERTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTCAssertName_Default(pSSysTCAssert, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTCASSERTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTESTCASEID";
                String string4 = this.checkFieldDupRule(this.getPSSysTCAssertDEModel(), "PSSYSTCASSERTNAME", string3, pSSysTCAssert, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSTCASSERTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTCInputId(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isPSSysTCInputIdDirty() && !bl2 : !pSSysTCAssert.isPSSysTCInputIdDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getPSSysTCInputId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTCINPUTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTCInputId_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTestCaseId(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isPSSysTestCaseIdDirty() : !pSSysTCAssert.isPSSysTestCaseIdDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getPSSysTestCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestCaseId_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTestDataId(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isPSSysTestDataIdDirty() : !pSSysTCAssert.isPSSysTestDataIdDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getPSSysTestDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestDataId_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_TestDataSN(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isTestDataSNDirty() : !pSSysTCAssert.isTestDataSNDirty()) {
            return null;
        }
        Integer n = pSSysTCAssert.getTestDataSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TestDataSN_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isUserCatDirty() : !pSSysTCAssert.isUserCatDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isUserTagDirty() : !pSSysTCAssert.isUserTagDirty()) {
            return null;
        }
        String string = pSSysTCAssert.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isUserTag2Dirty() : !pSSysTCAssert.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysTCAssert.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isUserTag3Dirty() : !pSSysTCAssert.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysTCAssert.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isUserTag4Dirty() : !pSSysTCAssert.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysTCAssert.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysTCAssert, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysTCAssert pSSysTCAssert, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTCAssert.isValidFlagDirty() : !pSSysTCAssert.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysTCAssert.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysTCAssert, bl2, bl3);
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

    protected void onSyncEntity(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
        super.onSyncEntity(pSSysTCAssert, bl);
    }

    protected void onSyncIndexEntities(PSSysTCAssert pSSysTCAssert, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysTCAssert, bl);
    }

    public Object getDataContextValue(PSSysTCAssert pSSysTCAssert, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysTCAssert, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTCAssert pSSysTCAssert, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysTCAssert, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ASSERTRESULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AssertResult_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASSERTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AssertTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASSERTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AssertTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASSERTTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AssertTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASSERTTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AssertTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASSERTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AssertType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DSTKEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstKeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTKEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstKeyPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXCEPTIONDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExceptionData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXCEPTIONDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExceptionData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXCEPTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExceptionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTCASSERTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTCAssertId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTCASSERTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTCAssertName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AssertResult_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASSERTRESULT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AssertTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASSERTTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AssertTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASSERTTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AssertTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASSERTTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AssertTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASSERTTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AssertType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASSERTTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_DstKeyPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTKEYPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstKeyPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTKEYPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExceptionData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXCEPTIONDATA", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExceptionData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXCEPTIONDATA2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExceptionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXCEPTIONNAME", iEntity, bl2, null, false, 260, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[260]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[260]";
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

    protected String onTestValueRule_PSSysTCAssertId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTCASSERTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTCAssertName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTCASSERTNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSSYSTCASSERTNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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
            if (this.checkFieldStringLengthRule("PSSYSTCINPUTNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSSysTCAssert pSSysTCAssert) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysTCAssert)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTCAssert pSSysTCAssert) throws Exception {
        super.onUpdateParent(pSSysTCAssert);
    }

    @Override
    protected void exportCurXmlModel(PSSysTCAssert pSSysTCAssert, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTCASSERT");
        if (!bl) {
            pSSysTCAssert.setCreateDate(null);
            pSSysTCAssert.setCreateMan(null);
            pSSysTCAssert.setPSSysTCAssertId(null);
            pSSysTCAssert.setUpdateDate(null);
            pSSysTCAssert.setUpdateMan(null);
            pSSysTCAssert.setPSSysTCInputId(null);
            pSSysTCAssert.setPSDEId(null);
            pSSysTCAssert.setPSSysTestCaseId(null);
            pSSysTCAssert.setPSSysTestCaseName(null);
            pSSysTCAssert.setTargetType(null);
            super.exportCurXmlModel(pSSysTCAssert, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysTCAssert pSSysTCAssert, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysTCAssert, string);
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
            return "DER1N_PSSYSTCASSERT_PSSYSTESTCASE_PSSYSTESTCASEID";
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
    public String getModelV2Tag(PSSysTCAssert pSSysTCAssert) {
        if (!StringHelper.isNullOrEmpty((String)pSSysTCAssert.getPSSysTCAssertName())) {
            return pSSysTCAssert.getPSSysTCAssertName();
        }
        return super.getModelV2Tag(pSSysTCAssert);
    }

    @Override
    public boolean setModelV2Tag(PSSysTCAssert pSSysTCAssert, String string) {
        pSSysTCAssert.setPSSysTCAssertName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSTCASSERTNAME", "");
        map.put("PSSYSTESTCASEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysTCAssert pSSysTCAssert, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysTCAssert.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysTCAssert, true);
        pSSysTCAssert.set("PSSYSTCASSERTNAME", string);
        if (this.select(pSSysTCAssert, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysTCAssert, true);
        return super.getModelV2Entity(pSSysTCAssert, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysTCAssert pSSysTCAssert, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysTCAssert, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysTCAssert pSSysTCAssert, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("PSSYSTCASSERTNAME", "assert");
    }
}

