/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstylecode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="41a3f669e85c4dae45261b26ec98c5ac", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFSTYLECODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFSTYLECODENAME", format="")})})
public class PSSFStyleCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFStyleCodeDefaultACModel() {
        this.initAnnotation(PSSFStyleCodeDefaultACModel.class);
    }
}

