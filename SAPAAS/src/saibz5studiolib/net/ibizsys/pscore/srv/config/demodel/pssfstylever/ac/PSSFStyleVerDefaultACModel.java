/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstylever.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="78693d75a767cb4d43edc0873504c43a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFSTYLEVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFSTYLEVERNAME", format="")})})
public class PSSFStyleVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFStyleVerDefaultACModel() {
        this.initAnnotation(PSSFStyleVerDefaultACModel.class);
    }
}

