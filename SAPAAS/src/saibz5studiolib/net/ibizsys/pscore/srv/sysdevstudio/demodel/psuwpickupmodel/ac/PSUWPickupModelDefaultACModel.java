/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwpickupmodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="93d4f64b9cf5148115c991734028e9d4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWPICKUPMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWPICKUPMODELNAME", format="")})})
public class PSUWPickupModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWPickupModelDefaultACModel() {
        this.initAnnotation(PSUWPickupModelDefaultACModel.class);
    }
}

