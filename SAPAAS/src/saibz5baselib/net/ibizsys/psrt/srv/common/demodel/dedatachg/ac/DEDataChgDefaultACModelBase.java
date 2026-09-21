/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.dedatachg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b46bdd8836d4e93bad690042e23ff374", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DEDATACHGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DEDATACHGNAME", format="")})})
public abstract class DEDataChgDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DEDataChgDefaultACModelBase() {
        this.initAnnotation(DEDataChgDefaultACModelBase.class);
    }
}

