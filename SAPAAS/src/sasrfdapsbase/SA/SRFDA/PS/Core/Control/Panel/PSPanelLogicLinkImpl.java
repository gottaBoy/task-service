package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPanelLogicLinkImpl extends PSObjectImpl implements IPSPanelLogicLink {
   private static final Log log = LogFactory.getLog(PSPanelLogicLinkImpl.class);
   protected IPSPanelLogic iPSPanelLogic;
   protected PSPanelLogicLink psPanelLogicLink;
   protected ArrayList<IPSPanelLogicLinkCond> psPanelLogicLinkCondList = new ArrayList<>();
   protected PSPanelLogicLinkGroupCondImpl psPanelLogicLinkGroupCondImpl = null;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPanelLogic iPSPanelLogic, PSPanelLogicLink psPanelLogicLink) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.iPSPanelLogic = iPSPanelLogic;
         this.psPanelLogicLink = psPanelLogicLink;
         this.setId(this.psPanelLogicLink.getPSPANELLOGICLINKID());
         this.setName(this.psPanelLogicLink.getPSPANELLOGICLINKNAME());
         this.setPSObjectData(this.psPanelLogicLink);
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
   protected void onInit() throws Exception {
      super.onInit();
      this.preparePSPanelLogicLinkConds();
   }

   protected void preparePSPanelLogicLinkConds() throws Exception {
      this.psPanelLogicLinkGroupCondImpl = null;
      this.psPanelLogicLinkCondList.clear();
      ArrayList<PSPanelLogicLinkCond> psPanelLogicLinkCondList = this.psPanelLogicLink.getPSPanelLogicLinkConds(false);
      if (psPanelLogicLinkCondList != null) {
         PSPanelLogicLinkCond groupPSPanelLogicLinkCond = new PSPanelLogicLinkCond();
         groupPSPanelLogicLinkCond.setPSPANELLLCONDID(this.getId());
         groupPSPanelLogicLinkCond.setLOGICTYPE("GROUP");
         groupPSPanelLogicLinkCond.setGROUPNOTFLAG(false);
         groupPSPanelLogicLinkCond.setGROUPOP("AND");

         for (PSPanelLogicLinkCond psPanelLogicLinkCond : psPanelLogicLinkCondList) {
            groupPSPanelLogicLinkCond.getChildPSPanelLogicLinkConds(true).add(psPanelLogicLinkCond);
         }

         this.psPanelLogicLinkGroupCondImpl = new PSPanelLogicLinkGroupCondImpl();
         this.psPanelLogicLinkGroupCondImpl.init(this.getDAGlobalHelper(), this, null, groupPSPanelLogicLinkCond);
         this.addToPSPanelLogicLinkCondList(this.psPanelLogicLinkGroupCondImpl);
      }
   }

   protected void addToPSPanelLogicLinkCondList(IPSPanelLogicLinkCond iPSPanelLogicLinkCond) throws Exception {
      this.psPanelLogicLinkCondList.add(iPSPanelLogicLinkCond);
      if (iPSPanelLogicLinkCond instanceof IPSPanelLogicLinkGroupCond) {
         IPSPanelLogicLinkGroupCond iPSPanelLogicLinkGroupCond = (IPSPanelLogicLinkGroupCond)iPSPanelLogicLinkCond;
         Iterator<IPSPanelLogicLinkCond> psPanelLogicLinkConds = iPSPanelLogicLinkGroupCond.getPSPanelLogicLinkConds();
         if (psPanelLogicLinkConds == null) {
            return;
         }

         while (psPanelLogicLinkConds.hasNext()) {
            this.addToPSPanelLogicLinkCondList(psPanelLogicLinkConds.next());
         }
      }
   }

   @PSModelRTMeta(description = "连接条件对象", hideempty = true)
   @Override
   public IPSPanelLogicLinkGroupCond getPSPanelLogicLinkGroupCond() {
      return this.psPanelLogicLinkGroupCondImpl != null && this.psPanelLogicLinkGroupCondImpl.getPSPanelLogicLinkConds() != null
         ? this.psPanelLogicLinkGroupCondImpl
         : null;
   }

   @PSModelRTMeta(description = "目标逻辑节点对象", hideempty = true)
   @Override
   public IPSPanelLogicNode getDstPSPanelLogicNode() throws Exception {
      return this.iPSPanelLogic.getPSPanelLogicNode(this.psPanelLogicLink.getDSTPSPANELLOGICNODEID());
   }

   @PSModelRTMeta(description = "源逻辑节点对象", hideempty = true)
   @Override
   public IPSPanelLogicNode getSrcPSPanelLogicNode() throws Exception {
      return this.iPSPanelLogic.getPSPanelLogicNode(this.psPanelLogicLink.getSRCPSPANELLOGICNODEID());
   }

   @Override
   public String getLinkType() {
      return this.psPanelLogicLink.getLINKTYPE();
   }

   @Override
   public IPSPanelLogic getPSPanelLogic() {
      return this.iPSPanelLogic;
   }

   @Override
   public String getPSSysModelInstId() {
      return this.getPSPanelLogic().getPSSysModelInstId();
   }

   @Override
   public String getModelType() {
      return "PSPANELLOGICLINK";
   }

   @Override
   public Iterator<IPSPanelLogicLinkCond> getAllPSPanelLogicLinkConds() {
      return this.psPanelLogicLinkCondList.size() == 0 ? null : this.psPanelLogicLinkCondList.iterator();
   }

   protected IPSSystemUtil getPSSystemUtil() {
      return (IPSSystemUtil)this.getPSPanelLogic().getPSPanel().getPSAppView().getPSSystem();
   }
}
