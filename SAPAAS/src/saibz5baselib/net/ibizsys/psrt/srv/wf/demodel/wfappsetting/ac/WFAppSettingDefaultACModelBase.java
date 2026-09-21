/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfappsetting.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="598b85c09bc9375e762590d2ab97552c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFAPPSETTINGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFAPPSETTINGNAME", format="")})})
public abstract class WFAppSettingDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFAppSettingDefaultACModelBase() {
        this.initAnnotation(WFAppSettingDefaultACModelBase.class);
    }
}

