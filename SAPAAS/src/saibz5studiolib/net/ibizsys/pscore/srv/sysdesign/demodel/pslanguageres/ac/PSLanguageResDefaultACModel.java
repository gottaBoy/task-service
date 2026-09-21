/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pslanguageres.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a4437a572742643e7895c8b191cec1b1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSLANGUAGERESID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSLANGUAGERESNAME", format="")})})
public class PSLanguageResDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSLanguageResDefaultACModel() {
        this.initAnnotation(PSLanguageResDefaultACModel.class);
    }
}

