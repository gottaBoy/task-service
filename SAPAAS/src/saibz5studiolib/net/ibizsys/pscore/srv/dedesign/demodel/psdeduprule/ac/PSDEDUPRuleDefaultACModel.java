/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeduprule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="748747733e385e2c30c04215d7aef6e3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDUPRULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDUPRULENAME", format="")})})
public class PSDEDUPRuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDUPRuleDefaultACModel() {
        this.initAnnotation(PSDEDUPRuleDefaultACModel.class);
    }
}

