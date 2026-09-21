/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynawfver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="da1ebfa0f1777e651b33c7e1df73c4ec", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DSDYNAWFVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DSDYNAWFVERNAME", format="")})})
public abstract class DSDynaWFVerDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DSDynaWFVerDefaultACModelBase() {
        this.initAnnotation(DSDynaWFVerDefaultACModelBase.class);
    }
}

