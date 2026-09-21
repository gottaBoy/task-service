/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefieldimp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ad05a95fc2897f554cfb109c2a430e3f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFIELDNAME", format="")})})
public class PSDEFieldImpDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFieldImpDefaultACModel() {
        this.initAnnotation(PSDEFieldImpDefaultACModel.class);
    }
}

