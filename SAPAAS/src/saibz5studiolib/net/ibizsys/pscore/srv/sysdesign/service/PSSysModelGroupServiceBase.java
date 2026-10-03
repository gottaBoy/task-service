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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
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
 *  net.ibizsys.paas.service.SessionFactoryManager
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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDSchemeBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysModelRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysModelRepoBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelRepoBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchSchemeBase;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysModelGroupDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysModelGroupDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBSchemeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelGroupServiceBase
extends PSCoreSysServiceBase<PSSysModelGroup> {
    private static final Log log = LogFactory.getLog(PSSysModelGroupServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysModelGroupDEModel pSSysModelGroupDEModel;
    private PSSysModelGroupDAO pSSysModelGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService";
    }

    public PSSysModelGroupDEModel getPSSysModelGroupDEModel() {
        if (this.pSSysModelGroupDEModel == null) {
            try {
                this.pSSysModelGroupDEModel = (PSSysModelGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysModelGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelGroupDEModel();
    }

    public PSSysModelGroupDAO getPSSysModelGroupDAO() {
        if (this.pSSysModelGroupDAO == null) {
            try {
                this.pSSysModelGroupDAO = (PSSysModelGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysModelGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelGroupDAO();
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

    protected void onFillParentInfo(PSSysModelGroup pSSysModelGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELGROUP_PSDCSYSMODELREPO_PSDCSYSMODELREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelRepoService", (SessionFactory)this.getSessionFactory());
            PSDCSysModelRepo pSDCSysModelRepo = (PSDCSysModelRepo)iService.getDEModel().createEntity();
            pSDCSysModelRepo.set("PSDCSYSMODELREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCSysModelRepo);
            } else {
                iService.get(pSDCSysModelRepo);
            }
            this.onFillParentInfo_PSDCSysModelRepo(pSSysModelGroup, pSDCSysModelRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELGROUP_PSSYSMODELREPO_PSSYSMODELREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelRepoService", (SessionFactory)this.getSessionFactory());
            PSSysModelRepo pSSysModelRepo = (PSSysModelRepo)iService.getDEModel().createEntity();
            pSSysModelRepo.set("PSSYSMODELREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysModelRepo);
            } else {
                iService.get(pSSysModelRepo);
            }
            this.onFillParentInfo_PSSysModelRepo(pSSysModelGroup, pSSysModelRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELGROUP_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysModelGroup, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysModelGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCSysModelRepo(PSSysModelGroup pSSysModelGroup, PSDCSysModelRepo pSDCSysModelRepo) throws Exception {
        pSSysModelGroup.setPSDCSysModelRepoId(pSDCSysModelRepo.getPSDCSysModelRepoId());
        pSSysModelGroup.setPSDCSysModelRepoName(pSDCSysModelRepo.getPSDCSysModelRepoName());
    }

    protected void onFillParentInfo_PSSysModelRepo(PSSysModelGroup pSSysModelGroup, PSSysModelRepo pSSysModelRepo) throws Exception {
        pSSysModelGroup.setPSSysModelRepoId(pSSysModelRepo.getPSSysModelRepoId());
        pSSysModelGroup.setPSSysModelRepoName(pSSysModelRepo.getPSSysModelRepoName());
    }

    protected void onFillParentInfo_PSSystem(PSSysModelGroup pSSysModelGroup, PSSystem pSSystem) throws Exception {
        pSSysModelGroup.setPSSystemId(pSSystem.getPSSystemId());
        pSSysModelGroup.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysModelGroup pSSysModelGroup, boolean bl) throws Exception {
        if (bl) {
            if (pSSysModelGroup.getPSSysModelGroupName() == null) {
                pSSysModelGroup.setPSSysModelGroupName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u6a21\u578b\u7ec4", 25));
            }
            if (pSSysModelGroup.getSysModelFrom() == null) {
                pSSysModelGroup.setSysModelFrom((String)this.getDefaultValue(this.getWebContext(), "", "NONE", 25));
            }
        }
        super.onFillEntityFullInfo(pSSysModelGroup, bl);
        this.onFillEntityFullInfo_PSDCSysModelRepo(pSSysModelGroup, bl);
        this.onFillEntityFullInfo_PSSysModelRepo(pSSysModelGroup, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysModelGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDCSysModelRepo(PSSysModelGroup pSSysModelGroup, boolean bl) throws Exception {
        if (pSSysModelGroup.isPSDCSysModelRepoIdDirty()) {
            if (pSSysModelGroup.getPSDCSysModelRepoId() != null) {
                if (pSSysModelGroup.getPSDCSysModelRepoId() == null || pSSysModelGroup.getPSDCSysModelRepoName() == null) {
                    PSDCSysModelRepo pSDCSysModelRepo = pSSysModelGroup.getPSDCSysModelRepo();
                    pSSysModelGroup.setPSDCSysModelRepoName(pSDCSysModelRepo.getPSDCSysModelRepoName());
                }
            } else {
                pSSysModelGroup.setPSDCSysModelRepoName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysModelRepo(PSSysModelGroup pSSysModelGroup, boolean bl) throws Exception {
        if (pSSysModelGroup.isPSSysModelRepoIdDirty()) {
            if (pSSysModelGroup.getPSSysModelRepoId() != null) {
                if (pSSysModelGroup.getPSSysModelRepoId() == null || pSSysModelGroup.getPSSysModelRepoName() == null) {
                    PSSysModelRepo pSSysModelRepo = pSSysModelGroup.getPSSysModelRepo();
                    pSSysModelGroup.setPSSysModelRepoName(pSSysModelRepo.getPSSysModelRepoName());
                }
            } else {
                pSSysModelGroup.setPSSysModelRepoName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysModelGroup pSSysModelGroup, boolean bl) throws Exception {
        if (pSSysModelGroup.isPSSystemIdDirty()) {
            if (pSSysModelGroup.getPSSystemId() != null) {
                if (pSSysModelGroup.getPSSystemId() == null || pSSysModelGroup.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysModelGroup.getPSSystem();
                    pSSysModelGroup.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysModelGroup.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysModelGroup pSSysModelGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysModelGroup, bl);
    }

    public ArrayList<PSSysModelGroup> selectByPSDCSysModelRepo(PSDCSysModelRepoBase pSDCSysModelRepoBase) throws Exception {
        return this.selectByPSDCSysModelRepo(pSDCSysModelRepoBase, "", -1);
    }

    public ArrayList<PSSysModelGroup> selectByPSDCSysModelRepo(PSDCSysModelRepoBase pSDCSysModelRepoBase, String string) throws Exception {
        return this.selectByPSDCSysModelRepo(pSDCSysModelRepoBase, string, -1);
    }

    public ArrayList<PSSysModelGroup> selectByPSDCSysModelRepo(PSDCSysModelRepoBase pSDCSysModelRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCSYSMODELREPOID", (Object)pSDCSysModelRepoBase.getPSDCSysModelRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCSysModelRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCSysModelRepoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelGroup> selectByPSSysModelRepo(PSSysModelRepoBase pSSysModelRepoBase) throws Exception {
        return this.selectByPSSysModelRepo(pSSysModelRepoBase, "", -1);
    }

    public ArrayList<PSSysModelGroup> selectByPSSysModelRepo(PSSysModelRepoBase pSSysModelRepoBase, String string) throws Exception {
        return this.selectByPSSysModelRepo(pSSysModelRepoBase, string, -1);
    }

    public ArrayList<PSSysModelGroup> selectByPSSysModelRepo(PSSysModelRepoBase pSSysModelRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELREPOID", (Object)pSSysModelRepoBase.getPSSysModelRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelRepoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelGroup> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysModelGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysModelGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCSysModelRepo(PSDCSysModelRepo pSDCSysModelRepo) throws Exception {
    }

    public void resetPSDCSysModelRepo(PSDCSysModelRepo pSDCSysModelRepo) throws Exception {
        ArrayList<PSSysModelGroup> arrayList = this.selectByPSDCSysModelRepo(pSDCSysModelRepo);
        for (PSSysModelGroup pSSysModelGroup : arrayList) {
            PSSysModelGroup pSSysModelGroup2 = (PSSysModelGroup)this.getDEModel().createEntity();
            pSSysModelGroup2.setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
            pSSysModelGroup2.setPSDCSysModelRepoId(null);
            this.update(pSSysModelGroup2);
        }
    }

    public void removeByPSDCSysModelRepo(PSDCSysModelRepo pSDCSysModelRepo) throws Exception {
        final PSDCSysModelRepo pSDCSysModelRepo2 = pSDCSysModelRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelGroupServiceBase.this.onBeforeRemoveByPSDCSysModelRepo(pSDCSysModelRepo2);
                PSSysModelGroupServiceBase.this.internalRemoveByPSDCSysModelRepo(pSDCSysModelRepo2);
                PSSysModelGroupServiceBase.this.onAfterRemoveByPSDCSysModelRepo(pSDCSysModelRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCSysModelRepo(PSDCSysModelRepo pSDCSysModelRepo) throws Exception {
    }

    protected void internalRemoveByPSDCSysModelRepo(PSDCSysModelRepo pSDCSysModelRepo) throws Exception {
        ArrayList<PSSysModelGroup> arrayList = this.selectByPSDCSysModelRepo(pSDCSysModelRepo);
        this.onBeforeRemoveByPSDCSysModelRepo(pSDCSysModelRepo, arrayList);
        for (PSSysModelGroup pSSysModelGroup : arrayList) {
            this.remove(pSSysModelGroup);
        }
        this.onAfterRemoveByPSDCSysModelRepo(pSDCSysModelRepo, arrayList);
    }

    protected void onAfterRemoveByPSDCSysModelRepo(PSDCSysModelRepo pSDCSysModelRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSDCSysModelRepo(PSDCSysModelRepo pSDCSysModelRepo, ArrayList<PSSysModelGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCSysModelRepo(PSDCSysModelRepo pSDCSysModelRepo, ArrayList<PSSysModelGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelRepo(PSSysModelRepo pSSysModelRepo) throws Exception {
    }

    public void resetPSSysModelRepo(PSSysModelRepo pSSysModelRepo) throws Exception {
        ArrayList<PSSysModelGroup> arrayList = this.selectByPSSysModelRepo(pSSysModelRepo);
        for (PSSysModelGroup pSSysModelGroup : arrayList) {
            PSSysModelGroup pSSysModelGroup2 = (PSSysModelGroup)this.getDEModel().createEntity();
            pSSysModelGroup2.setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
            pSSysModelGroup2.setPSSysModelRepoId(null);
            this.update(pSSysModelGroup2);
        }
    }

    public void removeByPSSysModelRepo(PSSysModelRepo pSSysModelRepo) throws Exception {
        final PSSysModelRepo pSSysModelRepo2 = pSSysModelRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelGroupServiceBase.this.onBeforeRemoveByPSSysModelRepo(pSSysModelRepo2);
                PSSysModelGroupServiceBase.this.internalRemoveByPSSysModelRepo(pSSysModelRepo2);
                PSSysModelGroupServiceBase.this.onAfterRemoveByPSSysModelRepo(pSSysModelRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelRepo(PSSysModelRepo pSSysModelRepo) throws Exception {
    }

    protected void internalRemoveByPSSysModelRepo(PSSysModelRepo pSSysModelRepo) throws Exception {
        ArrayList<PSSysModelGroup> arrayList = this.selectByPSSysModelRepo(pSSysModelRepo);
        this.onBeforeRemoveByPSSysModelRepo(pSSysModelRepo, arrayList);
        for (PSSysModelGroup pSSysModelGroup : arrayList) {
            this.remove(pSSysModelGroup);
        }
        this.onAfterRemoveByPSSysModelRepo(pSSysModelRepo, arrayList);
    }

    protected void onAfterRemoveByPSSysModelRepo(PSSysModelRepo pSSysModelRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelRepo(PSSysModelRepo pSSysModelRepo, ArrayList<PSSysModelGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelRepo(PSSysModelRepo pSSysModelRepo, ArrayList<PSSysModelGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysModelGroup> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELGROUP_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSMODELGROUP", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysModelGroup> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysModelGroup pSSysModelGroup : arrayList) {
            PSSysModelGroup pSSysModelGroup2 = (PSSysModelGroup)this.getDEModel().createEntity();
            pSSysModelGroup2.setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
            pSSysModelGroup2.setPSSystemId(null);
            this.update(pSSysModelGroup2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelGroupServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysModelGroupServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysModelGroupServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysModelGroup> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysModelGroup pSSysModelGroup : arrayList) {
            this.remove(pSSysModelGroup);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysModelGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysModelGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelGroup pSSysModelGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelGroup(pSSysModelGroup);
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).resetPSSysModelGroup(pSSysModelGroup);
        pSCoreSysServiceBase = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSModuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelGroup(pSSysModelGroup);
        pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelGroup(pSSysModelGroup);
        pSCoreSysServiceBase = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBISchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelGroup(pSSysModelGroup);
        pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelGroup(pSSysModelGroup);
        pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelGroup(pSSysModelGroup);
        pSCoreSysServiceBase = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUtilDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelGroup(pSSysModelGroup);
        super.onBeforeRemove(pSSysModelGroup);
    }

    protected void replaceParentInfo(PSSysModelGroup pSSysModelGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysModelGroup, cloneSession);
        if (pSSysModelGroup.getPSDCSysModelRepoId() != null && (iEntity = cloneSession.getEntity("PSDCSYSMODELREPO", (Object)pSSysModelGroup.getPSDCSysModelRepoId())) != null) {
            this.onFillParentInfo_PSDCSysModelRepo(pSSysModelGroup, (PSDCSysModelRepo)iEntity);
        }
        if (pSSysModelGroup.getPSSysModelRepoId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELREPO", (Object)pSSysModelGroup.getPSSysModelRepoId())) != null) {
            this.onFillParentInfo_PSSysModelRepo(pSSysModelGroup, (PSSysModelRepo)iEntity);
        }
        if (pSSysModelGroup.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysModelGroup.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysModelGroup, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelGroup pSSysModelGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysModelGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ClsPkgParams(bl, pSSysModelGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeNameMode(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DTOFormat(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaInstMode(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaInstTag(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaInstTag2(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePQL(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupParams(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag2(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag3(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag4(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PFRTObjectRepo(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKGCodeName(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysModelRepoId(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysModelRepoName(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelGroupId(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelGroupName(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelRepoId(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelRepoName(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuntimeType(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SFRTObjectRepo(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncMode(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysModelFrom(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysModelGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysModelGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ClsPkgParams(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isClsPkgParamsDirty() : !pSSysModelGroup.isClsPkgParamsDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getClsPkgParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPkgParams_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSPKGPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isCodeNameDirty() && !bl2 : !pSSysModelGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysModelGroup, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysModelGroupDEModel(), "CODENAME", string3, pSSysModelGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeNameMode(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isCodeNameModeDirty() : !pSSysModelGroup.isCodeNameModeDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getCodeNameMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeNameMode_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAMEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DTOFormat(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isDTOFormatDirty() : !pSSysModelGroup.isDTOFormatDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getDTOFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DTOFormat_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DTOFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaInstMode(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isDynaInstModeDirty() : !pSSysModelGroup.isDynaInstModeDirty()) {
            return null;
        }
        Integer n = pSSysModelGroup.getDynaInstMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaInstMode_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAINSTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaInstTag(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isDynaInstTagDirty() : !pSSysModelGroup.isDynaInstTagDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getDynaInstTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaInstTag_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAINSTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaInstTag2(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isDynaInstTag2Dirty() : !pSSysModelGroup.isDynaInstTag2Dirty()) {
            return null;
        }
        String string = pSSysModelGroup.getDynaInstTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaInstTag2_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAINSTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnablePQL(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isEnablePQLDirty() : !pSSysModelGroup.isEnablePQLDirty()) {
            return null;
        }
        Integer n = pSSysModelGroup.getEnablePQL();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePQL_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupParams(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isGroupParamsDirty() : !pSSysModelGroup.isGroupParamsDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getGroupParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupParams_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isGroupTagDirty() : !pSSysModelGroup.isGroupTagDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getGroupTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag2(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isGroupTag2Dirty() : !pSSysModelGroup.isGroupTag2Dirty()) {
            return null;
        }
        String string = pSSysModelGroup.getGroupTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag2_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag3(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isGroupTag3Dirty() : !pSSysModelGroup.isGroupTag3Dirty()) {
            return null;
        }
        String string = pSSysModelGroup.getGroupTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag3_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag4(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isGroupTag4Dirty() : !pSSysModelGroup.isGroupTag4Dirty()) {
            return null;
        }
        String string = pSSysModelGroup.getGroupTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag4_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isMemoDirty() : !pSSysModelGroup.isMemoDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysModelGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PFRTObjectRepo(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPFRTObjectRepoDirty() : !pSSysModelGroup.isPFRTObjectRepoDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPFRTObjectRepo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PFRTObjectRepo_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PFRTOBJECTREPO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PKGCodeName(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPKGCodeNameDirty() : !pSSysModelGroup.isPKGCodeNameDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPKGCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PKGCodeName_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysModelRepoId(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPSDCSysModelRepoIdDirty() : !pSSysModelGroup.isPSDCSysModelRepoIdDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPSDCSysModelRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysModelRepoId_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSMODELREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysModelRepoName(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPSDCSysModelRepoNameDirty() : !pSSysModelGroup.isPSDCSysModelRepoNameDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPSDCSysModelRepoName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysModelRepoName_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSMODELREPONAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelGroupId(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPSSysModelGroupIdDirty() && !bl2 : !pSSysModelGroup.isPSSysModelGroupIdDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPSSysModelGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelGroupId_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelGroupName(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPSSysModelGroupNameDirty() && !bl2 : !pSSysModelGroup.isPSSysModelGroupNameDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPSSysModelGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelGroupName_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelRepoId(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPSSysModelRepoIdDirty() : !pSSysModelGroup.isPSSysModelRepoIdDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPSSysModelRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelRepoId_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelRepoName(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPSSysModelRepoNameDirty() : !pSSysModelGroup.isPSSysModelRepoNameDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPSSysModelRepoName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelRepoName_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELREPONAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPSSystemIdDirty() && !bl2 : !pSSysModelGroup.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysModelGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isPSSystemNameDirty() && !bl2 : !pSSysModelGroup.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysModelGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_RuntimeType(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isRuntimeTypeDirty() : !pSSysModelGroup.isRuntimeTypeDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getRuntimeType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RuntimeType_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNTIMETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SFRTObjectRepo(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isSFRTObjectRepoDirty() : !pSSysModelGroup.isSFRTObjectRepoDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getSFRTObjectRepo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SFRTObjectRepo_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SFRTOBJECTREPO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncMode(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isSyncModeDirty() : !pSSysModelGroup.isSyncModeDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getSyncMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncMode_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysModelFrom(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isSysModelFromDirty() : !pSSysModelGroup.isSysModelFromDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getSysModelFrom();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysModelFrom_Default(pSSysModelGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSMODELFROM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isUserCatDirty() : !pSSysModelGroup.isUserCatDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysModelGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isUserTagDirty() : !pSSysModelGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSSysModelGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysModelGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isUserTag2Dirty() : !pSSysModelGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysModelGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysModelGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isUserTag3Dirty() : !pSSysModelGroup.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysModelGroup.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysModelGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysModelGroup pSSysModelGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelGroup.isUserTag4Dirty() : !pSSysModelGroup.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysModelGroup.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysModelGroup, bl2, bl3);
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

    protected void onSyncEntity(PSSysModelGroup pSSysModelGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSSysModelGroup, bl);
    }

    protected void onSyncIndexEntities(PSSysModelGroup pSSysModelGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysModelGroup, bl);
    }

    public Object getDataContextValue(PSSysModelGroup pSSysModelGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysModelGroup, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysModelGroup.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelGroup pSSysModelGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysModelGroup, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLSPKGPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPkgParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAMEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeNameMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DTOFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DTOFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAINSTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaInstMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAINSTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaInstTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAINSTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaInstTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePQL_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PFRTOBJECTREPO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PFRTObjectRepo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKGCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSMODELREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysModelRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSMODELREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysModelRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNTIMETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuntimeType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SFRTOBJECTREPO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SFRTObjectRepo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMODELFROM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysModelFrom_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ClsPkgParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLSPKGPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_CodeNameMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAMEMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected String onTestValueRule_DTOFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DTOFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaInstMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaInstTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAINSTTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaInstTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAINSTTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnablePQL_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PFRTObjectRepo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PFRTOBJECTREPO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PKGCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysModelRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSMODELREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysModelRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSMODELREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RuntimeType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNTIMETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SFRTObjectRepo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SFRTOBJECTREPO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysModelFrom_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSMODELFROM", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysModelGroup pSSysModelGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysModelGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelGroup pSSysModelGroup) throws Exception {
        super.onUpdateParent(pSSysModelGroup);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelGroup pSSysModelGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELGROUP");
        if (!bl) {
            pSSysModelGroup.setCreateDate(null);
            pSSysModelGroup.setCreateMan(null);
            pSSysModelGroup.setPSSysModelGroupId(null);
            pSSysModelGroup.setUpdateDate(null);
            pSSysModelGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSSysModelGroup, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysModelGroup pSSysModelGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysModelGroup, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSMODELGROUP_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysModelGroup pSSysModelGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSSysModelGroup.getCodeName())) {
            return pSSysModelGroup.getCodeName();
        }
        return super.getModelV2Tag(pSSysModelGroup);
    }

    @Override
    public boolean setModelV2Tag(PSSysModelGroup pSSysModelGroup, String string) {
        pSSysModelGroup.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysModelGroup pSSysModelGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysModelGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysModelGroup, true);
        pSSysModelGroup.set("CODENAME", string);
        if (this.select(pSSysModelGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysModelGroup, true);
        return super.getModelV2Entity(pSSysModelGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysModelGroup pSSysModelGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysModelGroup, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 10;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSBDSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSDBSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSSEARCHSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSUTILDE_PSSYSMODELGROUP_PSSYSMODELGROUPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysModelGroup pSSysModelGroup, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSMODULE", (Object)pSSysModelGroup.getPSSysModelGroupId()))).exists()) {
            pSCoreSysServiceBase = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSModule();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSModuleServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSModule)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSMODULE", (Object)((PSModule)entityBase).getPSModuleId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSBDSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBDSCHEME", (Object)pSSysModelGroup.getPSSysModelGroupId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysBDScheme();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBDSchemeServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBDScheme)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBDSCHEME", (Object)((PSSysBDScheme)entityBase).getPSSysBDSchemeId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSDBSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSDBSCHEME", (Object)pSSysModelGroup.getPSSysModelGroupId()))).exists()) {
            pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysDBScheme();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysDBSchemeServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysDBScheme)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSDBSCHEME", (Object)((PSSysDBScheme)entityBase).getPSSysDBSchemeId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSSEARCHSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSSEARCHSCHEME", (Object)pSSysModelGroup.getPSSysModelGroupId()))).exists()) {
            pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysSearchScheme();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysSearchSchemeServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysSearchScheme)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSSEARCHSCHEME", (Object)((PSSysSearchScheme)entityBase).getPSSysSearchSchemeId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSUTILDE_PSSYSMODELGROUP_PSSYSMODELGROUPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSUTILDE", (Object)pSSysModelGroup.getPSSysModelGroupId()))).exists()) {
            pSCoreSysServiceBase = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysUtilDE();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysUtilDEService)pSCoreSysServiceBase).getModelV2Tag((PSSysUtilDE)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSUTILDE", (Object)((PSSysUtilDE)entityBase).getPSSysUtilDEId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysModelGroup, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysModelGroup pSSysModelGroup, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID")) {
            pSCoreSysServiceBase = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSMODULE", (Object)pSSysModelGroup.getPSSysModelGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSMODELGROUP#%1$s", (Object)pSSysModelGroup.getPSSysModelGroupId());
                for (PSModule entity : ((PSModuleServiceBase)pSCoreSysServiceBase).selectByPSSysModelGroup(pSSysModelGroup)) {
                    String entityScope = ((PSModuleServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psmodulename")) {
                            string = objectNode.get("psmodulename").asText();
                        }
                        if (objectNode2.has("psmodulename")) {
                            string2 = objectNode2.get("psmodulename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSModule entity = new PSModule();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBDSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID")) {
            pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBDSCHEME", (Object)pSSysModelGroup.getPSSysModelGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSMODELGROUP#%1$s", (Object)pSSysModelGroup.getPSSysModelGroupId());
                for (PSSysBDScheme entity : ((PSSysBDSchemeServiceBase)pSCoreSysServiceBase).selectByPSSysModelGroup(pSSysModelGroup)) {
                    String entityScope = ((PSSysBDSchemeServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssysbdschemename")) {
                            string = objectNode.get("pssysbdschemename").asText();
                        }
                        if (objectNode2.has("pssysbdschemename")) {
                            string2 = objectNode2.get("pssysbdschemename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSSysBDScheme entity = new PSSysBDScheme();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSDBSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID")) {
            pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSDBSCHEME", (Object)pSSysModelGroup.getPSSysModelGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSMODELGROUP#%1$s", (Object)pSSysModelGroup.getPSSysModelGroupId());
                for (PSSysDBScheme entity : ((PSSysDBSchemeServiceBase)pSCoreSysServiceBase).selectByPSSysModelGroup(pSSysModelGroup)) {
                    String entityScope = ((PSSysDBSchemeServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssysdbschemename")) {
                            string = objectNode.get("pssysdbschemename").asText();
                        }
                        if (objectNode2.has("pssysdbschemename")) {
                            string2 = objectNode2.get("pssysdbschemename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSSysDBScheme entity = new PSSysDBScheme();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSEARCHSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID")) {
            pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSEARCHSCHEME", (Object)pSSysModelGroup.getPSSysModelGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSMODELGROUP#%1$s", (Object)pSSysModelGroup.getPSSysModelGroupId());
                for (PSSysSearchScheme entity : ((PSSysSearchSchemeServiceBase)pSCoreSysServiceBase).selectByPSSysModelGroup(pSSysModelGroup)) {
                    String entityScope = ((PSSysSearchSchemeServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssyssearchschemename")) {
                            string = objectNode.get("pssyssearchschemename").asText();
                        }
                        if (objectNode2.has("pssyssearchschemename")) {
                            string2 = objectNode2.get("pssyssearchschemename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSSysSearchScheme entity = new PSSysSearchScheme();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSUTILDE_PSSYSMODELGROUP_PSSYSMODELGROUPID")) {
            pSCoreSysServiceBase = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSMODELGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSUTILDE", (Object)pSSysModelGroup.getPSSysModelGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSMODELGROUP#%1$s", (Object)pSSysModelGroup.getPSSysModelGroupId());
                for (PSSysUtilDE entity : ((PSSysUtilDEServiceBase)pSCoreSysServiceBase).selectByPSSysModelGroup(pSSysModelGroup)) {
                    String entityScope = ((PSSysUtilDEServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssysutildename")) {
                            string = objectNode.get("pssysutildename").asText();
                        }
                        if (objectNode2.has("pssysutildename")) {
                            string2 = objectNode2.get("pssysutildename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSSysUtilDE entity = new PSSysUtilDE();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysModelGroup, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysModelGroup pSSysModelGroup) throws Exception {
        super.onEmptyModelV2(pSSysModelGroup);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysModelGroup pSSysModelGroup, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSModule();
        entityBase.set("PSSYSMODELGROUPID", pSSysModelGroup.getPSSysModelGroupId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysBDScheme();
        entityBase.set("PSSYSMODELGROUPID", pSSysModelGroup.getPSSysModelGroupId());
        pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysDBScheme();
        entityBase.set("PSSYSMODELGROUPID", pSSysModelGroup.getPSSysModelGroupId());
        pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysSearchScheme();
        entityBase.set("PSSYSMODELGROUPID", pSSysModelGroup.getPSSysModelGroupId());
        pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysUtilDE();
        entityBase.set("PSSYSMODELGROUPID", pSSysModelGroup.getPSSysModelGroupId());
        pSCoreSysServiceBase = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysModelGroup, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysModelGroup pSSysModelGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        IEntity object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSysModelGroupServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSModule();
                    ((PSModuleBase)object).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                    ((PSModuleBase)object).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    for (File child : ((File)object2).listFiles()) {
                        if (!child.isDirectory()) continue;
                        entityBase = new PSModule();
                        ((PSModule)entityBase).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                        ((PSModule)entityBase).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysModelGroupServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysBDScheme();
                    ((PSSysBDSchemeBase)object).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                    ((PSSysBDSchemeBase)object).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (File child : ((File)object2).listFiles()) {
                        if (!child.isDirectory()) continue;
                        entityBase = new PSSysBDScheme();
                        ((PSSysBDScheme)entityBase).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                        ((PSSysBDScheme)entityBase).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysModelGroupServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSSysDBScheme();
                    ((PSSysDBSchemeBase)object).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                    ((PSSysDBSchemeBase)object).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (((File)object2).exists()) {
                    for (File child : ((File)object2).listFiles()) {
                        if (!child.isDirectory()) continue;
                        entityBase = new PSSysDBScheme();
                        ((PSSysDBScheme)entityBase).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                        ((PSSysDBScheme)entityBase).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysModelGroupServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSSysSearchScheme();
                    ((PSSysSearchSchemeBase)object).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                    ((PSSysSearchSchemeBase)object).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string7);
                if (((File)object2).exists()) {
                    for (File child : ((File)object2).listFiles()) {
                        if (!child.isDirectory()) continue;
                        entityBase = new PSSysSearchScheme();
                        ((PSSysSearchScheme)entityBase).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                        ((PSSysSearchScheme)entityBase).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysModelGroupServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null && (arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase())) == null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)"pssysutils");
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSSysUtilDE();
                    ((PSSysUtilDEBase)object).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                    ((PSSysUtilDEBase)object).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string8 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string8);
                if (!((File)object2).exists()) {
                    string8 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)"PSSYSUTILS");
                    object2 = new File(string8);
                }
                if (((File)object2).exists()) {
                    for (File child : ((File)object2).listFiles()) {
                        if (!child.isDirectory()) continue;
                        entityBase = new PSSysUtilDE();
                        ((PSSysUtilDE)entityBase).setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
                        ((PSSysUtilDE)entityBase).setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysModelGroup, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysModelGroup pSSysModelGroup, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSModules(pSSysModelGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBDSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBDSchemes(pSSysModelGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSDBSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysDBSchemes(pSSysModelGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysSearchSchemes(pSSysModelGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSUTILDE_PSSYSMODELGROUP_PSSYSMODELGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysUtilDEs(pSSysModelGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysModelGroup, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSModules(PSSysModelGroup pSSysModelGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSMODULE", true), (boolean)false) == 0) {
            PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
            PSModule pSModule = new PSModule();
            pSModule.setPSModuleId(pSMOSFile.getPSModelId());
            if (!pSModuleService.get(pSModule, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSModule.getPSSysModelGroupId(), (String)pSSysModelGroup.getPSSysModelGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSModuleService.exportModelV2(pSModule);
            pSModule.reset();
            if (!pSModuleService.setModelV2ResScope(pSModule, "PSSYSMODELGROUP", pSSysModelGroup.getPSSysModelGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSModuleService.importModelV2(pSModule, objectNode);
            SessionFactoryManager.commit();
            return pSModuleService.getFile(pSModule);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysBDSchemes(PSSysModelGroup pSSysModelGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBDSCHEME", true), (boolean)false) == 0) {
            PSSysBDSchemeService pSSysBDSchemeService = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDScheme pSSysBDScheme = new PSSysBDScheme();
            pSSysBDScheme.setPSSysBDSchemeId(pSMOSFile.getPSModelId());
            if (!pSSysBDSchemeService.get(pSSysBDScheme, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBDScheme.getPSSysModelGroupId(), (String)pSSysModelGroup.getPSSysModelGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBDSchemeService.exportModelV2(pSSysBDScheme);
            pSSysBDScheme.reset();
            if (!pSSysBDSchemeService.setModelV2ResScope(pSSysBDScheme, "PSSYSMODELGROUP", pSSysModelGroup.getPSSysModelGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBDSchemeService.importModelV2(pSSysBDScheme, objectNode);
            SessionFactoryManager.commit();
            return pSSysBDSchemeService.getFile(pSSysBDScheme);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysDBSchemes(PSSysModelGroup pSSysModelGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSDBSCHEME", true), (boolean)false) == 0) {
            PSSysDBSchemeService pSSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
            PSSysDBScheme pSSysDBScheme = new PSSysDBScheme();
            pSSysDBScheme.setPSSysDBSchemeId(pSMOSFile.getPSModelId());
            if (!pSSysDBSchemeService.get(pSSysDBScheme, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysDBScheme.getPSSysModelGroupId(), (String)pSSysModelGroup.getPSSysModelGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysDBSchemeService.exportModelV2(pSSysDBScheme);
            pSSysDBScheme.reset();
            if (!pSSysDBSchemeService.setModelV2ResScope(pSSysDBScheme, "PSSYSMODELGROUP", pSSysModelGroup.getPSSysModelGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysDBSchemeService.importModelV2(pSSysDBScheme, objectNode);
            SessionFactoryManager.commit();
            return pSSysDBSchemeService.getFile(pSSysDBScheme);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysSearchSchemes(PSSysModelGroup pSSysModelGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSSEARCHSCHEME", true), (boolean)false) == 0) {
            PSSysSearchSchemeService pSSysSearchSchemeService = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
            PSSysSearchScheme pSSysSearchScheme = new PSSysSearchScheme();
            pSSysSearchScheme.setPSSysSearchSchemeId(pSMOSFile.getPSModelId());
            if (!pSSysSearchSchemeService.get(pSSysSearchScheme, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysSearchScheme.getPSSysModelGroupId(), (String)pSSysModelGroup.getPSSysModelGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysSearchSchemeService.exportModelV2(pSSysSearchScheme);
            pSSysSearchScheme.reset();
            if (!pSSysSearchSchemeService.setModelV2ResScope(pSSysSearchScheme, "PSSYSMODELGROUP", pSSysModelGroup.getPSSysModelGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysSearchSchemeService.importModelV2(pSSysSearchScheme, objectNode);
            SessionFactoryManager.commit();
            return pSSysSearchSchemeService.getFile(pSSysSearchScheme);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysUtilDEs(PSSysModelGroup pSSysModelGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSUTILDE", true), (boolean)false) == 0) {
            PSSysUtilDEService pSSysUtilDEService = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
            PSSysUtilDE pSSysUtilDE = new PSSysUtilDE();
            pSSysUtilDE.setPSSysUtilDEId(pSMOSFile.getPSModelId());
            if (!pSSysUtilDEService.get(pSSysUtilDE, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysUtilDE.getPSSysModelGroupId(), (String)pSSysModelGroup.getPSSysModelGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysUtilDEService.exportModelV2(pSSysUtilDE);
            pSSysUtilDE.reset();
            if (!pSSysUtilDEService.setModelV2ResScope(pSSysUtilDE, "PSSYSMODELGROUP", pSSysModelGroup.getPSSysModelGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysUtilDEService.importModelV2(pSSysUtilDE, objectNode);
            SessionFactoryManager.commit();
            return pSSysUtilDEService.getFile(pSSysUtilDE);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysModelGroup pSSysModelGroup, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSModules(pSSysModelGroup, list);
        this.onFillPasteHelps_PSSysBDSchemes(pSSysModelGroup, list);
        this.onFillPasteHelps_PSSysDBSchemes(pSSysModelGroup, list);
        this.onFillPasteHelps_PSSysSearchSchemes(pSSysModelGroup, list);
        this.onFillPasteHelps_PSSysUtilDEs(pSSysModelGroup, list);
        super.onFillPasteHelps(pSSysModelGroup, list);
    }

    protected void onFillPasteHelps_PSModules(PSSysModelGroup pSSysModelGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSMODULE");
        pSHelpSection.setSectionParam2("DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u6a21\u578b\u7ec4]\u7684[\u7cfb\u7edf\u6a21\u5757]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysBDSchemes(PSSysModelGroup pSSysModelGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBDSCHEME");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBDSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u6a21\u578b\u7ec4]\u7684[\u7cfb\u7edf\u5927\u6570\u636e\u4f53\u7cfb]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysDBSchemes(PSSysModelGroup pSSysModelGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSDBSCHEME");
        pSHelpSection.setSectionParam2("DER1N_PSSYSDBSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u6a21\u578b\u7ec4]\u7684[\u7cfb\u7edf\u6570\u636e\u5e93\u4f53\u7cfb]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysSearchSchemes(PSSysModelGroup pSSysModelGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSSEARCHSCHEME");
        pSHelpSection.setSectionParam2("DER1N_PSSYSSEARCHSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u6a21\u578b\u7ec4]\u7684[\u7cfb\u7edf\u5168\u6587\u68c0\u7d22\u4f53\u7cfb]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysUtilDEs(PSSysModelGroup pSSysModelGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSUTILDE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSUTILDE_PSSYSMODELGROUP_PSSYSMODELGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u6a21\u578b\u7ec4]\u7684[\u7cfb\u7edf\u529f\u80fd\u7ec4\u4ef6]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6a21\u5757>", "DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID", "PSSYSMODELGROUPID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSSysModelGroupServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6a21\u5757>");
            } else if (PSSysModelGroupServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psmodules");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID|PSSYSMODELGROUPID");
            pSMOSFile2.setFileTag3("PSMODULE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID", "PSSYSMODELGROUPID", pSMOSFile.getPSModelId(), "", "")) {
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSModuleService, "DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID", "PSSYSMODELGROUPID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSModuleService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysModelGroupServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSSysModelGroupServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6a21\u5757>", (boolean)false) == 0 || PSSysModelGroupServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSModules", (boolean)true) == 0) {
            PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSModuleService, "DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID", "PSSYSMODELGROUPID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSModule> arrayList2 = pSModuleService.selectEx((ISelectContext)selectContext);
            for (PSModule pSModule : arrayList2) {
                PSMOSFile pSMOSFile2 = pSModuleService.getFile(pSMOSFile, pSModule, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSMODULE_PSSYSMODELGROUP_PSSYSMODELGROUPID", (boolean)false) == 0) {
            if (PSSysModelGroupServiceBase.getMOSVer() == 1) {
                return "<\u6a21\u5757>";
            }
            if (PSSysModelGroupServiceBase.getMOSVer() == 2) {
                return "psmodules";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysModelGroup pSSysModelGroup, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("PSSYSMODELGROUPNAME", "\u6a21\u578b\u7ec4");
    }
}
