/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.ppmodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="14ad5675b58882f0e61ba3caabcf6f5e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PPMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PORTALPAGENAME", format="")})})
public abstract class PPModelDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PPModelDefaultACModelBase() {
        this.initAnnotation(PPModelDefaultACModelBase.class);
    }
}

