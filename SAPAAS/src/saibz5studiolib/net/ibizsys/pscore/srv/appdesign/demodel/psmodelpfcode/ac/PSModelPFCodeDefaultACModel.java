/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psmodelpfcode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c137491d7a4674ec6ea7c9356b266a39", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELPFCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELPFCODENAME", format="")})})
public class PSModelPFCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelPFCodeDefaultACModel() {
        this.initAnnotation(PSModelPFCodeDefaultACModel.class);
    }
}

