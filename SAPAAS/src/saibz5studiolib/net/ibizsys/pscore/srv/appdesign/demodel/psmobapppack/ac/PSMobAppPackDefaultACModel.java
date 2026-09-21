/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psmobapppack.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ad9d1def7055c1c9f5333e6afd7de8ef", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMOBAPPPACKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMOBAPPPACKNAME", format="")})})
public class PSMobAppPackDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMobAppPackDefaultACModel() {
        this.initAnnotation(PSMobAppPackDefaultACModel.class);
    }
}

