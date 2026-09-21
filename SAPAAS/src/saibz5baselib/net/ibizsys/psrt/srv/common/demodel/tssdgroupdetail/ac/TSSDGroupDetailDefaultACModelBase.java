/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssdgroupdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e8b6c72b7a73a98f68bf91b812d46c31", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDGROUPDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDGROUPDETAILNAME", format="")})})
public abstract class TSSDGroupDetailDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDGroupDetailDefaultACModelBase() {
        this.initAnnotation(TSSDGroupDetailDefaultACModelBase.class);
    }
}

