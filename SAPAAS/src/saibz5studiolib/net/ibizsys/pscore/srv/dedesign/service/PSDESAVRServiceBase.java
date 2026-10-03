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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDESAVRDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESAVRDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESAVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESAVRServiceBase
extends PSCoreSysServiceBase<PSDESAVR> {
    private static final Log log = LogFactory.getLog(PSDESAVRServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDESAVRDEModel pSDESAVRDEModel;
    private PSDESAVRDAO pSDESAVRDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDESAVRService";
    }

    public PSDESAVRDEModel getPSDESAVRDEModel() {
        if (this.pSDESAVRDEModel == null) {
            try {
                this.pSDESAVRDEModel = (PSDESAVRDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESAVRDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESAVRDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDESAVRDEModel();
    }

    public PSDESAVRDAO getPSDESAVRDAO() {
        if (this.pSDESAVRDAO == null) {
            try {
                this.pSDESAVRDAO = (PSDESAVRDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDESAVRDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESAVRDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDESAVRDAO();
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

    protected void onFillParentInfo(PSDESAVR pSDESAVR, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESAVR_PSDEFVALUERULE_PSDEFVRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFValueRule);
            } else {
                iService.get(pSDEFValueRule);
            }
            this.onFillParentInfo_PSDEFVR(pSDESAVR, pSDEFValueRule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)iService.getDEModel().createEntity();
            pSDEServiceAPI.set("PSDESERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEServiceAPI);
            } else {
                iService.get(pSDEServiceAPI);
            }
            this.onFillParentInfo_PSDEServiceAPI(pSDESAVR, pSDEServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESAVR_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysValueRule);
            } else {
                iService.get(pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSDESAVR, pSSysValueRule);
            return;
        }
        super.onFillParentInfo(pSDESAVR, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEFVR(PSDESAVR pSDESAVR, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDESAVR.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDESAVR.setPSDEFVRName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillParentInfo_PSDEServiceAPI(PSDESAVR pSDESAVR, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        pSDESAVR.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
        pSDESAVR.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSDESAVR pSDESAVR, PSSysValueRule pSSysValueRule) throws Exception {
        pSDESAVR.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSDESAVR.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDESAVR pSDESAVR, boolean bl) throws Exception {
        if (bl) {
            if (pSDESAVR.getCodeName() == null) {
                pSDESAVR.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "ValueRule", 25));
            }
            if (pSDESAVR.getOrderValue() == null) {
                pSDESAVR.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "1000", 9));
            }
            if (pSDESAVR.getValidFlag() == null) {
                pSDESAVR.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDESAVR.getVRType() == null) {
                pSDESAVR.setVRType((String)this.getDefaultValue(this.getWebContext(), "", "DEFVALUERULE", 25));
            }
        }
        super.onFillEntityFullInfo(pSDESAVR, bl);
        this.onFillEntityFullInfo_PSDEFVR(pSDESAVR, bl);
        this.onFillEntityFullInfo_PSDEServiceAPI(pSDESAVR, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSDESAVR, bl);
    }

    protected void onFillEntityFullInfo_PSDEFVR(PSDESAVR pSDESAVR, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEServiceAPI(PSDESAVR pSDESAVR, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSDESAVR pSDESAVR, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDESAVR pSDESAVR, boolean bl) throws Exception {
        super.onWriteBackParent(pSDESAVR, bl);
    }

    public ArrayList<PSDESAVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDESAVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDESAVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVRID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFVRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFVRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESAVR> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, "", -1);
    }

    public ArrayList<PSDESAVR> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, string, -1);
    }

    public ArrayList<PSDESAVR> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESERVICEAPIID", (Object)pSDEServiceAPIBase.getPSDEServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESAVR> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSDESAVR> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSDESAVR> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVALUERULEID", (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDESAVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESAVR_PSDEFVALUERULE_PSDEFVRID", "", iDataEntityModel.getName(), "PSDESAVR", iDataEntityModel.getDataInfo(pSDEFValueRule), arrayList.get(0)));
        }
    }

    public void resetPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDESAVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        for (PSDESAVR pSDESAVR : arrayList) {
            PSDESAVR pSDESAVR2 = (PSDESAVR)this.getDEModel().createEntity();
            pSDESAVR2.setPSDESAVRId(pSDESAVR.getPSDESAVRId());
            pSDESAVR2.setPSDEFVRId(null);
            this.update(pSDESAVR2);
        }
    }

    public void removeByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESAVRServiceBase.this.onBeforeRemoveByPSDEFVR(pSDEFValueRule2);
                PSDESAVRServiceBase.this.internalRemoveByPSDEFVR(pSDEFValueRule2);
                PSDESAVRServiceBase.this.onAfterRemoveByPSDEFVR(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDESAVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        this.onBeforeRemoveByPSDEFVR(pSDEFValueRule, arrayList);
        for (PSDESAVR pSDESAVR : arrayList) {
            this.remove(pSDESAVR);
        }
        this.onAfterRemoveByPSDEFVR(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDESAVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDESAVR> arrayList) throws Exception {
    }

    public void testRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESAVR> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID", "", iDataEntityModel.getName(), "PSDESAVR", iDataEntityModel.getDataInfo(pSDEServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESAVR> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        for (PSDESAVR pSDESAVR : arrayList) {
            PSDESAVR pSDESAVR2 = (PSDESAVR)this.getDEModel().createEntity();
            pSDESAVR2.setPSDESAVRId(pSDESAVR.getPSDESAVRId());
            pSDESAVR2.setPSDEServiceAPIId(null);
            this.update(pSDESAVR2);
        }
    }

    public void removeByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESAVRServiceBase.this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSDESAVRServiceBase.this.internalRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSDESAVRServiceBase.this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESAVR> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
        for (PSDESAVR pSDESAVR : arrayList) {
            this.remove(pSDESAVR);
        }
        this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESAVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESAVR> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDESAVR> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESAVR_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSDESAVR", iDataEntityModel.getDataInfo(pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDESAVR> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSDESAVR pSDESAVR : arrayList) {
            PSDESAVR pSDESAVR2 = (PSDESAVR)this.getDEModel().createEntity();
            pSDESAVR2.setPSDESAVRId(pSDESAVR.getPSDESAVRId());
            pSDESAVR2.setPSSysValueRuleId(null);
            this.update(pSDESAVR2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESAVRServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSDESAVRServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSDESAVRServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDESAVR> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSDESAVR pSDESAVR : arrayList) {
            this.remove(pSDESAVR);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDESAVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDESAVR> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDESAVR pSDESAVR) throws Exception {
        super.onBeforeRemove(pSDESAVR);
    }

    protected void replaceParentInfo(PSDESAVR pSDESAVR, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDESAVR, cloneSession);
        if (pSDESAVR.getPSDEFVRId() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDESAVR.getPSDEFVRId())) != null) {
            this.onFillParentInfo_PSDEFVR(pSDESAVR, (PSDEFValueRule)iEntity);
        }
        if (pSDESAVR.getPSDEServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSDESERVICEAPI", (Object)pSDESAVR.getPSDEServiceAPIId())) != null) {
            this.onFillParentInfo_PSDEServiceAPI(pSDESAVR, (PSDEServiceAPI)iEntity);
        }
        if (pSDESAVR.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSDESAVR.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSDESAVR, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDESAVR pSDESAVR, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDESAVR, bl);
    }

    protected void onCheckEntity(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDESAVR, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRId(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESAVRId(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESAVRName(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEServiceAPIId(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VRType(bl, pSDESAVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDESAVR, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isCodeNameDirty() && !bl2 : !pSDESAVR.isCodeNameDirty()) {
            return null;
        }
        String string = pSDESAVR.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDESAVR, bl2, bl3);
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
                string3 = "PSDESERVICEAPIID";
                String string4 = this.checkFieldDupRule(this.getPSDESAVRDEModel(), "CODENAME", string3, pSDESAVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isMemoDirty() : !pSDESAVR.isMemoDirty()) {
            return null;
        }
        String string = pSDESAVR.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDESAVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isOrderValueDirty() : !pSDESAVR.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDESAVR.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDESAVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFVRId(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isPSDEFVRIdDirty() : !pSDESAVR.isPSDEFVRIdDirty()) {
            return null;
        }
        String string = pSDESAVR.getPSDEFVRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRId_Default(pSDESAVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESAVRId(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isPSDESAVRIdDirty() && !bl2 : !pSDESAVR.isPSDESAVRIdDirty()) {
            return null;
        }
        String string = pSDESAVR.getPSDESAVRId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAVRID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESAVRId_Default(pSDESAVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESAVRName(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isPSDESAVRNameDirty() && !bl2 : !pSDESAVR.isPSDESAVRNameDirty()) {
            return null;
        }
        String string = pSDESAVR.getPSDESAVRName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAVRNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESAVRName_Default(pSDESAVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAVRNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEServiceAPIId(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isPSDEServiceAPIIdDirty() && !bl2 : !pSDESAVR.isPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDESAVR.getPSDEServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEServiceAPIId_Default(pSDESAVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isPSSysValueRuleIdDirty() : !pSDESAVR.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSDESAVR.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default(pSDESAVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isUserCatDirty() : !pSDESAVR.isUserCatDirty()) {
            return null;
        }
        String string = pSDESAVR.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDESAVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isUserTagDirty() : !pSDESAVR.isUserTagDirty()) {
            return null;
        }
        String string = pSDESAVR.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDESAVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isUserTag2Dirty() : !pSDESAVR.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDESAVR.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDESAVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isUserTag3Dirty() : !pSDESAVR.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDESAVR.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDESAVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isUserTag4Dirty() : !pSDESAVR.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDESAVR.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDESAVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isValidFlagDirty() && !bl2 : !pSDESAVR.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDESAVR.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDESAVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_VRType(boolean bl, PSDESAVR pSDESAVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESAVR.isVRTypeDirty() && !bl2 : !pSDESAVR.isVRTypeDirty()) {
            return null;
        }
        String string = pSDESAVR.getVRType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VRTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_VRType_Default(pSDESAVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VRTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDESAVR pSDESAVR, boolean bl) throws Exception {
        super.onSyncEntity(pSDESAVR, bl);
    }

    protected void onSyncIndexEntities(PSDESAVR pSDESAVR, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDESAVR, bl);
    }

    public Object getDataContextValue(PSDESAVR pSDESAVR, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDESAVR, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEServiceAPI pSDEServiceAPI = pSDESAVR.getPSDEServiceAPI();
        if (pSDEServiceAPI != null && pSDEServiceAPI.contains(string)) {
            return pSDEServiceAPI.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDESAVR pSDESAVR, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDESAVR, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESAVRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESAVRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VRTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VRType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEFVRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESAVRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESAVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_VRType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VRTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDESAVR pSDESAVR) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDESAVR)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDESAVR pSDESAVR) throws Exception {
        super.onUpdateParent(pSDESAVR);
    }

    @Override
    protected void exportCurXmlModel(PSDESAVR pSDESAVR, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESAVR");
        if (!bl) {
            pSDESAVR.setCreateDate(null);
            pSDESAVR.setCreateMan(null);
            pSDESAVR.setPSDESAVRId(null);
            pSDESAVR.setPSSysValueRuleName(null);
            pSDESAVR.setUpdateDate(null);
            pSDESAVR.setUpdateMan(null);
            super.exportCurXmlModel(pSDESAVR, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDESAVR pSDESAVR, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDESAVR, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDESERVICEAPI#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPINAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPI", (boolean)true) == 0) {
            iEntity.set("PSDESERVICEAPIID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDESERVICEAPIID"};
    }

    @Override
    public String getModelV2Tag(PSDESAVR pSDESAVR) {
        if (!StringHelper.isNullOrEmpty((String)pSDESAVR.getCodeName())) {
            return pSDESAVR.getCodeName();
        }
        return super.getModelV2Tag(pSDESAVR);
    }

    @Override
    public boolean setModelV2Tag(PSDESAVR pSDESAVR, String string) {
        pSDESAVR.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDESERVICEAPIID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDESAVR pSDESAVR, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDESAVR.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDESAVR, true);
        pSDESAVR.set("CODENAME", string);
        if (this.select(pSDESAVR, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDESAVR, true);
        return super.getModelV2Entity(pSDESAVR, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDESAVR pSDESAVR, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDESAVR, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDESAVR pSDESAVR, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "ValueRule");
    }
}

