/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfcustomprocess.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4b334725c65c703dfa12a6ed7103a9da", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFCUSTOMPROCESSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFCUSTOMPROCESSNAME", format="")})})
public abstract class WFCustomProcessDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFCustomProcessDefaultACModelBase() {
        this.initAnnotation(WFCustomProcessDefaultACModelBase.class);
    }
}

