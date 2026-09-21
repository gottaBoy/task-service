/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscodesnippet.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d0bc1a3b79542b3dc32a17d63fdaeb61", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCODESNIPPETID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCODESNIPPETNAME", format="")})})
public class PSSysCodeSnippetDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCodeSnippetDefaultACModel() {
        this.initAnnotation(PSSysCodeSnippetDefaultACModel.class);
    }
}

