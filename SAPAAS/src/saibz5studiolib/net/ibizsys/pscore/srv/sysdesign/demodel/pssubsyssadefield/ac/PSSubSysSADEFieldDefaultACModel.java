/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssubsyssadefield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="65d3177d4ac956f3413907bbeaab75aa", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBSYSSADEFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBSYSSADEFIELDNAME", format="")})})
public class PSSubSysSADEFieldDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubSysSADEFieldDefaultACModel() {
        this.initAnnotation(PSSubSysSADEFieldDefaultACModel.class);
    }
}

