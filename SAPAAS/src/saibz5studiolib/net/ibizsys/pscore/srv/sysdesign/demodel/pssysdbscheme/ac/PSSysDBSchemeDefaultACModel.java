/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbscheme.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1ac9d0c00e5245a45b4b79846a38d9f3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDBSCHEMEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDBSCHEMENAME", format="")})})
public class PSSysDBSchemeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDBSchemeDefaultACModel() {
        this.initAnnotation(PSSysDBSchemeDefaultACModel.class);
    }
}

