/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psrobotworktype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="820cc7288d16af4ec869b75e23147823", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSROBOTWORKTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSROBOTWORKTYPENAME", format="")})})
public class PSRobotWorkTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRobotWorkTypeDefaultACModel() {
        this.initAnnotation(PSRobotWorkTypeDefaultACModel.class);
    }
}

