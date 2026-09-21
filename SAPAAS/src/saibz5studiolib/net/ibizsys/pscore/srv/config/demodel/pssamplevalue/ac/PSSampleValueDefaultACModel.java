/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssamplevalue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="66237ae8ef5c50812a4aec1bb5d47298", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSAMPLEVALUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSAMPLEVALUENAME", format="")})})
public class PSSampleValueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSampleValueDefaultACModel() {
        this.initAnnotation(PSSampleValueDefaultACModel.class);
    }
}

