/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.config.entity.PSModelView
 *  net.ibizsys.pscore.srv.config.entity.PSModelViewUIAction
 *  net.ibizsys.pscore.srv.config.service.PSModelViewService
 *  net.ibizsys.pscore.srv.config.service.PSModelViewUIActionService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSSysApp;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.config.entity.PSModelView;
import net.ibizsys.pscore.srv.config.entity.PSModelViewUIAction;
import net.ibizsys.pscore.srv.config.service.PSModelViewService;
import net.ibizsys.pscore.srv.config.service.PSModelViewUIActionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAppDataCtrl
extends PSDEDataCtrl {
    public static final String CUSTOMCALL_PUBLISHCODE = "PUBLISHCODE";
    public static final String CUSTOMCALL_GENERATECODE = "GENERATECODE";
    public static final String CUSTOMCALL_GENERATECODE2 = "GENERATECODE2";
    public static final String CUSTOMCALL_CALCSYSREFFLAG = "CALCSYSREFFLAG";
    public static final String CUSTOMCALL_GENERATEMODELVIEW = "GENERATEMODELVIEW";
    private static final Log log = LogFactory.getLog(PSSysAppDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSSystemId = dataEntity.getParamStringValue("PSSYSTEMID", "");
        IPSSystem ipsSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        String strPSSysAppId = dataEntity.getParamStringValue("PSSYSAPPID", "");
        PSSystemUtil.loadPSApplication(ipsSystem, strPSSysAppId, IPSSystem.LOADLEVEL_CODE);
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PUBLISHCODE, (boolean)true) == 0) {
            return this.publishCode(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATECODE, (boolean)true) == 0) {
            return this.generateCode(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATECODE2, (boolean)true) == 0) {
            return this.generateCode2(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CALCSYSREFFLAG, (boolean)true) == 0) {
            return this.calcSysRefFlag(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATEMODELVIEW, (boolean)true) == 0) {
            return this.generateViewModel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult generateCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSysApp psSysApp = new PSSysApp();
            psSysApp.proxy(dataEntity);
            this.onGenerateCode2(psSysApp);
            this.onGenerateCode(psSysApp);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenerateCode(PSSysApp psSysApp) throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSYSAPPID", (Object)psSysApp.getPSSYSAPPID());
        IDEDataCtrl psAppViewDataCtrl = this.GetRelatedDataCtrl("DE2506");
        Vector<PSAppView> psAppViewList = new Vector<PSAppView>();
        CallResult callResult = psAppViewDataCtrl.Select(cond, psAppViewList, PSAppView.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        TaskManager taskManager = new TaskManager(psAppViewDataCtrl, psAppViewList);
        long nBeginTime = System.currentTimeMillis();
        taskManager.start();
        long nTime = System.currentTimeMillis() - nBeginTime;
        log.debug((Object)StringHelper.Format((String)"\u53d1\u5e03\u89c6\u56fe\u4ee3\u7801\u6570\u91cf[%1$s]\uff0c\u8017\u65f6[%2$s]ms\uff0c\u9519\u8bef\u6570\u91cf[%3$s]", (Object)psAppViewList.size(), (Object)nTime, (Object)taskManager.getErrorCount()));
        if (taskManager.getErrorCount() > 0) {
            throw new Exception(StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u89c6\u56fe\u4ee3\u7801\u53d1\u751f\u9519\u8bef"));
        }
    }

    public CallResult generateCode2(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSysApp psSysApp = new PSSysApp();
            psSysApp.proxy(dataEntity);
            this.onGenerateCode2(psSysApp);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenerateCode2(PSSysApp psSysApp) throws Exception {
        IPSApplication iPSApplication;
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
        if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
            this.getPSModelStorage().resetPSSystem(psSysApp.getPSSYSTEMID());
            this.getPSModelHelper().startLoadPSSystem(psSysApp.getPSSYSTEMID(), IPSSystem.LOADLEVEL_CODE);
            try {
                iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
                iPSSystem.load(IPSSystem.LOADLEVEL_CODE);
                this.getPSModelHelper().stopLoadPSSystem();
            }
            catch (Exception ex) {
                this.getPSModelHelper().stopLoadPSSystem();
                throw ex;
            }
        }
        if ((iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSYSAPPID())).getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
            PSSystemUtil.loadPSApplication(iPSSystem, psSysApp.getPSSYSAPPID(), IPSSystem.LOADLEVEL_CODE);
        }
        IPSPF iPSPF = iPSApplication.getPSPF();
        IPSPFStyle iPSPFStyle = iPSApplication.getPSPFStyle();
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl((IDEDataCtrl)this);
        Iterator<IPSPFAppTempl> psPFAppTempls = iPSPFStyle.getPSPFAppTempls(iPSApplication);
        while (psPFAppTempls.hasNext()) {
            IPSPFAppTempl iPSPFAppTempl = psPFAppTempls.next();
            IPSPFAppCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppCodePublisher();
            iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSApplication);
            iPSPFAppCodePublisher.close();
        }
    }

    public CallResult publishCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSysApp psSysApp = new PSSysApp();
            psSysApp.proxy(dataEntity);
            this.onPublishCode(psSysApp);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void onPublishCode(PSSysApp psSysApp) throws Exception {
        strFolder = this.getGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", "");
        if (StringHelper.IsNullOrEmpty((String)strFolder)) {
            throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u4ee3\u7801\u53d1\u5e03\u76ee\u5f55");
        }
        strPubFolder = String.valueOf(strFolder) + File.separator + psSysApp.getPSSYSAPPID();
        cond = new BaseDataEntity();
        cond.setParamValue("PSSYSAPPID", (Object)psSysApp.getPSSYSAPPID());
        psAppViewCodeDataCtrl = this.GetRelatedDataCtrl("DE2590");
        psAppViewCodeList = new Vector<E>();
        callResult = psAppViewCodeDataCtrl.Select(cond, psAppViewCodeList, PSAppViewCode.class.getName());
        if (!callResult.isError()) ** GOTO lbl30
        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u53d1\u5e03\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
lbl-1000:
        // 1 sources

        {
            strCodeFolder = strPubFolder;
            psAppViewCode = (PSAppViewCode)psAppViewCodeList.remove(0);
            strCodePath = psAppViewCode.getCODEPATH();
            nPos = strCodePath.lastIndexOf("/");
            if (nPos != -1) {
                strCodeFolder = String.valueOf(strCodeFolder) + strCodePath.substring(0, nPos);
            }
            if (!(folder = new File(strCodeFolder)).exists()) {
                folder.mkdirs();
            }
            strFullPath = String.valueOf(strPubFolder) + strCodePath;
            strCode = psAppViewCode.getUSERCODE();
            if (StringHelper.IsNullOrEmpty((String)strCode)) {
                strCode = psAppViewCode.getPUBCODE();
            }
            write = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(strFullPath)), "UTF-8");
            writer = new BufferedWriter(write);
            writer.write(strCode);
            writer.flush();
            writer.close();
