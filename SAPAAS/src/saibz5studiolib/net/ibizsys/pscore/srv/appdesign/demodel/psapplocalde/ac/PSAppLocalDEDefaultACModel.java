/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapplocalde.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0454de3944f0719f0b773a70a4dfda19", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPLOCALDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPLOCALDENAME", format="")})})
public class PSAppLocalDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppLocalDEDefaultACModel() {
        this.initAnnotation(PSAppLocalDEDefaultACModel.class);
    }
}

