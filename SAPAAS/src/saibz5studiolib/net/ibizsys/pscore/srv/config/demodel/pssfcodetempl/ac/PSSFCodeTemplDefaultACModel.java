/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfcodetempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="bc359c171326beb45021b038b1289a3e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFCODETEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFCODETEMPLNAME", format="")})})
public class PSSFCodeTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFCodeTemplDefaultACModel() {
        this.initAnnotation(PSSFCodeTemplDefaultACModel.class);
    }
}

