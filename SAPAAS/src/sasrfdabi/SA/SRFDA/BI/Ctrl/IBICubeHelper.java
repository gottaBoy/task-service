/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BICube;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchyFilter;
import SA.SRFDA.BI.Ctrl.Data.BIReportEx;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Vector;

public interface IBICubeHelper {
    public void Init(ISRFDAGlobalHelper var1, BICube var2) throws Exception;

    public String getId();

    public String getName();

    public int getVersion();

    public BICube getBICube();

    public IDEHelper getBICubeDEHelper();

    public IBIReportExHelper FindBIReportEx(BIReportEx var1) throws Exception;

    public Vector<IBIDimensionHelper> getBIDimensions();

    public Vector<IBICubeMeasureHelper> getBICubeMeasures();

    public IBIDimensionHelper FindBIDimension(String var1) throws Exception;

    public IDEFHelper FindBIDMJoinDEFHelper(String var1);

    public IBICubeMeasureHelper FindBICubeMeasure(String var1) throws Exception;

    public IBIHierarchyHelper FindBIHierarchy(String var1) throws Exception;

    public Vector<String> CalcBICubeTables(Vector<BIHierarchyFilter> var1) throws Exception;

    public boolean isUseView();
}

