/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.usergroupdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="404bf990bacdba520e82d9603063c3dd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERGROUPDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERGROUPDETAILNAME", format="")})})
public abstract class UserGroupDetailDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserGroupDetailDefaultACModelBase() {
        this.initAnnotation(UserGroupDetailDefaultACModelBase.class);
    }
}

