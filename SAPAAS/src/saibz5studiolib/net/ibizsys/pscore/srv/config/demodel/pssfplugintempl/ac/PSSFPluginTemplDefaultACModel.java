/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfplugintempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3ea3d51aecbd2776e56091a980016bf3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFPLUGINTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFPLUGINTEMPLNAME", format="")})})
public class PSSFPluginTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFPluginTemplDefaultACModel() {
        this.initAnnotation(PSSFPluginTemplDefaultACModel.class);
    }
}

