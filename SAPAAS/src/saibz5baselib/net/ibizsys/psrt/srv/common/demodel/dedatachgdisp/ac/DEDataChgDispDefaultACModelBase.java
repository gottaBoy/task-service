/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.dedatachgdisp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="54b64fbcfb4f415664d56327f7a2c210", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DEDATACHGDISPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DEDATACHGDISPNAME", format="")})})
public abstract class DEDataChgDispDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DEDataChgDispDefaultACModelBase() {
        this.initAnnotation(DEDataChgDispDefaultACModelBase.class);
    }
}

