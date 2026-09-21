/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userroledetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a6ba8b8895f3f2438f9e9ef761ccb29c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLEDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLEDETAILNAME", format="")})})
public abstract class UserRoleDetailDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleDetailDefaultACModelBase() {
        this.initAnnotation(UserRoleDetailDefaultACModelBase.class);
    }
}

