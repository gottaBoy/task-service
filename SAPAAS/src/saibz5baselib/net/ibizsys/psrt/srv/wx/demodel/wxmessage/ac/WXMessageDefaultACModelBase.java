/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wx.demodel.wxmessage.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="657d40a805a0f204934829160a198bb7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WXMESSAGEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WXMESSAGENAME", format="")})})
public abstract class WXMessageDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WXMessageDefaultACModelBase() {
        this.initAnnotation(WXMessageDefaultACModelBase.class);
    }
}

