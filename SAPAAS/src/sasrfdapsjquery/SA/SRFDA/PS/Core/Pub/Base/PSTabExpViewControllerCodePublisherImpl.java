/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher
 */
package SA.SRFDA.PS.Core.Pub.Base;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.Base.PSViewControllerCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSTabExpViewControllerCodePublisherImpl
extends PSViewControllerCodePublisherImpl {
    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        Iterator iterator = this.iPSAppView.getPSControls();
        ArrayList<IPSControl> controls = new ArrayList<IPSControl>();
        iterator.hasNext();
        while (iterator.hasNext()) {
            IPSControl control = (IPSControl)iterator.next();
            if (control.getControlType() != "TABVIEWPANEL") continue;
            controls.add(control);
        }
        int i = 0;
        while (i < controls.size()) {
            int j = i + 1;
            while (j < controls.size()) {
                IPSControl c1 = (IPSControl)controls.get(i);
                IPSControl c2 = (IPSControl)controls.get(j);
                if (c1.getOrderValue() > c2.getOrderValue()) {
                    controls.remove(j);
                    controls.add(i, c2);
                }
                ++j;
            }
            ++i;
        }
        params.put("tabviewpanelcontrols", controls);
        ArrayList<IPSGenerateCodeResult> codes = new ArrayList<IPSGenerateCodeResult>();
        int i2 = 0;
        while (i2 < controls.size()) {
            IPSControl control = (IPSControl)controls.get(i2);
            IPSPFCtrlTempl iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(control.getPSControlType(), this.getPSPFPubCode());
            if (iPSPFCtrlTempl != null) {
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, control);
                if (iPSGenerateCodeResult != null) {
                    codes.add(iPSGenerateCodeResult);
                }
                iPSPFCtrlCodePublisher.close();
            }
            ++i2;
        }
        params.put("tabviewpanels", codes);
    }
}

