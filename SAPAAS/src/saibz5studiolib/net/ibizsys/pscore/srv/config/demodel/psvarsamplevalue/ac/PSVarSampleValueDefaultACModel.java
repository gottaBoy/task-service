/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e657526c38986dd269be6eb65630a410", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVARSAMPLEVALUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVARSAMPLEVALUENAME", format="")})})
public class PSVarSampleValueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSVarSampleValueDefaultACModel() {
        this.initAnnotation(PSVarSampleValueDefaultACModel.class);
    }
}

