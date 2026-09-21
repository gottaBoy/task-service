/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ef2c7b349c855e594aa4fe0cb7ad8b48", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFUSERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFUSERNAME", format="")})})
public abstract class WFUserDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFUserDefaultACModelBase() {
        this.initAnnotation(WFUserDefaultACModelBase.class);
    }
}

