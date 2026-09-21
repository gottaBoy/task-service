/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4f8001e7e374b14fcadcef1db28178a7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVUSERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVUSERNAME", format="")})})
public class PSDevUserDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevUserDefaultACModel() {
        this.initAnnotation(PSDevUserDefaultACModel.class);
    }
}

