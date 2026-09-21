/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbpart.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b14b9295ad19dd9878cd93c6ef1a7183", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDBPARTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDBPARTNAME", format="")})})
public class PSSysDBPartDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDBPartDefaultACModel() {
        this.initAnnotation(PSSysDBPartDefaultACModel.class);
    }
}

