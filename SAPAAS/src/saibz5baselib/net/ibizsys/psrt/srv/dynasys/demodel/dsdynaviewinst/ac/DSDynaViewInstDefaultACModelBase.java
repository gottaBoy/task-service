/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynaviewinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="455ba35d2ea0b7be6e2035f54ff60f5b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DSDYNAVIEWINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DSDYNAVIEWINSTNAME", format="")})})
public abstract class DSDynaViewInstDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DSDynaViewInstDefaultACModelBase() {
        this.initAnnotation(DSDynaViewInstDefaultACModelBase.class);
    }
}

