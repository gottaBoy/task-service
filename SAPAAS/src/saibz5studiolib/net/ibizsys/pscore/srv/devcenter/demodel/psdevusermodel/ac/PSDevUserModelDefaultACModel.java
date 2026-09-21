/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevusermodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="93306a7ffae54a38e112d39f7f5933e9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVUSERMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVUSERMODELNAME", format="")})})
public class PSDevUserModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevUserModelDefaultACModel() {
        this.initAnnotation(PSDevUserModelDefaultACModel.class);
    }
}

