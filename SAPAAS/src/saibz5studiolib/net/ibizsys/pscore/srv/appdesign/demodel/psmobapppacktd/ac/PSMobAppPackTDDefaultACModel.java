/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psmobapppacktd.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="889fc3097776c5af101d40aca7894413", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMOBAPPPACKTDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMOBAPPPACKTDNAME", format="")})})
public class PSMobAppPackTDDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMobAppPackTDDefaultACModel() {
        this.initAnnotation(PSMobAppPackTDDefaultACModel.class);
    }
}

