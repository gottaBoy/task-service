/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysrefde.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="720b6df46bfbe2eedb9c3baaff3af7f6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSREFDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSREFDENAME", format="")})})
public class PSSysRefDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysRefDEDefaultACModel() {
        this.initAnnotation(PSSysRefDEDefaultACModel.class);
    }
}

