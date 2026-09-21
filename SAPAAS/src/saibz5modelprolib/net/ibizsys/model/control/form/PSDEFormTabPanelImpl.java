/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.form.IPSDEFormDRUIPart
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormTabPage
 *  net.ibizsys.model.control.form.IPSDEFormTabPanel
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormDetailRuntime;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormTabPage;
import net.ibizsys.model.control.form.IPSDEFormTabPanel;
import net.ibizsys.model.control.form.PSDEFormDetailImpl;
import net.ibizsys.model.entity.PSDEFormDetail;

public class PSDEFormTabPanelImpl
extends PSDEFormDetailImpl
implements IPSDEFormTabPanel {
    protected ArrayList<IPSDEFormTabPage> psDEFormTabPageList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEFormTabPages();
    }

    protected void onPreparePSDEFormTabPages() throws Exception {
        this.psDEFormTabPageList.clear();
        ArrayList<PSDEFormDetail> psDEFormDetailList = this.psDEFormDetail.getChildPSDEFormDetails(false);
        if (psDEFormDetailList == null) {
            return;
        }
        for (PSDEFormDetail psDEFormDetail : psDEFormDetailList) {
            IPSDEFormDetail iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this.getPSDEForm(), this, psDEFormDetail);
            this.psDEFormTabPageList.add((IPSDEFormTabPage)iPSDEFormDetail);
        }
    }

    public Iterator<IPSDEFormTabPage> getPSDEFormTabPages() {
        return this.psDEFormTabPageList.iterator();
    }

    @Override
    public boolean isShowCaption() {
        return false;
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
        for (IPSDEFormTabPage iPSDEFormTabPage : this.psDEFormTabPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormTabPage).fillPSDEFormItems(psDEFormItemList);
        }
    }

    @Override
    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> psDEFormDetailList) {
        for (IPSDEFormTabPage iPSDEFormTabPage : this.psDEFormTabPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormTabPage).fillPSDEFormDetails(psDEFormDetailList);
        }
        super.fillPSDEFormDetails(psDEFormDetailList);
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormTabPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormDetail).fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormTabPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormDetail).fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }

    @Override
    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList) {
        super.fillPSDEFormDRUIParts(psDEFormDRUIPartList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormTabPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormDetail).fillPSDEFormDRUIParts(psDEFormDRUIPartList);
        }
    }

    @Override
    protected void onLayout() throws Exception {
        super.onLayout();
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormTabPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormDetail).layout();
        }
    }
}

