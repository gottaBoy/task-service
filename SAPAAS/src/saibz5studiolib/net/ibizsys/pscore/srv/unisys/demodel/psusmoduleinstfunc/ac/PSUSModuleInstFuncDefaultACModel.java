/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.unisys.demodel.psusmoduleinstfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b75c00e4f1691fedfe1da15fe8fd752d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUSMODULEINSTFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUSMODULEINSTFUNCNAME", format="")})})
public class PSUSModuleInstFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUSModuleInstFuncDefaultACModel() {
        this.initAnnotation(PSUSModuleInstFuncDefaultACModel.class);
    }
}

