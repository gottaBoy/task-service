/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvtrv.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="abe00ee385144f0cfe07e32f4fac4f86", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVTRVID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVTRVNAME", format="")})})
public class PSVTRVDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSVTRVDefaultACModel() {
        this.initAnnotation(PSVTRVDefaultACModel.class);
    }
}

