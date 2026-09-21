/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynadetempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e80f81a5138dec28e8c1735d32f9e8d3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNADETEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNADETEMPLNAME", format="")})})
public class PSDynaDETemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaDETemplDefaultACModel() {
        this.initAnnotation(PSDynaDETemplDefaultACModel.class);
    }
}

