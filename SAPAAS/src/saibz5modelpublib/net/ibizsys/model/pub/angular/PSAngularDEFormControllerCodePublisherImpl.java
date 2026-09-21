/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormGroupPanel
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormPage
 *  net.ibizsys.model.control.form.IPSDEFormTabPage
 *  net.ibizsys.model.control.form.IPSDEFormTabPanel
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.angular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormGroupPanel;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormPage;
import net.ibizsys.model.control.form.IPSDEFormTabPage;
import net.ibizsys.model.control.form.IPSDEFormTabPanel;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.angular.PSAngularCtrlCodePublisherImpl;

public class PSAngularDEFormControllerCodePublisherImpl
extends PSAngularCtrlCodePublisherImpl {
    protected IPSDEForm iPSDEForm = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEForm = (IPSDEForm)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSDEFormPage iPSDEFormPage;
        IPSGenerateCodeResult iPSGenerateCodeResult;
        super.onFillGenerateCodeParams(params);
        this.iPSDEForm = (IPSDEForm)this.iPSControl;
        ArrayList<IPSGenerateCodeResult> formDetailList = new ArrayList<IPSGenerateCodeResult>();
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("HIDDENFORMITEM").getPSPFCtrlPartCodePublisher();
        Iterator psDEFormItems = this.iPSDEForm.getPSDEFormItems();
        while (psDEFormItems.hasNext()) {
            IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)psDEFormItems.next();
            if (!iPSDEFormItem.isHidden()) continue;
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEForm, (Object)iPSDEFormItem);
            formDetailList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("FORMPAGE").getPSPFCtrlPartCodePublisher();
        Iterator psDEFormPages = this.iPSDEForm.getPSDEFormPages();
        while (psDEFormPages.hasNext()) {
            iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEForm, (Object)iPSDEFormPage);
            formDetailList.add(iPSGenerateCodeResult);
        }
        psDEFormPages = this.iPSDEForm.getPSDEFormPages();
        while (psDEFormPages.hasNext()) {
            iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
            this.fillPSDEFormDetails((IPSDEFormDetail)iPSDEFormPage, formDetailList);
        }
        params.put("formdetails", formDetailList);
    }

    protected void fillPSDEFormDetails(IPSDEFormDetail iPSDEFormDetail, ArrayList<IPSGenerateCodeResult> formDetailList) throws Exception {
        if (iPSDEFormDetail instanceof IPSDEFormGroupPanel) {
            IPSDEFormDetail childPSDEFormDetail;
            IPSDEFormGroupPanel iPSDEFormGroupPanel = (IPSDEFormGroupPanel)iPSDEFormDetail;
            Iterator psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
            while (psDEFormDetails.hasNext()) {
                childPSDEFormDetail = (IPSDEFormDetail)psDEFormDetails.next();
                if (childPSDEFormDetail instanceof IPSDEFormItem && ((IPSDEFormItem)childPSDEFormDetail).isHidden()) continue;
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(childPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEForm, (Object)childPSDEFormDetail);
                formDetailList.add(iPSGenerateCodeResult);
            }
            psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
            while (psDEFormDetails.hasNext()) {
                childPSDEFormDetail = (IPSDEFormDetail)psDEFormDetails.next();
                this.fillPSDEFormDetails(childPSDEFormDetail, formDetailList);
            }
            return;
        }
        if (iPSDEFormDetail instanceof IPSDEFormTabPanel) {
            IPSDEFormTabPage iPSDEFormTabPage;
            IPSDEFormTabPanel iPSDEFormTabPanel = (IPSDEFormTabPanel)iPSDEFormDetail;
            Iterator psDEFormTabPages = iPSDEFormTabPanel.getPSDEFormTabPages();
            while (psDEFormTabPages.hasNext()) {
                iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSDEFormTabPage.getDetailType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEForm, (Object)iPSDEFormTabPage);
                formDetailList.add(iPSGenerateCodeResult);
            }
            psDEFormTabPages = iPSDEFormTabPanel.getPSDEFormTabPages();
            while (psDEFormTabPages.hasNext()) {
                iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
                this.fillPSDEFormDetails((IPSDEFormDetail)iPSDEFormTabPage, formDetailList);
            }
            return;
        }
    }
}

