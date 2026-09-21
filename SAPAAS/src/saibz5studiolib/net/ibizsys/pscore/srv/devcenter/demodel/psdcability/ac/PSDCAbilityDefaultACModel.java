/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcability.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="dc2e7a5b6acd532efbea19065ccb3147", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCABILITYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCABILITYNAME", format="")})})
public class PSDCAbilityDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCAbilityDefaultACModel() {
        this.initAnnotation(PSDCAbilityDefaultACModel.class);
    }
}

