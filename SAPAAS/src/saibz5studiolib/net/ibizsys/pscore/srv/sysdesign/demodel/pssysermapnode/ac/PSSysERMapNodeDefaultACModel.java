/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysermapnode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f6748010b50a5de655c6ab153e816560", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSERMAPNODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSERMAPNODENAME", format="")})})
public class PSSysERMapNodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysERMapNodeDefaultACModel() {
        this.initAnnotation(PSSysERMapNodeDefaultACModel.class);
    }
}

