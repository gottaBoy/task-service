/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.dao;

import net.ibizsys.paas.db.ISelectFieldFilter;

public interface IBASelectFilter
extends ISelectFieldFilter {
    public static final String BAFILTER_COLUMNVALUE = "COLUMNVALUE";
    public static final String BAFILTER_COLUMNVALUECONTAINS = "COLUMNVALUEPRE";
    public static final String BAFILTER_XCOLUMNVALUEPRE = "XCOLUMNVALUEPRE";
    public static final String BAFILTER_ROWKEY = "ROWKEY";
    public static final String BAFILTER_COLUMNNAME = "COLUMNNAME";
    public static final String BAFILTER_COLUMNNAMEPRE = "COLUMNNAMEPRE";

    public String getBAFilterType();

    public String getColSet();

    @Override
    public Object getCondObjectValue() throws Exception;
}

