/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psctrlmsg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="851399fffa509a28b2a2ef6b95eabb03", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLMSGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLMSGNAME", format="")})})
public class PSCtrlMsgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlMsgDefaultACModel() {
        this.initAnnotation(PSCtrlMsgDefaultACModel.class);
    }
}

