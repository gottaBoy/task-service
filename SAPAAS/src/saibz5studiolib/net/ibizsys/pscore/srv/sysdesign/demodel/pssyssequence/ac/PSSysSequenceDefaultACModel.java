/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssequence.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="70054ddb42de94251769588ee247e821", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSEQUENCEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSEQUENCENAME", format="")})})
public class PSSysSequenceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSequenceDefaultACModel() {
        this.initAnnotation(PSSysSequenceDefaultACModel.class);
    }
}

