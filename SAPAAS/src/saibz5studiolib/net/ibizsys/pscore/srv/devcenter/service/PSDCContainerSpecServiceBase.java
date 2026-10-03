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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCContainerSpecDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCContainerSpecDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSearchEngineInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSearchEngineInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCContainerSpecServiceBase
extends PSCoreSysServiceBase<PSDCContainerSpec> {
    private static final Log log = LogFactory.getLog(PSDCContainerSpecServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCContainerSpecDEModel pSDCContainerSpecDEModel;
    private PSDCContainerSpecDAO pSDCContainerSpecDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService";
    }

    public PSDCContainerSpecDEModel getPSDCContainerSpecDEModel() {
        if (this.pSDCContainerSpecDEModel == null) {
            try {
                this.pSDCContainerSpecDEModel = (PSDCContainerSpecDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCContainerSpecDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCContainerSpecDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCContainerSpecDEModel();
    }

    public PSDCContainerSpecDAO getPSDCContainerSpecDAO() {
        if (this.pSDCContainerSpecDAO == null) {
            try {
                this.pSDCContainerSpecDAO = (PSDCContainerSpecDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCContainerSpecDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCContainerSpecDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCContainerSpecDAO();
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

    protected void onFillParentInfo(PSDCContainerSpec pSDCContainerSpec, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCONTAINERSPEC_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCContainerSpec, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSDCContainerSpec, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCContainerSpec pSDCContainerSpec, PSDevCenter pSDevCenter) throws Exception {
        pSDCContainerSpec.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCContainerSpec.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDCContainerSpec pSDCContainerSpec, boolean bl) throws Exception {
        if (bl && pSDCContainerSpec.getValidFlag() == null) {
            pSDCContainerSpec.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDCContainerSpec, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCContainerSpec, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCContainerSpec pSDCContainerSpec, boolean bl) throws Exception {
        if (pSDCContainerSpec.isPSDevCenterIdDirty()) {
            if (pSDCContainerSpec.getPSDevCenterId() != null) {
                if (pSDCContainerSpec.getPSDevCenterId() == null || pSDCContainerSpec.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCContainerSpec.getPSDevCenter();
                    pSDCContainerSpec.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCContainerSpec.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCContainerSpec pSDCContainerSpec, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCContainerSpec, bl);
    }

    public ArrayList<PSDCContainerSpec> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCContainerSpec> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCContainerSpec> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCContainerSpec> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCContainerSpec pSDCContainerSpec : arrayList) {
            PSDCContainerSpec pSDCContainerSpec2 = (PSDCContainerSpec)this.getDEModel().createEntity();
            pSDCContainerSpec2.setPSDCContainerSpecId(pSDCContainerSpec.getPSDCContainerSpecId());
            pSDCContainerSpec2.setPSDevCenterId(null);
            this.update(pSDCContainerSpec2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCContainerSpecServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCContainerSpecServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCContainerSpecServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCContainerSpec> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCContainerSpec pSDCContainerSpec : arrayList) {
            this.remove(pSDCContainerSpec);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCContainerSpec> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCContainerSpec> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCDeployCenterService)ServiceGlobal.getService(PSDCDeployCenterService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDeployCenterServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMSPlatformServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDCRegistryRepoService)ServiceGlobal.getService(PSDCRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRegistryRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDCSearchEngineInstService)ServiceGlobal.getService(PSDCSearchEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSearchEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDCWFEngineInstService)ServiceGlobal.getService(PSDCWFEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCWFEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterASServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterDBInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDevCenterMQService)ServiceGlobal.getService(PSDevCenterMQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterMQServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDevCenterServerService)ServiceGlobal.getService(PSDevCenterServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterServerServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        pSCoreSysServiceBase = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterSVNServiceBase)pSCoreSysServiceBase).testRemoveByPSDCContainerSpec(pSDCContainerSpec);
        super.onBeforeRemove(pSDCContainerSpec);
    }

    protected void replaceParentInfo(PSDCContainerSpec pSDCContainerSpec, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCContainerSpec, cloneSession);
        if (pSDCContainerSpec.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCContainerSpec.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCContainerSpec, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCContainerSpec pSDCContainerSpec, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCContainerSpec, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CfgType(bl, pSDCContainerSpec, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClusterType(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContainerCfg(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CPULimit(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MemoryLimit(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCContainerSpecId(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCContainerSpecName(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpecParams(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpecTag(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpecTag2(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpecVer(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCContainerSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCContainerSpec, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CfgType(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isCfgTypeDirty() : !pSDCContainerSpec.isCfgTypeDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getCfgType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgType_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClusterType(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isClusterTypeDirty() : !pSDCContainerSpec.isClusterTypeDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getClusterType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClusterType_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLUSTERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContainerCfg(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isContainerCfgDirty() : !pSDCContainerSpec.isContainerCfgDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getContainerCfg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContainerCfg_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTAINERCFG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CPULimit(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isCPULimitDirty() : !pSDCContainerSpec.isCPULimitDirty()) {
            return null;
        }
        Integer n = pSDCContainerSpec.getCPULimit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CPULimit_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPULIMIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isMemoDirty() : !pSDCContainerSpec.isMemoDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCContainerSpec, bl2, bl3);
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

    protected EntityFieldError onCheckField_MemoryLimit(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isMemoryLimitDirty() : !pSDCContainerSpec.isMemoryLimitDirty()) {
            return null;
        }
        Integer n = pSDCContainerSpec.getMemoryLimit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MemoryLimit_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMORYLIMIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCContainerSpecId(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isPSDCContainerSpecIdDirty() && !bl2 : !pSDCContainerSpec.isPSDCContainerSpecIdDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getPSDCContainerSpecId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCONTAINERSPECID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCContainerSpecId_Default(pSDCContainerSpec, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCContainerSpecName(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isPSDCContainerSpecNameDirty() && !bl2 : !pSDCContainerSpec.isPSDCContainerSpecNameDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getPSDCContainerSpecName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCONTAINERSPECNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCContainerSpecName_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCONTAINERSPECNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isPSDevCenterIdDirty() : !pSDCContainerSpec.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCContainerSpec, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isPSDevCenterNameDirty() : !pSDCContainerSpec.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCContainerSpec, bl2, bl3);
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

    protected EntityFieldError onCheckField_SpecParams(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isSpecParamsDirty() : !pSDCContainerSpec.isSpecParamsDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getSpecParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpecParams_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPECPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpecTag(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isSpecTagDirty() : !pSDCContainerSpec.isSpecTagDirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getSpecTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpecTag_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPECTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpecTag2(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isSpecTag2Dirty() : !pSDCContainerSpec.isSpecTag2Dirty()) {
            return null;
        }
        String string = pSDCContainerSpec.getSpecTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpecTag2_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPECTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpecVer(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isSpecVerDirty() && !bl2 : !pSDCContainerSpec.isSpecVerDirty()) {
            return null;
        }
        Integer n = pSDCContainerSpec.getSpecVer();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPECVER");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_SpecVer_Default(pSDCContainerSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPECVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCContainerSpec pSDCContainerSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCContainerSpec.isValidFlagDirty() : !pSDCContainerSpec.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCContainerSpec.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCContainerSpec, bl2, bl3);
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

    protected void onSyncEntity(PSDCContainerSpec pSDCContainerSpec, boolean bl) throws Exception {
        super.onSyncEntity(pSDCContainerSpec, bl);
    }

    protected void onSyncIndexEntities(PSDCContainerSpec pSDCContainerSpec, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCContainerSpec, bl);
    }

    public Object getDataContextValue(PSDCContainerSpec pSDCContainerSpec, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCContainerSpec, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCContainerSpec pSDCContainerSpec, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCContainerSpec, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CFGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLUSTERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClusterType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTAINERCFG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContainerCfg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPULIMIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPULimit_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MEMORYLIMIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MemoryLimit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPECPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpecParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPECTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpecTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPECTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpecTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPECVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpecVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CfgType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClusterType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLUSTERTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContainerCfg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTAINERCFG", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPULimit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MemoryLimit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_SpecParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPECPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpecTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPECTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpecTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPECTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpecVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDCContainerSpec pSDCContainerSpec) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCContainerSpec)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        super.onUpdateParent(pSDCContainerSpec);
    }

    @Override
    protected void exportCurXmlModel(PSDCContainerSpec pSDCContainerSpec, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCCONTAINERSPEC");
        if (!bl) {
            pSDCContainerSpec.setCreateDate(null);
            pSDCContainerSpec.setCreateMan(null);
            pSDCContainerSpec.setPSDCContainerSpecId(null);
            pSDCContainerSpec.setUpdateDate(null);
            pSDCContainerSpec.setUpdateMan(null);
            super.exportCurXmlModel(pSDCContainerSpec, xmlNode, bl);
        }
    }
}

