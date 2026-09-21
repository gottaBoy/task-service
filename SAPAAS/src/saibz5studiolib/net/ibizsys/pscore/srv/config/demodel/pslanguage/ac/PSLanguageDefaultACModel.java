/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pslanguage.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d2b24af5cd34569382615427460d7e92", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSLANGUAGEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSLANGUAGENAME", format="")})})
public class PSLanguageDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSLanguageDefaultACModel() {
        this.initAnnotation(PSLanguageDefaultACModel.class);
    }
}

