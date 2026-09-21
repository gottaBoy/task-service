/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewstyle.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2749b7d823ee17b6d3ccf7fbb609e8b5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWSTYLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWSTYLENAME", format="")})})
public class PSViewStyleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewStyleDefaultACModel() {
        this.initAnnotation(PSViewStyleDefaultACModel.class);
    }
}

