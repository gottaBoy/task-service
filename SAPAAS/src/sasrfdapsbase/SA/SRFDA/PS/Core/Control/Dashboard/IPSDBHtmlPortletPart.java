/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSysPortletPart;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="Html\u9875\u9762\u95e8\u6237\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDBHtmlPortletPart
extends IPSDBSysPortletPart {
    public String getPageUrl();

    public String getHtmlShowMode();
}

