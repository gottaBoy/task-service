/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdelogicparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0adae883450e46d71ab5f9bc0e99c695", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELOGICPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELOGICPARAMNAME", format="")})})
public class PSDELogicParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDELogicParamDefaultACModel() {
        this.initAnnotation(PSDELogicParamDefaultACModel.class);
    }
}

