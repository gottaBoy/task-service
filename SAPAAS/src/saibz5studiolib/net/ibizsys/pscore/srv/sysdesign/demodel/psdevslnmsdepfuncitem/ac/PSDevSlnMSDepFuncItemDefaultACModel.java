/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfuncitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eb1a132ec15ee516040a1c9242d9c883", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNMSDEPFUNCITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNMSDEPFUNCITEMNAME", format="")})})
public class PSDevSlnMSDepFuncItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnMSDepFuncItemDefaultACModel() {
        this.initAnnotation(PSDevSlnMSDepFuncItemDefaultACModel.class);
    }
}

