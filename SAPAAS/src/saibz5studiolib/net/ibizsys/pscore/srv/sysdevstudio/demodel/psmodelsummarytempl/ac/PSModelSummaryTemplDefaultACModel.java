/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psmodelsummarytempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6bc921ee0ad91d5f96fea23646a51533", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELSUMMARYTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELSUMMARYTEMPLNAME", format="")})})
public class PSModelSummaryTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelSummaryTemplDefaultACModel() {
        this.initAnnotation(PSModelSummaryTemplDefaultACModel.class);
    }
}

