/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psdbsysproctype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e4f2e0422607aedcc903b9b88e83afe6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBSYSPROCTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBSYSPROCTYPENAME", format="")})})
public class PSDBSysProcTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBSysProcTypeDefaultACModel() {
        this.initAnnotation(PSDBSysProcTypeDefaultACModel.class);
    }
}

