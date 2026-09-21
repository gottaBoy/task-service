/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysrtdefinputtip.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="304ff161a7693cab17ed4149ca1bde79", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSRTDEFINPUTTIPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSRTDEFINPUTTIPNAME", format="")})})
public class PSSysRTDEFInputTipDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysRTDEFInputTipDefaultACModel() {
        this.initAnnotation(PSSysRTDEFInputTipDefaultACModel.class);
    }
}

