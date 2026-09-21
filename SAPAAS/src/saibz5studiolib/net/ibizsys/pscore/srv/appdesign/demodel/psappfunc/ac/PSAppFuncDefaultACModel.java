/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="26e3efd6f085105daec5bb6bdd0e0836", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPFUNCNAME", format="")})})
public class PSAppFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppFuncDefaultACModel() {
        this.initAnnotation(PSAppFuncDefaultACModel.class);
    }
}

