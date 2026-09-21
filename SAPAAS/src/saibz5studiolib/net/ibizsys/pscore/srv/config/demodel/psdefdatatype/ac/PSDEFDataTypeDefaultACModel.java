/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdefdatatype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="52e0a3afadde72673ad91bf80cf8210e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFDATATYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFDATATYPENAME", format="")})})
public class PSDEFDataTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFDataTypeDefaultACModel() {
        this.initAnnotation(PSDEFDataTypeDefaultACModel.class);
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
    }
}

