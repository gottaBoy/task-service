package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERMultiInherit;
import SA.SRFDA.PS.Data.PSSysDBTable;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysDBTableImpl extends PSSysDBSchemeObjectImpl implements IPSSysDBTable, IPSSysDBTableRuntime {
   private static final Log log = LogFactory.getLog(PSSysDBTableImpl.class);
   protected PSSysDBTable psSysDBTable = null;
   private PSSysDBColumnGlobalModel psSysDBColumnGlobalModel = new PSSysDBColumnGlobalModel();
   private int nLoadedLevel = IPSSystem.LOADLEVEL_NONE;
   private int nLoadingLevel = IPSSystem.LOADLEVEL_NONE;
   private boolean bExistingModel = false;
   private boolean bAutoExtendModel = true;
   private Map<String, IPSSysDBIndex> psSysDBIndexMap = new LinkedHashMap<>();

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDBScheme iPSSysDBScheme, PSSysDBTable psSysDBTable) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.setPSSysDBScheme(iPSSysDBScheme);
         this.psSysDBTable = psSysDBTable;
         this.setPSSysDBScheme(iPSSysDBScheme);
         this.setId(this.psSysDBTable.getPSSYSDBTABLEID());
         this.setName(this.psSysDBTable.getPSSYSDBTABLENAME());
         this.setPSObjectData(this.psSysDBTable);
         if (!this.psSysDBTable.isEXISTINGMODELNull()) {
            this.bExistingModel = this.psSysDBTable.getEXISTINGMODEL();
         } else {
            this.bExistingModel = iPSSysDBScheme.isExistingModel();
         }

         if (!this.psSysDBTable.isAUTOEXTENDMODELNull()) {
            this.bAutoExtendModel = this.psSysDBTable.getAUTOEXTENDMODEL();
         } else {
            this.bAutoExtendModel = iPSSysDBScheme.isAutoExtendModel();
         }

         this.psSysDBColumnGlobalModel.Init(iDAGlobalHelper, this);
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
      this.psSysDBColumnGlobalModel.getAllModelHelpers();
      super.onInit();
   }

   @Override
   protected int onCheck() throws Exception {
      this.psSysDBColumnGlobalModel.checkAll();
      return super.onCheck();
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.psSysDBTable.getCODENAME();
   }

   @PSModelRTMeta(description = "逻辑名称 ", fields = "LOGICNAME")
   @Override
   public String getLogicName() {
      return this.psSysDBTable.getLOGICNAME();
   }

   @Override
   public String getModelType() {
      return "PSSYSDBTABLE";
   }

   @Override
   public String getModelId() {
      return SA.SRFramework.Utility.StringHelper.Format("%1$s#%2$s", this.getPSSysDBScheme().getModelId(), super.getModelId());
   }

   @PSModelRTMeta(description = "数据列集合", child = true, rtname = "getColumns", dynamodelmode = 4, group = "基本", order = 140)
   @Override
   public Iterator<IPSSysDBColumn> getAllPSSysDBColumns() throws Exception {
      return this.psSysDBColumnGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "索引集合", child = true, rtname = "getIndices", dynamodelmode = 4, group = "基本", order = 142)
   @Override
   public Iterator<IPSSysDBIndex> getAllPSSysDBIndices() throws Exception {
      return this.psSysDBIndexMap.values().iterator();
   }

   @Override
   public IPSSysDBColumn getPSSysDBColumn(String strSysDBColumnId) throws Exception {
      return this.psSysDBColumnGlobalModel.FindModelHelper(strSysDBColumnId);
   }

   @Override
   public IPSSysDBColumn getPSSysDBColumn(String strSysDBColumnId, boolean bTryMode) throws Exception {
      return this.psSysDBColumnGlobalModel.FindModelHelper(strSysDBColumnId, bTryMode);
   }

   @Override
   public void resetPSSysDBColumn(String strSysDBColumnId) throws Exception {
      this.psSysDBColumnGlobalModel.ResetModel(strSysDBColumnId);
   }

   @Override
   public void resetAllPSSysDBColumns() {
      this.psSysDBColumnGlobalModel.ResetAll();
   }

   @Override
   public void load(int nLoadLevel) throws Exception {
      try {
         this.nLoadingLevel = nLoadLevel;
         this.getAllPSSysDBColumns();
         this.nLoadedLevel = nLoadLevel;
      } catch (Exception ex) {
         this.getPSSystemUtil().log(1, this, ex.getMessage());
         throw ex;
      }
   }

   @Override
   public int getLoadedLevel() {
      return this.nLoadedLevel;
   }

   @Override
   public int getLoadingLevel() {
      return this.nLoadingLevel;
   }

   @PSModelRTMeta(description = "现有数据结构")
   @Override
   public boolean isExistingModel() {
      return this.bExistingModel;
   }

   @PSModelRTMeta(description = "自动扩展结构")
   @Override
   public boolean isAutoExtendModel() {
      return this.bAutoExtendModel;
   }

   @PSModelRTMeta(description = "建立SQL", fields = "CREATESQL")
   @Override
   public String getCreateSql() {
      return this.psSysDBTable.getCREATESQL();
   }

   @PSModelRTMeta(description = "移除SQL", fields = "DROPSQL")
   @Override
   public String getDropSql() {
      return this.psSysDBTable.getDROPSQL();
   }

   @Override
   public String getNameByDBType(String strDBType) throws Exception {
      IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(strDBType, true);
      if (iPSDBType == null) {
         throw new Exception(String.format("不支持的数据库类型[%1$s]", strDBType));
      } else {
         return iPSDBType.getDBObjStandardName(this.getName());
      }
   }

   @Override
   public void registerPSDataEntity(IPSDataEntity iPSDataEntity) throws Exception {
      if (this.getPSSysDBScheme().isPubIndex()) {
         IPSSysDBColumn[] extColumns = null;
         IPSSysDBColumn saaSDCIdPSSysDBColumn = null;
         String strSaaSDCIdColumn = iPSDataEntity.getSaaSDCIdColumnName();
         if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty(strSaaSDCIdColumn)) {
            saaSDCIdPSSysDBColumn = this.getPSSysDBColumn(strSaaSDCIdColumn, true);
            if (saaSDCIdPSSysDBColumn != null) {
               extColumns = new IPSSysDBColumn[]{saaSDCIdPSSysDBColumn};
            }
         }

         if (this.getPSSysDBScheme().isEnableFKeyIndex()) {
            Map<String, IPSSysDBIndex> derPSSysDBIndexMap = new HashMap<>();
            Iterator<IPSDER1N> psDER1Ns = iPSDataEntity.getMinorPSDER1Ns();
            if (psDER1Ns != null) {
               while (psDER1Ns.hasNext()) {
                  IPSDER1N iPSDER1N = psDER1Ns.next();
                  PSSysDBIndexImpl psSysDBIndexImpl = new PSSysDBIndexImpl();
                  psSysDBIndexImpl.init(this.getDAGlobalHelper(), this, iPSDER1N, extColumns);
                  if (psSysDBIndexImpl.getAllPSSysDBIndexColumns() != null
                     && psSysDBIndexImpl.getAllPSSysDBIndexColumns().hasNext()
                     && !this.psSysDBIndexMap.containsKey(psSysDBIndexImpl.getUniqueId())) {
                     this.psSysDBIndexMap.put(psSysDBIndexImpl.getUniqueId(), psSysDBIndexImpl);
                     derPSSysDBIndexMap.put(iPSDER1N.getPSPickupDEField().getName(), psSysDBIndexImpl);
                  }
               }
            }

            if (iPSDataEntity.getVirtualMode() == 5) {
               this.registerInheritPSDataEntity(iPSDataEntity, extColumns, derPSSysDBIndexMap, true);
            }
         }

         if (this.getPSSysDBScheme().isEnableSaaSDCIdIndex() && saaSDCIdPSSysDBColumn != null) {
            PSSysDBIndexImpl psSysDBIndexImpl = new PSSysDBIndexImpl();
            psSysDBIndexImpl.init(this.getDAGlobalHelper(), this, saaSDCIdPSSysDBColumn, null);
            if (psSysDBIndexImpl.getAllPSSysDBIndexColumns() != null
               && psSysDBIndexImpl.getAllPSSysDBIndexColumns().hasNext()
               && !this.psSysDBIndexMap.containsKey(psSysDBIndexImpl.getUniqueId())) {
               this.psSysDBIndexMap.put(psSysDBIndexImpl.getUniqueId(), psSysDBIndexImpl);
            }
         }

         Iterator<IPSDEDBIndex> psDEDBIndexs = iPSDataEntity.getAllPSDEDBIndexs();
         if (psDEDBIndexs != null) {
            while (psDEDBIndexs.hasNext()) {
               IPSDEDBIndex iPSDEDBIndex = psDEDBIndexs.next();
               PSSysDBIndexImpl psSysDBIndexImpl = new PSSysDBIndexImpl();
               psSysDBIndexImpl.init(this.getDAGlobalHelper(), this, iPSDEDBIndex, extColumns);
               if (psSysDBIndexImpl.getAllPSSysDBIndexColumns() != null && psSysDBIndexImpl.getAllPSSysDBIndexColumns().hasNext()) {
                  this.psSysDBIndexMap.put(psSysDBIndexImpl.getUniqueId(), psSysDBIndexImpl);
               }
            }
         }
      }
   }

   @PSModelRTMeta(description = "数据表标记", fields = "TABLETAG")
   @Override
   public String getTableTag() {
      return this.psSysDBTable.getTABLETAG();
   }

   @PSModelRTMeta(description = "数据表标记2", fields = "TABLETAG2")
   @Override
   public String getTableTag2() {
      return this.psSysDBTable.getTABLETAG2();
   }

   protected void registerInheritPSDataEntity(
      IPSDataEntity iPSDataEntity, IPSSysDBColumn[] extColumns, Map<String, IPSSysDBIndex> derPSSysDBIndexMap, boolean bRoot
   ) throws Exception {
      if (!bRoot) {
         Iterator<IPSDER1N> psDER1Ns = iPSDataEntity.getMinorPSDER1Ns();
         if (psDER1Ns != null) {
            while (psDER1Ns.hasNext()) {
               IPSDER1N iPSDER1N = psDER1Ns.next();
               PSSysDBIndexImpl psSysDBIndexImpl = new PSSysDBIndexImpl();
               psSysDBIndexImpl.init(this.getDAGlobalHelper(), this, iPSDER1N.getPSPickupDEField(), extColumns);
               if (psSysDBIndexImpl.getAllPSSysDBIndexColumns() != null
                  && psSysDBIndexImpl.getAllPSSysDBIndexColumns().hasNext()
                  && !this.psSysDBIndexMap.containsKey(psSysDBIndexImpl.getUniqueId())
                  && !derPSSysDBIndexMap.containsKey(iPSDER1N.getPSPickupDEField().getName())) {
                  this.psSysDBIndexMap.put(psSysDBIndexImpl.getUniqueId(), psSysDBIndexImpl);
                  derPSSysDBIndexMap.put(iPSDER1N.getPSPickupDEField().getName(), psSysDBIndexImpl);
               }
            }
         }

         if (iPSDataEntity.getVirtualMode() != 5) {
            return;
         }
      }

      Iterator<IPSDERMultiInherit> psDERMultiInherits = iPSDataEntity.getPSDERMultiInherits(false);
      if (psDERMultiInherits != null) {
         while (psDERMultiInherits.hasNext()) {
            IPSDERMultiInherit iPSDERMultiInherit = psDERMultiInherits.next();
            this.registerInheritPSDataEntity(iPSDERMultiInherit.getMajorPSDataEntity(), extColumns, derPSSysDBIndexMap, false);
         }
      }
   }
}
