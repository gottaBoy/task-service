/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfplugin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8ab682c175266f8dd776d7233a086b4c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFPLUGINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFPLUGINNAME", format="")})})
public class PSSFPluginDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFPluginDefaultACModel() {
        this.initAnnotation(PSSFPluginDefaultACModel.class);
    }
}

