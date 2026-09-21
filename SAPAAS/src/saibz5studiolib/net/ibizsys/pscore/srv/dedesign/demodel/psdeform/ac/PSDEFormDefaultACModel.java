/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeform.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8873e88807ee0de51b57f38f9c33b569", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFORMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFORMNAME", format="")})})
public class PSDEFormDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFormDefaultACModel() {
        this.initAnnotation(PSDEFormDefaultACModel.class);
    }
}

