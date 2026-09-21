/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.registry.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6f29424570cf5cb552950326c000e031", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="REGISTRYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="REGISTRYNAME", format="")})})
public abstract class RegistryDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public RegistryDefaultACModelBase() {
        this.initAnnotation(RegistryDefaultACModelBase.class);
    }
}

