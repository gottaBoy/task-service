/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.eaidesign.demodel.pssyseaider.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="947d38d3e07ebc3119d9b7171a1ac6d8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSEAIDERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSEAIDERNAME", format="")})})
public class PSSysEAIDERDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysEAIDERDefaultACModel() {
        this.initAnnotation(PSSysEAIDERDefaultACModel.class);
    }
}

