/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapppvpart.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c14525266fd0bba31fa8d12ab966c601", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPPVPARTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPPVPARTNAME", format="")})})
public class PSAppPVPartDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppPVPartDefaultACModel() {
        this.initAnnotation(PSAppPVPartDefaultACModel.class);
    }
}

