/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysusercase.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0f59b4112ee216ca83cff0491a7a3ece", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUSERCASEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUSERCASENAME", format="")})})
public class PSSysUserCaseDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUserCaseDefaultACModel() {
        this.initAnnotation(PSSysUserCaseDefaultACModel.class);
    }
}

