/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userdictitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4d49318ec5a12e0a9e36d79e45c641f2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERDICTITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERDICTITEMNAME", format="")})})
public abstract class UserDictItemDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserDictItemDefaultACModelBase() {
        this.initAnnotation(UserDictItemDefaultACModelBase.class);
    }
}

