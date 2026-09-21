/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.eaidesign.demodel.pssyseaide.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="75a71daba7c263a4703f56c7aa60936f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSEAIDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSEAIDENAME", format="")})})
public class PSSysEAIDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysEAIDEDefaultACModel() {
        this.initAnnotation(PSSysEAIDEDefaultACModel.class);
    }
}

