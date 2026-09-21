/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppViewCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIBiz5SysAppViewCtrlModelCodePublisherImpl
extends PSIBiz5SysAppViewCodePublisherImpl {
    protected HashMap<String, String> appViewCtrlMap = new HashMap();

    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        this.appViewCtrlMap.clear();
        super.onGenerateCode(iPSApplication, list);
        this.appViewCtrlMap.clear();
    }

    @Override
    protected void onGenerateAppViewCode(IPSAppView iPSAppView, ArrayList<PSSysSFCode> list) throws Exception {
        for (IPSControl iPSControl : iPSAppView.getAllPSControls()) {
            if (!iPSControl.getPSControlType().isAjaxControl() || StringHelper.Compare((String)iPSControl.getModelScope(), (String)this.getModelScope(), (boolean)true) != 0 || this.appViewCtrlMap.containsKey(String.valueOf(iPSControl.getControlType()) + "|" + iPSControl.getId())) continue;
            this.appViewCtrlMap.put(String.valueOf(iPSControl.getControlType()) + "|" + iPSControl.getId(), "");
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
        this.onFillGenerateCodeParams("", iPSControl, params);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSControl, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected String getModelScope() {
        return "VIEW";
    }

    @Override
    protected void onClose() {
        this.appViewCtrlMap.clear();
        super.onClose();
    }
}

