/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysbackservice.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="07767c29f40bdc472a4e63fe48f1f221", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBACKSERVICEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBACKSERVICENAME", format="")})})
public class PSSysBackServiceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBackServiceDefaultACModel() {
        this.initAnnotation(PSSysBackServiceDefaultACModel.class);
    }
}

