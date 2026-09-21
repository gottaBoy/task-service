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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysUserCaseRSDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserCaseRSDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActor;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActorBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseRS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUserCaseRSServiceBase
extends PSCoreSysServiceBase<PSSysUserCaseRS> {
    private static final Log log = LogFactory.getLog(PSSysUserCaseRSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysUserCaseRSDEModel pSSysUserCaseRSDEModel;
    private PSSysUserCaseRSDAO pSSysUserCaseRSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseRSService";
    }

    public PSSysUserCaseRSDEModel getPSSysUserCaseRSDEModel() {
        if (this.pSSysUserCaseRSDEModel == null) {
            try {
                this.pSSysUserCaseRSDEModel = (PSSysUserCaseRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserCaseRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUserCaseRSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysUserCaseRSDEModel();
    }

    public PSSysUserCaseRSDAO getPSSysUserCaseRSDAO() {
        if (this.pSSysUserCaseRSDAO == null) {
            try {
                this.pSSysUserCaseRSDAO = (PSSysUserCaseRSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysUserCaseRSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUserCaseRSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysUserCaseRSDAO();
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

    protected void onFillParentInfo(PSSysUserCaseRS pSSysUserCaseRS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERCASERS_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysUserCaseRS, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERCASERS_PSSYSACTOR_PPSSYSACTORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService", (SessionFactory)this.getSessionFactory());
            PSSysActor pSSysActor = (PSSysActor)iService.getDEModel().createEntity();
            pSSysActor.set("PSSYSACTORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysActor);
            } else {
                iService.get((IEntity)pSSysActor);
            }
            this.onFillParentInfo_PPSSysActor(pSSysUserCaseRS, pSSysActor);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERCASERS_PSSYSACTOR_PSSYSACTORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService", (SessionFactory)this.getSessionFactory());
            PSSysActor pSSysActor = (PSSysActor)iService.getDEModel().createEntity();
            pSSysActor.set("PSSYSACTORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysActor);
            } else {
                iService.get((IEntity)pSSysActor);
            }
            this.onFillParentInfo_PSSysActor(pSSysUserCaseRS, pSSysActor);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERCASERS_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysUserCaseRS, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERCASERS_PSSYSUSERCASE_PPSSYSUSERCASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService", (SessionFactory)this.getSessionFactory());
            PSSysUserCase pSSysUserCase = (PSSysUserCase)iService.getDEModel().createEntity();
            pSSysUserCase.set("PSSYSUSERCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUserCase);
            } else {
                iService.get((IEntity)pSSysUserCase);
            }
            this.onFillParentInfo_PPSSysUserCase(pSSysUserCaseRS, pSSysUserCase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERCASERS_PSSYSUSERCASE_PSSYSUSERCASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService", (SessionFactory)this.getSessionFactory());
            PSSysUserCase pSSysUserCase = (PSSysUserCase)iService.getDEModel().createEntity();
            pSSysUserCase.set("PSSYSUSERCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUserCase);
            } else {
                iService.get((IEntity)pSSysUserCase);
            }
            this.onFillParentInfo_PSSysUserCase(pSSysUserCaseRS, pSSysUserCase);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysUserCaseRS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysUserCaseRS pSSysUserCaseRS, PSModule pSModule) throws Exception {
        pSSysUserCaseRS.setPSModuleId(pSModule.getPSModuleId());
        pSSysUserCaseRS.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PPSSysActor(PSSysUserCaseRS pSSysUserCaseRS, PSSysActor pSSysActor) throws Exception {
        pSSysUserCaseRS.setPPSSysActorId(pSSysActor.getPSSysActorId());
        pSSysUserCaseRS.setPPSSysActorName(pSSysActor.getPSSysActorName());
    }

    protected void onFillParentInfo_PSSysActor(PSSysUserCaseRS pSSysUserCaseRS, PSSysActor pSSysActor) throws Exception {
        pSSysUserCaseRS.setPSSysActorId(pSSysActor.getPSSysActorId());
        pSSysUserCaseRS.setPSSysActorName(pSSysActor.getPSSysActorName());
    }

    protected void onFillParentInfo_PSSystem(PSSysUserCaseRS pSSysUserCaseRS, PSSystem pSSystem) throws Exception {
        pSSysUserCaseRS.setPSSystemId(pSSystem.getPSSystemId());
        pSSysUserCaseRS.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PPSSysUserCase(PSSysUserCaseRS pSSysUserCaseRS, PSSysUserCase pSSysUserCase) throws Exception {
        pSSysUserCaseRS.setPPSSysUserCaseId(pSSysUserCase.getPSSysUserCaseId());
        pSSysUserCaseRS.setPPSSysUserCaseName(pSSysUserCase.getPSSysUserCaseName());
    }

    protected void onFillParentInfo_PSSysUserCase(PSSysUserCaseRS pSSysUserCaseRS, PSSysUserCase pSSysUserCase) throws Exception {
        pSSysUserCaseRS.setPSSysUserCaseId(pSSysUserCase.getPSSysUserCaseId());
        pSSysUserCaseRS.setPSSysUserCaseName(pSSysUserCase.getPSSysUserCaseName());
    }

    protected void onFillEntityFullInfo(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
        if (bl) {
            if (pSSysUserCaseRS.getOrderValue() == null) {
                pSSysUserCaseRS.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "1000", 9));
            }
            if (pSSysUserCaseRS.getValidFlag() == null) {
                pSSysUserCaseRS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysUserCaseRS, bl);
        this.onFillEntityFullInfo_PSModule(pSSysUserCaseRS, bl);
        this.onFillEntityFullInfo_PPSSysActor(pSSysUserCaseRS, bl);
        this.onFillEntityFullInfo_PSSysActor(pSSysUserCaseRS, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysUserCaseRS, bl);
        this.onFillEntityFullInfo_PPSSysUserCase(pSSysUserCaseRS, bl);
        this.onFillEntityFullInfo_PSSysUserCase(pSSysUserCaseRS, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSysActor(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysActor(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
        if (pSSysUserCaseRS.isPSSystemIdDirty()) {
            if (pSSysUserCaseRS.getPSSystemId() != null) {
                if (pSSysUserCaseRS.getPSSystemId() == null || pSSysUserCaseRS.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysUserCaseRS.getPSSystem();
                    pSSysUserCaseRS.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysUserCaseRS.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSSysUserCase(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserCase(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysUserCaseRS, bl);
    }

    public ArrayList<PSSysUserCaseRS> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserCaseRS> selectByPPSSysActor(PSSysActorBase pSSysActorBase) throws Exception {
        return this.selectByPPSSysActor(pSSysActorBase, "", -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPPSSysActor(PSSysActorBase pSSysActorBase, String string) throws Exception {
        return this.selectByPPSSysActor(pSSysActorBase, string, -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPPSSysActor(PSSysActorBase pSSysActorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSACTORID", (Object)pSSysActorBase.getPSSysActorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysActorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysActorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserCaseRS> selectByPSSysActor(PSSysActorBase pSSysActorBase) throws Exception {
        return this.selectByPSSysActor(pSSysActorBase, "", -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPSSysActor(PSSysActorBase pSSysActorBase, String string) throws Exception {
        return this.selectByPSSysActor(pSSysActorBase, string, -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPSSysActor(PSSysActorBase pSSysActorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSACTORID", (Object)pSSysActorBase.getPSSysActorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysActorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysActorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserCaseRS> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserCaseRS> selectByPPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase) throws Exception {
        return this.selectByPPSSysUserCase(pSSysUserCaseBase, "", -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string) throws Exception {
        return this.selectByPPSSysUserCase(pSSysUserCaseBase, string, -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSUSERCASEID", (Object)pSSysUserCaseBase.getPSSysUserCaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysUserCaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysUserCaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserCaseRS> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, "", -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, string, -1);
    }

    public ArrayList<PSSysUserCaseRS> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERCASEID", (Object)pSSysUserCaseBase.getPSSysUserCaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserCaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserCaseCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSERCASERS_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSUSERCASERS", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSModule(pSModule);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            PSSysUserCaseRS pSSysUserCaseRS2 = (PSSysUserCaseRS)this.getDEModel().createEntity();
            pSSysUserCaseRS2.setPSSysUserCaseRSId(pSSysUserCaseRS.getPSSysUserCaseRSId());
            pSSysUserCaseRS2.setPSModuleId(null);
            this.update(pSSysUserCaseRS2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserCaseRSServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysUserCaseRSServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysUserCaseRSServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            this.remove((IEntity)pSSysUserCaseRS);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPPSSysActor(pSSysActor, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSACTOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysActor);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSERCASERS_PSSYSACTOR_PPSSYSACTORID", "", iDataEntityModel.getName(), "PSSYSUSERCASERS", iDataEntityModel.getDataInfo((IEntity)pSSysActor), arrayList.get(0)));
        }
    }

    public void resetPPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPPSSysActor(pSSysActor);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            PSSysUserCaseRS pSSysUserCaseRS2 = (PSSysUserCaseRS)this.getDEModel().createEntity();
            pSSysUserCaseRS2.setPSSysUserCaseRSId(pSSysUserCaseRS.getPSSysUserCaseRSId());
            pSSysUserCaseRS2.setPPSSysActorId(null);
            this.update(pSSysUserCaseRS2);
        }
    }

    public void removeByPPSSysActor(PSSysActor pSSysActor) throws Exception {
        final PSSysActor pSSysActor2 = pSSysActor;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserCaseRSServiceBase.this.onBeforeRemoveByPPSSysActor(pSSysActor2);
                PSSysUserCaseRSServiceBase.this.internalRemoveByPPSSysActor(pSSysActor2);
                PSSysUserCaseRSServiceBase.this.onAfterRemoveByPPSSysActor(pSSysActor2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysActor(PSSysActor pSSysActor) throws Exception {
    }

    protected void internalRemoveByPPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPPSSysActor(pSSysActor);
        this.onBeforeRemoveByPPSSysActor(pSSysActor, arrayList);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            this.remove((IEntity)pSSysUserCaseRS);
        }
        this.onAfterRemoveByPPSSysActor(pSSysActor, arrayList);
    }

    protected void onAfterRemoveByPPSSysActor(PSSysActor pSSysActor) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysActor(PSSysActor pSSysActor, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysActor(PSSysActor pSSysActor, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    public void testRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSSysActor(pSSysActor, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSACTOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysActor);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSERCASERS_PSSYSACTOR_PSSYSACTORID", "", iDataEntityModel.getName(), "PSSYSUSERCASERS", iDataEntityModel.getDataInfo((IEntity)pSSysActor), arrayList.get(0)));
        }
    }

    public void resetPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSSysActor(pSSysActor);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            PSSysUserCaseRS pSSysUserCaseRS2 = (PSSysUserCaseRS)this.getDEModel().createEntity();
            pSSysUserCaseRS2.setPSSysUserCaseRSId(pSSysUserCaseRS.getPSSysUserCaseRSId());
            pSSysUserCaseRS2.setPSSysActorId(null);
            this.update(pSSysUserCaseRS2);
        }
    }

    public void removeByPSSysActor(PSSysActor pSSysActor) throws Exception {
        final PSSysActor pSSysActor2 = pSSysActor;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserCaseRSServiceBase.this.onBeforeRemoveByPSSysActor(pSSysActor2);
                PSSysUserCaseRSServiceBase.this.internalRemoveByPSSysActor(pSSysActor2);
                PSSysUserCaseRSServiceBase.this.onAfterRemoveByPSSysActor(pSSysActor2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
    }

    protected void internalRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSSysActor(pSSysActor);
        this.onBeforeRemoveByPSSysActor(pSSysActor, arrayList);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            this.remove((IEntity)pSSysUserCaseRS);
        }
        this.onAfterRemoveByPSSysActor(pSSysActor, arrayList);
    }

    protected void onAfterRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
    }

    protected void onBeforeRemoveByPSSysActor(PSSysActor pSSysActor, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysActor(PSSysActor pSSysActor, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            PSSysUserCaseRS pSSysUserCaseRS2 = (PSSysUserCaseRS)this.getDEModel().createEntity();
            pSSysUserCaseRS2.setPSSysUserCaseRSId(pSSysUserCaseRS.getPSSysUserCaseRSId());
            pSSysUserCaseRS2.setPSSystemId(null);
            this.update(pSSysUserCaseRS2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserCaseRSServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysUserCaseRSServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysUserCaseRSServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            this.remove((IEntity)pSSysUserCaseRS);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPPSSysUserCase(pSSysUserCase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERCASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUserCase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSERCASERS_PSSYSUSERCASE_PPSSYSUSERCASEID", "", iDataEntityModel.getName(), "PSSYSUSERCASERS", iDataEntityModel.getDataInfo((IEntity)pSSysUserCase), arrayList.get(0)));
        }
    }

    public void resetPPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPPSSysUserCase(pSSysUserCase);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            PSSysUserCaseRS pSSysUserCaseRS2 = (PSSysUserCaseRS)this.getDEModel().createEntity();
            pSSysUserCaseRS2.setPSSysUserCaseRSId(pSSysUserCaseRS.getPSSysUserCaseRSId());
            pSSysUserCaseRS2.setPPSSysUserCaseId(null);
            this.update(pSSysUserCaseRS2);
        }
    }

    public void removeByPPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        final PSSysUserCase pSSysUserCase2 = pSSysUserCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserCaseRSServiceBase.this.onBeforeRemoveByPPSSysUserCase(pSSysUserCase2);
                PSSysUserCaseRSServiceBase.this.internalRemoveByPPSSysUserCase(pSSysUserCase2);
                PSSysUserCaseRSServiceBase.this.onAfterRemoveByPPSSysUserCase(pSSysUserCase2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void internalRemoveByPPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPPSSysUserCase(pSSysUserCase);
        this.onBeforeRemoveByPPSSysUserCase(pSSysUserCase, arrayList);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            this.remove((IEntity)pSSysUserCaseRS);
        }
        this.onAfterRemoveByPPSSysUserCase(pSSysUserCase, arrayList);
    }

    protected void onAfterRemoveByPPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSSysUserCase(pSSysUserCase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERCASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUserCase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSERCASERS_PSSYSUSERCASE_PSSYSUSERCASEID", "", iDataEntityModel.getName(), "PSSYSUSERCASERS", iDataEntityModel.getDataInfo((IEntity)pSSysUserCase), arrayList.get(0)));
        }
    }

    public void resetPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            PSSysUserCaseRS pSSysUserCaseRS2 = (PSSysUserCaseRS)this.getDEModel().createEntity();
            pSSysUserCaseRS2.setPSSysUserCaseRSId(pSSysUserCaseRS.getPSSysUserCaseRSId());
            pSSysUserCaseRS2.setPSSysUserCaseId(null);
            this.update(pSSysUserCaseRS2);
        }
    }

    public void removeByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        final PSSysUserCase pSSysUserCase2 = pSSysUserCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserCaseRSServiceBase.this.onBeforeRemoveByPSSysUserCase(pSSysUserCase2);
                PSSysUserCaseRSServiceBase.this.internalRemoveByPSSysUserCase(pSSysUserCase2);
                PSSysUserCaseRSServiceBase.this.onAfterRemoveByPSSysUserCase(pSSysUserCase2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void internalRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysUserCaseRS> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        this.onBeforeRemoveByPSSysUserCase(pSSysUserCase, arrayList);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList) {
            this.remove((IEntity)pSSysUserCaseRS);
        }
        this.onAfterRemoveByPSSysUserCase(pSSysUserCase, arrayList);
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysUserCaseRS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysUserCaseRS pSSysUserCaseRS) throws Exception {
        super.onBeforeRemove(pSSysUserCaseRS);
    }

    protected void replaceParentInfo(PSSysUserCaseRS pSSysUserCaseRS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysUserCaseRS, cloneSession);
        if (pSSysUserCaseRS.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysUserCaseRS.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysUserCaseRS, (PSModule)iEntity);
        }
        if (pSSysUserCaseRS.getPPSSysActorId() != null && (iEntity = cloneSession.getEntity("PSSYSACTOR", (Object)pSSysUserCaseRS.getPPSSysActorId())) != null) {
            this.onFillParentInfo_PPSSysActor(pSSysUserCaseRS, (PSSysActor)iEntity);
        }
        if (pSSysUserCaseRS.getPSSysActorId() != null && (iEntity = cloneSession.getEntity("PSSYSACTOR", (Object)pSSysUserCaseRS.getPSSysActorId())) != null) {
            this.onFillParentInfo_PSSysActor(pSSysUserCaseRS, (PSSysActor)iEntity);
        }
        if (pSSysUserCaseRS.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysUserCaseRS.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysUserCaseRS, (PSSystem)iEntity);
        }
        if (pSSysUserCaseRS.getPPSSysUserCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERCASE", (Object)pSSysUserCaseRS.getPPSSysUserCaseId())) != null) {
            this.onFillParentInfo_PPSSysUserCase(pSSysUserCaseRS, (PSSysUserCase)iEntity);
        }
        if (pSSysUserCaseRS.getPSSysUserCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERCASE", (Object)pSSysUserCaseRS.getPSSysUserCaseId())) != null) {
            this.onFillParentInfo_PSSysUserCase(pSSysUserCaseRS, (PSSysUserCase)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysUserCaseRS, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysUserCaseRS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Color(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysActorId(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysUserCaseId(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysActorId(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserCaseId(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserCaseRSId(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserCaseRSName(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSMode(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag2(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag3(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag4(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSType(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tags(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysUserCaseRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysUserCaseRS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isCodeNameDirty() : !pSSysUserCaseRS.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSSysUserCaseRSDEModel(), "CODENAME", string3, pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_Color(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isColorDirty() : !pSSysUserCaseRS.isColorDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isContentDirty() : !pSSysUserCaseRS.isContentDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isMemoDirty() : !pSSysUserCaseRS.isMemoDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isOrderValueDirty() : !pSSysUserCaseRS.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysUserCaseRS.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysActorId(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isPPSSysActorIdDirty() : !pSSysUserCaseRS.isPPSSysActorIdDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getPPSSysActorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysActorId_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSACTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysUserCaseId(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isPPSSysUserCaseIdDirty() : !pSSysUserCaseRS.isPPSSysUserCaseIdDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getPPSSysUserCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysUserCaseId_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSUSERCASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isPSModuleIdDirty() : !pSSysUserCaseRS.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysActorId(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isPSSysActorIdDirty() : !pSSysUserCaseRS.isPSSysActorIdDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getPSSysActorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysActorId_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSACTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isPSSystemIdDirty() : !pSSysUserCaseRS.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isPSSystemNameDirty() : !pSSysUserCaseRS.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserCaseId(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isPSSysUserCaseIdDirty() : !pSSysUserCaseRS.isPSSysUserCaseIdDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getPSSysUserCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserCaseId_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERCASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserCaseRSId(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isPSSysUserCaseRSIdDirty() && !bl2 : !pSSysUserCaseRS.isPSSysUserCaseRSIdDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getPSSysUserCaseRSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERCASERSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserCaseRSId_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERCASERSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserCaseRSName(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isPSSysUserCaseRSNameDirty() && !bl2 : !pSSysUserCaseRS.isPSSysUserCaseRSNameDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getPSSysUserCaseRSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERCASERSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserCaseRSName_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERCASERSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSMode(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isRSModeDirty() && !bl2 : !pSSysUserCaseRS.isRSModeDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getRSMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSMode_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSTag(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isRSTagDirty() : !pSSysUserCaseRS.isRSTagDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getRSTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_RSTag2(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isRSTag2Dirty() : !pSSysUserCaseRS.isRSTag2Dirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getRSTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag2_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_RSTag3(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isRSTag3Dirty() : !pSSysUserCaseRS.isRSTag3Dirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getRSTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag3_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSTag4(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isRSTag4Dirty() : !pSSysUserCaseRS.isRSTag4Dirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getRSTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag4_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSType(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isRSTypeDirty() && !bl2 : !pSSysUserCaseRS.isRSTypeDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getRSType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSType_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tags(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isTagsDirty() : !pSSysUserCaseRS.isTagsDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tags_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isUserCatDirty() : !pSSysUserCaseRS.isUserCatDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isUserTagDirty() : !pSSysUserCaseRS.isUserTagDirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isUserTag2Dirty() : !pSSysUserCaseRS.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isUserTag3Dirty() : !pSSysUserCaseRS.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isUserTag4Dirty() : !pSSysUserCaseRS.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysUserCaseRS.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysUserCaseRS pSSysUserCaseRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserCaseRS.isValidFlagDirty() && !bl2 : !pSSysUserCaseRS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysUserCaseRS.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysUserCaseRS, bl2, bl3);
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

    protected void onSyncEntity(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysUserCaseRS, bl);
    }

    protected void onSyncIndexEntities(PSSysUserCaseRS pSSysUserCaseRS, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysUserCaseRS, bl);
    }

    public Object getDataContextValue(PSSysUserCaseRS pSSysUserCaseRS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysUserCaseRS, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysUserCaseRS pSSysUserCaseRS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysUserCaseRS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PPSSYSACTORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysActorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSACTORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysActorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSUSERCASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysUserCaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSUSERCASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysUserCaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSACTORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysActorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSACTORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysActorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASERSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseRSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASERSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseRSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tags_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Color_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_PPSSysActorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSACTORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSSYSACTORID", "PSSYSUSERCASERS", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysActorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSACTORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysUserCaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSUSERCASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSSYSUSERCASEID", "PSSYSUSERCASERS", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysUserCaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSUSERCASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysActorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSACTORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysActorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSACTORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseRSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASERSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseRSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASERSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tags_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected boolean onMergeChild(String string, String string2, PSSysUserCaseRS pSSysUserCaseRS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysUserCaseRS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysUserCaseRS pSSysUserCaseRS) throws Exception {
        super.onUpdateParent((IEntity)pSSysUserCaseRS);
    }

    @Override
    protected void exportCurXmlModel(PSSysUserCaseRS pSSysUserCaseRS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSUSERCASERS");
        if (!bl) {
            pSSysUserCaseRS.setCreateDate(null);
            pSSysUserCaseRS.setCreateMan(null);
            pSSysUserCaseRS.setPSSysUserCaseRSId(null);
            pSSysUserCaseRS.setUpdateDate(null);
            pSSysUserCaseRS.setUpdateMan(null);
            super.exportCurXmlModel(pSSysUserCaseRS, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysUserCaseRS pSSysUserCaseRS, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysUserCaseRS, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUSERCASERS_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUSERCASERS_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysUserCaseRS pSSysUserCaseRS) {
        if (!StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getCodeName())) {
            return pSSysUserCaseRS.getCodeName();
        }
        return super.getModelV2Tag(pSSysUserCaseRS);
    }

    @Override
    public boolean setModelV2Tag(PSSysUserCaseRS pSSysUserCaseRS, String string) {
        pSSysUserCaseRS.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysUserCaseRS pSSysUserCaseRS, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysUserCaseRS.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysUserCaseRS, true);
        pSSysUserCaseRS.set("CODENAME", string);
        if (this.select(pSSysUserCaseRS, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysUserCaseRS, true);
        return super.getModelV2Entity(pSSysUserCaseRS, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysUserCaseRS pSSysUserCaseRS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysUserCaseRS, objectNode, string, string2, n);
    }
}

