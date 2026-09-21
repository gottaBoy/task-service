/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscharttype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fd05dbe4e9df6731af6f63bc0c86f14a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCHARTTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCHARTTYPENAME", format="")})})
public class PSChartTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSChartTypeDefaultACModel() {
        this.initAnnotation(PSChartTypeDefaultACModel.class);
    }
}

