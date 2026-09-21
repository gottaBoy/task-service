/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wx.demodel.wxentapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="aeb4861b6d65eff3ef2098ddd7a0d4f5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WXENTAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WXENTAPPNAME", format="")})})
public abstract class WXEntAppDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WXEntAppDefaultACModelBase() {
        this.initAnnotation(WXEntAppDefaultACModelBase.class);
    }
}

