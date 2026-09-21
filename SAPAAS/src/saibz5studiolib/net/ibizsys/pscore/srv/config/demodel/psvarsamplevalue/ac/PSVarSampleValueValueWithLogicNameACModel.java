/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="VALUEWITHLOGICNAME", id="9404B5F9-90BD-419B-B0E2-C4C25148F32C", dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVARSAMPLEVALUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="VALUE", format="")}), @DataItem(name="logicname", dataitemparams={@DataItemParam(name="PSVARSAMPLEVALUENAME", format="%1$s")})})
public class PSVarSampleValueValueWithLogicNameACModel
extends DEACModelBase {
    public static final String NAME = "VALUEWITHLOGICNAME";

    public PSVarSampleValueValueWithLogicNameACModel() {
        this.initAnnotation(PSVarSampleValueValueWithLogicNameACModel.class);
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
    }
}

