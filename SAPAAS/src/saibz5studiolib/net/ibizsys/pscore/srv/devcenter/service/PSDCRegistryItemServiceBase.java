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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCRegistryItemDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRegistryItemDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepoBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeployBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRegistryItemServiceBase
extends PSCoreSysServiceBase<PSDCRegistryItem> {
    private static final Log log = LogFactory.getLog(PSDCRegistryItemServiceBase.class);
    public static final String DATASET_CODESERVER = "CodeServer";
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURDC2 = "CurDC2";
    public static final String DATASET_CURDCAPI = "CurDCAPI";
    public static final String DATASET_CURDCAPI2 = "CurDCAPI2";
    public static final String DATASET_CURDCANDSLN = "CurDCAndSln";
    public static final String DATASET_CURDCANDSLNGENERATOR = "CurDCAndSlnGenerator";
    public static final String DATASET_CURDCAPP = "CurDCApp";
    public static final String DATASET_CURDCAPP2 = "CurDCApp2";
    public static final String DATASET_CURDCCODESERVER = "CurDCCodeServer";
    public static final String DATASET_CURDCCODESERVER2 = "CurDCCodeServer2";
    public static final String DATASET_CURDCGENERATOR = "CurDCGenerator";
    public static final String DATASET_CURDCGENERATOR2 = "CurDCGenerator2";
    public static final String DATASET_CURDCRUNNER = "CurDCRunner";
    public static final String DATASET_CURDCRUNNER2 = "CurDCRunner2";
    public static final String DATASET_CURREPO = "CurRepo";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURSLNGENERATOR = "CurSlnGenerator";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSAPI = "CurSysAPI";
    public static final String DATASET_CURSYSAPP = "CurSysApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_GENERATOR = "Generator";
    public static final String DATASET_RUNNER = "Runner";
    public static final String DATASET_TOOL = "Tool";
    private PSDCRegistryItemDEModel pSDCRegistryItemDEModel;
    private PSDCRegistryItemDAO pSDCRegistryItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService";
    }

    public PSDCRegistryItemDEModel getPSDCRegistryItemDEModel() {
        if (this.pSDCRegistryItemDEModel == null) {
            try {
                this.pSDCRegistryItemDEModel = (PSDCRegistryItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRegistryItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRegistryItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCRegistryItemDEModel();
    }

    public PSDCRegistryItemDAO getPSDCRegistryItemDAO() {
        if (this.pSDCRegistryItemDAO == null) {
            try {
                this.pSDCRegistryItemDAO = (PSDCRegistryItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCRegistryItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRegistryItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCRegistryItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CODESERVER, (boolean)true) == 0) {
            return this.fetchCodeServer(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDC2, (boolean)true) == 0) {
            return this.fetchCurDC2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCAPI, (boolean)true) == 0) {
            return this.fetchCurDCAPI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCAPI2, (boolean)true) == 0) {
            return this.fetchCurDCAPI2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCANDSLN, (boolean)true) == 0) {
            return this.fetchCurDCAndSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCANDSLNGENERATOR, (boolean)true) == 0) {
            return this.fetchCurDCAndSlnGenerator(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCAPP, (boolean)true) == 0) {
            return this.fetchCurDCApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCAPP2, (boolean)true) == 0) {
            return this.fetchCurDCApp2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCCODESERVER, (boolean)true) == 0) {
            return this.fetchCurDCCodeServer(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCCODESERVER2, (boolean)true) == 0) {
            return this.fetchCurDCCodeServer2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCGENERATOR, (boolean)true) == 0) {
            return this.fetchCurDCGenerator(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCGENERATOR2, (boolean)true) == 0) {
            return this.fetchCurDCGenerator2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCRUNNER, (boolean)true) == 0) {
            return this.fetchCurDCRunner(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCRUNNER2, (boolean)true) == 0) {
            return this.fetchCurDCRunner2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURREPO, (boolean)true) == 0) {
            return this.fetchCurRepo(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNGENERATOR, (boolean)true) == 0) {
            return this.fetchCurSlnGenerator(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPI, (boolean)true) == 0) {
            return this.fetchCurSysAPI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPP, (boolean)true) == 0) {
            return this.fetchCurSysApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_GENERATOR, (boolean)true) == 0) {
            return this.fetchGenerator(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_RUNNER, (boolean)true) == 0) {
            return this.fetchRunner(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_TOOL, (boolean)true) == 0) {
            return this.fetchTool(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCodeServer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CODESERVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDC2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCAPI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCAPI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCAPI2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCAPI2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCAndSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCANDSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCAndSlnGenerator(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCANDSLNGENERATOR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCApp2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCAPP2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCCodeServer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCCODESERVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCCodeServer2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCCODESERVER2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCGenerator(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCGENERATOR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCGenerator2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCGENERATOR2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCRunner(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCRUNNER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCRunner2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCRUNNER2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurRepo(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURREPO, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSlnGenerator(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNGENERATOR, false);
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

    public DBFetchResult fetchCurSysApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchGenerator(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_GENERATOR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchRunner(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_RUNNER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTool(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_TOOL, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDCRegistryItem pSDCRegistryItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYITEM_PSDCREGISTRYREPO_PSDCREGISTRYREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryRepo pSDCRegistryRepo = (PSDCRegistryRepo)iService.getDEModel().createEntity();
            pSDCRegistryRepo.set("PSDCREGISTRYREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRegistryRepo);
            } else {
                iService.get(pSDCRegistryRepo);
            }
            this.onFillParentInfo_PSDCRegistryRepo(pSDCRegistryItem, pSDCRegistryRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYITEM_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDCRegistryItem, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYITEM_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDeploy pSDevSlnMSDeploy = (PSDevSlnMSDeploy)iService.getDEModel().createEntity();
            pSDevSlnMSDeploy.set("PSDEVSLNMSDEPLOYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnMSDeploy);
            } else {
                iService.get(pSDevSlnMSDeploy);
            }
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDCRegistryItem, pSDevSlnMSDeploy);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYITEM_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDCRegistryItem, pSDevSlnSys);
            return;
        }
        super.onFillParentInfo(pSDCRegistryItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCRegistryRepo(PSDCRegistryItem pSDCRegistryItem, PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        pSDCRegistryItem.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
        pSDCRegistryItem.setPSDCRegistryRepoName(pSDCRegistryRepo.getPSDCRegistryRepoName());
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDCRegistryItem pSDCRegistryItem, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDCRegistryItem.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDCRegistryItem.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevSlnMSDeploy(PSDCRegistryItem pSDCRegistryItem, PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        pSDCRegistryItem.setPSDevSlnMSDeployId(pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
        pSDCRegistryItem.setPSDevSlnMSDeployName(pSDevSlnMSDeploy.getPSDevSlnMSDeployName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDCRegistryItem pSDCRegistryItem, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDCRegistryItem.setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
        pSDCRegistryItem.setPSDevSlnName(pSDevSlnSys.getPSDevSlnName());
        pSDCRegistryItem.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDCRegistryItem.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDCRegistryItem pSDCRegistryItem, boolean bl) throws Exception {
        if (bl && pSDCRegistryItem.getValidFlag() == null) {
            pSDCRegistryItem.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDCRegistryItem, bl);
        this.onFillEntityFullInfo_PSDCRegistryRepo(pSDCRegistryItem, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDCRegistryItem, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDeploy(pSDCRegistryItem, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDCRegistryItem, bl);
    }

    protected void onFillEntityFullInfo_PSDCRegistryRepo(PSDCRegistryItem pSDCRegistryItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDCRegistryItem pSDCRegistryItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDeploy(PSDCRegistryItem pSDCRegistryItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDCRegistryItem pSDCRegistryItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDCRegistryItem pSDCRegistryItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCRegistryItem, bl);
    }

    public ArrayList<PSDCRegistryItem> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase) throws Exception {
        return this.selectByPSDCRegistryRepo(pSDCRegistryRepoBase, "", -1);
    }

    public ArrayList<PSDCRegistryItem> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase, String string) throws Exception {
        return this.selectByPSDCRegistryRepo(pSDCRegistryRepoBase, string, -1);
    }

    public ArrayList<PSDCRegistryItem> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCREGISTRYREPOID", (Object)pSDCRegistryRepoBase.getPSDCRegistryRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCRegistryRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCRegistryRepoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCRegistryItem> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDCRegistryItem> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDCRegistryItem> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCRegistryItem> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, "", -1);
    }

    public ArrayList<PSDCRegistryItem> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, string, -1);
    }

    public ArrayList<PSDCRegistryItem> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPLOYID", (Object)pSDevSlnMSDeployBase.getPSDevSlnMSDeployId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnMSDeployCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnMSDeployCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCRegistryItem> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDCRegistryItem> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDCRegistryItem> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCRegistryRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYITEM_PSDCREGISTRYREPO_PSDCREGISTRYREPOID", "", iDataEntityModel.getName(), "PSDCREGISTRYITEM", iDataEntityModel.getDataInfo(pSDCRegistryRepo), arrayList.get(0)));
        }
    }

    public void resetPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo);
        for (PSDCRegistryItem pSDCRegistryItem : arrayList) {
            PSDCRegistryItem pSDCRegistryItem2 = (PSDCRegistryItem)this.getDEModel().createEntity();
            pSDCRegistryItem2.setPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
            pSDCRegistryItem2.setPSDCRegistryRepoId(null);
            this.update(pSDCRegistryItem2);
        }
    }

    public void removeByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        final PSDCRegistryRepo pSDCRegistryRepo2 = pSDCRegistryRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryItemServiceBase.this.onBeforeRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
                PSDCRegistryItemServiceBase.this.internalRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
                PSDCRegistryItemServiceBase.this.onAfterRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
    }

    protected void internalRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo);
        this.onBeforeRemoveByPSDCRegistryRepo(pSDCRegistryRepo, arrayList);
        for (PSDCRegistryItem pSDCRegistryItem : arrayList) {
            this.remove(pSDCRegistryItem);
        }
        this.onAfterRemoveByPSDCRegistryRepo(pSDCRegistryRepo, arrayList);
    }

    protected void onAfterRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, ArrayList<PSDCRegistryItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, ArrayList<PSDCRegistryItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYITEM_PSDEVCENTERSVN_PSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDCREGISTRYITEM", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDCRegistryItem pSDCRegistryItem : arrayList) {
            PSDCRegistryItem pSDCRegistryItem2 = (PSDCRegistryItem)this.getDEModel().createEntity();
            pSDCRegistryItem2.setPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
            pSDCRegistryItem2.setPSDevCenterSVNId(null);
            this.update(pSDCRegistryItem2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryItemServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDCRegistryItemServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDCRegistryItemServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDCRegistryItem pSDCRegistryItem : arrayList) {
            this.remove(pSDCRegistryItem);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDCRegistryItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDCRegistryItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNMSDEPLOY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnMSDeploy);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYITEM_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", "", iDataEntityModel.getName(), "PSDCREGISTRYITEM", iDataEntityModel.getDataInfo(pSDevSlnMSDeploy), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        for (PSDCRegistryItem pSDCRegistryItem : arrayList) {
            PSDCRegistryItem pSDCRegistryItem2 = (PSDCRegistryItem)this.getDEModel().createEntity();
            pSDCRegistryItem2.setPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
            pSDCRegistryItem2.setPSDevSlnMSDeployId(null);
            this.update(pSDCRegistryItem2);
        }
    }

    public void removeByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        final PSDevSlnMSDeploy pSDevSlnMSDeploy2 = pSDevSlnMSDeploy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryItemServiceBase.this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDCRegistryItemServiceBase.this.internalRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDCRegistryItemServiceBase.this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
        for (PSDCRegistryItem pSDCRegistryItem : arrayList) {
            this.remove(pSDCRegistryItem);
        }
        this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDCRegistryItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDCRegistryItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDCRegistryItem pSDCRegistryItem : arrayList) {
            PSDCRegistryItem pSDCRegistryItem2 = (PSDCRegistryItem)this.getDEModel().createEntity();
            pSDCRegistryItem2.setPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
            pSDCRegistryItem2.setPSDevSlnSysId(null);
            this.update(pSDCRegistryItem2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryItemServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDCRegistryItemServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDCRegistryItemServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDCRegistryItem> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDCRegistryItem pSDCRegistryItem : arrayList) {
            this.remove(pSDCRegistryItem);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDCRegistryItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDCRegistryItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMSPlatformNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDCRegistryItem(pSDCRegistryItem);
        pSCoreSysServiceBase = (PSDevSlnPipelineStageService)ServiceGlobal.getService(PSDevSlnPipelineStageService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStageServiceBase)pSCoreSysServiceBase).testRemoveByAgentPSDCRegistryItem(pSDCRegistryItem);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByAgentPSDCRegistryItem(pSDCRegistryItem);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDCRegistryItem(pSDCRegistryItem);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByToolPSDCRegistryItem(pSDCRegistryItem);
        pSCoreSysServiceBase = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDCRegistryItem(pSDCRegistryItem);
        super.onBeforeRemove(pSDCRegistryItem);
    }

    protected void replaceParentInfo(PSDCRegistryItem pSDCRegistryItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCRegistryItem, cloneSession);
        if (pSDCRegistryItem.getPSDCRegistryRepoId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYREPO", (Object)pSDCRegistryItem.getPSDCRegistryRepoId())) != null) {
            this.onFillParentInfo_PSDCRegistryRepo(pSDCRegistryItem, (PSDCRegistryRepo)iEntity);
        }
        if (pSDCRegistryItem.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDCRegistryItem.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDCRegistryItem, (PSDevCenterSVN)iEntity);
        }
        if (pSDCRegistryItem.getPSDevSlnMSDeployId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPLOY", (Object)pSDCRegistryItem.getPSDevSlnMSDeployId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDCRegistryItem, (PSDevSlnMSDeploy)iEntity);
        }
        if (pSDCRegistryItem.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDCRegistryItem.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDCRegistryItem, (PSDevSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCRegistryItem pSDCRegistryItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCRegistryItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ConnStr(bl, pSDCRegistryItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DockerFile(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParams(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag2(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag3(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag4(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryItemId(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryItemName(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryRepoId(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDeployId(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tags(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCRegistryItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCRegistryItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isConnStrDirty() : !pSDCRegistryItem.isConnStrDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getConnStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DockerFile(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isDockerFileDirty() : !pSDCRegistryItem.isDockerFileDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getDockerFile();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DockerFile_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCKERFILE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParams(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isItemParamsDirty() : !pSDCRegistryItem.isItemParamsDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getItemParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParams_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isItemTagDirty() : !pSDCRegistryItem.isItemTagDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getItemTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag2(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isItemTag2Dirty() : !pSDCRegistryItem.isItemTag2Dirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getItemTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag2_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag3(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isItemTag3Dirty() : !pSDCRegistryItem.isItemTag3Dirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getItemTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag3_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag4(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isItemTag4Dirty() : !pSDCRegistryItem.isItemTag4Dirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getItemTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag4_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isLogicNameDirty() : !pSDCRegistryItem.isLogicNameDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isMemoDirty() : !pSDCRegistryItem.isMemoDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCRegistryItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRegistryItemId(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isPSDCRegistryItemIdDirty() && !bl2 : !pSDCRegistryItem.isPSDCRegistryItemIdDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getPSDCRegistryItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryItemId_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRegistryItemName(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isPSDCRegistryItemNameDirty() && !bl2 : !pSDCRegistryItem.isPSDCRegistryItemNameDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getPSDCRegistryItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryItemName_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRegistryRepoId(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isPSDCRegistryRepoIdDirty() : !pSDCRegistryItem.isPSDCRegistryRepoIdDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getPSDCRegistryRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryRepoId_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isPSDevCenterSVNIdDirty() : !pSDCRegistryItem.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDeployId(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isPSDevSlnMSDeployIdDirty() : !pSDCRegistryItem.isPSDevSlnMSDeployIdDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getPSDevSlnMSDeployId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDeployId_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isPSDevSlnSysIdDirty() : !pSDCRegistryItem.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isResStateDirty() : !pSDCRegistryItem.isResStateDirty()) {
            return null;
        }
        Integer n = pSDCRegistryItem.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDCRegistryItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tags(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isTagsDirty() : !pSDCRegistryItem.isTagsDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tags_Default(pSDCRegistryItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isUserCatDirty() : !pSDCRegistryItem.isUserCatDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDCRegistryItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isUserTagDirty() : !pSDCRegistryItem.isUserTagDirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDCRegistryItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isUserTag2Dirty() : !pSDCRegistryItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDCRegistryItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isUserTag3Dirty() : !pSDCRegistryItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDCRegistryItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isUserTag4Dirty() : !pSDCRegistryItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDCRegistryItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDCRegistryItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCRegistryItem pSDCRegistryItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryItem.isValidFlagDirty() : !pSDCRegistryItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCRegistryItem.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCRegistryItem, bl2, bl3);
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

    protected void onSyncEntity(PSDCRegistryItem pSDCRegistryItem, boolean bl) throws Exception {
        super.onSyncEntity(pSDCRegistryItem, bl);
    }

    protected void onSyncIndexEntities(PSDCRegistryItem pSDCRegistryItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCRegistryItem, bl);
    }

    public Object getDataContextValue(PSDCRegistryItem pSDCRegistryItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCRegistryItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCRegistryRepo pSDCRegistryRepo = pSDCRegistryItem.getPSDCRegistryRepo();
        if (pSDCRegistryRepo != null && pSDCRegistryRepo.contains(string)) {
            return pSDCRegistryRepo.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCRegistryItem pSDCRegistryItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCRegistryItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONNSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConnStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCKERFILE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DockerFile_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPLOYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDeployId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPLOYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDeployName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ConnStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNSTR", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_DockerFile_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCKERFILE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_PSDCRegistryItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRegistryItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRegistryRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRegistryRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDeployId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPLOYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDeployName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPLOYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDCRegistryItem pSDCRegistryItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCRegistryItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        super.onUpdateParent(pSDCRegistryItem);
    }

    @Override
    protected void exportCurXmlModel(PSDCRegistryItem pSDCRegistryItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCREGISTRYITEM");
        if (!bl) {
            pSDCRegistryItem.setCreateDate(null);
            pSDCRegistryItem.setCreateMan(null);
            pSDCRegistryItem.setPSDCRegistryItemId(null);
            pSDCRegistryItem.setUpdateDate(null);
            pSDCRegistryItem.setUpdateMan(null);
            super.exportCurXmlModel(pSDCRegistryItem, xmlNode, bl);
        }
    }
}

