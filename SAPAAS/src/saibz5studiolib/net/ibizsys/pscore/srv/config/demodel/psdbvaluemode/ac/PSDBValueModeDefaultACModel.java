/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdbvaluemode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="26cdf58692ad804a9bc82a54cb0835e4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBVALUEMODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBVALUEMODENAME", format="")})})
public class PSDBValueModeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBValueModeDefaultACModel() {
        this.initAnnotation(PSDBValueModeDefaultACModel.class);
    }
}

