/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdeploycenter.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1fcf5928bf0747d940c9c7e1d5b57971", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCDEPLOYCENTERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCDEPLOYCENTERNAME", format="")})})
public class PSDCDeployCenterDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCDeployCenterDefaultACModel() {
        this.initAnnotation(PSDCDeployCenterDefaultACModel.class);
    }
}

