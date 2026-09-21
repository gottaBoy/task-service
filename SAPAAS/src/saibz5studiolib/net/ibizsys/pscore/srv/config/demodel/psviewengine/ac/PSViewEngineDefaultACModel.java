/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewengine.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="bd426a00840360c993a6139549a8d6a4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWENGINEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWENGINENAME", format="")})})
public class PSViewEngineDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewEngineDefaultACModel() {
        this.initAnnotation(PSViewEngineDefaultACModel.class);
    }
}

