/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcnwflow.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5d9712bce9e5d5cc1b3ef962ce1f9b39", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCNWFLOWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCNWFLOWNAME", format="")})})
public class PSDCNWFlowDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCNWFlowDefaultACModel() {
        this.initAnnotation(PSDCNWFlowDefaultACModel.class);
    }
}

