/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.msgsendqueuehis.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6f417c7c7a003110acbb270429717f0f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="MSGSENDQUEUEHISID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="MSGSENDQUEUEHISNAME", format="")})})
public abstract class MsgSendQueueHisDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public MsgSendQueueHisDefaultACModelBase() {
        this.initAnnotation(MsgSendQueueHisDefaultACModelBase.class);
    }
}

