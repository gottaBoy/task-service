package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlContainerImpl2;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelParamImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.Data.PSDataItemParamImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSDEGEIUDetail;
import SA.SRFDA.PS.Data.PSDEGEIUpdate;
import SA.SRFDA.PS.Data.PSDEGrid;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.PS.Data.PSDEGridEditItemVR;
import SA.SRFDA.PS.Data.PSDEGridLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.data.IDataItemParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement = "IPSControl", typevalues = "GRID")
public class PSDEGridImpl extends PSMDAjaxControlContainerImpl2 implements IPSDEGrid {
   private static final Log log = LogFactory.getLog(PSDEGridImpl.class);
   protected PSDEGrid psDEGrid;
   protected ArrayList<IPSDEGridColumn> psDEGridColumnList = new ArrayList<>();
   protected ArrayList<IPSDEGridColumn> psDEGridColumnList2 = new ArrayList<>();
   protected ArrayList<IPSDEGridColumn> psDEGridColumnList3 = new ArrayList<>();
   protected ArrayList<IGridColumn> gridColumnList = new ArrayList<>();
   protected Map<String, IPSDEGridDataItem> psDEGridDataItemMap = new LinkedHashMap<>();
   protected ArrayList<IGridDataItem> gridDataItemList = new ArrayList<>();
   protected Map<String, IPSDEGridEditItem> psDEGridEditItemMap = new LinkedHashMap<>();
   protected ArrayList<IGridEditItem> gridEditItemList = new ArrayList<>();
   protected Map<String, IPSDEGridEditItemUpdate> psDEGridEditItemUpdateMap = new LinkedHashMap<>();
   protected PSDEGridParamImpl psDEGridParamImpl = new PSDEGridParamImpl();
   protected String strCodeName = "";
   protected boolean bForceFit = false;
   protected String strGridStyle = "";
   protected boolean bNoSort = false;
   protected IPSDEField minorPSDEField = null;
   protected String strMinorSortDir = "";
   private boolean bHideHeader = false;
   protected ArrayList<IPSDEGridDataItem> groupPSDEGridDataItemList = new ArrayList<>();
   private String strEmptyText = null;
   private IPSLanguageRes emptyTextPSLanguageRes = null;
   private boolean bHasWFDataItems = false;
   private String strSortMode = "REMOTE";
   private String strAggMode = "NONE";
   private IPSDataEntity aggPSDataEntity = null;
   private IPSDEAction aggPSDEAction = null;
   private IPSDEDataSet aggPSDEDataSet = null;
   private IPSAppDataEntity aggPSAppDataEntity = null;
   private IPSAppDEAction aggPSAppDEAction = null;
   private IPSAppDEDataSet aggPSAppDEDataSet = null;
   private List<IPSAppDEField> psAppDEFieldList = null;
   private int nColumnEnableLink = 2;
   private int nColumnEnableFilter = 2;
   private HashMap<String, IPSDEGridEditItemVR> psDEGridEditItemVRMap = new HashMap<>();
   private IPSDEField orderValuePSDEField = null;
   private String strGroupMode = "NONE";
   private IPSDEField groupPSDEField = null;
   private IPSCodeList groupPSCodeList = null;
   private boolean bEnableGroup = false;
   private IPSAppDEField groupPSAppDEField = null;
   private IPSDEField groupTextPSDEField = null;
   private IPSAppDEField groupTextPSAppDEField = null;
   private boolean bBufferRenderer = true;
   private boolean bInvalidId = false;
   private boolean bEnableCustomized = false;
   private IPSSysLayoutPanel aggPSLayoutPanel = null;
   private String strAggPSSysViewPanelId = null;
   private String strGroupStyle = null;
   private IPSDEDataSet asyncPSDEDataSet = null;
   protected List<PSDEGridLogicImpl> psDEGridLogicList = new ArrayList<>();

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.setPSControlContainer(iPSControlContainer);
         IPSDEGridParam iPSDEGridParam = (IPSDEGridParam)iPSControlParam;
         this.psDEGrid = new PSDEGrid();
         if (!StringHelper.IsNullOrEmpty(iPSDEGridParam.getPSDEGridId())) {
            CallResult callResult = this.getPSModelHelper().getPSDEGrid(iPSDEGridParam.getPSDEGridId(), this.psDEGrid);
            if (callResult.isError()) {
               throw new Exception(StringHelper.Format("获取实体表格发生错误，%1$s", callResult.getErrorInfo()));
            }

            this.setId(this.psDEGrid.getPSDEGRIDID());
         } else {
            this.setId(StringHelper.Format("%1$s_%2$s", this.getPSAppView().getId(), strName));
            this.bInvalidId = true;
         }

