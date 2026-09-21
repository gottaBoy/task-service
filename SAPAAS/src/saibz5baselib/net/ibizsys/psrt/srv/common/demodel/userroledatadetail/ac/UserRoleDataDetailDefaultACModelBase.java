/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userroledatadetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a54fc7fa42e8260cab1cb33393e222b1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLEDATADETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLEDATADETAILNAME", format="")})})
public abstract class UserRoleDataDetailDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleDataDetailDefaultACModelBase() {
        this.initAnnotation(UserRoleDataDetailDefaultACModelBase.class);
    }
}

