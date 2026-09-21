/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pshelpprjtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d08847a31e957f68d1be87e6e6af2fb6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPPRJTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPPRJTYPENAME", format="")})})
public class PSHelpPrjTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpPrjTypeDefaultACModel() {
        this.initAnnotation(PSHelpPrjTypeDefaultACModel.class);
    }
}

