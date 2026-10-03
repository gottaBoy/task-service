package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMSLogicLinkImpl extends PSObjectImpl implements IPSDEMSLogicLink {
   private static final Log log = LogFactory.getLog(PSDEMSLogicLinkImpl.class);
   protected IPSDEMSLogic iPSDEMSLogic;
   protected PSDELogicLink psDELogicLink;
   protected ArrayList<IPSDEMSLogicLinkCond> psDEMSLogicLinkCondList = new ArrayList<>();
   protected PSDEMSLogicLinkGroupCondImpl psDEMSLogicLinkGroupCondImpl = null;
   private boolean bDefaultLink = false;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMSLogic iPSDEMSLogic, PSDELogicLink psDELogicLink) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.iPSDEMSLogic = iPSDEMSLogic;
         this.psDELogicLink = psDELogicLink;
         this.setId(this.psDELogicLink.getPSDELOGICLINKID());
         this.setName(this.psDELogicLink.getPSDELOGICLINKNAME());
         this.setPSObjectData(this.psDELogicLink);
         if (!psDELogicLink.isDEFAULTLINKNull()) {
            this.bDefaultLink = psDELogicLink.getDEFAULTLINK();
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
      this.preparePSDEMSLogicLinkConds();
   }

   protected void preparePSDEMSLogicLinkConds() throws Exception {
      this.psDEMSLogicLinkGroupCondImpl = null;
      this.psDEMSLogicLinkCondList.clear();
      ArrayList<PSDELogicLinkCond> psDEMSLogicLinkCondList = this.psDELogicLink.getPSDELogicLinkConds(false);
      if (psDEMSLogicLinkCondList != null) {
         PSDELogicLinkCond groupPSDELogicLinkCond = new PSDELogicLinkCond();
         groupPSDELogicLinkCond.setPSDELLCONDID(this.getId());
         groupPSDELogicLinkCond.setLOGICTYPE("GROUP");
         groupPSDELogicLinkCond.setGROUPNOTFLAG(false);
         groupPSDELogicLinkCond.setGROUPOP("AND");

         for (PSDELogicLinkCond psDELogicLinkCond : psDEMSLogicLinkCondList) {
            groupPSDELogicLinkCond.getChildPSDELogicLinkConds(true).add(psDELogicLinkCond);
         }

         this.psDEMSLogicLinkGroupCondImpl = new PSDEMSLogicLinkGroupCondImpl();
         this.psDEMSLogicLinkGroupCondImpl.init(this.getDAGlobalHelper(), this, null, groupPSDELogicLinkCond);
         this.addToPSDELogicLinkCondList(this.psDEMSLogicLinkGroupCondImpl);
      }
   }

   protected void addToPSDELogicLinkCondList(IPSDEMSLogicLinkCond iPSDEMSLogicLinkCond) throws Exception {
      this.psDEMSLogicLinkCondList.add(iPSDEMSLogicLinkCond);
      if (iPSDEMSLogicLinkCond instanceof IPSDEMSLogicLinkGroupCond) {
         IPSDEMSLogicLinkGroupCond iPSDEMSLogicLinkGroupCond = (IPSDEMSLogicLinkGroupCond)iPSDEMSLogicLinkCond;
         Iterator<? extends IPSDEMSLogicLinkCond> psDELogicLinkConds = iPSDEMSLogicLinkGroupCond.getPSDEMSLogicLinkConds();
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
   public IPSDEMSLogicLinkGroupCond getPSDEMSLogicLinkGroupCond() {
      return this.psDEMSLogicLinkGroupCondImpl != null && this.psDEMSLogicLinkGroupCondImpl.getPSDEMSLogicLinkConds() != null
         ? this.psDEMSLogicLinkGroupCondImpl
         : null;
   }

   @PSModelRTMeta(description = "目标主状态节点对象", hideempty = true, dumpref = true, from = "IPSDEMSLogic", fields = "DSTPSDELOGICNODEID")
   @Override
   public IPSDEMSLogicNode getDstPSDEMSLogicNode() throws Exception {
      return this.iPSDEMSLogic.getPSDEMSLogicNode(this.psDELogicLink.getDSTPSDELOGICNODEID());
   }

   @PSModelRTMeta(description = "源主状态节点对象", hideempty = true, dumpref = true, from = "IPSDEMSLogic", ignorert = 3, fields = "SRCPSDELOGICNODEID")
   @Override
   public IPSDEMSLogicNode getSrcPSDEMSLogicNode() throws Exception {
      return this.iPSDEMSLogic.getPSDEMSLogicNode(this.psDELogicLink.getSRCPSDELOGICNODEID());
   }

   @Override
   public IPSDEMSLogic getPSDEMSLogic() {
      return this.iPSDEMSLogic;
   }

   @Override
   public String getPSSysModelInstId() {
      return this.getPSDEMSLogic().getPSSysModelInstId();
   }

   @Override
   public String getModelType() {
      return "PSDEMSLOGICLINK";
   }

   @Override
   public Class<?> getModelClass(String strModelType) {
      return super.getModelClass(strModelType);
   }

   @Override
   public String getModelId() {
      return StringHelper.format("%1$s#%2$s", this.getPSDEMSLogic().getModelId(), super.getModelId());
   }

   @Override
   public Iterator<IPSDEMSLogicLinkCond> getAllPSDEMSLogicLinkConds() {
      return this.psDEMSLogicLinkCondList.size() == 0 ? null : this.psDEMSLogicLinkCondList.iterator();
   }

   protected IPSSystemUtil getPSSystemUtil() {
      return (IPSSystemUtil)this.getPSDEMSLogic().getPSDataEntity().getPSSystem();
   }

   @PSModelRTMeta(description = "默认连接", ignoredumpvalues = "false", fields = "DEFAULTLINK")
   @Override
   public boolean isDefaultLink() {
      return false;
   }

   @Override
   public String getModelRefId() {
      return null;
   }
}
