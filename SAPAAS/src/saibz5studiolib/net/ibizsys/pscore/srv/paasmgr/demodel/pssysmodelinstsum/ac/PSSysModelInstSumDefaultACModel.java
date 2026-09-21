/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pssysmodelinstsum.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="980e15ed54c0f37c6aff7c52202c71d4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMODELINSTSUMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMODELINSTSUMNAME", format="")})})
public class PSSysModelInstSumDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysModelInstSumDefaultACModel() {
        this.initAnnotation(PSSysModelInstSumDefaultACModel.class);
    }
}

