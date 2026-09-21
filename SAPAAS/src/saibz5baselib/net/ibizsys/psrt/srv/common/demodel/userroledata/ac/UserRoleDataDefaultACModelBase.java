/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userroledata.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c4125399a698dc5f8acca6dc8b38b353", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLEDATAID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLEDATANAME", format="")})})
public abstract class UserRoleDataDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleDataDefaultACModelBase() {
        this.initAnnotation(UserRoleDataDefaultACModelBase.class);
    }
}

