/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.Util.PSWorkspaceHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Random;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkspaceDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSWorkspaceDataCtrl.class);
    public static final String CUSTOMCALL_STARTUP = "STARTUP";
    public static final String CUSTOMCALL_SHUTDOWN = "SHUTDOWN";
    public static final String CUSTOMCALL_CLONE = "CLONE";
    public static final String CUSTOMCALL_BINDDC = "BINDDC";
    public static final String CUSTOMCALL_RESETDC = "RESETDC";
    private static final Random random = new Random();

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_STARTUP, (boolean)true) == 0) {
            return this.startup(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SHUTDOWN, (boolean)true) == 0) {
            return this.shutdown(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLONE, (boolean)true) == 0) {
            return this.clone(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_BINDDC, (boolean)true) == 0) {
            return this.bindDC(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RESETDC, (boolean)true) == 0) {
            return this.resetDC(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult startup(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSWorkspaceDataCtrl.this.onStartup(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5f00\u542f\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onStartup(BaseDataEntity dataEntity) throws Exception {
        PSWorkspace psWorkspace = new PSWorkspace();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psWorkspace);
        PSWorkspaceHelper.startup(psWorkspace.getPSWorkspaceId());
    }

    public CallResult shutdown(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSWorkspaceDataCtrl.this.onShutdown(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5173\u95ed\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onShutdown(BaseDataEntity dataEntity) throws Exception {
        PSWorkspace psWorkspace = new PSWorkspace();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psWorkspace);
        PSWorkspaceHelper.shutdown(psWorkspace.getPSWorkspaceId());
    }

    public CallResult clone(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSWorkspaceDataCtrl.this.onClone(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u514b\u9686\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onClone(BaseDataEntity dataEntity) throws Exception {
        PSWorkspace psWorkspace = new PSWorkspace();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psWorkspace);
        PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class);
        psWorkspaceService.get((IEntity)psWorkspace);
        PSWorkspace newPSWorkspace = new PSWorkspace();
        psWorkspace.copyTo((IDataObject)newPSWorkspace, false);
        newPSWorkspace.setPSSvrDomainId(psWorkspace.getPSSvrDomainId());
        newPSWorkspace.setPSSvrDomainName(psWorkspace.getPSSvrDomainName());
        newPSWorkspace.setPSDevCenterId(psWorkspace.getPSDevCenterId());
        newPSWorkspace.setPSDevCenterName(psWorkspace.getPSDevCenterName());
        newPSWorkspace.resetPSWorkspaceId();
        newPSWorkspace.setPSWorkspaceName(StringHelper.Format((String)"%1$s_%2$s", (Object)psWorkspace.getPSWorkspaceName(), (Object)random.nextInt(100000)));
        newPSWorkspace.setPSDCWorkspaceId(null);
        newPSWorkspace.resetExp();
        newPSWorkspace.resetExp2();
        newPSWorkspace.resetExp3();
        newPSWorkspace.resetExp4();
        newPSWorkspace.setWorkspaceState(Integer.valueOf(20));
        psWorkspaceService.create((IEntity)newPSWorkspace);
    }

    public CallResult bindDC(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSWorkspaceDataCtrl.this.onBindDC(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5206\u914d\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onBindDC(BaseDataEntity dataEntity) throws Exception {
        PSWorkspace psWorkspace = new PSWorkspace();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psWorkspace);
        PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class);
        psWorkspaceService.get((IEntity)psWorkspace);
        psWorkspaceService.bindDC(psWorkspace);
    }

    public CallResult resetDC(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSWorkspaceDataCtrl.this.onResetDC(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u91ca\u653e\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onResetDC(BaseDataEntity dataEntity) throws Exception {
        PSWorkspace psWorkspace = new PSWorkspace();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psWorkspace);
        PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class);
        psWorkspaceService.resetDC(psWorkspace);
    }
}

