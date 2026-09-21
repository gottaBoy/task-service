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

@DEACMode(name="DLMODE", id="C841F078-25F8-4806-888C-BAF8C58FCA11", dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBVALUEOPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBVALUEOPNAME", format="")})})
public class PSDBValueOPDLModeACModel
extends DEACModelBase {
    public static final String NAME = "DLMODE";

    public PSDBValueOPDLModeACModel() {
        this.initAnnotation(PSDBValueOPDLModeACModel.class);
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
    }
}

