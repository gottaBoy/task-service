/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBToolbarPortlet;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBSysPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEToolbarPortlet;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"TOOLBAR"})
public class PSDBToolbarPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBToolbarPortlet {
    public static final String TOOLBARNAME = "_toolbar";
    private IPSDEToolbar iPSDEToolbar = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDEToolbarPortlet iPSSysDEToolbarPortlet = (IPSSysDEToolbarPortlet)this.iPSSysPortlet;
        PSDEToolbarParamImpl psDEToolbarParamImpl = new PSDEToolbarParamImpl();
        psDEToolbarParamImpl.setPSDEToolbarId(iPSSysDEToolbarPortlet.getPSDEToolbarId());
        psDEToolbarParamImpl.setOwner(this);
        this.iPSDEToolbar = (IPSDEToolbar)this.registerPSControl(String.valueOf(this.getName()) + TOOLBARNAME, "TOOLBAR", psDEToolbarParamImpl);
        super.onInit();
    }

    @Override
    public IPSDEToolbar getPSDEToolbar() {
        return this.iPSDEToolbar;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6", dumpref=true, modelreftype="LINK", from="__self__", from_method="getPSControl")
    public IPSControl getContentPSControl() {
        return this.getPSDEToolbar();
    }
}

