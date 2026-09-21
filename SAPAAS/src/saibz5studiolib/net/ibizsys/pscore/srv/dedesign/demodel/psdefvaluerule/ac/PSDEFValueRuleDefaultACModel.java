/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefvaluerule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fb1f3523203ee20e4cedcf75ee6117bf", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFVALUERULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFVALUERULENAME", format="")})})
public class PSDEFValueRuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFValueRuleDefaultACModel() {
        this.initAnnotation(PSDEFValueRuleDefaultACModel.class);
    }
}

