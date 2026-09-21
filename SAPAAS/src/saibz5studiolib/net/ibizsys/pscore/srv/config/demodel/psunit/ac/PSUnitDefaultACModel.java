/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psunit.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="71b6f441be3244db048e329610e230ba", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUNITID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUNITNAME", format="")})})
public class PSUnitDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUnitDefaultACModel() {
        this.initAnnotation(PSUnitDefaultACModel.class);
    }
}

