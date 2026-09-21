/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlPreviewable;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutFactory;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDataRegion;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDetailType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;

public class PSSysPanelContainerImplBase
extends PSSysPanelItemImpl
implements IPSLayoutContainer,
IPSPanelDataRegion {
    protected ArrayList<IPSPanelItem> psPanelItemList = new ArrayList();
    protected double[] columnWidths = null;
    protected Map<String, Integer> itemColIdMap = null;
    protected Map<String, Integer> itemRowIdMap = null;
    protected Map<String, Integer> itemColSpanMap = null;
    protected Map<String, Integer> itemRowSpanMap = null;
    private int nColumnCount = 0;
    private int nLabelColSpan = 1;
    private int nCtrlColSpan = 2;
    private int nChildColXS = -1;
    private int nChildColSM = -1;
    private int nChildColMD = 12;
    private int nChildColLG = -1;
    private String strFlexDir = "";
    private String strFlexAlign = "";
    private String strFlexVAlign = "";
    private IPSLayout iPSLayout = null;
    private String strDataRegionType = "INHERIT";
    private String strDataSourceType = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEAction iPSAppDEAction = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private IPSAppDELogic iPSAppDELogic = null;
    private int nReloadTimer = -1;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    private String strDataName = null;
    private String strScriptCode = null;
    private boolean bShowBusyIndicator = false;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onInit() throws Exception {
        this.strFlexDir = this.psSysPanelItem.getFLEXDIR();
        this.strFlexAlign = this.psSysPanelItem.getFLEXALIGN();
        this.strFlexVAlign = this.psSysPanelItem.getFLEXVALIGN();
        super.onInit();
        this.itemColIdMap = new LinkedHashMap<String, Integer>();
        this.itemRowIdMap = new LinkedHashMap<String, Integer>();
        this.itemColSpanMap = new LinkedHashMap<String, Integer>();
        this.itemRowSpanMap = new LinkedHashMap<String, Integer>();
        String strLayoutMode = this.getLayoutMode();
        if (this.isDesignMode() && StringHelper.IsNullOrEmpty((String)strLayoutMode)) {
            strLayoutMode = ((IPSControlPreviewable)((Object)this.getPSPanel())).getPreviewPSPF().getPanelLayoutMode();
        }
        if (StringHelper.Compare((String)strLayoutMode, (String)"TABLE_12COL", (boolean)true) == 0) {
            this.nColumnCount = 12;
            this.nChildColMD = 12;
        } else if (StringHelper.Compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            this.nColumnCount = 24;
            this.nChildColMD = 24;
        }
        if (!this.psSysPanelItem.isCHILD_COL_XSNull()) {
            this.nChildColXS = this.psSysPanelItem.getCHILD_COL_XS();
            if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                this.nChildColXS *= 2;
            }
            if (this.nChildColXS <= 0 || this.nChildColXS > this.nColumnCount) {
                this.nChildColXS = -1;
            }
        }
        if (!this.psSysPanelItem.isCHILD_COL_SMNull()) {
            this.nChildColSM = this.psSysPanelItem.getCHILD_COL_SM();
            if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                this.nChildColSM *= 2;
            }
            if (this.nChildColSM <= 0 || this.nChildColSM > this.nColumnCount) {
                this.nChildColSM = -1;
            }
        }
        if (!this.psSysPanelItem.isCHILD_COL_MDNull()) {
            this.nChildColMD = this.psSysPanelItem.getCHILD_COL_MD();
            if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                this.nChildColMD *= 2;
            }
            if (this.nChildColMD <= 0 || this.nChildColMD > this.nColumnCount) {
                this.nChildColMD = this.nColumnCount;
            }
        }
        if (!this.psSysPanelItem.isCHILD_COL_LGNull()) {
            this.nChildColLG = this.psSysPanelItem.getCHILD_COL_LG();
            if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                this.nChildColLG *= 2;
            }
            if (this.nChildColLG <= 0 || this.nChildColLG > this.nColumnCount) {
                this.nChildColLG = -1;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strLayoutMode)) {
            this.iPSLayout = PSLayoutFactory.createPSLayout(this, strLayoutMode, this.psSysPanelItem);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getDATAPANELMODE())) {
            this.strDataRegionType = this.psSysPanelItem.getDATAPANELMODE();
            if (StringHelper.Compare((String)this.getDataRegionType(), (String)"NONE", (boolean)false) != 0 && StringHelper.Compare((String)this.getDataRegionType(), (String)"INHERIT", (boolean)false) != 0) {
                this.strDataSourceType = this.psSysPanelItem.getDATASOURCE();
                if (!this.psSysPanelItem.isBUSYINDICATORNull()) {
                    this.bShowBusyIndicator = this.psSysPanelItem.getBUSYINDICATOR();
                }
                if (StringHelper.Compare((String)this.getDataSourceType(), (String)"DEACTION", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"DEDATASET", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"DELOGIC", (boolean)false) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u5b9e\u4f53\u5bf9\u8c61");
                    this.iPSAppDataEntity = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppDataEntityByDEId(this.psSysPanelItem.getPSDEID(), false);
                    if (StringHelper.Compare((String)this.getDataSourceType(), (String)"DEACTION", (boolean)false) == 0) {
                        if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEACTIONID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u884c\u4e3a\u5bf9\u8c61");
                        this.iPSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.psSysPanelItem.getPSDEACTIONID(), false);
                    }
                    if (StringHelper.Compare((String)this.getDataSourceType(), (String)"DEDATASET", (boolean)false) == 0) {
                        if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEDATASETID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u6570\u636e\u96c6\u5bf9\u8c61");
                        this.iPSAppDEDataSet = this.getPSAppDataEntity().getPSAppDEDataSet(this.psSysPanelItem.getPSDEDATASETID(), false);
                    }
                    if (StringHelper.Compare((String)this.getDataSourceType(), (String)"DELOGIC", (boolean)false) == 0) {
                        if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDELOGICID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u5904\u7406\u903b\u8f91\u5bf9\u8c61");
                        this.iPSAppDELogic = this.getPSAppDataEntity().getPSAppDELogic(this.psSysPanelItem.getPSDELOGICID(), false);
                    }
                    if (!this.psSysPanelItem.isGETDATATIMERNull() && this.psSysPanelItem.getGETDATATIMER() > 0) {
                        this.nReloadTimer = this.psSysPanelItem.getGETDATATIMER();
                    }
                    this.onPreparePSNavViewParams();
                } else if (StringHelper.Compare((String)this.getDataSourceType(), (String)"APPGLOBALPARAM", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"TOPVIEWSESSIONPARAM", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"VIEWSESSIONPARAM", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"ACTIVEDATAPARAM", (boolean)false) == 0) {
                    this.strDataName = this.psSysPanelItem.getFIELDNAME();
                    if (StringHelper.IsNullOrEmpty((String)this.strDataName)) {
                        throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u5bf9\u8c61\u540d\u79f0");
                    }
                } else if (StringHelper.Compare((String)this.getDataSourceType(), (String)"CUSTOM", (boolean)false) == 0) {
                    this.strScriptCode = this.psSysPanelItem.getCUSTOMCODE();
                    if (StringHelper.IsNullOrEmpty((String)this.strScriptCode)) {
                        throw new Exception("\u672a\u6307\u5b9a\u81ea\u5b9a\u4e49\u4ee3\u7801");
                    }
                }
            }
        }
        this.onPreparePSSysPanelItems();
    }

    protected void onPreparePSNavViewParams() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getITEMPARAMS())) {
            return;
        }
        Properties navViewParams = PropertiesHelper.load((String)this.psSysPanelItem.getITEMPARAMS());
        if (navViewParams != null) {
            for (Object objKey : navViewParams.keySet()) {
                PSNavigateParamImpl PSNavigateParamImpl2;
                boolean bRawValue;
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)navViewParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                bRawValue = true;
                strTag = strKey.toLowerCase();
                if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
            }
        }
    }

    @Override
    protected void onLayout() throws Exception {
        super.onLayout();
        if (StringHelper.Compare((String)this.getLayoutMode(), (String)"TABLE", (boolean)true) == 0 || StringHelper.Compare((String)this.getLayoutMode(), (String)"AUTOTABLE", (boolean)true) == 0) {
            String strColumns = this.psSysPanelItem.getCOLMODEL();
            String[] columns = null;
            if (!StringHelper.IsNullOrEmpty((String)(strColumns = strColumns.trim()))) {
                strColumns = strColumns.replace("\uff1b", ";");
                strColumns = strColumns.replace("\uff0c", ";");
                strColumns = strColumns.replace(",", ";");
                columns = strColumns.split("[;]");
            } else {
                columns = new String[]{"*"};
            }
            int nStarCount = 0;
            this.columnWidths = new double[columns.length];
            double fTotal = 1.0;
            int i = 0;
            while (i < columns.length) {
                String strColumn = columns[i];
                if (StringHelper.IsNullOrEmpty((String)strColumn) || StringHelper.Compare((String)strColumn, (String)"*", (boolean)true) == 0) {
                    ++nStarCount;
                    this.columnWidths[i] = 0.0;
                } else if (strColumn.indexOf("%") == -1) {
                    this.columnWidths[i] = Double.parseDouble(strColumn);
                } else {
                    strColumn = strColumn.replace("%", "");
                    this.columnWidths[i] = Double.parseDouble(strColumn) / 100.0;
                    if (this.columnWidths[i] <= 1.0) {
                        fTotal -= this.columnWidths[i];
                    }
                }
                ++i;
            }
            if (nStarCount > 0) {
                double fStarWidth = fTotal / (double)nStarCount;
                int i2 = 0;
                while (i2 < columns.length) {
                    if (this.columnWidths[i2] == 0.0) {
                        this.columnWidths[i2] = fStarWidth;
                    }
                    ++i2;
                }
            }
            int nColCount = this.columnWidths.length;
            int nRowIndex = -1;
            int nColumnIndex = nColCount;
            block2: for (IPSPanelItem iPSPanelItem : this.psPanelItemList) {
                IPSPanelField iPSPanelField;
                if (iPSPanelItem instanceof IPSPanelField && (iPSPanelField = (IPSPanelField)iPSPanelItem).isHidden()) continue;
                int nColSpan = this.getItemColSpan(iPSPanelItem);
                if (nColSpan > nColCount) {
                    nColSpan = nColCount;
                    this.itemColSpanMap.put(iPSPanelItem.getId(), nColSpan);
                }
                while (true) {
                    if (nColCount - nColumnIndex >= nColSpan) {
                        this.itemRowIdMap.put(iPSPanelItem.getId(), nRowIndex);
                        this.itemColIdMap.put(iPSPanelItem.getId(), nColumnIndex);
                        this.itemColSpanMap.put(iPSPanelItem.getId(), nColSpan);
                        this.itemRowSpanMap.put(iPSPanelItem.getId(), 1);
                        iPSPanelItem.layout();
                        nColumnIndex += nColSpan;
                        continue block2;
                    }
                    ++nRowIndex;
                    nColumnIndex = 0;
                }
            }
            return;
        }
        if (StringHelper.Compare((String)this.getLayoutMode(), (String)"TABLE_12COL", (boolean)true) == 0 || StringHelper.Compare((String)this.getLayoutMode(), (String)"TABLE_24COL", (boolean)true) == 0) {
            if (this.parentPSSysPanelContainer != null) {
                float fX = 1.0f;
                if (this.getColSpan() > 0 && this.parentPSSysPanelContainer.getColumnCount() != 0 && this.parentPSSysPanelContainer.getColumnCount() > this.getColSpan()) {
                    fX = this.getColSpan() / this.parentPSSysPanelContainer.getColumnCount();
                }
            }
            for (IPSPanelItem iPSPanelItem : this.psPanelItemList) {
                IPSPanelField iPSPanelField;
                if (iPSPanelItem instanceof IPSPanelField && (iPSPanelField = (IPSPanelField)iPSPanelItem).isHidden()) continue;
                iPSPanelItem.layout();
            }
            return;
        }
        for (IPSPanelItem iPSPanelItem : this.psPanelItemList) {
            IPSPanelField iPSPanelField;
            if (iPSPanelItem instanceof IPSPanelField && (iPSPanelField = (IPSPanelField)iPSPanelItem).isHidden()) continue;
            iPSPanelItem.layout();
        }
    }

    protected void onPreparePSSysPanelItems() throws Exception {
        this.psPanelItemList.clear();
        ArrayList<PSSysPanelItem> psPanelItemList = this.psSysPanelItem.getChildPSSysPanelItems(false);
        if (psPanelItemList == null) {
            return;
        }
        for (PSSysPanelItem psSysPanelItem : psPanelItemList) {
            if (StringHelper.Compare((String)psSysPanelItem.getITEMTYPE(), (String)"PARAM", (boolean)false) == 0) continue;
            IPSPanelDetailType iPSPanelDetailType = this.getPSModelStorage().getPSPanelDetailType(psSysPanelItem.getITEMTYPE());
            IPSSysPanelItem iPSSysPanelItem = iPSPanelDetailType.createPSSysPanelItem(psSysPanelItem);
            iPSSysPanelItem.init(this.getDAGlobalHelper(), this.iPSSysPanel, this, psSysPanelItem);
            this.psPanelItemList.add(iPSSysPanelItem);
            int nColSpan = psSysPanelItem.getCOLSPAN();
            if (nColSpan <= 0) {
                nColSpan = 1;
                psSysPanelItem.setCOLSPAN(nColSpan);
            }
            this.itemColSpanMap.put(iPSSysPanelItem.getId(), nColSpan);
        }
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psPanelFieldList) {
        for (IPSPanelItem iPSPanelItem : this.psPanelItemList) {
            iPSPanelItem.fillPSPanelFields(psPanelFieldList);
        }
    }

    @Override
    public void fillPSControls(ArrayList<IPSControl> psControlList) {
        for (IPSPanelItem iPSPanelItem : this.psPanelItemList) {
            iPSPanelItem.fillPSControls(psControlList);
        }
    }

    @Override
    public void fillPSPanelItems(ArrayList<IPSPanelItem> psDEFormItemList) {
        for (IPSPanelItem iPSPanelItem : this.psPanelItemList) {
            iPSPanelItem.fillPSPanelItems(psDEFormItemList);
        }
        super.fillPSPanelItems(psDEFormItemList);
    }

    public double[] getColumnWidths() {
        return this.columnWidths;
    }

    public int getItemRowId(IPSPanelItem iPSPanelItem) throws Exception {
        if (this.itemRowIdMap.containsKey(iPSPanelItem.getId())) {
            return this.itemRowIdMap.get(iPSPanelItem.getId());
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u9762\u677f\u6210\u5458"));
    }

    public int getItemRowSpan(IPSPanelItem iPSPanelItem) throws Exception {
        if (this.itemRowSpanMap.containsKey(iPSPanelItem.getId())) {
            return this.itemRowSpanMap.get(iPSPanelItem.getId());
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u9762\u677f\u6210\u5458"));
    }

    public int getItemColId(IPSPanelItem iPSPanelItem) throws Exception {
        if (this.itemColIdMap.containsKey(iPSPanelItem.getId())) {
            return this.itemColIdMap.get(iPSPanelItem.getId());
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u9762\u677f\u6210\u5458"));
    }

    public int getItemColSpan(IPSPanelItem iPSPanelItem) throws Exception {
        if (this.itemColSpanMap.containsKey(iPSPanelItem.getId())) {
            return this.itemColSpanMap.get(iPSPanelItem.getId());
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u9762\u677f\u6210\u5458"));
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSPanelItem iPSPanelItem : this.psPanelItemList) {
            iPSPanelItem.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSPanelItem iPSPanelItem : this.psPanelItemList) {
            iPSPanelItem.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }

    public int getLabelColSpan() {
        return this.nLabelColSpan;
    }

    public int getCtrlColSpan() {
        return this.nCtrlColSpan;
    }

    public int getColumnCount() {
        return this.nColumnCount;
    }

    public int getChildColXS() {
        return this.nChildColXS;
    }

    public int getChildColSM() {
        return this.nChildColSM;
    }

    public int getChildColMD() {
        return this.nChildColMD;
    }

    public int getChildColLG() {
        return this.nChildColLG;
    }

    public String getSubCaption() {
        return this.psSysPanelItem.getRAWCONTENT();
    }

    @PSModelRTMeta(description="Flex\u5e03\u5c40\u65b9\u5411", codelist="FlexLayoutDir", dump=false)
    public String getFlexDir() {
        return this.strFlexDir;
    }

    @PSModelRTMeta(description="Flex\u6a2a\u8f74\u5bf9\u9f50\u65b9\u5411", codelist="FlexAlign", dump=false)
    public String getFlexAlign() {
        return this.strFlexAlign;
    }

    @PSModelRTMeta(description="Flex\u7eb5\u8f74\u5bf9\u9f50\u65b9\u5411", codelist="FlexVAlign", dump=false)
    public String getFlexVAlign() {
        return this.strFlexVAlign;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u8bbe\u7f6e", hideempty=true, child=true)
    public IPSLayout getPSLayout() {
        return this.iPSLayout;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u533a\u57df\u7c7b\u578b", hideempty=true, codelist="DataPanelMode", ignoredumpvalues="INHERIT", fields={"DATAPANELMODE"})
    public String getDataRegionType() {
        return this.strDataRegionType;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6e90\u7c7b\u578b", hideempty=true, codelist="DataPanelSource", fields={"DATASOURCE"})
    public String getDataSourceType() {
        return this.strDataSourceType;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", hideempty=true, dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5904\u7406\u903b\u8f91", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDELOGICID"})
    public IPSAppDELogic getPSAppDELogic() {
        return this.iPSAppDELogic;
    }

    @Override
    public IPSAppDEAction getPSAppDEAction() {
        return this.iPSAppDEAction;
    }

    @Override
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5237\u65b0\u95f4\u9694(ms)", ignoredumpvalues="-1", fields={"GETDATATIMER"})
    public int getReloadTimer() {
        return this.nReloadTimer;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5", dumpref=true, from="IPSAppDataEntity", fields={"PSDEACTIONID", "PSDEDATASETID"})
    public IPSAppDEMethod getPSAppDEMethod() {
        if (this.getPSAppDEAction() != null) {
            return this.getPSAppDEAction();
        }
        if (this.getPSAppDEDataSet() != null) {
            return this.getPSAppDEDataSet();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u540d\u79f0", hideempty2=true)
    public String getDataName() {
        return this.strDataName;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true)
    public String getScriptCode() {
        return this.strScriptCode;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u5904\u7406\u63d0\u793a", ignoredumpvalues="false", fields={"BUSYINDICATOR"})
    public boolean isShowBusyIndicator() {
        return this.bShowBusyIndicator;
    }
}

