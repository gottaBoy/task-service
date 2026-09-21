/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfplugin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ae0633e37620882d6a5e815773533d9c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPLUGINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPLUGINNAME", format="")})})
public class PSPFPluginDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPluginDefaultACModel() {
        this.initAnnotation(PSPFPluginDefaultACModel.class);
    }
}

