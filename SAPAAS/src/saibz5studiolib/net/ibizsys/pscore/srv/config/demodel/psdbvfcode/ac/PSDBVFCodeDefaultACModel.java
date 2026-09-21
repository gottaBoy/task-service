/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdbvfcode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3bd40223636cc129911da05950fa1aed", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBVFCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBVFCODENAME", format="")})})
public class PSDBVFCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBVFCodeDefaultACModel() {
        this.initAnnotation(PSDBVFCodeDefaultACModel.class);
    }
}

