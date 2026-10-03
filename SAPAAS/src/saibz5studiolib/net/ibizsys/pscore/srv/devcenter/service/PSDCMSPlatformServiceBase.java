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
 *  net.ibizsys.paas.service.IServicePlugin
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

import java.sql.Timestamp;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCMSPlatformDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCClusterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpecBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFileBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatform;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMSPlatformServiceBase
extends PSCoreSysServiceBase<PSDCMSPlatform> {
    private static final Log log = LogFactory.getLog(PSDCMSPlatformServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_PUBCONFIGS = "PubConfigs";
    private PSDCMSPlatformDEModel pSDCMSPlatformDEModel;
    private PSDCMSPlatformDAO pSDCMSPlatformDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService";
    }

    public PSDCMSPlatformDEModel getPSDCMSPlatformDEModel() {
        if (this.pSDCMSPlatformDEModel == null) {
            try {
                this.pSDCMSPlatformDEModel = (PSDCMSPlatformDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCMSPlatformDEModel();
    }

    public PSDCMSPlatformDAO getPSDCMSPlatformDAO() {
        if (this.pSDCMSPlatformDAO == null) {
            try {
                this.pSDCMSPlatformDAO = (PSDCMSPlatformDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCMSPlatformDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCMSPlatformDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_PUBCONFIGS, (boolean)true) == 0) {
            this.pubConfigs((PSDCMSPlatform)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void pubConfigs(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PUBCONFIGS, 0, pSDCMSPlatform, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCMSPlatform, ACTION_PUBCONFIGS);
        final PSDCMSPlatform pSDCMSPlatform2 = pSDCMSPlatform;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCMSPlatformServiceBase.this.getService(), PSDCMSPlatformServiceBase.ACTION_PUBCONFIGS, 40, pSDCMSPlatform2, null).getResult() != 1) {
                    PSDCMSPlatformServiceBase.this.onPubConfigs(pSDCMSPlatform2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PUBCONFIGS, 99, pSDCMSPlatform, null);
        }
    }

    protected void onPubConfigs(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PubConfigs]");
    }

    protected void onFillParentInfo(PSDCMSPlatform pSDCMSPlatform, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORM_PSDCCLUSTER_PSDCCLUSTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService", (SessionFactory)this.getSessionFactory());
            PSDCCluster pSDCCluster = (PSDCCluster)iService.getDEModel().createEntity();
            pSDCCluster.set("PSDCCLUSTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCCluster);
            } else {
                iService.get(pSDCCluster);
            }
            this.onFillParentInfo_PSDCCluster(pSDCMSPlatform, pSDCCluster);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORM_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService", (SessionFactory)this.getSessionFactory());
            PSDCContainerSpec pSDCContainerSpec = (PSDCContainerSpec)iService.getDEModel().createEntity();
            pSDCContainerSpec.set("PSDCCONTAINERSPECID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCContainerSpec);
            } else {
                iService.get(pSDCContainerSpec);
            }
            this.onFillParentInfo_PSDCContainerSpec(pSDCMSPlatform, pSDCContainerSpec);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORM_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService", (SessionFactory)this.getSessionFactory());
            PSDCDeployCenter pSDCDeployCenter = (PSDCDeployCenter)iService.getDEModel().createEntity();
            pSDCDeployCenter.set("PSDCDEPLOYCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCDeployCenter);
            } else {
                iService.get(pSDCDeployCenter);
            }
            this.onFillParentInfo_PSDCDeployCenter(pSDCMSPlatform, pSDCDeployCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORM_PSDCFILE_PSDCFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCFileService", (SessionFactory)this.getSessionFactory());
            PSDCFile pSDCFile = (PSDCFile)iService.getDEModel().createEntity();
            pSDCFile.set("PSDCFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCFile);
            } else {
                iService.get(pSDCFile);
            }
            this.onFillParentInfo_PSDCFile(pSDCMSPlatform, pSDCFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORM_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCMSPlatform, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORM_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCMSPlatform, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORM_PSMSPLATFORM_PSMSPLATFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformService", (SessionFactory)this.getSessionFactory());
            PSMSPlatform pSMSPlatform = (PSMSPlatform)iService.getDEModel().createEntity();
            pSMSPlatform.set("PSMSPLATFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSMSPlatform);
            } else {
                iService.get(pSMSPlatform);
            }
            this.onFillParentInfo_PSMSPlatform(pSDCMSPlatform, pSMSPlatform);
            return;
        }
        super.onFillParentInfo(pSDCMSPlatform, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCCluster(PSDCMSPlatform pSDCMSPlatform, PSDCCluster pSDCCluster) throws Exception {
        pSDCMSPlatform.setPSDCClusterId(pSDCCluster.getPSDCClusterId());
        pSDCMSPlatform.setPSDCClusterName(pSDCCluster.getPSDCClusterName());
    }

    protected void onFillParentInfo_PSDCContainerSpec(PSDCMSPlatform pSDCMSPlatform, PSDCContainerSpec pSDCContainerSpec) throws Exception {
        pSDCMSPlatform.setPSDCContainerSpecId(pSDCContainerSpec.getPSDCContainerSpecId());
        pSDCMSPlatform.setPSDCContainerSpecName(pSDCContainerSpec.getPSDCContainerSpecName());
    }

    protected void onFillParentInfo_PSDCDeployCenter(PSDCMSPlatform pSDCMSPlatform, PSDCDeployCenter pSDCDeployCenter) throws Exception {
        pSDCMSPlatform.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
        pSDCMSPlatform.setPSDCDeployCenterName(pSDCDeployCenter.getPSDCDeployCenterName());
    }

    protected void onFillParentInfo_PSDCFile(PSDCMSPlatform pSDCMSPlatform, PSDCFile pSDCFile) throws Exception {
        pSDCMSPlatform.setPSDCFileId(pSDCFile.getPSDCFileId());
        pSDCMSPlatform.setPSDCFileName(pSDCFile.getPSDCFileName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCMSPlatform pSDCMSPlatform, PSDevCenter pSDevCenter) throws Exception {
        pSDCMSPlatform.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCMSPlatform.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCMSPlatform pSDCMSPlatform, PSDevSln pSDevSln) throws Exception {
        pSDCMSPlatform.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCMSPlatform.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSMSPlatform(PSDCMSPlatform pSDCMSPlatform, PSMSPlatform pSMSPlatform) throws Exception {
        pSDCMSPlatform.setPSMSPlatformId(pSMSPlatform.getPSMSPlatformId());
        pSDCMSPlatform.setPSMSPlatformName(pSMSPlatform.getPSMSPlatformName());
    }

    protected void onFillEntityFullInfo(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
        if (bl && pSDCMSPlatform.getValidFlag() == null) {
            pSDCMSPlatform.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDCMSPlatform, bl);
        this.onFillEntityFullInfo_PSDCCluster(pSDCMSPlatform, bl);
        this.onFillEntityFullInfo_PSDCContainerSpec(pSDCMSPlatform, bl);
        this.onFillEntityFullInfo_PSDCDeployCenter(pSDCMSPlatform, bl);
        this.onFillEntityFullInfo_PSDCFile(pSDCMSPlatform, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCMSPlatform, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCMSPlatform, bl);
        this.onFillEntityFullInfo_PSMSPlatform(pSDCMSPlatform, bl);
    }

    protected void onFillEntityFullInfo_PSDCCluster(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCContainerSpec(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCDeployCenter(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCFile(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
        if (pSDCMSPlatform.isPSDevCenterIdDirty()) {
            if (pSDCMSPlatform.getPSDevCenterId() != null) {
                if (pSDCMSPlatform.getPSDevCenterId() == null || pSDCMSPlatform.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCMSPlatform.getPSDevCenter();
                    pSDCMSPlatform.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCMSPlatform.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSMSPlatform(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
        if (pSDCMSPlatform.isPSMSPlatformIdDirty()) {
            if (pSDCMSPlatform.getPSMSPlatformId() != null) {
                if (pSDCMSPlatform.getPSMSPlatformId() == null || pSDCMSPlatform.getPSMSPlatformName() == null) {
                    PSMSPlatform pSMSPlatform = pSDCMSPlatform.getPSMSPlatform();
                    pSDCMSPlatform.setPSMSPlatformName(pSMSPlatform.getPSMSPlatformName());
                }
            } else {
                pSDCMSPlatform.setPSMSPlatformName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCMSPlatform, bl);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, "", -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, string, -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCLUSTERID", (Object)pSDCClusterBase.getPSDCClusterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCClusterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCClusterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, "", -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, string, -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCONTAINERSPECID", (Object)pSDCContainerSpecBase.getPSDCContainerSpecId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCContainerSpecCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCContainerSpecCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, "", -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, string, -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCDEPLOYCENTERID", (Object)pSDCDeployCenterBase.getPSDCDeployCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCDeployCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCDeployCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCFile(PSDCFileBase pSDCFileBase) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, "", -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, string, -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCFILEID", (Object)pSDCFileBase.getPSDCFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCMSPlatform> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCMSPlatform> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCMSPlatform> selectByPSMSPlatform(PSMSPlatformBase pSMSPlatformBase) throws Exception {
        return this.selectByPSMSPlatform(pSMSPlatformBase, "", -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSMSPlatform(PSMSPlatformBase pSMSPlatformBase, String string) throws Exception {
        return this.selectByPSMSPlatform(pSMSPlatformBase, string, -1);
    }

    public ArrayList<PSDCMSPlatform> selectByPSMSPlatform(PSMSPlatformBase pSMSPlatformBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMSPLATFORMID", (Object)pSMSPlatformBase.getPSMSPlatformId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSMSPlatformCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSMSPlatformCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCCluster(pSDCCluster, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCLUSTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCCluster);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSPLATFORM_PSDCCLUSTER_PSDCCLUSTERID", "", iDataEntityModel.getName(), "PSDCMSPLATFORM", iDataEntityModel.getDataInfo(pSDCCluster), arrayList.get(0)));
        }
    }

    public void resetPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCCluster(pSDCCluster);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            PSDCMSPlatform pSDCMSPlatform2 = (PSDCMSPlatform)this.getDEModel().createEntity();
            pSDCMSPlatform2.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
            pSDCMSPlatform2.setPSDCClusterId(null);
            this.update(pSDCMSPlatform2);
        }
    }

    public void removeByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        final PSDCCluster pSDCCluster2 = pSDCCluster;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformServiceBase.this.onBeforeRemoveByPSDCCluster(pSDCCluster2);
                PSDCMSPlatformServiceBase.this.internalRemoveByPSDCCluster(pSDCCluster2);
                PSDCMSPlatformServiceBase.this.onAfterRemoveByPSDCCluster(pSDCCluster2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void internalRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCCluster(pSDCCluster);
        this.onBeforeRemoveByPSDCCluster(pSDCCluster, arrayList);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            this.remove(pSDCMSPlatform);
        }
        this.onAfterRemoveByPSDCCluster(pSDCCluster, arrayList);
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    public void testRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCONTAINERSPEC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCContainerSpec);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSPLATFORM_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", "", iDataEntityModel.getName(), "PSDCMSPLATFORM", iDataEntityModel.getDataInfo(pSDCContainerSpec), arrayList.get(0)));
        }
    }

    public void resetPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            PSDCMSPlatform pSDCMSPlatform2 = (PSDCMSPlatform)this.getDEModel().createEntity();
            pSDCMSPlatform2.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
            pSDCMSPlatform2.setPSDCContainerSpecId(null);
            this.update(pSDCMSPlatform2);
        }
    }

    public void removeByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        final PSDCContainerSpec pSDCContainerSpec2 = pSDCContainerSpec;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformServiceBase.this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDCMSPlatformServiceBase.this.internalRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDCMSPlatformServiceBase.this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void internalRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            this.remove(pSDCMSPlatform);
        }
        this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    public void testRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCDEPLOYCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCDeployCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSPLATFORM_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", "", iDataEntityModel.getName(), "PSDCMSPLATFORM", iDataEntityModel.getDataInfo(pSDCDeployCenter), arrayList.get(0)));
        }
    }

    public void resetPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            PSDCMSPlatform pSDCMSPlatform2 = (PSDCMSPlatform)this.getDEModel().createEntity();
            pSDCMSPlatform2.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
            pSDCMSPlatform2.setPSDCDeployCenterId(null);
            this.update(pSDCMSPlatform2);
        }
    }

    public void removeByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        final PSDCDeployCenter pSDCDeployCenter2 = pSDCDeployCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformServiceBase.this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDCMSPlatformServiceBase.this.internalRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDCMSPlatformServiceBase.this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void internalRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            this.remove(pSDCMSPlatform);
        }
        this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    public void testRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCFile(pSDCFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSPLATFORM_PSDCFILE_PSDCFILEID", "", iDataEntityModel.getName(), "PSDCMSPLATFORM", iDataEntityModel.getDataInfo(pSDCFile), arrayList.get(0)));
        }
    }

    public void resetPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCFile(pSDCFile);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            PSDCMSPlatform pSDCMSPlatform2 = (PSDCMSPlatform)this.getDEModel().createEntity();
            pSDCMSPlatform2.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
            pSDCMSPlatform2.setPSDCFileId(null);
            this.update(pSDCMSPlatform2);
        }
    }

    public void removeByPSDCFile(PSDCFile pSDCFile) throws Exception {
        final PSDCFile pSDCFile2 = pSDCFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformServiceBase.this.onBeforeRemoveByPSDCFile(pSDCFile2);
                PSDCMSPlatformServiceBase.this.internalRemoveByPSDCFile(pSDCFile2);
                PSDCMSPlatformServiceBase.this.onAfterRemoveByPSDCFile(pSDCFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void internalRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDCFile(pSDCFile);
        this.onBeforeRemoveByPSDCFile(pSDCFile, arrayList);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            this.remove(pSDCMSPlatform);
        }
        this.onAfterRemoveByPSDCFile(pSDCFile, arrayList);
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSPLATFORM_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCMSPLATFORM", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            PSDCMSPlatform pSDCMSPlatform2 = (PSDCMSPlatform)this.getDEModel().createEntity();
            pSDCMSPlatform2.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
            pSDCMSPlatform2.setPSDevCenterId(null);
            this.update(pSDCMSPlatform2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCMSPlatformServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCMSPlatformServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            this.remove(pSDCMSPlatform);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSPLATFORM_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDCMSPLATFORM", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            PSDCMSPlatform pSDCMSPlatform2 = (PSDCMSPlatform)this.getDEModel().createEntity();
            pSDCMSPlatform2.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
            pSDCMSPlatform2.setPSDevSlnId(null);
            this.update(pSDCMSPlatform2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCMSPlatformServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCMSPlatformServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            this.remove(pSDCMSPlatform);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    public void testRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSMSPlatform(pSMSPlatform, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMSPLATFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSMSPlatform);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSPLATFORM_PSMSPLATFORM_PSMSPLATFORMID", "", iDataEntityModel.getName(), "PSDCMSPLATFORM", iDataEntityModel.getDataInfo(pSMSPlatform), arrayList.get(0)));
        }
    }

    public void resetPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSMSPlatform(pSMSPlatform);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            PSDCMSPlatform pSDCMSPlatform2 = (PSDCMSPlatform)this.getDEModel().createEntity();
            pSDCMSPlatform2.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
            pSDCMSPlatform2.setPSMSPlatformId(null);
            this.update(pSDCMSPlatform2);
        }
    }

    public void removeByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
        final PSMSPlatform pSMSPlatform2 = pSMSPlatform;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformServiceBase.this.onBeforeRemoveByPSMSPlatform(pSMSPlatform2);
                PSDCMSPlatformServiceBase.this.internalRemoveByPSMSPlatform(pSMSPlatform2);
                PSDCMSPlatformServiceBase.this.onAfterRemoveByPSMSPlatform(pSMSPlatform2);
            }
        });
    }

    protected void onBeforeRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
    }

    protected void internalRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
        ArrayList<PSDCMSPlatform> arrayList = this.selectByPSMSPlatform(pSMSPlatform);
        this.onBeforeRemoveByPSMSPlatform(pSMSPlatform, arrayList);
        for (PSDCMSPlatform pSDCMSPlatform : arrayList) {
            this.remove(pSDCMSPlatform);
        }
        this.onAfterRemoveByPSMSPlatform(pSMSPlatform, arrayList);
    }

    protected void onAfterRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
    }

    protected void onBeforeRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform, ArrayList<PSDCMSPlatform> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCMSPlatformFuncService)ServiceGlobal.getService(PSDCMSPlatformFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMSPlatformFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDCMSPlatform(pSDCMSPlatform);
        ((PSDCMSPlatformFuncServiceBase)pSCoreSysServiceBase).removeByPSDCMSPlatform(pSDCMSPlatform);
        pSCoreSysServiceBase = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMSPlatformNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDCMSPlatform(pSDCMSPlatform);
        ((PSDCMSPlatformNodeServiceBase)pSCoreSysServiceBase).removeByPSDCMSPlatform(pSDCMSPlatform);
        pSCoreSysServiceBase = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnServiceBase)pSCoreSysServiceBase).testRemoveByPSDCMSPlatform(pSDCMSPlatform);
        pSCoreSysServiceBase = (PSDevSlnMSDeployService)ServiceGlobal.getService(PSDevSlnMSDeployService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDeployServiceBase)pSCoreSysServiceBase).testRemoveByPSDCMSPlatform(pSDCMSPlatform);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDCMSPlatform(pSDCMSPlatform);
        super.onBeforeRemove(pSDCMSPlatform);
    }

    protected void replaceParentInfo(PSDCMSPlatform pSDCMSPlatform, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCMSPlatform, cloneSession);
        if (pSDCMSPlatform.getPSDCClusterId() != null && (iEntity = cloneSession.getEntity("PSDCCLUSTER", (Object)pSDCMSPlatform.getPSDCClusterId())) != null) {
            this.onFillParentInfo_PSDCCluster(pSDCMSPlatform, (PSDCCluster)iEntity);
        }
        if (pSDCMSPlatform.getPSDCContainerSpecId() != null && (iEntity = cloneSession.getEntity("PSDCCONTAINERSPEC", (Object)pSDCMSPlatform.getPSDCContainerSpecId())) != null) {
            this.onFillParentInfo_PSDCContainerSpec(pSDCMSPlatform, (PSDCContainerSpec)iEntity);
        }
        if (pSDCMSPlatform.getPSDCDeployCenterId() != null && (iEntity = cloneSession.getEntity("PSDCDEPLOYCENTER", (Object)pSDCMSPlatform.getPSDCDeployCenterId())) != null) {
            this.onFillParentInfo_PSDCDeployCenter(pSDCMSPlatform, (PSDCDeployCenter)iEntity);
        }
        if (pSDCMSPlatform.getPSDCFileId() != null && (iEntity = cloneSession.getEntity("PSDCFILE", (Object)pSDCMSPlatform.getPSDCFileId())) != null) {
            this.onFillParentInfo_PSDCFile(pSDCMSPlatform, (PSDCFile)iEntity);
        }
        if (pSDCMSPlatform.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCMSPlatform.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCMSPlatform, (PSDevCenter)iEntity);
        }
        if (pSDCMSPlatform.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCMSPlatform.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCMSPlatform, (PSDevSln)iEntity);
        }
        if (pSDCMSPlatform.getPSMSPlatformId() != null && (iEntity = cloneSession.getEntity("PSMSPLATFORM", (Object)pSDCMSPlatform.getPSMSPlatformId())) != null) {
            this.onFillParentInfo_PSMSPlatform(pSDCMSPlatform, (PSMSPlatform)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCMSPlatform, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminPasswd(bl, pSDCMSPlatform, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AdminUserName(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgServiceUrl(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClusterNamespace(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSType(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCClusterId(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCContainerSpecId(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployCenterId(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCFileId(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformId(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformName(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformId(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformName(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCount(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResVer(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceUrl(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WebConsolePath(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSDCMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCMSPlatform, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminPasswd(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isAdminPasswdDirty() : !pSDCMSPlatform.isAdminPasswdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getAdminPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminPasswd_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AdminUserName(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isAdminUserNameDirty() : !pSDCMSPlatform.isAdminUserNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getAdminUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminUserName_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CfgServiceUrl(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isCfgServiceUrlDirty() : !pSDCMSPlatform.isCfgServiceUrlDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getCfgServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgServiceUrl_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGSERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClusterNamespace(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isClusterNamespaceDirty() : !pSDCMSPlatform.isClusterNamespaceDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getClusterNamespace();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClusterNamespace_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLUSTERNAMESPACE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isExpriedTimeDirty() : !pSDCMSPlatform.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCMSPlatform.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPRIEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isIpAddrDirty() : !pSDCMSPlatform.isIpAddrDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isIpAddr2Dirty() : !pSDCMSPlatform.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isMemoDirty() : !pSDCMSPlatform.isMemoDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_MSType(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isMSTypeDirty() && !bl2 : !pSDCMSPlatform.isMSTypeDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getMSType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSType_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPasswdDirty() : !pSDCMSPlatform.isPasswdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Port(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPortDirty() : !pSDCMSPlatform.isPortDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatform.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCClusterId(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSDCClusterIdDirty() : !pSDCMSPlatform.isPSDCClusterIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSDCClusterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCClusterId_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCLUSTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCContainerSpecId(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSDCContainerSpecIdDirty() : !pSDCMSPlatform.isPSDCContainerSpecIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSDCContainerSpecId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCContainerSpecId_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCONTAINERSPECID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDeployCenterId(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSDCDeployCenterIdDirty() : !pSDCMSPlatform.isPSDCDeployCenterIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSDCDeployCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployCenterId_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCFileId(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSDCFileIdDirty() : !pSDCMSPlatform.isPSDCFileIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSDCFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCFileId_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformId(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSDCMSPlatformIdDirty() && !bl2 : !pSDCMSPlatform.isPSDCMSPlatformIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSDCMSPlatformId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformId_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformName(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSDCMSPlatformNameDirty() && !bl2 : !pSDCMSPlatform.isPSDCMSPlatformNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSDCMSPlatformName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformName_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSDevCenterIdDirty() && !bl2 : !pSDCMSPlatform.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSDevCenterNameDirty() && !bl2 : !pSDCMSPlatform.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSDevSlnIdDirty() : !pSDCMSPlatform.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMSPlatformId(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSMSPlatformIdDirty() : !pSDCMSPlatform.isPSMSPlatformIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSMSPlatformId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformId_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMSPlatformName(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isPSMSPlatformNameDirty() : !pSDCMSPlatform.isPSMSPlatformNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getPSMSPlatformName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformName_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCount(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isRefCountDirty() : !pSDCMSPlatform.isRefCountDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatform.getRefCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefCount_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCOUNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isResPosDirty() : !pSDCMSPlatform.isResPosDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatform.getResPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isResReadyTimeDirty() : !pSDCMSPlatform.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCMSPlatform.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESREADYTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isResStateDirty() : !pSDCMSPlatform.isResStateDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatform.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDCMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResVer(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isResVerDirty() : !pSDCMSPlatform.isResVerDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatform.getResVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResVer_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceUrl(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isServiceUrlDirty() : !pSDCMSPlatform.isServiceUrlDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceUrl_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isSSHIPAddrDirty() : !pSDCMSPlatform.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHIPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isSSHPortDirty() : !pSDCMSPlatform.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatform.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isUploadFileModeDirty() : !pSDCMSPlatform.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADFILEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isUploadPathDirty() : !pSDCMSPlatform.isUploadPathDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isUserNameDirty() : !pSDCMSPlatform.isUserNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isUserParamsDirty() : !pSDCMSPlatform.isUserParamsDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDCMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isUserTagDirty() : !pSDCMSPlatform.isUserTagDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDCMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isUserTag2Dirty() : !pSDCMSPlatform.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDCMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isUserTag3Dirty() : !pSDCMSPlatform.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDCMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isUserTag4Dirty() : !pSDCMSPlatform.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDCMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isValidFlagDirty() && !bl2 : !pSDCMSPlatform.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatform.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_WebConsolePath(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isWebConsolePathDirty() : !pSDCMSPlatform.isWebConsolePathDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getWebConsolePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WebConsolePath_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WEBCONSOLEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSDCMSPlatform pSDCMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatform.isWorkshopPathDirty() : !pSDCMSPlatform.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSDCMSPlatform.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default(pSDCMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKSHOPPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
        super.onSyncEntity(pSDCMSPlatform, bl);
    }

    protected void onSyncIndexEntities(PSDCMSPlatform pSDCMSPlatform, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCMSPlatform, bl);
    }

    public Object getDataContextValue(PSDCMSPlatform pSDCMSPlatform, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCMSPlatform, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevCenter pSDevCenter = pSDCMSPlatform.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCMSPlatform pSDCMSPlatform, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCMSPlatform, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGSERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLUSTERNAMESPACE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClusterNamespace_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Port_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCLUSTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCClusterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCLUSTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCClusterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCOUNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCount_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHIPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHIPAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADFILEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadFileMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WEBCONSOLEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WebConsolePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSHOPPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopPath_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AdminPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINUSERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGSERVICEURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClusterNamespace_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLUSTERNAMESPACE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IpAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IpAddr2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_MSType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Passwd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Port_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCClusterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCLUSTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCClusterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCLUSTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCContainerSpecId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCONTAINERSPECID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCContainerSpecName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCONTAINERSPECNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDeployCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDeployCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSMSPlatformId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMSPlatformName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCount_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SSHIPAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SSHIPADDR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SSHPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UploadFileMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADFILEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UploadPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_WebConsolePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WEBCONSOLEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WorkshopPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WORKSHOPPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDCMSPlatform pSDCMSPlatform) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCMSPlatform)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        super.onUpdateParent(pSDCMSPlatform);
    }

    @Override
    protected void exportCurXmlModel(PSDCMSPlatform pSDCMSPlatform, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMSPLATFORM");
        if (!bl) {
            pSDCMSPlatform.setCreateDate(null);
            pSDCMSPlatform.setCreateMan(null);
            pSDCMSPlatform.setPSDCMSPlatformId(null);
            pSDCMSPlatform.setPSDevSlnName(null);
            pSDCMSPlatform.setRefCount(null);
            pSDCMSPlatform.setUpdateDate(null);
            pSDCMSPlatform.setUpdateMan(null);
            super.exportCurXmlModel(pSDCMSPlatform, xmlNode, bl);
        }
    }
}

