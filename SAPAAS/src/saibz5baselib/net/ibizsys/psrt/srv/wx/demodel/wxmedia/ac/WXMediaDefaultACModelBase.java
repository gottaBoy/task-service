/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wx.demodel.wxmedia.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6e265a32be682141a452a8832bc78530", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WXMEDIAID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WXMEDIANAME", format="")})})
public abstract class WXMediaDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WXMediaDefaultACModelBase() {
        this.initAnnotation(WXMediaDefaultACModelBase.class);
    }
}

