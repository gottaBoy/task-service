/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynaview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="87d8599997ce9323cd2bba43278b4135", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DSDYNAVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DSDYNAVIEWNAME", format="")})})
public abstract class DSDynaViewDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DSDynaViewDefaultACModelBase() {
        this.initAnnotation(DSDynaViewDefaultACModelBase.class);
    }
}

