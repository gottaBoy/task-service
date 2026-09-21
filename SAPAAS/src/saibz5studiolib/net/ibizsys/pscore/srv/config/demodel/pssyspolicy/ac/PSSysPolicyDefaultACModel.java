/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssyspolicy.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a921b98826f4fc3609a8a56957797dc6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSPOLICYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSPOLICYNAME", format="")})})
public class PSSysPolicyDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysPolicyDefaultACModel() {
        this.initAnnotation(PSSysPolicyDefaultACModel.class);
    }
}

