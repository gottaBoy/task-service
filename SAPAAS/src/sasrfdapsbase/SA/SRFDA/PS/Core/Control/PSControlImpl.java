package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl3;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewPreview;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSPFPubSupportable;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsg;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IView;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSControlImpl extends PSObjectImpl3 implements IPSControl, IPSControlPreviewable, IPSPFPubSupportable {
   private static final Log log = LogFactory.getLog(PSControlImpl.class);
   public static final String MODELGROUP_DETAIL = "部件元素";
   public static final String MODELGROUP_LOGIC = "部件逻辑";
   public static final String MODELGROUP_NAV = "部件导航";
   public static final String[] MODELGROUPS = new String[]{"基本", "部件元素", "部件逻辑", "部件导航", "用户扩展", "其它"};
   public static final int MODELORDER_DETAIL = 150;
   public static final int MODELORDER_LOGIC = 200;
   public static final int MODELORDER_NAV = 300;
   public static final int DEFAULTORDERVALUE = 99999;
   public static final String MODELREF_LINK = "LINK";
   public static final String MODELREF_MUSTREF = "MUSTREF";
   public static final String MODEL_SINGLE = "SINGLE";
   public static final String MODELREF_INDIVIDUAL = "INDIVIDUAL";
   private IPSControlContainer iPSControlContainer = null;
   private IPSControlType iPSControlType = null;
   private IPSDataEntity iPSDataEntity = null;
   protected IPSControlParam iPSControlParam = null;
   private IPSSysCss iPSSysCss = null;
   private IPSSysPFPlugin iPSSysPFPlugin = null;
   private IPSCtrlMsg iPSCtrlMsg = null;
   private boolean bDesignMode = false;
   private String strUniqueId = "";
   private double fWidth = 0.0;
   private double fHeight = 0.0;
   private int nOrderValue = 99999;
   private IPSControlXDataContainer iPSControlXDataContainer = null;
   private boolean bDefaultCtrl = false;
   private Boolean bDynamicCtrl = null;
   private String strLogicName = null;
   private IPSPF previewPSPF = null;
   private List<IPSControlLogic> psControlLogicList = null;
   private Map<String, ArrayList<IPSControlLogic>> hookEventMap = null;
   private IPSPFXCodeObject iPSPFXCodeObject = null;
   private IPSAppDataEntity iPSAppDataEntity = null;
   private IPSPFPubHelp iPSPFPubHelp = null;
   private List<IPSControlAttribute> psControlAttributeList = null;
   private List<IPSControlRender> psControlRenderList = null;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
      this.setDAGlobalHelper(iDAGlobalHelper);
      this.setPSControlContainer(iPSControlContainer);
      this.setName(strName);
      this.iPSControlParam = iPSControlParam;
      if (this.getPSAppView() != null) {
         this.strUniqueId = this.getPSAppView().generateCtrlUniId();
      } else {
         this.strUniqueId = "";
      }

      if (this.iPSControlParam.getWidth() != null) {
         this.fWidth = this.iPSControlParam.getWidth();
      }

      if (this.iPSControlParam.getHeight() != null) {
         this.fHeight = this.iPSControlParam.getHeight();
      }

      if (this.iPSControlParam.isDefaultCtrl() != null) {
         this.bDefaultCtrl = this.iPSControlParam.isDefaultCtrl();
      }

      if (this.iPSControlParam.getOrderValue() != null) {
         this.nOrderValue = this.iPSControlParam.getOrderValue();
      }

      if (!StringHelper.isNullOrEmpty(this.iPSControlParam.getPSSysPFPluginId())) {
         if (this.getPSApplication() != null) {
            this.iPSSysPFPlugin = this.getPSApplication().getPSSysPFPlugin(this.iPSControlParam.getPSSysPFPluginId(), "CONTROL", this.getControlType(), null);
         } else {
            this.iPSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(this.iPSControlParam.getPSSysPFPluginId());
         }

         if (this.getPSAppView() != null) {
            this.getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
         }
      }

      if (!StringHelper.isNullOrEmpty(this.iPSControlParam.getPSSysCssId())) {
         this.iPSSysCss = this.getPSSystem().getPSSysCss(this.iPSControlParam.getPSSysCssId());
         if (this.getPSAppView() != null) {
            if (this.getPSAppView().getPSPFStyle().isRegisterToContainer()) {
               this.getPSControlContainer().registerPSSysCss(this.iPSSysCss);
            } else {
               this.getPSAppView().registerPSSysCss(this.iPSSysCss);
            }
         }
      }

      if (!StringHelper.isNullOrEmpty(this.iPSControlParam.getPSCtrlMsgId())) {
         this.iPSCtrlMsg = this.getPSSystem().getPSCtrlMsg(this.iPSControlParam.getPSCtrlMsgId());
      }

      if (!this.isDesignMode() && !StringHelper.isNullOrEmpty(this.getId()) && this.getId().indexOf("SRFTEMPKEY:") == 0) {
         this.setDesignMode(true);
         if (this.getPreviewPSPF() == null) {
            this.setPreviewPSPF(this.calcPreviewPSPF());
         }
      }

      if (!this.isDesignMode() && this.getPSAppView() instanceof IPSAppViewPreview) {
         this.setDesignMode(((IPSAppViewPreview)this.getPSAppView()).isDesignMode());
         if (this.isDesignMode() && this.getPreviewPSPF() == null) {
            this.setPreviewPSPF(this.calcPreviewPSPF());
         }
      }

      if (this.iPSDataEntity == null && !StringHelper.isNullOrEmpty(this.iPSControlParam.getPSDEId())) {
         this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.iPSControlParam.getPSDEId(), false));
      }

      if (this.getPSDataEntity() != null && this.getPSAppDataEntity() == null) {
         if (this.getPSAppView().getPSAppDataEntity() != null) {
            if (StringHelper.compare(this.getPSAppView().getPSAppDataEntity().getPSDE().getId(), this.getPSDataEntity().getId(), false) == 0) {
               this.setPSAppDataEntity(this.getPSAppView().getPSAppDataEntity());
            } else if (this.getPSAppDataEntity() == null) {
               this.setPSAppDataEntity(this.getPSAppView().getPSApplication().getPSAppDataEntityByDEId(this.getPSDataEntity().getId(), true));
            }
         } else {
            this.setPSAppDataEntity(this.getPSAppView().getPSApplication().getPSAppDataEntityByDEId(this.getPSDataEntity().getId(), true));
         }
      }

      ServiceWorkHelper.getInstance().execute(new IServiceWork() {
         @Override
         public void execute(ITransaction iTransaction) throws Exception {
            if (!StringHelper.isNullOrEmpty(PSControlImpl.this.getModelType()) && !StringHelper.isNullOrEmpty(PSControlImpl.this.getId())) {
               String strUniqueTag = PSControlImpl.this.getPSAppView().getName() + "_" + PSControlImpl.this.getId();
               if (!ActionSessionManager.getCurrentSession().registerRecursion(PSControlImpl.this.getModelType(), strUniqueTag)) {
                  throw new Exception(StringHelper.format("视图[%1$s]部件[%2$s]存在递归引用", PSControlImpl.this.getPSAppView().getName(), PSControlImpl.this.getName()));
               }

               try {
                  PSControlImpl.this.onInit();
                  ActionSessionManager.getCurrentSession().unregisterRecursion(PSControlImpl.this.getModelType(), strUniqueTag);
               } catch (Exception ex) {
                  ActionSessionManager.getCurrentSession().unregisterRecursion(PSControlImpl.this.getModelType(), strUniqueTag);
                  throw ex;
               }
            } else {
               PSControlImpl.this.onInit();
            }
         }
      });
      if (this.isRegisterToPSAppDataEntity() && this.getPSAppDataEntity() != null) {
         this.getPSAppDataEntity().registerPSControl(this);
      }

      if (!this.isDesignMode()) {
         if (this.getPSSysPFPlugin() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId(this.getPSSysPFPlugin().getId(), this.getPSAppView().getPSPFStyle().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
               this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, this.getPSAppView(), this);
            }
         }

         this.registerPSControlLogics();
         this.onCheckControlParam();
      }
   }

   @Override
   protected int onCheck() throws Exception {
      if (this.isPrepareTemplV2logic()) {
         Iterator<? extends IPSControlAction> psControlActions = this.getPSControlActions();
         if (psControlActions != null) {
            while (psControlActions.hasNext()) {
               IPSControlAction iPSControlAction = psControlActions.next();
               iPSControlAction.getPSAppDataEntity();
            }
         }

         Iterator<? extends IPSControlLogic> psControlLogics = this.getAllPSControlLogics();
         if (psControlLogics != null) {
            while (psControlLogics.hasNext()) {
               IPSControlLogic iPSControlLogic = psControlLogics.next();
               iPSControlLogic.getPSAppDataEntity();
               iPSControlLogic.getPSAppDEUIAction();
               if (iPSControlLogic.getPSAppDEUILogic() != null) {
                  iPSControlLogic.getPSAppDEUILogic().check();
               }

               iPSControlLogic.getPSAppUILogic();
               iPSControlLogic.getPSAppViewEngine();
               iPSControlLogic.getPSAppViewLogic();
            }
         }

         Iterator<? extends IPSControlRender> psControlRenders = this.getAllPSControlRenders();
         if (psControlRenders != null) {
            while (psControlRenders.hasNext()) {
               IPSControlRender iPSControlRender = psControlRenders.next();
               if (iPSControlRender.getPSLayoutPanel() != null) {
                  iPSControlRender.getPSLayoutPanel().check();
               }
            }
         }
      }

      return super.onCheck();
   }

   protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
      return null;
   }

   private void registerPSControlLogics() throws Exception {
      Map<String, IPSAppDEUILogicGroupDetail> map = new LinkedHashMap<>();
      Iterator<? extends IPSAppDEUILogicGroupDetail> psAppDEUILogicGroupDetails = this.getPSAppDEUILogicGroupDetails();
      if (psAppDEUILogicGroupDetails != null) {
         while (psAppDEUILogicGroupDetails.hasNext()) {
            IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
            String strName = iPSAppDEUILogicGroupDetail.getName();
            if (!StringHelper.isNullOrEmpty(strName)) {
               strName = strName.toLowerCase();
               if (!map.containsKey(strName)) {
                  map.put(strName, iPSAppDEUILogicGroupDetail);
                  this.registerPSAppDEUILogicGroupDetail(iPSAppDEUILogicGroupDetail);
               }
            }
         }
      }

      String strPPSDEUILogicGroupId = this.iPSControlParam.getPSDEUILogicGroupId();
      if (!StringHelper.isNullOrEmpty(strPPSDEUILogicGroupId)) {
         if (this.getPSAppDataEntity() == null) {
            log.warn(String.format("部件[%1$s]应用实体无效，无法加载部件逻辑组", this.getName()));
            return;
         }

         List<IPSAppDEUILogicGroup> list = new ArrayList<>();

         while (!StringHelper.isNullOrEmpty(strPPSDEUILogicGroupId)) {
            IPSAppDEUILogicGroup parent = this.getPSAppDataEntity().getPSAppDEUILogicGroup(strPPSDEUILogicGroupId);
            if (list.contains(parent)) {
               throw new Exception(String.format("界面逻辑组[%1$s]出现递归引用", parent.getFullName()));
            }

            list.add(parent);
            strPPSDEUILogicGroupId = parent.getParentPSDEUILogicGroupId();
         }

         for (IPSAppDEUILogicGroup item : list) {
            psAppDEUILogicGroupDetails = item.getPSAppDEUILogicGroupDetails();
            if (psAppDEUILogicGroupDetails != null) {
               while (psAppDEUILogicGroupDetails.hasNext()) {
                  IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
                  String strName = iPSAppDEUILogicGroupDetail.getName();
                  if (!StringHelper.isNullOrEmpty(strName)) {
                     strName = strName.toLowerCase();
                     if (!map.containsKey(strName)) {
                        map.put(strName, iPSAppDEUILogicGroupDetail);
                        this.registerPSAppDEUILogicGroupDetail(iPSAppDEUILogicGroupDetail);
                     }
                  }
               }
            }
         }
      }
   }

   protected void registerPSAppDEUILogicGroupDetail(IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail) throws Exception {
      if ("CTRLEVENT".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
         || "TIMER".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
         || "CUSTOM".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
         || "ITEMBLANK".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
         || "ITEMENABLE".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
         || "ITEMVISIBLE".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
         || "ITEMDYNACLASS".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) {
         IPSAppDEUIAction iPSAppDEUIAction = null;
         if (StringHelper.compare(iPSAppDEUILogicGroupDetail.getLogicType(), "DEUIACTION", true) == 0) {
            IPSDataEntity iPSDataEntity = iPSAppDEUILogicGroupDetail.getPSDataEntity();
            if (iPSDataEntity == null) {
               iPSDataEntity = this.getPSDataEntity();
            }

            if (iPSDataEntity == null) {
               throw new Exception("当前实体无效");
            }

            IPSAppDataEntity iPSAppDataEntity = this.getPSAppView().getPSApplication().getPSAppDataEntity(iPSDataEntity, false);
            iPSAppDEUIAction = iPSAppDataEntity.getPSAppDEUIAction(iPSAppDEUILogicGroupDetail.getPSDEUIActionId(), false, this);
         }

         PSControlLogicProxy2 psControlLogicProxy2 = new PSControlLogicProxy2(this, iPSAppDEUILogicGroupDetail, iPSAppDEUIAction);
         this.registerPSControlLogic(psControlLogicProxy2);
      } else if ("RENDER".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) {
         PSControlRenderProxy psControlRenderProxy = new PSControlRenderProxy(this, iPSAppDEUILogicGroupDetail);
         this.registerPSControlRender(psControlRenderProxy);
      } else if ("ATTRIBUTE".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) {
         PSControlAttributeProxy psControlAttributeProxy = new PSControlAttributeProxy(this, iPSAppDEUILogicGroupDetail);
         this.registerPSControlAttribute(psControlAttributeProxy);
      }
   }

   protected void onCheckControlParam() throws Exception {
   }

   protected IPSPF calcPreviewPSPF() throws Exception {
      IPSPF iPSPF = this.getPSAppView().getPSApplication().getPSPF();
      if (iPSPF.isUseJITDesignPreview() && !this.getPSApplication().isEnableUIModelEx()) {
         if (iPSPF.getPSAppType().isMobileApp()) {
            iPSPF = this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewMobPFId());
         } else {
            iPSPF = this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewPCPFId());
         }
      }

      return iPSPF;
   }

   @PSModelRTMeta(description = "应用视图", debugmode = true)
   @Override
   public IPSAppView getPSAppView() {
      return this.iPSControlContainer != null ? this.iPSControlContainer.getPSAppView() : null;
   }

   @PSModelRTMeta(description = "部件参数", child = true, outputdoc = "false")
   @Override
   public IPSControlParam getPSControlParam() {
      return this.onGetPSControlParam();
   }

   protected IPSControlParam onGetPSControlParam() {
      return this.iPSControlParam;
   }

   @PSModelRTMeta(description = "部件处理", child = true, outputdoc = "false", ignorert = 3)
   @Override
   public IPSControlHandler getPSControlHandler() {
      return this.onGetPSControlHandler();
   }

   protected IPSControlHandler onGetPSControlHandler() {
      return null;
   }

   protected void setPSControlContainer(IPSControlContainer iPSControlContainer) {
      this.iPSControlContainer = iPSControlContainer;
      if (this.iPSControlContainer == null) {
         this.iPSControlXDataContainer = null;
      } else {
         this.iPSControlXDataContainer = this.calcPSControlXDataContainer();
      }
   }

   @Override
   public IPSControlContainer getPSControlContainer() {
      return this.iPSControlContainer;
   }

   @Override
   public IPSControlXDataContainer getPSControlXDataContainer() {
      return this.iPSControlXDataContainer;
   }

   protected IPSControlXDataContainer calcPSControlXDataContainer() {
      IPSControlContainer iPSControlContainer;
      for (iPSControlContainer = this.getPSControlContainer();
         !(iPSControlContainer instanceof IPSControlXDataContainer);
         iPSControlContainer = ((IPSControl)iPSControlContainer).getPSControlContainer()
      ) {
         if (!(iPSControlContainer instanceof IPSControl)) {
            return null;
         }
      }

      return (IPSControlXDataContainer)iPSControlContainer;
   }

   @Override
   public IPSControlType getPSControlType() {
      return this.iPSControlType;
   }

   @Override
   public void setPSControlType(IPSControlType iPSControlType) {
      this.iPSControlType = iPSControlType;
   }

   @Override
   public IView getView() {
      return this.getPSAppView();
   }

   @PSModelRTMeta(description = "实体对象")
   @Override
   public IPSDataEntity getPSDataEntity() {
      if (this.iPSDataEntity == null && this.getPSAppView() instanceof IPSAppDEView) {
         this.iPSDataEntity = ((IPSAppDEView)this.getPSAppView()).getPSDataEntity();
      }

      return this.iPSDataEntity;
   }

   protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
      this.iPSDataEntity = iPSDataEntity;
   }

   @Override
   public IDataEntity getDataEntity() {
      return this.getPSDataEntity();
   }

   @Override
   public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
   }

   @Override
   public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.onGetCodeName();
   }

   protected String onGetCodeName() {
      if (this.getPSAppView().getPSPFStyle().getPFEngineVer() < 20 || !(this.getPSAppView() instanceof IPSAppDEView)) {
         return this.getPSApplication().getViewCodeName(null, this.getName(), null);
      } else {
         return this.isEnableUIModelEx()
            ? this.getPSApplication().getViewCodeName(((IPSAppDEView)this.getPSAppView()).getPSDEViewCodeName(), this.getName(), null)
            : StringHelper.format("%1$s%2$s", ((IPSAppDEView)this.getPSAppView()).getPSDEViewCodeName(), this.getName());
      }
   }

   @Override
   public boolean isDesignMode() {
      if (this.bDesignMode) {
         return true;
      }

      Boolean bRet = PSAppViewImpl.getCurrentDesignMode();
      return bRet == null ? false : bRet;
   }

   protected void setDesignMode(boolean bDesignMode) {
      this.bDesignMode = bDesignMode;
   }

   @Override
   public boolean hasCtrlModel() {
      return true;
   }

   @Override
   public String getPSSysModelInstId() {
      return this.iPSControlContainer.getPSSysModelInstId();
   }

   @Override
   public final String getUniqueId() {
      return this.strUniqueId;
   }

   @Override
   public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
   }

   @PSModelRTMeta(description = "控件宽度", ignoredumpvalues = "0.0", outputdoc = "(%1$s.getWidth() gt 0)")
   @Override
   public double getWidth() {
      return this.fWidth;
   }

   @PSModelRTMeta(description = "控件高度", ignoredumpvalues = "0.0", outputdoc = "(%1$s.getHeight() gt 0)")
   @Override
   public double getHeight() {
      return this.fHeight;
   }

   @PSModelRTMeta(description = "控件次序", dump = false)
   @Override
   public int getOrderValue() {
      return this.nOrderValue;
   }

   public IPSSystem getPSSystem() {
      return this.getPSAppView() == null ? null : this.getPSAppView().getPSSystem();
   }

   @PSModelRTMeta(description = "前端扩展插件")
   @Override
   public IPSSysPFPlugin getPSSysPFPlugin() {
      return this.iPSSysPFPlugin;
   }

   @PSModelRTMeta(description = "部件消息", child = true)
   @Override
   public IPSCtrlMsg getPSCtrlMsg() {
      return this.iPSCtrlMsg;
   }

   @PSModelRTMeta(description = "界面样式", dumpref = true)
   @Override
   public IPSSysCss getPSSysCss() {
      return this.iPSSysCss;
   }

   @PSModelRTMeta(description = "默认部件", dump = false)
   @Override
   public boolean isDefaultCtrl() {
      return this.bDefaultCtrl;
   }

   @Override
   public boolean isDynamicCtrl() {
      return this.bDynamicCtrl == null ? false : this.bDynamicCtrl;
   }

   protected IPSSystemSetting getPSSystemSetting() {
      return (IPSSystemSetting)this.getPSSystem();
   }

   @Override
   public String getModelId() {
      return this.getPSAppView() != null ? StringHelper.format("%1$s#%2$s", this.getPSAppView().getId(), this.getName()) : super.getModelId();
   }

   protected IPSSystemUtil getPSSystemUtil() {
      return (IPSSystemUtil)this.getPSSystem();
   }

   @Override
   public String getFullModelName() {
      return this.getPSAppView() != null
         ? StringHelper.format("%1$s|%2$s", this.getPSAppView().getFullModelName(), this.getModelName())
         : super.getFullModelName();
   }

   @Override
   public boolean isEnableCol12ToCol24() {
      if (this.isDesignMode()) {
         if (this.getPSAppView() != null && this.getPSAppView().getPSApplication().getPFType().indexOf("PREVIEW_") == 0) {
            return true;
         }

         if (StringHelper.compare(this.getPreviewPSPF().getFormLayoutMode(), "TABLE_24COL", true) != 0) {
            return false;
         }
      }

      return this.getPSAppView() != null ? this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableCol12ToCol24() : false;
   }

   @PSModelRTMeta(description = "部件逻辑名称", hideempty2 = true)
   @Override
   public String getLogicName() {
      return this.strLogicName;
   }

   protected void setLogicName(String strLogicName) {
      this.strLogicName = strLogicName;
   }

   @Override
   public String getControlSubType() {
      return "";
   }

   @PSModelRTMeta(description = "部件样式")
   @Override
   public final String getControlStyle() {
      String strControlSubType = this.getControlSubType();
      if (!StringHelper.isNullOrEmpty(strControlSubType)) {
         return strControlSubType;
      }

      if (this.getRender() == null && this.getPSSysPFPlugin() != null) {
         strControlSubType = this.getPSSysPFPlugin().getPluginCode();
         if (!StringHelper.isNullOrEmpty(strControlSubType)) {
            return strControlSubType;
         }
      }

      return this.getPSAppView() == null ? "" : this.getPSAppView().getPSApplication().getPSApplicationUI().getDefaultControlStyle();
   }

   @Override
   public IPSPF getPreviewPSPF() {
      return this.previewPSPF;
   }

   protected void setPreviewPSPF(IPSPF previewPSPF) {
      this.previewPSPF = previewPSPF;
   }

   @Override
   public void registerPSControlLogic(IPSControlLogic iPSControlLogic) throws Exception {
      if (this.psControlLogicList == null) {
         this.psControlLogicList = new ArrayList<>();
      }

      iPSControlLogic = new PSControlLogicProxy(this, iPSControlLogic);
      this.psControlLogicList.add(iPSControlLogic);
      String strEventNames = iPSControlLogic.getEventNames();
      if (!StringHelper.isNullOrEmpty(strEventNames)) {
         strEventNames = strEventNames.toUpperCase();
         String[] events = StringHelper.splitEx(strEventNames);
         if (events != null) {
            String[] var7 = events;
            int var6 = events.length;

            for (int var5 = 0; var5 < var6; var5++) {
               String strEvent = var7[var5];
               strEvent = strEvent.trim();
               if (!StringHelper.isNullOrEmpty(strEvent)) {
                  if (this.hookEventMap == null) {
                     this.hookEventMap = new LinkedHashMap<>();
                  }

                  ArrayList<IPSControlLogic> list = this.hookEventMap.get(strEvent);
                  if (list == null) {
                     list = new ArrayList<>();
                     this.hookEventMap.put(strEvent, list);
                  }

                  list.add(iPSControlLogic);
               }
            }
         }
      }
   }

   @PSModelRTMeta(description = "部件逻辑集合", hideempty2 = true, child = true, group = "部件逻辑", order = 220)
   @Override
   public Iterator<? extends IPSControlLogic> getPSControlLogics() {
      return this.onGetPSControlLogics();
   }

   protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
      if (!this.isEnableUIModelEx()) {
         return this.getAllPSControlLogics();
      }

      Iterator<? extends IPSControlLogic> psControlLogics = this.getAllPSControlLogics();
      if (psControlLogics == null) {
         return null;
      }

      List<IPSControlLogic> psControlLogicList = null;

      while (psControlLogics.hasNext()) {
         IPSControlLogic iPSControlLogic = psControlLogics.next();
         if (!"CTRLEVENT".equals(iPSControlLogic.getTriggerType())
            && !"TIMER".equals(iPSControlLogic.getTriggerType())
            && !"CUSTOM".equals(iPSControlLogic.getTriggerType())) {
            if ((
                  "ITEMBLANK".equals(iPSControlLogic.getTriggerType())
                     || "ITEMENABLE".equals(iPSControlLogic.getTriggerType())
                     || "ITEMVISIBLE".equals(iPSControlLogic.getTriggerType())
                     || "ITEMDYNACLASS".equals(iPSControlLogic.getTriggerType())
               )
               && StringHelper.isNullOrEmpty(iPSControlLogic.getItemName())) {
               if (psControlLogicList == null) {
                  psControlLogicList = new ArrayList<>();
               }

               psControlLogicList.add(iPSControlLogic);
            }
         } else {
            if (psControlLogicList == null) {
               psControlLogicList = new ArrayList<>();
            }

            psControlLogicList.add(iPSControlLogic);
         }
      }

      return psControlLogicList != null && psControlLogicList.size() != 0 ? psControlLogicList.iterator() : null;
   }

   @PSModelRTMeta(description = "部件全部逻辑集合", hideempty2 = true)
   @Override
   public Iterator<? extends IPSControlLogic> getAllPSControlLogics() {
      return this.onGetAllPSControlLogics();
   }

   protected Iterator<? extends IPSControlLogic> onGetAllPSControlLogics() {
      return this.psControlLogicList != null && this.psControlLogicList.size() != 0 ? this.psControlLogicList.iterator() : null;
   }

   @PSModelRTMeta(description = "监控事件名称集合", hideempty2 = true, child = true, rtname = "hookEventNames", ignorert = 3)
   @Override
   public Iterator<String> getHookEventNames() {
      return this.hookEventMap != null && this.hookEventMap.size() != 0 ? this.hookEventMap.keySet().iterator() : null;
   }

   @Override
   public Iterator<? extends IPSControlLogic> getPSControlLogics(String strEventName) {
      if (this.hookEventMap == null) {
         return null;
      }

      ArrayList<IPSControlLogic> list = this.hookEventMap.get(strEventName.toUpperCase());
      return list != null && list.size() != 0 ? list.iterator() : null;
   }

   @PSModelRTMeta(description = "部件注入属性集合", hideempty2 = true, child = true, group = "部件逻辑", order = 222)
   @Override
   public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
      return this.onGetPSControlAttributes();
   }

   protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
      Iterator<? extends IPSControlAttribute> psControlAttributes = this.getAllPSControlAttributes();
      if (psControlAttributes == null) {
         return null;
      }

      List<IPSControlAttribute> psControlAttributeList = null;

      while (psControlAttributes.hasNext()) {
         IPSControlAttribute iPSControlAttribute = psControlAttributes.next();
         if (StringHelper.isNullOrEmpty(iPSControlAttribute.getItemName())) {
            if (psControlAttributeList == null) {
               psControlAttributeList = new ArrayList<>();
            }

            psControlAttributeList.add(iPSControlAttribute);
         }
      }

      return psControlAttributeList != null && psControlAttributeList.size() != 0 ? psControlAttributeList.iterator() : null;
   }

   @PSModelRTMeta(description = "部件全部属性注入集合", hideempty2 = true)
   @Override
   public Iterator<? extends IPSControlAttribute> getAllPSControlAttributes() {
      return this.onGetAllPSControlAttributes();
   }

   protected Iterator<? extends IPSControlAttribute> onGetAllPSControlAttributes() {
      return this.psControlAttributeList != null && this.psControlAttributeList.size() != 0 ? this.psControlAttributeList.iterator() : null;
   }

   public void registerPSControlAttribute(IPSControlAttribute iPSControlAttribute) throws Exception {
      if (this.psControlAttributeList == null) {
         this.psControlAttributeList = new ArrayList<>();
      }

      this.psControlAttributeList.add(iPSControlAttribute);
   }

   @PSModelRTMeta(description = "部件绘制器集合", hideempty2 = true, child = true, group = "部件逻辑", order = 223)
   @Override
   public Iterator<? extends IPSControlRender> getPSControlRenders() {
      return this.onGetPSControlRenders();
   }

   protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
      Iterator<? extends IPSControlRender> psControlRenders = this.getAllPSControlRenders();
      if (psControlRenders == null) {
         return null;
      }

      List<IPSControlRender> psControlRenderList = null;

      while (psControlRenders.hasNext()) {
         IPSControlRender iPSControlRender = psControlRenders.next();
         if (StringHelper.isNullOrEmpty(iPSControlRender.getItemName())) {
            if (psControlRenderList == null) {
               psControlRenderList = new ArrayList<>();
            }

            psControlRenderList.add(iPSControlRender);
         }
      }

      return psControlRenderList != null && psControlRenderList.size() != 0 ? psControlRenderList.iterator() : null;
   }

   @PSModelRTMeta(description = "部件全部绘制器集合", hideempty2 = true)
   @Override
   public Iterator<? extends IPSControlRender> getAllPSControlRenders() {
      return this.onGetAllPSControlRenders();
   }

   protected Iterator<? extends IPSControlRender> onGetAllPSControlRenders() {
      return this.psControlRenderList != null && this.psControlRenderList.size() != 0 ? this.psControlRenderList.iterator() : null;
   }

   public void registerPSControlRender(IPSControlRender iPSControlRender) throws Exception {
      if (this.psControlRenderList == null) {
         this.psControlRenderList = new ArrayList<>();
      }

      this.psControlRenderList.add(iPSControlRender);
   }

   @Override
   public Iterator<? extends IPSControlAttribute> getPSControlAttributesByItemName(String strItemName) {
      Iterator<? extends IPSControlAttribute> psControlAttributes = this.getAllPSControlAttributes();
      if (psControlAttributes == null) {
         return null;
      }

      List<IPSControlAttribute> psControlAttributeList = null;

      while (psControlAttributes.hasNext()) {
         IPSControlAttribute iPSControlAttribute = psControlAttributes.next();
         if (!StringHelper.isNullOrEmpty(iPSControlAttribute.getItemName()) && StringHelper.compare(iPSControlAttribute.getItemName(), strItemName, true) == 0) {
            if (psControlAttributeList == null) {
               psControlAttributeList = new ArrayList<>();
            }

            psControlAttributeList.add(iPSControlAttribute);
         }
      }

      return psControlAttributeList != null && psControlAttributeList.size() != 0 ? psControlAttributeList.iterator() : null;
   }

   @Override
   public Iterator<? extends IPSControlRender> getPSControlRendersByItemName(String strItemName) {
      Iterator<? extends IPSControlRender> psControlRenders = this.getAllPSControlRenders();
      if (psControlRenders == null) {
         return null;
      }

      List<IPSControlRender> psControlRenderList = null;

      while (psControlRenders.hasNext()) {
         IPSControlRender iPSControlRender = psControlRenders.next();
         if (!StringHelper.isNullOrEmpty(iPSControlRender.getItemName()) && StringHelper.compare(iPSControlRender.getItemName(), strItemName, true) == 0) {
            if (psControlRenderList == null) {
               psControlRenderList = new ArrayList<>();
            }

            psControlRenderList.add(iPSControlRender);
         }
      }

      return psControlRenderList != null && psControlRenderList.size() != 0 ? psControlRenderList.iterator() : null;
   }

   @Override
   public Iterator<? extends IPSControlLogic> getPSControlLogicsByItemName(String strItemName) {
      Iterator<? extends IPSControlLogic> psControlLogics = this.getAllPSControlLogics();
      if (psControlLogics == null) {
         return null;
      }

      List<IPSControlLogic> psControlLogicList = null;

      while (psControlLogics.hasNext()) {
         IPSControlLogic iPSControlLogic = psControlLogics.next();
         if (!StringHelper.isNullOrEmpty(iPSControlLogic.getItemName())
            && (
               "ITEMBLANK".equals(iPSControlLogic.getTriggerType())
                  || "ITEMENABLE".equals(iPSControlLogic.getTriggerType())
                  || "ITEMVISIBLE".equals(iPSControlLogic.getTriggerType())
                  || "ITEMDYNACLASS".equals(iPSControlLogic.getTriggerType())
            )
            && StringHelper.compare(iPSControlLogic.getItemName(), strItemName, true) == 0) {
            if (psControlLogicList == null) {
               psControlLogicList = new ArrayList<>();
            }

            psControlLogicList.add(iPSControlLogic);
         }
      }

      return psControlLogicList != null && psControlLogicList.size() != 0 ? psControlLogicList.iterator() : null;
   }

   @Override
   public boolean isRegisterToPSAppDataEntity() {
      return this.getPSAppView() == null ? false : this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
   }

   @Override
   public boolean isPrepareDefaultPSAppViewLogics() {
      return this.getPSAppView() == null ? false : this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
   }

   @Override
   public boolean isPrepareTemplV2logic() {
      return this.getPSAppView() == null ? false : this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
   }

   @Override
   public Object getCtrlParam(String strParamName) {
      return this.getPSControlParam() == null ? null : this.getPSControlParam().getCtrlParam(strParamName);
   }

   @Override
   public boolean containsCtrlParam(String strParamName) {
      return this.getPSControlParam() == null ? false : this.getPSControlParam().containsCtrlParam(strParamName);
   }

   @Override
   public String getCtrlParam(String strParamName, String strDefault) {
      return this.getPSControlParam() == null ? strDefault : this.getPSControlParam().getCtrlParam(strParamName, strDefault);
   }

   @Override
   public boolean getCtrlParam(String strParamName, boolean bDefault) {
      return this.getPSControlParam() == null ? bDefault : this.getPSControlParam().getCtrlParam(strParamName, bDefault);
   }

   @Override
   public int getCtrlParam(String strParamName, int nDefault) {
      return this.getPSControlParam() == null ? nDefault : this.getPSControlParam().getCtrlParam(strParamName, nDefault);
   }

   @PSModelRTMeta(description = "动态参数集合")
   @Override
   public Iterator<String> getCtrlParamNames() {
      return this.getPSControlParam() == null ? null : this.getPSControlParam().getCtrlParamNames();
   }

   @PSModelRTMeta(description = "用户标记")
   @Override
   public String getUserTag() {
      return this.getPSControlParam() == null ? null : this.getPSControlParam().getUserTag();
   }

   @PSModelRTMeta(description = "用户标记2")
   @Override
   public String getUserTag2() {
      return this.getPSControlParam() == null ? null : this.getPSControlParam().getUserTag2();
   }

   @Override
   public String getPSDynaModelId() {
      return this.getPSControlParam() == null ? null : this.getPSControlParam().getPSDynaModelId();
   }

   @PSModelRTMeta(description = "绘制插件")
   @Override
   public IPSPFXCodeObject getRender() {
      return this.iPSPFXCodeObject;
   }

   @Override
   public String getPreviewHtml() {
      return this.isDesignMode() && this.getPSSysPFPlugin() != null ? this.getPSSysPFPlugin().getPreviewHtml() : null;
   }

   @PSModelRTMeta(description = "应用实体", dumpref = true)
   @Override
   public IPSAppDataEntity getPSAppDataEntity() {
      return this.iPSAppDataEntity;
   }

   protected void setPSAppDataEntity(IPSAppDataEntity iPSAppDataEntity) {
      this.iPSAppDataEntity = iPSAppDataEntity;
   }

   @Override
   public Iterator<? extends IPSControlAction> getPSControlActions() {
      return null;
   }

   @Override
   public IPSControlAction getUserPSControlAction() {
      return null;
   }

   @Override
   public IPSControlAction getUser2PSControlAction() {
      return null;
   }

   public IPSApplication getPSApplication() {
      return this.getPSAppView() != null ? this.getPSAppView().getPSApplication() : null;
   }

   @PSModelRTMeta(description = "部署数据标识", dump = false)
   @Override
   public String getDeployId() {
      return this.getPSAppView() != null ? KeyValueHelper.genUniqueId(this.getPSAppView().getDeployId(), this.getName()) : super.getDeployId();
   }

   @Override
   protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
      return this.getPSSystem() != null ? this.getPSSystem().getPSSysDynaModel(strPSSysDynaModelId) : super.internalGetPSSysDynaModel(strPSSysDynaModelId);
   }

   @PSModelRTMeta(name = "[H]前端模板发布帮助", hideempty = true)
   @Override
   public IPSPFPubHelp getPSPFPubHelp() {
      try {
         if (PSTemplHelper.isBusy()) {
            return null;
         }

         if (this.iPSPFPubHelp != null) {
            return this.iPSPFPubHelp;
         }

         Map<String, IPSCodePublisherParam> publisherParamMap = new LinkedHashMap<>();
         this.iPSPFPubHelp = PSPFCtrlPubHelpImpl.createPSPFPubHelp(this, publisherParamMap);
         return this.iPSPFPubHelp;
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @Override
   protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
      super.onFillModelNode(objectNode, strModelType);
      if (!StringHelper.isNullOrEmpty(this.getDynaModelFilePath())) {
         objectNode.remove("name");
      }

      if (StringHelper.compare(strModelType, "SINGLE", true) != 0) {
         if (!objectNode.has("name")) {
            putJsonProperty(objectNode, "name", this.getName().toLowerCase());
         }
      } else {
         objectNode.remove("getPSControlParam");
         objectNode.remove("getPSControlHandler");
      }

      if (!objectNode.has("modelid") && !StringHelper.isNullOrEmpty(this.getId()) && !this.getId().equals("SRFCURRENTVIEW")) {
         putJsonProperty(objectNode, "modelid", this.getId());
         putJsonProperty(objectNode, "modeltype", this.getModelType());
      }
   }

   @Override
   public ObjectNode toModelRef(String strType) {
      if (StringHelper.compare("LINK", strType, true) == 0) {
         ObjectNode objectNode = JsonNodeHelper.createObjectNode();
         objectNode.put("name", this.getName().toLowerCase());
         return objectNode;
      } else if (StringHelper.compare("IGNOREDESIGN", strType, true) == 0 && this.isDesignMode()) {
         return this.toModel(null);
      } else {
         return this.isExportModelAlways() && StringHelper.compare("MUSTREF", strType, true) != 0 ? this.toModel(strType) : super.toModelRef(strType);
      }
   }

   @Override
   protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
      super.onFillModelRefNode(objectNode, strModelRefType);
      if (!"INDIVIDUAL".equals(strModelRefType)) {
         if (!objectNode.has("name")) {
            putJsonProperty(objectNode, "name", this.getName().toLowerCase());
         }

         if (this.getPSControlParam() != null) {
            ObjectNode objNode = this.getPSControlParam().getModel();
            putJsonProperty(objectNode, "getPSControlParam", objNode);
         }

         if (this.getPSControlHandler() != null) {
            ObjectNode objNode = this.getPSControlHandler().getModel();
            putJsonProperty(objectNode, "getPSControlHandler", objNode);
         }
      }

      objectNode.put("controlType", this.getControlType());
   }

   @PSModelRTMeta(description = "动态模型文件路径", hideempty = true)
   @Override
   public String getDynaModelFilePath() {
      if (this.isExportModelAlways()) {
         return null;
      } else if (!this.isEnableDynaModel()) {
         return null;
      } else {
         return StringHelper.isNullOrEmpty(this.getDynaModelTag()) ? null : String.format("%1$s/%2$s.json", this.getDynaModelFolder(), this.getDynaModelTag());
      }
   }

   @Override
   protected boolean isExportModelAlways() {
      return false;
   }

   protected Boolean getDynamicCtrl() {
      return this.bDynamicCtrl;
   }

   @PSModelRTMeta(description = "动态实例模式", dump = false, codelist = "DynaInstMode3")
   @Override
   public int getDynaInstMode() {
      return this.getPSApplication() != null && this.getPSApplication().getDynaInstMode() == 0 ? 0 : this.onGetDynaInstMode();
   }

   @Override
   protected int onGetDynaInstMode() {
      if (this.getDynamicCtrl() != null) {
         if (this.isDynamicCtrl()) {
            return this.getPSAppDataEntity() != null && this.getPSApplication().getDynaInstMode() == 0 ? 0 : 1;
         } else {
            return 0;
         }
      } else {
         return this.getPSAppDataEntity() != null ? this.getPSAppDataEntity().getDynaInstMode() : 0;
      }
   }

   @Override
   protected boolean onGetEnableDynaModel() {
      return this.getDynamicCtrl() != null ? this.isDynamicCtrl() : true;
   }

   @Override
   protected String onGetDynaModelFolder() {
      if (this.getPSAppDataEntity() != null) {
         String strDynaModelFolder = this.getPSAppDataEntity().getDynaModelFolder();
         return StringHelper.isNullOrEmpty(strDynaModelFolder)
            ? null
            : String.format("%1$s/PS%2$s", strDynaModelFolder, Inflector.getInstance().pluralize(this.getDumpModelType()).toUpperCase());
      } else if (this.getPSAppView() != null) {
         String strDynaModelFolder = this.getPSAppView().getDynaModelFolder();
         return StringHelper.isNullOrEmpty(strDynaModelFolder)
            ? null
            : String.format("%1$s/PS%2$s", strDynaModelFolder, Inflector.getInstance().pluralize(this.getDumpModelType()).toUpperCase());
      } else if (this.getPSApplication() != null) {
         String strDynaModelFolder = this.getPSApplication().getDynaModelFolder();
         return StringHelper.isNullOrEmpty(strDynaModelFolder)
            ? null
            : String.format("%1$s/PS%2$s", strDynaModelFolder, Inflector.getInstance().pluralize(this.getDumpModelType()).toUpperCase());
      } else {
         return super.onGetDynaModelFolder();
      }
   }

   @Override
   public String getDumpModelType() {
      return this.getControlType();
   }

   protected boolean isNeedFillPSACHandlerData() {
      return false;
   }

   protected void fillPSACHandlerData(PSACHandler psACHandler) throws Exception {
   }

   @Override
   public String getModelScope() {
      return null;
   }

   @PSModelRTMeta(description = "部件类型", codelist = "CtrlType", group = "基本", order = 125)
   @Override
   public String getControlType() {
      return this.onGetControlType();
   }

   protected String onGetControlType() {
      return null;
   }

   @PSModelRTMeta(description = "引用部件", dump = false, hideempty = true)
   @Override
   public IPSControl getRefPSControl() throws Exception {
      if (this.getPSControlParam() != null && !StringHelper.isNullOrEmpty(this.getPSControlParam().getRefCtrlName())) {
         if (StringHelper.compare(this.getPSControlParam().getRefCtrlName(), this.getName(), true) == 0) {
            throw new Exception(String.format("引用部件不能为自己"));
         } else {
            return this.getPSControlContainer().getPSControl(this.getPSControlParam().getRefCtrlName());
         }
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "引用部件2", dump = false, hideempty = true)
   @Override
   public IPSControl getRefPSControl2() throws Exception {
      if (this.getPSControlParam() != null && !StringHelper.isNullOrEmpty(this.getPSControlParam().getRefCtrl2Name())) {
         if (StringHelper.compare(this.getPSControlParam().getRefCtrl2Name(), this.getName(), true) == 0) {
            throw new Exception(String.format("引用部件不能为自己"));
         } else {
            return this.getPSControlContainer().getPSControl(this.getPSControlParam().getRefCtrl2Name());
         }
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "部件安装界面引擎", dump = false, hideempty2 = true)
   @Override
   public String getInstallUIEngine() {
      return this.getPSControlParam() == null ? null : this.getPSControlParam().getInstallUIEngine();
   }

   @PSModelRTMeta(description = "部件安装界面引擎", dump = false, hideempty2 = true)
   @Override
   public String getInstallUIEngine2() {
      return this.getPSControlParam() == null ? null : this.getPSControlParam().getInstallUIEngine2();
   }

   @Override
   protected String onGetMOSFolder() {
      String strRootPath = "";
      if (this.getPSDataEntity() != null) {
         strRootPath = this.getPSDataEntity().getMOSFilePath();
         if (StringHelper.isNullOrEmpty(strRootPath)) {
            return null;
         }
      }

      return !StringHelper.isNullOrEmpty(strRootPath)
         ? strRootPath + "/" + Inflector.getInstance().pluralize(this.getModelType()).toLowerCase()
         : Inflector.getInstance().pluralize(this.getModelType()).toLowerCase();
   }

   @Override
   protected String onGetRTMOSFileName() {
      return this.getName();
   }

   @Override
   protected String onGetMOSFileName() {
      return this.getCodeName();
   }

   @Override
   protected String onGetRTMOSFolder() {
      String strRootPath = "";
      if (this.getPSAppView() != null) {
         strRootPath = this.getPSAppView().getRTMOSFilePath();
      } else if (this.getPSAppDataEntity() != null) {
         strRootPath = this.getPSAppDataEntity().getRTMOSFilePath();
      } else if (this.getPSApplication() != null) {
         strRootPath = this.getPSApplication().getRTMOSFilePath();
      }

      return !StringHelper.isNullOrEmpty(strRootPath)
         ? strRootPath + "/" + Inflector.getInstance().pluralize(this.getRTMOSModelType()).toLowerCase()
         : super.onGetRTMOSFolder();
   }

   @Override
   protected IPSModelObject onGetScopeModel() {
      return this.getPSAppView() != null ? this.getPSAppView() : this.getPSApplication();
   }

   @Override
   public boolean isIndividualCtrl() {
      return !this.isExportModelAlways();
   }

   @Override
   public boolean isEnableUIModelEx() {
      return this.getPSApplication() != null ? this.getPSApplication().getPSApplicationUI().isEnableUIModelEx() : false;
   }

   @Override
   public String getRTMOSModelType() {
      return this.getPSAppView() != null ? "PSAPPVIEWCTRL" : this.getModelType();
   }

   @Override
   public void registerPSControlLogic(IPSAppViewLogic iPSAppViewLogic) throws Exception {
      if (StringHelper.isNullOrEmpty(iPSAppViewLogic.getPSViewCtrlName())
         || StringHelper.compare(iPSAppViewLogic.getPSViewCtrlName(), this.getName(), true) == 0) {
         if ("ITEMBLANK".equals(iPSAppViewLogic.getLogicTrigger())
            || "ITEMENABLE".equals(iPSAppViewLogic.getLogicTrigger())
            || "ITEMVISIBLE".equals(iPSAppViewLogic.getLogicTrigger())
            || "ITEMDYNACLASS".equals(iPSAppViewLogic.getLogicTrigger())) {
            PSControlLogicProxy4 psControlLogicProxy4 = new PSControlLogicProxy4(this, iPSAppViewLogic);
            this.registerPSControlLogic(psControlLogicProxy4);
            return;
         }

         if ("RENDER".equals(iPSAppViewLogic.getLogicTrigger())) {
            PSControlRenderProxy4 psControlRenderProxy = new PSControlRenderProxy4(this, iPSAppViewLogic);
            this.registerPSControlRender(psControlRenderProxy);
            return;
         }

         if ("ATTRIBUTE".equals(iPSAppViewLogic.getLogicTrigger())) {
            PSControlAttributeProxy4 psControlAttributeProxy = new PSControlAttributeProxy4(this, iPSAppViewLogic);
            this.registerPSControlAttribute(psControlAttributeProxy);
            return;
         }
      }

      log.warn(String.format("未支持的应用视图逻辑[%1$s][%2$s]", iPSAppViewLogic.getName(), iPSAppViewLogic.getLogicTrigger()));
   }

   @PSModelRTMeta(description = "动态系统模式", codelist = "ControlDynaSysMode", ignoredumpvalues = "0")
   @Override
   public int getDynaSysMode() {
      return this.getPSControlParam() != null && this.getPSControlParam().getDynaSysMode() != null ? this.getPSControlParam().getDynaSysMode() : 0;
   }

   @PSModelRTMeta(description = "部件优先级", codelist = "ControlPriority", ignoredumpvalues = "-1")
   @Override
   public int getPriority() {
      return this.onGetPriority() == null ? -1 : this.onGetPriority();
   }

   protected Integer onGetPriority() {
      return this.getPSControlParam() != null && this.getPSControlParam().getPriority() != null ? this.getPSControlParam().getPriority() : -1;
   }
}
