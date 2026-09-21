/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynadeformtempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="caeabcf1e7b949486ca5e5f359d5bb1d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNADEFORMTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNADEFORMTEMPLNAME", format="")})})
public class PSDynaDEFormTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaDEFormTemplDefaultACModel() {
        this.initAnnotation(PSDynaDEFormTemplDefaultACModel.class);
    }
}

