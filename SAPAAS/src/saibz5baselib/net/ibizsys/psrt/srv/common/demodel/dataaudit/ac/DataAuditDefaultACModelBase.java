/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.dataaudit.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="326125ce130f4bec558c9778daef045c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DATAAUDITID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DATAAUDITNAME", format="")})})
public abstract class DataAuditDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DataAuditDefaultACModelBase() {
        this.initAnnotation(DataAuditDefaultACModelBase.class);
    }
}

