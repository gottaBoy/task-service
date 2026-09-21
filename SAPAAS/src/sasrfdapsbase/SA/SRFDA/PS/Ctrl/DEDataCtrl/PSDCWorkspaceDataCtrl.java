/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWSBooking
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWSBooking;
import net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDCWorkspaceDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDCWorkspaceDataCtrl.class);
    public static final String CUSTOMCALL_TESTBOOKING = "TESTBOOKING";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_TESTBOOKING, (boolean)true) == 0) {
            return this.testBooking(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult testBooking(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDCWorkspaceDataCtrl.this.onTestBooking(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u9884\u7ea6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onTestBooking(BaseDataEntity dataEntity) throws Exception {
        PSWSBooking psWSBooking = new PSWSBooking();
        String strPSDCWorkspaceId = dataEntity.getParamStringValue("PSDCWORKSPACEID", null);
        psWSBooking.setDuration(Integer.valueOf(20));
        psWSBooking.setPSDCWorkspaceId(strPSDCWorkspaceId);
        PSWSBookingService psWSBookingService = (PSWSBookingService)ServiceGlobal.getService(PSWSBookingService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psWSBookingService.autoCreate(psWSBooking);
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSDCWorkspaceId = dataEntity.getParamStringValue("PSDCWORKSPACEID", "");
        this.getPSModelStorage().resetPSDCWorkspace(strPSDCWorkspaceId);
    }
}

