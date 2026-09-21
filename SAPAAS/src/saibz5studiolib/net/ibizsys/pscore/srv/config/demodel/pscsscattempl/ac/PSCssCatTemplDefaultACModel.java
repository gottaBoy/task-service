/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscsscattempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9bf3fe734f39aa5ae3c06036adf0925f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCSSCATTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCSSCATTEMPLNAME", format="")})})
public class PSCssCatTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCssCatTemplDefaultACModel() {
        this.initAnnotation(PSCssCatTemplDefaultACModel.class);
    }
}

