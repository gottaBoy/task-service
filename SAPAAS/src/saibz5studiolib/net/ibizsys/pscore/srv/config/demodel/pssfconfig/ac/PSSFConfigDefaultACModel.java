/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfconfig.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2e5ab4d4f9082ca3a35eac2629656833", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFCONFIGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFCONFIGNAME", format="")})})
public class PSSFConfigDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFConfigDefaultACModel() {
        this.initAnnotation(PSSFConfigDefaultACModel.class);
    }
}

