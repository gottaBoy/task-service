/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psappfunctype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="506fedd5482ebfa39260085db95103fa", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPFUNCTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPFUNCTYPENAME", format="")})})
public class PSAppFuncTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppFuncTypeDefaultACModel() {
        this.initAnnotation(PSAppFuncTypeDefaultACModel.class);
    }
}

