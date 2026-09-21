/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdevenv.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6b4a151d86390043540f5ae385d2dde2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVENVID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVENVNAME", format="")})})
public class PSDevEnvDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevEnvDefaultACModel() {
        this.initAnnotation(PSDevEnvDefaultACModel.class);
    }
}

