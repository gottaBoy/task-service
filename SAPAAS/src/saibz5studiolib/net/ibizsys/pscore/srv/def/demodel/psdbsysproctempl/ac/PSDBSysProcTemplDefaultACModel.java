/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psdbsysproctempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="dbb646ea1a5cadd2f083e33b1f2132d8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBSYSPROCTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBSYSPROCTEMPLNAME", format="")})})
public class PSDBSysProcTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBSysProcTemplDefaultACModel() {
        this.initAnnotation(PSDBSysProcTemplDefaultACModel.class);
    }
}

