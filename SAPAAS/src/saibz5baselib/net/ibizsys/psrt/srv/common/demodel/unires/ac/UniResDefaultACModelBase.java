/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.unires.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="88d390ffbdb76f146f608c669729d81d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="UNIRESID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="UNIRESNAME", format="")})})
public abstract class UniResDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UniResDefaultACModelBase() {
        this.initAnnotation(UniResDefaultACModelBase.class);
    }
}

