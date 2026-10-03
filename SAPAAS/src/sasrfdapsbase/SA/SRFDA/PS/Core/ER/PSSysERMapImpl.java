package SA.SRFDA.PS.Core.ER;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysERMap;
import SA.SRFDA.PS.Data.PSSysERMapNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysERMapImpl extends PSSystemObjectImpl implements IPSSysERMap {
   private static final Log log = LogFactory.getLog(PSSysERMapImpl.class);
   protected PSSysERMap psSysERMap = null;
   private ArrayList<IPSSysERMapNode> psSysERMapNodeList = new ArrayList<>();
   private String strCodeName = "";
   private IPSSystemModule iPSSystemModule = null;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysERMap psSysERMap) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.setPSSystem(iPSSystem);
         this.psSysERMap = psSysERMap;
         this.setId(this.psSysERMap.getPSSYSERMAPID());
         this.setName(this.psSysERMap.getPSSYSERMAPNAME());
         this.setPSObjectData(this.psSysERMap);
         this.strCodeName = this.psSysERMap.getCODENAME();
         if (!StringHelper.IsNullOrEmpty(this.psSysERMap.getPSMODULEID())) {
            this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysERMap.getPSMODULEID());
         }

         this.onInit();
      } catch (Exception ex) {
         String strLogName = net.ibizsys.paas.util.StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = net.ibizsys.paas.util.StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(net.ibizsys.paas.util.StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
         if (this.getPSSystemUtil() != null) {
            this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
         }

         this.throwInitException(ex);
      }
   }

   @Override
   protected void onInit() throws Exception {
      this.onPreparePSSysERMapNodes();
      super.onInit();
   }

   protected void onPreparePSSysERMapNodes() throws Exception {
      this.psSysERMapNodeList.clear();
      Vector<PSSysERMapNode> psSysERMapNodeList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSSysERMapNodes(this.getId(), psSysERMapNodeList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询系统ER图节点发生错误, %1$s", callResult.getErrorInfo()));
      }

      int nX = 100;
      int nY = 100;
      int nIndex = 0;
      int nRowCount = 4;

      for (PSSysERMapNode psSysERMapNode : psSysERMapNodeList) {
         int nColumn = nIndex % nRowCount;
         int nRow = nIndex / nRowCount;
         psSysERMapNode.setLEFTPOS(nX + 450 * nColumn);
         psSysERMapNode.setTOPPOS(nY + 550 * nRow);
         IPSSysERMapNode iPSSysERMapNode = new PSSysERMapNodeImpl();
         iPSSysERMapNode.init(this.getDAGlobalHelper(), this, psSysERMapNode);
         this.psSysERMapNodeList.add(iPSSysERMapNode);
         nIndex++;
      }
   }

   @PSModelRTMeta(description = "ER图节点集合", outputdoc = "false", child = true)
   @Override
   public Iterator<? extends IPSSysERMapNode> getPSSysERMapNodes() {
      return this.psSysERMapNodeList.size() == 0 ? null : this.psSysERMapNodeList.iterator();
   }

   @PSModelRTMeta(description = "编号", group = "基本", order = 105)
   @Override
   public String getERMapSN() {
      return null;
   }

   @Override
   public String getModelType() {
      return "PSSYSERMAP";
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.strCodeName;
   }

   @PSModelRTMeta(description = "系统模块", hideempty = true, dumpref = true)
   @Override
   public IPSSystemModule getPSSystemModule() {
      return this.iPSSystemModule;
   }

   @PSModelRTMeta(description = "后台服务发布对象", hideempty = true)
   @Override
   public IPSSysSFPub getPSSysSFPub() {
      return this.getPSSystemModule() != null ? this.getPSSystemModule().getPSSysSFPub() : this.getPSSystem().getDefaultPSSysSFPub();
   }

   @Override
   public Iterator<? extends IPSERMapNode> getPSERMapNodes() {
      return this.getPSSysERMapNodes();
   }

   @PSModelRTMeta(description = "实体关系集合", hideempty = true, group = "基本", order = 140)
   @Override
   public Iterator<? extends IPSDERBase> getPSDERs() throws Exception {
      Map<String, IPSDataEntity> map = new LinkedHashMap<>();
      Iterator<? extends IPSSysERMapNode> psSysERMapNodes = this.getPSSysERMapNodes();
      if (psSysERMapNodes == null) {
         return null;
      }

      while (psSysERMapNodes.hasNext()) {
         IPSSysERMapNode iPSSysERMapNode = psSysERMapNodes.next();
         if (iPSSysERMapNode.getPSDataEntity() != null) {
            map.put(iPSSysERMapNode.getPSDataEntity().getId(), iPSSysERMapNode.getPSDataEntity());
         }
      }

      if (map.size() == 0) {
         return null;
      }

      Iterator<IPSDERBase> psDERs = this.getPSSystem().getAllPSDERs();
      if (psDERs == null) {
         return null;
      }

      List<IPSDERBase> list = new ArrayList<>();

      while (psDERs.hasNext()) {
         IPSDERBase iPSDERBase = psDERs.next();
         if (map.containsKey(iPSDERBase.getMajorPSDataEntity().getId()) && map.containsKey(iPSDERBase.getMinorPSDataEntity().getId())) {
            list.add(iPSDERBase);
         }
      }

      return list.size() == 0 ? null : list.iterator();
   }
}
