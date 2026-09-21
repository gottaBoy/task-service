/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.unisys.demodel.psusmodule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="bd4b21c6e1a56a388735bf970baccb1e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUSMODULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUSMODULENAME", format="")})})
public class PSUSModuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUSModuleDefaultACModel() {
        this.initAnnotation(PSUSModuleDefaultACModel.class);
    }
}

