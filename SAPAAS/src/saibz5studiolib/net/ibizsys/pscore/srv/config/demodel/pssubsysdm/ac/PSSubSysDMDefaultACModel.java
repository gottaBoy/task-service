/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubsysdm.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6169ed75e8d15f479ea97382cda20e3c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBSYSDMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBSYSDMNAME", format="")})})
public class PSSubSysDMDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubSysDMDefaultACModel() {
        this.initAnnotation(PSSubSysDMDefaultACModel.class);
    }
}

