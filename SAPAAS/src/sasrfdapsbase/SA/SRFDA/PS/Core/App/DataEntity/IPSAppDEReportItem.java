/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReport;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReportItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u62a5\u8868\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDERepItem")
public interface IPSAppDEReportItem
extends IPSDEReportItem {
    public IPSAppDEReport getPSAppDEReport();

    public IPSAppDEReport getMinorPSAppDEReport() throws Exception;
}

