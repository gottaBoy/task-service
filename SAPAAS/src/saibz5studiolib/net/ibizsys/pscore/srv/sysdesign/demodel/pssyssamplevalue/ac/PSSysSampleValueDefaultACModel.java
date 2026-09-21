/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssamplevalue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1bde9f121f9e925fb3e6df25a5db6036", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSAMPLEVALUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSAMPLEVALUENAME", format="")})})
public class PSSysSampleValueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSampleValueDefaultACModel() {
        this.initAnnotation(PSSysSampleValueDefaultACModel.class);
    }
}

