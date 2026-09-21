/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfusergroupdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0b60b3e6ed35cc656ceecb6fac698e6e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFUSERGROUPDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFUSERGROUPDETAILNAME", format="")})})
public abstract class WFUserGroupDetailDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFUserGroupDetailDefaultACModelBase() {
        this.initAnnotation(WFUserGroupDetailDefaultACModelBase.class);
    }
}

