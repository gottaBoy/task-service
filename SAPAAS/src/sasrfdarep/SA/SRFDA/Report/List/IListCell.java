/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Report.List.ListColumnConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 */
package SA.SRFDA.Report.List;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.List.ListColumnConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;

public interface IListCell {
    public String GetValue(IDEHelper var1, ISRFDAWebContext var2, ISRFDAGlobalHelper var3, DataRow var4, ListColumnConfig var5);
}

