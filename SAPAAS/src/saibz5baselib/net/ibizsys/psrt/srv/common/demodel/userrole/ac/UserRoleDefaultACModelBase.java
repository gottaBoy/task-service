/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userrole.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1e40618663977c439800bf56d8ac4390", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLENAME", format="")})})
public abstract class UserRoleDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleDefaultACModelBase() {
        this.initAnnotation(UserRoleDefaultACModelBase.class);
    }
}

