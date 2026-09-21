/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.search.demodel.pssyssearchdefield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="db6fc2318a4b42616bfcc284b4ab0be8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSEARCHDEFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSEARCHDEFIELDNAME", format="")})})
public class PSSysSearchDEFieldDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSearchDEFieldDefaultACModel() {
        this.initAnnotation(PSSysSearchDEFieldDefaultACModel.class);
    }
}

