/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIDimension;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIDimensionHelper {
    public void Init(ISRFDAGlobalHelper var1, BIDimension var2) throws Exception;

    public String getId();

    public String getShortId();

    public void setShortId(String var1);

    public String getUniqueName();

    public String getLogicName();

    public IBIHierarchyHelper FindBIHierarchy(String var1) throws Exception;

    public boolean hasBIHierarchy(String var1);

    public BIDimension getBIDimension();

    public String getDimensionType();
}

