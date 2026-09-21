/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psworkspacetype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c7283cf03e82d40be6fe9c50e7b32b13", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWORKSPACETYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWORKSPACETYPENAME", format="")})})
public class PSWorkspaceTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWorkspaceTypeDefaultACModel() {
        this.initAnnotation(PSWorkspaceTypeDefaultACModel.class);
    }
}

