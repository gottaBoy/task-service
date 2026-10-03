/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPIBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDESARSDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDESARSDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESARSServiceBase
extends PSCoreSysServiceBase<PSDESARS> {
    private static final Log log = LogFactory.getLog(PSDESARSServiceBase.class);
    public static final String DATASET_CURDESAMAJOR = "CurDESAMajor";
    public static final String DATASET_CURDESAMINOR = "CurDESAMinor";
    public static final String DATASET_CURSYSAPI = "CurSysAPI";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEEX = "createEx";
    private PSDESARSDEModel pSDESARSDEModel;
    private PSDESARSDAO pSDESARSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService";
    }

    public PSDESARSDEModel getPSDESARSDEModel() {
        if (this.pSDESARSDEModel == null) {
            try {
                this.pSDESARSDEModel = (PSDESARSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDESARSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESARSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDESARSDEModel();
    }

    public PSDESARSDAO getPSDESARSDAO() {
        if (this.pSDESARSDAO == null) {
            try {
                this.pSDESARSDAO = (PSDESARSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDESARSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESARSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDESARSDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDESAMAJOR, (boolean)true) == 0) {
            return this.fetchCurDESAMajor(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDESAMINOR, (boolean)true) == 0) {
            return this.fetchCurDESAMinor(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)ACTION_CREATEEX, (boolean)true) == 0) {
            this.createEx((PSDESARS)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDESAMajor(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDESAMAJOR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDESAMinor(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDESAMINOR, false);
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

    public void createEx(PSDESARS pSDESARS) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEEX, 0, pSDESARS, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDESARS, ACTION_CREATEEX);
        final PSDESARS pSDESARS2 = pSDESARS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDESARSServiceBase.this.getService(), PSDESARSServiceBase.ACTION_CREATEEX, 40, pSDESARS2, null).getResult() != 1) {
                    PSDESARSServiceBase.this.onCreateEx(pSDESARS2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEEX, 99, pSDESARS, null);
        }
    }

    protected void onCreateEx(PSDESARS pSDESARS) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[createEx]");
    }

    protected void onFillParentInfo(PSDESARS pSDESARS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESARS_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSDESARS, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESARS_PSDESERVICEAPI_CPSDESERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)iService.getDEModel().createEntity();
            pSDEServiceAPI.set("PSDESERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEServiceAPI);
            } else {
                iService.get(pSDEServiceAPI);
            }
            this.onFillParentInfo_CPSDEServiceAPI(pSDESARS, pSDEServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESARS_PSDESERVICEAPI_PPSDESERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)iService.getDEModel().createEntity();
            pSDEServiceAPI.set("PSDESERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEServiceAPI);
            } else {
                iService.get(pSDEServiceAPI);
            }
            this.onFillParentInfo_PPSDEServiceAPI(pSDESARS, pSDEServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSysServiceAPI pSSysServiceAPI = (PSSysServiceAPI)iService.getDEModel().createEntity();
            pSSysServiceAPI.set("PSSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysServiceAPI);
            } else {
                iService.get(pSSysServiceAPI);
            }
            this.onFillParentInfo_PSSysServiceAPI(pSDESARS, pSSysServiceAPI);
            return;
        }
        super.onFillParentInfo(pSDESARS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDER(PSDESARS pSDESARS, PSDER pSDER) throws Exception {
        pSDESARS.setPSDERId(pSDER.getPSDERId());
        pSDESARS.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_CPSDEServiceAPI(PSDESARS pSDESARS, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        pSDESARS.setCPSDEId(pSDEServiceAPI.getPSDEId());
        pSDESARS.setCPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
        pSDESARS.setCPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
    }

    protected void onFillParentInfo_PPSDEServiceAPI(PSDESARS pSDESARS, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        pSDESARS.setPPSDEId(pSDEServiceAPI.getPSDEId());
        pSDESARS.setPPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
        pSDESARS.setPPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
        if (pSDEServiceAPI.getPSSysServiceAPI() != null) {
            this.onFillParentInfo_PSSysServiceAPI(pSDESARS, pSDEServiceAPI.getPSSysServiceAPI());
        }
    }

    protected void onFillParentInfo_PSSysServiceAPI(PSDESARS pSDESARS, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSDESARS.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
        pSDESARS.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
    }

    protected void onFillEntityFullInfo(PSDESARS pSDESARS, boolean bl) throws Exception {
        if (bl && pSDESARS.getValidFlag() == null) {
            pSDESARS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDESARS, bl);
        this.onFillEntityFullInfo_PSDER(pSDESARS, bl);
        this.onFillEntityFullInfo_CPSDEServiceAPI(pSDESARS, bl);
        this.onFillEntityFullInfo_PPSDEServiceAPI(pSDESARS, bl);
        this.onFillEntityFullInfo_PSSysServiceAPI(pSDESARS, bl);
    }

    protected void onFillEntityFullInfo_PSDER(PSDESARS pSDESARS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CPSDEServiceAPI(PSDESARS pSDESARS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSDEServiceAPI(PSDESARS pSDESARS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysServiceAPI(PSDESARS pSDESARS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDESARS pSDESARS, boolean bl) throws Exception {
        super.onWriteBackParent(pSDESARS, bl);
    }

    public ArrayList<PSDESARS> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDESARS> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDESARS> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESARS> selectByCPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase) throws Exception {
        return this.selectByCPSDEServiceAPI(pSDEServiceAPIBase, "", -1);
    }

    public ArrayList<PSDESARS> selectByCPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string) throws Exception {
        return this.selectByCPSDEServiceAPI(pSDEServiceAPIBase, string, -1);
    }

    public ArrayList<PSDESARS> selectByCPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CPSDESERVICEAPIID", (Object)pSDEServiceAPIBase.getPSDEServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCPSDEServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCPSDEServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESARS> selectByPPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase) throws Exception {
        return this.selectByPPSDEServiceAPI(pSDEServiceAPIBase, "", -1);
    }

    public ArrayList<PSDESARS> selectByPPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string) throws Exception {
        return this.selectByPPSDEServiceAPI(pSDEServiceAPIBase, string, -1);
    }

    public ArrayList<PSDESARS> selectByPPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDESERVICEAPIID", (Object)pSDEServiceAPIBase.getPSDEServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDEServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDEServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESARS> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSDESARS> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSDESARS> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSERVICEAPIID", (Object)pSSysServiceAPIBase.getPSSysServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESARS_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSDESARS", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByPSDER(pSDER);
        for (PSDESARS pSDESARS : arrayList) {
            PSDESARS pSDESARS2 = (PSDESARS)this.getDEModel().createEntity();
            pSDESARS2.setPSDESARSId(pSDESARS.getPSDESARSId());
            pSDESARS2.setPSDERId(null);
            this.update(pSDESARS2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESARSServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDESARSServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDESARSServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDESARS pSDESARS : arrayList) {
            this.remove(pSDESARS);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDESARS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDESARS> arrayList) throws Exception {
    }

    public void testRemoveByCPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByCPSDEServiceAPI(pSDEServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESARS_PSDESERVICEAPI_CPSDESERVICEAPIID", "", iDataEntityModel.getName(), "PSDESARS", iDataEntityModel.getDataInfo(pSDEServiceAPI), arrayList.get(0)));
        }
    }

    public void resetCPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByCPSDEServiceAPI(pSDEServiceAPI);
        for (PSDESARS pSDESARS : arrayList) {
            PSDESARS pSDESARS2 = (PSDESARS)this.getDEModel().createEntity();
            pSDESARS2.setPSDESARSId(pSDESARS.getPSDESARSId());
            pSDESARS2.setCPSDEServiceAPIId(null);
            this.update(pSDESARS2);
        }
    }

    public void removeByCPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESARSServiceBase.this.onBeforeRemoveByCPSDEServiceAPI(pSDEServiceAPI2);
                PSDESARSServiceBase.this.internalRemoveByCPSDEServiceAPI(pSDEServiceAPI2);
                PSDESARSServiceBase.this.onAfterRemoveByCPSDEServiceAPI(pSDEServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByCPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void internalRemoveByCPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByCPSDEServiceAPI(pSDEServiceAPI);
        this.onBeforeRemoveByCPSDEServiceAPI(pSDEServiceAPI, arrayList);
        for (PSDESARS pSDESARS : arrayList) {
            this.remove(pSDESARS);
        }
        this.onAfterRemoveByCPSDEServiceAPI(pSDEServiceAPI, arrayList);
    }

    protected void onAfterRemoveByCPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByCPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESARS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESARS> arrayList) throws Exception {
    }

    public void testRemoveByPPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    public void resetPPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByPPSDEServiceAPI(pSDEServiceAPI);
        for (PSDESARS pSDESARS : arrayList) {
            PSDESARS pSDESARS2 = (PSDESARS)this.getDEModel().createEntity();
            pSDESARS2.setPSDESARSId(pSDESARS.getPSDESARSId());
            pSDESARS2.setPPSDEServiceAPIId(null);
            this.update(pSDESARS2);
        }
    }

    public void removeByPPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESARSServiceBase.this.onBeforeRemoveByPPSDEServiceAPI(pSDEServiceAPI2);
                PSDESARSServiceBase.this.internalRemoveByPPSDEServiceAPI(pSDEServiceAPI2);
                PSDESARSServiceBase.this.onAfterRemoveByPPSDEServiceAPI(pSDEServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void internalRemoveByPPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByPPSDEServiceAPI(pSDEServiceAPI);
        this.onBeforeRemoveByPPSDEServiceAPI(pSDEServiceAPI, arrayList);
        for (PSDESARS pSDESARS : arrayList) {
            this.remove(pSDESARS);
        }
        this.onAfterRemoveByPPSDEServiceAPI(pSDEServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESARS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESARS> arrayList) throws Exception {
    }

    public void testRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSDESARS", iDataEntityModel.getDataInfo(pSSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        for (PSDESARS pSDESARS : arrayList) {
            PSDESARS pSDESARS2 = (PSDESARS)this.getDEModel().createEntity();
            pSDESARS2.setPSDESARSId(pSDESARS.getPSDESARSId());
            pSDESARS2.setPSSysServiceAPIId(null);
            this.update(pSDESARS2);
        }
    }

    public void removeByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESARSServiceBase.this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSDESARSServiceBase.this.internalRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSDESARSServiceBase.this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSDESARS> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
        for (PSDESARS pSDESARS : arrayList) {
            this.remove(pSDESARS);
        }
        this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSDESARS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSDESARS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDESARS pSDESARS) throws Exception {
        PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        pSDESADetailService.testRemoveByPSDESARS(pSDESARS);
        super.onBeforeRemove(pSDESARS);
    }

    protected void replaceParentInfo(PSDESARS pSDESARS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDESARS, cloneSession);
        if (pSDESARS.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDESARS.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDESARS, (PSDER)iEntity);
        }
        if (pSDESARS.getCPSDEServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSDESERVICEAPI", (Object)pSDESARS.getCPSDEServiceAPIId())) != null) {
            this.onFillParentInfo_CPSDEServiceAPI(pSDESARS, (PSDEServiceAPI)iEntity);
        }
        if (pSDESARS.getPPSDEServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSDESERVICEAPI", (Object)pSDESARS.getPPSDEServiceAPIId())) != null) {
            this.onFillParentInfo_PPSDEServiceAPI(pSDESARS, (PSDEServiceAPI)iEntity);
        }
        if (pSDESARS.getPSSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSYSSERVICEAPI", (Object)pSDESARS.getPSSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSysServiceAPI(pSDESARS, (PSSysServiceAPI)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDESARS pSDESARS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDESARS, bl);
    }

    protected void onCheckEntity(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionRSMode(bl, pSDESARS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArrayFlag(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChildFilter(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CPSDEServiceAPIId(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataAccMode(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataRSMode(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDataExport(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDataImport(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDEAction(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDEDataSet(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSelect(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportModel(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope2(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope3(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope4(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDEServiceAPIId(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESARSId(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESARSName(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncExportModel(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TempOrderValue(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeFilter(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDESARS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDESARS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionRSMode(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isActionRSModeDirty() : !pSDESARS.isActionRSModeDirty()) {
            return null;
        }
        Integer n = pSDESARS.getActionRSMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionRSMode_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONRSMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArrayFlag(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isArrayFlagDirty() : !pSDESARS.isArrayFlagDirty()) {
            return null;
        }
        Integer n = pSDESARS.getArrayFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArrayFlag_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARRAYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ChildFilter(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isChildFilterDirty() : !pSDESARS.isChildFilterDirty()) {
            return null;
        }
        String string = pSDESARS.getChildFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChildFilter_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILDFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isCodeNameDirty() : !pSDESARS.isCodeNameDirty()) {
            return null;
        }
        String string = pSDESARS.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDESARS, bl2, bl3);
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
                string3 = "PPSDESERVICEAPIID";
                String string4 = this.checkFieldDupRule(this.getPSDESARSDEModel(), "CODENAME", string3, pSDESARS, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isCodeName2Dirty() : !pSDESARS.isCodeName2Dirty()) {
            return null;
        }
        String string = pSDESARS.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
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
                string3 = "PPSDESERVICEAPIID";
                String string4 = this.checkFieldDupRule(this.getPSDESARSDEModel(), "CODENAME2", string3, pSDESARS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME2");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CPSDEServiceAPIId(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isCPSDEServiceAPIIdDirty() && !bl2 : !pSDESARS.isCPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDESARS.getCPSDEServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSDESERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CPSDEServiceAPIId_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSDESERVICEAPIID");
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
                string3 = "PPSDESERVICEAPIID";
                String string4 = this.checkFieldDupRule(this.getPSDESARSDEModel(), "CPSDESERVICEAPIID", string3, pSDESARS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CPSDESERVICEAPIID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataAccMode(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isDataAccModeDirty() : !pSDESARS.isDataAccModeDirty()) {
            return null;
        }
        Integer n = pSDESARS.getDataAccMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DataAccMode_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAACCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataRSMode(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isDataRSModeDirty() : !pSDESARS.isDataRSModeDirty()) {
            return null;
        }
        Integer n = pSDESARS.getDataRSMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DataRSMode_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATARSMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDataExport(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isEnableDataExportDirty() : !pSDESARS.isEnableDataExportDirty()) {
            return null;
        }
        Integer n = pSDESARS.getEnableDataExport();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDataExport_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDATAEXPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDataImport(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isEnableDataImportDirty() : !pSDESARS.isEnableDataImportDirty()) {
            return null;
        }
        Integer n = pSDESARS.getEnableDataImport();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDataImport_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDATAIMPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDEAction(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isEnableDEActionDirty() : !pSDESARS.isEnableDEActionDirty()) {
            return null;
        }
        Integer n = pSDESARS.getEnableDEAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDEAction_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDEACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDEDataSet(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isEnableDEDataSetDirty() : !pSDESARS.isEnableDEDataSetDirty()) {
            return null;
        }
        Integer n = pSDESARS.getEnableDEDataSet();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDEDataSet_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDEDATASET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSelect(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isEnableSelectDirty() : !pSDESARS.isEnableSelectDirty()) {
            return null;
        }
        Integer n = pSDESARS.getEnableSelect();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSelect_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESELECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportModel(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isExportModelDirty() : !pSDESARS.isExportModelDirty()) {
            return null;
        }
        Integer n = pSDESARS.getExportModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportModel_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isExportScopeDirty() : !pSDESARS.isExportScopeDirty()) {
            return null;
        }
        Integer n = pSDESARS.getExportScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope2(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isExportScope2Dirty() : !pSDESARS.isExportScope2Dirty()) {
            return null;
        }
        Integer n = pSDESARS.getExportScope2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope2_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope3(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isExportScope3Dirty() : !pSDESARS.isExportScope3Dirty()) {
            return null;
        }
        Integer n = pSDESARS.getExportScope3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope3_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope4(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isExportScope4Dirty() : !pSDESARS.isExportScope4Dirty()) {
            return null;
        }
        Integer n = pSDESARS.getExportScope4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope4_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isMemoDirty() : !pSDESARS.isMemoDirty()) {
            return null;
        }
        String string = pSDESARS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDESARS, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isOrderValueDirty() : !pSDESARS.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDESARS.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDESARS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDEServiceAPIId(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isPPSDEServiceAPIIdDirty() && !bl2 : !pSDESARS.isPPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDESARS.getPPSDEServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDESERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDEServiceAPIId_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDESERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isPSDERIdDirty() : !pSDESARS.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDESARS.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESARSId(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isPSDESARSIdDirty() && !bl2 : !pSDESARS.isPSDESARSIdDirty()) {
            return null;
        }
        String string = pSDESARS.getPSDESARSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESARSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESARSId_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESARSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESARSName(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isPSDESARSNameDirty() && !bl2 : !pSDESARS.isPSDESARSNameDirty()) {
            return null;
        }
        String string = pSDESARS.getPSDESARSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESARSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESARSName_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESARSNAME");
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
                string3 = "PSSYSSERVICEAPIID";
                String string4 = this.checkFieldDupRule(this.getPSDESARSDEModel(), "PSDESARSNAME", string3, pSDESARS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDESARSNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isPSSysServiceAPIIdDirty() && !bl2 : !pSDESARS.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDESARS.getPSSysServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncExportModel(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isSyncExportModelDirty() : !pSDESARS.isSyncExportModelDirty()) {
            return null;
        }
        Integer n = pSDESARS.getSyncExportModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncExportModel_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCEXPORTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TempOrderValue(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isTempOrderValueDirty() : !pSDESARS.isTempOrderValueDirty()) {
            return null;
        }
        Integer n = pSDESARS.getTempOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TempOrderValue_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeFilter(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isTypeFilterDirty() : !pSDESARS.isTypeFilterDirty()) {
            return null;
        }
        String string = pSDESARS.getTypeFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeFilter_Default(pSDESARS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isUserCatDirty() : !pSDESARS.isUserCatDirty()) {
            return null;
        }
        String string = pSDESARS.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDESARS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isUserTagDirty() : !pSDESARS.isUserTagDirty()) {
            return null;
        }
        String string = pSDESARS.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDESARS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isUserTag2Dirty() : !pSDESARS.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDESARS.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDESARS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isUserTag3Dirty() : !pSDESARS.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDESARS.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDESARS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isUserTag4Dirty() : !pSDESARS.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDESARS.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDESARS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDESARS pSDESARS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESARS.isValidFlagDirty() && !bl2 : !pSDESARS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDESARS.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDESARS, bl2, bl3);
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

    protected void onSyncEntity(PSDESARS pSDESARS, boolean bl) throws Exception {
        super.onSyncEntity(pSDESARS, bl);
    }

    protected void onSyncIndexEntities(PSDESARS pSDESARS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDESARS, bl);
    }

    public Object getDataContextValue(PSDESARS pSDESARS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDESARS, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysServiceAPI pSSysServiceAPI = pSDESARS.getPSSysServiceAPI();
        if (pSSysServiceAPI != null && pSSysServiceAPI.contains(string)) {
            return pSSysServiceAPI.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDESARS pSDESARS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDESARS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONRSMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionRSMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARRAYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArrayFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILDFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChildFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPSDESERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSDEServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPSDESERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSDEServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAACCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataAccMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATARSMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataRSMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDATAEXPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDataExport_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDATAIMPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDataImport_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDEACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDEAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDEDataSet_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESELECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSelect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDESERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDESERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESARSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESARSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESARSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESARSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCEXPORTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncExportModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TempOrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeFilter_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ActionRSMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ArrayFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ChildFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHILDFILTER", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPSDEServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSDESERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPSDEServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSDESERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_DataAccMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DataRSMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDataExport_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDataImport_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDEAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDEDataSet_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSelect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDESERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDESERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESARSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESARSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESARSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESARSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncExportModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TempOrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TypeFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEFILTER", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDESARS pSDESARS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDESARS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDESARS pSDESARS) throws Exception {
        super.onUpdateParent(pSDESARS);
    }

    @Override
    protected void exportCurXmlModel(PSDESARS pSDESARS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESARS");
        if (!bl) {
            pSDESARS.setCreateDate(null);
            pSDESARS.setCreateMan(null);
            pSDESARS.setPSDESARSId(null);
            pSDESARS.setUpdateDate(null);
            pSDESARS.setUpdateMan(null);
            super.exportCurXmlModel(pSDESARS, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDESARS pSDESARS, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDESARS, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSSERVICEAPI#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSERVICEAPINAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPI", (boolean)true) == 0) {
            iEntity.set("PSSYSSERVICEAPIID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSSERVICEAPIID"};
    }

    @Override
    public String getModelV2Tag(PSDESARS pSDESARS) {
        if (!StringHelper.isNullOrEmpty((String)pSDESARS.getPSDESARSName())) {
            return pSDESARS.getPSDESARSName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDESARS.getCodeName())) {
            return pSDESARS.getCodeName();
        }
        return super.getModelV2Tag(pSDESARS);
    }

    @Override
    public boolean setModelV2Tag(PSDESARS pSDESARS, String string) {
        pSDESARS.setPSDESARSName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDESARSNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSSERVICEAPIID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDESARS pSDESARS, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDESARS.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDESARS, true);
        pSDESARS.set("PSDESARSNAME", string);
        if (this.select(pSDESARS, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDESARS, true);
        return super.getModelV2Entity(pSDESARS, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDESARS pSDESARS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDESARS, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDESADETAIL_PSDESARS_PSDESARSID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSDESARS pSDESARS, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSDESADETAIL_PSDESARS_PSDESARSID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESARS#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDESADETAIL", (Object)pSDESARS.getPSDESARSId()))).exists()) {
            PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSDESADetailService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSDESADetail pSDESADetail = new PSDESADetail();
                PSModelV2Helper.fromJSONObject((IDataObject)pSDESADetail, objectNode, false);
                String string6 = pSDESADetailService.getModelV2Tag(pSDESADetail);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDESADETAIL", (Object)pSDESADetail.getPSDESADetailId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSDESADetailService.exportModelV2(pSDESADetail, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSDESARS, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDESARS pSDESARS, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDESADETAIL_PSDESARS_PSDESARSID")) {
            PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESARS#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDESADETAIL", (Object)pSDESARS.getPSDESARSId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String detailJson : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)detailJson)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(detailJson));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String resScope = StringHelper.format((String)"PSDESARS#%1$s", (Object)pSDESARS.getPSDESARSId());
                for (PSDESADetail detail : pSDESADetailService.selectByPSDESARS(pSDESARS)) {
                    String detailScope = pSDESADetailService.getModelV2ResScope(detail);
                    if (StringHelper.compare(resScope, detailScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(detail, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode detailsNode = objectNode.putArray(pSDESADetailService.getModelV2Name(false).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdesadetailname")) {
                            string = objectNode.get("psdesadetailname").asText();
                        }
                        if (objectNode2.has("psdesadetailname")) {
                            string2 = objectNode2.get("psdesadetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode detailNode : arrayList) {
                    PSDESADetail detail = new PSDESADetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)detail, detailNode, false);
                    detailsNode.add((JsonNode)pSDESADetailService.exportModelV2(detail, string));
                }
            }
        }
        super.onExportCurModelV2(pSDESARS, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDESARS pSDESARS) throws Exception {
        super.onEmptyModelV2(pSDESARS);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSDESADetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDESARS pSDESARS, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDESADetail pSDESADetail = new PSDESADetail();
        pSDESADetail.set("PSDESARSID", pSDESARS.getPSDESARSId());
        PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDESADetailService.getModelV2Entity(pSDESADetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDESARS, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDESARS pSDESARS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSDESARSServiceBase.isSimpleImportExportMode("")) {
            PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSDESADetailService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSDESADetail pSDESADetail = new PSDESADetail();
                    pSDESADetail.setPSDESARSId(pSDESARS.getPSDESARSId());
                    pSDESADetail.setPSDESARSName(pSDESARS.getPSDESARSName());
                    pSDESADetailService.compileModelV2(pSDESADetail, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSDESADetail pSDESADetail = new PSDESADetail();
                        pSDESADetail.setPSDESARSId(pSDESARS.getPSDESARSId());
                        pSDESADetail.setPSDESARSName(pSDESARS.getPSDESARSName());
                        pSDESADetailService.compileModelV2(pSDESADetail, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDESARS, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDESARS pSDESARS, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSDESARS, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSDESARS pSDESARS, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSDESARS, list);
    }
}

