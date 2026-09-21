/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.system.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="df93b04c07324dc3f4ae6aa109e612d1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="SYSTEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="SYSTEMNAME", format="")})})
public abstract class SystemDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public SystemDefaultACModelBase() {
        this.initAnnotation(SystemDefaultACModelBase.class);
    }
}

