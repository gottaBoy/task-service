/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepDM;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepDMHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIReportExHelper var2, BIRepDM var3) throws Exception;

    public IBIDimensionHelper getBIDimension();

    public IBIHierarchyHelper getBIHierarchy();

    public boolean isEnableFilter();

    public int getFilterPos();

    public String getPlacement();

    public int getColumnWidth();

    public String getPlaceType();

    public boolean isOutputAll();
}

