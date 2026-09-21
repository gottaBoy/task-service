/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.WizardPanel.IPSDEWizardPanel
 *  SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub.Ionic4;

import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.WizardPanel.IPSDEWizardPanel;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4CtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIonic4DEWizardCodePublisherImpl
extends PSIonic4CtrlCodePublisherImpl {
    protected IPSDEWizardPanel iPSDEWizardPanel = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEWizardPanel = (IPSDEWizardPanel)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        this.iPSDEWizardPanel = (IPSDEWizardPanel)this.iPSControl;
        Iterator psDEEditForms = this.iPSDEWizardPanel.getPSDEEditForms();
        if (psDEEditForms != null) {
            ArrayList<IPSGenerateCodeResult> wizardFormList = new ArrayList<IPSGenerateCodeResult>();
            while (psDEEditForms.hasNext()) {
                IPSDEEditForm iPSDEEditForm = (IPSDEEditForm)psDEEditForms.next();
                IPSPFCtrlTempl iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(iPSDEEditForm.getPSControlType(), this.getPSPFPubCode());
                if (iPSPFCtrlTempl == null) continue;
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)iPSDEEditForm);
                if (iPSGenerateCodeResult != null) {
                    wizardFormList.add(iPSGenerateCodeResult);
                }
                iPSPFCtrlCodePublisher.close();
            }
            params.put("wizardforms", wizardFormList);
        }
    }

    protected void onClose() {
        this.iPSDEWizardPanel = null;
        super.onClose();
    }
}

