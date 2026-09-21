/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvartype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b2e2afc94dbe21ac3b1d05a3cddde86c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVARTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVARTYPENAME", format="")})})
public class PSVarTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSVarTypeDefaultACModel() {
        this.initAnnotation(PSVarTypeDefaultACModel.class);
    }
}

