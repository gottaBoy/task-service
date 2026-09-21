/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssdgroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f37da71b9c7217fb86634c135e6fb7e0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDGROUPNAME", format="")})})
public abstract class TSSDGroupDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDGroupDefaultACModelBase() {
        this.initAnnotation(TSSDGroupDefaultACModelBase.class);
    }
}

