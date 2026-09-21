/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psstudioplugindata.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="242402913775a588002e0dbac2180e02", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSTUDIOPLUGINDATAID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSTUDIOPLUGINDATANAME", format="")})})
public class PSStudioPluginDataDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSStudioPluginDataDefaultACModel() {
        this.initAnnotation(PSStudioPluginDataDefaultACModel.class);
    }
}

