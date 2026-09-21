/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdesysproc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6e693f61929dfb3261d9ba4a60121487", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDESYSPROCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDESYSPROCNAME", format="")})})
public class PSDESysProcDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDESysProcDefaultACModel() {
        this.initAnnotation(PSDESysProcDefaultACModel.class);
    }
}

