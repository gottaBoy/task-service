/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcpfplugin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="260959266320e098c0ec4306ff35fa78", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCPFPLUGINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCPFPLUGINNAME", format="")})})
public class PSDCPFPluginDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCPFPluginDefaultACModel() {
        this.initAnnotation(PSDCPFPluginDefaultACModel.class);
    }
}

