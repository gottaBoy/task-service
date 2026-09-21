/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.usergroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5eba267a2d34c0c5dc686961a48f62d1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERGROUPNAME", format="")})})
public abstract class UserGroupDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserGroupDefaultACModelBase() {
        this.initAnnotation(UserGroupDefaultACModelBase.class);
    }
}

