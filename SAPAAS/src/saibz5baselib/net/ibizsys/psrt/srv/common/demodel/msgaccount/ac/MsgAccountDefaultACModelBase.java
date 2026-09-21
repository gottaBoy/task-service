/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.msgaccount.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7ce656616f83e08ed4aeba648bb0a30b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="MSGACCOUNTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="MSGACCOUNTNAME", format="")})})
public abstract class MsgAccountDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public MsgAccountDefaultACModelBase() {
        this.initAnnotation(MsgAccountDefaultACModelBase.class);
    }
}

