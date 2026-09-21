/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core.valuerule;

import net.ibizsys.paas.core.valuerule.IDEFVRDEDataSet;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;

public interface IDEFDataRangeRule
extends IDEFValueRule {
    public static final String DATARANGE_DEDATASET = "DEDATASET";

    public IDEFVRDEDataSet getDEFVRDEDataSet();
}

