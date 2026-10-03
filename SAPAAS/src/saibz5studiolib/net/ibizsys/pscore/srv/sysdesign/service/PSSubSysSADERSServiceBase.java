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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADERSDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADERSDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADERS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSADERSServiceBase
extends PSCoreSysServiceBase<PSSubSysSADERS> {
    private static final Log log = LogFactory.getLog(PSSubSysSADERSServiceBase.class);
    public static final String DATASET_CURSA = "CurSA";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSubSysSADERSDEModel pSSubSysSADERSDEModel;
    private PSSubSysSADERSDAO pSSubSysSADERSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADERSService";
    }

    public PSSubSysSADERSDEModel getPSSubSysSADERSDEModel() {
        if (this.pSSubSysSADERSDEModel == null) {
            try {
                this.pSSubSysSADERSDEModel = (PSSubSysSADERSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADERSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADERSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubSysSADERSDEModel();
    }

    public PSSubSysSADERSDAO getPSSubSysSADERSDAO() {
        if (this.pSSubSysSADERSDAO == null) {
            try {
                this.pSSubSysSADERSDAO = (PSSubSysSADERSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADERSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADERSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubSysSADERSDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSA, (boolean)true) == 0) {
            return this.fetchCurSA(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSA(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSA, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSubSysSADERS pSSubSysSADERS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADERS_PSSUBSYSSADE_CPSSUBSYSSADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = (PSSubSysSADE)iService.getDEModel().createEntity();
            pSSubSysSADE.set("PSSUBSYSSADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSysSADE);
            } else {
                iService.get(pSSubSysSADE);
            }
            this.onFillParentInfo_CPSSubSysSADE(pSSubSysSADERS, pSSubSysSADE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADERS_PSSUBSYSSADE_PPSSUBSYSSADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = (PSSubSysSADE)iService.getDEModel().createEntity();
            pSSubSysSADE.set("PSSUBSYSSADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSysSADE);
            } else {
                iService.get(pSSubSysSADE);
            }
            this.onFillParentInfo_PPSSubSysSADE(pSSubSysSADERS, pSSubSysSADE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSubSysServiceAPI pSSubSysServiceAPI = (PSSubSysServiceAPI)iService.getDEModel().createEntity();
            pSSubSysServiceAPI.set("PSSUBSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSysServiceAPI);
            } else {
                iService.get(pSSubSysServiceAPI);
            }
            this.onFillParentInfo_PSSubSysServiceAPI(pSSubSysSADERS, pSSubSysServiceAPI);
            return;
        }
        super.onFillParentInfo(pSSubSysSADERS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_CPSSubSysSADE(PSSubSysSADERS pSSubSysSADERS, PSSubSysSADE pSSubSysSADE) throws Exception {
        pSSubSysSADERS.setCPSSubSysSADEId(pSSubSysSADE.getPSSubSysSADEId());
        pSSubSysSADERS.setCPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
    }

    protected void onFillParentInfo_PPSSubSysSADE(PSSubSysSADERS pSSubSysSADERS, PSSubSysSADE pSSubSysSADE) throws Exception {
        pSSubSysSADERS.setPPSSubSysSADEId(pSSubSysSADE.getPSSubSysSADEId());
        pSSubSysSADERS.setPPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
    }

    protected void onFillParentInfo_PSSubSysServiceAPI(PSSubSysSADERS pSSubSysSADERS, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        pSSubSysSADERS.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSSubSysSADERS.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
    }

    protected void onFillEntityFullInfo(PSSubSysSADERS pSSubSysSADERS, boolean bl) throws Exception {
        if (bl && pSSubSysSADERS.getValidFlag() == null) {
            pSSubSysSADERS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSubSysSADERS, bl);
        this.onFillEntityFullInfo_CPSSubSysSADE(pSSubSysSADERS, bl);
        this.onFillEntityFullInfo_PPSSubSysSADE(pSSubSysSADERS, bl);
        this.onFillEntityFullInfo_PSSubSysServiceAPI(pSSubSysSADERS, bl);
    }

    protected void onFillEntityFullInfo_CPSSubSysSADE(PSSubSysSADERS pSSubSysSADERS, boolean bl) throws Exception {
        if (pSSubSysSADERS.isCPSSubSysSADEIdDirty()) {
            if (pSSubSysSADERS.getCPSSubSysSADEId() != null) {
                if (pSSubSysSADERS.getCPSSubSysSADEId() == null || pSSubSysSADERS.getCPSSubSysSADEName() == null) {
                    PSSubSysSADE pSSubSysSADE = pSSubSysSADERS.getCPSSubSysSADE();
                    pSSubSysSADERS.setCPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
                }
            } else {
                pSSubSysSADERS.setCPSSubSysSADEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSSubSysSADE(PSSubSysSADERS pSSubSysSADERS, boolean bl) throws Exception {
        if (pSSubSysSADERS.isPPSSubSysSADEIdDirty()) {
            if (pSSubSysSADERS.getPPSSubSysSADEId() != null) {
                if (pSSubSysSADERS.getPPSSubSysSADEId() == null || pSSubSysSADERS.getPPSSubSysSADEName() == null) {
                    PSSubSysSADE pSSubSysSADE = pSSubSysSADERS.getPPSSubSysSADE();
                    pSSubSysSADERS.setPPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
                }
            } else {
                pSSubSysSADERS.setPPSSubSysSADEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubSysServiceAPI(PSSubSysSADERS pSSubSysSADERS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSubSysSADERS pSSubSysSADERS, boolean bl) throws Exception {
        super.onWriteBackParent(pSSubSysSADERS, bl);
    }

    public ArrayList<PSSubSysSADERS> selectByCPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase) throws Exception {
        return this.selectByCPSSubSysSADE(pSSubSysSADEBase, "", -1);
    }

    public ArrayList<PSSubSysSADERS> selectByCPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string) throws Exception {
        return this.selectByCPSSubSysSADE(pSSubSysSADEBase, string, -1);
    }

    public ArrayList<PSSubSysSADERS> selectByCPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CPSSUBSYSSADEID", (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCPSSubSysSADECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCPSSubSysSADECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADERS> selectByPPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase) throws Exception {
        return this.selectByPPSSubSysSADE(pSSubSysSADEBase, "", -1);
    }

    public ArrayList<PSSubSysSADERS> selectByPPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string) throws Exception {
        return this.selectByPPSSubSysSADE(pSSubSysSADEBase, string, -1);
    }

    public ArrayList<PSSubSysSADERS> selectByPPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSUBSYSSADEID", (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSubSysSADECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSubSysSADECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADERS> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSubSysSADERS> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSubSysSADERS> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSERVICEAPIID", (Object)pSSubSysServiceAPIBase.getPSSubSysServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByCPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    public void resetCPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADERS> arrayList = this.selectByCPSSubSysSADE(pSSubSysSADE);
        for (PSSubSysSADERS pSSubSysSADERS : arrayList) {
            PSSubSysSADERS pSSubSysSADERS2 = (PSSubSysSADERS)this.getDEModel().createEntity();
            pSSubSysSADERS2.setPSSubSysSADERSId(pSSubSysSADERS.getPSSubSysSADERSId());
            pSSubSysSADERS2.setCPSSubSysSADEId(null);
            this.update(pSSubSysSADERS2);
        }
    }

    public void removeByCPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        final PSSubSysSADE pSSubSysSADE2 = pSSubSysSADE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADERSServiceBase.this.onBeforeRemoveByCPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADERSServiceBase.this.internalRemoveByCPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADERSServiceBase.this.onAfterRemoveByCPSSubSysSADE(pSSubSysSADE2);
            }
        });
    }

    protected void onBeforeRemoveByCPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void internalRemoveByCPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADERS> arrayList = this.selectByCPSSubSysSADE(pSSubSysSADE);
        this.onBeforeRemoveByCPSSubSysSADE(pSSubSysSADE, arrayList);
        for (PSSubSysSADERS pSSubSysSADERS : arrayList) {
            this.remove(pSSubSysSADERS);
        }
        this.onAfterRemoveByCPSSubSysSADE(pSSubSysSADE, arrayList);
    }

    protected void onAfterRemoveByCPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void onBeforeRemoveByCPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADERS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADERS> arrayList) throws Exception {
    }

    public void testRemoveByPPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADERS> arrayList = this.selectByPPSSubSysSADE(pSSubSysSADE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubSysSADE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADERS_PSSUBSYSSADE_PPSSUBSYSSADEID", "", iDataEntityModel.getName(), "PSSUBSYSSADERS", iDataEntityModel.getDataInfo(pSSubSysSADE), arrayList.get(0)));
        }
    }

    public void resetPPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADERS> arrayList = this.selectByPPSSubSysSADE(pSSubSysSADE);
        for (PSSubSysSADERS pSSubSysSADERS : arrayList) {
            PSSubSysSADERS pSSubSysSADERS2 = (PSSubSysSADERS)this.getDEModel().createEntity();
            pSSubSysSADERS2.setPSSubSysSADERSId(pSSubSysSADERS.getPSSubSysSADERSId());
            pSSubSysSADERS2.setPPSSubSysSADEId(null);
            this.update(pSSubSysSADERS2);
        }
    }

    public void removeByPPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        final PSSubSysSADE pSSubSysSADE2 = pSSubSysSADE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADERSServiceBase.this.onBeforeRemoveByPPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADERSServiceBase.this.internalRemoveByPPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADERSServiceBase.this.onAfterRemoveByPPSSubSysSADE(pSSubSysSADE2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void internalRemoveByPPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADERS> arrayList = this.selectByPPSSubSysSADE(pSSubSysSADE);
        this.onBeforeRemoveByPPSSubSysSADE(pSSubSysSADE, arrayList);
        for (PSSubSysSADERS pSSubSysSADERS : arrayList) {
            this.remove(pSSubSysSADERS);
        }
        this.onAfterRemoveByPPSSubSysSADE(pSSubSysSADE, arrayList);
    }

    protected void onAfterRemoveByPPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void onBeforeRemoveByPPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADERS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADERS> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSubSysSADERS> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSSUBSYSSADERS", iDataEntityModel.getDataInfo(pSSubSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSubSysSADERS> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        for (PSSubSysSADERS pSSubSysSADERS : arrayList) {
            PSSubSysSADERS pSSubSysSADERS2 = (PSSubSysSADERS)this.getDEModel().createEntity();
            pSSubSysSADERS2.setPSSubSysSADERSId(pSSubSysSADERS.getPSSubSysSADERSId());
            pSSubSysSADERS2.setPSSubSysServiceAPIId(null);
            this.update(pSSubSysSADERS2);
        }
    }

    public void removeByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADERSServiceBase.this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSubSysSADERSServiceBase.this.internalRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSubSysSADERSServiceBase.this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSubSysSADERS> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
        for (PSSubSysSADERS pSSubSysSADERS : arrayList) {
            this.remove(pSSubSysSADERS);
        }
        this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSubSysSADERS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSubSysSADERS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubSysSADERS pSSubSysSADERS) throws Exception {
        super.onBeforeRemove(pSSubSysSADERS);
    }

    protected void replaceParentInfo(PSSubSysSADERS pSSubSysSADERS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSubSysSADERS, cloneSession);
        if (pSSubSysSADERS.getCPSSubSysSADEId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADE", (Object)pSSubSysSADERS.getCPSSubSysSADEId())) != null) {
            this.onFillParentInfo_CPSSubSysSADE(pSSubSysSADERS, (PSSubSysSADE)iEntity);
        }
        if (pSSubSysSADERS.getPPSSubSysSADEId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADE", (Object)pSSubSysSADERS.getPPSSubSysSADEId())) != null) {
            this.onFillParentInfo_PPSSubSysSADE(pSSubSysSADERS, (PSSubSysSADE)iEntity);
        }
        if (pSSubSysSADERS.getPSSubSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSERVICEAPI", (Object)pSSubSysSADERS.getPSSubSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSubSysServiceAPI(pSSubSysSADERS, (PSSubSysServiceAPI)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubSysSADERS pSSubSysSADERS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSubSysSADERS, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArrayFlag(bl, pSSubSysSADERS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChildFilter(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CPSSubSysSADEId(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CPSSubSysSADEName(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSubSysSADEId(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSubSysSADEName(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADERSId(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADERSName(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIId(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag2(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeFilter(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSubSysSADERS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSubSysSADERS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArrayFlag(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isArrayFlagDirty() : !pSSubSysSADERS.isArrayFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysSADERS.getArrayFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArrayFlag_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ChildFilter(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isChildFilterDirty() : !pSSubSysSADERS.isChildFilterDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getChildFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChildFilter_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isCodeNameDirty() : !pSSubSysSADERS.isCodeNameDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSubSysSADERS, bl2, bl3);
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
                string3 = "PPSSUBSYSSADEID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADERSDEModel(), "CODENAME", string3, pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isCodeName2Dirty() : !pSSubSysSADERS.isCodeName2Dirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSSubSysSADERS, bl2, bl3);
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
                string3 = "PPSSUBSYSSADEID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADERSDEModel(), "CODENAME2", string3, pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_CPSSubSysSADEId(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isCPSSubSysSADEIdDirty() && !bl2 : !pSSubSysSADERS.isCPSSubSysSADEIdDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getCPSSubSysSADEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSSUBSYSSADEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CPSSubSysSADEId_Default(pSSubSysSADERS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSSUBSYSSADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PPSSUBSYSSADEID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADERSDEModel(), "CPSSUBSYSSADEID", string3, pSSubSysSADERS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CPSSUBSYSSADEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CPSSubSysSADEName(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isCPSSubSysSADENameDirty() && !bl2 : !pSSubSysSADERS.isCPSSubSysSADENameDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getCPSSubSysSADEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSSUBSYSSADENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CPSSubSysSADEName_Default(pSSubSysSADERS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSSUBSYSSADENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isMemoDirty() : !pSSubSysSADERS.isMemoDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isOrderValueDirty() : !pSSubSysSADERS.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSubSysSADERS.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSubSysSADEId(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isPPSSubSysSADEIdDirty() && !bl2 : !pSSubSysSADERS.isPPSSubSysSADEIdDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getPPSSubSysSADEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSUBSYSSADEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSubSysSADEId_Default(pSSubSysSADERS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSUBSYSSADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSubSysSADEName(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isPPSSubSysSADENameDirty() && !bl2 : !pSSubSysSADERS.isPPSSubSysSADENameDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getPPSSubSysSADEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSUBSYSSADENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSubSysSADEName_Default(pSSubSysSADERS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSUBSYSSADENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADERSId(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isPSSubSysSADERSIdDirty() && !bl2 : !pSSubSysSADERS.isPSSubSysSADERSIdDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getPSSubSysSADERSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADERSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADERSId_Default(pSSubSysSADERS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADERSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADERSName(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isPSSubSysSADERSNameDirty() && !bl2 : !pSSubSysSADERS.isPSSubSysSADERSNameDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getPSSubSysSADERSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADERSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADERSName_Default(pSSubSysSADERS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADERSNAME");
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
                string3 = "PSSUBSYSSERVICEAPIID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADERSDEModel(), "PSSUBSYSSADERSNAME", string3, pSSubSysSADERS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSUBSYSSADERSNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysServiceAPIId(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isPSSubSysServiceAPIIdDirty() && !bl2 : !pSSubSysSADERS.isPSSubSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getPSSubSysServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIId_Default(pSSubSysSADERS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSTag(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isRSTagDirty() : !pSSubSysSADERS.isRSTagDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getRSTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag_Default(pSSubSysSADERS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSTag2(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isRSTag2Dirty() : !pSSubSysSADERS.isRSTag2Dirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getRSTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag2_Default(pSSubSysSADERS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeFilter(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isTypeFilterDirty() : !pSSubSysSADERS.isTypeFilterDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getTypeFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeFilter_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isUserCatDirty() : !pSSubSysSADERS.isUserCatDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isUserTagDirty() : !pSSubSysSADERS.isUserTagDirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isUserTag2Dirty() : !pSSubSysSADERS.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isUserTag3Dirty() : !pSSubSysSADERS.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isUserTag4Dirty() : !pSSubSysSADERS.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSubSysSADERS.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSubSysSADERS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSubSysSADERS pSSubSysSADERS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADERS.isValidFlagDirty() && !bl2 : !pSSubSysSADERS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysSADERS.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSubSysSADERS, bl2, bl3);
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

    protected void onSyncEntity(PSSubSysSADERS pSSubSysSADERS, boolean bl) throws Exception {
        super.onSyncEntity(pSSubSysSADERS, bl);
    }

    protected void onSyncIndexEntities(PSSubSysSADERS pSSubSysSADERS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSubSysSADERS, bl);
    }

    public Object getDataContextValue(PSSubSysSADERS pSSubSysSADERS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSubSysSADERS, string, iDataContextParam)) != null) {
            return object;
        }
        PSSubSysServiceAPI pSSubSysServiceAPI = pSSubSysSADERS.getPSSubSysServiceAPI();
        if (pSSubSysServiceAPI != null && pSSubSysServiceAPI.contains(string)) {
            return pSSubSysServiceAPI.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSubSysSADERS pSSubSysSADERS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSubSysSADERS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
        if (StringHelper.compare((String)string, (String)"CPSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPSSUBSYSSADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSSubSysSADEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PPSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSUBSYSSADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSubSysSADEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADERSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADERSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADERSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADERSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag2_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_CPSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPSSubSysSADEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSSUBSYSSADENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_PPSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSubSysSADEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSUBSYSSADENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADERSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADERSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADERSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADERSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected boolean onMergeChild(String string, String string2, PSSubSysSADERS pSSubSysSADERS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSubSysSADERS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubSysSADERS pSSubSysSADERS) throws Exception {
        super.onUpdateParent(pSSubSysSADERS);
    }

    @Override
    protected void exportCurXmlModel(PSSubSysSADERS pSSubSysSADERS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBSYSSADERS");
        if (!bl) {
            pSSubSysSADERS.setCreateDate(null);
            pSSubSysSADERS.setCreateMan(null);
            pSSubSysSADERS.setPSSubSysSADERSId(null);
            pSSubSysSADERS.setUpdateDate(null);
            pSSubSysSADERS.setUpdateMan(null);
            super.exportCurXmlModel(pSSubSysSADERS, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSubSysSADERS pSSubSysSADERS, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSubSysSADERS, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSUBSYSSERVICEAPI#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSERVICEAPINAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPI", (boolean)true) == 0) {
            iEntity.set("PSSUBSYSSERVICEAPIID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSUBSYSSERVICEAPIID"};
    }

    @Override
    public String getModelV2Tag(PSSubSysSADERS pSSubSysSADERS) {
        if (!StringHelper.isNullOrEmpty((String)pSSubSysSADERS.getPSSubSysSADERSName())) {
            return pSSubSysSADERS.getPSSubSysSADERSName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSubSysSADERS.getCodeName())) {
            return pSSubSysSADERS.getCodeName();
        }
        return super.getModelV2Tag(pSSubSysSADERS);
    }

    @Override
    public boolean setModelV2Tag(PSSubSysSADERS pSSubSysSADERS, String string) {
        pSSubSysSADERS.setPSSubSysSADERSName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSUBSYSSADERSNAME", "");
        map.put("CODENAME", "");
        map.put("PSSUBSYSSERVICEAPIID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSubSysSADERS pSSubSysSADERS, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSubSysSADERS.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSubSysSADERS, true);
        pSSubSysSADERS.set("PSSUBSYSSADERSNAME", string);
        if (this.select(pSSubSysSADERS, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSubSysSADERS, true);
        return super.getModelV2Entity(pSSubSysSADERS, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSubSysSADERS pSSubSysSADERS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSubSysSADERS, objectNode, string, string2, n);
    }
}

