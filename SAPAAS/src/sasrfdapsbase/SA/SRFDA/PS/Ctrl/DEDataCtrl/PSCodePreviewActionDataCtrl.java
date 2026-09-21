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
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodePreviewAction
 *  net.ibizsys.pscore.srv.sysdesign.service.PSCodePreviewActionService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodePreviewAction;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodePreviewActionService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSCodePreviewActionDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSCodePreviewActionDataCtrl.class);
    public static final String CUSTOMCALL_START = "START";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_START, (boolean)true) == 0) {
            return this.startAction(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult startAction(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSCodePreviewActionDataCtrl.this.onStartAction(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5f00\u59cb\u4ee3\u7801\u7247\u6bb5\u6267\u884c\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onStartAction(BaseDataEntity dataEntity) throws Exception {
        PSCodePreviewActionService psCodePreviewActionService = (PSCodePreviewActionService)ServiceGlobal.getService(PSCodePreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSCodePreviewAction psCodePreviewAction = new PSCodePreviewAction();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psCodePreviewAction);
        psCodePreviewActionService.get((IEntity)psCodePreviewAction);
        if (WebContext.getCurrent() != null) {
            WebContext.getCurrent().setSessionValue("SRFLOGINNAME", (Object)psCodePreviewAction.getCreateMan());
        }
        String strPSDevSlnSysId = psCodePreviewAction.getPSDevSlnSysId();
        String strPSDynaInstId = psCodePreviewAction.getPSDynaInstId();
        String strPSBKTaskSessionId = strPSDevSlnSysId;
        boolean bDynaInstMode = false;
        if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
            strPSBKTaskSessionId = "PSDYNAINST:" + strPSDynaInstId;
            bDynaInstMode = true;
        }
        IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = null;
        IPSDevSlnSys iPSDevSlnSys = null;
        String strPSSysModelInstId = null;
        boolean bTemplEngineV2 = false;
        if (bDynaInstMode) {
            bTemplEngineV2 = true;
            iPSDevSlnSysDynaInst = this.getPSModelStorage().getCachePSDevSlnSysDynaInst(strPSDynaInstId);
            if (iPSDevSlnSysDynaInst != null) {
                IPSModelHelper iPSModelHelper;
                iPSDevSlnSys = iPSDevSlnSysDynaInst.getPSDevSlnSys();
                if (iPSDevSlnSys != null && (iPSModelHelper = this.getPSModelHelper(iPSDevSlnSys.getPSSysModelInstId())) != null) {
                    iPSModelHelper.resetCache();
                }
                try {
                    this.getPSModelStorage().getPSSysDevBKTaskGlobal().resetPSBKTaskSession(strPSBKTaskSessionId);
                }
                catch (Exception ex) {
                    log.error((Object)ex.getMessage());
                }
                this.getPSModelStorage().resetPSDevSlnSysDynaInst(strPSDynaInstId);
            }
            iPSDevSlnSysDynaInst = this.getPSModelStorage().getPSDevSlnSysDynaInst(strPSDynaInstId);
            iPSDevSlnSys = iPSDevSlnSysDynaInst.getPSDevSlnSys();
            strPSSysModelInstId = iPSDevSlnSysDynaInst.getPSSysModelInstId();
        } else {
            iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            bTemplEngineV2 = StringHelper.Compare((String)iPSDevSlnSys.getTemplEngineVer(), (String)"V2", (boolean)true) == 0;
            strPSSysModelInstId = iPSDevSlnSys.getPSSysModelInstId();
        }
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(psCodePreviewAction.getPSCodePreviewActionName());
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
        psSysDevBKTask.setTaskType("CODEPREVIEWACTION");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
        psSysDevBKTask.setTaskParam(psCodePreviewAction.getPSCodePreviewActionId());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
            psSysDevBKTask.setTaskType("DYNAINSTPREVIEWACTION");
            psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
            psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
            psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
        }
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)strPSSysModelInstId));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSCodePreviewActionDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }
}

