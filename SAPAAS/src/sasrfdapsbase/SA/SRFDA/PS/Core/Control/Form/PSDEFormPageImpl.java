/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormBaseGroupPanelImpl;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import java.util.Iterator;

public class PSDEFormPageImpl
extends PSDEFormBaseGroupPanelImpl
implements IPSDEFormPage {
    private int nFirstLabelColSpan = 2;
    private int nPageIndex = -1;
    public static final String PARAM_PAGEINDEX = "PAGEINDEX";

    @Override
    protected void onInit() throws Exception {
        this.nPageIndex = this.psDEFormDetail.GetParamIntValue(PARAM_PAGEINDEX, this.nPageIndex);
        super.onInit();
    }

    @Override
    protected void onLayout() throws Exception {
        this.fWidth = this.getPSDEForm().getFormWidth();
        if (this.fWidth > 1.0) {
            this.fWidth -= (double)(this.getMargin().getLeft() + this.getMargin().getRight());
        }
        this.fContentWidth = this.fWidth;
        this.nFirstLabelColSpan = this.psDEFormDetail.getLABELCOLSPAN2() > 0 ? this.psDEFormDetail.getLABELCOLSPAN2() : this.getPSDEForm().getFirstLabelColSpan();
        super.onLayout();
    }

    @Override
    public boolean isShowCaption() {
        return true;
    }

    @Override
    public int getFirstLabelColSpan() {
        return this.nFirstLabelColSpan;
    }

    @Override
    public int getPageIndex() {
        return this.nPageIndex;
    }

    @Override
    public boolean isEnableAnchor() {
        return false;
    }

    @Override
    public int getBuildInActions() {
        return 0;
    }

    @Override
    public boolean isEnableBuildInAction(int nAction) {
        return false;
    }

    @Override
    public int getPSDEFormDetailCount() {
        return this.psDEFormDetailList.size();
    }

    @Override
    public IPSDEFormDetail getPSDEFormDetail(int nIndex) throws Exception {
        return (IPSDEFormDetail)this.psDEFormDetailList.get(nIndex);
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_FORMPAGE";
    }

    @Override
    public IPSUIActionGroup getPSUIActionGroup() {
        return null;
    }

    @Override
    public String getActionGroupExtractMode() {
        return null;
    }

    @Override
    public Iterator<IPSDEFormItem> getAnchorablePSDEFormItems() {
        return null;
    }

    @Override
    public IPSDEFormDetail addPSDEFormDetail(PSDEFormDetail psDEFormDetail) throws Exception {
        IPSFormDetailType iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
        IPSDEFormDetail iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
        iPSDEFormDetail.init(this.getDAGlobalHelper(), this.getPSDEForm(), this, psDEFormDetail);
        this.psDEFormDetailList.add(iPSDEFormDetail);
        return iPSDEFormDetail;
    }
}

