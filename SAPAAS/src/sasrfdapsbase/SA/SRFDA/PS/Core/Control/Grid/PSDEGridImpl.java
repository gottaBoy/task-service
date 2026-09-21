/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.grid.IGridColumn
 *  net.ibizsys.paas.control.grid.IGridDataItem
 *  net.ibizsys.paas.control.grid.IGridEditItem
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.HiddenPSDEGridEditItemImpl;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemVR;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridFieldColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridGroupColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridLogic;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridParam;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridDataItemImpl;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridEditItemUpdateImpl;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridEditItemVRImpl;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridLogicImpl;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridParamImpl;
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
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
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
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"GRID"})
public class PSDEGridImpl
extends PSMDAjaxControlContainerImpl2
implements IPSDEGrid {
    private static final Log log = LogFactory.getLog(PSDEGridImpl.class);
    protected PSDEGrid psDEGrid;
    protected ArrayList<IPSDEGridColumn> psDEGridColumnList = new ArrayList();
    protected ArrayList<IPSDEGridColumn> psDEGridColumnList2 = new ArrayList();
    protected ArrayList<IPSDEGridColumn> psDEGridColumnList3 = new ArrayList();
    protected ArrayList<IGridColumn> gridColumnList = new ArrayList();
    protected Map<String, IPSDEGridDataItem> psDEGridDataItemMap = new LinkedHashMap<String, IPSDEGridDataItem>();
    protected ArrayList<IGridDataItem> gridDataItemList = new ArrayList();
    protected Map<String, IPSDEGridEditItem> psDEGridEditItemMap = new LinkedHashMap<String, IPSDEGridEditItem>();
    protected ArrayList<IGridEditItem> gridEditItemList = new ArrayList();
    protected Map<String, IPSDEGridEditItemUpdate> psDEGridEditItemUpdateMap = new LinkedHashMap<String, IPSDEGridEditItemUpdate>();
    protected PSDEGridParamImpl psDEGridParamImpl = new PSDEGridParamImpl();
    protected String strCodeName = "";
    protected boolean bForceFit = false;
    protected String strGridStyle = "";
    protected boolean bNoSort = false;
    protected IPSDEField minorPSDEField = null;
    protected String strMinorSortDir = "";
    private boolean bHideHeader = false;
    protected ArrayList<IPSDEGridDataItem> groupPSDEGridDataItemList = new ArrayList();
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
    private HashMap<String, IPSDEGridEditItemVR> psDEGridEditItemVRMap = new HashMap();
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
    protected List<PSDEGridLogicImpl> psDEGridLogicList = new ArrayList<PSDEGridLogicImpl>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEGridParam iPSDEGridParam = (IPSDEGridParam)iPSControlParam;
            this.psDEGrid = new PSDEGrid();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEGridParam.getPSDEGridId())) {
                CallResult callResult = this.getPSModelHelper().getPSDEGrid(iPSDEGridParam.getPSDEGridId(), this.psDEGrid);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psDEGrid.getPSDEGRIDID());
            } else {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psDEGrid.getPSDEGRIDNAME());
            this.setPSObjectData(this.psDEGrid);
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getPSDEID()) || this.getPSDataEntity() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEGrid.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0)) {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEGrid.getPSDEID()));
            }
            this.psDEGridParamImpl.setPSAjaxControlHandlerId(this.psDEGrid.getPSACHANDLERID());
            this.psDEGridParamImpl.setPSDEDataSetId(this.psDEGrid.getPSDEDATASETID());
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getPSDEDATASETID()) && this.getPSDataEntity() != null && this.getPSDataEntity().getDefaultPSDEDataSet() != null) {
                this.psDEGridParamImpl.setPSDEDataSetId(this.getPSDataEntity().getDefaultPSDEDataSet().getId());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridParamImpl.getPSDEDataSetId())) {
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
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.setCheckControlDataSet(true);
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psDEGridParamImpl);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
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
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.setId(this.psDEGrid.getPSDEGRIDID());
        this.setName(strGridId);
        this.psDEGridParamImpl.setPSAjaxControlHandlerId(this.psDEGrid.getPSACHANDLERID());
        this.psDEGridParamImpl.setPSDEDataSetId(this.psDEGrid.getPSDEDATASETID());
        this.strCodeName = this.psDEGrid.getCODENAME();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.getName();
        }
        if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
            String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
            this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
        }
        this.setCheckControlDataSet(false);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        String strMinorSortPSDEFName;
        if (!this.psDEGrid.isFORCEFITNull()) {
            this.bForceFit = this.psDEGrid.getFORCEFIT();
        } else if (this.getPSAppView() != null) {
            this.bForceFit = this.getPSAppView().getPSApplication().getPSApplicationUI().isGridForceFit();
        }
        this.bEnableCustomized = this.psDEGridParamImpl.isEnableCustomized() != null ? this.psDEGridParamImpl.isEnableCustomized() : (!this.psDEGrid.isENABLECUSTOMIZEDNull() ? this.psDEGrid.getENABLECUSTOMIZED() : this.getPSAppView().getPSApplication().getPSApplicationUI().isGridEnableCustomized());
        this.strGridStyle = this.psDEGrid.getGRIDSTYLE();
        if (!this.psDEGrid.isNOSORTNull()) {
            this.bNoSort = this.psDEGrid.getNOSORT();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getSORTMODE())) {
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getAGGMODE())) {
            this.strAggMode = this.psDEGrid.getAGGMODE();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getAggMode()) && SA.SRFramework.Utility.StringHelper.Compare((String)this.getAggMode(), (String)"NONE", (boolean)false) != 0) {
            this.strAggPSSysViewPanelId = this.psDEGrid.getAGGPSSYSVIEWPANELID();
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getAggMode(), (String)"ALL", (boolean)false) == 0) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getAGGPSDEID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u805a\u5408\u670d\u52a1\u5b9e\u4f53\u5bf9\u8c61");
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getAGGPSDEDSID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getAGGPSDEACTIONID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u805a\u5408\u670d\u52a1\u5b9e\u4f53\u96c6\u5408\u5bf9\u8c61");
                }
                this.aggPSDataEntity = this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEGrid.getAGGPSDEID());
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getAGGPSDEACTIONID())) {
                    this.aggPSDEAction = this.getAggPSDataEntity().getPSDEAction(this.psDEGrid.getAGGPSDEACTIONID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getAGGPSDEDSID())) {
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getGROUPMODE())) {
            this.strGroupMode = this.psDEGrid.getGROUPMODE();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupMode(), (String)"NONE", (boolean)false) != 0) {
            this.bEnableGroup = true;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getGROUPPSDEFID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5206\u7ec4\u5c5e\u6027");
            }
            this.groupPSDEField = this.getPSDataEntity().getPSDEField(this.psDEGrid.getGROUPPSDEFID());
            this.groupPSCodeList = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getGROUPPSCODELISTID()) ? this.getPSDataEntity().getPSSystem().getPSCodeList(this.psDEGrid.getGROUPPSCODELISTID()) : this.groupPSDEField.getPSCodeList();
            if (this.groupPSCodeList != null) {
                this.groupPSCodeList = this.getPSAppView().getPSApplication().getPSCodeList(this.groupPSCodeList, true);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getGROUPTEXTPSDEFID())) {
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getEMPTYTEXTPSLANRESID())) {
            this.emptyTextPSLanguageRes = this.getPSApplication() != null ? this.getPSApplication().getPSLanguageRes(this.psDEGrid.getEMPTYTEXTPSLANRESID()) : this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEGrid.getEMPTYTEXTPSLANRESID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strMinorSortPSDEFName = this.psDEGrid.getMINORSORTPSDEFNAME()))) {
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(strMinorSortPSDEFName);
            this.strMinorSortDir = this.psDEGrid.getMINORSORTDIR();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strMinorSortDir)) {
                this.strMinorSortDir = "ASC";
            }
        }
        this.orderValuePSDEField = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getORDERVALUEPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psDEGrid.getORDERVALUEPSDEFID()) : this.getPSDataEntity().getOrderValuePSDEField();
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
        IPSDEGridFieldColumn iPSDEGridFieldColumn;
        IPSDEGridColumn iPSDEGridColumn;
        Object iPSDEGridColumnType;
        this.psDEGridColumnList.clear();
        this.gridColumnList.clear();
        this.psDEGridColumnList2.clear();
        this.groupPSDEGridDataItemList.clear();
        this.psDEGridColumnList3.clear();
        Vector<PSDEGridColumn> psDEGridColumnList = new Vector<PSDEGridColumn>();
        CallResult callResult = this.getPSModelHelper().getPSDEGridColumns(this.getId(), psDEGridColumnList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u5217\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        boolean bKeyColumn = false;
        HashMap<String, PSDEGridColumn> psDEGridColumnMap = new HashMap<String, PSDEGridColumn>();
        for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            psDEGridColumnMap.put(psDEGridColumn.getPSDEGRIDCOLID(), psDEGridColumn);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEGridColumn.getPSDEGRIDCOLNAME(), (String)"srfkey", (boolean)true) != 0) continue;
            bKeyColumn = true;
            break;
        }
        for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEGridColumn.getPPSDEGRIDCOLID()) || !psDEGridColumn.isHIDDENDATAITEMNull() && psDEGridColumn.getHIDDENDATAITEM()) continue;
            PSDEGridColumn parentPSDEGridColumn = (PSDEGridColumn)((Object)psDEGridColumnMap.get(psDEGridColumn.getPPSDEGRIDCOLID()));
            if (parentPSDEGridColumn != null) {
                parentPSDEGridColumn.getChildPSDEGridColumns(true).add(psDEGridColumn);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u683c\u7236\u5217[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDEGridColumn.getPPSDEGRIDCOLID()), "PSDEGRIDCOL", "REMOVE", psDEGridColumn.getPSDEGRIDCOLID());
        }
        for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEGridColumn.getPPSDEGRIDCOLID()) && (psDEGridColumn.isHIDDENDATAITEMNull() || !psDEGridColumn.getHIDDENDATAITEM())) continue;
            iPSDEGridColumnType = this.getPSModelStorage().getPSDEGridColumnType(psDEGridColumn.getGRIDCOLTYPE());
            iPSDEGridColumn = iPSDEGridColumnType.createPSDEGridColumn(psDEGridColumn);
            iPSDEGridColumn.init(this.getDAGlobalHelper(), this, null, psDEGridColumn);
            if (iPSDEGridColumn.isHiddenDataItem()) {
                this.psDEGridColumnList2.add(iPSDEGridColumn);
                continue;
            }
            this.psDEGridColumnList.add(iPSDEGridColumn);
        }
        for (IPSDEGridColumn iPSDEGridColumn2 : this.psDEGridColumnList) {
            this.fillChildPSDEGridColumnList(iPSDEGridColumn2, this.psDEGridColumnList2);
        }
        HashMap<String, IPSDEGridFieldColumn> groupPSDEGridColumnMap = new HashMap<String, IPSDEGridFieldColumn>();
        for (IPSDEGridColumn iPSDEGridColumn3 : this.psDEGridColumnList) {
            if (!(iPSDEGridColumn3 instanceof IPSDEGridFieldColumn) || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(iPSDEGridFieldColumn = (IPSDEGridFieldColumn)iPSDEGridColumn3).getGroupItem())) continue;
            groupPSDEGridColumnMap.put(iPSDEGridFieldColumn.getGroupItem(), iPSDEGridFieldColumn);
        }
        for (IPSDEGridColumn iPSDEGridColumn3 : this.psDEGridColumnList2) {
            if (!(iPSDEGridColumn3 instanceof IPSDEGridFieldColumn) || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(iPSDEGridFieldColumn = (IPSDEGridFieldColumn)iPSDEGridColumn3).getGroupItem())) continue;
            groupPSDEGridColumnMap.put(iPSDEGridFieldColumn.getGroupItem(), iPSDEGridFieldColumn);
        }
        int i = 1;
        while (i <= 4) {
            Iterator<IPSDEGridDataItem> psDEGridDataItems;
            String strGroupItem = SA.SRFramework.Utility.StringHelper.Format((String)"GROUP%1$s", (Object)i);
            iPSDEGridFieldColumn = (IPSDEGridFieldColumn)groupPSDEGridColumnMap.get(strGroupItem);
            if (iPSDEGridFieldColumn != null && (psDEGridDataItems = iPSDEGridFieldColumn.getPSDEGridDataItems()) != null) {
                while (psDEGridDataItems.hasNext()) {
                    this.groupPSDEGridDataItemList.add(psDEGridDataItems.next());
                }
            }
            ++i;
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
            iPSDEGridColumnType = this.getPSModelStorage().getPSDEGridColumnType(psDEGridColumn.getGRIDCOLTYPE());
            iPSDEGridColumn = iPSDEGridColumnType.createPSDEGridColumn(psDEGridColumn);
            iPSDEGridColumn.init(this.getDAGlobalHelper(), this, null, psDEGridColumn);
            this.psDEGridColumnList2.add(iPSDEGridColumn);
        }
        this.gridColumnList.addAll(this.psDEGridColumnList);
        for (IPSDEGridColumn iPSDEGridColumn4 : this.psDEGridColumnList) {
            this.fillAllPSDEGridColumnList(iPSDEGridColumn4, this.psDEGridColumnList3);
        }
    }

    protected void fillAllPSDEGridColumnList(IPSDEGridColumn iPSDEGridColumn, ArrayList<IPSDEGridColumn> psDEGridColumnList) {
        IPSDEGridGroupColumn iPSDEGridGroupColumn;
        Iterator<IPSDEGridColumn> psDEGridColumns;
        psDEGridColumnList.add(iPSDEGridColumn);
        if (iPSDEGridColumn instanceof IPSDEGridGroupColumn && (psDEGridColumns = (iPSDEGridGroupColumn = (IPSDEGridGroupColumn)iPSDEGridColumn).getPSDEGridColumns()) != null) {
            while (psDEGridColumns.hasNext()) {
                this.fillAllPSDEGridColumnList(psDEGridColumns.next(), psDEGridColumnList);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void onPreparePSDEGridDataItems() throws Exception {
        this.psDEGridDataItemMap.clear();
        this.gridDataItemList.clear();
        bAddFKey = true;
        bAddDataAccAction = true;
        bEditModeItem = false;
        nIgnoreDSItem = this.psDEGrid.getIGNOREDSITEM();
        if ((nIgnoreDSItem & 1) > 0) {
            bAddFKey = false;
        }
        if ((nIgnoreDSItem & 1024) > 0) {
            bAddDataAccAction = false;
        }
        bUseDTO = false;
        if (this.getPSApplication() != null) {
            bUseDTO = this.getPSApplication().isUseServiceApi();
        }
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
            psDEGridDataItems = iPSDEGridColumn.getPSDEGridDataItems();
            if (psDEGridDataItems != null) ** GOTO lbl22
            continue;
lbl-1000:
            // 1 sources

            {
                iPSDEGridDataItem = psDEGridDataItems.next();
                if (this.psDEGridDataItemMap.containsKey(iPSDEGridDataItem.getName())) continue;
                this.psDEGridDataItemMap.put(iPSDEGridDataItem.getName(), iPSDEGridDataItem);
lbl22:
                // 3 sources

                ** while (psDEGridDataItems.hasNext())
            }
lbl23:
            // 1 sources

        }
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList2) {
            psDEGridDataItems = iPSDEGridColumn.getPSDEGridDataItems();
            if (psDEGridDataItems != null) ** GOTO lbl32
            continue;
lbl-1000:
            // 1 sources

            {
                iPSDEGridDataItem = psDEGridDataItems.next();
                if (this.psDEGridDataItemMap.containsKey(iPSDEGridDataItem.getName())) continue;
                this.psDEGridDataItemMap.put(iPSDEGridDataItem.getName(), iPSDEGridDataItem);
lbl32:
                // 3 sources

                ** while (psDEGridDataItems.hasNext())
            }
lbl33:
            // 1 sources

        }
        if (!this.psDEGridDataItemMap.containsKey("srfkey")) {
            psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName("srfkey");
            if (!bUseDTO) {
                psDEGridDataItemImpl.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psDEGridDataItemImpl.setFormat("");
            }
            psItemParamImpl = new PSDataItemParamImpl();
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
            psDEGridDataItemImpl = new PSDEGridDataItemImpl();
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
            psItemParamImpl = new PSDataItemParamImpl();
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
        psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            iPSDEField = psDEFields.next();
            if (!iPSDEField.isQueryColumn()) continue;
            iPSAppDEField = null;
            if (bUseDTO && this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) == null) continue;
            if (iPSDEField.isIndexTypeDEField() || iPSDEField.isMultiFormDEField()) {
                if (!bEditModeItem) {
                    bEditModeItem = true;
                    if (!this.psDEGridDataItemMap.containsKey("srfdatatype")) {
                        psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                        psDEGridDataItemImpl.setName("srfdatatype");
                        if (iPSAppDEField == null) {
                            psDEGridDataItemImpl.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psDEGridDataItemImpl.setFormat("");
                        }
                        psItemParamImpl = new PSDataItemParamImpl();
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
                    psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                    psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                    if (iPSAppDEField == null) {
                        psDEGridDataItemImpl.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                    } else {
                        psDEGridDataItemImpl.setFormat("");
                    }
                    psItemParamImpl = new PSDataItemParamImpl();
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
            if (!bAddFKey || SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0 || this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) continue;
            psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
            if (iPSAppDEField == null) {
                psDEGridDataItemImpl.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psDEGridDataItemImpl.setFormat("");
            }
            psItemParamImpl = new PSDataItemParamImpl();
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
        if (!this.psDEGridDataItemMap.containsKey("srfmajortext") && this.getPSDataEntity().getMajorPSDEField() != null) {
            iPSAppDEField = null;
            bAddDEGridDataItem = true;
            if (bUseDTO && this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getMajorPSDEField(), true)) == null) {
                bAddDEGridDataItem = false;
            }
            if (bAddDEGridDataItem) {
                psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                psDEGridDataItemImpl.setName("srfmajortext");
                if (iPSAppDEField == null) {
                    psDEGridDataItemImpl.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psDEGridDataItemImpl.setFormat("");
                }
                psItemParamImpl = new PSDataItemParamImpl();
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
        bOutputMSTag = true;
        if (this.getPSDataEntity().getAllPSDEWFs() != null) {
            psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
            while (psDEWFs.hasNext()) {
                iPSDEWF = psDEWFs.next();
                if (iPSDEWF.getWFStepPSDEField() != null) {
                    iPSDEField = iPSDEWF.getWFStepPSDEField();
                    iPSAppDEField = null;
                    if (bUseDTO && this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) == null) continue;
                    if (!this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                        psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                        psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                        if (iPSAppDEField == null) {
                            psDEGridDataItemImpl.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psDEGridDataItemImpl.setFormat("");
                        }
                        psItemParamImpl = new PSDataItemParamImpl();
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
                    iPSDEField = iPSDEWF.getUDStatePSDEField();
                    iPSAppDEField = null;
                    if (bUseDTO && this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) == null) continue;
                    if (!this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                        psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                        psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                        if (iPSAppDEField == null) {
                            psDEGridDataItemImpl.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psDEGridDataItemImpl.setFormat("");
                        }
                        psItemParamImpl = new PSDataItemParamImpl();
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
                if (iPSDEWF.getWFVerPSDEField() == null) continue;
                iPSDEField = iPSDEWF.getWFVerPSDEField();
                iPSAppDEField = null;
                if (bUseDTO && this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) == null || this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) continue;
                psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                if (iPSAppDEField == null) {
                    psDEGridDataItemImpl.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psDEGridDataItemImpl.setFormat("");
                }
                psItemParamImpl = new PSDataItemParamImpl();
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
        if (this.isFixWFDataItemsBug() && this.getPSAppView() != null && this.getPSAppView() instanceof IPSAppDEWFView && (iPSDEWF = ((IPSAppDEWFView)this.getPSAppView()).getPSDEWF()) != null) {
            this.bHasWFDataItems = true;
            if (iPSDEWF.getWFStepPSDEField() != null) {
                iPSDEField = iPSDEWF.getWFStepPSDEField();
                iPSAppDEField = null;
                bAddDEGridDataItem = true;
                if (bUseDTO && this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) == null) {
                    bAddDEGridDataItem = false;
                }
                if (bAddDEGridDataItem && !this.psDEGridDataItemMap.containsKey("srfwfstep")) {
                    psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                    psDEGridDataItemImpl.setName("srfwfstep");
                    if (iPSAppDEField == null) {
                        psDEGridDataItemImpl.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                    } else {
                        psDEGridDataItemImpl.setFormat("");
                    }
                    psItemParamImpl = new PSDataItemParamImpl();
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
                iPSDEField = iPSDEWF.getWFVerPSDEField();
                iPSAppDEField = null;
                bAddDEGridDataItem = true;
                if (bUseDTO && this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) == null) {
                    bAddDEGridDataItem = false;
                }
                if (bAddDEGridDataItem && !this.psDEGridDataItemMap.containsKey("srfwfver")) {
                    psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                    psDEGridDataItemImpl.setName("srfwfver");
                    if (iPSAppDEField == null) {
                        psDEGridDataItemImpl.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                    } else {
                        psDEGridDataItemImpl.setFormat("");
                    }
                    psItemParamImpl = new PSDataItemParamImpl();
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
        if (this.getPSDataEntity().isEnableDEMainState()) {
            psDEGridDataItemImpl = new PSDEGridDataItemImpl();
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
        ArrayList<String> valueItemList = new ArrayList<String>();
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
            if (!iPSDEGridColumn.isEnableRowEdit() || iPSDEGridColumn.getPSDEGridEditItem() == null) continue;
            this.psDEGridEditItemMap.put(iPSDEGridColumn.getPSDEGridEditItem().getName(), iPSDEGridColumn.getPSDEGridEditItem());
        }
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList2) {
            if (!iPSDEGridColumn.isEnableRowEdit() || iPSDEGridColumn.getPSDEGridEditItem() == null) continue;
            this.psDEGridEditItemMap.put(iPSDEGridColumn.getPSDEGridEditItem().getName(), iPSDEGridColumn.getPSDEGridEditItem());
        }
        this.gridEditItemList.addAll(this.psDEGridEditItemMap.values());
        for (IGridEditItem iGridEditItem : this.gridEditItemList) {
            IPSDEGridDataItem iPSDEDataGridDataItem;
            String[] valueItemNames = ((IPSDEGridEditItem)iGridEditItem).getValueItemNames();
            if (valueItemNames == null) continue;
            String[] stringArray = valueItemNames;
            int n = valueItemNames.length;
            int n2 = 0;
            while (n2 < n) {
                String strValueItemName = stringArray[n2];
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValueItemName) && !valueItemList.contains(strValueItemName.toLowerCase())) {
                    valueItemList.add(strValueItemName.toLowerCase());
                }
                ++n2;
            }
            if (!bUseDTO || !(iGridEditItem.getDataItem() instanceof IPSDEGridDataItem) || this.psDEGridDataItemMap.containsKey((iPSDEDataGridDataItem = (IPSDEGridDataItem)iGridEditItem.getDataItem()).getName())) continue;
            this.psDEGridDataItemMap.put(iPSDEDataGridDataItem.getName(), iPSDEDataGridDataItem);
        }
        for (String strValueItem : valueItemList) {
            IPSDEGridDataItem iPSDEDataGridDataItem;
            if (this.psDEGridEditItemMap.containsKey(strValueItem)) continue;
            IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strValueItem);
            HiddenPSDEGridEditItemImpl hiddenPSDEGridEditItemImpl = new HiddenPSDEGridEditItemImpl();
            hiddenPSDEGridEditItemImpl.init(this.getDAGlobalHelper(), this, iPSDEField);
            this.psDEGridEditItemMap.put(hiddenPSDEGridEditItemImpl.getName(), hiddenPSDEGridEditItemImpl);
            this.gridEditItemList.add(hiddenPSDEGridEditItemImpl);
            if (!bUseDTO || !(hiddenPSDEGridEditItemImpl.getDataItem() instanceof IPSDEGridDataItem) || this.psDEGridDataItemMap.containsKey((iPSDEDataGridDataItem = (IPSDEGridDataItem)hiddenPSDEGridEditItemImpl.getDataItem()).getName())) continue;
            this.psDEGridDataItemMap.put(iPSDEDataGridDataItem.getName(), iPSDEDataGridDataItem);
        }
    }

    protected void onPreparePSDEGridEditItemUpdates() throws Exception {
        this.psDEGridEditItemUpdateMap.clear();
        Vector<PSDEGEIUpdate> psDEGEIUpdateList = new Vector<PSDEGEIUpdate>();
        CallResult callResult = this.getPSModelHelper().getPSDEGEIUpdates(this.getId(), psDEGEIUpdateList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDEGEIUpdateList.size() == 0) {
            return;
        }
        HashMap<String, PSDEGEIUpdate> psDEGEIUpdateMap = new HashMap<String, PSDEGEIUpdate>();
        for (PSDEGEIUpdate psDEGEIUpdate : psDEGEIUpdateList) {
            psDEGEIUpdateMap.put(psDEGEIUpdate.getPSDEGEIUPDATEID(), psDEGEIUpdate);
        }
        Vector<PSDEGEIUDetail> psDEGEIUDetailList = new Vector<PSDEGEIUDetail>();
        callResult = this.getPSModelHelper().getPSDEGEIUDetails(this.getId(), psDEGEIUDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEGEIUDetail psDEGEIUDetail : psDEGEIUDetailList) {
            PSDEGEIUpdate psDEGEIUpdate = (PSDEGEIUpdate)((Object)psDEGEIUpdateMap.get(psDEGEIUDetail.getPSDEGEIUPDATEID()));
            if (psDEGEIUpdate != null) {
                psDEGEIUpdate.getPSDEGEIUDetails(true).add(psDEGEIUDetail);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDEGEIUDetail.getPSDEGEIUPDATEID()), "PSDEGEIUDETAIL", "REMOVE", psDEGEIUDetail.getPSDEGEIUDETAILID());
        }
        for (PSDEGEIUpdate psDEGEIUpdate : psDEGEIUpdateList) {
            PSDEGridEditItemUpdateImpl psDEGEIUpdateImpl = new PSDEGridEditItemUpdateImpl();
            psDEGEIUpdateImpl.init(this.getDAGlobalHelper(), this, psDEGEIUpdate);
            this.psDEGridEditItemUpdateMap.put(psDEGEIUpdateImpl.getId(), psDEGEIUpdateImpl);
        }
    }

    protected void onPreparePSDEGridEditItemVRs() throws Exception {
        this.psDEGridEditItemVRMap.clear();
        this.onPreparePSDEGridEditItemVRs(this.getId());
    }

    protected void onPreparePSDEGridEditItemVRs(String strPSDEFormId) throws Exception {
        Vector<PSDEGridEditItemVR> psDEGridEditItemVRList = new Vector<PSDEGridEditItemVR>();
        CallResult callResult = this.getPSModelHelper().getPSDEGridEditItemVRs(strPSDEFormId, psDEGridEditItemVRList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u7f16\u8f91\u9879\u503c\u89c4\u5219\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
        Vector<PSDEGridLogic> psDEGridLogicList = new Vector<PSDEGridLogic>();
        CallResult callResult = this.getPSModelHelper().getPSDEGridLogics(strPSDEGridId, psDEGridLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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

    public Iterator<IGridColumn> getGridColumns() {
        return this.gridColumnList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u96c6\u5408", modeltype="PSDEGRIDCOL", child=true, outputdoc="false")
    public Iterator<IPSDEGridColumn> getPSDEGridColumns() {
        return this.psDEGridColumnList.iterator();
    }

    public Iterator<IGridDataItem> getGridDataItems() {
        return this.gridDataItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u6570\u636e\u9879\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=163)
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        return this.psDEGridDataItemMap.values().iterator();
    }

    @Override
    public IPSDEGridDataItem getPSDEGridDataItem(String strPSDEGridDataItemName, boolean bTryMode) throws Exception {
        IPSDEGridDataItem iPSDEGridDataItem = this.psDEGridDataItemMap.get(strPSDEGridDataItemName.toLowerCase());
        if (iPSDEGridDataItem != null || bTryMode) {
            return iPSDEGridDataItem;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u683c\u6570\u636e\u9879[%1$s]", (Object)strPSDEGridDataItemName));
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u90e8\u4ef6\u53c2\u6570")
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEGridParamImpl;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5206\u9875\u680f", fields={"ENABLEPAGINGBAR"})
    public boolean isEnablePagingBar() {
        if (this.psDEGrid.isENABLEPAGINGBARNull()) {
            return false;
        }
        return this.psDEGrid.getENABLEPAGINGBAR() == 1;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u6a21\u5f0f", codelist="PagingMode", ignoredumpvalues="0")
    public int getPagingMode() {
        if (this.psDEGrid.isENABLEPAGINGBARNull()) {
            return 0;
        }
        return this.psDEGrid.getENABLEPAGINGBAR();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u5927\u5c0f", fields={"PAGINGSIZE"})
    public int getPagingSize() {
        if (this.psDEGrid.isPAGINGSIZENull()) {
            return 20;
        }
        return this.psDEGrid.getPAGINGSIZE();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.strCodeName, null);
    }

    @Override
    @PSModelRTMeta(description="\u5355\u9879\u9009\u62e9", model="PSDEViewCtrl", fields={"MULTISELECT"}, ignoresetvalues="*")
    public boolean isSingleSelect() {
        return this.psDEGridParamImpl.isSingleSelect();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u7f16\u8f91", model="PSDEViewCtrl", fields={"CTRLPARAM6"}, ignoresetvalues="*")
    public boolean isEnableRowEdit() {
        if (this.psDEGridParamImpl.isEnableRowEdit() == null) {
            return false;
        }
        return this.psDEGridParamImpl.isEnableRowEdit();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u65b0\u5efa", model="PSDEViewCtrl", fields={"CTRLPARAM6"})
    public boolean isEnableRowNew() {
        if (this.psDEGridParamImpl.getEditMode() != null && (this.psDEGridParamImpl.getEditMode() & 0x80) == 128) {
            return false;
        }
        return this.isEnableRowEdit();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u6b21\u5e8f\u8c03\u6574", model="PSDEViewCtrl", fields={"CTRLPARAM6"})
    public boolean isEnableRowEditOrder() {
        return this.psDEGridParamImpl.getEditMode() != null && (this.psDEGridParamImpl.getEditMode() & 0x100) == 256;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u7f16\u8f91\u4ec5\u63d0\u4ea4\u53d8\u5316\u503c", ignoredumpvalues="false", model="PSDEViewCtrl", fields={"CTRLPARAM6"})
    public boolean isEnableRowEditChangedOnly() {
        return this.psDEGridParamImpl.getEditMode() != null && (this.psDEGridParamImpl.getEditMode() & 0x800) == 2048;
    }

    @Override
    @PSModelRTMeta(description="\u9002\u5e94\u5c4f\u5e55\u5bbd\u5ea6", fields={"FORCEFIT"})
    public boolean isForceFit() {
        return this.bForceFit;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u6837\u5f0f", codelist="DEGridStyle", fields={"GRIDSTYLE"})
    public String getGridStyle() {
        return this.psDEGrid.getGRIDSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7981\u7528\u6392\u5e8f", fields={"NOSORT"})
    public boolean isNoSort() {
        return this.bNoSort;
    }

    @Override
    public IPSDEField getMinorSortPSDEF() {
        return this.minorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u6392\u5e8f\u65b9\u5411", codelist="SortDir", fields={"MINORSORTDIR"})
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
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEGridDataItem.getCodeListId())) {
                relatedPSCodeListList.add(this.getPSDataEntity().getPSSystem().getPSCodeList(iPSDEGridDataItem.getCodeListId()));
            }
            if (iPSDEGridDataItem.getDataItemParams() == null) continue;
            IDataItemParam[] iDataItemParamArray = iPSDEGridDataItem.getDataItemParams();
            int n = iDataItemParamArray.length;
            int n2 = 0;
            while (n2 < n) {
                IDataItemParam iDataItemParam = iDataItemParamArray[n2];
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iDataItemParam.getCodeListId())) {
                    relatedPSCodeListList.add(this.getPSDataEntity().getPSSystem().getPSCodeList(iDataItemParam.getCodeListId()));
                }
                ++n2;
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

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u8868\u683c\u5934\u90e8", fields={"SHOWHEADER"})
    public boolean isHideHeader() {
        return this.bHideHeader;
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    public Iterator<IGridEditItem> getGridEditItems() {
        return this.gridEditItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u96c6\u5408", modeltype="PSDEGRIDEDITITEM", child=true, outputdoc="false")
    public Iterator<IPSDEGridEditItem> getPSDEGridEditItems() {
        return this.psDEGridEditItemMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u96c6\u5408", child=true, group="\u90e8\u4ef6\u903b\u8f91", order=210)
    public Iterator<IPSDEGridEditItemUpdate> getPSDEGridEditItemUpdates() {
        return this.psDEGridEditItemUpdateMap.values().iterator();
    }

    @Override
    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate(String strPSDEGridEditItemUpdateId) throws Exception {
        IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate = this.psDEGridEditItemUpdateMap.get(strPSDEGridEditItemUpdateId);
        if (strPSDEGridEditItemUpdateId == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0[%1$s]", (Object)strPSDEGridEditItemUpdateId));
        }
        return iPSDEGridEditItemUpdate;
    }

    protected void fillChildPSDEGridColumnList(IPSDEGridColumn iPSDEGridColumn, ArrayList<IPSDEGridColumn> psDEGridColumnList) throws Exception {
        IPSDEGridGroupColumn iPSDEGridGroupColumn;
        Iterator<IPSDEGridColumn> psDEGridColumns;
        if (iPSDEGridColumn instanceof IPSDEGridGroupColumn && (psDEGridColumns = (iPSDEGridGroupColumn = (IPSDEGridGroupColumn)iPSDEGridColumn).getPSDEGridColumns()) != null) {
            while (psDEGridColumns.hasNext()) {
                IPSDEGridColumn childPSDEGridColumn = psDEGridColumns.next();
                psDEGridColumnList.add(childPSDEGridColumn);
                this.fillChildPSDEGridColumnList(childPSDEGridColumn, psDEGridColumnList);
            }
        }
    }

    @Override
    public Iterator<IPSDEGridDataItem> getGroupPSDEGridDataItems() {
        if (this.groupPSDEGridDataItemList == null || this.groupPSDEGridDataItemList.size() == 0) {
            return null;
        }
        return this.groupPSDEGridDataItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u8868\u683c\u5217\u96c6\u5408", modeltype="PSDEGRIDCOL", group="\u90e8\u4ef6\u5143\u7d20", order=160)
    public Iterator<IPSDEGridColumn> getAllPSDEGridColumns() {
        return this.psDEGridColumnList3.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90", fields={"EMPTYTEXTPSLANRESID"})
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        if (this.emptyTextPSLanguageRes == null && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyTextPSLanguageRes();
        }
        return this.emptyTextPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u5185\u5bb9", fields={"EMPTYTEXT"})
    public String getEmptyText() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEmptyText) && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyText();
        }
        return this.strEmptyText;
    }

    @Override
    public String getModelType() {
        return "PSDEGRID";
    }

    protected boolean isFixWFDataItemsBug() {
        return (this.getPSSystemSetting().getEngineBugFixs() & 4) == 4;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u9884\u7f6e\u6d41\u7a0b\u6570\u636e\u9879")
    public boolean hasWFDataItems() {
        return this.bHasWFDataItems;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u6a21\u5f0f", codelist="SortMode", fields={"SORTMODE"})
    public String getSortMode() {
        return this.strSortMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5217\u8fc7\u6ee4\u5668", model="PSDEViewCtrl", fields={"CTRLPARAM8"})
    public boolean isEnableColFilter() {
        if (this.psDEGridParamImpl.isEnableColFilter() == null) {
            return false;
        }
        return this.psDEGridParamImpl.isEnableColFilter();
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u6570\u636e\u884c\u4e3a", hideempty=true, child=true)
    public IPSControlAction getCreatePSControlAction() {
        block4: {
            try {
                if (this.isEnableRowEdit()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("create", true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u6570\u636e\u884c\u4e3a", hideempty=true, child=true)
    public IPSControlAction getUpdatePSControlAction() {
        block4: {
            try {
                if (this.isEnableRowEdit()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("update", true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6570\u636e\u884c\u4e3a", hideempty=true, child=true)
    public IPSControlAction getRemovePSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("remove", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u6570\u636e\u884c\u4e3a", hideempty=true, child=true)
    public IPSControlAction getMovePSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("move", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u884c\u4e3a", hideempty=true, child=true)
    public IPSControlAction getGetPSControlAction() {
        block4: {
            try {
                if (this.isEnableRowEdit()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("load", true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\u884c\u4e3a", hideempty=true, child=true)
    public IPSControlAction getGetDraftPSControlAction() {
        block4: {
            try {
                if (this.isEnableRowEdit()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("loaddraft", true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\u884c\u4e3a\uff08\u62f7\u8d1d\uff09", hideempty=true, child=true)
    public IPSControlAction getGetDraftFromPSControlAction() {
        block4: {
            try {
                if (this.isEnableRowEdit()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("loaddraftfrom", true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u805a\u5408\u6a21\u5f0f", codelist="GridAggMode")
    public String getAggMode() {
        return this.strAggMode;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u670d\u52a1\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getAggPSDataEntity() {
        return this.aggPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u670d\u52a1\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dump=false)
    public IPSDEAction getAggPSDEAction() {
        return this.aggPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u670d\u52a1\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true, dump=false)
    public IPSDEDataSet getAggPSDEDataSet() {
        return this.aggPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u670d\u52a1\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"AGGPSDEID"})
    public IPSAppDataEntity getAggPSAppDataEntity() {
        return this.aggPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u670d\u52a1\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dumpref=false, from="__self__", from_method="getAggPSAppDataEntityMust().getPSAppDEAction")
    public IPSAppDEAction getAggPSAppDEAction() {
        return this.aggPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u670d\u52a1\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true, dumpref=true, from="__self__", from_method="getAggPSAppDataEntityMust().getPSAppDEDataSet", fields={"AGGPSDEDSID"})
    public IPSAppDEDataSet getAggPSAppDEDataSet() {
        return this.aggPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5c5e\u6027\u96c6\u5408", hideempty=true)
    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception {
        if (this.psAppDEFieldList == null) {
            LinkedHashMap<String, IPSAppDEField> psAppDEFieldMap = new LinkedHashMap<String, IPSAppDEField>();
            Iterator<IPSDEGridDataItem> psDEGridDataItems = this.getPSDEGridDataItems();
            if (psDEGridDataItems != null) {
                while (psDEGridDataItems.hasNext()) {
                    IPSDEGridDataItem iPSDEGridDataItem = psDEGridDataItems.next();
                    if (iPSDEGridDataItem.getPSAppDEField() == null) continue;
                    psAppDEFieldMap.put(iPSDEGridDataItem.getPSAppDEField().getName(), iPSDEGridDataItem.getPSAppDEField());
                }
            }
            ArrayList<IPSAppDEField> psAppDEFieldList = new ArrayList<IPSAppDEField>();
            psAppDEFieldList.addAll(psAppDEFieldMap.values());
            Collections.sort(psAppDEFieldList, new Comparator<IPSAppDEField>(){

                @Override
                public int compare(IPSAppDEField o1, IPSAppDEField o2) {
                    return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                }
            });
            if (this.psAppDEFieldList == null) {
                this.psAppDEFieldList = psAppDEFieldList;
            }
        }
        return this.psAppDEFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u94fe\u63a5\u6a21\u5f0f", codelist="DEGridColLinkMode", fields={"COLENABLELINK"})
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
                if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEGridColumn.getId(), (String)strPSDEGridColumnId, (boolean)false) == 0) {
                    return iPSDEGridColumn;
                }
                if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEGridColumn.getName(), (String)strPSDEGridColumnId, (boolean)true) != 0) continue;
                return iPSDEGridColumn;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u683c\u5217[%1$s]", (Object)strPSDEGridColumnId));
    }

    @Override
    public IPSDEGridEditItem getPSDEGridEditItem(String strPSDEGridEditItemName, boolean bTryMode) throws Exception {
        IPSDEGridEditItem iPSDEGridEditItem = this.psDEGridEditItemMap.get(strPSDEGridEditItemName.toLowerCase());
        if (iPSDEGridEditItem != null || bTryMode) {
            return iPSDEGridEditItem;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879[%1$s]", (Object)strPSDEGridEditItemName));
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u503c\u89c4\u5219\u96c6\u5408", child=true, group="\u90e8\u4ef6\u903b\u8f91", order=215)
    public Iterator<IPSDEGridEditItemVR> getPSDEGridEditItemVRs() {
        return this.psDEGridEditItemVRMap.values().iterator();
    }

    @Override
    public IPSDEGridEditItemVR getPSDEGridEditItemVR(String strPSDEGridEditItemVRId) throws Exception {
        IPSDEGridEditItemVR iPSDEGridEditItemVR = this.psDEGridEditItemVRMap.get(strPSDEGridEditItemVRId);
        if (strPSDEGridEditItemVRId == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u503c\u89c4\u5219[%1$s]", (Object)strPSDEGridEditItemVRId));
        }
        return iPSDEGridEditItemVR;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5c5e\u6027")
    public IPSDEField getOrderValuePSDEField() {
        return this.orderValuePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, fields={"ORDERVALUEPSDEFID"})
    public IPSAppDEField getOrderValuePSAppDEField() {
        try {
            if (this.getPSAppDataEntity() != null && this.getOrderValuePSDEField() != null) {
                return this.getPSAppDataEntity().getPSAppDEField(this.getOrderValuePSDEField(), true);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMinorSortPSDEField() {
        return this.getMinorSortPSDEF();
    }

    @Override
    public boolean isBufferRenderer() {
        return this.bBufferRenderer;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u6392\u5e8f\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, fields={"MINORSORTPSDEFID"})
    public IPSAppDEField getMinorSortPSAppDEField() {
        try {
            if (this.getPSAppDataEntity() != null && this.getMinorSortPSDEField() != null) {
                return this.getPSAppDataEntity().getPSAppDEField(this.getMinorSortPSDEField(), true);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6a21\u5f0f", hideempty2=true, codelist="MDCtrlGroupMode", fields={"GROUPMODE"})
    public String getGroupMode() {
        return this.strGroupMode;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6837\u5f0f", hideempty2=true, codelist="CtrlGroupStyle", ignoredumpvalues="DEFAULT", fields={"GROUPSTYLE"})
    public String getGroupStyle() {
        return this.strGroupStyle;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5206\u7ec4", doc="\u8ba1\u7b97{@link #getGroupMode}\u8fd4\u56de\u4e0d\u7b49\u4e8e(NONE)")
    public boolean isEnableGroup() {
        return this.bEnableGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, fields={"GROUPPSDEFID"})
    public IPSAppDEField getGroupPSAppDEField() {
        return this.groupPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, ignorepf=true)
    public IPSDEField getGroupPSDEField() {
        return this.groupPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, fields={"GROUPTEXTPSDEFID"})
    public IPSAppDEField getGroupTextPSAppDEField() {
        return this.groupTextPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6587\u672c\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, ignorepf=true)
    public IPSDEField getGroupTextPSDEField() {
        return this.groupTextPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u4ee3\u7801\u8868", hideempty=true, dumpref=true, fields={"GROUPPSCODELISTID"})
    public IPSCodeList getGroupPSCodeList() {
        return this.groupPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u8868\u683c\u5b9a\u5236", model="PSDEViewCtrl", fields={"CTRLPARAM7"}, doc="\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u5168\u5c40\u5b9a\u4e49{@link PSSysAppDTO#FIELD_GRIDENABLECUSTOMIZED}")
    public boolean isEnableCustomized() {
        return this.bEnableCustomized;
    }

    @Override
    protected boolean isNeedFillPSACHandlerData() {
        if (!(!this.isEnableRowEdit() && !this.isEnableUIModelEx() || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getGETDRAFTPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getCREATEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getGETPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getUPDATEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getREMOVEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getMOVEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getCOPYPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getUSERPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getUSER2PSDEACTIONID()))) {
            return true;
        }
        return super.isNeedFillPSACHandlerData();
    }

    @Override
    protected void fillPSACHandlerData(PSACHandler psACHandler) throws Exception {
        super.fillPSACHandlerData(psACHandler);
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getGETDRAFTPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getGETDRAFTPSDEACTIONID())) {
            psACHandler.setGETDRAFTPSDEACTIONID(this.psDEGrid.getGETDRAFTPSDEACTIONID());
            psACHandler.setGETDRAFTPSDEACTIONNAME(this.psDEGrid.getGETDRAFTPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getCREATEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getCREATEPSDEACTIONID())) {
            psACHandler.setCREATEPSDEACTIONID(this.psDEGrid.getCREATEPSDEACTIONID());
            psACHandler.setCREATEPSDEACTIONNAME(this.psDEGrid.getCREATEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getGETPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getGETPSDEACTIONID())) {
            psACHandler.setGETPSDEACTIONID(this.psDEGrid.getGETPSDEACTIONID());
            psACHandler.setGETPSDEACTIONNAME(this.psDEGrid.getGETPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getUPDATEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getUPDATEPSDEACTIONID())) {
            psACHandler.setUPDATEPSDEACTIONID(this.psDEGrid.getUPDATEPSDEACTIONID());
            psACHandler.setUPDATEPSDEACTIONNAME(this.psDEGrid.getUPDATEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getREMOVEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getREMOVEPSDEACTIONID())) {
            psACHandler.setREMOVEPSDEACTIONID(this.psDEGrid.getREMOVEPSDEACTIONID());
            psACHandler.setREMOVEPSDEACTIONNAME(this.psDEGrid.getREMOVEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getMOVEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getMOVEPSDEACTIONID())) {
            psACHandler.setMOVEPSDEACTIONID(this.psDEGrid.getMOVEPSDEACTIONID());
            psACHandler.setMOVEPSDEACTIONNAME(this.psDEGrid.getMOVEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getCOPYPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getCOPYPSDEACTIONID())) {
            psACHandler.setCOPYPSDEACTIONID(this.psDEGrid.getCOPYPSDEACTIONID());
            psACHandler.setCOPYPSDEACTIONNAME(this.psDEGrid.getCOPYPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getUSERPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getUSERPSDEACTIONID())) {
            psACHandler.setUSERPSDEACTIONID(this.psDEGrid.getUSERPSDEACTIONID());
            psACHandler.setUSERPSDEACTIONNAME(this.psDEGrid.getUSERPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getUSER2PSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGrid.getUSER2PSDEACTIONID())) {
            psACHandler.setUSER2PSDEACTIONID(this.psDEGrid.getUSER2PSDEACTIONID());
            psACHandler.setUSER2PSDEACTIONNAME(this.psDEGrid.getUSER2PSDEACTIONNAME());
        }
    }

    protected String getAggPSSysLayoutPanelId() {
        return this.strAggPSSysViewPanelId;
    }

    protected void onPrepareAggPSLayoutPanel() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getAggPSSysLayoutPanelId())) {
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

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u5e03\u5c40\u9762\u677f", child=true)
    public IPSLayoutPanel getAggPSLayoutPanel() {
        return this.aggPSLayoutPanel;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u8fc7\u6ee4\u5668\u6a21\u5f0f", codelist="DEGridColLinkMode", fields={"COLENABLEFILTER"})
    public int getColumnEnableFilter() {
        return this.nColumnEnableFilter;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSDEGridLogic> getPSDEGridLogics() {
        if (this.psDEGridLogicList == null || this.psDEGridLogicList.size() == 0) {
            return null;
        }
        return this.psDEGridLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psDEGridLogicList == null || this.psDEGridLogicList.size() == 0) {
            return null;
        }
        return this.psDEGridLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u56fa\u5b9a\u8d77\u59cb\u5217\u6570", ignoredumpvalues="0", fields={"FROZENCOL"})
    public int getFrozenFirstColumn() {
        if (!this.psDEGrid.isFROZENCOLNull() && this.psDEGrid.getFROZENCOL() > 0) {
            return this.psDEGrid.getFROZENCOL();
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u56fa\u5b9a\u672b\u5c3e\u5217\u6570", ignoredumpvalues="0", fields={"FROZENLASTCOL"})
    public int getFrozenLastColumn() {
        if (!this.psDEGrid.isFROZENLASTCOLNull() && this.psDEGrid.getFROZENLASTCOL() > 0) {
            return this.psDEGrid.getFROZENLASTCOL();
        }
        return 0;
    }
}

