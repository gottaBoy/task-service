/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst
 *  net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstRef
 *  net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService
 *  net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin
 *  net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstRef;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysDynaInstDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstDataCtrl.class);
    public static final String CUSTOMCALL_CHECKOUTMODEL = "CHECKOUTMODEL";
    public static final String CUSTOMCALL_CHECKOUTALLMODEL = "CHECKOUTALLMODEL";
    public static final String CUSTOMCALL_CHECKINMODEL = "CHECKINMODEL";
    public static final String CUSTOMCALL_CHECKOUTCFG = "CHECKOUTCFG";
    public static final String CUSTOMCALL_CHECKINCFG = "CHECKINCFG";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_CHECKOUTMODEL, (boolean)true) == 0) {
            return this.checkOutModel(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_CHECKOUTALLMODEL, (boolean)true) == 0) {
            return this.checkOutAllModel(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_CHECKINMODEL, (boolean)true) == 0) {
            return this.checkInModel(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_CHECKOUTCFG, (boolean)true) == 0) {
            return this.checkOutCfg(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_CHECKINCFG, (boolean)true) == 0) {
            return this.checkInCfg(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult Save(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        if (bInsert) {
            CallResult callResult = new CallResult();
            try {
                if (this.getTransactionManager() != null) {
                    this.getTransactionManager().Commit();
                }
                if (!PSCoreSysServiceBase.isEnableGitLabPlugin()) {
                    PSCoreSysServiceBase.setCurrentPSSvrDomainId((String)"SVRDOMAIN0001");
                    PSCoreSysServiceBase.setEnableGitLabPlugin((boolean)true);
                    PSCoreSysServiceBase.setPSGitLabPlugin((IPSGitLabPlugin)new PSGitLabPluginImpl());
                }
                final PSDevSlnSysDynaInst psDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInst);
                final boolean bInsert2 = bInsert;
                ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                    public void execute(ITransaction iTransaction) throws Exception {
                        PSDevSlnSysDynaInstService psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                        if (bInsert2) {
                            psDevSlnSysDynaInstService.create(psDevSlnSysDynaInst);
                        } else {
                            psDevSlnSysDynaInstService.update(psDevSlnSysDynaInst);
                        }
                    }
                });
                PSDEDataCtrl.convertEntity((IEntity)psDevSlnSysDynaInst, dataEntity);
                return callResult;
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
        return super.Save(bInsert, strActionMode, dataEntity);
    }

    public CallResult checkOutModel(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDynaInstDataCtrl.this.onCheckOutModel(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u7b7e\u51fa\u5b9e\u4f8b\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCheckOutModel(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSysDynaInst psDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInst);
        PSDevSlnSysDynaInstService psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysDynaInstService.checkOutModel(psDevSlnSysDynaInst);
    }

    public CallResult checkOutAllModel(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDynaInstDataCtrl.this.onCheckOutAllModel(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u7b7e\u51fa\u5b9e\u4f8b\u5168\u90e8\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCheckOutAllModel(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSysDynaInst psDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInst);
        PSDevSlnSysDynaInstService psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysDynaInstService.checkOutAllModel(psDevSlnSysDynaInst);
        log.debug((Object)String.format("\u52a8\u6001\u5b9e\u4f8b[%1$s]\u6a21\u578b\u8def\u5f84[%2$s]", psDevSlnSysDynaInst.getPSDevSlnSysDynaInstId(), psDevSlnSysDynaInst.getInstModelPath()));
        ArrayList<PSDevSlnSysDynaInstRef> psDevSlnSysDynaInstRefList = psDevSlnSysDynaInst.getPSDevSlnSysDynaInstRefs();
        if (psDevSlnSysDynaInstRefList != null) {
            for (PSDevSlnSysDynaInstRef psDevSlnSysDynaInstRef : psDevSlnSysDynaInstRefList) {
                log.debug((Object)String.format("\u52a8\u6001\u5b9e\u4f8b[%1$s]\u5f15\u7528\u6a21\u578b\u8def\u5f84[%2$s]", psDevSlnSysDynaInst.getPSDevSlnSysDynaInstId(), psDevSlnSysDynaInstRef.getInstModelPath()));
            }
        }
        if (!StringHelper.isNullOrEmpty((String)psDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId())) {
            PSDevSlnSysDynaInst psDevSlnSysDynaInst2 = new PSDevSlnSysDynaInst();
            psDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(psDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId());
            psDevSlnSysDynaInstService.checkOutAllModel(psDevSlnSysDynaInst2);
            log.debug((Object)String.format("\u7236\u52a8\u6001\u5b9e\u4f8b[%1$s]\u6a21\u578b\u8def\u5f84[%2$s]", psDevSlnSysDynaInst2.getPSDevSlnSysDynaInstId(), psDevSlnSysDynaInst2.getInstModelPath()));
            psDevSlnSysDynaInstRefList = psDevSlnSysDynaInst2.getPSDevSlnSysDynaInstRefs();
            if (psDevSlnSysDynaInstRefList != null) {
                for (PSDevSlnSysDynaInstRef psDevSlnSysDynaInstRef : psDevSlnSysDynaInstRefList) {
                    log.debug((Object)String.format("\u7236\u52a8\u6001\u5b9e\u4f8b[%1$s]\u5f15\u7528\u6a21\u578b\u8def\u5f84[%2$s]", psDevSlnSysDynaInst2.getPSDevSlnSysDynaInstId(), psDevSlnSysDynaInstRef.getInstModelPath()));
                }
            }
        }
    }

    public CallResult checkInModel(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDynaInstDataCtrl.this.onCheckInModel(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u7b7e\u5165\u5b9e\u4f8b\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCheckInModel(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSysDynaInst psDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInst);
        PSDevSlnSysDynaInstService psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysDynaInstService.checkInModel(psDevSlnSysDynaInst);
    }

    public CallResult checkOutCfg(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDynaInstDataCtrl.this.onCheckOutCfg(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u7b7e\u51fa\u5b9e\u4f8b\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCheckOutCfg(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSysDynaInst psDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInst);
        PSDevSlnSysDynaInstService psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysDynaInstService.checkOutCfg(psDevSlnSysDynaInst);
    }

    public CallResult checkInCfg(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDynaInstDataCtrl.this.onCheckInCfg(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u7b7e\u5165\u5b9e\u4f8b\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCheckInCfg(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSysDynaInst psDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInst);
        PSDevSlnSysDynaInstService psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysDynaInstService.checkInCfg(psDevSlnSysDynaInst);
    }
}
