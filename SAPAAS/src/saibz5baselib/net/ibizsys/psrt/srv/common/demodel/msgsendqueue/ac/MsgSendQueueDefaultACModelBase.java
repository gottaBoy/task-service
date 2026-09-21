/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.msgsendqueue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="323db6416464fc80757753d4f3666854", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="MSGSENDQUEUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="MSGSENDQUEUENAME", format="")})})
public abstract class MsgSendQueueDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public MsgSendQueueDefaultACModelBase() {
        this.initAnnotation(MsgSendQueueDefaultACModelBase.class);
    }
}

