/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psrobotability.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8adf2d9da0debe4e68c06e00f8e3a94f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSROBOTABILITYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSROBOTABILITYNAME", format="")})})
public class PSRobotAbilityDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRobotAbilityDefaultACModel() {
        this.initAnnotation(PSRobotAbilityDefaultACModel.class);
    }
}

