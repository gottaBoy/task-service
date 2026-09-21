/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userdictcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c41d9a5508a558b5ccc8a091c5e249b1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERDICTCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERDICTCATNAME", format="")})})
public abstract class UserDictCatDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserDictCatDefaultACModelBase() {
        this.initAnnotation(UserDictCatDefaultACModelBase.class);
    }
}

