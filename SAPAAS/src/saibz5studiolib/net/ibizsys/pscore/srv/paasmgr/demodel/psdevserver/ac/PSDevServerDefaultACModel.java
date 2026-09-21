/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdevserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7ce04be6489c71183eac4cc94d8ce74e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSERVERNAME", format="")})})
public class PSDevServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevServerDefaultACModel() {
        this.initAnnotation(PSDevServerDefaultACModel.class);
    }
}

