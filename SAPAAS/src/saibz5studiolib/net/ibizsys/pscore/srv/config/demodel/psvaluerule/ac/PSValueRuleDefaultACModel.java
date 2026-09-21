/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvaluerule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="196f7ee66eb20385698b69d6051ecf57", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVALUERULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVALUERULENAME", format="")})})
public class PSValueRuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSValueRuleDefaultACModel() {
        this.initAnnotation(PSValueRuleDefaultACModel.class);
    }
}

