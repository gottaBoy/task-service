/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevsysdiffrep.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="98d4db48e6e88d3211afb4c3ab7b742c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSYSDIFFREPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSYSDIFFREPNAME", format="")})})
public class PSDevSysDiffRepDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSysDiffRepDefaultACModel() {
        this.initAnnotation(PSDevSysDiffRepDefaultACModel.class);
    }
}

