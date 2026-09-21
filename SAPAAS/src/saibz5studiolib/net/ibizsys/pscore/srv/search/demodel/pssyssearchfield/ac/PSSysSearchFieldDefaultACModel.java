/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.search.demodel.pssyssearchfield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0e37a6c601fc277e6262f42ad07c021b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSEARCHFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSEARCHFIELDNAME", format="")})})
public class PSSysSearchFieldDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSearchFieldDefaultACModel() {
        this.initAnnotation(PSSysSearchFieldDefaultACModel.class);
    }
}

