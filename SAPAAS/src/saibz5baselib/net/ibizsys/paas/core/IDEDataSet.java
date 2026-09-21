/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.cache.IDataCacheSupporter;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataRange;
import net.ibizsys.paas.core.IDEDataSetGroupParam;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEDataSet
extends IDataEntityObject,
IDEDataRange,
IDataCacheSupporter {
    public static final String PREDEFINETYPE_INDEXDE = "INDEXDE";
    public static final String PREDEFINETYPE_MULTIFORM = "MULTIFORM";

    public void init(IDataEntity var1) throws Exception;

    public boolean isEnableGroup();

    public int getGroupTopCount();

    public String getMajorSortField();

    public String getMajorSortDir();

    public String getMinorSortField();

    public String getMinorSortDir();

    public int getPageSize();

    public Iterator<IDEDataSetQuery> getDEDataSetQueries();

    public Iterator<IDEDataSetGroupParam> getDEDataSetGroupParams();

    public Iterator<IDEDataQuery> getDEDataQueries() throws Exception;

    public String getActiveDataDELogicId();
}

