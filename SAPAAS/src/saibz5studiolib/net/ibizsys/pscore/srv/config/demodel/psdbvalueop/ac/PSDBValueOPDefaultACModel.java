/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdbvalueop.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="856d9784f197117de00f7c36906ac30b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBVALUEOPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBVALUEOPNAME", format="")})})
public class PSDBValueOPDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBValueOPDefaultACModel() {
        this.initAnnotation(PSDBValueOPDefaultACModel.class);
    }
}

