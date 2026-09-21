/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wx.demodel.wxaccount.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a807f4b43d86fbcad55c58e4621a8c80", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WXACCOUNTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WXACCOUNTNAME", format="")})})
public abstract class WXAccountDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WXAccountDefaultACModelBase() {
        this.initAnnotation(WXAccountDefaultACModelBase.class);
    }
}

