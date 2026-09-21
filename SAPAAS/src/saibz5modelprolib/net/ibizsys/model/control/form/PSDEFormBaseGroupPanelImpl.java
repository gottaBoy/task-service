/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSModelJsonExporter
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.form.IPSDEFormDRUIPart
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormDetailRuntime;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.PSDEFormDetailImpl;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSDEFormBaseGroupPanelImpl
extends PSDEFormDetailImpl {
    protected ArrayList<IPSDEFormDetail> psDEFormDetailList = new ArrayList();
    protected double[] columnWidths = null;
    protected HashMap<String, Integer> itemColIdMap = null;
    protected HashMap<String, Integer> itemRowIdMap = null;
    protected HashMap<String, Integer> itemColSpanMap = null;
    protected HashMap<String, Integer> itemRowSpanMap = null;
    private int nColumnCount = 0;
    private int nLabelColSpan = 1;
    private int nCtrlColSpan = 2;
    private int nChildColXS = -1;
    private int nChildColSM = -1;
    private int nChildColMD = 12;
    private int nChildColLG = -1;
    private int nTitleBarCloseMode = 0;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psDEFormDetail.isTITLEBARCLOSEMODENull()) {
            this.nTitleBarCloseMode = this.psDEFormDetail.getTITLEBARCLOSEMODE();
        }
        this.itemColIdMap = new HashMap();
        this.itemRowIdMap = new HashMap();
        this.itemColSpanMap = new HashMap();
        this.itemRowSpanMap = new HashMap();
        String strLayoutMode = this.getLayoutMode();
        this.isDesignMode();
        if (StringHelper.compare((String)strLayoutMode, (String)"TABLE_12COL", (boolean)true) == 0) {
            this.nColumnCount = 12;
            this.nChildColMD = 12;
        } else if (StringHelper.compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            this.nColumnCount = 24;
            this.nChildColMD = 24;
        }
        if (!this.psDEFormDetail.isCHILD_COL_XSNull()) {
            this.nChildColXS = this.psDEFormDetail.getCHILD_COL_XS();
            if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                this.nChildColXS *= 2;
            }
            if (this.nChildColXS <= 0 && this.nChildColXS > this.nColumnCount) {
                this.nChildColXS = -1;
            }
        }
        if (!this.psDEFormDetail.isCHILD_COL_SMNull()) {
            this.nChildColSM = this.psDEFormDetail.getCHILD_COL_SM();
            if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                this.nChildColSM *= 2;
            }
            if (this.nChildColSM <= 0 && this.nChildColSM > this.nColumnCount) {
                this.nChildColSM = -1;
            }
        }
        if (!this.psDEFormDetail.isCHILD_COL_MDNull()) {
            this.nChildColMD = this.psDEFormDetail.getCHILD_COL_MD();
            if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                this.nChildColMD *= 2;
            }
            if (this.nChildColMD <= 0 && this.nChildColMD > this.nColumnCount) {
                this.nChildColMD = this.nColumnCount;
            }
        }
        if (!this.psDEFormDetail.isCHILD_COL_LGNull()) {
            this.nChildColLG = this.psDEFormDetail.getCHILD_COL_LG();
            if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                this.nChildColLG *= 2;
            }
            if (this.nChildColLG <= 0 && this.nChildColLG > this.nColumnCount) {
                this.nChildColLG = -1;
            }
        }
        this.onPreparePSDEFormDetails();
    }

    @Override
    protected void onLayout() throws Exception {
        IPSDEFormItem iPSDEFormItem;
        super.onLayout();
        if (StringHelper.compare((String)this.getLayoutMode(), (String)"TABLE_12COL", (boolean)true) == 0 || StringHelper.compare((String)this.getLayoutMode(), (String)"TABLE_24COL", (boolean)true) == 0) {
            if (this.parentPSDEFormGroupPanel == null) {
                if (this.psDEFormDetail.getLABELCOLSPAN() > 0) {
                    this.nLabelColSpan = this.psDEFormDetail.getLABELCOLSPAN();
                    if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                        this.nLabelColSpan *= 2;
                    }
                } else {
                    this.nLabelColSpan = this.getPSDEForm().getLabelColSpan();
                }
                if (this.psDEFormDetail.getCTRLCOLSPAN() > 0) {
                    this.nCtrlColSpan = this.psDEFormDetail.getCTRLCOLSPAN();
                    if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
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
                    if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                        this.nLabelColSpan *= 2;
                    }
                } else {
                    this.nLabelColSpan = Math.round((float)this.parentPSDEFormGroupPanel.getLabelColSpan() / fX);
                }
                if (this.psDEFormDetail.getCTRLCOLSPAN() > 0) {
                    this.nCtrlColSpan = this.psDEFormDetail.getCTRLCOLSPAN();
                    if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                        this.nCtrlColSpan *= 2;
                    }
                } else {
                    this.nCtrlColSpan = Math.round((float)this.parentPSDEFormGroupPanel.getCtrlColSpan() / fX);
                }
            }
            for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
                if (iPSDEFormDetail instanceof IPSDEFormItem && StringHelper.compare((String)(iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) continue;
                ((IPSDEFormDetailRuntime)iPSDEFormDetail).layout();
            }
        }
        if (StringHelper.compare((String)this.getLayoutMode(), (String)"BORDER", (boolean)true) == 0) {
            for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
                if (iPSDEFormDetail instanceof IPSDEFormItem && StringHelper.compare((String)(iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) continue;
                ((IPSDEFormDetailRuntime)iPSDEFormDetail).layout();
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
            IPSDEFormDetail iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this.getPSDEForm(), this, psDEFormDetail);
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
            ((IPSDEFormDetailRuntime)iPSDEFormDetail).fillPSDEFormItems(psDEFormItemList);
        }
    }

    @Override
    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> psDEFormDetailList) {
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            ((IPSDEFormDetailRuntime)iPSDEFormDetail).fillPSDEFormDetails(psDEFormDetailList);
        }
        super.fillPSDEFormDetails(psDEFormDetailList);
    }

    public double[] getColumnWidths() {
        return this.columnWidths;
    }

    public int getItemRowId(IPSDEFormDetail iPSDEFormDetail) throws Exception {
        if (this.itemRowIdMap.containsKey(iPSDEFormDetail.getId())) {
            return this.itemRowIdMap.get(iPSDEFormDetail.getId());
        }
        throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u8868\u5355\u6210\u5458"));
    }

    public int getItemRowSpan(IPSDEFormDetail iPSDEFormDetail) throws Exception {
        if (this.itemRowSpanMap.containsKey(iPSDEFormDetail.getId())) {
            return this.itemRowSpanMap.get(iPSDEFormDetail.getId());
        }
        throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u8868\u5355\u6210\u5458"));
    }

    public int getItemColId(IPSDEFormDetail iPSDEFormDetail) throws Exception {
        if (this.itemColIdMap.containsKey(iPSDEFormDetail.getId())) {
            return this.itemColIdMap.get(iPSDEFormDetail.getId());
        }
        throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u8868\u5355\u6210\u5458"));
    }

    public int getItemColSpan(IPSDEFormDetail iPSDEFormDetail) throws Exception {
        if (this.itemColSpanMap.containsKey(iPSDEFormDetail.getId())) {
            return this.itemColSpanMap.get(iPSDEFormDetail.getId());
        }
        throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u8868\u5355\u6210\u5458"));
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            ((IPSDEFormDetailRuntime)iPSDEFormDetail).fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            ((IPSDEFormDetailRuntime)iPSDEFormDetail).fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }

    @Override
    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList) {
        super.fillPSDEFormDRUIParts(psDEFormDRUIPartList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            ((IPSDEFormDetailRuntime)iPSDEFormDetail).fillPSDEFormDRUIParts(psDEFormDRUIPartList);
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

    public int getTitleBarCloseMode() {
        return this.nTitleBarCloseMode;
    }

    public String getCaptionItemName() {
        return this.psDEFormDetail.getVALUEITEMNAME();
    }

    public String getSubCaption() {
        return this.psDEFormDetail.getRAWCONTENT();
    }

    @Override
    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        super.onFillJsonObject(objectNode);
        if (!StringHelper.isNullOrEmpty((String)this.getCaption())) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)"caption", (Object)this.getCaption());
        }
        ArrayList<ObjectNode> itemList = new ArrayList<ObjectNode>();
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            ObjectNode psDEFormPageObjectNode = ((IPSModelJsonExporter)iPSDEFormDetail).toJsonObject(null);
            itemList.add(psDEFormPageObjectNode);
        }
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"items", itemList);
    }
}

