/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDeployDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDeployDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDeployServiceBase
extends PSCoreSysServiceBase<PSDevSlnMSDeploy> {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDeployServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_PUBCONFIGS = "PubConfigs";
    private PSDevSlnMSDeployDEModel pSDevSlnMSDeployDEModel;
    private PSDevSlnMSDeployDAO pSDevSlnMSDeployDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService";
    }

    public PSDevSlnMSDeployDEModel getPSDevSlnMSDeployDEModel() {
        if (this.pSDevSlnMSDeployDEModel == null) {
            try {
                this.pSDevSlnMSDeployDEModel = (PSDevSlnMSDeployDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDeployDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDeployDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnMSDeployDEModel();
    }

    public PSDevSlnMSDeployDAO getPSDevSlnMSDeployDAO() {
        if (this.pSDevSlnMSDeployDAO == null) {
            try {
                this.pSDevSlnMSDeployDAO = (PSDevSlnMSDeployDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDeployDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDeployDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnMSDeployDAO();
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
            this.pubConfigs((PSDevSlnMSDeploy)iEntity);
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

    public void pubConfigs(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PUBCONFIGS, 0, (IEntity)pSDevSlnMSDeploy, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnMSDeploy, ACTION_PUBCONFIGS);
        final PSDevSlnMSDeploy pSDevSlnMSDeploy2 = pSDevSlnMSDeploy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnMSDeployServiceBase.this.getService(), PSDevSlnMSDeployServiceBase.ACTION_PUBCONFIGS, 40, (IEntity)pSDevSlnMSDeploy2, null).getResult() != 1) {
                    PSDevSlnMSDeployServiceBase.this.onPubConfigs(pSDevSlnMSDeploy2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PUBCONFIGS, 99, (IEntity)pSDevSlnMSDeploy, null);
        }
    }

    protected void onPubConfigs(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PubConfigs]");
    }

    protected void onFillParentInfo(PSDevSlnMSDeploy pSDevSlnMSDeploy, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPLOY_PSDCMSPLATFORM_PSDCMSPLATFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatform pSDCMSPlatform = (PSDCMSPlatform)iService.getDEModel().createEntity();
            pSDCMSPlatform.set("PSDCMSPLATFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCMSPlatform);
            } else {
                iService.get((IEntity)pSDCMSPlatform);
            }
            this.onFillParentInfo_PSDCMSPlatform(pSDevSlnMSDeploy, pSDCMSPlatform);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPLOY_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSln);
            } else {
                iService.get((IEntity)pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDeploy, pSDevSln);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnMSDeploy, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCMSPlatform(PSDevSlnMSDeploy pSDevSlnMSDeploy, PSDCMSPlatform pSDCMSPlatform) throws Exception {
        pSDevSlnMSDeploy.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
        pSDevSlnMSDeploy.setPSDCMSPlatformName(pSDCMSPlatform.getPSDCMSPlatformName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnMSDeploy pSDevSlnMSDeploy, PSDevSln pSDevSln) throws Exception {
        pSDevSlnMSDeploy.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnMSDeploy.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnMSDeploy.getPSDevSlnMSDepAPIsCnt() == null) {
                pSDevSlnMSDeploy.setPSDevSlnMSDepAPIsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnMSDeploy.getPSDevSlnMSDepAppsCnt() == null) {
                pSDevSlnMSDeploy.setPSDevSlnMSDepAppsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnMSDeploy.getValidFlag() == null) {
                pSDevSlnMSDeploy.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnMSDeploy, bl);
        this.onFillEntityFullInfo_PSDCMSPlatform(pSDevSlnMSDeploy, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnMSDeploy, bl);
    }

    protected void onFillEntityFullInfo_PSDCMSPlatform(PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnMSDeploy, bl);
    }

    public ArrayList<PSDevSlnMSDeploy> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDeploy> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDeploy> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDeploy> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDeploy> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDeploy> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDevSlnMSDeploy> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMSPLATFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCMSPlatform);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPLOY_PSDCMSPLATFORM_PSDCMSPLATFORMID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPLOY", iDataEntityModel.getDataInfo((IEntity)pSDCMSPlatform), arrayList.get(0)));
        }
    }

    public void resetPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDevSlnMSDeploy> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        for (PSDevSlnMSDeploy pSDevSlnMSDeploy : arrayList) {
            PSDevSlnMSDeploy pSDevSlnMSDeploy2 = (PSDevSlnMSDeploy)this.getDEModel().createEntity();
            pSDevSlnMSDeploy2.setPSDevSlnMSDeployId(pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
            pSDevSlnMSDeploy2.setPSDCMSPlatformId(null);
            this.update(pSDevSlnMSDeploy2);
        }
    }

    public void removeByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        final PSDCMSPlatform pSDCMSPlatform2 = pSDCMSPlatform;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDeployServiceBase.this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDevSlnMSDeployServiceBase.this.internalRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDevSlnMSDeployServiceBase.this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDevSlnMSDeploy> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
        for (PSDevSlnMSDeploy pSDevSlnMSDeploy : arrayList) {
            this.remove((IEntity)pSDevSlnMSDeploy);
        }
        this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDevSlnMSDeploy> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDevSlnMSDeploy> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnMSDeploy> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPLOY_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPLOY", iDataEntityModel.getDataInfo((IEntity)pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnMSDeploy> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnMSDeploy pSDevSlnMSDeploy : arrayList) {
            PSDevSlnMSDeploy pSDevSlnMSDeploy2 = (PSDevSlnMSDeploy)this.getDEModel().createEntity();
            pSDevSlnMSDeploy2.setPSDevSlnMSDeployId(pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
            pSDevSlnMSDeploy2.setPSDevSlnId(null);
            this.update(pSDevSlnMSDeploy2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDeployServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnMSDeployServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnMSDeployServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnMSDeploy> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnMSDeploy pSDevSlnMSDeploy : arrayList) {
            this.remove((IEntity)pSDevSlnMSDeploy);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnMSDeploy> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnMSDeploy> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRegistryItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        pSCoreSysServiceBase = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        pSCoreSysServiceBase = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        pSCoreSysServiceBase = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        pSCoreSysServiceBase = (PSDevSlnMSDepResService)ServiceGlobal.getService(PSDevSlnMSDepResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepResServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        super.onBeforeRemove(pSDevSlnMSDeploy);
    }

    protected void replaceParentInfo(PSDevSlnMSDeploy pSDevSlnMSDeploy, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnMSDeploy, cloneSession);
        if (pSDevSlnMSDeploy.getPSDCMSPlatformId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORM", (Object)pSDevSlnMSDeploy.getPSDCMSPlatformId())) != null) {
            this.onFillParentInfo_PSDCMSPlatform(pSDevSlnMSDeploy, (PSDCMSPlatform)iEntity);
        }
        if (pSDevSlnMSDeploy.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnMSDeploy.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDeploy, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnMSDeploy, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DeployMDUrl(bl, pSDevSlnMSDeploy, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag2(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformId(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAPIsCnt(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAppsCnt(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDeployId(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDeployName(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnMSDeploy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnMSDeploy, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DeployMDUrl(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isDeployMDUrlDirty() : !pSDevSlnMSDeploy.isDeployMDUrlDirty()) {
            return null;
        }
        String string = pSDevSlnMSDeploy.getDeployMDUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployMDUrl_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYMDURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeployTag(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isDeployTagDirty() : !pSDevSlnMSDeploy.isDeployTagDirty()) {
            return null;
        }
        String string = pSDevSlnMSDeploy.getDeployTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeployTag2(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isDeployTag2Dirty() : !pSDevSlnMSDeploy.isDeployTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnMSDeploy.getDeployTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag2_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isMemoDirty() : !pSDevSlnMSDeploy.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnMSDeploy.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCMSPlatformId(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isPSDCMSPlatformIdDirty() && !bl2 : !pSDevSlnMSDeploy.isPSDCMSPlatformIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDeploy.getPSDCMSPlatformId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformId_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isPSDevSlnIdDirty() && !bl2 : !pSDevSlnMSDeploy.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDeploy.getPSDevSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDepAPIsCnt(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isPSDevSlnMSDepAPIsCntDirty() : !pSDevSlnMSDeploy.isPSDevSlnMSDepAPIsCntDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDeploy.getPSDevSlnMSDepAPIsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDevSlnMSDepAPIsCnt_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPISCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepAppsCnt(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isPSDevSlnMSDepAppsCntDirty() : !pSDevSlnMSDeploy.isPSDevSlnMSDepAppsCntDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDeploy.getPSDevSlnMSDepAppsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDevSlnMSDepAppsCnt_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPPSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDeployId(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isPSDevSlnMSDeployIdDirty() && !bl2 : !pSDevSlnMSDeploy.isPSDevSlnMSDeployIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDeploy.getPSDevSlnMSDeployId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDeployId_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDeployName(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isPSDevSlnMSDeployNameDirty() && !bl2 : !pSDevSlnMSDeploy.isPSDevSlnMSDeployNameDirty()) {
            return null;
        }
        String string = pSDevSlnMSDeploy.getPSDevSlnMSDeployName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDeployName_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isUserParamsDirty() : !pSDevSlnMSDeploy.isUserParamsDirty()) {
            return null;
        }
        String string = pSDevSlnMSDeploy.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDeploy.isValidFlagDirty() && !bl2 : !pSDevSlnMSDeploy.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDeploy.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDevSlnMSDeploy, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnMSDeploy, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnMSDeploy pSDevSlnMSDeploy, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnMSDeploy, bl);
    }

    public Object getDataContextValue(PSDevSlnMSDeploy pSDevSlnMSDeploy, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnMSDeploy, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSln pSDevSln = pSDevSlnMSDeploy.getPSDevSln();
        if (pSDevSln != null && pSDevSln.contains(string)) {
            return pSDevSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnMSDeploy, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYMDURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeployMDUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeployTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeployTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPISCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAPIsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPPSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAppsCnt_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_DeployMDUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYMDURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeployTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeployTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_PSDevSlnMSDepAPIsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDevSlnMSDepAppsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPI_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", (boolean)true) == 0) && this.onMergeChild_PSDevSlnMSDepAPIs(pSDevSlnMSDeploy)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPP_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", (boolean)true) == 0) && this.onMergeChild_PSDevSlnMSDepApps(pSDevSlnMSDeploy)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnMSDeploy)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSDevSlnMSDepAPIs(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEVSLNMSDEPAPISCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEVSLNMSDEPLOYID", (Object)pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDevSlnMSDeploy, false);
        return true;
    }

    protected boolean onMergeChild_PSDevSlnMSDepApps(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEVSLNMSDEPAPPSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEVSLNMSDEPLOYID", (Object)pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDevSlnMSDeploy, false);
        return true;
    }

    protected void onUpdateParent(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        Object object = pSDevSlnMSDeploy.get("PSDEVSLNID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEVSLNMSDEPLOY_PSDEVSLN_PSDEVSLNID", object);
        }
        super.onUpdateParent((IEntity)pSDevSlnMSDeploy);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnMSDeploy pSDevSlnMSDeploy, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNMSDEPLOY");
        if (!bl) {
            pSDevSlnMSDeploy.setCreateDate(null);
            pSDevSlnMSDeploy.setCreateMan(null);
            pSDevSlnMSDeploy.setPSDevSlnMSDeployId(null);
            pSDevSlnMSDeploy.setUpdateDate(null);
            pSDevSlnMSDeploy.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnMSDeploy, xmlNode, bl);
        }
    }
}

