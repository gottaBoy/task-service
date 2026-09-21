/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevusersql.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fc8d3c6ba0ae38bae9c5ea2acff7acfb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVUSERSQLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVUSERSQLNAME", format="")})})
public class PSDevUserSqlDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevUserSqlDefaultACModel() {
        this.initAnnotation(PSDevUserSqlDefaultACModel.class);
    }
}

