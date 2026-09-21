/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemrun.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a7c8ecb80eaab24c474cda7b01aa1259", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTEMRUNID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTEMRUNNAME", format="")})})
public class PSSystemRunDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSystemRunDefaultACModel() {
        this.initAnnotation(PSSystemRunDefaultACModel.class);
    }
}

