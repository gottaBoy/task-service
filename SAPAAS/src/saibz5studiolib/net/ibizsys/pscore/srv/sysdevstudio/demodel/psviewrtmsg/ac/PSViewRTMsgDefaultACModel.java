/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psviewrtmsg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1104152f49c38fcab45868197fa0c037", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWRTMSGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWRTMSGNAME", format="")})})
public class PSViewRTMsgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewRTMsgDefaultACModel() {
        this.initAnnotation(PSViewRTMsgDefaultACModel.class);
    }
}

