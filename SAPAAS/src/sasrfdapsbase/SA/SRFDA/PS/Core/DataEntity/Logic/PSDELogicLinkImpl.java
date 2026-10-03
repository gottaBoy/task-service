package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicLinkImpl extends PSObjectImpl implements IPSDELogicLink, IPSAppDELogicLink {
   private static final Log log = LogFactory.getLog(PSDELogicLinkImpl.class);
   protected IPSDELogic iPSDELogic;
   protected PSDELogicLink psDELogicLink;
   protected ArrayList<IPSDELogicLinkCond> psDELogicLinkCondList = new ArrayList<>();
   protected PSDELogicLinkGroupCondImpl psDELogicLinkGroupCondImpl = null;
   protected IPSAppDELogic iPSAppDELogic;
   protected int nLinkMode = 0;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDELogic iPSDELogic, PSDELogicLink psDELogicLink) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.iPSDELogic = iPSDELogic;
         this.psDELogicLink = psDELogicLink;
         this.setId(this.psDELogicLink.getPSDELOGICLINKID());
         this.setName(this.psDELogicLink.getPSDELOGICLINKNAME());
         this.setPSObjectData(this.psDELogicLink);
         if (iPSDELogic instanceof IPSAppDELogic) {
            IPSAppDELogic iPSAppDELogic = (IPSAppDELogic)iPSDELogic;
            if (iPSAppDELogic.getPSAppDataEntity() != null) {
               this.iPSAppDELogic = iPSAppDELogic;
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
      this.preparePSDELogicLinkConds();
   }

   protected void preparePSDELogicLinkConds() throws Exception {
      this.psDELogicLinkGroupCondImpl = null;
      this.psDELogicLinkCondList.clear();
      ArrayList<PSDELogicLinkCond> psDELogicLinkCondList = this.psDELogicLink.getPSDELogicLinkConds(false);
      if (psDELogicLinkCondList != null) {
         PSDELogicLinkCond groupPSDELogicLinkCond = new PSDELogicLinkCond();
         groupPSDELogicLinkCond.setPSDELLCONDNAME(String.format("连接条件组"));
         groupPSDELogicLinkCond.setPSDELLCONDID(this.getId());
         groupPSDELogicLinkCond.setLOGICTYPE("GROUP");
         groupPSDELogicLinkCond.setGROUPNOTFLAG(false);
         groupPSDELogicLinkCond.setGROUPOP("AND");

         for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            groupPSDELogicLinkCond.getChildPSDELogicLinkConds(true).add(psDELogicLinkCond);
         }

         this.psDELogicLinkGroupCondImpl = new PSDELogicLinkGroupCondImpl();
         this.psDELogicLinkGroupCondImpl.init(this.getDAGlobalHelper(), this, null, groupPSDELogicLinkCond);
         this.addToPSDELogicLinkCondList(this.psDELogicLinkGroupCondImpl);
      }
   }

   protected void addToPSDELogicLinkCondList(IPSDELogicLinkCond iPSDELogicLinkCond) throws Exception {
      this.psDELogicLinkCondList.add(iPSDELogicLinkCond);
      if (iPSDELogicLinkCond instanceof IPSDELogicLinkGroupCond) {
         IPSDELogicLinkGroupCond iPSDELogicLinkGroupCond = (IPSDELogicLinkGroupCond)iPSDELogicLinkCond;
         Iterator<? extends IPSDELogicLinkCond> psDELogicLinkConds = iPSDELogicLinkGroupCond.getPSDELogicLinkConds();
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
   public IPSDELogicLinkGroupCond getPSDELogicLinkGroupCond() {
      return this.psDELogicLinkGroupCondImpl != null && this.psDELogicLinkGroupCondImpl.getPSDELogicLinkConds() != null
         ? this.psDELogicLinkGroupCondImpl
         : null;
   }

   @PSModelRTMeta(description = "目标逻辑节点对象", hideempty = true, dumpref = true, rtname = "getThen", from = "IPSDELogic", fields = "DSTPSDELOGICNODEID")
   @Override
   public IPSDELogicNode getDstPSDELogicNode() throws Exception {
      return this.iPSDELogic.getPSDELogicNode(this.psDELogicLink.getDSTPSDELOGICNODEID());
   }

   @PSModelRTMeta(description = "源逻辑节点对象", hideempty = true, dumpref = true, from = "IPSDELogic", ignorert = 3, fields = "SRCPSDELOGICNODEID")
   @Override
   public IPSDELogicNode getSrcPSDELogicNode() throws Exception {
      return this.iPSDELogic.getPSDELogicNode(this.psDELogicLink.getSRCPSDELOGICNODEID());
   }

   @Override
   public IPSDELogic getPSDELogic() {
      return this.iPSDELogic;
   }

   @Override
   public String getPSSysModelInstId() {
      return this.getPSDELogic().getPSSysModelInstId();
   }

   @Override
   public String getModelType() {
      return this.getPSAppDELogic() != null ? "PSAPPDELOGICLINK" : "PSDELOGICLINK";
   }

   @Override
   public Class<?> getModelClass(String strModelType) {
      return super.getModelClass(strModelType);
   }

   @Override
   public String getModelId() {
      return this.getPSAppDELogic() != null ? StringHelper.format("%1$s#%2$s", this.getPSAppDELogic().getModelId(), super.getModelId()) : super.getModelId();
   }

   @Override
   public Iterator<IPSDELogicLinkCond> getAllPSDELogicLinkConds() {
      return this.psDELogicLinkCondList.size() == 0 ? null : this.psDELogicLinkCondList.iterator();
   }

   protected IPSSystemUtil getPSSystemUtil() {
      return (IPSSystemUtil)this.getPSDELogic().getPSDataEntity().getPSSystem();
   }

   @Override
   public IPSAppDELogic getPSAppDELogic() {
      return this.iPSAppDELogic;
   }

   public int getLinkMode() {
      return this.nLinkMode;
   }

   @PSModelRTMeta(description = "默认连接", ignoredumpvalues = "false", fields = "DEFAULTLINK")
   @Override
   public boolean isDefaultLink() {
      return this.getLinkMode() == 1;
   }

   @PSModelRTMeta(description = "异常处理连接", ignoredumpvalues = "false", fields = "DEFAULTLINK")
   @Override
   public boolean isCatchLink() {
      return this.getLinkMode() == 9;
   }

   @PSModelRTMeta(description = "子调用连接", ignoredumpvalues = "false", fields = "DEFAULTLINK")
   @Override
   public boolean isSubCallLink() {
      return this.getLinkMode() == 10;
   }

   @Override
   public String getModelRefId() {
      return null;
   }

   @Override
   protected IPSModelObject onGetParentModel() {
      try {
         return this.getSrcPSDELogicNode();
      } catch (Exception e) {
         log.error(e.getMessage());
         return this.getPSDELogic();
      }
   }

   @Override
   protected IPSModelObject onGetScopeModel() {
      return this.getPSDELogic();
   }

   @Override
   protected String onGetRTMOSFilePath() {
      return null;
   }
}
