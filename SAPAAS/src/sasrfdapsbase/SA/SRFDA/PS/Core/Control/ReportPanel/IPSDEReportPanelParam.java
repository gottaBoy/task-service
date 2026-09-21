/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ReportPanel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u62a5\u8868\u9762\u677f\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDEReportPanelParam
extends IPSControlParam {
    public String getPSDEReportId();

    public String getReportContentType();
}

