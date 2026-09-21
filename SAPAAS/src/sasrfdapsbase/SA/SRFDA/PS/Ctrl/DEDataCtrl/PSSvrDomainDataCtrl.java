/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Random;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSvrDomainDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSvrDomainDataCtrl.class);
    public static final String CUSTOMCALL_SYNCSTATES = "SYNCSTATES";
    private static final Random random = new Random();

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCSTATES, (boolean)true) == 0) {
            return this.syncStates(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult syncStates(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSSvrDomainDataCtrl.this.onSyncStates(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u57df\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncStates(BaseDataEntity dataEntity) throws Exception {
        PSSvrDomain psSvrDomain = new PSSvrDomain();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psSvrDomain);
        PSSvrDomainService psSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class);
        psSvrDomainService.syncDomainData(psSvrDomain);
    }
}

