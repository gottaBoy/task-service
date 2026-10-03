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
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.config.entity.PSPFStyle
 *  net.ibizsys.pscore.srv.config.entity.PSSFStyle
 *  net.ibizsys.pscore.srv.config.service.PSPFStyleService
 *  net.ibizsys.pscore.srv.config.service.PSSFStyleService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCSSession
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUserCS
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCSSessionService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSCodeServerAction
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSCodeServerActionService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCSSession;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUserCS;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCSSessionService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSCodeServerAction;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSCodeServerActionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSCodeServerActionDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSCodeServerActionDataCtrl.class);
    public static final String PSDEVSLNTEMPL_GIT = "PSDEVSLNTEMPL_GIT";
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
                    PSCodeServerActionDataCtrl.this.onStartAction(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5f00\u59cb\u4ee3\u7801\u670d\u52a1\u5668\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onStartAction(BaseDataEntity dataEntity) throws Exception {
        PSCodeServerActionService psCodeServerActionService = (PSCodeServerActionService)ServiceGlobal.getService(PSCodeServerActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSCodeServerAction psCodeServerAction = new PSCodeServerAction();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psCodeServerAction);
        psCodeServerActionService.get(psCodeServerAction);
        PSCodeServerAction psCodeServerAction2 = new PSCodeServerAction();
        String strPSCodeServerActionId = psCodeServerAction.getPSCodeServerActionId();
        String strPSDevSlnId = psCodeServerAction.getPSDevSlnId();
        String strPSDSConsoleId = psCodeServerAction.getPSDSConsoleId();
        if (StringHelper.IsNullOrEmpty((String)strPSDSConsoleId)) {
            strPSDSConsoleId = strPSDevSlnId;
        }
        if (PSDEVSLNTEMPL_GIT.equals(psCodeServerAction.getPSObjType())) {
            PSDevSlnTemplService psDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnTempl psDevSlnTempl = new PSDevSlnTempl();
            psDevSlnTempl.setPSDevSlnTemplId(psCodeServerAction.getPSObjId());
            psDevSlnTemplService.get(psDevSlnTempl);
            String strGitPath = "";
            if (StringHelper.Compare((String)psDevSlnTempl.getTemplType(), (String)"PSPF", (boolean)true) == 0) {
                PSPFStyleService psPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                PSPFStyle psPFStyle = new PSPFStyle();
                psPFStyle.setPSPFStyleId(psDevSlnTempl.getPSPFStyleId());
                psPFStyleService.get(psPFStyle);
                strGitPath = psPFStyle.getTemplRootUrl();
            } else if (StringHelper.Compare((String)psDevSlnTempl.getTemplType(), (String)"PSSF", (boolean)true) == 0) {
                PSSFStyleService psSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                PSSFStyle psSFStyle = new PSSFStyle();
                psSFStyle.setPSSFStyleId(psDevSlnTempl.getPSSFStyleId());
                psSFStyleService.get(psSFStyle);
                strGitPath = psSFStyle.getTemplRootUrl();
            }
            psCodeServerAction2.reset();
            psCodeServerAction2.setPSCodeServerActionId(psCodeServerAction.getPSCodeServerActionId());
            if (StringHelper.IsNullOrEmpty((String)strGitPath)) {
                psCodeServerAction2.setActionState(Integer.valueOf(40));
                psCodeServerAction2.setActionResult(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u677f\u4ed3\u5e93\u5730\u5740"));
            } else {
                psCodeServerAction2.setActionState(Integer.valueOf(30));
                psCodeServerAction2.setCodeServerUrl(strGitPath);
            }
            psCodeServerAction2.setPSDSConsoleId(strPSDSConsoleId);
            psCodeServerActionService.update(psCodeServerAction2, false);
            return;
        }
        PSDevSlnUserCSService psDevSlnUserCSService = (PSDevSlnUserCSService)ServiceGlobal.getService(PSDevSlnUserCSService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnUserCS psDevSlnUserCS = new PSDevSlnUserCS();
        psDevSlnUserCS.setPSDevSlnId(psCodeServerAction.getPSDevSlnId());
        psDevSlnUserCS.setPSDevUserId(psCodeServerAction.getActionParam());
        psDevSlnUserCS.setAllUserFlag(Integer.valueOf(0));
        if ("PSDEVSLNSYS".equals(psCodeServerAction.getPSObjType())) {
            psDevSlnUserCS.setCodeTarget("PSDEVSLNSYS");
            psDevSlnUserCS.setPSDevSlnSysId(psCodeServerAction.getPSObjId());
        } else if ("PSDEVSLNTEMPL".equals(psCodeServerAction.getPSObjType())) {
            psDevSlnUserCS.setCodeTarget("PSDEVSLNTEMPL");
            psDevSlnUserCS.setPSDevSlnTemplId(psCodeServerAction.getPSObjId());
        } else {
            psCodeServerActionService = (PSCodeServerActionService)ServiceGlobal.getService(PSCodeServerActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psCodeServerAction2.reset();
            psCodeServerAction2.setPSCodeServerActionId(psCodeServerAction.getPSCodeServerActionId());
            psCodeServerAction2.setActionState(Integer.valueOf(40));
            psCodeServerAction2.setActionResult(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7528\u6237\u5f00\u53d1\u4e3b\u673a\u4fe1\u606f\uff0c\u65e0\u6548\u7684\u76ee\u6807"));
            psCodeServerAction2.setPSDSConsoleId(strPSDSConsoleId);
            psCodeServerActionService.update(psCodeServerAction2, false);
            return;
        }
        if (!psDevSlnUserCSService.select(psDevSlnUserCS, true)) {
            psDevSlnUserCS.resetPSDevUserId();
            psDevSlnUserCS.setAllUserFlag(Integer.valueOf(1));
            if (!psDevSlnUserCSService.select(psDevSlnUserCS, true)) {
                psDevSlnUserCS = null;
            }
        }
        PSDevSlnCSSession psDevSlnCSSession = null;
        if (psDevSlnUserCS != null) {
            PSDevSlnCSSessionService psDevSlnCSSessionService = (PSDevSlnCSSessionService)ServiceGlobal.getService(PSDevSlnCSSessionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psDevSlnCSSession = new PSDevSlnCSSession();
            psDevSlnCSSession.setPSDevSlnUserCSId(psDevSlnUserCS.getPSDevSlnUserCSId());
            psDevSlnCSSession.setResState(Integer.valueOf(20));
            if (!psDevSlnCSSessionService.select(psDevSlnCSSession, true)) {
                psDevSlnCSSession = null;
            }
        }
        if (psDevSlnCSSession == null) {
            psCodeServerActionService = (PSCodeServerActionService)ServiceGlobal.getService(PSCodeServerActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psCodeServerAction2.reset();
            psCodeServerAction2.setPSCodeServerActionId(psCodeServerAction.getPSCodeServerActionId());
            psCodeServerAction2.setActionState(Integer.valueOf(40));
            psCodeServerAction2.setActionResult(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7528\u6237\u5f00\u53d1\u4e3b\u673a\u4fe1\u606f"));
            psCodeServerAction2.setPSDSConsoleId(strPSDSConsoleId);
            psCodeServerActionService.update(psCodeServerAction2, false);
            return;
        }
        psCodeServerActionService = (PSCodeServerActionService)ServiceGlobal.getService(PSCodeServerActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psCodeServerAction2.reset();
        psCodeServerAction2.setPSCodeServerActionId(psCodeServerAction.getPSCodeServerActionId());
        psCodeServerAction2.setActionState(Integer.valueOf(30));
        psCodeServerAction2.setActionStep("");
        psCodeServerAction2.setActionResult("");
        psCodeServerAction2.setCodeServerUrl(psDevSlnCSSession.getCSParam());
        psCodeServerAction2.setPSDSConsoleId(strPSDSConsoleId);
        psCodeServerActionService.update(psCodeServerAction2, false);
    }
}
