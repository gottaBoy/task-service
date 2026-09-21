/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICubeCacheCondition;
import SA.SRFDA.BI.Ctrl.BICubeCacheSortInfo;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchyFilter;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Hashtable;
import java.util.Vector;

public interface IBICubeCache {
    public void Init(ISRFDAGlobalHelper var1, IBICubeHelper var2, String var3, String var4, String var5) throws Exception;

    public IBICubeHelper getBICube();

    public String getBIFilter();

    public String getCacheTableName();

    public Vector<BIHierarchyFilter> getBIHierarchyFilters();

    public boolean hasBIHierarchyFilter(String var1);

    public Vector<BaseDataEntity> getBIHierarchyDatas(String var1) throws Exception;

    public Vector<BaseDataEntity> getBIHierarchyDatas(String var1, String var2) throws Exception;

    public void FetchDataByBIHierarchy(String var1, int var2, int var3, Vector<IBIHierarchyHelper> var4, Hashtable<String, BaseDataEntity> var5) throws Exception;

    public void FetchData(BICubeCacheCondition var1, Vector<IBIHierarchyHelper> var2, Hashtable<String, BaseDataEntity> var3) throws Exception;

    public void FetchData(BICubeCacheCondition var1, BICubeCacheSortInfo var2, Vector<IBIHierarchyHelper> var3, Vector<BaseDataEntity> var4) throws Exception;
}

