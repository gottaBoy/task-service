/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppViewCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIBiz5SysAppViewCtrlCodePublisherImpl2
extends PSIBiz5SysAppViewCodePublisherImpl {
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        super.onGenerateCode(iPSApplication, list);
    }

    @Override
    protected void onGenerateAppViewCode(IPSAppView iPSAppView, ArrayList<PSSysSFCode> list) throws Exception {
        for (IPSControl iPSControl : iPSAppView.getAllPSControls()) {
            this.generateControlCode(iPSControl, list);
        }
    }

    protected void generateControlCode(IPSControl iPSControl, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (iPSControl.getPSDataEntity() != null) {
            params.put("de", iPSControl.getPSDataEntity());
        }
        if (iPSControl.getPSAppDataEntity() != null) {
            params.put("appde", iPSControl.getPSAppDataEntity());
        }
        params.put("ctrl", iPSControl);
        this.onFillGenerateCodeParams("", iPSControl, params);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSControl, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected void onClose() {
        super.onClose();
    }
}

