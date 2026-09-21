/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSSysLayoutPanel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u89c6\u56fe\u5e03\u5c40\u9762\u677f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSSysViewLayoutPanelImpl", model="PSSysViewPanel")
public interface IPSViewLayoutPanel
extends IPSSysLayoutPanel {
    public boolean isUseDefaultLayout();

    public boolean isLayoutBodyOnly();

    public boolean isViewProxyMode();
}