lbl30:
            // 2 sources

            ** while (psAppViewCodeList.size() > 0)
        }
lbl31:
        // 1 sources

    }

    public CallResult calcSysRefFlag(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSysApp psSysApp = new PSSysApp();
            psSysApp.proxy(dataEntity);
            this.onCalcSysRefFlag(psSysApp);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u8ba1\u7b97\u5e94\u7528\u89c6\u56fe\u5f15\u7528\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCalcSysRefFlag(PSSysApp psSysApp) throws Exception {
        IPSApplication iPSApplication;
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
        if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
            this.getPSModelStorage().resetPSSystem(psSysApp.getPSSYSTEMID());
            this.getPSModelHelper().startLoadPSSystem(psSysApp.getPSSYSTEMID(), IPSSystem.LOADLEVEL_CODE);
            try {
                iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
                iPSSystem.load(IPSSystem.LOADLEVEL_CODE);
                this.getPSModelHelper().stopLoadPSSystem();
            }
            catch (Exception ex) {
                this.getPSModelHelper().stopLoadPSSystem();
                throw ex;
            }
        }
        if ((iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSYSAPPID())).getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
            PSSystemUtil.loadPSApplication(iPSSystem, psSysApp.getPSSYSAPPID(), IPSSystem.LOADLEVEL_CODE);
        }
        IPSApplicationRuntime iPSApplicationRuntime = (IPSApplicationRuntime)((Object)iPSApplication);
        iPSApplicationRuntime.calcPSAppViewSysRefFlag();
    }

    public CallResult generateViewModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSysApp psSysApp = new PSSysApp();
            psSysApp.proxy(dataEntity);
            this.onGenerateViewModel(psSysApp);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u89c6\u56fe\u5f15\u7528\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenerateViewModel(PSSysApp psSysApp) throws Exception {
        IPSApplication iPSApplication;
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
        if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
            this.getPSModelStorage().resetPSSystem(psSysApp.getPSSYSTEMID());
            this.getPSModelHelper().startLoadPSSystem(psSysApp.getPSSYSTEMID(), IPSSystem.LOADLEVEL_CODE);
            try {
                iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
                iPSSystem.load(IPSSystem.LOADLEVEL_CODE);
                this.getPSModelHelper().stopLoadPSSystem();
            }
            catch (Exception ex) {
                this.getPSModelHelper().stopLoadPSSystem();
                throw ex;
            }
        }
        if ((iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSYSAPPID())).getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
            PSSystemUtil.loadPSApplication(iPSSystem, psSysApp.getPSSYSAPPID(), IPSSystem.LOADLEVEL_CODE);
        }
        IPSApplicationRuntime iPSApplicationRuntime = (IPSApplicationRuntime)((Object)iPSApplication);
        iPSApplicationRuntime.calcPSAppViewSysRefFlag();
        final IPSApplication iPSApplication2 = iPSApplication;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSModelViewService psModelViewService = (PSModelViewService)ServiceGlobal.getService(PSModelViewService.class);
                PSModelViewUIActionService psModelViewUIActionService = (PSModelViewUIActionService)ServiceGlobal.getService(PSModelViewUIActionService.class);
                Iterator<IPSAppView> psAppViews = iPSApplication2.getAllPSAppViews();
                while (psAppViews.hasNext()) {
                    IPSAppView iPSAppView = psAppViews.next();
                    PSModelView psModelView2 = new PSModelView();
                    psModelView2.setPSModelViewId(iPSAppView.getId());
                    boolean bInsert = !psModelViewService.get((IEntity)psModelView2, true);
                    PSModelView psModelView = new PSModelView();
                    psModelView.setPSModelViewId(iPSAppView.getId());
                    psModelView.setValidFlag(Integer.valueOf(iPSAppView.getRefFlag() ? 1 : 0));
                    psModelView.setViewTag(iPSAppView.getFullCodeName());
                    psModelView.setPSModelViewName(iPSAppView.getTitle());
                    psModelView.setPSViewTypeId(iPSAppView.getPSViewType().getId());
                    if (iPSAppView instanceof IPSAppDEView) {
                        IPSAppDEView iPSAppDEView = (IPSAppDEView)iPSAppView;
                        psModelView.setPSDEViewBaseId(iPSAppDEView.getPSDEViewId());
                        psModelView.setPSDEViewBaseName(iPSAppDEView.getPSDEViewName());
                        if (StringHelper.IsNullOrEmpty((String)psModelView2.getPSModelId())) {
                            psModelView.setPSModelId(iPSAppDEView.getPSDataEntity().getName());
                        }
                    }
                    if (bInsert) {
                        psModelViewService.create((IEntity)psModelView, false);
                    } else {
                        psModelViewService.update((IEntity)psModelView, false);
                    }
                    int nOrder = 100;
                    Iterator<IPSUIAction> psUIActions = iPSAppView.getPSUIActions();
                    if (psUIActions == null) continue;
                    while (psUIActions.hasNext()) {
                        IPSUIAction iPSUIAction = psUIActions.next();
                        if (!(iPSUIAction instanceof IPSDEUIAction)) continue;
                        IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)iPSUIAction;
                        String strKey = KeyValueHelper.genUniqueId((String)iPSAppView.getId(), (String)iPSDEUIAction.getId());
                        PSModelViewUIAction psModelViewUIAction = new PSModelViewUIAction();
                        psModelViewUIAction.setPSModelViewUIActionId(strKey);
                        if (psModelViewUIActionService.checkKey((IEntity)psModelViewUIAction) == 0) {
                            psModelViewUIAction.setPSModelViewUIActionName(iPSDEUIAction.getName());
                            psModelViewUIAction.setPSModelUIActionId(iPSDEUIAction.getId());
                            psModelViewUIAction.setPSModelUIActionName(iPSDEUIAction.getName());
                            psModelViewUIAction.setValidFlag(Integer.valueOf(1));
                            psModelViewUIAction.setOrderValue(Integer.valueOf(nOrder));
                            psModelViewUIAction.setPSModelViewId(iPSAppView.getId());
                            psModelViewUIActionService.create((IEntity)psModelViewUIAction);
                        }
                        nOrder += 100;
                    }
                }
            }
        });
    }

    public class TaskManager {
        private Vector<PSAppView> psAppViewList = new Vector();
        private IDEDataCtrl psAppViewDataCtrl = null;
        private int nTotalCount = 0;
        private int nFinishCount = 0;
        private int nErrorCount = 0;

        public TaskManager(IDEDataCtrl psAppViewDataCtrl, Vector<PSAppView> psAppViewList) {
            this.psAppViewList.addAll(psAppViewList);
            this.psAppViewDataCtrl = psAppViewDataCtrl;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void start() throws Exception {
            this.nTotalCount = this.psAppViewList.size();
            if (this.nTotalCount == 0) {
                return;
            }
            ArrayList<TaskThread> threads = new ArrayList<TaskThread>();
            int i = 0;
            while (i < 5) {
                TaskThread taskThread = new TaskThread();
                threads.add(taskThread);
                taskThread.start();
                ++i;
            }
            while (true) {
                Vector<PSAppView> vector = this.psAppViewList;
                synchronized (vector) {
                    if (this.nTotalCount == this.nFinishCount) {
                        break;
                    }
                }
                Thread.sleep(50L);
            }
            threads.clear();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean runTask() {
            Vector<PSAppView> vector;
            if (PSJITWebContext.getInstance() != null) {
                PSJITWebContext.setCurrent(null);
            }
            PSAppView psAppView = null;
            Vector<PSAppView> vector2 = this.psAppViewList;
            synchronized (vector2) {
                if (this.psAppViewList.size() <= 0) {
                    return false;
                }
                psAppView = this.psAppViewList.remove(0);
            }
            CallResult callResult = this.psAppViewDataCtrl.CustomCall(PSSysAppDataCtrl.CUSTOMCALL_GENERATECODE, (BaseDataEntity)psAppView);
            if (callResult.isError()) {
                log.error((Object)callResult.getErrorInfo());
                vector = this.psAppViewList;
                synchronized (vector) {
                    ++this.nErrorCount;
                }
            }
            vector = this.psAppViewList;
            synchronized (vector) {
                ++this.nFinishCount;
                return true;
            }
        }

        public int getErrorCount() {
            return this.nErrorCount;
        }

        public class TaskThread
        extends Thread {
            @Override
            public void run() {
                if (PSJITWebContext.getInstance() != null) {
                    PSJITWebContext.setCurrent(null);
                }
                while (TaskManager.this.runTask()) {
                    try {
                        Thread.sleep(10L);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

