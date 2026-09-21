/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippetref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0685c44fb4d0efe5c36cb6c3ac589184", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCCODESNIPPETREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCCODESNIPPETREFNAME", format="")})})
public class PSDCCodeSnippetRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCCodeSnippetRefDefaultACModel() {
        this.initAnnotation(PSDCCodeSnippetRefDefaultACModel.class);
    }
}

