/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.dataauditdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7d9fefe4909e0cfffcb467129475b02d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DATAAUDITDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DATAAUDITDETAILNAME", format="")})})
public abstract class DataAuditDetailDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DataAuditDetailDefaultACModelBase() {
        this.initAnnotation(DataAuditDetailDefaultACModelBase.class);
    }
}

