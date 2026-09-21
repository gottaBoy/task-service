/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelexample.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1ca2af5b90f2eeafd98815d947bbe5dc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELEXAMPLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELEXAMPLENAME", format="")})})
public class PSModelExampleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelExampleDefaultACModel() {
        this.initAnnotation(PSModelExampleDefaultACModel.class);
    }
}

