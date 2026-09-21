/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcenterdbinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="40c8056f17251a6d0f400fa54aa5502f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVCENTERDBINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVCENTERDBINSTNAME", format="")})})
public class PSDevCenterDBInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevCenterDBInstDefaultACModel() {
        this.initAnnotation(PSDevCenterDBInstDefaultACModel.class);
    }
}

