/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.demodel.demodel.querymodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ee650aec5d0df3c9880100dc57441146", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="QUERYMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="QUERYMODELNAME", format="")})})
public abstract class QueryModelDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public QueryModelDefaultACModelBase() {
        this.initAnnotation(QueryModelDefaultACModelBase.class);
    }
}

