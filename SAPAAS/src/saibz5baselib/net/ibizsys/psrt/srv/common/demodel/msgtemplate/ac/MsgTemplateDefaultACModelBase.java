/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.msgtemplate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e2c5b96d6cb0389900da130bc4545add", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="MSGTEMPLATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="MSGTEMPLATENAME", format="")})})
public abstract class MsgTemplateDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public MsgTemplateDefaultACModelBase() {
        this.initAnnotation(MsgTemplateDefaultACModelBase.class);
    }
}

