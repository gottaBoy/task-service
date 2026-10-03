package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicLink;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUILogicLinkImpl extends PSObjectImpl implements IPSDEUILogicLink, IPSAppDEUILogicLink {
   private static final Log log = LogFactory.getLog(PSDEUILogicLinkImpl.class);
   protected IPSDEUILogic iPSDEUILogic;
   protected PSDELogicLink psDELogicLink;
   protected ArrayList<IPSDEUILogicLinkCond> psDEUILogicLinkCondList = new ArrayList<>();
   protected PSDEUILogicLinkGroupCondImpl psDEUILogicLinkGroupCondImpl = null;
   protected IPSAppDEUILogic iPSAppDEUILogic;
   protected int nLinkMode = 0;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEUILogic iPSDEUILogic, PSDELogicLink psDELogicLink) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.iPSDEUILogic = iPSDEUILogic;
         this.psDELogicLink = psDELogicLink;
         this.setId(this.psDELogicLink.getPSDELOGICLINKID());
         this.setName(this.psDELogicLink.getPSDELOGICLINKNAME());
         this.setPSObjectData(this.psDELogicLink);
         if (iPSDEUILogic instanceof IPSAppDEUILogic) {
            IPSAppDEUILogic iPSAppDEUILogic = (IPSAppDEUILogic)iPSDEUILogic;
            if (iPSAppDEUILogic.getPSAppDataEntity() != null) {
               this.iPSAppDEUILogic = iPSAppDEUILogic;
            }
         }

         if (!psDELogicLink.isDEFAULTLINKNull()) {
            this.nLinkMode = psDELogicLink.GetParamIntValue("DEFAULTLINK", this.nLinkMode);
         }

         this.onInit();
      } catch (Exception ex) {
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
   protected void onInit() throws Exception {
      super.onInit();
      this.preparePSDEUILogicLinkConds();
   }

   protected void preparePSDEUILogicLinkConds() throws Exception {
      this.psDEUILogicLinkGroupCondImpl = null;
      this.psDEUILogicLinkCondList.clear();
      ArrayList<PSDELogicLinkCond> psDEUILogicLinkCondList = this.psDELogicLink.getPSDELogicLinkConds(false);
      if (psDEUILogicLinkCondList != null) {
         PSDELogicLinkCond groupPSDELogicLinkCond = new PSDELogicLinkCond();
         groupPSDELogicLinkCond.setPSDELLCONDID(this.getId());
         groupPSDELogicLinkCond.setLOGICTYPE("GROUP");
         groupPSDELogicLinkCond.setGROUPNOTFLAG(false);
         groupPSDELogicLinkCond.setGROUPOP("AND");

         for (PSDELogicLinkCond psDELogicLinkCond : psDEUILogicLinkCondList) {
            groupPSDELogicLinkCond.getChildPSDELogicLinkConds(true).add(psDELogicLinkCond);
         }

         this.psDEUILogicLinkGroupCondImpl = new PSDEUILogicLinkGroupCondImpl();
         this.psDEUILogicLinkGroupCondImpl.init(this.getDAGlobalHelper(), this, null, groupPSDELogicLinkCond);
         this.addToPSDELogicLinkCondList(this.psDEUILogicLinkGroupCondImpl);
      }
   }

   protected void addToPSDELogicLinkCondList(IPSDEUILogicLinkCond iPSDEUILogicLinkCond) throws Exception {
      this.psDEUILogicLinkCondList.add(iPSDEUILogicLinkCond);
      if (iPSDEUILogicLinkCond instanceof IPSDEUILogicLinkGroupCond) {
         IPSDEUILogicLinkGroupCond iPSDEUILogicLinkGroupCond = (IPSDEUILogicLinkGroupCond)iPSDEUILogicLinkCond;
         Iterator<? extends IPSDEUILogicLinkCond> psDELogicLinkConds = iPSDEUILogicLinkGroupCond.getPSDEUILogicLinkConds();
         if (psDELogicLinkConds == null) {
            return;
         }

         while (psDELogicLinkConds.hasNext()) {
            this.addToPSDELogicLinkCondList(psDELogicLinkConds.next());
         }
      }
   }

   @PSModelRTMeta(description = "连接条件对象", hideempty = true, child = true)
   @Override
   public IPSDEUILogicLinkGroupCond getPSDEUILogicLinkGroupCond() {
      return this.psDEUILogicLinkGroupCondImpl != null && this.psDEUILogicLinkGroupCondImpl.getPSDEUILogicLinkConds() != null
         ? this.psDEUILogicLinkGroupCondImpl
         : null;
   }

   @PSModelRTMeta(description = "目标逻辑节点对象", hideempty = true, dumpref = true, from = "IPSDEUILogic", fields = "DSTPSDELOGICNODEID")
   @Override
   public IPSDEUILogicNode getDstPSDEUILogicNode() throws Exception {
      return this.iPSDEUILogic.getPSDEUILogicNode(this.psDELogicLink.getDSTPSDELOGICNODEID());
   }

   @PSModelRTMeta(description = "源逻辑节点对象", hideempty = true, dumpref = true, from = "IPSDEUILogic", fields = "SRCPSDELOGICNODEID")
   @Override
   public IPSDEUILogicNode getSrcPSDEUILogicNode() throws Exception {
      return this.iPSDEUILogic.getPSDEUILogicNode(this.psDELogicLink.getSRCPSDELOGICNODEID());
   }

   @Override
   public IPSDEUILogic getPSDEUILogic() {
      return this.iPSDEUILogic;
   }

   @Override
   public String getPSSysModelInstId() {
      return this.getPSDEUILogic().getPSSysModelInstId();
   }

   @Override
   public String getModelType() {
      return this.getPSAppDEUILogic() != null ? "PSAPPDEUILOGICLINK" : "PSDEUILOGICLINK";
   }

   @Override
   public Class<?> getModelClass(String strModelType) {
      return super.getModelClass(strModelType);
   }

   @Override
   public String getModelId() {
      return this.getPSAppDEUILogic() != null
         ? StringHelper.format("%1$s#%2$s", this.getPSAppDEUILogic().getModelId(), super.getModelId())
         : super.getModelId();
   }

   @Override
   public Iterator<IPSDEUILogicLinkCond> getAllPSDEUILogicLinkConds() {
      return this.psDEUILogicLinkCondList.size() == 0 ? null : this.psDEUILogicLinkCondList.iterator();
   }

   protected IPSSystemUtil getPSSystemUtil() {
      return (IPSSystemUtil)this.getPSDEUILogic().getPSDataEntity().getPSSystem();
   }

   @Override
   public IPSAppDEUILogic getPSAppDEUILogic() {
      return this.iPSAppDEUILogic;
   }

   @PSModelRTMeta(description = "连接模式", codelist = "DEUILogicLinkMode", fields = "DEFAULTLINK")
   @Override
   public int getLinkMode() {
      return this.nLinkMode;
   }

   @PSModelRTMeta(description = "默认连接", ignoredumpvalues = "false", fields = "DEFAULTLINK", doc = "{@link #getLinkMode}等于默认连接(1)")
   @Override
   public boolean isDefaultLink() {
      return this.getLinkMode() == 1;
   }

   @PSModelRTMeta(description = "异步完成连接", ignoredumpvalues = "false", fields = "DEFAULTLINK", doc = "{@link #getLinkMode}等于异步结束(2)")
   @Override
   public boolean isFulfilledLink() {
      return this.getLinkMode() == 2;
   }

   @PSModelRTMeta(description = "异步拒绝连接", ignoredumpvalues = "false", fields = "DEFAULTLINK", doc = "{@link #getLinkMode}等于异步拒绝(3)")
   @Override
   public boolean isRejectedLink() {
      return this.getLinkMode() == 3;
   }

   @PSModelRTMeta(description = "异常处理连接", ignoredumpvalues = "false", fields = "DEFAULTLINK", doc = "{@link #getLinkMode}等于异常处理(9)")
   @Override
   public boolean isCatchLink() {
      return this.getLinkMode() == 9;
   }

   @PSModelRTMeta(description = "子调用连接", ignoredumpvalues = "false", fields = "DEFAULTLINK", doc = "{@link #getLinkMode}等于异常处理(10)")
   @Override
   public boolean isSubCallLink() {
      return this.getLinkMode() == 10;
   }

   @PSModelRTMeta(description = "连接条件", hideempty2 = true, fields = "LINKCOND")
   @Override
   public String getLinkCond() {
      return this.psDELogicLink.getLINKCOND();
   }

   @Override
   public String getModelRefId() {
      return null;
   }
}
