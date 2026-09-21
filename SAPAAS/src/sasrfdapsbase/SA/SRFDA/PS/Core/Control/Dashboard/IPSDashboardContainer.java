/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u6570\u636e\u770b\u677f\u5bb9\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDashboardContainer
extends IPSLayoutContainer {
    public Iterator<IPSDBPortletPart> getPSPortlets();

    public void registerPSPortlet(IPSDBPortletPart var1) throws Exception;

    public String getLayoutMode();

    public String getFlexDir();

    public String getFlexAlign();

    public String getFlexVAlign();
}

