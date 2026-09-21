/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDEDashboard;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSSysDashboardLogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6570\u636e\u770b\u677f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysDashboard")
public interface IPSSysDashboard
extends IPSDashboard,
IPSDEDashboard {
    public Iterator<? extends IPSSysDashboardLogic> getPSSysDashboardLogics();
}

