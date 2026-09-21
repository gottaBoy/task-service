/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pseditortype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="50eb16ea68b6397ef54d667a3c2d1125", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSEDITORTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSEDITORTYPENAME", format="")})})
public class PSEditorTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSEditorTypeDefaultACModel() {
        this.initAnnotation(PSEditorTypeDefaultACModel.class);
    }
}

