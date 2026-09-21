/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.dedatachg2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2be4c985b8c11e06783904ce4e9d8b90", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DEDATACHG2ID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DEDATACHG2NAME", format="")})})
public abstract class DEDataChg2DefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DEDataChg2DefaultACModelBase() {
        this.initAnnotation(DEDataChg2DefaultACModelBase.class);
    }
}

