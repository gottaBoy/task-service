/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e56d1d16ea2c448b74c49c27e75fcdb6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCCODESNIPPETID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCCODESNIPPETNAME", format="")})})
public class PSDCCodeSnippetDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCCodeSnippetDefaultACModel() {
        this.initAnnotation(PSDCCodeSnippetDefaultACModel.class);
    }
}

