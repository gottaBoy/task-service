/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssfplugin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1e603de0e0ce9134f32e50a9bc938d76", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSFPLUGINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSFPLUGINNAME", format="")})})
public class PSSysSFPluginDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSFPluginDefaultACModel() {
        this.initAnnotation(PSSysSFPluginDefaultACModel.class);
    }
}

