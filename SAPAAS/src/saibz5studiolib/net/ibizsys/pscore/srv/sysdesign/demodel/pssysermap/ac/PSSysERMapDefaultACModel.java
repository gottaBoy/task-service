/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysermap.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a624f6b70af8923b0c5968485438c18f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSERMAPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSERMAPNAME", format="")})})
public class PSSysERMapDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysERMapDefaultACModel() {
        this.initAnnotation(PSSysERMapDefaultACModel.class);
    }
}

