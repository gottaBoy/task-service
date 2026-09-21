/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrtmsg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="05b9d70b249baa7a6f4e895037b85d10", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELRTMSGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELRTMSGNAME", format="")})})
public class PSModelRTMsgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelRTMsgDefaultACModel() {
        this.initAnnotation(PSModelRTMsgDefaultACModel.class);
    }
}

