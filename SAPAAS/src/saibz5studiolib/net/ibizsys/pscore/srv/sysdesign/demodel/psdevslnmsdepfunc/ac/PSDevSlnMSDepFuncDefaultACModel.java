/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1cce1174a7bdb39ecb2da0ba91ebc39c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNMSDEPFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNMSDEPFUNCNAME", format="")})})
public class PSDevSlnMSDepFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnMSDepFuncDefaultACModel() {
        this.initAnnotation(PSDevSlnMSDepFuncDefaultACModel.class);
    }
}

