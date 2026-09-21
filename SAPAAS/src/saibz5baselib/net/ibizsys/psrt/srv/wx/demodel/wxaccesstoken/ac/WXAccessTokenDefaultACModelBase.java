/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wx.demodel.wxaccesstoken.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7c0817a9156329b7eed4a878988f31cc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WXACCESSTOKENID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WXACCESSTOKENNAME", format="")})})
public abstract class WXAccessTokenDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WXAccessTokenDefaultACModelBase() {
        this.initAnnotation(WXAccessTokenDefaultACModelBase.class);
    }
}

