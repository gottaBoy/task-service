/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.eaidesign.demodel.pssyseaischeme.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="adab72df31a7c65eeda0d709becd3f83", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSEAISCHEMEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSEAISCHEMENAME", format="")})})
public class PSSysEAISchemeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysEAISchemeDefaultACModel() {
        this.initAnnotation(PSSysEAISchemeDefaultACModel.class);
    }
}

