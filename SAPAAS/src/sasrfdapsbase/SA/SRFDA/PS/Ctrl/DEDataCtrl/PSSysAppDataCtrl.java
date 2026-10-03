package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSSysApp;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.config.entity.PSModelView;
import net.ibizsys.pscore.srv.config.entity.PSModelViewUIAction;
import net.ibizsys.pscore.srv.config.service.PSModelViewService;
import net.ibizsys.pscore.srv.config.service.PSModelViewUIActionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAppDataCtrl extends PSDEDataCtrl {
   public static final String CUSTOMCALL_PUBLISHCODE = "PUBLISHCODE";
   public static final String CUSTOMCALL_GENERATECODE = "GENERATECODE";
   public static final String CUSTOMCALL_GENERATECODE2 = "GENERATECODE2";
   public static final String CUSTOMCALL_CALCSYSREFFLAG = "CALCSYSREFFLAG";
   public static final String CUSTOMCALL_GENERATEMODELVIEW = "GENERATEMODELVIEW";
   private static final Log log = LogFactory.getLog(PSSysAppDataCtrl.class);

   @Override
   protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
      CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
      return callResult.isError() ? callResult : callResult;
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
      if (StringHelper.Compare(strCallName, "PUBLISHCODE", true) == 0) {
         return this.publishCode(dataEntity);
      } else if (StringHelper.Compare(strCallName, "GENERATECODE", true) == 0) {
         return this.generateCode(dataEntity);
      } else if (StringHelper.Compare(strCallName, "GENERATECODE2", true) == 0) {
         return this.generateCode2(dataEntity);
      } else if (StringHelper.Compare(strCallName, "CALCSYSREFFLAG", true) == 0) {
         return this.calcSysRefFlag(dataEntity);
      } else {
         return StringHelper.Compare(strCallName, "GENERATEMODELVIEW", true) == 0
            ? this.generateViewModel(dataEntity)
            : super.OnCustomCall(strCallName, dataEntity);
      }
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
      } catch (Exception ex) {
         log.error(StringHelper.Format("发布应用代码发生异常，%1$s", ex.getMessage()), ex);
         callResult.setRetCode(1);
         callResult.setErrorInfo(ex.getMessage());
         return callResult;
      }
   }

   protected void onGenerateCode(PSSysApp psSysApp) throws Exception {
      BaseDataEntity cond = new BaseDataEntity();
      cond.setParamValue("PSSYSAPPID", psSysApp.getPSSYSAPPID());
      IDEDataCtrl psAppViewDataCtrl = this.GetRelatedDataCtrl("DE2506");
      Vector<PSAppView> psAppViewList = new Vector<>();
      CallResult callResult = psAppViewDataCtrl.Select(cond, psAppViewList, PSAppView.class.getName());
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询应用视图发生错误，%1$s", callResult.getErrorInfo()));
      }

      PSSysAppDataCtrl.TaskManager taskManager = new PSSysAppDataCtrl.TaskManager(psAppViewDataCtrl, psAppViewList);
      long nBeginTime = System.currentTimeMillis();
      taskManager.start();
      long nTime = System.currentTimeMillis() - nBeginTime;
      log.debug(StringHelper.Format("发布视图代码数量[%1$s]，耗时[%2$s]ms，错误数量[%3$s]", psAppViewList.size(), nTime, taskManager.getErrorCount()));
      if (taskManager.getErrorCount() > 0) {
         throw new Exception(StringHelper.Format("发布应用视图代码发生错误"));
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
      } catch (Exception ex) {
         log.error(StringHelper.Format("发布应用代码发生异常，%1$s", ex.getMessage()), ex);
         callResult.setRetCode(1);
         callResult.setErrorInfo(ex.getMessage());
         return callResult;
      }
   }

   protected void onGenerateCode2(PSSysApp psSysApp) throws Exception {
      IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
      if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
         this.getPSModelStorage().resetPSSystem(psSysApp.getPSSYSTEMID());
         this.getPSModelHelper().startLoadPSSystem(psSysApp.getPSSYSTEMID(), IPSSystem.LOADLEVEL_CODE);

         try {
            iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
            iPSSystem.load(IPSSystem.LOADLEVEL_CODE);
            this.getPSModelHelper().stopLoadPSSystem();
         } catch (Exception ex) {
            this.getPSModelHelper().stopLoadPSSystem();
            throw ex;
         }
      }

      IPSApplication iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSYSAPPID());
      if (iPSApplication.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
         PSSystemUtil.loadPSApplication(iPSSystem, psSysApp.getPSSYSAPPID(), IPSSystem.LOADLEVEL_CODE);
      }

      IPSPF iPSPF = iPSApplication.getPSPF();
      IPSPFStyle iPSPFStyle = iPSApplication.getPSPFStyle();
      PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this);
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
      } catch (Exception ex) {
         log.error(StringHelper.Format("发布应用代码发生异常，%1$s", ex.getMessage()), ex);
         callResult.setRetCode(1);
         callResult.setErrorInfo(ex.getMessage());
         return callResult;
      }
   }

   protected void onPublishCode(PSSysApp psSysApp) throws Exception {
      String strFolder = this.getGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", "");
      if (StringHelper.IsNullOrEmpty(strFolder)) {
         throw new Exception("没有定义代码发布目录");
      }

      String strPubFolder = strFolder + File.separator + psSysApp.getPSSYSAPPID();
      BaseDataEntity cond = new BaseDataEntity();
      cond.setParamValue("PSSYSAPPID", psSysApp.getPSSYSAPPID());
      IDEDataCtrl psAppViewCodeDataCtrl = this.GetRelatedDataCtrl("DE2590");
      Vector<PSAppViewCode> psAppViewCodeList = new Vector<>();
      CallResult callResult = psAppViewCodeDataCtrl.Select(cond, psAppViewCodeList, PSAppViewCode.class.getName());
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询发布代码发生错误，%1$s", callResult.getErrorInfo()));
      }

      while (psAppViewCodeList.size() > 0) {
         String strCodeFolder = strPubFolder;
         PSAppViewCode psAppViewCode = psAppViewCodeList.remove(0);
         String strCodePath = psAppViewCode.getCODEPATH();
         int nPos = strCodePath.lastIndexOf("/");
         if (nPos != -1) {
            strCodeFolder = strCodeFolder + strCodePath.substring(0, nPos);
         }

         File folder = new File(strCodeFolder);
         if (!folder.exists()) {
            folder.mkdirs();
         }

         String strFullPath = strPubFolder + strCodePath;
         String strCode = psAppViewCode.getUSERCODE();
         if (StringHelper.IsNullOrEmpty(strCode)) {
            strCode = psAppViewCode.getPUBCODE();
         }

         OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(new File(strFullPath)), "UTF-8");
         BufferedWriter writer = new BufferedWriter(write);
         writer.write(strCode);
         writer.flush();
         writer.close();
      }
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
      } catch (Exception ex) {
         log.error(StringHelper.Format("计算应用视图引用发生异常，%1$s", ex.getMessage()), ex);
         callResult.setRetCode(1);
         callResult.setErrorInfo(ex.getMessage());
         return callResult;
      }
   }

   protected void onCalcSysRefFlag(PSSysApp psSysApp) throws Exception {
      IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
      if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
         this.getPSModelStorage().resetPSSystem(psSysApp.getPSSYSTEMID());
         this.getPSModelHelper().startLoadPSSystem(psSysApp.getPSSYSTEMID(), IPSSystem.LOADLEVEL_CODE);

         try {
            iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
            iPSSystem.load(IPSSystem.LOADLEVEL_CODE);
            this.getPSModelHelper().stopLoadPSSystem();
         } catch (Exception ex) {
            this.getPSModelHelper().stopLoadPSSystem();
            throw ex;
         }
      }

      IPSApplication iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSYSAPPID());
      if (iPSApplication.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
         PSSystemUtil.loadPSApplication(iPSSystem, psSysApp.getPSSYSAPPID(), IPSSystem.LOADLEVEL_CODE);
      }

      IPSApplicationRuntime iPSApplicationRuntime = (IPSApplicationRuntime)iPSApplication;
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
      } catch (Exception ex) {
         log.error(StringHelper.Format("发布应用视图引用发生异常，%1$s", ex.getMessage()), ex);
         callResult.setRetCode(1);
         callResult.setErrorInfo(ex.getMessage());
         return callResult;
      }
   }

   protected void onGenerateViewModel(PSSysApp psSysApp) throws Exception {
      IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
      if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
         this.getPSModelStorage().resetPSSystem(psSysApp.getPSSYSTEMID());
         this.getPSModelHelper().startLoadPSSystem(psSysApp.getPSSYSTEMID(), IPSSystem.LOADLEVEL_CODE);

         try {
            iPSSystem = this.getPSModelStorage().getPSSystem(psSysApp.getPSSYSTEMID());
            iPSSystem.load(IPSSystem.LOADLEVEL_CODE);
            this.getPSModelHelper().stopLoadPSSystem();
         } catch (Exception ex) {
            this.getPSModelHelper().stopLoadPSSystem();
            throw ex;
         }
      }

      IPSApplication iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSYSAPPID());
      if (iPSApplication.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
         PSSystemUtil.loadPSApplication(iPSSystem, psSysApp.getPSSYSAPPID(), IPSSystem.LOADLEVEL_CODE);
      }

      IPSApplicationRuntime iPSApplicationRuntime = (IPSApplicationRuntime)iPSApplication;
      iPSApplicationRuntime.calcPSAppViewSysRefFlag();
      final IPSApplication iPSApplication2 = iPSApplication;
      PSBKTaskWorkHelper.execute(new IPSBKTaskWork() {
         @Override
         public void execute(Object obj) throws Exception {
            PSModelViewService psModelViewService = (PSModelViewService)ServiceGlobal.getService(PSModelViewService.class);
            PSModelViewUIActionService psModelViewUIActionService = (PSModelViewUIActionService)ServiceGlobal.getService(PSModelViewUIActionService.class);
            Iterator<IPSAppView> psAppViews = iPSApplication2.getAllPSAppViews();

            while (psAppViews.hasNext()) {
               IPSAppView iPSAppView = psAppViews.next();
               PSModelView psModelView2 = new PSModelView();
               psModelView2.setPSModelViewId(iPSAppView.getId());
               boolean bInsert = !psModelViewService.get(psModelView2, true);
               PSModelView psModelView = new PSModelView();
               psModelView.setPSModelViewId(iPSAppView.getId());
               psModelView.setValidFlag(iPSAppView.getRefFlag() ? 1 : 0);
               psModelView.setViewTag(iPSAppView.getFullCodeName());
               psModelView.setPSModelViewName(iPSAppView.getTitle());
               psModelView.setPSViewTypeId(iPSAppView.getPSViewType().getId());
               if (iPSAppView instanceof IPSAppDEView) {
                  IPSAppDEView iPSAppDEView = (IPSAppDEView)iPSAppView;
                  psModelView.setPSDEViewBaseId(iPSAppDEView.getPSDEViewId());
                  psModelView.setPSDEViewBaseName(iPSAppDEView.getPSDEViewName());
                  if (StringHelper.IsNullOrEmpty(psModelView2.getPSModelId())) {
                     psModelView.setPSModelId(iPSAppDEView.getPSDataEntity().getName());
                  }
               }

               if (bInsert) {
                  psModelViewService.create(psModelView, false);
               } else {
                  psModelViewService.update(psModelView, false);
               }

               int nOrder = 100;
               Iterator<IPSUIAction> psUIActions = iPSAppView.getPSUIActions();
               if (psUIActions != null) {
                  while (psUIActions.hasNext()) {
                     IPSUIAction iPSUIAction = psUIActions.next();
                     if (iPSUIAction instanceof IPSDEUIAction) {
                        IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)iPSUIAction;
                        String strKey = KeyValueHelper.genUniqueId(iPSAppView.getId(), iPSDEUIAction.getId());
                        PSModelViewUIAction psModelViewUIAction = new PSModelViewUIAction();
                        psModelViewUIAction.setPSModelViewUIActionId(strKey);
                        if (psModelViewUIActionService.checkKey(psModelViewUIAction) == 0) {
                           psModelViewUIAction.setPSModelViewUIActionName(iPSDEUIAction.getName());
                           psModelViewUIAction.setPSModelUIActionId(iPSDEUIAction.getId());
                           psModelViewUIAction.setPSModelUIActionName(iPSDEUIAction.getName());
                           psModelViewUIAction.setValidFlag(1);
                           psModelViewUIAction.setOrderValue(nOrder);
                           psModelViewUIAction.setPSModelViewId(iPSAppView.getId());
                           psModelViewUIActionService.create(psModelViewUIAction);
                        }

                        nOrder += 100;
                     }
                  }
               }
            }
         }
      });
   }

   public class TaskManager {
      private Vector<PSAppView> psAppViewList = new Vector<>();
      private IDEDataCtrl psAppViewDataCtrl = null;
      private int nTotalCount = 0;
      private int nFinishCount = 0;
      private int nErrorCount = 0;

      public TaskManager(IDEDataCtrl psAppViewDataCtrl, Vector<PSAppView> psAppViewList) {
         this.psAppViewList.addAll(psAppViewList);
         this.psAppViewDataCtrl = psAppViewDataCtrl;
      }

      public void start() throws Exception {
         this.nTotalCount = this.psAppViewList.size();
         if (this.nTotalCount != 0) {
            ArrayList<PSSysAppDataCtrl.TaskManager.TaskThread> threads = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
               PSSysAppDataCtrl.TaskManager.TaskThread taskThread = new PSSysAppDataCtrl.TaskManager.TaskThread();
               threads.add(taskThread);
               taskThread.start();
            }

            while (true) {
               synchronized (this.psAppViewList) {
                  if (this.nTotalCount == this.nFinishCount) {
                     break;
                  }
               }

               Thread.sleep(50L);
            }

            threads.clear();
         }
      }

      public boolean runTask() {
         if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
         }

         PSAppView psAppView = null;
         synchronized (this.psAppViewList) {
            if (this.psAppViewList.size() <= 0) {
               return false;
            }

            psAppView = this.psAppViewList.remove(0);
         }

         CallResult callResult = this.psAppViewDataCtrl.CustomCall("GENERATECODE", psAppView);
         if (callResult.isError()) {
            PSSysAppDataCtrl.log.error(callResult.getErrorInfo());
            synchronized (this.psAppViewList) {
               this.nErrorCount++;
            }
         }

         synchronized (this.psAppViewList) {
            this.nFinishCount++;
            return true;
         }
      }

      public int getErrorCount() {
         return this.nErrorCount;
      }

      public class TaskThread extends Thread {
         @Override
         public void run() {
            if (PSJITWebContext.getInstance() != null) {
               PSJITWebContext.setCurrent(null);
            }

            while (TaskManager.this.runTask()) {
               try {
                  Thread.sleep(10L);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      }
   }
}
