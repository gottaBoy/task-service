/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnmode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0b01d1b3e06c1bffc43ec3321b76f9f0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSLNMODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSLNMODENAME", format="")})})
public class PSDepSlnModeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSlnModeDefaultACModel() {
        this.initAnnotation(PSDepSlnModeDefaultACModel.class);
    }
}

