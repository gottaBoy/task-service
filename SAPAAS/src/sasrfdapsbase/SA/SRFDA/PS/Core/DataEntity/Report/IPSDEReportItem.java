/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Report;

import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEReportItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u62a5\u8868\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDERepItem")
public interface IPSDEReportItem
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEReport var2, PSDEReportItem var3) throws Exception;

    public IPSDEReport getPSDEReport();

    public String getMinorPSDEReportId();

    public IPSDEReport getMinorPSDEReport() throws Exception;
}

