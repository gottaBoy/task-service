/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psrobottypeability.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="887220b150960569c9b456b0497d91db", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSROBOTTYPEABILITYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSROBOTTYPEABILITYNAME", format="")})})
public class PSRobotTypeAbilityDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRobotTypeAbilityDefaultACModel() {
        this.initAnnotation(PSRobotTypeAbilityDefaultACModel.class);
    }
}

