/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ReportPanel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReport;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u62a5\u8868\u9762\u677f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEReportPanel
extends IPSControl {
    public IPSDEReport getPSDEReport();

    public String getReportContentType();

    public IPSAppDEReport getPSAppDEReport();
}

