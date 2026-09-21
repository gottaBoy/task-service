/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psuienginetypeparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="22376d5817d1a4ba6f27aa3d004865c5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUIENGINETYPEPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUIENGINETYPEPARAMNAME", format="")})})
public class PSUIEngineTypeParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUIEngineTypeParamDefaultACModel() {
        this.initAnnotation(PSUIEngineTypeParamDefaultACModel.class);
    }
}

