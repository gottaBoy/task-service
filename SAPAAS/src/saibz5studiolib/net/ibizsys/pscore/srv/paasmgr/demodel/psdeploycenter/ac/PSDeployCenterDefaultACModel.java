/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdeploycenter.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a4225a1d541dfe86a4070706a062a1cc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPLOYCENTERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPLOYCENTERNAME", format="")})})
public class PSDeployCenterDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDeployCenterDefaultACModel() {
        this.initAnnotation(PSDeployCenterDefaultACModel.class);
    }
}

