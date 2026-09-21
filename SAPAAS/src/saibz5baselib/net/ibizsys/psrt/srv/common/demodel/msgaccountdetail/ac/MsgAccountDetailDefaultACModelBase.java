/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.msgaccountdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b0a62e77dcb2ca3226353cea1c370b79", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="MSGACCOUNTDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="MSGACCOUNTDETAILNAME", format="")})})
public abstract class MsgAccountDetailDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public MsgAccountDetailDefaultACModelBase() {
        this.initAnnotation(MsgAccountDetailDefaultACModelBase.class);
    }
}

