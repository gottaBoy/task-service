/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcentermq.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4381e3b3f9e82c1edb62f8c71b3934fe", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVCENTERMQID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVCENTERMQNAME", format="")})})
public class PSDevCenterMQDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevCenterMQDefaultACModel() {
        this.initAnnotation(PSDevCenterMQDefaultACModel.class);
    }
}

