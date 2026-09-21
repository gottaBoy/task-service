/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysvaluerule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="36b620a7874e53c6a0e494b3d0a0ef50", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSVALUERULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSVALUERULENAME", format="")})})
public class PSSysValueRuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysValueRuleDefaultACModel() {
        this.initAnnotation(PSSysValueRuleDefaultACModel.class);
    }
}

