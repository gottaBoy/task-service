/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDETabExplorerView
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.viewpanel.IPSDEViewPanel
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.app.view;

import java.util.ArrayList;
import net.ibizsys.model.app.view.IPSAppDETabExplorerView;
import net.ibizsys.model.app.view.PSAppDEExplorerViewImpl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.viewpanel.IPSDEViewPanel;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.paas.util.StringHelper;

public class PSAppDETabExplorerViewImpl
extends PSAppDEExplorerViewImpl
implements IPSAppDETabExplorerView {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        ArrayList<IPSControl> psControls = this.getPSControls("TABVIEWPANEL", 10);
        for (IPSControl iPSControl : psControls) {
            if (!(iPSControl instanceof IPSDEViewPanel)) continue;
            IPSDEViewPanel iPSDEViewPanel = (IPSDEViewPanel)iPSControl;
            String strViewRefMode = StringHelper.format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)iPSControl.getName());
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
            psAppViewRef.setMINORPSAPPVIEWID(iPSDEViewPanel.getPSAppDEView().getId());
            psAppViewRef.setParamValue("EMBEDVIEWID", iPSDEViewPanel.getEmbedViewId());
            this.getPSAppViewRuntime().registerPSAppViewRef(psAppViewRef);
        }
    }
}

