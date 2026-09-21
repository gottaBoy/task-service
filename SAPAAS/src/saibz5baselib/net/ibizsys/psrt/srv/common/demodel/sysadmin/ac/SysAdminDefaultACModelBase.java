/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.sysadmin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="089885ec20e095e248e78d49d3153815", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="SYSADMINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="SYSADMINNAME", format="")})})
public abstract class SysAdminDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public SysAdminDefaultACModelBase() {
        this.initAnnotation(SysAdminDefaultACModelBase.class);
    }
}

