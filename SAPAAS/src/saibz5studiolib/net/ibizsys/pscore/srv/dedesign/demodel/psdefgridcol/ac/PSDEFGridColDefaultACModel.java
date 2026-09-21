/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefgridcol.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5ef6c739141b0e135379c369db79c977", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFGRIDCOLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFGRIDCOLNAME", format="")})})
public class PSDEFGridColDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFGridColDefaultACModel() {
        this.initAnnotation(PSDEFGridColDefaultACModel.class);
    }
}