         this.setName(strName);
         this.setLogicName(this.psDEGrid.getPSDEGRIDNAME());
         this.setPSObjectData(this.psDEGrid);
         if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getPSDEID())
            && (this.getPSDataEntity() == null || StringHelper.Compare(this.psDEGrid.getPSDEID(), this.getPSDataEntity().getId(), true) != 0)) {
            this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEGrid.getPSDEID()));
         }

         this.psDEGridParamImpl.setPSAjaxControlHandlerId(this.psDEGrid.getPSACHANDLERID());
         this.psDEGridParamImpl.setPSDEDataSetId(this.psDEGrid.getPSDEDATASETID());
         if (StringHelper.IsNullOrEmpty(this.psDEGrid.getPSDEDATASETID())
            && this.getPSDataEntity() != null
            && this.getPSDataEntity().getDefaultPSDEDataSet() != null) {
            this.psDEGridParamImpl.setPSDEDataSetId(this.getPSDataEntity().getDefaultPSDEDataSet().getId());
         }

         if (!StringHelper.IsNullOrEmpty(this.psDEGridParamImpl.getPSDEDataSetId())) {
            this.psDEGridParamImpl.setCustomCond(this.psDEGrid.getCUSTOMCOND());
         }

         this.psDEGridParamImpl.setPSCtrlMsgId(this.psDEGrid.getPSCTRLMSGID());
         this.psDEGridParamImpl.setPSSysPFPluginId(this.psDEGrid.getPSSYSPFPLUGINID());
         this.psDEGridParamImpl.setPSSysCssId(this.psDEGrid.getPSSYSCSSID());
         this.psDEGridParamImpl.setPSDEUILogicGroupId(this.psDEGrid.getPSCTRLLOGICGROUPID());
         if (!this.psDEGrid.isMULTISELECTNull()) {
            this.psDEGridParamImpl.setSingleSelect(!this.psDEGrid.getMULTISELECT());
         } else {
            this.psDEGridParamImpl.setSingleSelect(false);
         }

         int nEditMode = this.psDEGrid.GetParamIntValue("ENABLEEDIT", 0);
         if (nEditMode != 0) {
            this.psDEGridParamImpl.setEditMode(nEditMode);
            this.psDEGridParamImpl.setEnableRowEdit((nEditMode & 1) == 1);
         } else {
            this.psDEGridParamImpl.setEnableRowEdit(false);
         }

         this.psDEGridParamImpl.merge(iPSControlParam);
         this.strCodeName = this.psDEGrid.getCODENAME();
         if (StringHelper.IsNullOrEmpty(this.strCodeName)) {
            this.strCodeName = this.getName();
         }

         if (!StringHelper.IsNullOrEmpty(this.strCodeName)
            && (this.getPSSystem() == null || !this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
            String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
            this.strCodeName = strHeader + this.strCodeName.substring(1);
         }

         this.setCheckControlDataSet(true);
         super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psDEGridParamImpl);
      } catch (Exception ex) {
         this.throwCriticalInitException(ex);
         String strLogName = net.ibizsys.paas.util.StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = net.ibizsys.paas.util.StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(net.ibizsys.paas.util.StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
         if (this.getPSSystemUtil() != null) {
            this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
         }

         this.throwInitException(ex);
      }
   }

   public void initExpMode(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strGridId) throws Exception {
      this.setDAGlobalHelper(iDAGlobalHelper);
      this.setPSControlContainer(iPSControlContainer);
      this.psDEGrid = new PSDEGrid();
      CallResult callResult = this.getPSModelHelper().getPSDEGrid(strGridId, this.psDEGrid);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("获取实体表格发生错误，%1$s", callResult.getErrorInfo()));
      }

      this.setId(this.psDEGrid.getPSDEGRIDID());
      this.setName(strGridId);
      this.psDEGridParamImpl.setPSAjaxControlHandlerId(this.psDEGrid.getPSACHANDLERID());
      this.psDEGridParamImpl.setPSDEDataSetId(this.psDEGrid.getPSDEDATASETID());
      this.strCodeName = this.psDEGrid.getCODENAME();
      if (StringHelper.IsNullOrEmpty(this.strCodeName)) {
         this.strCodeName = this.getName();
      }

      if (!StringHelper.IsNullOrEmpty(this.strCodeName)
         && (this.getPSSystem() == null || !this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
         String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
         this.strCodeName = strHeader + this.strCodeName.substring(1);
      }

      this.setCheckControlDataSet(false);
      this.onInit();
   }

   @Override
   protected void onInit() throws Exception {
      if (!this.psDEGrid.isFORCEFITNull()) {
         this.bForceFit = this.psDEGrid.getFORCEFIT();
      } else if (this.getPSAppView() != null) {
         this.bForceFit = this.getPSAppView().getPSApplication().getPSApplicationUI().isGridForceFit();
      }

      if (this.psDEGridParamImpl.isEnableCustomized() != null) {
         this.bEnableCustomized = this.psDEGridParamImpl.isEnableCustomized();
      } else if (!this.psDEGrid.isENABLECUSTOMIZEDNull()) {
         this.bEnableCustomized = this.psDEGrid.getENABLECUSTOMIZED();
      } else {
         this.bEnableCustomized = this.getPSAppView().getPSApplication().getPSApplicationUI().isGridEnableCustomized();
      }

      this.strGridStyle = this.psDEGrid.getGRIDSTYLE();
      if (!this.psDEGrid.isNOSORTNull()) {
         this.bNoSort = this.psDEGrid.getNOSORT();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getSORTMODE())) {
         this.strSortMode = this.psDEGrid.getSORTMODE();
      }

      if (!this.psDEGrid.isSHOWHEADERNull()) {
         this.bHideHeader = !this.psDEGrid.getSHOWHEADER();
      }

      this.strEmptyText = this.psDEGrid.getEMPTYTEXT();
      if (!this.psDEGrid.isCOLENABLELINKNull()) {
         this.nColumnEnableLink = this.psDEGrid.getCOLENABLELINK();
      } else if (this.getPSApplication() != null) {
         this.nColumnEnableLink = this.getPSApplication().getPSApplicationUI().getGridColumnEnableLink();
      }

      if (!this.psDEGrid.isCOLENABLEFILTERNull()) {
         this.nColumnEnableFilter = this.psDEGrid.getCOLENABLEFILTER();
      } else if (this.getPSApplication() != null) {
         this.nColumnEnableFilter = this.getPSApplication().getPSApplicationUI().getGridColumnEnableFilter();
      }

      if (!this.psDEGrid.isBUFFERRENDERERMODENull()) {
         this.bBufferRenderer = this.psDEGrid.getBUFFERRENDERERMODE();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getAGGMODE())) {
         this.strAggMode = this.psDEGrid.getAGGMODE();
      }

      if (!StringHelper.IsNullOrEmpty(this.getAggMode()) && StringHelper.Compare(this.getAggMode(), "NONE", false) != 0) {
         this.strAggPSSysViewPanelId = this.psDEGrid.getAGGPSSYSVIEWPANELID();
         if (StringHelper.Compare(this.getAggMode(), "ALL", false) == 0) {
            if (StringHelper.IsNullOrEmpty(this.psDEGrid.getAGGPSDEID())) {
               throw new Exception("没有指定聚合服务实体对象");
            }

            if (StringHelper.IsNullOrEmpty(this.psDEGrid.getAGGPSDEDSID()) && StringHelper.IsNullOrEmpty(this.psDEGrid.getAGGPSDEACTIONID())) {
               throw new Exception("没有指定聚合服务实体集合对象");
            }

            this.aggPSDataEntity = this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEGrid.getAGGPSDEID());
            if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getAGGPSDEACTIONID())) {
               this.aggPSDEAction = this.getAggPSDataEntity().getPSDEAction(this.psDEGrid.getAGGPSDEACTIONID());
            }

            if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getAGGPSDEDSID())) {
               this.aggPSDEDataSet = this.getAggPSDataEntity().getPSDEDataSet(this.psDEGrid.getAGGPSDEDSID());
            }

            this.aggPSAppDataEntity = this.getPSAppView().getPSApplication().getPSAppDataEntity(this.aggPSDataEntity, true);
            if (this.getAggPSAppDataEntity() != null) {
               if (this.aggPSDEAction != null) {
                  this.aggPSAppDEAction = this.getAggPSAppDataEntity().getPSAppDEAction(this.aggPSDEAction, true);
               }

               if (this.aggPSDEDataSet != null) {
                  this.aggPSAppDEDataSet = this.getAggPSAppDataEntity().getPSAppDEDataSet(this.aggPSDEDataSet, true);
               }
            }
         }
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getGROUPMODE())) {
         this.strGroupMode = this.psDEGrid.getGROUPMODE();
      }

      if (StringHelper.Compare(this.getGroupMode(), "NONE", false) != 0) {
         this.bEnableGroup = true;
         if (StringHelper.IsNullOrEmpty(this.psDEGrid.getGROUPPSDEFID())) {
            throw new Exception("没有指定分组属性");
         }

         this.groupPSDEField = this.getPSDataEntity().getPSDEField(this.psDEGrid.getGROUPPSDEFID());
         if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getGROUPPSCODELISTID())) {
            this.groupPSCodeList = this.getPSDataEntity().getPSSystem().getPSCodeList(this.psDEGrid.getGROUPPSCODELISTID());
         } else {
            this.groupPSCodeList = this.groupPSDEField.getPSCodeList();
         }

         if (this.groupPSCodeList != null) {
            this.groupPSCodeList = this.getPSAppView().getPSApplication().getPSCodeList(this.groupPSCodeList, true);
         }

         if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getGROUPTEXTPSDEFID())) {
            this.groupTextPSDEField = this.getPSDataEntity().getPSDEField(this.psDEGrid.getGROUPTEXTPSDEFID());
         } else if (this.groupPSCodeList == null && this.groupPSDEField instanceof IPSPickupDEField) {
            this.groupTextPSDEField = ((IPSPickupDEField)this.groupPSDEField).getPSPickupTextDEField();
         }

         if (this.getPSAppDataEntity() != null) {
            this.groupPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.groupPSDEField, true);
            if (this.groupTextPSDEField != null) {
               this.groupTextPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.groupTextPSDEField, true);
            }
         }

         this.strGroupStyle = this.psDEGrid.getGROUPSTYLE();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getEMPTYTEXTPSLANRESID())) {
         if (this.getPSApplication() != null) {
            this.emptyTextPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psDEGrid.getEMPTYTEXTPSLANRESID());
         } else {
            this.emptyTextPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEGrid.getEMPTYTEXTPSLANRESID());
         }
      }

      String strMinorSortPSDEFName = this.psDEGrid.getMINORSORTPSDEFNAME();
      if (!StringHelper.IsNullOrEmpty(strMinorSortPSDEFName)) {
         this.minorPSDEField = this.getPSDataEntity().getPSDEField(strMinorSortPSDEFName);
         this.strMinorSortDir = this.psDEGrid.getMINORSORTDIR();
         if (StringHelper.IsNullOrEmpty(this.strMinorSortDir)) {
            this.strMinorSortDir = "ASC";
         }
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEGrid.getORDERVALUEPSDEFID())) {
         this.orderValuePSDEField = this.getPSDataEntity().getPSDEField(this.psDEGrid.getORDERVALUEPSDEFID());
      } else {
         this.orderValuePSDEField = this.getPSDataEntity().getOrderValuePSDEField();
      }

      super.onInit();
      this.onPrepareAggPSLayoutPanel();
      if (!this.bInvalidId) {
         this.onPreparePSDEGridColumns();
         this.onPreparePSDEGridDataItems();
         this.onPreparePSDEGridEditItemUpdates();
         this.onPreparePSDEGridEditItems();
         this.onPreparePSDEGridEditItemVRs();
         this.onPreparePSDEGridLogics();
      }

      this.initNavParams(this.psDEGrid);
   }

   @Override
   protected int onCheck() throws Exception {
      if (this.getAggPSLayoutPanel() != null) {
         this.getAggPSLayoutPanel().check();
      }

      return super.onCheck();
   }

   protected void onPreparePSDEGridColumns() throws Exception {
      this.psDEGridColumnList.clear();
      this.gridColumnList.clear();
      this.psDEGridColumnList2.clear();
      this.groupPSDEGridDataItemList.clear();
      this.psDEGridColumnList3.clear();
      Vector<PSDEGridColumn> psDEGridColumnList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDEGridColumns(this.getId(), psDEGridColumnList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询表格列集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      boolean bKeyColumn = false;
      HashMap<String, PSDEGridColumn> psDEGridColumnMap = new HashMap<>();

      for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
         psDEGridColumnMap.put(psDEGridColumn.getPSDEGRIDCOLID(), psDEGridColumn);
         if (StringHelper.Compare(psDEGridColumn.getPSDEGRIDCOLNAME(), "srfkey", true) == 0) {
            bKeyColumn = true;
            break;
         }
      }

      for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
         if (!StringHelper.IsNullOrEmpty(psDEGridColumn.getPPSDEGRIDCOLID()) && (psDEGridColumn.isHIDDENDATAITEMNull() || !psDEGridColumn.getHIDDENDATAITEM())) {
            PSDEGridColumn parentPSDEGridColumn = psDEGridColumnMap.get(psDEGridColumn.getPPSDEGRIDCOLID());
            if (parentPSDEGridColumn != null) {
               parentPSDEGridColumn.getChildPSDEGridColumns(true).add(psDEGridColumn);
            } else {
               this.getPSSystemUtil()
                  .getPSSysConsole()
                  .warn(
                     this.getLogName(),
                     StringHelper.Format("无法获取表格父列[%1$s]，忽略此模型", psDEGridColumn.getPPSDEGRIDCOLID()),
                     "PSDEGRIDCOL",
                     "REMOVE",
                     psDEGridColumn.getPSDEGRIDCOLID()
                  );
            }
         }
      }

      for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
         if (StringHelper.IsNullOrEmpty(psDEGridColumn.getPPSDEGRIDCOLID()) || !psDEGridColumn.isHIDDENDATAITEMNull() && psDEGridColumn.getHIDDENDATAITEM()) {
            IPSDEGridColumnType iPSDEGridColumnType = this.getPSModelStorage().getPSDEGridColumnType(psDEGridColumn.getGRIDCOLTYPE());
            IPSDEGridColumn iPSDEGridColumn = iPSDEGridColumnType.createPSDEGridColumn(psDEGridColumn);
            iPSDEGridColumn.init(this.getDAGlobalHelper(), this, null, psDEGridColumn);
            if (iPSDEGridColumn.isHiddenDataItem()) {
               this.psDEGridColumnList2.add(iPSDEGridColumn);
            } else {
               this.psDEGridColumnList.add(iPSDEGridColumn);
            }
         }
      }

      for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
         this.fillChildPSDEGridColumnList(iPSDEGridColumn, this.psDEGridColumnList2);
      }

      HashMap<String, IPSDEGridFieldColumn> groupPSDEGridColumnMap = new HashMap<>();

      for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
         if (iPSDEGridColumn instanceof IPSDEGridFieldColumn) {
            IPSDEGridFieldColumn iPSDEGridFieldColumn = (IPSDEGridFieldColumn)iPSDEGridColumn;
            if (!StringHelper.IsNullOrEmpty(iPSDEGridFieldColumn.getGroupItem())) {
               groupPSDEGridColumnMap.put(iPSDEGridFieldColumn.getGroupItem(), iPSDEGridFieldColumn);
            }
         }
      }

      for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList2) {
         if (iPSDEGridColumn instanceof IPSDEGridFieldColumn) {
            IPSDEGridFieldColumn iPSDEGridFieldColumn = (IPSDEGridFieldColumn)iPSDEGridColumn;
            if (!StringHelper.IsNullOrEmpty(iPSDEGridFieldColumn.getGroupItem())) {
               groupPSDEGridColumnMap.put(iPSDEGridFieldColumn.getGroupItem(), iPSDEGridFieldColumn);
            }
         }
      }

      for (int i = 1; i <= 4; i++) {
         String strGroupItem = StringHelper.Format("GROUP%1$s", i);
         IPSDEGridFieldColumn iPSDEGridFieldColumn = groupPSDEGridColumnMap.get(strGroupItem);
         if (iPSDEGridFieldColumn != null) {
            Iterator<IPSDEGridDataItem> psDEGridDataItems = iPSDEGridFieldColumn.getPSDEGridDataItems();
            if (psDEGridDataItems != null) {
               while (psDEGridDataItems.hasNext()) {
                  this.groupPSDEGridDataItemList.add(psDEGridDataItems.next());
               }
            }
         }
      }

      if (!bKeyColumn) {
         PSDEGridColumn psDEGridColumn = new PSDEGridColumn();
         psDEGridColumn.setPSDEID(this.getPSDataEntity().getId());
         psDEGridColumn.setENABLEROWEDIT(true);
         psDEGridColumn.setPSDEGRIDCOLID("srfkey");
         psDEGridColumn.setPSDEGRIDCOLNAME("srfkey");
         psDEGridColumn.setEDITORTYPE("HIDDEN");
         psDEGridColumn.setPSDEFID(this.getPSDataEntity().getKeyPSDEField().getId());
         psDEGridColumn.setPSDEFNAME(this.getPSDataEntity().getKeyPSDEField().getName());
         psDEGridColumn.setGRIDCOLTYPE("DEFGRIDCOLUMN");
         psDEGridColumn.setALLOWEMPTY(true);
         psDEGridColumn.setHIDDENDATAITEM(true);
         IPSDEGridColumnType iPSDEGridColumnType = this.getPSModelStorage().getPSDEGridColumnType(psDEGridColumn.getGRIDCOLTYPE());
         IPSDEGridColumn iPSDEGridColumn = iPSDEGridColumnType.createPSDEGridColumn(psDEGridColumn);
         iPSDEGridColumn.init(this.getDAGlobalHelper(), this, null, psDEGridColumn);
         this.psDEGridColumnList2.add(iPSDEGridColumn);
      }

      this.gridColumnList.addAll(this.psDEGridColumnList);

      for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
         this.fillAllPSDEGridColumnList(iPSDEGridColumn, this.psDEGridColumnList3);
      }
   }

   protected void fillAllPSDEGridColumnList(IPSDEGridColumn iPSDEGridColumn, ArrayList<IPSDEGridColumn> psDEGridColumnList) {
      psDEGridColumnList.add(iPSDEGridColumn);
      if (iPSDEGridColumn instanceof IPSDEGridGroupColumn) {
         IPSDEGridGroupColumn iPSDEGridGroupColumn = (IPSDEGridGroupColumn)iPSDEGridColumn;
         Iterator<IPSDEGridColumn> psDEGridColumns = iPSDEGridGroupColumn.getPSDEGridColumns();
         if (psDEGridColumns != null) {
            while (psDEGridColumns.hasNext()) {
               this.fillAllPSDEGridColumnList(psDEGridColumns.next(), psDEGridColumnList);
            }
         }
      }
   }

   protected void onPreparePSDEGridDataItems() throws Exception {
      this.psDEGridDataItemMap.clear();
      this.gridDataItemList.clear();
      boolean bAddFKey = true;
      boolean bAddDataAccAction = true;
      boolean bEditModeItem = false;
      int nIgnoreDSItem = this.psDEGrid.getIGNOREDSITEM();
      if ((nIgnoreDSItem & 1) > 0) {
         bAddFKey = false;
      }

      if ((nIgnoreDSItem & 1024) > 0) {
         bAddDataAccAction = false;
      }

      boolean bUseDTO = false;
      if (this.getPSApplication() != null) {
         bUseDTO = this.getPSApplication().isUseServiceApi();
      }

      for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
         Iterator<IPSDEGridDataItem> psDEGridDataItems = iPSDEGridColumn.getPSDEGridDataItems();
         if (psDEGridDataItems != null) {
            while (psDEGridDataItems.hasNext()) {
               IPSDEGridDataItem iPSDEGridDataItem = psDEGridDataItems.next();
               if (!this.psDEGridDataItemMap.containsKey(iPSDEGridDataItem.getName())) {
                  this.psDEGridDataItemMap.put(iPSDEGridDataItem.getName(), iPSDEGridDataItem);
               }
            }
         }
      }

      for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList2) {
         Iterator<IPSDEGridDataItem> psDEGridDataItems = iPSDEGridColumn.getPSDEGridDataItems();
         if (psDEGridDataItems != null) {
            while (psDEGridDataItems.hasNext()) {
               IPSDEGridDataItem iPSDEGridDataItem = psDEGridDataItems.next();
               if (!this.psDEGridDataItemMap.containsKey(iPSDEGridDataItem.getName())) {
                  this.psDEGridDataItemMap.put(iPSDEGridDataItem.getName(), iPSDEGridDataItem);
               }
            }
         }
      }

      if (!this.psDEGridDataItemMap.containsKey("srfkey")) {
         PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
         psDEGridDataItemImpl.setName("srfkey");
         if (!bUseDTO) {
            psDEGridDataItemImpl.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
               psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
         } else {
            psDEGridDataItemImpl.setFormat("");
         }

         PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
         psItemParamImpl.setName(this.getPSDataEntity().getKeyPSDEField().getName());
         psItemParamImpl.setPSDEField(this.getPSDataEntity().getKeyPSDEField());
         if (this.getPSAppDataEntity() != null) {
            psItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getKeyPSAppDEField());
         }

         psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
         psDEGridDataItemImpl.init(this);
         this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
      }

      if (bAddDataAccAction && !this.psDEGridDataItemMap.containsKey("srfdataaccaction")) {
         PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
         psDEGridDataItemImpl.setName("srfdataaccaction");
         if (!bUseDTO) {
            psDEGridDataItemImpl.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
               psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
         } else {
            psDEGridDataItemImpl.setFormat("");
         }

         psDEGridDataItemImpl.setDataAccessAction(true);
         PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
         psItemParamImpl.setName(this.getPSDataEntity().getKeyPSDEField().getName());
         psItemParamImpl.setPSDEField(this.getPSDataEntity().getKeyPSDEField());
         if (this.getPSAppDataEntity() != null) {
            psItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getKeyPSAppDEField());
         }

         psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
         psItemParamImpl = new PSDataItemParamImpl();
         psItemParamImpl.setName("NONE");
         psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
         psDEGridDataItemImpl.init(this);
         this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
      }

      Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();

      while (psDEFields.hasNext()) {
         IPSDEField iPSDEField = psDEFields.next();
         if (iPSDEField.isQueryColumn()) {
            IPSAppDEField iPSAppDEField = null;
            if (bUseDTO && this.getPSAppDataEntity() != null) {
               iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true);
               if (iPSAppDEField == null) {
                  continue;
               }
            }

            if (iPSDEField.isIndexTypeDEField() || iPSDEField.isMultiFormDEField()) {
               if (!bEditModeItem) {
                  bEditModeItem = true;
                  if (!this.psDEGridDataItemMap.containsKey("srfdatatype")) {
                     PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                     psDEGridDataItemImpl.setName("srfdatatype");
                     if (iPSAppDEField == null) {
                        psDEGridDataItemImpl.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                           psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                     } else {
                        psDEGridDataItemImpl.setFormat("");
                     }

                     PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
                     psItemParamImpl.setName(iPSDEField.getName());
                     psItemParamImpl.setPSDEField(iPSDEField);
                     if (iPSAppDEField == null) {
                        psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                     } else {
                        psItemParamImpl.setFormat(iPSAppDEField.getValueFormat());
                        psItemParamImpl.setPSAppDEField(iPSAppDEField);
                     }

                     psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                     psDEGridDataItemImpl.init(this);
                     this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
                  }
               }

               if (!this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                  PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                  psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                  if (iPSAppDEField == null) {
                     psDEGridDataItemImpl.setFormat("%1$s");
                     if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                     }
                  } else {
                     psDEGridDataItemImpl.setFormat("");
                  }

                  PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
                  psItemParamImpl.setName(iPSDEField.getName());
                  psItemParamImpl.setPSDEField(iPSDEField);
                  if (iPSAppDEField == null) {
                     psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                  } else {
                     psItemParamImpl.setFormat(iPSAppDEField.getValueFormat());
                     psItemParamImpl.setPSAppDEField(iPSAppDEField);
                  }

                  psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                  psDEGridDataItemImpl.init(this);
                  this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
                  continue;
               }
            }

            if (bAddFKey
               && StringHelper.Compare(iPSDEField.getDataType(), "PICKUP", true) == 0
               && !this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
               PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
               psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
               if (iPSAppDEField == null) {
                  psDEGridDataItemImpl.setFormat("%1$s");
                  if (this.getPSSystemSetting() != null) {
                     psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                  }
               } else {
                  psDEGridDataItemImpl.setFormat("");
               }

               PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
               psItemParamImpl.setName(iPSDEField.getName());
               psItemParamImpl.setPSDEField(iPSDEField);
               if (iPSAppDEField == null) {
                  psItemParamImpl.setFormat(iPSDEField.getValueFormat());
               } else {
                  psItemParamImpl.setFormat(iPSAppDEField.getValueFormat());
                  psItemParamImpl.setPSAppDEField(iPSAppDEField);
               }

               psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
               psDEGridDataItemImpl.init(this);
               this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
            }
         }
      }

      if (!this.psDEGridDataItemMap.containsKey("srfmajortext") && this.getPSDataEntity().getMajorPSDEField() != null) {
         IPSAppDEField iPSAppDEField = null;
         boolean bAddDEGridDataItem = true;
         if (bUseDTO && this.getPSAppDataEntity() != null) {
            iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getMajorPSDEField(), true);
            if (iPSAppDEField == null) {
               bAddDEGridDataItem = false;
            }
         }

         if (bAddDEGridDataItem) {
            PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName("srfmajortext");
            if (iPSAppDEField == null) {
               psDEGridDataItemImpl.setFormat("%1$s");
               if (this.getPSSystemSetting() != null) {
                  psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
               }
            } else {
               psDEGridDataItemImpl.setFormat("");
            }

            PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDataEntity().getMajorPSDEField().getName());
            psItemParamImpl.setPSDEField(this.getPSDataEntity().getMajorPSDEField());
            if (this.getPSAppDataEntity() != null) {
               psItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getMajorPSAppDEField());
            }

            psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
            psDEGridDataItemImpl.init(this);
            this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
         }
      }

      boolean bOutputMSTag = true;
      if (this.getPSDataEntity().getAllPSDEWFs() != null) {
         Iterator<IPSDEWF> psDEWFs = this.getPSDataEntity().getAllPSDEWFs();

         while (psDEWFs.hasNext()) {
            IPSDEWF iPSDEWF = psDEWFs.next();
            if (iPSDEWF.getWFStepPSDEField() != null) {
               IPSDEField iPSDEField = iPSDEWF.getWFStepPSDEField();
               IPSAppDEField iPSAppDEField = null;
               if (bUseDTO && this.getPSAppDataEntity() != null) {
                  iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true);
                  if (iPSAppDEField == null) {
                     continue;
                  }
               }

               if (!this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                  PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                  psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                  if (iPSAppDEField == null) {
                     psDEGridDataItemImpl.setFormat("%1$s");
                     if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                     }
                  } else {
                     psDEGridDataItemImpl.setFormat("");
                  }

                  PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
                  psItemParamImpl.setName(iPSDEField.getName());
                  psItemParamImpl.setPSDEField(iPSDEField);
                  if (iPSAppDEField == null) {
                     psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                  } else {
                     psItemParamImpl.setFormat(iPSAppDEField.getValueFormat());
                     psItemParamImpl.setPSAppDEField(iPSAppDEField);
                  }

                  psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                  psDEGridDataItemImpl.init(this);
                  this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
               }
            }

            if (iPSDEWF.getUDStatePSDEField() != null) {
               IPSDEField iPSDEField = iPSDEWF.getUDStatePSDEField();
               IPSAppDEField iPSAppDEField = null;
               if (bUseDTO && this.getPSAppDataEntity() != null) {
                  iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true);
                  if (iPSAppDEField == null) {
                     continue;
                  }
               }

               if (!this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                  PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                  psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                  if (iPSAppDEField == null) {
                     psDEGridDataItemImpl.setFormat("%1$s");
                     if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                     }
                  } else {
                     psDEGridDataItemImpl.setFormat("");
                  }

                  PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
                  psItemParamImpl.setName(iPSDEField.getName());
                  psItemParamImpl.setPSDEField(iPSDEField);
                  if (iPSAppDEField == null) {
                     psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                  } else {
                     psItemParamImpl.setFormat(iPSAppDEField.getValueFormat());
                     psItemParamImpl.setPSAppDEField(iPSAppDEField);
                  }

                  psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                  psDEGridDataItemImpl.init(this);
                  this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
               }
            }

            if (iPSDEWF.getWFVerPSDEField() != null) {
               IPSDEField iPSDEField = iPSDEWF.getWFVerPSDEField();
               IPSAppDEField iPSAppDEField = null;
               if (bUseDTO && this.getPSAppDataEntity() != null) {
                  iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true);
                  if (iPSAppDEField == null) {
                     continue;
                  }
               }

               if (!this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                  PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                  psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                  if (iPSAppDEField == null) {
                     psDEGridDataItemImpl.setFormat("%1$s");
                     if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                     }
                  } else {
                     psDEGridDataItemImpl.setFormat("");
                  }

                  PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
                  psItemParamImpl.setName(iPSDEField.getName());
                  psItemParamImpl.setPSDEField(iPSDEField);
                  if (iPSAppDEField == null) {
                     psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                  } else {
                     psItemParamImpl.setFormat(iPSAppDEField.getValueFormat());
                     psItemParamImpl.setPSAppDEField(iPSAppDEField);
                  }

                  psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                  psDEGridDataItemImpl.init(this);
                  this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
               }
            }
         }
      }

      if (this.isFixWFDataItemsBug() && this.getPSAppView() != null && this.getPSAppView() instanceof IPSAppDEWFView) {
         IPSDEWF iPSDEWF = ((IPSAppDEWFView)this.getPSAppView()).getPSDEWF();
         if (iPSDEWF != null) {
            this.bHasWFDataItems = true;
            if (iPSDEWF.getWFStepPSDEField() != null) {
               IPSDEField iPSDEField = iPSDEWF.getWFStepPSDEField();
               IPSAppDEField iPSAppDEField = null;
               boolean bAddDEGridDataItem = true;
               if (bUseDTO && this.getPSAppDataEntity() != null) {
                  iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true);
                  if (iPSAppDEField == null) {
                     bAddDEGridDataItem = false;
                  }
               }

               if (bAddDEGridDataItem && !this.psDEGridDataItemMap.containsKey("srfwfstep")) {
                  PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                  psDEGridDataItemImpl.setName("srfwfstep");
                  if (iPSAppDEField == null) {
                     psDEGridDataItemImpl.setFormat("%1$s");
                     if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                     }
                  } else {
                     psDEGridDataItemImpl.setFormat("");
                  }

                  PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
                  psItemParamImpl.setName(iPSDEField.getName());
                  psItemParamImpl.setPSDEField(iPSDEField);
                  if (iPSAppDEField == null) {
                     psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                  } else {
                     psItemParamImpl.setFormat(iPSAppDEField.getValueFormat());
                     psItemParamImpl.setPSAppDEField(iPSAppDEField);
                  }

                  psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                  psDEGridDataItemImpl.init(this);
                  this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
               }
            }

            if (iPSDEWF.getWFVerPSDEField() != null) {
               IPSDEField iPSDEField = iPSDEWF.getWFVerPSDEField();
               IPSAppDEField iPSAppDEField = null;
               boolean bAddDEGridDataItem = true;
               if (bUseDTO && this.getPSAppDataEntity() != null) {
                  iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true);
                  if (iPSAppDEField == null) {
                     bAddDEGridDataItem = false;
                  }
               }

               if (bAddDEGridDataItem && !this.psDEGridDataItemMap.containsKey("srfwfver")) {
                  PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                  psDEGridDataItemImpl.setName("srfwfver");
                  if (iPSAppDEField == null) {
                     psDEGridDataItemImpl.setFormat("%1$s");
                     if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                     }
                  } else {
                     psDEGridDataItemImpl.setFormat("");
                  }

                  PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
                  psItemParamImpl.setName(iPSDEField.getName());
                  psItemParamImpl.setPSDEField(iPSDEField);
                  if (iPSAppDEField == null) {
                     psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                  } else {
                     psItemParamImpl.setPSAppDEField(iPSAppDEField);
                     psItemParamImpl.setFormat(iPSAppDEField.getValueFormat());
                  }

                  psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                  psDEGridDataItemImpl.init(this);
                  this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
               }
            }
         }
      }

      if (this.getPSDataEntity().isEnableDEMainState()) {
         PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
         psDEGridDataItemImpl.setName("srfmstag");
         if (!bUseDTO) {
            psDEGridDataItemImpl.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
               psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
         } else {
            psDEGridDataItemImpl.setFormat("");
         }

         psDEGridDataItemImpl.init(this);
         this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
      }

      this.gridDataItemList.addAll(this.psDEGridDataItemMap.values());
   }

   protected void onPreparePSDEGridEditItems() throws Exception {
      this.psDEGridEditItemMap.clear();
      this.gridEditItemList.clear();
      boolean bUseDTO = false;
      if (this.getPSApplication() != null) {
         bUseDTO = this.getPSApplication().isUseServiceApi();
      }

      ArrayList<String> valueItemList = new ArrayList<>();

      for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
         if (iPSDEGridColumn.isEnableRowEdit() && iPSDEGridColumn.getPSDEGridEditItem() != null) {
            this.psDEGridEditItemMap.put(iPSDEGridColumn.getPSDEGridEditItem().getName(), iPSDEGridColumn.getPSDEGridEditItem());
         }
      }

      for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList2) {
         if (iPSDEGridColumn.isEnableRowEdit() && iPSDEGridColumn.getPSDEGridEditItem() != null) {
            this.psDEGridEditItemMap.put(iPSDEGridColumn.getPSDEGridEditItem().getName(), iPSDEGridColumn.getPSDEGridEditItem());
         }
      }

      this.gridEditItemList.addAll(this.psDEGridEditItemMap.values());

      for (IGridEditItem iGridEditItem : this.gridEditItemList) {
         String[] valueItemNames = ((IPSDEGridEditItem)iGridEditItem).getValueItemNames();
         if (valueItemNames != null) {
            String[] var9 = valueItemNames;
            int var8 = valueItemNames.length;

            for (int iPSDEDataGridDataItem = 0; iPSDEDataGridDataItem < var8; iPSDEDataGridDataItem++) {
               String strValueItemName = var9[iPSDEDataGridDataItem];
               if (!StringHelper.IsNullOrEmpty(strValueItemName) && !valueItemList.contains(strValueItemName.toLowerCase())) {
                  valueItemList.add(strValueItemName.toLowerCase());
               }
            }

            if (bUseDTO && iGridEditItem.getDataItem() instanceof IPSDEGridDataItem) {
               IPSDEGridDataItem iPSDEDataGridDataItem = (IPSDEGridDataItem)iGridEditItem.getDataItem();
               if (!this.psDEGridDataItemMap.containsKey(iPSDEDataGridDataItem.getName())) {
                  this.psDEGridDataItemMap.put(iPSDEDataGridDataItem.getName(), iPSDEDataGridDataItem);
               }
            }
         }
      }

      for (String strValueItem : valueItemList) {
         if (!this.psDEGridEditItemMap.containsKey(strValueItem)) {
            IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strValueItem);
            HiddenPSDEGridEditItemImpl hiddenPSDEGridEditItemImpl = new HiddenPSDEGridEditItemImpl();
            hiddenPSDEGridEditItemImpl.init(this.getDAGlobalHelper(), this, iPSDEField);
            this.psDEGridEditItemMap.put(hiddenPSDEGridEditItemImpl.getName(), hiddenPSDEGridEditItemImpl);
            this.gridEditItemList.add(hiddenPSDEGridEditItemImpl);
            if (bUseDTO && hiddenPSDEGridEditItemImpl.getDataItem() instanceof IPSDEGridDataItem) {
               IPSDEGridDataItem iPSDEDataGridDataItem = (IPSDEGridDataItem)hiddenPSDEGridEditItemImpl.getDataItem();
               if (!this.psDEGridDataItemMap.containsKey(iPSDEDataGridDataItem.getName())) {
                  this.psDEGridDataItemMap.put(iPSDEDataGridDataItem.getName(), iPSDEDataGridDataItem);
               }
            }
         }
      }
   }

   protected void onPreparePSDEGridEditItemUpdates() throws Exception {
      this.psDEGridEditItemUpdateMap.clear();
      Vector<PSDEGEIUpdate> psDEGEIUpdateList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDEGEIUpdates(this.getId(), psDEGEIUpdateList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询表格编辑项更新逻辑集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      if (psDEGEIUpdateList.size() != 0) {
         HashMap<String, PSDEGEIUpdate> psDEGEIUpdateMap = new HashMap<>();

         for (PSDEGEIUpdate psDEGEIUpdate : psDEGEIUpdateList) {
            psDEGEIUpdateMap.put(psDEGEIUpdate.getPSDEGEIUPDATEID(), psDEGEIUpdate);
         }

         Vector<PSDEGEIUDetail> psDEGEIUDetailList = new Vector<>();
         callResult = this.getPSModelHelper().getPSDEGEIUDetails(this.getId(), psDEGEIUDetailList);
         if (callResult.isError()) {
            throw new Exception(StringHelper.Format("查询表格编辑项更新成员集合发生错误, %1$s", callResult.getErrorInfo()));
         }

         for (PSDEGEIUDetail psDEGEIUDetail : psDEGEIUDetailList) {
            PSDEGEIUpdate psDEGEIUpdate = psDEGEIUpdateMap.get(psDEGEIUDetail.getPSDEGEIUPDATEID());
            if (psDEGEIUpdate != null) {
               psDEGEIUpdate.getPSDEGEIUDetails(true).add(psDEGEIUDetail);
            } else {
               this.getPSSystemUtil()
                  .getPSSysConsole()
                  .warn(
                     this.getLogName(),
                     StringHelper.Format("无法获取表格编辑项更新[%1$s]，忽略此模型", psDEGEIUDetail.getPSDEGEIUPDATEID()),
                     "PSDEGEIUDETAIL",
                     "REMOVE",
                     psDEGEIUDetail.getPSDEGEIUDETAILID()
                  );
            }
         }

         for (PSDEGEIUpdate psDEGEIUpdate : psDEGEIUpdateList) {
            PSDEGridEditItemUpdateImpl psDEGEIUpdateImpl = new PSDEGridEditItemUpdateImpl();
            psDEGEIUpdateImpl.init(this.getDAGlobalHelper(), this, psDEGEIUpdate);
            this.psDEGridEditItemUpdateMap.put(psDEGEIUpdateImpl.getId(), psDEGEIUpdateImpl);
         }
      }
   }

   protected void onPreparePSDEGridEditItemVRs() throws Exception {
      this.psDEGridEditItemVRMap.clear();
      this.onPreparePSDEGridEditItemVRs(this.getId());
   }

   protected void onPreparePSDEGridEditItemVRs(String strPSDEFormId) throws Exception {
      Vector<PSDEGridEditItemVR> psDEGridEditItemVRList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDEGridEditItemVRs(strPSDEFormId, psDEGridEditItemVRList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询表格编辑项值规则集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      for (PSDEGridEditItemVR psDEGridEditItemVR : psDEGridEditItemVRList) {
         PSDEGridEditItemVRImpl psDEGridEditItemVRImpl = new PSDEGridEditItemVRImpl();
         psDEGridEditItemVRImpl.init(this.getDAGlobalHelper(), this, psDEGridEditItemVR);
         this.psDEGridEditItemVRMap.put(psDEGridEditItemVRImpl.getId(), psDEGridEditItemVRImpl);
      }
   }

   protected void onPreparePSDEGridLogics() throws Exception {
      this.psDEGridLogicList.clear();
      this.onPreparePSDEGridLogics(this.getId());
   }

   protected void onPreparePSDEGridLogics(String strPSDEGridId) throws Exception {
      Vector<PSDEGridLogic> psDEGridLogicList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDEGridLogics(strPSDEGridId, psDEGridLogicList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询表格逻辑集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      for (PSDEGridLogic psDEGridLogic : psDEGridLogicList) {
         PSDEGridLogicImpl psDEGridLogicImpl = new PSDEGridLogicImpl();
         psDEGridLogicImpl.init(this.getDAGlobalHelper(), this, psDEGridLogic);
         this.psDEGridLogicList.add(psDEGridLogicImpl);
      }
   }

   @Override
   protected String onGetControlType() {
      return "GRID";
   }

   @Override
   public Iterator<IGridColumn> getGridColumns() {
      return this.gridColumnList.iterator();
   }

   @PSModelRTMeta(description = "表格列集合", modeltype = "PSDEGRIDCOL", child = true, outputdoc = "false")
   @Override
   public Iterator<IPSDEGridColumn> getPSDEGridColumns() {
      return this.psDEGridColumnList.iterator();
   }

   @Override
   public Iterator<IGridDataItem> getGridDataItems() {
      return this.gridDataItemList.iterator();
   }

   @PSModelRTMeta(description = "表格数据项集合", child = true, group = "部件元素", order = 163)
   @Override
   public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
      return this.psDEGridDataItemMap.values().iterator();
   }

   @Override
   public IPSDEGridDataItem getPSDEGridDataItem(String strPSDEGridDataItemName, boolean bTryMode) throws Exception {
      IPSDEGridDataItem iPSDEGridDataItem = this.psDEGridDataItemMap.get(strPSDEGridDataItemName.toLowerCase());
      if (iPSDEGridDataItem == null && !bTryMode) {
         throw new Exception(StringHelper.Format("无法获取指定表格数据项[%1$s]", strPSDEGridDataItemName));
      } else {
         return iPSDEGridDataItem;
      }
   }

   @PSModelRTMeta(description = "后台部件参数")
   @Override
   public IPSAjaxControlParam getPSAjaxControlParam() {
      return this.psDEGridParamImpl;
   }

   @PSModelRTMeta(description = "支持分页栏", fields = "ENABLEPAGINGBAR")
   @Override
   public boolean isEnablePagingBar() {
      return this.psDEGrid.isENABLEPAGINGBARNull() ? false : this.psDEGrid.getENABLEPAGINGBAR() == 1;
   }

   @PSModelRTMeta(description = "分页模式", codelist = "PagingMode", ignoredumpvalues = "0")
   @Override
   public int getPagingMode() {
      return this.psDEGrid.isENABLEPAGINGBARNull() ? 0 : this.psDEGrid.getENABLEPAGINGBAR();
   }

   @PSModelRTMeta(description = "分页大小", fields = "PAGINGSIZE")
   @Override
   public int getPagingSize() {
      return this.psDEGrid.isPAGINGSIZENull() ? 20 : this.psDEGrid.getPAGINGSIZE();
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.onGetCodeName();
   }

   @Override
   protected String onGetCodeName() {
      return this.getPSApplication().getViewCodeName(null, this.strCodeName, null);
   }

   @PSModelRTMeta(description = "单项选择", model = "PSDEViewCtrl", fields = "MULTISELECT", ignoresetvalues = "*")
   @Override
   public boolean isSingleSelect() {
      return this.psDEGridParamImpl.isSingleSelect();
   }

   @PSModelRTMeta(description = "支持行编辑", model = "PSDEViewCtrl", fields = "CTRLPARAM6", ignoresetvalues = "*")
   @Override
   public boolean isEnableRowEdit() {
      return this.psDEGridParamImpl.isEnableRowEdit() == null ? false : this.psDEGridParamImpl.isEnableRowEdit();
   }

   @PSModelRTMeta(description = "支持行新建", model = "PSDEViewCtrl", fields = "CTRLPARAM6")
   @Override
   public boolean isEnableRowNew() {
      return this.psDEGridParamImpl.getEditMode() != null && (this.psDEGridParamImpl.getEditMode() & 128) == 128 ? false : this.isEnableRowEdit();
   }

   @PSModelRTMeta(description = "支持行次序调整", model = "PSDEViewCtrl", fields = "CTRLPARAM6")
   @Override
   public boolean isEnableRowEditOrder() {
      return this.psDEGridParamImpl.getEditMode() != null && (this.psDEGridParamImpl.getEditMode() & 256) == 256;
   }

   @PSModelRTMeta(description = "支持行编辑仅提交变化值", ignoredumpvalues = "false", model = "PSDEViewCtrl", fields = "CTRLPARAM6")
   @Override
   public boolean isEnableRowEditChangedOnly() {
      return this.psDEGridParamImpl.getEditMode() != null && (this.psDEGridParamImpl.getEditMode() & 2048) == 2048;
   }

   @PSModelRTMeta(description = "适应屏幕宽度", fields = "FORCEFIT")
   @Override
   public boolean isForceFit() {
      return this.bForceFit;
   }

   @PSModelRTMeta(description = "表格样式", codelist = "DEGridStyle", fields = "GRIDSTYLE")
   @Override
   public String getGridStyle() {
      return this.psDEGrid.getGRIDSTYLE();
   }

   @PSModelRTMeta(description = "默认禁用排序", fields = "NOSORT")
   @Override
   public boolean isNoSort() {
      return this.bNoSort;
   }

   @Override
   public IPSDEField getMinorSortPSDEF() {
      return this.minorPSDEField;
   }

   @PSModelRTMeta(description = "附加排序方向", codelist = "SortDir", fields = "MINORSORTDIR")
   @Override
   public String getMinorSortDir() {
      return this.strMinorSortDir;
   }

   @Override
   public String getModelScope() {
      return "DE";
   }

   @Override
   public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
      super.fillRelatedPSCodeLists(relatedPSCodeListList);

      for (IPSDEGridDataItem iPSDEGridDataItem : this.psDEGridDataItemMap.values()) {
         if (!StringHelper.IsNullOrEmpty(iPSDEGridDataItem.getCodeListId())) {
            relatedPSCodeListList.add(this.getPSDataEntity().getPSSystem().getPSCodeList(iPSDEGridDataItem.getCodeListId()));
         }

         if (iPSDEGridDataItem.getDataItemParams() != null) {
            IDataItemParam[] var7;
            int var6 = (var7 = iPSDEGridDataItem.getDataItemParams()).length;

            for (int var5 = 0; var5 < var6; var5++) {
               IDataItemParam iDataItemParam = var7[var5];
               if (!StringHelper.IsNullOrEmpty(iDataItemParam.getCodeListId())) {
                  relatedPSCodeListList.add(this.getPSDataEntity().getPSSystem().getPSCodeList(iDataItemParam.getCodeListId()));
               }
            }
         }
      }
   }

   @Override
   public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
      super.fillRelatedPSAppViews(relatedAppViewList);

      for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
         iPSDEGridColumn.fillRelatedPSAppViews(relatedAppViewList);
      }
   }

   @PSModelRTMeta(description = "隐藏表格头部", fields = "SHOWHEADER")
   @Override
   public boolean isHideHeader() {
      return this.bHideHeader;
   }

   @Override
   public boolean isStateful() {
      return true;
   }

   @Override
   public Iterator<IGridEditItem> getGridEditItems() {
      return this.gridEditItemList.iterator();
   }

   @PSModelRTMeta(description = "表格编辑项集合", modeltype = "PSDEGRIDEDITITEM", child = true, outputdoc = "false")
   @Override
   public Iterator<IPSDEGridEditItem> getPSDEGridEditItems() {
      return this.psDEGridEditItemMap.values().iterator();
   }

   @PSModelRTMeta(description = "表格编辑项更新集合", child = true, group = "部件逻辑", order = 210)
   @Override
   public Iterator<IPSDEGridEditItemUpdate> getPSDEGridEditItemUpdates() {
      return this.psDEGridEditItemUpdateMap.values().iterator();
   }

   @Override
   public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate(String strPSDEGridEditItemUpdateId) throws Exception {
      IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate = this.psDEGridEditItemUpdateMap.get(strPSDEGridEditItemUpdateId);
      if (strPSDEGridEditItemUpdateId == null) {
         throw new Exception(StringHelper.Format("无法获取指定表格编辑项更新[%1$s]", strPSDEGridEditItemUpdateId));
      } else {
         return iPSDEGridEditItemUpdate;
      }
   }

   protected void fillChildPSDEGridColumnList(IPSDEGridColumn iPSDEGridColumn, ArrayList<IPSDEGridColumn> psDEGridColumnList) throws Exception {
      if (iPSDEGridColumn instanceof IPSDEGridGroupColumn) {
         IPSDEGridGroupColumn iPSDEGridGroupColumn = (IPSDEGridGroupColumn)iPSDEGridColumn;
         Iterator<IPSDEGridColumn> psDEGridColumns = iPSDEGridGroupColumn.getPSDEGridColumns();
         if (psDEGridColumns != null) {
            while (psDEGridColumns.hasNext()) {
               IPSDEGridColumn childPSDEGridColumn = psDEGridColumns.next();
               psDEGridColumnList.add(childPSDEGridColumn);
               this.fillChildPSDEGridColumnList(childPSDEGridColumn, psDEGridColumnList);
            }
         }
      }
   }

   @Override
   public Iterator<IPSDEGridDataItem> getGroupPSDEGridDataItems() {
      return this.groupPSDEGridDataItemList != null && this.groupPSDEGridDataItemList.size() != 0 ? this.groupPSDEGridDataItemList.iterator() : null;
   }

   @PSModelRTMeta(description = "全部表格列集合", modeltype = "PSDEGRIDCOL", group = "部件元素", order = 160)
   @Override
   public Iterator<IPSDEGridColumn> getAllPSDEGridColumns() {
      return this.psDEGridColumnList3.iterator();
   }

   @PSModelRTMeta(description = "无值内容语言资源", fields = "EMPTYTEXTPSLANRESID")
   @Override
   public IPSLanguageRes getEmptyTextPSLanguageRes() {
      return this.emptyTextPSLanguageRes == null && this.getPSApplication() != null
         ? this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyTextPSLanguageRes()
         : this.emptyTextPSLanguageRes;
   }

   @PSModelRTMeta(description = "无值显示内容", fields = "EMPTYTEXT")
   @Override
   public String getEmptyText() {
      return StringHelper.IsNullOrEmpty(this.strEmptyText) && this.getPSApplication() != null
         ? this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyText()
         : this.strEmptyText;
   }

   @Override
   public String getModelType() {
      return "PSDEGRID";
   }

   protected boolean isFixWFDataItemsBug() {
      return (this.getPSSystemSetting().getEngineBugFixs() & 4) == 4;
   }

   @PSModelRTMeta(description = "输出预置流程数据项")
   @Override
   public boolean hasWFDataItems() {
      return this.bHasWFDataItems;
   }

   @PSModelRTMeta(description = "排序模式", codelist = "SortMode", fields = "SORTMODE")
   @Override
   public String getSortMode() {
      return this.strSortMode;
   }

   @PSModelRTMeta(description = "启用列过滤器", model = "PSDEViewCtrl", fields = "CTRLPARAM8")
   @Override
   public boolean isEnableColFilter() {
      return this.psDEGridParamImpl.isEnableColFilter() == null ? false : this.psDEGridParamImpl.isEnableColFilter();
   }

   @PSModelRTMeta(description = "建立数据行为", hideempty = true, child = true)
   @Override
   public IPSControlAction getCreatePSControlAction() {
      try {
         if (!this.isEnableRowEdit()) {
            return null;
         } else {
            return this.getPSAjaxControlHandler() != null ? this.getPSAjaxControlHandler().getPSAjaxHandlerAction("create", true) : null;
         }
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "更新数据行为", hideempty = true, child = true)
   @Override
   public IPSControlAction getUpdatePSControlAction() {
      try {
         if (!this.isEnableRowEdit()) {
            return null;
         } else {
            return this.getPSAjaxControlHandler() != null ? this.getPSAjaxControlHandler().getPSAjaxHandlerAction("update", true) : null;
         }
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "删除数据行为", hideempty = true, child = true)
   @Override
   public IPSControlAction getRemovePSControlAction() {
      try {
         return this.getPSAjaxControlHandler() != null ? this.getPSAjaxControlHandler().getPSAjaxHandlerAction("remove", true) : null;
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "移动数据行为", hideempty = true, child = true)
   @Override
   public IPSControlAction getMovePSControlAction() {
      try {
         return this.getPSAjaxControlHandler() != null ? this.getPSAjaxControlHandler().getPSAjaxHandlerAction("move", true) : null;
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "获取数据行为", hideempty = true, child = true)
   @Override
   public IPSControlAction getGetPSControlAction() {
      try {
         if (!this.isEnableRowEdit()) {
            return null;
         } else {
            return this.getPSAjaxControlHandler() != null ? this.getPSAjaxControlHandler().getPSAjaxHandlerAction("load", true) : null;
         }
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "获取草稿数据行为", hideempty = true, child = true)
   @Override
   public IPSControlAction getGetDraftPSControlAction() {
      try {
         if (!this.isEnableRowEdit()) {
            return null;
         } else {
            return this.getPSAjaxControlHandler() != null ? this.getPSAjaxControlHandler().getPSAjaxHandlerAction("loaddraft", true) : null;
         }
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "获取草稿数据行为（拷贝）", hideempty = true, child = true)
   @Override
   public IPSControlAction getGetDraftFromPSControlAction() {
      try {
         if (!this.isEnableRowEdit()) {
            return null;
         } else {
            return this.getPSAjaxControlHandler() != null ? this.getPSAjaxControlHandler().getPSAjaxHandlerAction("loaddraftfrom", true) : null;
         }
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "表格聚合模式", codelist = "GridAggMode")
   @Override
   public String getAggMode() {
      return this.strAggMode;
   }

   @PSModelRTMeta(description = "聚合服务实体对象", hideempty = true)
   @Override
   public IPSDataEntity getAggPSDataEntity() {
      return this.aggPSDataEntity;
   }

   @PSModelRTMeta(description = "聚合服务实体行为", hideempty = true, dump = false)
   @Override
   public IPSDEAction getAggPSDEAction() {
      return this.aggPSDEAction;
   }

   @PSModelRTMeta(description = "聚合服务实体数据集", hideempty = true, dump = false)
   @Override
   public IPSDEDataSet getAggPSDEDataSet() {
      return this.aggPSDEDataSet;
   }

   @PSModelRTMeta(description = "聚合服务应用实体对象", hideempty = true, dumpref = true, fields = "AGGPSDEID")
   @Override
   public IPSAppDataEntity getAggPSAppDataEntity() {
      return this.aggPSAppDataEntity;
   }

   @PSModelRTMeta(
      description = "聚合服务应用实体行为",
      hideempty = true,
      dumpref = false,
      from = "__self__",
      from_method = "getAggPSAppDataEntityMust().getPSAppDEAction"
   )
   @Override
   public IPSAppDEAction getAggPSAppDEAction() {
      return this.aggPSAppDEAction;
   }

   @PSModelRTMeta(
      description = "聚合服务应用实体数据集",
      hideempty = true,
      dumpref = true,
      from = "__self__",
      from_method = "getAggPSAppDataEntityMust().getPSAppDEDataSet",
      fields = "AGGPSDEDSID"
   )
   @Override
   public IPSAppDEDataSet getAggPSAppDEDataSet() {
      return this.aggPSAppDEDataSet;
   }

   @PSModelRTMeta(description = "数据属性集合", hideempty = true)
   @Override
   public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception {
      if (this.psAppDEFieldList == null) {
         Map<String, IPSAppDEField> psAppDEFieldMap = new LinkedHashMap<>();
         Iterator<IPSDEGridDataItem> psDEGridDataItems = this.getPSDEGridDataItems();
         if (psDEGridDataItems != null) {
            while (psDEGridDataItems.hasNext()) {
               IPSDEGridDataItem iPSDEGridDataItem = psDEGridDataItems.next();
               if (iPSDEGridDataItem.getPSAppDEField() != null) {
                  psAppDEFieldMap.put(iPSDEGridDataItem.getPSAppDEField().getName(), iPSDEGridDataItem.getPSAppDEField());
               }
            }
         }

         ArrayList<IPSAppDEField> psAppDEFieldList = new ArrayList<>();
         psAppDEFieldList.addAll(psAppDEFieldMap.values());
         Collections.sort(psAppDEFieldList, new Comparator<IPSAppDEField>() {
            public int compare(IPSAppDEField o1, IPSAppDEField o2) {
               return net.ibizsys.paas.util.StringHelper.compare(o1.getName(), o2.getName(), false);
            }
         });
         if (this.psAppDEFieldList == null) {
            this.psAppDEFieldList = psAppDEFieldList;
         }
      }

      return this.psAppDEFieldList.iterator();
   }

   @PSModelRTMeta(description = "列链接模式", codelist = "DEGridColLinkMode", fields = "COLENABLELINK")
   @Override
   public int getColumnEnableLink() {
      return this.nColumnEnableLink;
   }

   @Override
   protected String getQuickPSDEToolbarId() {
      return this.psDEGrid.getQUICKPSDETOOLBARID();
   }

   @Override
   protected String getBatchPSDEToolbarId() {
      return this.psDEGrid.getBATPSDETOOLBARID();
   }

   @Override
   public IPSDEGridColumn getPSDEGridColumn(String strPSDEGridColumnId, boolean bTryMode) throws Exception {
      if (this.psDEGridColumnList3 != null) {
         for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList3) {
            if (StringHelper.Compare(iPSDEGridColumn.getId(), strPSDEGridColumnId, false) == 0) {
               return iPSDEGridColumn;
            }

            if (StringHelper.Compare(iPSDEGridColumn.getName(), strPSDEGridColumnId, true) == 0) {
               return iPSDEGridColumn;
            }
         }
      }

      if (bTryMode) {
         return null;
      } else {
         throw new Exception(StringHelper.Format("无法获取指定表格列[%1$s]", strPSDEGridColumnId));
      }
   }

   @Override
   public IPSDEGridEditItem getPSDEGridEditItem(String strPSDEGridEditItemName, boolean bTryMode) throws Exception {
      IPSDEGridEditItem iPSDEGridEditItem = this.psDEGridEditItemMap.get(strPSDEGridEditItemName.toLowerCase());
      if (iPSDEGridEditItem == null && !bTryMode) {
         throw new Exception(StringHelper.Format("无法获取指定表格编辑项[%1$s]", strPSDEGridEditItemName));
      } else {
         return iPSDEGridEditItem;
      }
   }

   @PSModelRTMeta(description = "表格编辑项值规则集合", child = true, group = "部件逻辑", order = 215)
   @Override
   public Iterator<IPSDEGridEditItemVR> getPSDEGridEditItemVRs() {
      return this.psDEGridEditItemVRMap.values().iterator();
   }

   @Override
   public IPSDEGridEditItemVR getPSDEGridEditItemVR(String strPSDEGridEditItemVRId) throws Exception {
      IPSDEGridEditItemVR iPSDEGridEditItemVR = this.psDEGridEditItemVRMap.get(strPSDEGridEditItemVRId);
      if (strPSDEGridEditItemVRId == null) {
         throw new Exception(StringHelper.Format("无法获取指定表格编辑项值规则[%1$s]", strPSDEGridEditItemVRId));
      } else {
         return iPSDEGridEditItemVR;
      }
   }

   @PSModelRTMeta(description = "排序值属性")
   @Override
   public IPSDEField getOrderValuePSDEField() {
      return this.orderValuePSDEField;
   }

   @PSModelRTMeta(description = "排序值应用实体属性", dumpref = true, fields = "ORDERVALUEPSDEFID")
   @Override
   public IPSAppDEField getOrderValuePSAppDEField() {
      try {
         if (this.getPSAppDataEntity() != null && this.getOrderValuePSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getOrderValuePSDEField(), true);
         }
      } catch (Exception ex) {
         log.error(ex);
      }

      return null;
   }

   @PSModelRTMeta(description = "附加排序属性")
   @Override
   public IPSDEField getMinorSortPSDEField() {
      return this.getMinorSortPSDEF();
   }

   @Override
   public boolean isBufferRenderer() {
      return this.bBufferRenderer;
   }

   @PSModelRTMeta(description = "附加排序应用实体属性", dumpref = true, fields = "MINORSORTPSDEFID")
   @Override
   public IPSAppDEField getMinorSortPSAppDEField() {
      try {
         if (this.getPSAppDataEntity() != null && this.getMinorSortPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getMinorSortPSDEField(), true);
         }
      } catch (Exception ex) {
         log.error(ex);
      }

      return null;
   }

   @PSModelRTMeta(description = "分组模式", hideempty2 = true, codelist = "MDCtrlGroupMode", fields = "GROUPMODE")
   @Override
   public String getGroupMode() {
      return this.strGroupMode;
   }

   @PSModelRTMeta(description = "分组样式", hideempty2 = true, codelist = "CtrlGroupStyle", ignoredumpvalues = "DEFAULT", fields = "GROUPSTYLE")
   @Override
   public String getGroupStyle() {
      return this.strGroupStyle;
   }

   @PSModelRTMeta(description = "启用分组", doc = "计算{@link #getGroupMode}返回不等于(NONE)")
   @Override
   public boolean isEnableGroup() {
      return this.bEnableGroup;
   }

   @PSModelRTMeta(description = "分组应用实体属性", hideempty = true, dumpref = true, fields = "GROUPPSDEFID")
   @Override
   public IPSAppDEField getGroupPSAppDEField() {
      return this.groupPSAppDEField;
   }

   @PSModelRTMeta(description = "分组实体属性", hideempty = true, dumpref = true, ignorepf = true)
   @Override
   public IPSDEField getGroupPSDEField() {
      return this.groupPSDEField;
   }

   @PSModelRTMeta(description = "分组应用实体属性", hideempty = true, dumpref = true, fields = "GROUPTEXTPSDEFID")
   @Override
   public IPSAppDEField getGroupTextPSAppDEField() {
      return this.groupTextPSAppDEField;
   }

   @PSModelRTMeta(description = "分组文本实体属性", hideempty = true, dumpref = true, ignorepf = true)
   @Override
   public IPSDEField getGroupTextPSDEField() {
      return this.groupTextPSDEField;
   }

   @PSModelRTMeta(description = "分组代码表", hideempty = true, dumpref = true, fields = "GROUPPSCODELISTID")
   @Override
   public IPSCodeList getGroupPSCodeList() {
      return this.groupPSCodeList;
   }

   @PSModelRTMeta(description = "支持表格定制", model = "PSDEViewCtrl", fields = "CTRLPARAM7", doc = "未定义时使用应用全局定义{@link PSSysAppDTO#FIELD_GRIDENABLECUSTOMIZED}")
   @Override
   public boolean isEnableCustomized() {
      return this.bEnableCustomized;
   }

   @Override
   protected boolean isNeedFillPSACHandlerData() {
      return !this.isEnableRowEdit() && !this.isEnableUIModelEx()
            || StringHelper.IsNullOrEmpty(this.psDEGrid.getGETDRAFTPSDEACTIONID())
               && StringHelper.IsNullOrEmpty(this.psDEGrid.getCREATEPSDEACTIONID())
               && StringHelper.IsNullOrEmpty(this.psDEGrid.getGETPSDEACTIONID())
               && StringHelper.IsNullOrEmpty(this.psDEGrid.getUPDATEPSDEACTIONID())
               && StringHelper.IsNullOrEmpty(this.psDEGrid.getREMOVEPSDEACTIONID())
               && StringHelper.IsNullOrEmpty(this.psDEGrid.getMOVEPSDEACTIONID())
               && StringHelper.IsNullOrEmpty(this.psDEGrid.getCOPYPSDEACTIONID())
               && StringHelper.IsNullOrEmpty(this.psDEGrid.getUSERPSDEACTIONID())
               && StringHelper.IsNullOrEmpty(this.psDEGrid.getUSER2PSDEACTIONID())
         ? super.isNeedFillPSACHandlerData()
         : true;
   }

   @Override
   protected void fillPSACHandlerData(PSACHandler psACHandler) throws Exception {
      super.fillPSACHandlerData(psACHandler);
      if (StringHelper.IsNullOrEmpty(psACHandler.getGETDRAFTPSDEACTIONID()) && !StringHelper.IsNullOrEmpty(this.psDEGrid.getGETDRAFTPSDEACTIONID())) {
         psACHandler.setGETDRAFTPSDEACTIONID(this.psDEGrid.getGETDRAFTPSDEACTIONID());
         psACHandler.setGETDRAFTPSDEACTIONNAME(this.psDEGrid.getGETDRAFTPSDEACTIONNAME());
      }

      if (StringHelper.IsNullOrEmpty(psACHandler.getCREATEPSDEACTIONID()) && !StringHelper.IsNullOrEmpty(this.psDEGrid.getCREATEPSDEACTIONID())) {
         psACHandler.setCREATEPSDEACTIONID(this.psDEGrid.getCREATEPSDEACTIONID());
         psACHandler.setCREATEPSDEACTIONNAME(this.psDEGrid.getCREATEPSDEACTIONNAME());
      }

      if (StringHelper.IsNullOrEmpty(psACHandler.getGETPSDEACTIONID()) && !StringHelper.IsNullOrEmpty(this.psDEGrid.getGETPSDEACTIONID())) {
         psACHandler.setGETPSDEACTIONID(this.psDEGrid.getGETPSDEACTIONID());
         psACHandler.setGETPSDEACTIONNAME(this.psDEGrid.getGETPSDEACTIONNAME());
      }

      if (StringHelper.IsNullOrEmpty(psACHandler.getUPDATEPSDEACTIONID()) && !StringHelper.IsNullOrEmpty(this.psDEGrid.getUPDATEPSDEACTIONID())) {
         psACHandler.setUPDATEPSDEACTIONID(this.psDEGrid.getUPDATEPSDEACTIONID());
         psACHandler.setUPDATEPSDEACTIONNAME(this.psDEGrid.getUPDATEPSDEACTIONNAME());
      }

      if (StringHelper.IsNullOrEmpty(psACHandler.getREMOVEPSDEACTIONID()) && !StringHelper.IsNullOrEmpty(this.psDEGrid.getREMOVEPSDEACTIONID())) {
         psACHandler.setREMOVEPSDEACTIONID(this.psDEGrid.getREMOVEPSDEACTIONID());
         psACHandler.setREMOVEPSDEACTIONNAME(this.psDEGrid.getREMOVEPSDEACTIONNAME());
      }

      if (StringHelper.IsNullOrEmpty(psACHandler.getMOVEPSDEACTIONID()) && !StringHelper.IsNullOrEmpty(this.psDEGrid.getMOVEPSDEACTIONID())) {
         psACHandler.setMOVEPSDEACTIONID(this.psDEGrid.getMOVEPSDEACTIONID());
         psACHandler.setMOVEPSDEACTIONNAME(this.psDEGrid.getMOVEPSDEACTIONNAME());
      }

      if (StringHelper.IsNullOrEmpty(psACHandler.getCOPYPSDEACTIONID()) && !StringHelper.IsNullOrEmpty(this.psDEGrid.getCOPYPSDEACTIONID())) {
         psACHandler.setCOPYPSDEACTIONID(this.psDEGrid.getCOPYPSDEACTIONID());
         psACHandler.setCOPYPSDEACTIONNAME(this.psDEGrid.getCOPYPSDEACTIONNAME());
      }

      if (StringHelper.IsNullOrEmpty(psACHandler.getUSERPSDEACTIONID()) && !StringHelper.IsNullOrEmpty(this.psDEGrid.getUSERPSDEACTIONID())) {
         psACHandler.setUSERPSDEACTIONID(this.psDEGrid.getUSERPSDEACTIONID());
         psACHandler.setUSERPSDEACTIONNAME(this.psDEGrid.getUSERPSDEACTIONNAME());
      }

      if (StringHelper.IsNullOrEmpty(psACHandler.getUSER2PSDEACTIONID()) && !StringHelper.IsNullOrEmpty(this.psDEGrid.getUSER2PSDEACTIONID())) {
         psACHandler.setUSER2PSDEACTIONID(this.psDEGrid.getUSER2PSDEACTIONID());
         psACHandler.setUSER2PSDEACTIONNAME(this.psDEGrid.getUSER2PSDEACTIONNAME());
      }
   }

   protected String getAggPSSysLayoutPanelId() {
      return this.strAggPSSysViewPanelId;
   }

   protected void onPrepareAggPSLayoutPanel() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.getAggPSSysLayoutPanelId())) {
         if (this.isRegisterPSLayoutPanel()) {
            PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
            psSysPanelParamImpl.setPSSysPanelId(this.getAggPSSysLayoutPanelId());
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("PANEL");
            IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), this, "agglayoutpanel", psSysPanelParamImpl);
            this.aggPSLayoutPanel = (IPSSysLayoutPanel)iPSControl;
            this.registerPSLayoutPanel(this.aggPSLayoutPanel);
         } else {
            PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
            psSysPanelParamImpl.setPSSysPanelId(this.getAggPSSysLayoutPanelId());
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("VIEWLAYOUTPANEL");
            IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), this.getPSControlContainer(), "agglayoutpanel", psSysPanelParamImpl);
            this.aggPSLayoutPanel = (IPSSysLayoutPanel)iPSControl;
         }
      }
   }

   @PSModelRTMeta(description = "聚合数据布局面板", child = true)
   @Override
   public IPSLayoutPanel getAggPSLayoutPanel() {
      return this.aggPSLayoutPanel;
   }

   @PSModelRTMeta(description = "列过滤器模式", codelist = "DEGridColLinkMode", fields = "COLENABLEFILTER")
   @Override
   public int getColumnEnableFilter() {
      return this.nColumnEnableFilter;
   }

   @PSModelRTMeta(description = "表格逻辑集合", group = "部件逻辑", order = 217)
   @Override
   public Iterator<? extends IPSDEGridLogic> getPSDEGridLogics() {
      return this.psDEGridLogicList != null && this.psDEGridLogicList.size() != 0 ? this.psDEGridLogicList.iterator() : null;
   }

   @Override
   protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
      return this.psDEGridLogicList != null && this.psDEGridLogicList.size() != 0 ? this.psDEGridLogicList.iterator() : null;
   }

   @PSModelRTMeta(description = "固定起始列数", ignoredumpvalues = "0", fields = "FROZENCOL")
   @Override
   public int getFrozenFirstColumn() {
      return !this.psDEGrid.isFROZENCOLNull() && this.psDEGrid.getFROZENCOL() > 0 ? this.psDEGrid.getFROZENCOL() : 0;
   }

   @PSModelRTMeta(description = "固定末尾列数", ignoredumpvalues = "0", fields = "FROZENLASTCOL")
   @Override
   public int getFrozenLastColumn() {
      return !this.psDEGrid.isFROZENLASTCOLNull() && this.psDEGrid.getFROZENLASTCOL() > 0 ? this.psDEGrid.getFROZENLASTCOL() : 0;
   }
}
