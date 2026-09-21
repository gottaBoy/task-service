/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pscoreprd.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cf4211ea44d5c958ece31dd03381ddad", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCOREPRDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCOREPRDNAME", format="")})})
public class PSCorePrdDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCorePrdDefaultACModel() {
        this.initAnnotation(PSCorePrdDefaultACModel.class);
    }
}

