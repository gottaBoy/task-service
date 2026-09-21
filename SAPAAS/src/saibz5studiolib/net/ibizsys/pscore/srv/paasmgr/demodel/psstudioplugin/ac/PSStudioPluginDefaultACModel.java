/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psstudioplugin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="924fcb70ace50069f6a3c4071f562e69", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSTUDIOPLUGINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSTUDIOPLUGINNAME", format="")})})
public class PSStudioPluginDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSStudioPluginDefaultACModel() {
        this.initAnnotation(PSStudioPluginDefaultACModel.class);
    }
}

