/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepapi.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="351fc13693e28033fef41464635e07e2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNMSDEPAPIID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNMSDEPAPINAME", format="")})})
public class PSDevSlnMSDepAPIDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnMSDepAPIDefaultACModel() {
        this.initAnnotation(PSDevSlnMSDepAPIDefaultACModel.class);
    }
}

