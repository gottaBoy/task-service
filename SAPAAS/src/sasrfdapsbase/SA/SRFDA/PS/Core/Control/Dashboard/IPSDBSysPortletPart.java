/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9884\u7f6e\u95e8\u6237\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDBSysPortletPart
extends IPSDBPortletPart {
    public IPSSysPortlet getPSSysPortlet();

    public long getTimer();
}

