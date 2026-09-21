/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pscoreprdinstlog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e770cd6672338ad5d924d2329abaaaa0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCOREPRDINSTLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCOREPRDINSTLOGNAME", format="")})})
public class PSCorePrdInstLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCorePrdInstLogDefaultACModel() {
        this.initAnnotation(PSCorePrdInstLogDefaultACModel.class);
    }
}

