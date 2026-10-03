package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroupDetail;
import SA.SRFDA.PS.Data.PSViewMsgGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewMsgGroupImpl extends PSApplicationObjectImpl implements IPSAppViewMsgGroup {
   private static final Log log = LogFactory.getLog(PSAppViewMsgGroupImpl.class);
   private IPSViewMsgGroup iPSViewMsgGroup = null;
   private ArrayList<IPSAppViewMsgGroupDetail> psAppViewMsgGroupDetailList = new ArrayList<>();

   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSViewMsgGroup iPSViewMsgGroup) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.setPSApplication(iPSApplication);
         this.iPSViewMsgGroup = iPSViewMsgGroup;
         this.setId(iPSViewMsgGroup.getId());
         this.setName(iPSViewMsgGroup.getName());
         this.onInit();
      } catch (Exception ex) {
         this.throwCriticalInitException(ex);
         String strLogName = StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
         if (this.getPSSystemUtil() != null) {
            this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
         }

         this.throwInitException(ex);
      }
   }

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSViewMsgGroup psViewMsgGroup) throws Exception {
      throw new Exception("没有实现");
   }

   @Override
   protected void onInit() throws Exception {
      this.onPreparePSAppViewMsgGroupDetails();
      super.onInit();
   }

   protected void onPreparePSAppViewMsgGroupDetails() throws Exception {
      this.psAppViewMsgGroupDetailList.clear();
      Iterator<? extends IPSViewMsgGroupDetail> psViewMsgGroupDetails = this.getPSViewMsgGroup().getPSViewMsgGroupDetails();
      if (psViewMsgGroupDetails != null) {
         while (psViewMsgGroupDetails.hasNext()) {
            IPSViewMsgGroupDetail iPSViewMsgGroupDetail = psViewMsgGroupDetails.next();
            PSAppViewMsgGroupDetailImpl psAppViewMsgGroupDetailImpl = new PSAppViewMsgGroupDetailImpl();
            psAppViewMsgGroupDetailImpl.init(this.getDAGlobalHelper(), this, iPSViewMsgGroupDetail);
            this.psAppViewMsgGroupDetailList.add(psAppViewMsgGroupDetailImpl);
         }
      }
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.getPSViewMsgGroup().getCodeName();
   }

   @Override
   public Iterator<? extends IPSViewMsgGroupDetail> getPSViewMsgGroupDetails() {
      return this.getPSAppViewMsgGroupDetails();
   }

   @PSModelRTMeta(description = "消息组成员集合", child = true, group = "基本", order = 120)
   @Override
   public Iterator<? extends IPSAppViewMsgGroupDetail> getPSAppViewMsgGroupDetails() {
      return this.psAppViewMsgGroupDetailList != null && this.psAppViewMsgGroupDetailList.size() != 0 ? this.psAppViewMsgGroupDetailList.iterator() : null;
   }

   @PSModelRTMeta(description = "系统模块", hideempty = true)
   @Override
   public IPSSystemModule getPSSystemModule() {
      return this.getPSViewMsgGroup().getPSSystemModule();
   }

   @PSModelRTMeta(description = "头部消息区样式", hideempty = true, codelist = "ViewMsgShowMode", fields = "TOPMSGSTYLE")
   @Override
   public String getTopStyle() {
      return this.getPSViewMsgGroup().getTopStyle();
   }

   @PSModelRTMeta(description = "尾部消息区样式", hideempty = true, codelist = "ViewMsgShowMode", fields = "BOTTOMMSGSTYLE")
   @Override
   public String getBottomStyle() {
      return this.getPSViewMsgGroup().getBottomStyle();
   }

   @PSModelRTMeta(description = "内部消息区样式", hideempty = true, codelist = "ViewMsgShowMode", fields = "BODYMSGSTYLE")
   @Override
   public String getBodyStyle() {
      return this.getPSViewMsgGroup().getBodyStyle();
   }

   @Override
   public IPSViewMsgGroup getPSViewMsgGroup() {
      return this.iPSViewMsgGroup;
   }

   @Override
   protected IPSModelObject getProxyPSModelObject() {
      return this.getPSViewMsgGroup();
   }

   @PSModelRTMeta(description = "消息组唯一标记")
   @Override
   public String getUniqueTag() {
      return this.getPSViewMsgGroup().getUniqueTag();
   }

   @Override
   public String getModelId() {
      return this.getPSApplication() != null ? StringHelper.format("%1$s#%2$s", this.getPSApplication().getModelId(), super.getModelId()) : super.getModelId();
   }

   @Override
   public String getModelType() {
      return "PSAPPVIEWMSGGROUP";
   }

   @Override
   public String getDynaModelFilePath() {
      return null;
   }

   @Override
   public int getOrderValue() {
      return 99999;
   }
}
