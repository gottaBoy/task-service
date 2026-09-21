/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfreminder.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="352ff0280b4d127a400f4262d6ebfded", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFREMINDERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFREMINDERNAME", format="")})})
public abstract class WFReminderDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFReminderDefaultACModelBase() {
        this.initAnnotation(WFReminderDefaultACModelBase.class);
    }
}

