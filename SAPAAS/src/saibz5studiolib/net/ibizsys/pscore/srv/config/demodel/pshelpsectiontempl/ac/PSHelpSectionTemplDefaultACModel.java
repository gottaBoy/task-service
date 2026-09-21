/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pshelpsectiontempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5692069b7417f1752abb6eaf8dec5083", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPSECTIONTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPSECTIONTEMPLNAME", format="")})})
public class PSHelpSectionTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpSectionTemplDefaultACModel() {
        this.initAnnotation(PSHelpSectionTemplDefaultACModel.class);
    }
}

