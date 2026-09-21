/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.sysadminfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2e71859d8147cd788d815a3371f9ebd6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="SYSADMINFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="SYSADMINFUNCNAME", format="")})})
public abstract class SysAdminFuncDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public SysAdminFuncDefaultACModelBase() {
        this.initAnnotation(SysAdminFuncDefaultACModelBase.class);
    }
}

