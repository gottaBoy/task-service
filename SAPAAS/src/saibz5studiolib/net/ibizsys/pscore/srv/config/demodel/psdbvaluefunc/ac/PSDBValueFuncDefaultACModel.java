/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdbvaluefunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eca723395093a098191a2dc191e5edb2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBVALUEFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBVALUEFUNCNAME", format="")})})
public class PSDBValueFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBValueFuncDefaultACModel() {
        this.initAnnotation(PSDBValueFuncDefaultACModel.class);
    }
}

