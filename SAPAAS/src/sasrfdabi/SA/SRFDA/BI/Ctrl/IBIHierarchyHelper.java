/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBILevelHelper;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Vector;

public interface IBIHierarchyHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIDimensionHelper var2, BIHierarchy var3) throws Exception;

    public String getShortId();

    public void setShortId(String var1);

    public String getId();

    public String getUniqueName();

    public String getLogicName();

    public IBIDimensionHelper getIBIDimension();

    public BIHierarchy getBIHierarchy();

    public String getFilterType();

    public String getCustomFilter();

    public boolean isHasAll();

    public String getAllCaption();

    public Vector<IBILevelHelper> getBILevels();

    public TreeView getTreeView();

    public int getColumnWidth();

    public String getTableName();

    public IDEHelper getBIHierarchyDEHelper();

    public String getDataCaption(BaseDataEntity var1);

    public String getDataKey(BaseDataEntity var1);
}

