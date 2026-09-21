/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemEx;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.PSDEEditFormItemImpl;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorContainerEx;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEEditFormItemExImpl
extends PSDEEditFormItemImpl
implements IPSDEFormItemEx,
IPSEditorContainerEx {
    private static final Log log = LogFactory.getLog(PSDEEditFormItemExImpl.class);
    protected ArrayList<IPSDEFormItem> psDEFormItemList = new ArrayList();
    protected ArrayList<String> formItemNameList = new ArrayList();
    private boolean bPreparePSDEFormItems = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEFormItems();
        this.bPreparePSDEFormItems = true;
        this.preparePSEditor();
    }

    protected void onPreparePSDEFormItems() throws Exception {
        this.psDEFormItemList.clear();
        this.formItemNameList.clear();
        ArrayList<PSDEFormDetail> psDEFormDetailList = this.psDEFormDetail.getChildPSDEFormDetails(false);
        if (psDEFormDetailList == null) {
            return;
        }
        for (PSDEFormDetail psDEFormDetail : psDEFormDetailList) {
            IPSFormDetailType iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            IPSDEFormDetail iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this.iPSDEForm, this, psDEFormDetail);
            this.psDEFormItemList.add((IPSDEFormItem)iPSDEFormDetail);
            this.formItemNameList.add(iPSDEFormDetail.getName());
        }
    }

    @Override
    protected void preparePSEditor() throws Exception {
        if (!this.bPreparePSDEFormItems) {
            return;
        }
        super.preparePSEditor();
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            iPSDEFormItem.fillPSDEFormItems(psDEFormItemList);
        }
        super.fillPSDEFormItems(psDEFormItemList);
    }

    @Override
    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> psDEFormDetailList) {
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            iPSDEFormItem.fillPSDEFormDetails(psDEFormDetailList);
        }
        super.fillPSDEFormDetails(psDEFormDetailList);
    }

    public Iterator<String> getItemNames() {
        return this.formItemNameList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSDEFormItem> getPSDEFormItems() {
        return this.psDEFormItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u590d\u5408\u8868\u5355\u9879")
    public boolean isCompositeItem() {
        return true;
    }

    @Override
    protected String onGetDetailType() {
        return "FORMITEM";
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_FORMITEMEX";
    }

    @Override
    public Iterator<? extends IPSEditorContainer> getPSEditorContainers() {
        return this.psDEFormItemList.iterator();
    }
}

