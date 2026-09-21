/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEForm
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSFR7CtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSFR7DEFormViewCodePublisherImpl
extends PSFR7CtrlCodePublisherImpl {
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
        ArrayList<IPSGenerateCodeResult> hiddenList = new ArrayList<IPSGenerateCodeResult>();
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("HIDDENFORMITEM").getPSPFCtrlPartCodePublisher();
        Iterator psDEFormItems = this.iPSDEForm.getPSDEFormItems();
        while (psDEFormItems.hasNext()) {
            IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)psDEFormItems.next();
            if (!iPSDEFormItem.isHidden()) continue;
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEForm, (Object)iPSDEFormItem);
            hiddenList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("hiddens", hiddenList);
        ArrayList<IPSGenerateCodeResult> formPageList = new ArrayList<IPSGenerateCodeResult>();
        iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("FORMPAGE").getPSPFCtrlPartCodePublisher();
        Iterator psDEFormPages = this.iPSDEForm.getPSDEFormPages();
        while (psDEFormPages.hasNext()) {
            iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEForm, (Object)iPSDEFormPage);
            formPageList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("formpages", formPageList);
        ArrayList<IPSGenerateCodeResult> formDetailList = new ArrayList<IPSGenerateCodeResult>();
        iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("FORMPAGE").getPSPFCtrlPartCodePublisher();
        psDEFormPages = this.iPSDEForm.getPSDEFormPages();
        while (psDEFormPages.hasNext()) {
            iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEForm, (Object)iPSDEFormPage);
            formDetailList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
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
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(childPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEForm, (Object)childPSDEFormDetail);
                formDetailList.add(iPSGenerateCodeResult);
                iPSPFCtrlPartCodePublisher.close();
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
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEForm, (Object)iPSDEFormTabPage);
                formDetailList.add(iPSGenerateCodeResult);
                iPSPFCtrlPartCodePublisher.close();
            }
            psDEFormTabPages = iPSDEFormTabPanel.getPSDEFormTabPages();
            while (psDEFormTabPages.hasNext()) {
                iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
                this.fillPSDEFormDetails((IPSDEFormDetail)iPSDEFormTabPage, formDetailList);
            }
            return;
        }
    }

    protected void onClose() {
        this.iPSDEForm = null;
        super.onClose();
    }
}

