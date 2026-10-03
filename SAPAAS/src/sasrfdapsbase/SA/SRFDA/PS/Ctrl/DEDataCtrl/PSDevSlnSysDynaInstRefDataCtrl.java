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
 *  net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstRef
 *  net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstRefService
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
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstRef;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstRefService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysDynaInstRefDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstRefDataCtrl.class);

    public CallResult Save(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSDevSlnSysDynaInstRef psDevSlnSysDynaInstRef = new PSDevSlnSysDynaInstRef();
            PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInstRef);
            final boolean bInsert2 = bInsert;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDynaInstRefService psDevSlnSysDynaInstRefService = (PSDevSlnSysDynaInstRefService)ServiceGlobal.getService(PSDevSlnSysDynaInstRefService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    if (bInsert2) {
                        psDevSlnSysDynaInstRefService.create(psDevSlnSysDynaInstRef);
                    } else {
                        psDevSlnSysDynaInstRefService.update(psDevSlnSysDynaInstRef);
                    }
                }
            });
            PSDEDataCtrl.convertEntity((IEntity)psDevSlnSysDynaInstRef, dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult InternalGet(BaseDataEntity dataEntity, boolean bTransaction) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSDevSlnSysDynaInstRef psDevSlnSysDynaInstRef = new PSDevSlnSysDynaInstRef();
            PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInstRef);
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDynaInstRefService psDevSlnSysDynaInstRefService = (PSDevSlnSysDynaInstRefService)ServiceGlobal.getService(PSDevSlnSysDynaInstRefService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psDevSlnSysDynaInstRefService.get(psDevSlnSysDynaInstRef);
                }
            });
            PSDEDataCtrl.convertEntity((IEntity)psDevSlnSysDynaInstRef, dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult InternalRemoveData(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSDevSlnSysDynaInstRef psDevSlnSysDynaInstRef = new PSDevSlnSysDynaInstRef();
            PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDynaInstRef);
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDynaInstRefService psDevSlnSysDynaInstRefService = (PSDevSlnSysDynaInstRefService)ServiceGlobal.getService(PSDevSlnSysDynaInstRefService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psDevSlnSysDynaInstRefService.remove(psDevSlnSysDynaInstRef);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}
