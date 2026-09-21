/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psrobotwork.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="37a43d0f4296231d075fa0f9b95cddd6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSROBOTWORKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSROBOTWORKNAME", format="")})})
public class PSRobotWorkDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRobotWorkDefaultACModel() {
        this.initAnnotation(PSRobotWorkDefaultACModel.class);
    }
}

