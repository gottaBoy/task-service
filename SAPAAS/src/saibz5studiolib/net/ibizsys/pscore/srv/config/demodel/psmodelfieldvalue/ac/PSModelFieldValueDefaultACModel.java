/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelfieldvalue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="21c1d6de156b70df43b8a8982e75559f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELFIELDVALUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELFIELDVALUENAME", format="")})})
public class PSModelFieldValueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelFieldValueDefaultACModel() {
        this.initAnnotation(PSModelFieldValueDefaultACModel.class);
    }
}

