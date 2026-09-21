/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psregistryservertype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0869316e4c6d2612d6e5fcca7fd1e2e8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSREGISTRYSERVERTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSREGISTRYSERVERTYPENAME", format="")})})
public class PSRegistryServerTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRegistryServerTypeDefaultACModel() {
        this.initAnnotation(PSRegistryServerTypeDefaultACModel.class);
    }
}

