/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridDataItem
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.grid;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlObject;
import net.ibizsys.model.control.IPSControlRuntime;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridColumnRuntime;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEGridColumnImpl
extends PSObjectImpl
implements IPSDEGridColumn,
IPSDEGridColumnRuntime,
IPSControlObject {
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

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEGrid iPSDEGrid, IPSDEGridColumn parentPSDEGridColumn, PSDEGridColumn psDEGridColumn) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEGrid(iPSDEGrid);
            this.psDEGridColumn = psDEGridColumn;
            this.parentPSDEGridColumn = parentPSDEGridColumn;
            this.setId(this.psDEGridColumn.getPSDEGRIDCOLID());
            this.setName(this.psDEGridColumn.getPSDEGRIDCOLNAME());
            this.setPSObjectData(psDEGridColumn);
            this.strCaption = this.psDEGridColumn.getCAPTION();
            if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDEGrid().getPSAppView().getPSSystem().getPSLanguageRes(this.psDEGridColumn.getCAPPSLANRESID());
            }
            if (!((IPSControlRuntime)this.getPSDEGrid()).isDesignMode() && !StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getGCRPSSYSPFPLUGINID())) {
                this.renderPSSysPFPlugin = ((IPSSystemRuntime)this.getPSDEGrid().getPSDataEntity().getPSSystem()).getPSSysPFPlugin(this.psDEGridColumn.getGCRPSSYSPFPLUGINID());
            }
            if (!StringHelper.isNullOrEmpty((String)psDEGridColumn.getALIGN())) {
                this.strAlign = psDEGridColumn.getALIGN();
            }
            if (!psDEGridColumn.isHIDDENDATAITEMNull()) {
                this.bHiddenDataItem = psDEGridColumn.getHIDDENDATAITEM();
            }
            if (!psDEGridColumn.isHIDEDEFAULTNull()) {
                this.bHideDefault = psDEGridColumn.getHIDEDEFAULT();
            }
            if (!this.psDEGridColumn.isNOSORTNull()) {
                this.bEnableSort = !this.psDEGridColumn.getNOSORT();
                this.bDefineEnableSort = true;
            } else if (this.getPSDEGrid().isNoSort()) {
                this.bEnableSort = false;
                this.bDefineEnableSort = true;
            }
            this.strWidthString = StringHelper.compare((String)this.psDEGridColumn.getWIDTHUNIT(), (String)"PX", (boolean)true) == 0 || StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getWIDTHUNIT()) ? (psDEGridColumn.getWIDTH() > 0 ? StringHelper.format((String)"%1$spx", (Object)psDEGridColumn.getWIDTH()) : "0px") : (psDEGridColumn.getWIDTH() > 1 ? StringHelper.format((String)"%1$s*", (Object)psDEGridColumn.getWIDTH()) : "*");
            this.strColumnStyle = this.psDEGridColumn.getGRIDCOLSTYLE();
            if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getHEADERPSSYSCSSID())) {
                this.headerPSSysCss = this.getPSDEGrid().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEGridColumn.getHEADERPSSYSCSSID());
                if (this.getPSDEGrid().getPSAppView() != null) {
                    ((IPSAppViewRuntime)this.getPSDEGrid().getPSAppView()).registerPSSysCss(this.headerPSSysCss);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getCELLPSSYSCSSID())) {
                this.cellPSSysCss = this.getPSDEGrid().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEGridColumn.getCELLPSSYSCSSID());
                if (this.getPSDEGrid().getPSAppView() != null) {
                    ((IPSAppViewRuntime)this.getPSDEGrid().getPSAppView()).registerPSSysCss(this.cellPSSysCss);
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.getName();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u683c\u5bf9\u8c61")
    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    protected void setPSDEGrid(IPSDEGrid iPSDEGrid) {
        this.iPSDEGrid = iPSDEGrid;
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        if (StringHelper.isNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption();
        }
        return this.strCaption;
    }

    protected String onGetCaption() {
        return "";
    }

    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.capPSLanguageRes == null) {
            return this.onGetCapPSLanguageRes();
        }
        return this.capPSLanguageRes;
    }

    protected IPSLanguageRes onGetCapPSLanguageRes() {
        return null;
    }

    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() == null) {
            return null;
        }
        return this.getCapPSLanguageRes().getLanResTag();
    }

    public String getDataItemName() {
        return "";
    }

    @PSModelRTMeta(description="\u5217\u5bbd\u5ea6\u5355\u4f4d")
    public String getWidthUnit() {
        if (this.psDEGridColumn.isWIDTHUNITNull()) {
            return "PX";
        }
        return this.psDEGridColumn.getWIDTHUNIT();
    }

    @PSModelRTMeta(description="\u5217\u5bbd\u5ea6")
    public int getWidth() {
        if (this.psDEGridColumn.isWIDTHNull()) {
            return this.onGetWidth();
        }
        return this.psDEGridColumn.getWIDTH();
    }

    protected int onGetWidth() {
        return 100;
    }

    @PSModelRTMeta(description="\u5217\u7c7b\u578b", codelist="DEGridColType")
    public String getColumnType() {
        return this.psDEGridColumn.getGRIDCOLTYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEGrid).getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u7ed8\u5236\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getRenderPSSysPFPlugin() {
        return this.renderPSSysPFPlugin;
    }

    protected void setRenderPSSysPFPlugin(IPSSysPFPlugin renderPSSysPFPlugin) {
        this.renderPSSysPFPlugin = renderPSSysPFPlugin;
    }

    @PSModelRTMeta(description="\u5217\u5bf9\u9f50", codelist="GridColAlign")
    public String getAlign() {
        return this.strAlign;
    }

    protected void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    @PSModelRTMeta(description="\u652f\u6301\u6392\u5e8f")
    public boolean isEnableSort() {
        return this.bEnableSort;
    }

    public void setEnableSort(boolean bEnableSort) {
        this.bEnableSort = bEnableSort;
    }

    public String getWidthString() {
        return this.strWidthString;
    }

    public String getExcelText(IWebContext iWebContext, Object object) throws Exception {
        return "\u6ca1\u6709\u5b9e\u73b0";
    }

    public String getExcelText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
        return "\u6ca1\u6709\u5b9e\u73b0";
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u9690\u85cf")
    public boolean isHideDefault() {
        return this.bHideDefault;
    }

    @PSModelRTMeta(description="\u9690\u85cf\u6570\u636e\u9879")
    public boolean isHiddenDataItem() {
        return this.bHiddenDataItem;
    }

    public String getExcelCaption() {
        return null;
    }

    public String getCodeListId() {
        return null;
    }

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

    public boolean isEnableRowEdit() {
        return false;
    }

    public IPSDEGridEditItem getPSDEGridEditItem() {
        return null;
    }

    public boolean isDesignMode() {
        return ((IPSControlRuntime)this.getPSDEGrid()).isDesignMode();
    }

    @PSModelRTMeta(description="\u7236\u5217\u5bf9\u8c61", hideempty=true)
    public IPSDEGridColumn getParentPSGridColumn() {
        return this.parentPSDEGridColumn;
    }

    public String getExcelCapLanResTag() {
        return null;
    }

    public IPSSystem getPSSystem() {
        return this.getPSDEGrid().getPSDataEntity().getPSSystem();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)this.getPSSystem();
    }

    @Override
    public String getModelType() {
        return "PSDEGRIDCOL";
    }

    @PSModelRTMeta(description="\u8868\u683c\u5217\u6837\u5f0f")
    public String getColumnStyle() {
        return this.strColumnStyle;
    }

    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0")
    public String getUserTag() {
        return this.psDEGridColumn.getUSERTAG();
    }

    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02")
    public String getUserTag2() {
        return this.psDEGridColumn.getUSERTAG2();
    }

    @PSModelRTMeta(description="\u5934\u90e8\u6837\u5f0f\u5bf9\u8c61")
    public IPSSysCss getHeaderPSSysCss() {
        return this.headerPSSysCss;
    }

    @PSModelRTMeta(description="\u5355\u5143\u683c\u6837\u5f0f\u5bf9\u8c61")
    public IPSSysCss getCellPSSysCss() {
        return this.cellPSSysCss;
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDEGrid();
    }
}

