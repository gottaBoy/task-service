/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userroledefield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="10d6c2ea8dda8754dcde1bceab9704c5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLEDEFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLEDEFIELDNAME", format="")})})
public abstract class UserRoleDEFieldDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleDEFieldDefaultACModelBase() {
        this.initAnnotation(UserRoleDEFieldDefaultACModelBase.class);
    }
}

