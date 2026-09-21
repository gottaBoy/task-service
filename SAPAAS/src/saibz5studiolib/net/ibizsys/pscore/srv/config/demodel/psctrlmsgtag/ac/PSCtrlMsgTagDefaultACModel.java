/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psctrlmsgtag.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="bc3eb840ecd4a72de281868b4587a3a6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLMSGTAGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLMSGTAGNAME", format="")}), @DataItem(name="logicname", dataitemparams={@DataItemParam(name="LOGICNAME", format="%1$s")})})
public class PSCtrlMsgTagDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlMsgTagDefaultACModel() {
        this.initAnnotation(PSCtrlMsgTagDefaultACModel.class);
    }
}

