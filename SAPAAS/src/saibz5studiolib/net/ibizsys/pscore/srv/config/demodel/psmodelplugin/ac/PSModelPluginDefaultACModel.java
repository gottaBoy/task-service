/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelplugin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c154f701f55b1707d88c83776293dce8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELPLUGINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELPLUGINNAME", format="")})})
public class PSModelPluginDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelPluginDefaultACModel() {
        this.initAnnotation(PSModelPluginDefaultACModel.class);
    }
}

