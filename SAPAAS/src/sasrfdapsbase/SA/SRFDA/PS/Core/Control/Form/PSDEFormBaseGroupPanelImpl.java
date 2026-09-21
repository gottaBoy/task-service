/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDRUIPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupBase;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDetailImpl;
import SA.SRFDA.PS.Core.Control.IPSControlPreviewable;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutFactory;
import SA.SRFDA.PS.Core.Control.PSThicknessImpl;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormBaseGroupPanelImpl
extends PSDEFormDetailImpl
implements IPSLayoutContainer,
IPSDEFormGroupBase {
    private static final Log log = LogFactory.getLog(PSDEFormBaseGroupPanelImpl.class);
    protected ArrayList<IPSDEFormDetail> psDEFormDetailList = new ArrayList();
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
    private int nTitleBarCloseMode = 0;
    private IPSLayout iPSLayout = null;
    private boolean bInfoGroupMode = false;
    private boolean bHideEmptyItems = false;
    private boolean bEnableAnchor = false;
    private boolean bInfoGroupConvertPickerToLink = false;
    private boolean bInfoGroupReadOnlyMode = false;
    private int nItemIgnoreInput = 0;
    private boolean bItemIgnoreInputDefined = false;

    @Override
    protected void onInit() throws Exception {
        this.margin = !StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getMARGIN()) ? new PSThicknessImpl(this.psDEFormDetail.getMARGIN()) : this.getPSDEForm().getDefaultGroupMargin(this.isShowCaption());
        this.padding = !StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPADDING()) ? new PSThicknessImpl(this.psDEFormDetail.getPADDING()) : this.getPSDEForm().getDefaultGroupPadding(this.isShowCaption());
        if (!this.psDEFormDetail.isENABLEANCHORNull()) {
            this.bEnableAnchor = this.psDEFormDetail.getENABLEANCHOR();
        }
        if (!this.psDEFormDetail.isIGNOREINPUTNull()) {
            this.nItemIgnoreInput = this.psDEFormDetail.getIGNOREINPUT();
            this.bItemIgnoreInputDefined = true;
        }
        super.onInit();
        if (!this.psDEFormDetail.isTITLEBARCLOSEMODENull()) {
            this.nTitleBarCloseMode = this.psDEFormDetail.getTITLEBARCLOSEMODE();
        }
        if (!this.psDEFormDetail.isENABLECONDNull()) {
            this.bInfoGroupMode = this.psDEFormDetail.getENABLECOND() >= 1;
            this.bInfoGroupConvertPickerToLink = this.psDEFormDetail.getENABLECOND() == 3;
            this.bInfoGroupReadOnlyMode = this.psDEFormDetail.getENABLECOND() == 5;
        } else if (this.getParentPSDEFormDetail() instanceof IPSDEFormGroupPanel) {
            this.bInfoGroupMode = ((IPSDEFormGroupPanel)this.getParentPSDEFormDetail()).isInfoGroupMode();
            this.bInfoGroupConvertPickerToLink = ((IPSDEFormGroupPanel)this.getParentPSDEFormDetail()).isInfoGroupConvertPickerToLink();
            this.bInfoGroupReadOnlyMode = ((IPSDEFormGroupPanel)this.getParentPSDEFormDetail()).isInfoGroupReadOnlyMode();
        } else if (this.getPSDEForm() instanceof IPSDEEditForm) {
            this.bInfoGroupMode = ((IPSDEEditForm)this.getPSDEForm()).isInfoFormMode();
            this.bInfoGroupConvertPickerToLink = ((IPSDEEditForm)this.getPSDEForm()).isInfoFormConvertPickerToLink();
            this.bInfoGroupReadOnlyMode = ((IPSDEEditForm)this.getPSDEForm()).isInfoFormReadOnlyMode();
        }
        if (!this.psDEFormDetail.isALLOWEMPTYNull()) {
            this.bHideEmptyItems = this.psDEFormDetail.getALLOWEMPTY();
        } else if (this.getParentPSDEFormDetail() instanceof IPSDEFormGroupPanel) {
            this.bHideEmptyItems = ((IPSDEFormGroupPanel)this.getParentPSDEFormDetail()).isHideEmptyItems();
        }
        this.itemColIdMap = new LinkedHashMap<String, Integer>();
        this.itemRowIdMap = new LinkedHashMap<String, Integer>();
        this.itemColSpanMap = new LinkedHashMap<String, Integer>();
        this.itemRowSpanMap = new LinkedHashMap<String, Integer>();
        String strLayoutMode = this.getLayoutMode();
        if (this.isDesignMode()) {
            IPSPF iPSPF = this.getPSDEForm().getPSAppView().getPSApplication().getPSPF();
            if (iPSPF.isUseJITDesignPreview()) {
                strLayoutMode = ((IPSControlPreviewable)((Object)this.getPSDEForm())).getPreviewPSPF().getFormLayoutMode();
            } else if (StringHelper.Compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0 && this.getPSDEForm().getPSAppView().getPSApplication().getPFType().indexOf("PREVIEW_") != 0) {
                strLayoutMode = "TABLE_12COL";
            }
        }
        if (StringHelper.Compare((String)strLayoutMode, (String)"TABLE_12COL", (boolean)true) == 0) {
            this.nColumnCount = 12;
            this.nChildColMD = 12;
        } else if (StringHelper.Compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            this.nColumnCount = 24;
            this.nChildColMD = 24;
        }
        if (!this.psDEFormDetail.isCHILD_COL_XSNull()) {
            this.nChildColXS = this.psDEFormDetail.getCHILD_COL_XS();
            if (this.getPSDEForm().isEnableCol12ToCol24()) {
                this.nChildColXS *= 2;
            }
            if (this.nChildColXS <= 0 || this.nChildColXS > this.nColumnCount) {
                this.nChildColXS = -1;
            }
        }
        if (!this.psDEFormDetail.isCHILD_COL_SMNull()) {
            this.nChildColSM = this.psDEFormDetail.getCHILD_COL_SM();
            if (this.getPSDEForm().isEnableCol12ToCol24()) {
                this.nChildColSM *= 2;
            }
            if (this.nChildColSM <= 0 || this.nChildColSM > this.nColumnCount) {
                this.nChildColSM = -1;
            }
        }
        if (!this.psDEFormDetail.isCHILD_COL_MDNull()) {
            this.nChildColMD = this.psDEFormDetail.getCHILD_COL_MD();
            if (this.getPSDEForm().isEnableCol12ToCol24()) {
                this.nChildColMD *= 2;
            }
            if (this.nChildColMD <= 0 || this.nChildColMD > this.nColumnCount) {
                this.nChildColMD = this.nColumnCount;
            }
        }
        if (!this.psDEFormDetail.isCHILD_COL_LGNull()) {
            this.nChildColLG = this.psDEFormDetail.getCHILD_COL_LG();
            if (this.getPSDEForm().isEnableCol12ToCol24()) {
                this.nChildColLG *= 2;
            }
            if (this.nChildColLG <= 0 || this.nChildColLG > this.nColumnCount) {
                this.nChildColLG = -1;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strLayoutMode)) {
            this.iPSLayout = PSLayoutFactory.createPSLayout(this, strLayoutMode, this.psDEFormDetail);
        }
        this.onPreparePSDEFormDetails();
    }

    @Override
    protected void onLayout() throws Exception {
        super.onLayout();
        if (StringHelper.Compare((String)this.getLayoutMode(), (String)"TABLE", (boolean)true) == 0 || StringHelper.Compare((String)this.getLayoutMode(), (String)"AUTOTABLE", (boolean)true) == 0) {
            String strColumns = this.psDEFormDetail.getCOLMODEL();
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
            block2: for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
                IPSDEFormItem iPSDEFormItem;
                if (iPSDEFormDetail instanceof IPSDEFormItem && StringHelper.Compare((String)(iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) continue;
                int nColSpan = this.getItemColSpan(iPSDEFormDetail);
                if (nColSpan > nColCount) {
                    nColSpan = nColCount;
                    this.itemColSpanMap.put(iPSDEFormDetail.getId(), nColSpan);
                }
                while (true) {
                    if (nColCount - nColumnIndex >= nColSpan) {
                        this.itemRowIdMap.put(iPSDEFormDetail.getId(), nRowIndex);
                        this.itemColIdMap.put(iPSDEFormDetail.getId(), nColumnIndex);
                        this.itemColSpanMap.put(iPSDEFormDetail.getId(), nColSpan);
                        this.itemRowSpanMap.put(iPSDEFormDetail.getId(), 1);
                        iPSDEFormDetail.layout();
                        nColumnIndex += nColSpan;
                        continue block2;
                    }
                    ++nRowIndex;
                    nColumnIndex = 0;
                }
            }
        }
        if (StringHelper.Compare((String)this.getLayoutMode(), (String)"TABLE_12COL", (boolean)true) == 0 || StringHelper.Compare((String)this.getLayoutMode(), (String)"TABLE_24COL", (boolean)true) == 0) {
            if (this.parentPSDEFormGroupPanel == null) {
                if (this.psDEFormDetail.getLABELCOLSPAN() > 0) {
                    this.nLabelColSpan = this.psDEFormDetail.getLABELCOLSPAN();
                    if (this.getPSDEForm().isEnableCol12ToCol24()) {
                        this.nLabelColSpan *= 2;
                    }
                } else {
                    this.nLabelColSpan = this.getPSDEForm().getLabelColSpan();
                }
                if (this.psDEFormDetail.getCTRLCOLSPAN() > 0) {
                    this.nCtrlColSpan = this.psDEFormDetail.getCTRLCOLSPAN();
                    if (this.getPSDEForm().isEnableCol12ToCol24()) {
                        this.nCtrlColSpan *= 2;
                    }
                } else {
                    this.nCtrlColSpan = this.getPSDEForm().getCtrlColSpan();
                }
            } else {
                float fX = 1.0f;
                if (this.getColSpan() > 0 && this.parentPSDEFormGroupPanel.getColumnCount() != 0 && this.parentPSDEFormGroupPanel.getColumnCount() > this.getColSpan()) {
                    fX = this.getColSpan() / this.parentPSDEFormGroupPanel.getColumnCount();
                }
                if (this.psDEFormDetail.getLABELCOLSPAN() > 0) {
                    this.nLabelColSpan = this.psDEFormDetail.getLABELCOLSPAN();
                    if (this.getPSDEForm().isEnableCol12ToCol24()) {
                        this.nLabelColSpan *= 2;
                    }
                } else {
                    this.nLabelColSpan = Math.round((float)this.parentPSDEFormGroupPanel.getLabelColSpan() / fX);
                }
                if (this.psDEFormDetail.getCTRLCOLSPAN() > 0) {
                    this.nCtrlColSpan = this.psDEFormDetail.getCTRLCOLSPAN();
                    if (this.getPSDEForm().isEnableCol12ToCol24()) {
                        this.nCtrlColSpan *= 2;
                    }
                } else {
                    this.nCtrlColSpan = Math.round((float)this.parentPSDEFormGroupPanel.getCtrlColSpan() / fX);
                }
            }
            for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
                IPSDEFormItem iPSDEFormItem;
                if (iPSDEFormDetail instanceof IPSDEFormItem && StringHelper.Compare((String)(iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) continue;
                iPSDEFormDetail.layout();
            }
        }
        if (StringHelper.Compare((String)this.getLayoutMode(), (String)"BORDER", (boolean)true) == 0) {
            for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
                IPSDEFormItem iPSDEFormItem;
                if (iPSDEFormDetail instanceof IPSDEFormItem && StringHelper.Compare((String)(iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) continue;
                iPSDEFormDetail.layout();
            }
        }
    }

    protected void onPreparePSDEFormDetails() throws Exception {
        this.psDEFormDetailList.clear();
        ArrayList<PSDEFormDetail> psDEFormDetailList = this.psDEFormDetail.getChildPSDEFormDetails(false);
        if (psDEFormDetailList == null) {
            return;
        }
        for (PSDEFormDetail psDEFormDetail : psDEFormDetailList) {
            IPSFormDetailType iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            IPSDEFormDetail iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this.iPSDEForm, this, psDEFormDetail);
            this.psDEFormDetailList.add(iPSDEFormDetail);
            int nColSpan = psDEFormDetail.getCOLSPAN();
            if (nColSpan <= 0) {
                nColSpan = 1;
                psDEFormDetail.setCOLSPAN(nColSpan);
            }
            this.itemColSpanMap.put(iPSDEFormDetail.getId(), nColSpan);
        }
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            iPSDEFormDetail.fillPSDEFormItems(psDEFormItemList);
        }
    }

    @Override
    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> psDEFormDetailList) {
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            iPSDEFormDetail.fillPSDEFormDetails(psDEFormDetailList);
        }
        super.fillPSDEFormDetails(psDEFormDetailList);
    }

    @Override
    public double[] getColumnWidths() {
        return this.columnWidths;
    }

    @Override
    public int getItemRowId(IPSDEFormDetail iPSDEFormDetail) throws Exception {
        if (this.itemRowIdMap.containsKey(iPSDEFormDetail.getId())) {
            return this.itemRowIdMap.get(iPSDEFormDetail.getId());
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u8868\u5355\u6210\u5458"));
    }

    @Override
    public int getItemRowSpan(IPSDEFormDetail iPSDEFormDetail) throws Exception {
        if (this.itemRowSpanMap.containsKey(iPSDEFormDetail.getId())) {
            return this.itemRowSpanMap.get(iPSDEFormDetail.getId());
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u8868\u5355\u6210\u5458"));
    }

    @Override
    public int getItemColId(IPSDEFormDetail iPSDEFormDetail) throws Exception {
        if (this.itemColIdMap.containsKey(iPSDEFormDetail.getId())) {
            return this.itemColIdMap.get(iPSDEFormDetail.getId());
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u8868\u5355\u6210\u5458"));
    }

    @Override
    public int getItemColSpan(IPSDEFormDetail iPSDEFormDetail) throws Exception {
        if (this.itemColSpanMap.containsKey(iPSDEFormDetail.getId())) {
            return this.itemColSpanMap.get(iPSDEFormDetail.getId());
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u8868\u5355\u6210\u5458"));
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            iPSDEFormDetail.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            iPSDEFormDetail.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }

    @Override
    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList) {
        super.fillPSDEFormDRUIParts(psDEFormDRUIPartList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            iPSDEFormDetail.fillPSDEFormDRUIParts(psDEFormDRUIPartList);
        }
    }

    @Override
    public int getLabelColSpan() {
        return this.nLabelColSpan;
    }

    @Override
    public int getCtrlColSpan() {
        return this.nCtrlColSpan;
    }

    @Override
    public int getColumnCount() {
        return this.nColumnCount;
    }

    @Override
    public int getChildColXS() {
        return this.nChildColXS;
    }

    @Override
    public int getChildColSM() {
        return this.nChildColSM;
    }

    @Override
    public int getChildColMD() {
        return this.nChildColMD;
    }

    @Override
    public int getChildColLG() {
        return this.nChildColLG;
    }

    @Override
    public int getTitleBarCloseMode() {
        return this.nTitleBarCloseMode;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6807\u9898\u7ed1\u5b9a\u503c\u9879", fields={"VALUEITEMNAME"})
    public String getCaptionItemName() {
        return this.psDEFormDetail.getVALUEITEMNAME();
    }

    @PSModelRTMeta(description="\u5b50\u6807\u9898", fields={"RAWCONTENT"})
    public String getSubCaption() {
        return this.psDEFormDetail.getRAWCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u8bbe\u7f6e", hideempty=true, child=true)
    public IPSLayout getPSLayout() {
        return this.iPSLayout;
    }

    @Override
    public String getModelName() {
        if (!StringHelper.IsNullOrEmpty((String)this.getCaption())) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)super.getModelName(), (Object)this.getCaption());
        }
        return super.getModelName();
    }

    @PSModelRTMeta(description="\u4fe1\u606f\u9762\u677f\u6a21\u5f0f", fields={"ENABLECOND"})
    public boolean isInfoGroupMode() {
        return this.bInfoGroupMode;
    }

    @PSModelRTMeta(description="\u4fe1\u606f\u9762\u677f\u8f6c\u5316\u9009\u62e9\u90e8\u4ef6\u81f3\u94fe\u63a5\u90e8\u4ef6", dump=false)
    public boolean isInfoGroupConvertPickerToLink() {
        return this.bInfoGroupConvertPickerToLink;
    }

    @PSModelRTMeta(description="\u4fe1\u606f\u9762\u677f\u542f\u7528\u53ea\u8bfb\u6a21\u5f0f", dump=false)
    public boolean isInfoGroupReadOnlyMode() {
        return this.bInfoGroupReadOnlyMode;
    }

    @PSModelRTMeta(description="\u9690\u85cf\u65e0\u503c\u8868\u5355\u9879", ignoredumpvalues="false", fields={"ALLOWEMPTY"})
    public boolean isHideEmptyItems() {
        return this.bHideEmptyItems;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSDEFormDetail> getPSDEFormDetails() {
        return this.psDEFormDetailList.iterator();
    }

    @Override
    public int getPSDEFormDetailCount() {
        return this.psDEFormDetailList.size();
    }

    @Override
    public IPSDEFormDetail getPSDEFormDetail(int nIndex) throws Exception {
        return this.psDEFormDetailList.get(nIndex);
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u4f9b\u951a\u70b9", ignoredumpvalues="false", fields={"ENABLEANCHOR"})
    public boolean isEnableAnchor() {
        return this.bEnableAnchor;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u9879\u5ffd\u7565\u8f93\u5165\u6a21\u5f0f", ignoredumpvalues="0")
    public int getItemIgnoreInput() {
        if (this.bItemIgnoreInputDefined) {
            return this.nItemIgnoreInput;
        }
        if (this.getParentPSDEFormDetail() instanceof IPSDEFormGroupBase) {
            return ((IPSDEFormGroupBase)this.getParentPSDEFormDetail()).getItemIgnoreInput();
        }
        return this.nItemIgnoreInput;
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u4e49\u6210\u5458\u9879\u5ffd\u7565\u8f93\u5165\u6a21\u5f0f", dump=false)
    public boolean isItemIgnoreInputDefined() {
        if (this.bItemIgnoreInputDefined) {
            return true;
        }
        if (this.getParentPSDEFormDetail() instanceof IPSDEFormGroupBase) {
            return ((IPSDEFormGroupBase)this.getParentPSDEFormDetail()).isItemIgnoreInputDefined();
        }
        return false;
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strCtrlName = this.getPSDEForm().getName();
        String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_%3$s_click", (Object)strCtrlName, (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDEForm(), psAppViewLogic, iPSAppViewUIAction);
        this.getPSDEForm().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }
}

