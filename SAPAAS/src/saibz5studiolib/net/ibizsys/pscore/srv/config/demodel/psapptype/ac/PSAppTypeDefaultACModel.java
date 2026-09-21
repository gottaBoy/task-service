/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psapptype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d8e4bd9bde2358c11daac4de590859de", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPTYPENAME", format="")})})
public class PSAppTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppTypeDefaultACModel() {
        this.initAnnotation(PSAppTypeDefaultACModel.class);
    }
}

