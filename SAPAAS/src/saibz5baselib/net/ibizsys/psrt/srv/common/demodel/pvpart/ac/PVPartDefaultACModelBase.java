/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.pvpart.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d1ce1f760d77192f620b4f6b9d7769f8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PVPARTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PVPARTNAME", format="")})})
public abstract class PVPartDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PVPartDefaultACModelBase() {
        this.initAnnotation(PVPartDefaultACModelBase.class);
    }
}

