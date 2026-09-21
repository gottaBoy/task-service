/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynacodelist.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7a90be048da1f8e71d2f8f74e8703c05", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DSDYNACODELISTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DSDYNACODELISTNAME", format="")})})
public abstract class DSDynaCodeListDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DSDynaCodeListDefaultACModelBase() {
        this.initAnnotation(DSDynaCodeListDefaultACModelBase.class);
    }
}

