/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psbackservice.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6faf31bfd6dbf2346650ee7b3d97e3be", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSBACKSERVICEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSBACKSERVICENAME", format="")})})
public class PSBackServiceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSBackServiceDefaultACModel() {
        this.initAnnotation(PSBackServiceDefaultACModel.class);
    }
}

