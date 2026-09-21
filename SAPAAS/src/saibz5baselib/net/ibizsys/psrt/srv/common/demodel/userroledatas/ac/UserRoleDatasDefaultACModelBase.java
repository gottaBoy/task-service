/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userroledatas.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b2af03b3659b89cfbfc6f8932ff1b61f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLEDATASID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLEDATASNAME", format="")})})
public abstract class UserRoleDatasDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleDatasDefaultACModelBase() {
        this.initAnnotation(UserRoleDatasDefaultACModelBase.class);
    }
}

