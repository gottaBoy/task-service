/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappusermode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3fa3a006e1fbad9c0060270386e01e41", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPUSERMODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPUSERMODENAME", format="")})})
public class PSAppUserModeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppUserModeDefaultACModel() {
        this.initAnnotation(PSAppUserModeDefaultACModel.class);
    }
}

