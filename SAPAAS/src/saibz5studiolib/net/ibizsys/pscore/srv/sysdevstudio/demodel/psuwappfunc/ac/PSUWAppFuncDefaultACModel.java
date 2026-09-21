/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwappfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="bb51f1a8a67f35d2208a351b61b8bd57", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWAPPFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWAPPFUNCNAME", format="")})})
public class PSUWAppFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWAppFuncDefaultACModel() {
        this.initAnnotation(PSUWAppFuncDefaultACModel.class);
    }
}

