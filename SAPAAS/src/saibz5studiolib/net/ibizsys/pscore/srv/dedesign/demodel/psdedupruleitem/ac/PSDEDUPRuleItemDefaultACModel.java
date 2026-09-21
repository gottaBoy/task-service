/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedupruleitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="dd0800e2d78cc030fca5b7ccdfe0089a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDUPRULEITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDUPRULEITEMNAME", format="")})})
public class PSDEDUPRuleItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDUPRuleItemDefaultACModel() {
        this.initAnnotation(PSDEDUPRuleItemDefaultACModel.class);
    }
}

