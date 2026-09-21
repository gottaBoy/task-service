/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdcsyncdatatype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5b18bd8d326096199580c9fe4b07edb3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSYNCDATATYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSYNCDATATYPENAME", format="")})})
public class PSDCSyncDataTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCSyncDataTypeDefaultACModel() {
        this.initAnnotation(PSDCSyncDataTypeDefaultACModel.class);
    }
}

