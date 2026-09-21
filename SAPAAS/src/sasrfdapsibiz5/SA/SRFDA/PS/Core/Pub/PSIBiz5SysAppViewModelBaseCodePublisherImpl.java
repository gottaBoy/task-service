/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppViewCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppViewModelBaseCodePublisherImpl
extends PSIBiz5SysAppViewCodePublisherImpl {
    public static final String CODETEMPL_CONTROL_ANNO = "CONTROL_ANNO";
    public static final String CODETEMPL_ANNO = "_ANNO";
    public static final String CODETEMPL_ANNOHELPERPARAM = "_ANNOHELPERPARAM";
    public static final String CODETEMPL_ANNOHELPERPARAMINIT = "_ANNOHELPERPARAMINIT";

    @Override
    protected void onGenerateAppViewCode(IPSAppView iPSAppView, ArrayList<PSSysSFCode> list) throws Exception {
        IPSGenerateCodeResult iPSGenerateCodeResult;
        IPSControl iPSControl;
        HashMap params = new HashMap();
        ArrayList<IPSGenerateCodeResult> ctrls = new ArrayList<IPSGenerateCodeResult>();
        Iterator psControls = iPSAppView.getPSControls();
        while (psControls.hasNext()) {
            iPSControl = (IPSControl)psControls.next();
            if (!iPSControl.getPSControlType().isAjaxControl()) continue;
            iPSGenerateCodeResult = this.generateCode(CODETEMPL_CONTROL_ANNO, iPSControl, null);
            ctrls.add(iPSGenerateCodeResult);
        }
        params.put("ctrlannos", ctrls);
        ctrls = new ArrayList();
        psControls = iPSAppView.getPSControls();
        while (psControls.hasNext()) {
            iPSControl = (IPSControl)psControls.next();
            if (!iPSControl.getPSControlType().isAjaxControl()) continue;
            iPSGenerateCodeResult = this.generateCode(String.valueOf(iPSControl.getControlType()) + CODETEMPL_ANNO, iPSControl, null);
            ctrls.add(iPSGenerateCodeResult);
        }
        params.put("realctrlannos", ctrls);
        ctrls = new ArrayList();
        psControls = iPSAppView.getPSControls();
        while (psControls.hasNext()) {
            iPSControl = (IPSControl)psControls.next();
            if (!iPSControl.getPSControlType().isAjaxControl()) continue;
            iPSGenerateCodeResult = this.generateCode(String.valueOf(iPSControl.getControlType()) + CODETEMPL_ANNOHELPERPARAM, iPSControl, null);
            ctrls.add(iPSGenerateCodeResult);
        }
        params.put("ctrlannoparams", ctrls);
        ctrls = new ArrayList();
        psControls = iPSAppView.getPSControls();
        while (psControls.hasNext()) {
            iPSControl = (IPSControl)psControls.next();
            if (!iPSControl.getPSControlType().isAjaxControl()) continue;
            iPSGenerateCodeResult = this.generateCode(String.valueOf(iPSControl.getControlType()) + CODETEMPL_ANNOHELPERPARAMINIT, iPSControl, null);
            ctrls.add(iPSGenerateCodeResult);
        }
        params.put("ctrlannoparaminits", ctrls);
        this.savePSSysSFCode(iPSAppView, null, params);
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }
}

