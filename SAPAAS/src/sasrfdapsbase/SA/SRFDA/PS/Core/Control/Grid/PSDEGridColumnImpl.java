/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridFieldColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridGroupColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridUAColumn;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlPartCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridColumnImpl
extends PSObjectImpl
implements IPSDEGridColumn,
IPSControlObject,
IPSPFCtrlPartCodeObject {
    private static final Log log = LogFactory.getLog(PSDEGridColumnImpl.class);
    private IPSDEGrid iPSDEGrid = null;
    protected PSDEGridColumn psDEGridColumn = null;
    private String strCaption = "";
    private IPSSysPFPlugin renderPSSysPFPlugin = null;
    private String strAlign = "";
    private boolean bEnableSort = true;
    private String strWidthString = "";
    private boolean bHiddenDataItem = false;
    private boolean bHideDefault = false;
    private boolean bDefineEnableSort = false;
    private IPSDEGridColumn parentPSDEGridColumn = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private String strColumnStyle = null;
    private IPSSysCss headerPSSysCss = null;
    private IPSSysCss cellPSSysCss = null;
    private int nNoPrivDisplayMode = 1;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private String strAggMode = "NONE";
    private String strAggField = "";
    private String strAggValueFormat = "";
    private IPSSysImage iPSSysImage = null;
    private int nHideMode = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEGrid iPSDEGrid, IPSDEGridColumn parentPSDEGridColumn, PSDEGridColumn psDEGridColumn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEGrid(iPSDEGrid);
            this.psDEGridColumn = psDEGridColumn;
            this.parentPSDEGridColumn = parentPSDEGridColumn;
            this.setId(this.psDEGridColumn.getPSDEGRIDCOLID());
            this.setName(this.psDEGridColumn.getPSDEGRIDCOLNAME());
            this.setPSObjectData(psDEGridColumn);
            this.strCaption = this.psDEGridColumn.getCAPTION();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDEGrid().getPSAppView().getPSApplication().getPSLanguageRes(this.psDEGridColumn.getCAPPSLANRESID());
            }
            if (!this.getPSDEGrid().isDesignMode() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRenderPSSysPFPluginId())) {
                this.renderPSSysPFPlugin = this.getPSDEGrid().getPSAppView().getPSApplication() != null ? this.getPSDEGrid().getPSAppView().getPSApplication().getPSSysPFPlugin(this.getRenderPSSysPFPluginId(), "CONTROLITEM", this.getPSDEGrid().getControlType(), this.getColumnType()) : this.getPSDEGrid().getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.getRenderPSSysPFPluginId());
                this.getPSDEGrid().getPSAppView().registerPSSysPFPlugin(this.renderPSSysPFPlugin);
            }
            if (this.getRenderPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getRenderPSSysPFPlugin().getId(), (String)this.getPSDEGrid().getPSAppView().getPSPFStyle().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSDEGrid().getPSAppView().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSDEGrid().getPSAppView(), (Object)this.getPSDEGrid(), (Object)this);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEGridColumn.getALIGN())) {
                this.strAlign = psDEGridColumn.getALIGN();
            }
            if (!psDEGridColumn.isHIDDENDATAITEMNull()) {
                this.bHiddenDataItem = psDEGridColumn.getHIDDENDATAITEM();
            }
            if (!psDEGridColumn.isHIDEDEFAULTNull()) {
                this.nHideMode = psDEGridColumn.getHIDEDEFAULT();
                boolean bl = this.bHideDefault = psDEGridColumn.getHIDEDEFAULT() == 1;
            }
            if (!this.psDEGridColumn.isNOSORTNull()) {
                this.bEnableSort = !this.psDEGridColumn.getNOSORT();
                this.bDefineEnableSort = true;
            } else if (this.getPSDEGrid().isNoSort()) {
                this.bEnableSort = false;
                this.bDefineEnableSort = true;
            }
            this.strWidthString = SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEGridColumn.getWIDTHUNIT(), (String)"PX", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getWIDTHUNIT()) ? (psDEGridColumn.getWIDTH() > 0 ? SA.SRFramework.Utility.StringHelper.Format((String)"%1$spx", (Object)psDEGridColumn.getWIDTH()) : "0px") : (psDEGridColumn.getWIDTH() > 1 ? SA.SRFramework.Utility.StringHelper.Format((String)"%1$s*", (Object)psDEGridColumn.getWIDTH()) : "*");
            this.strColumnStyle = this.psDEGridColumn.getGRIDCOLSTYLE();
            boolean bRegisterToContainer = true;
            if (this.getPSDEGrid().getPSAppView() != null) {
                bRegisterToContainer = this.getPSDEGrid().getPSAppView().getPSPFStyle().isRegisterToContainer();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getHEADERPSSYSCSSID())) {
                this.headerPSSysCss = this.getPSDEGrid().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEGridColumn.getHEADERPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSDEGrid().registerPSSysCss(this.headerPSSysCss);
                } else if (this.getPSDEGrid().getPSAppView() != null) {
                    this.getPSDEGrid().getPSAppView().registerPSSysCss(this.headerPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getCELLPSSYSCSSID())) {
                this.cellPSSysCss = this.getPSDEGrid().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEGridColumn.getCELLPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSDEGrid().registerPSSysCss(this.cellPSSysCss);
                } else if (this.getPSDEGrid().getPSAppView() != null) {
                    this.getPSDEGrid().getPSAppView().registerPSSysCss(this.cellPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSDEGrid().getPSDataEntity().getPSSystem().getPSSysImage(this.psDEGridColumn.getPSSYSIMAGEID());
                if (bRegisterToContainer) {
                    this.getPSDEGrid().registerPSSysImage(this.iPSSysImage);
                } else if (this.getPSDEGrid().getPSAppView() != null) {
                    this.getPSDEGrid().getPSAppView().registerPSSysImage(this.iPSSysImage);
                }
            }
            this.nNoPrivDisplayMode = !this.psDEGridColumn.isNOPRIVDMNull() ? this.psDEGridColumn.getNOPRIVDM() : this.getPSDEGrid().getPSAppView().getPSApplication().getPSApplicationUI().getFormItemNoPrivDisplayMode();
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEGrid.getAggMode(), (String)"NONE", (boolean)false) != 0) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getAGGMODE())) {
                    this.strAggMode = this.psDEGridColumn.getAGGMODE();
                }
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getAggMode(), (String)"NONE", (boolean)false) != 0) {
                    this.strAggField = this.psDEGridColumn.getAGGFIELD();
                    this.strAggValueFormat = this.psDEGridColumn.getAGGVALUEFORMAT();
                }
            }
            this.onInit();
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

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u683c\u5bf9\u8c61", outputdoc="false")
    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    protected void setPSDEGrid(IPSDEGrid iPSDEGrid) {
        this.iPSDEGrid = iPSDEGrid;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption();
        }
        return this.strCaption;
    }

    protected String onGetCaption() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.capPSLanguageRes == null) {
            return this.onGetCapPSLanguageRes();
        }
        return this.capPSLanguageRes;
    }

    protected IPSLanguageRes onGetCapPSLanguageRes() {
        return null;
    }

    @Override
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() == null) {
            return null;
        }
        return this.getCapPSLanguageRes().getLanResTag();
    }

    @Override
    public String getDataItemName() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5217\u5bbd\u5355\u4f4d", codelist="DEGridColWidthUnitType", fields={"WIDTHUNIT"})
    public String getWidthUnit() {
        if (this.psDEGridColumn.isWIDTHUNITNull()) {
            return "PX";
        }
        return this.psDEGridColumn.getWIDTHUNIT();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u5bbd", fields={"WIDTH"})
    public int getWidth() {
        if (this.psDEGridColumn.isWIDTHNull()) {
            return this.onGetWidth();
        }
        return this.psDEGridColumn.getWIDTH();
    }

    protected int onGetWidth() {
        return 100;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u7c7b\u578b", codelist="DEGridColType", fields={"GRIDCOLTYPE"})
    public String getColumnType() {
        return this.psDEGridColumn.getGRIDCOLTYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEGrid.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", modelattr="getPSSysPFPlugin")
    public IPSSysPFPlugin getRenderPSSysPFPlugin() {
        return this.renderPSSysPFPlugin;
    }

    protected void setRenderPSSysPFPlugin(IPSSysPFPlugin renderPSSysPFPlugin) {
        this.renderPSSysPFPlugin = renderPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u6c34\u5e73\u5bf9\u9f50", codelist="GridColAlign", fields={"ALIGN"})
    public String getAlign() {
        return this.onGetAlign();
    }

    protected String onGetAlign() {
        return this.strAlign;
    }

    protected void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6392\u5e8f", fields={"NOSORT"})
    public boolean isEnableSort() {
        return this.bEnableSort;
    }

    public void setEnableSort(boolean bEnableSort) {
        this.bEnableSort = bEnableSort;
    }

    @Override
    public String getWidthString() {
        return this.strWidthString;
    }

    public String getExcelText(IWebContext iWebContext, Object object) throws Exception {
        return "\u6ca1\u6709\u5b9e\u73b0";
    }

    public String getExcelText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
        return "\u6ca1\u6709\u5b9e\u73b0";
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u9690\u85cf", ignoredumpvalues="false")
    public boolean isHideDefault() {
        return this.bHideDefault;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u6a21\u5f0f", ignoredumpvalues="0", fields={"HIDEDEFAULT"})
    public int getHideMode() {
        return this.nHideMode;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u6570\u636e\u9879", ignoredumpvalues="false", fields={"HIDDENDATAITEM"})
    public boolean isHiddenDataItem() {
        return this.bHiddenDataItem;
    }

    @Override
    public String getExcelCaption() {
        return null;
    }

    public String getCodeListId() {
        return null;
    }

    @Override
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        return null;
    }

    protected boolean isDefineEnableSort() {
        return this.bDefineEnableSort;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        this.onFillRelatedPSAppViews(relatedAppViewList);
    }

    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    public IPSCodeList getPSCodeList() {
        return null;
    }

    public String getPSCodeListId() {
        return null;
    }

    @Override
    public boolean isEnableRowEdit() {
        return false;
    }

    @Override
    public IPSDEGridEditItem getPSDEGridEditItem() {
        return null;
    }

    public boolean isDesignMode() {
        return this.getPSDEGrid().isDesignMode();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u5217\u5bf9\u8c61", hideempty=true)
    public IPSDEGridColumn getParentPSGridColumn() {
        return this.parentPSDEGridColumn;
    }

    @Override
    public String getExcelCapLanResTag() {
        if (this.getExcelCapPSLanguageRes() != null) {
            return this.getExcelCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public IPSLanguageRes getExcelCapPSLanguageRes() {
        return null;
    }

    public IPSSystem getPSSystem() {
        return this.getPSDEGrid().getPSDataEntity().getPSSystem();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDEGRIDCOL";
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u6837\u5f0f", fields={"GRIDCOLSTYLE"})
    public String getColumnStyle() {
        return this.strColumnStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u6837\u5f0f\u5bf9\u8c61", fields={"HEADERPSSYSCSSID"})
    public IPSSysCss getHeaderPSSysCss() {
        return this.headerPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u5355\u5143\u683c\u6837\u5f0f\u5bf9\u8c61", fields={"CELLPSSYSCSSID"})
    public IPSSysCss getCellPSSysCss() {
        return this.cellPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", codelist="NoPrivDisplayModes", fields={"NOPRIVDM"})
    public int getNoPrivDisplayMode() {
        return this.nNoPrivDisplayMode;
    }

    @Override
    public String getModelType(String strModelType) {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSDEGRIDEDITITEM", (boolean)true) == 0) {
            return "PSDEGRIDEDITITEM";
        }
        return super.getModelType(strModelType);
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSDEGRIDEDITITEM", (boolean)true) == 0) {
            return IPSDEGridEditItem.class;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSDEGRIDCOL", (boolean)true) == 0) {
            if (this instanceof IPSDEGridFieldColumn) {
                return IPSDEGridFieldColumn.class;
            }
            if (this instanceof IPSDEGridGroupColumn) {
                return IPSDEGridGroupColumn.class;
            }
            if (this instanceof IPSDEGridUAColumn) {
                return IPSDEGridUAColumn.class;
            }
            return IPSDEGridColumn.class;
        }
        return super.getModelClass(strModelType);
    }

    @Override
    public String getModelId() {
        if (this.getPSDEGrid() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEGrid().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelName() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getCaption())) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getName(), (Object)this.getCaption());
        }
        return super.getModelName();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEGrid().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEGrid().getPSAppView().getPSSystem());
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSDEGrid().getPSAppView().getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDEGrid();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6210\u5458\u4ee3\u7801\u7c7b\u578b", dump=false)
    public String getPFPartCodeType() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"COL_%1$s", (Object)this.getColumnType());
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6a21\u5f0f", codelist="GridColAggMode", ignoredumpvalues="NONE", fields={"AGGMODE"})
    public String getAggMode() {
        return this.strAggMode;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u503c\u5b58\u50a8\u5c5e\u6027", hideempty2=true, fields={"AGGFIELD"})
    public String getAggField() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSDEGrid().getAggMode(), (String)"ALL", (boolean)false) == 0 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strAggField)) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getDataItemName())) {
                return this.getDataItemName();
            }
            return this.getName();
        }
        return this.strAggField;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u503c\u683c\u5f0f\u5316", hideempty2=true, fields={"AGGVALUEFORMAT"})
    public String getAggValueFormat() {
        return this.strAggValueFormat;
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u56fe\u7247\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    public String getRenderPSSysPFPluginId() {
        return this.onGetRenderPSSysPFPluginId();
    }

    protected String onGetRenderPSSysPFPluginId() {
        return this.psDEGridColumn.getGCRPSSYSPFPLUGINID();
    }

    @Override
    public boolean isCustomCode() {
        return this.psDEGridColumn.getCUSTOMMODE();
    }

    @Override
    public String getScriptCode() {
        if (this.isCustomCode()) {
            return this.psDEGridColumn.getCUSTOMCODE();
        }
        return "";
    }

    public String getPredefinedType() {
        return null;
    }

    public String getRenderMode() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        return this.getOwnedPSControl().getPSControlLogicsByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        return this.getOwnedPSControl().getPSControlAttributesByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return this.getOwnedPSControl().getPSControlRendersByItemName(this.getName());
    }
}

