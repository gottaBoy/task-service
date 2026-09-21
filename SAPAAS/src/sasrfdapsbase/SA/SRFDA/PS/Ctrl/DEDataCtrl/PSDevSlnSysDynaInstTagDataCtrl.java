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
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstTag
 *  net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstTagService
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
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstTag;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstTagService;
import net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysDynaInstTagDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstTagDataCtrl.class);

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
                final PSDevSlnSysDynaInstTag psDevSlnSysDynaInstTag = new PSDevSlnSysDynaInstTag();
                PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInstTag);
                final boolean bInsert2 = bInsert;
                ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                    public void execute(ITransaction iTransaction) throws Exception {
                        PSDevSlnSysDynaInstTagService psDevSlnSysDynaInstTagService = (PSDevSlnSysDynaInstTagService)ServiceGlobal.getService(PSDevSlnSysDynaInstTagService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                        if (bInsert2) {
                            psDevSlnSysDynaInstTagService.create((IEntity)psDevSlnSysDynaInstTag);
                        } else {
                            psDevSlnSysDynaInstTagService.update((IEntity)psDevSlnSysDynaInstTag);
                        }
                    }
                });
                PSDEDataCtrl.convertEntity((IEntity)psDevSlnSysDynaInstTag, dataEntity);
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

    protected CallResult InternalGet(BaseDataEntity dataEntity, boolean bTransaction) {
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
            final PSDevSlnSysDynaInstTag psDevSlnSysDynaInstTag = new PSDevSlnSysDynaInstTag();
            PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInstTag);
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDynaInstTagService psDevSlnSysDynaInstTagService = (PSDevSlnSysDynaInstTagService)ServiceGlobal.getService(PSDevSlnSysDynaInstTagService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psDevSlnSysDynaInstTagService.get((IEntity)psDevSlnSysDynaInstTag);
                }
            });
            PSDEDataCtrl.convertEntity((IEntity)psDevSlnSysDynaInstTag, dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

