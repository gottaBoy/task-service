/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psrobot.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="19015326451f633074e21d8e7512d766", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSROBOTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSROBOTNAME", format="")})})
public class PSRobotDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRobotDefaultACModel() {
        this.initAnnotation(PSRobotDefaultACModel.class);
    }
}

