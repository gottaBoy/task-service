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
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCClusterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnBDInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnBDInstServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnDBInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnDBInstServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnFileService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnFileServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnLogService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnLogServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnMQInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnMQInstServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModeService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModeServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnParamService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnParamServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDBService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDBServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysMQService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysMQServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnUserService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnUserServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnWFEngineInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnWFEngineInstServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSdepSlnDepSessionService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSdepSlnDepSessionServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnServiceBase
extends PSCoreSysServiceBase<PSDepSln> {
    private static final Log log = LogFactory.getLog(PSDepSlnServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnDEModel pSDepSlnDEModel;
    private PSDepSlnDAO pSDepSlnDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService";
    }

    public PSDepSlnDEModel getPSDepSlnDEModel() {
        if (this.pSDepSlnDEModel == null) {
            try {
                this.pSDepSlnDEModel = (PSDepSlnDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnDEModel();
    }

    public PSDepSlnDAO getPSDepSlnDAO() {
        if (this.pSDepSlnDAO == null) {
            try {
                this.pSDepSlnDAO = (PSDepSlnDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSln pSDepSln, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLN_PSDCCLUSTER_PSDCCLUSTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService", (SessionFactory)this.getSessionFactory());
            PSDCCluster pSDCCluster = (PSDCCluster)iService.getDEModel().createEntity();
            pSDCCluster.set("PSDCCLUSTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCCluster);
            } else {
                iService.get(pSDCCluster);
            }
            this.onFillParentInfo_PSDCCluster(pSDepSln, pSDCCluster);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLN_PSDCMSPLATFORM_PSDCMSPLATFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatform pSDCMSPlatform = (PSDCMSPlatform)iService.getDEModel().createEntity();
            pSDCMSPlatform.set("PSDCMSPLATFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCMSPlatform);
            } else {
                iService.get(pSDCMSPlatform);
            }
            this.onFillParentInfo_PSDCMSPlatform(pSDepSln, pSDCMSPlatform);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLN_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDepSln, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLN_PSDEVUSER_ADMINPSDEVUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = (PSDevUser)iService.getDEModel().createEntity();
            pSDevUser.set("PSDEVUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevUser);
            } else {
                iService.get(pSDevUser);
            }
            this.onFillParentInfo_AdminPSDevUser(pSDepSln, pSDevUser);
            return;
        }
        super.onFillParentInfo(pSDepSln, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCCluster(PSDepSln pSDepSln, PSDCCluster pSDCCluster) throws Exception {
        pSDepSln.setPSDCClusterId(pSDCCluster.getPSDCClusterId());
        pSDepSln.setPSDCClusterName(pSDCCluster.getPSDCClusterName());
    }

    protected void onFillParentInfo_PSDCMSPlatform(PSDepSln pSDepSln, PSDCMSPlatform pSDCMSPlatform) throws Exception {
        pSDepSln.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
        pSDepSln.setPSDCMSPlatformName(pSDCMSPlatform.getPSDCMSPlatformName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDepSln pSDepSln, PSDevCenter pSDevCenter) throws Exception {
        pSDepSln.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDepSln.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_AdminPSDevUser(PSDepSln pSDepSln, PSDevUser pSDevUser) throws Exception {
        pSDepSln.setAdminPSDevUserId(pSDevUser.getPSDevUserId());
        pSDepSln.setAdminPSDevUserName(pSDevUser.getPSDevUserName());
    }

    protected void onFillEntityFullInfo(PSDepSln pSDepSln, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSln, bl);
        this.onFillEntityFullInfo_PSDCCluster(pSDepSln, bl);
        this.onFillEntityFullInfo_PSDCMSPlatform(pSDepSln, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDepSln, bl);
        this.onFillEntityFullInfo_AdminPSDevUser(pSDepSln, bl);
    }

    protected void onFillEntityFullInfo_PSDCCluster(PSDepSln pSDepSln, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCMSPlatform(PSDepSln pSDepSln, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDepSln pSDepSln, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AdminPSDevUser(PSDepSln pSDepSln, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSln pSDepSln, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSln, bl);
    }

    public ArrayList<PSDepSln> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, "", -1);
    }

    public ArrayList<PSDepSln> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, string, -1);
    }

    public ArrayList<PSDepSln> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSln> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, "", -1);
    }

    public ArrayList<PSDepSln> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, string, -1);
    }

    public ArrayList<PSDepSln> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMSPLATFORMID", (Object)pSDCMSPlatformBase.getPSDCMSPlatformId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMSPlatformCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMSPlatformCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSln> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDepSln> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDepSln> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSln> selectByAdminPSDevUser(PSDevUserBase pSDevUserBase) throws Exception {
        return this.selectByAdminPSDevUser(pSDevUserBase, "", -1);
    }

    public ArrayList<PSDepSln> selectByAdminPSDevUser(PSDevUserBase pSDevUserBase, String string) throws Exception {
        return this.selectByAdminPSDevUser(pSDevUserBase, string, -1);
    }

    public ArrayList<PSDepSln> selectByAdminPSDevUser(PSDevUserBase pSDevUserBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ADMINPSDEVUSERID", (Object)pSDevUserBase.getPSDevUserId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAdminPSDevUserCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAdminPSDevUserCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByPSDCCluster(pSDCCluster, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCLUSTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCCluster);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLN_PSDCCLUSTER_PSDCCLUSTERID", "", iDataEntityModel.getName(), "PSDEPSLN", iDataEntityModel.getDataInfo(pSDCCluster), arrayList.get(0)));
        }
    }

    public void resetPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByPSDCCluster(pSDCCluster);
        for (PSDepSln pSDepSln : arrayList) {
            PSDepSln pSDepSln2 = (PSDepSln)this.getDEModel().createEntity();
            pSDepSln2.setPSDepSlnId(pSDepSln.getPSDepSlnId());
            pSDepSln2.setPSDCClusterId(null);
            this.update(pSDepSln2);
        }
    }

    public void removeByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        final PSDCCluster pSDCCluster2 = pSDCCluster;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnServiceBase.this.onBeforeRemoveByPSDCCluster(pSDCCluster2);
                PSDepSlnServiceBase.this.internalRemoveByPSDCCluster(pSDCCluster2);
                PSDepSlnServiceBase.this.onAfterRemoveByPSDCCluster(pSDCCluster2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void internalRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByPSDCCluster(pSDCCluster);
        this.onBeforeRemoveByPSDCCluster(pSDCCluster, arrayList);
        for (PSDepSln pSDepSln : arrayList) {
            this.remove(pSDepSln);
        }
        this.onAfterRemoveByPSDCCluster(pSDCCluster, arrayList);
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDepSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDepSln> arrayList) throws Exception {
    }

    public void testRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMSPLATFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCMSPlatform);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLN_PSDCMSPLATFORM_PSDCMSPLATFORMID", "", iDataEntityModel.getName(), "PSDEPSLN", iDataEntityModel.getDataInfo(pSDCMSPlatform), arrayList.get(0)));
        }
    }

    public void resetPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        for (PSDepSln pSDepSln : arrayList) {
            PSDepSln pSDepSln2 = (PSDepSln)this.getDEModel().createEntity();
            pSDepSln2.setPSDepSlnId(pSDepSln.getPSDepSlnId());
            pSDepSln2.setPSDCMSPlatformId(null);
            this.update(pSDepSln2);
        }
    }

    public void removeByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        final PSDCMSPlatform pSDCMSPlatform2 = pSDCMSPlatform;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnServiceBase.this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDepSlnServiceBase.this.internalRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDepSlnServiceBase.this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
        for (PSDepSln pSDepSln : arrayList) {
            this.remove(pSDepSln);
        }
        this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDepSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDepSln> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDepSln pSDepSln : arrayList) {
            PSDepSln pSDepSln2 = (PSDepSln)this.getDEModel().createEntity();
            pSDepSln2.setPSDepSlnId(pSDepSln.getPSDepSlnId());
            pSDepSln2.setPSDevCenterId(null);
            this.update(pSDepSln2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDepSlnServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDepSlnServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDepSln pSDepSln : arrayList) {
            this.remove(pSDepSln);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDepSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDepSln> arrayList) throws Exception {
    }

    public void testRemoveByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByAdminPSDevUser(pSDevUser, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVUSER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevUser);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLN_PSDEVUSER_ADMINPSDEVUSERID", "", iDataEntityModel.getName(), "PSDEPSLN", iDataEntityModel.getDataInfo(pSDevUser), arrayList.get(0)));
        }
    }

    public void resetAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByAdminPSDevUser(pSDevUser);
        for (PSDepSln pSDepSln : arrayList) {
            PSDepSln pSDepSln2 = (PSDepSln)this.getDEModel().createEntity();
            pSDepSln2.setPSDepSlnId(pSDepSln.getPSDepSlnId());
            pSDepSln2.setAdminPSDevUserId(null);
            this.update(pSDepSln2);
        }
    }

    public void removeByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
        final PSDevUser pSDevUser2 = pSDevUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnServiceBase.this.onBeforeRemoveByAdminPSDevUser(pSDevUser2);
                PSDepSlnServiceBase.this.internalRemoveByAdminPSDevUser(pSDevUser2);
                PSDepSlnServiceBase.this.onAfterRemoveByAdminPSDevUser(pSDevUser2);
            }
        });
    }

    protected void onBeforeRemoveByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void internalRemoveByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDepSln> arrayList = this.selectByAdminPSDevUser(pSDevUser);
        this.onBeforeRemoveByAdminPSDevUser(pSDevUser, arrayList);
        for (PSDepSln pSDepSln : arrayList) {
            this.remove(pSDepSln);
        }
        this.onAfterRemoveByAdminPSDevUser(pSDevUser, arrayList);
    }

    protected void onAfterRemoveByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void onBeforeRemoveByAdminPSDevUser(PSDevUser pSDevUser, ArrayList<PSDepSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAdminPSDevUser(PSDevUser pSDevUser, ArrayList<PSDepSln> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSln pSDepSln) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnASGroupService)ServiceGlobal.getService(PSDepSlnASGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnASGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnASGroupServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnASService)ServiceGlobal.getService(PSDepSlnASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnASServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnASServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnBDInstService)ServiceGlobal.getService(PSDepSlnBDInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnBDInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnBDInstServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnDBInstService)ServiceGlobal.getService(PSDepSlnDBInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnDBInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnDBInstServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSdepSlnDepSessionService)ServiceGlobal.getService(PSdepSlnDepSessionService.class, (SessionFactory)this.getSessionFactory());
        ((PSdepSlnDepSessionServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnFileService)ServiceGlobal.getService(PSDepSlnFileService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnFileServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnHostService)ServiceGlobal.getService(PSDepSlnHostService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnHostServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnLogService)ServiceGlobal.getService(PSDepSlnLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnLogServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnModeService)ServiceGlobal.getService(PSDepSlnModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnModeServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnModeServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnMQInstService)ServiceGlobal.getService(PSDepSlnMQInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnMQInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnMQInstServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnPackService)ServiceGlobal.getService(PSDepSlnPackService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnPackServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnParamService)ServiceGlobal.getService(PSDepSlnParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnParamServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnPrdService)ServiceGlobal.getService(PSDepSlnPrdService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnPrdServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnPrdServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnRunLogService)ServiceGlobal.getService(PSDepSlnRunLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnRunLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnRunLogServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnSysASService)ServiceGlobal.getService(PSDepSlnSysASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysASServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnSysDBService)ServiceGlobal.getService(PSDepSlnSysDBService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysDBServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnSysMQService)ServiceGlobal.getService(PSDepSlnSysMQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysMQServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnSysMQServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnUserService)ServiceGlobal.getService(PSDepSlnUserService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnUserServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnUserServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        pSCoreSysServiceBase = (PSDepSlnWFEngineInstService)ServiceGlobal.getService(PSDepSlnWFEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnWFEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSln(pSDepSln);
        ((PSDepSlnWFEngineInstServiceBase)pSCoreSysServiceBase).removeByPSDepSln(pSDepSln);
        super.onBeforeRemove(pSDepSln);
    }

    protected void replaceParentInfo(PSDepSln pSDepSln, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSln, cloneSession);
        if (pSDepSln.getPSDCClusterId() != null && (iEntity = cloneSession.getEntity("PSDCCLUSTER", (Object)pSDepSln.getPSDCClusterId())) != null) {
            this.onFillParentInfo_PSDCCluster(pSDepSln, (PSDCCluster)iEntity);
        }
        if (pSDepSln.getPSDCMSPlatformId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORM", (Object)pSDepSln.getPSDCMSPlatformId())) != null) {
            this.onFillParentInfo_PSDCMSPlatform(pSDepSln, (PSDCMSPlatform)iEntity);
        }
        if (pSDepSln.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDepSln.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDepSln, (PSDevCenter)iEntity);
        }
        if (pSDepSln.getAdminPSDevUserId() != null && (iEntity = cloneSession.getEntity("PSDEVUSER", (Object)pSDepSln.getAdminPSDevUserId())) != null) {
            this.onFillParentInfo_AdminPSDevUser(pSDepSln, (PSDevUser)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSln pSDepSln, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSln, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminPSDevUserId(bl, pSDepSln, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DomainName(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCClusterId(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformId(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnName(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SlnMDUrl(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SLNSN(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SlnTag(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SlnTag2(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDepSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSln, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminPSDevUserId(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isAdminPSDevUserIdDirty() : !pSDepSln.isAdminPSDevUserIdDirty()) {
            return null;
        }
        String string = pSDepSln.getAdminPSDevUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminPSDevUserId_Default(pSDepSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINPSDEVUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isCodeNameDirty() && !bl2 : !pSDepSln.isCodeNameDirty()) {
            return null;
        }
        String string = pSDepSln.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDepSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DomainName(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isDomainNameDirty() : !pSDepSln.isDomainNameDirty()) {
            return null;
        }
        String string = pSDepSln.getDomainName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DomainName_Default(pSDepSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isMemoDirty() : !pSDepSln.isMemoDirty()) {
            return null;
        }
        String string = pSDepSln.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCClusterId(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isPSDCClusterIdDirty() : !pSDepSln.isPSDCClusterIdDirty()) {
            return null;
        }
        String string = pSDepSln.getPSDCClusterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCClusterId_Default(pSDepSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCMSPlatformId(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isPSDCMSPlatformIdDirty() : !pSDepSln.isPSDCMSPlatformIdDirty()) {
            return null;
        }
        String string = pSDepSln.getPSDCMSPlatformId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformId_Default(pSDepSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isPSDepSlnIdDirty() && !bl2 : !pSDepSln.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSln.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnName(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isPSDepSlnNameDirty() && !bl2 : !pSDepSln.isPSDepSlnNameDirty()) {
            return null;
        }
        String string = pSDepSln.getPSDepSlnName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnName_Default(pSDepSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isPSDevCenterIdDirty() && !bl2 : !pSDepSln.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDepSln.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDepSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_SlnMDUrl(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isSlnMDUrlDirty() : !pSDepSln.isSlnMDUrlDirty()) {
            return null;
        }
        String string = pSDepSln.getSlnMDUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SlnMDUrl_Default(pSDepSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNMDURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SLNSN(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isSLNSNDirty() : !pSDepSln.isSLNSNDirty()) {
            return null;
        }
        String string = pSDepSln.getSLNSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SLNSN_Default(pSDepSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SlnTag(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isSlnTagDirty() : !pSDepSln.isSlnTagDirty()) {
            return null;
        }
        String string = pSDepSln.getSlnTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SlnTag_Default(pSDepSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SlnTag2(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isSlnTag2Dirty() : !pSDepSln.isSlnTag2Dirty()) {
            return null;
        }
        String string = pSDepSln.getSlnTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SlnTag2_Default(pSDepSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isUserCatDirty() : !pSDepSln.isUserCatDirty()) {
            return null;
        }
        String string = pSDepSln.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDepSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isUserTagDirty() : !pSDepSln.isUserTagDirty()) {
            return null;
        }
        String string = pSDepSln.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDepSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isUserTag2Dirty() : !pSDepSln.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDepSln.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDepSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isUserTag3Dirty() : !pSDepSln.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDepSln.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDepSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDepSln pSDepSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSln.isUserTag4Dirty() : !pSDepSln.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDepSln.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDepSln, bl2, bl3);
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

    protected void onSyncEntity(PSDepSln pSDepSln, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSln, bl);
    }

    protected void onSyncIndexEntities(PSDepSln pSDepSln, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSln, bl);
    }

    public Object getDataContextValue(PSDepSln pSDepSln, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSln, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSln pSDepSln, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSln, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINPSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINPSDEVUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPSDevUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCLUSTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCClusterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCLUSTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCClusterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNMDURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SlnMDUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SLNSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SlnTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SlnTag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AdminPSDevUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPSDEVUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminPSDevUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPSDEVUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_DomainName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDepSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SlnMDUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNMDURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SLNSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SlnTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SlnTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSDepSln pSDepSln) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSln)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSln pSDepSln) throws Exception {
        super.onUpdateParent(pSDepSln);
    }

    @Override
    protected void exportCurXmlModel(PSDepSln pSDepSln, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLN");
        if (!bl) {
            pSDepSln.setPSDCClusterName(null);
            pSDepSln.setPSDCMSPlatformName(null);
            super.exportCurXmlModel(pSDepSln, xmlNode, bl);
        }
    }
}

