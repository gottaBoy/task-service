/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psviewmsg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a54c6d8ec114f3ffe9f47f7f36da6acb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWMSGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWMSGNAME", format="")})})
public class PSViewMsgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewMsgDefaultACModel() {
        this.initAnnotation(PSViewMsgDefaultACModel.class);
    }
}

