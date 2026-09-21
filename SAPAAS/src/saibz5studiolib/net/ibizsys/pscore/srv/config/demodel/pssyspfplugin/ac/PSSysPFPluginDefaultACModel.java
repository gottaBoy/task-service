/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="850bff46135ea742014684051bf67889", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSPFPLUGINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSPFPLUGINNAME", format="")})})
public class PSSysPFPluginDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysPFPluginDefaultACModel() {
        this.initAnnotation(PSSysPFPluginDefaultACModel.class);
    }
}

