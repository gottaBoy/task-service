/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userroletype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f5d60d6bd8ba7928bbe13fed42ae606a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLETYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLETYPENAME", format="")})})
public abstract class UserRoleTypeDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleTypeDefaultACModelBase() {
        this.initAnnotation(UserRoleTypeDefaultACModelBase.class);
    }
}

