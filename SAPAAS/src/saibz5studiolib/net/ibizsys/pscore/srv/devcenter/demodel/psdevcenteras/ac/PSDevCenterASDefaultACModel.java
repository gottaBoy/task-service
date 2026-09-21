/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcenteras.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c89b03a71c671ab3cf1766c16fa0bc4f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVCENTERASID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVCENTERASNAME", format="")})})
public class PSDevCenterASDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevCenterASDefaultACModel() {
        this.initAnnotation(PSDevCenterASDefaultACModel.class);
    }
}

