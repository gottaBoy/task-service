/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdejointype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="18b2ddb30be5ef94f2bf5472311b603c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEJOINTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEJOINTYPENAME", format="")})})
public class PSDEJoinTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEJoinTypeDefaultACModel() {
        this.initAnnotation(PSDEJoinTypeDefaultACModel.class);
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
    }
}

