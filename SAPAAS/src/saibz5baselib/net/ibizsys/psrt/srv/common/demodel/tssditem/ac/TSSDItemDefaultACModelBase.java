/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssditem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7923f282cb5da8b2419d53cb6fc6e9a7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDITEMNAME", format="")})})
public abstract class TSSDItemDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDItemDefaultACModelBase() {
        this.initAnnotation(TSSDItemDefaultACModelBase.class);
    }
}

