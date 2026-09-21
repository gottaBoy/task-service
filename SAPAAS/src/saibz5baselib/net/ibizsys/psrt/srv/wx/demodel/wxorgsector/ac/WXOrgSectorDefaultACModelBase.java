/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wx.demodel.wxorgsector.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2b5ee3ad72f76d2cb7d12f8c5f31b817", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WXORGSECTORID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WXORGSECTORNAME", format="")})})
public abstract class WXOrgSectorDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WXOrgSectorDefaultACModelBase() {
        this.initAnnotation(WXOrgSectorDefaultACModelBase.class);
    }
}

