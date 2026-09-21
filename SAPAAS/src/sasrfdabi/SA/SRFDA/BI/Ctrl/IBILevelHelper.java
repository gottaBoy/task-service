/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBILevelHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIHierarchyHelper var2, BILevel var3) throws Exception;

    public String getShortId();

    public void setShortId(String var1);

    public String getId();

    public String getName();

    public String getUniqueName();

    public String getLogicName();

    public BILevel getBILevel();

    public IBIHierarchyHelper getBIHierarchy();

    public String getColumnName();

    public String getSortColumnName();

    public boolean isUniqueMembers();

    public String getAggCaption();

    public String getLevelType();
}

