/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.unisys.demodel.psusmoduleinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="406b5a0320a306cf57a8979148aa64b2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUSMODULEINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUSMODULEINSTNAME", format="")})})
public class PSUSModuleInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUSModuleInstDefaultACModel() {
        this.initAnnotation(PSUSModuleInstDefaultACModel.class);
    }
}

