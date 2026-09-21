/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.db.ISelectFilter;

public interface IDEDataQueryCodeCond
extends IModelBase,
ISelectFilter {
    public static final String CONDTYPE_DEFIELD = "DEFIELD";
    public static final String CONDTYPE_CUSTOM = "CUSTOM";
    public static final String CONDTYPE_GROUP = "GROUP";
    public static final String CONDTYPE_PREDEFINED = "PREDEFINED";

    public String getDEFName();

    @Override
    public String getCondType();

    public String getCondOp();

    public String getCondValue();

    public String getCustomCond();

    @Deprecated
    public String getPredefindedCond();

    public String getPredefinedCode();

    public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds();

    public String getDEFieldExp();

    public boolean isNotMode();

    public int getStdDataType();

    public String getValueFunc();
}

