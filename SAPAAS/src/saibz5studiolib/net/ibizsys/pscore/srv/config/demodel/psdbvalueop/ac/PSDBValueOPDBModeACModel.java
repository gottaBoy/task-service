/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdbvalueop.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DBMODE", id="C454A783-B905-40F9-8FAD-30F7CC3E664D", dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBVALUEOPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBVALUEOPNAME", format="")})})
public class PSDBValueOPDBModeACModel
extends DEACModelBase {
    public static final String NAME = "DBMODE";

    public PSDBValueOPDBModeACModel() {
        this.initAnnotation(PSDBValueOPDBModeACModel.class);
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
    }
}

