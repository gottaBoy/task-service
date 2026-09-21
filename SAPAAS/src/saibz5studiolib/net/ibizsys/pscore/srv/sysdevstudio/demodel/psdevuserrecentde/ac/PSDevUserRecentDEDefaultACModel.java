/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9d403d6a2edefd78f1083e76f4af5f96", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVUSERRECENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVUSERRECENTNAME", format="")})})
public class PSDevUserRecentDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevUserRecentDEDefaultACModel() {
        this.initAnnotation(PSDevUserRecentDEDefaultACModel.class);
    }
}

