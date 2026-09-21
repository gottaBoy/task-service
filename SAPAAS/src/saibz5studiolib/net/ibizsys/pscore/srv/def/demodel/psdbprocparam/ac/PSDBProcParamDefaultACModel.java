/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psdbprocparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b96054202b80a6dc552572a132e3898b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBPROCPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBPROCPARAMNAME", format="")})})
public class PSDBProcParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBProcParamDefaultACModel() {
        this.initAnnotation(PSDBProcParamDefaultACModel.class);
    }
}

