/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u7ed8\u5236\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSControlRenderProxy")
public interface IPSControlRender
extends IPSModelObject {
    public static final String RENDERTYPE_LAYOUTPANEL = "LAYOUTPANEL";
    public static final String RENDERTYPE_LAYOUTPANEL_MODEL = "LAYOUTPANEL_MODEL";
    public static final String RENDERTYPE_PFPLUGIN = "PFPLUGIN";

    public String getItemName();

    public String getRenderName();

    public String getRenderType();

    public String getLayoutPanelModel();

    public IPSLayoutPanel getPSLayoutPanel();

    public IPSSysPFPlugin getPSSysPFPlugin();
}

