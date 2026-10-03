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
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDictCatDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDictCatDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDictCatServiceBase
extends PSCoreSysServiceBase<PSSysDictCat> {
    private static final Log log = LogFactory.getLog(PSSysDictCatServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysDictCatDEModel pSSysDictCatDEModel;
    private PSSysDictCatDAO pSSysDictCatDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService";
    }

    public PSSysDictCatDEModel getPSSysDictCatDEModel() {
        if (this.pSSysDictCatDEModel == null) {
            try {
                this.pSSysDictCatDEModel = (PSSysDictCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDictCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDictCatDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDictCatDEModel();
    }

    public PSSysDictCatDAO getPSSysDictCatDAO() {
        if (this.pSSysDictCatDAO == null) {
            try {
                this.pSSysDictCatDAO = (PSSysDictCatDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDictCatDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDictCatDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDictCatDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysDictCat pSSysDictCat, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDICTCAT_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysDictCat, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDICTCAT_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysDictCat, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDICTCAT_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysDictCat, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysDictCat, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysDictCat pSSysDictCat, PSModule pSModule) throws Exception {
        pSSysDictCat.setPSModuleId(pSModule.getPSModuleId());
        pSSysDictCat.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysDictCat pSSysDictCat, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysDictCat.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysDictCat.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSystem(PSSysDictCat pSSysDictCat, PSSystem pSSystem) throws Exception {
        pSSysDictCat.setPSSystemId(pSSystem.getPSSystemId());
        pSSysDictCat.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysDictCat pSSysDictCat, boolean bl) throws Exception {
        if (bl) {
            if (pSSysDictCat.getCodeName() == null) {
                pSSysDictCat.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DictCat", 25));
            }
            if (pSSysDictCat.getPSSysDictCatName() == null) {
                pSSysDictCat.setPSSysDictCatName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u8bcd\u6761\u7c7b\u522b", 25));
            }
        }
        super.onFillEntityFullInfo(pSSysDictCat, bl);
        this.onFillEntityFullInfo_PSModule(pSSysDictCat, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysDictCat, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysDictCat, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysDictCat pSSysDictCat, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysDictCat pSSysDictCat, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysDictCat pSSysDictCat, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDictCat pSSysDictCat, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDictCat, bl);
    }

    public ArrayList<PSSysDictCat> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysDictCat> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysDictCat> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDictCat> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysDictCat> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysDictCat> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDictCat> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysDictCat> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysDictCat> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysDictCat> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDICTCAT_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSDICTCAT", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysDictCat> arrayList = this.selectByPSModule(pSModule);
        for (PSSysDictCat pSSysDictCat : arrayList) {
            PSSysDictCat pSSysDictCat2 = (PSSysDictCat)this.getDEModel().createEntity();
            pSSysDictCat2.setPSSysDictCatId(pSSysDictCat.getPSSysDictCatId());
            pSSysDictCat2.setPSModuleId(null);
            this.update(pSSysDictCat2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDictCatServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysDictCatServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysDictCatServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysDictCat> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysDictCat pSSysDictCat : arrayList) {
            this.remove(pSSysDictCat);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysDictCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysDictCat> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDictCat> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDICTCAT_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSDICTCAT", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDictCat> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysDictCat pSSysDictCat : arrayList) {
            PSSysDictCat pSSysDictCat2 = (PSSysDictCat)this.getDEModel().createEntity();
            pSSysDictCat2.setPSSysDictCatId(pSSysDictCat.getPSSysDictCatId());
            pSSysDictCat2.setPSSysDynaModelId(null);
            this.update(pSSysDictCat2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDictCatServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysDictCatServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysDictCatServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDictCat> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysDictCat pSSysDictCat : arrayList) {
            this.remove(pSSysDictCat);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysDictCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysDictCat> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDictCat> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysDictCat pSSysDictCat : arrayList) {
            PSSysDictCat pSSysDictCat2 = (PSSysDictCat)this.getDEModel().createEntity();
            pSSysDictCat2.setPSSysDictCatId(pSSysDictCat.getPSSysDictCatId());
            pSSysDictCat2.setPSSystemId(null);
            this.update(pSSysDictCat2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDictCatServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysDictCatServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysDictCatServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDictCat> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysDictCat pSSysDictCat : arrayList) {
            this.remove(pSSysDictCat);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDictCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDictCat> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDictCat pSSysDictCat) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDictCat(pSSysDictCat);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDictCat(pSSysDictCat);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDictCat(pSSysDictCat);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDictCat(pSSysDictCat);
        super.onBeforeRemove(pSSysDictCat);
    }

    protected void replaceParentInfo(PSSysDictCat pSSysDictCat, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDictCat, cloneSession);
        if (pSSysDictCat.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysDictCat.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysDictCat, (PSModule)iEntity);
        }
        if (pSSysDictCat.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysDictCat.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysDictCat, (PSSysDynaModel)iEntity);
        }
        if (pSSysDictCat.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysDictCat.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysDictCat, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDictCat pSSysDictCat, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDictCat, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysDictCat, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DictCatTag(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DictCatTag2(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDictCatId(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDictCatName(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysDictCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDictCat, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isCodeNameDirty() : !pSSysDictCat.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysDictCat.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysDictCat, bl2, bl3);
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysDictCatDEModel(), "CODENAME", string3, pSSysDictCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_DictCatTag(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isDictCatTagDirty() : !pSSysDictCat.isDictCatTagDirty()) {
            return null;
        }
        String string = pSSysDictCat.getDictCatTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DictCatTag_Default(pSSysDictCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DICTCATTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DictCatTag2(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isDictCatTag2Dirty() : !pSSysDictCat.isDictCatTag2Dirty()) {
            return null;
        }
        String string = pSSysDictCat.getDictCatTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DictCatTag2_Default(pSSysDictCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DICTCATTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isLockFlagDirty() : !pSSysDictCat.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysDictCat.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSSysDictCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isMemoDirty() : !pSSysDictCat.isMemoDirty()) {
            return null;
        }
        String string = pSSysDictCat.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDictCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isPSModuleIdDirty() : !pSSysDictCat.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysDictCat.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysDictCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDictCatId(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isPSSysDictCatIdDirty() && !bl2 : !pSSysDictCat.isPSSysDictCatIdDirty()) {
            return null;
        }
        String string = pSSysDictCat.getPSSysDictCatId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDICTCATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDictCatId_Default(pSSysDictCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDICTCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDictCatName(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isPSSysDictCatNameDirty() && !bl2 : !pSSysDictCat.isPSSysDictCatNameDirty()) {
            return null;
        }
        String string = pSSysDictCat.getPSSysDictCatName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDICTCATNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDictCatName_Default(pSSysDictCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDICTCATNAME");
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysDictCatDEModel(), "PSSYSDICTCATNAME", string3, pSSysDictCat, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDICTCATNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isPSSysDynaModelIdDirty() : !pSSysDictCat.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysDictCat.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysDictCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isPSSystemIdDirty() && !bl2 : !pSSysDictCat.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysDictCat.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysDictCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isUserCatDirty() : !pSSysDictCat.isUserCatDirty()) {
            return null;
        }
        Integer n = pSSysDictCat.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserCat_Default(pSSysDictCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isUserTagDirty() : !pSSysDictCat.isUserTagDirty()) {
            return null;
        }
        String string = pSSysDictCat.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysDictCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isUserTag2Dirty() : !pSSysDictCat.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysDictCat.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysDictCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isUserTag3Dirty() : !pSSysDictCat.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysDictCat.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysDictCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysDictCat pSSysDictCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDictCat.isUserTag4Dirty() : !pSSysDictCat.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysDictCat.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysDictCat, bl2, bl3);
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

    protected void onSyncEntity(PSSysDictCat pSSysDictCat, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDictCat, bl);
    }

    protected void onSyncIndexEntities(PSSysDictCat pSSysDictCat, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDictCat, bl);
    }

    public Object getDataContextValue(PSSysDictCat pSSysDictCat, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysDictCat, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDictCat pSSysDictCat, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDictCat, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DICTCATTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DictCatTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DICTCATTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DictCatTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDICTCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDictCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDICTCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDictCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DictCatTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DICTCATTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DictCatTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DICTCATTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSysDictCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDICTCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDictCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDICTCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
        return null;
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysDictCat pSSysDictCat) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDictCat)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDictCat pSSysDictCat) throws Exception {
        super.onUpdateParent(pSSysDictCat);
    }

    @Override
    protected void exportCurXmlModel(PSSysDictCat pSSysDictCat, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDICTCAT");
        if (!bl) {
            super.exportCurXmlModel(pSSysDictCat, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDictCat pSSysDictCat, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDictCat, string);
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
            return "DER1N_PSSYSDICTCAT_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDICTCAT_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysDictCat pSSysDictCat) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDictCat.getCodeName())) {
            return pSSysDictCat.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDictCat.getPSSysDictCatName())) {
            return pSSysDictCat.getPSSysDictCatName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDictCat.getCodeName())) {
            return pSSysDictCat.getCodeName();
        }
        return super.getModelV2Tag(pSSysDictCat);
    }

    @Override
    public boolean setModelV2Tag(PSSysDictCat pSSysDictCat, String string) {
        pSSysDictCat.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSDICTCATNAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDictCat pSSysDictCat, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDictCat.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDictCat, true);
        pSSysDictCat.set("CODENAME", string);
        if (this.select(pSSysDictCat, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDictCat, true);
        return super.getModelV2Entity(pSSysDictCat, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDictCat pSSysDictCat, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysDictCat, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysDictCat pSSysDictCat, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DictCat");
        defaultValueMap.put("PSSYSDICTCATNAME", "\u8bcd\u6761\u7c7b\u522b");
    }
}

