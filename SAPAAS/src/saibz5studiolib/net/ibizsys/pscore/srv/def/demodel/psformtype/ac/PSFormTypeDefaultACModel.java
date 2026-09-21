/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psformtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c3ba9d4f122ceeeb3095837094afa594", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSFORMTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSFORMTYPENAME", format="")})})
public class PSFormTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSFormTypeDefaultACModel() {
        this.initAnnotation(PSFormTypeDefaultACModel.class);
    }
}

