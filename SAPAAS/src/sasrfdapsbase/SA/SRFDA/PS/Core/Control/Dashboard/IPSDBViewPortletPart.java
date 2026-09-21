/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBAppViewPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSysPortletPart;

public interface IPSDBViewPortletPart
extends IPSDBSysPortletPart,
IPSDBAppViewPortletPart {
    @Override
    public IPSAppView getPortletPSAppView();
}

