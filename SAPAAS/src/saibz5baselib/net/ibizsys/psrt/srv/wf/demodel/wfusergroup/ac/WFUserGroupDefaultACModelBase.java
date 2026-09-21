/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfusergroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e64a576e41250c73ac1f51c15d6631e2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFUSERGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFUSERGROUPNAME", format="")})})
public abstract class WFUserGroupDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFUserGroupDefaultACModelBase() {
        this.initAnnotation(WFUserGroupDefaultACModelBase.class);
    }
}

