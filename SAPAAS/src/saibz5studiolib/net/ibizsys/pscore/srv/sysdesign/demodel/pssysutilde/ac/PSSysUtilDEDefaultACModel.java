/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysutilde.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c55744753343d12fbe6ad5e6c405dd70", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUTILDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUTILDENAME", format="")})})
public class PSSysUtilDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUtilDEDefaultACModel() {
        this.initAnnotation(PSSysUtilDEDefaultACModel.class);
    }
}

