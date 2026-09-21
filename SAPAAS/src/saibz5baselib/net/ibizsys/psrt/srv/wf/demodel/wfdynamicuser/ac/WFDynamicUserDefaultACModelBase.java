/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfdynamicuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="733170434261be84089d353a6a231373", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFDYNAMICUSERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFDYNAMICUSERNAME", format="")})})
public abstract class WFDynamicUserDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFDynamicUserDefaultACModelBase() {
        this.initAnnotation(WFDynamicUserDefaultACModelBase.class);
    }
}

