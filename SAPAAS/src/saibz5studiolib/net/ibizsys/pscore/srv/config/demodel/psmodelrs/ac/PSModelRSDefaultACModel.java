/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelrs.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5239391bc353e43d20fc473cc85af751", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELRSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELRSNAME", format="")})})
public class PSModelRSDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelRSDefaultACModel() {
        this.initAnnotation(PSModelRSDefaultACModel.class);
    }
}

