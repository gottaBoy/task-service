package SA.SRFDA.PS.Core.JIT.App;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.Pub.IPSAppViewCode;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.JIT.Controller.IPSJITViewController;
import SA.SRFDA.PS.Core.JIT.Controller.PSJITRedirectViewController;
import SA.SRFDA.PS.Core.JIT.Controller.PSJITViewController;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFDEViewController;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebApplicationContext;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.AppModelBase;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.RequestContext;

public class PSJITAppModel extends AppModelBase implements IPSJITAppModel {
   private static final Log log = LogFactory.getLog(PSJITAppModel.class);
   private ISRFDAGlobalHelper iDAGlobalHelper = null;
   private IPSApplication iPSApplication = null;
   private IPSJITSystemModel iPSJITSystemModel = null;
   private HashMap<String, IPSJITViewController> viewControllerMap = new HashMap<>();
   private HashMap<String, IViewController> viewControllerMap2 = new HashMap<>();
   private HashMap<String, IAppMenuModel> appMenuModelMap2 = new HashMap<>();

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSJITSystemModel iPSJITSystemModel, IPSApplication iPSApplication) throws Exception {
      this.setDAGlobalHelper(iDAGlobalHelper);
      this.iPSJITSystemModel = iPSJITSystemModel;
      this.iPSApplication = iPSApplication;
      this.setId(this.iPSApplication.getId());
      this.setName(this.iPSApplication.getName());
      this.setPFType(this.getPSApplication().getPSPF().getId());
      this.onInit();
   }

   @Override
   protected void onInit() throws Exception {
      this.prepareAppUserModeMenus();
      super.onInit();
   }

   @Override
   public ISystem getSystem() {
      return this.iPSJITSystemModel;
   }

   @Override
   public IPSJITSystemModel getPSJITSystemModel() {
      return this.iPSJITSystemModel;
   }

   @Override
   public IPSApplication getPSApplication() {
      return this.iPSApplication;
   }

   @Override
   public IPSJITViewController getViewController(IPSAppView iPSAppView) throws Exception {
      synchronized (this.viewControllerMap) {
         IPSJITViewController iPSJITViewController = this.viewControllerMap.get(iPSAppView.getId());
         if (iPSJITViewController != null) {
            return iPSJITViewController;
         }

         PSJITViewController psJITViewController = null;
         if (iPSAppView.isRedirectView()) {
            psJITViewController = new PSJITRedirectViewController();
         } else if (iPSAppView.isEnableWF()) {
            psJITViewController = new PSJITWFDEViewController();
         } else {
            psJITViewController = new PSJITViewController();
         }

         psJITViewController.init(this, iPSAppView);
         this.viewControllerMap.put(iPSAppView.getId(), psJITViewController);
         return psJITViewController;
      }
   }

   @Override
   public IWebContext createWebContext(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
      return PSJITWebContext.getInstance();
   }

   protected void prepareAppUserModeMenus() throws Exception {
      HashMap<String, IPSAppMenuModel> psAppMenuModelMap = new HashMap<>();
      Iterator<IPSAppUserMode> psAppUserModes = this.getPSApplication().getAllPSAppUserModes();

      while (psAppUserModes.hasNext()) {
         IPSAppUserMode iPSAppUserMode = psAppUserModes.next();
         if (iPSAppUserMode.getPSSysUserMode() != null) {
            this.registerUserModeMenu(iPSAppUserMode.getPSSysUserMode().getName(), iPSAppUserMode.getPSAppMenuModel().getId());
         } else {
            this.registerUserModeMenu("", iPSAppUserMode.getPSAppMenuModel().getId());
         }

         psAppMenuModelMap.put(iPSAppUserMode.getPSAppMenuModel().getId(), iPSAppUserMode.getPSAppMenuModel());
      }

      for (IPSAppMenuModel iPSAppMenuModel : psAppMenuModelMap.values()) {
         PSJITAppMenuModel psJITAppMenuModel = new PSJITAppMenuModel();
         psJITAppMenuModel.init(this, iPSAppMenuModel);
      }
   }

   @Override
   public void registerViewController2(String strViewControllerClsType, IViewController iViewController) {
      synchronized (this.viewControllerMap2) {
         this.viewControllerMap2.put(strViewControllerClsType, iViewController);
      }
   }

   @Override
   public IViewController getViewController2(Class cls) throws Exception {
      return this.getViewController2(cls.getCanonicalName());
   }

   @Override
   public IViewController getViewController2(String strViewControllerClsType) throws Exception {
      return this.internalGetViewController2(strViewControllerClsType);
   }

   private IViewController internalGetViewController2(String strViewControllerClsType) throws Exception {
      synchronized (this.viewControllerMap2) {
         return this.viewControllerMap2.get(strViewControllerClsType);
      }
   }

   @Override
   public void registerAppMenuModel2(String strAppMenuModelClsType, IAppMenuModel iAppMenuModel) {
      synchronized (this.appMenuModelMap2) {
         this.appMenuModelMap2.put(strAppMenuModelClsType, iAppMenuModel);
      }
   }

   @Override
   public IAppMenuModel getAppMenuModel2(Class cls) throws Exception {
      return this.getAppMenuModel(cls.getCanonicalName());
   }

   @Override
   public IAppMenuModel getAppMenuModel2(String strAppMenuModelClsType) throws Exception {
      return this.internalGetAppMenuModel(strAppMenuModelClsType);
   }

   private IAppMenuModel internalGetAppMenuModel(String strAppMenuModelClsType) throws Exception {
      synchronized (this.appMenuModelMap2) {
         return this.appMenuModelMap2.get(strAppMenuModelClsType);
      }
   }

   @Override
   public boolean doFilter(Page page, HttpServletRequest request, HttpServletResponse response) throws Exception {
      if (page != null) {
         request.setAttribute(RequestContext.WEB_APPLICATION_CONTEXT_ATTRIBUTE, new PSJITWebApplicationContext(request.getSession().getServletContext()));
      }

      return super.doFilter(page, request, response);
   }

   protected String generateCode() throws Exception {
      boolean bLastWriteCode = PSJITWebContext.getInstance().isRealWriteFile();

      try {
         PSJITWebContext.getInstance().setRealWriteFile(true);
         StringBuilderEx sBuilderEx = new StringBuilderEx();
         sBuilderEx.append(this.onGenerateCode());
         sBuilderEx.append(this.onGenerateCode2());
         this.generateUserCode();
         PSJITWebContext.getInstance().setRealWriteFile(bLastWriteCode);
         return sBuilderEx.toString();
      } catch (Exception ex) {
         PSJITWebContext.getInstance().setRealWriteFile(bLastWriteCode);
         throw ex;
      }
   }

   protected String onGenerateCode() throws Exception {
      String strPSDevSlnSysId = this.iPSApplication.getPSSystem().getPSDevSlnSysId();
      String strPSSysModelInstId = this.iPSApplication.getPSSysModelInstId();
      StringBuilderEx sBuilderEx = new StringBuilderEx();

      try {
         long nBeginTime = System.currentTimeMillis();
         Iterator<IPSAppView> psAppViews = this.iPSApplication.getAllPSAppViews();

         while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = psAppViews.next();
            this.generateViewCode(iPSAppView);
         }

         long nTime = System.currentTimeMillis() - nBeginTime;
         log.debug(StringHelper.format("发布JIT视图代码耗时[%1$s]ms", nTime));
         sBuilderEx.append(StringHelper.format("发布视图代码耗时[%1$s]ms", nTime));
      } catch (Exception ex) {
         log.error(StringHelper.format("产生视图代码发生异常，%1$s", ex.getMessage()), ex);
         throw ex;
      }

      return sBuilderEx.toString();
   }

   protected String onGenerateCode2() throws Exception {
      StringBuilderEx sBuilderEx = new StringBuilderEx();
      IPSPFStyle iPSPFStyle = this.iPSApplication.getPSPFStyle();
      PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
      psPublishContextImpl.setPSSysModelInstId(this.iPSApplication.getPSSysModelInstId());
      Iterator<IPSPFAppTempl> psPFAppTempls = iPSPFStyle.getPSPFAppTempls(this.iPSApplication);

      while (psPFAppTempls.hasNext()) {
         IPSPFAppTempl iPSPFAppTempl = psPFAppTempls.next();
         IPSPFAppCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppCodePublisher();
         iPSPFAppCodePublisher.generateCode(psPublishContextImpl, this.iPSApplication);
         iPSPFAppCodePublisher.close();
      }

      return sBuilderEx.toString();
   }

   protected void generateUserCode() throws Exception {
      Iterator<IPSAppViewCode> psAppViewCodes = this.iPSApplication.getAllPSAppViewCodes();
      if (psAppViewCodes != null) {
         String strCodeFolder = this.iPSJITSystemModel.getJITCodeFolder();
         if (StringHelper.isNullOrEmpty(strCodeFolder)) {
            throw new Exception("没有定义代码发布目录");
         }

         while (psAppViewCodes.hasNext()) {
            IPSAppViewCode iPSAppViewCode = psAppViewCodes.next();
            if (iPSAppViewCode.getPSPFPubCode() == null) {
               String strFolder = strCodeFolder;
               strFolder = strFolder + File.separator + this.iPSApplication.getPSSystem().getPSDevCenterDomain();
               strFolder = strFolder + File.separator + this.iPSApplication.getPSSystem().getPubSystemId();
               strFolder = strFolder + File.separator + this.iPSApplication.getPSSystem().getVCName();
               strFolder = strFolder + File.separator + "app_" + this.iPSApplication.getWorkshopName();
               strFolder = strFolder + File.separator + "USERCODE";
               strFolder = strFolder + File.separator + iPSAppViewCode.getProjectType();
               if (!StringHelper.isNullOrEmpty(iPSAppViewCode.getFilePath())) {
                  strFolder = strFolder + File.separator + iPSAppViewCode.getFilePath();
               }

               strFolder = strFolder.replace("/", File.separator);
               File folder = new File(strFolder);
               if (!folder.exists()) {
                  folder.mkdirs();
               }

               String strFullPath = strFolder + File.separator + iPSAppViewCode.getName();
               if (strFullPath.length() >= PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()) {
                  String strInfo = StringHelper.format("发布代码[%1$s]路径过长[%2$s]，可能无法写入", strFullPath, strFullPath.length());
                  ((IPSSystemUtil)this.iPSApplication.getPSSystem()).log(4, this.iPSApplication, strInfo);
                  log.warn(strInfo);
                  if (PSTaskServerEnvImpl.getCurrent().isThrowExceptionWhenFileNameTooLong()) {
                     throw new Exception(StringHelper.format("发布代码[%1$s]名称长度超过[%2$s]", strFullPath, PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()));
                  }
               }

               ((IPSSystemUtil)this.iPSApplication.getPSSystem()).writeFile(strFullPath, iPSAppViewCode.getUserCode(), null);
            }
         }
      }
   }

   protected boolean generateViewCode(IPSAppView iPSAppView) throws Exception {
      if (!StringHelper.isNullOrEmpty(iPSAppView.getSubAppFolderName())) {
         return false;
      }

      if (this.iPSApplication.isPubRefViewOnly() && !iPSAppView.getRefFlag()) {
         return false;
      }

      PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
      psPublishContextImpl.setPSSysModelInstId(this.iPSApplication.getPSSysModelInstId());
      Iterator<IPSPFViewTempl> psPFViewTempls = iPSAppView.getPSPFStyle().getPSPFViewTempls(iPSAppView);

      while (psPFViewTempls.hasNext()) {
         IPSPFViewTempl iPSPFViewTempl = psPFViewTempls.next();
         IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
         iPSPFViewCodePublisher.generateCode(psPublishContextImpl, iPSAppView);
         iPSPFViewCodePublisher.close();
      }

      return true;
   }

   public ISRFDAGlobalHelper getDAGlobalHelper() {
      return this.iDAGlobalHelper;
   }

   public void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
      this.iDAGlobalHelper = iDAGlobalHelper;
   }
}
