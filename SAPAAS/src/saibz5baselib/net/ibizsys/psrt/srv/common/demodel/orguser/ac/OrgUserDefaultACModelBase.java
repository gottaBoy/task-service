/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.orguser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1f9576cdcc6a949230c7669182c73648", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="ORGUSERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="ORGUSERNAME", format="")})})
public abstract class OrgUserDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public OrgUserDefaultACModelBase() {
        this.initAnnotation(OrgUserDefaultACModelBase.class);
    }
}

