/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="19439997d0fd8b3d57fea99732268839", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNUSERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNUSERNAME", format="")})})
public class PSDevSlnUserDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnUserDefaultACModel() {
        this.initAnnotation(PSDevSlnUserDefaultACModel.class);
    }
}

