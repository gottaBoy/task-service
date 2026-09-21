/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdeactionparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3e37d785a125c66e9b7b6fd19cc81dc7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEACTIONPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEACTIONPARAMNAME", format="")})})
public class PSDEActionParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEActionParamDefaultACModel() {
        this.initAnnotation(PSDEActionParamDefaultACModel.class);
    }
}

