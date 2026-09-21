/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.search.demodel.pssyssearchscheme.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="81cd727d7a361920051d5d64d3598acd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSEARCHSCHEMEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSEARCHSCHEMENAME", format="")})})
public class PSSysSearchSchemeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSearchSchemeDefaultACModel() {
        this.initAnnotation(PSSysSearchSchemeDefaultACModel.class);
    }
}

