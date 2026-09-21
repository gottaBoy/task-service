/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.unisys.demodel.psusmoduleinstref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b3c852cfe49aaf8f6134991454ecd365", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUSMODULEINSTREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUSMODULEINSTREFNAME", format="")})})
public class PSUSModuleInstRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUSModuleInstRefDefaultACModel() {
        this.initAnnotation(PSUSModuleInstRefDefaultACModel.class);
    }
}

