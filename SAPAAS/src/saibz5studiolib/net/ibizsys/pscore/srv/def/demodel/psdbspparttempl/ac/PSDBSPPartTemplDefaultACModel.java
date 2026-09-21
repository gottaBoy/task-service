/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psdbspparttempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="351ee0eaca7457210e8c355ad8b24895", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBSPPARTTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBSPPARTTEMPLNAME", format="")})})
public class PSDBSPPartTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBSPPartTemplDefaultACModel() {
        this.initAnnotation(PSDBSPPartTemplDefaultACModel.class);
    }
}

