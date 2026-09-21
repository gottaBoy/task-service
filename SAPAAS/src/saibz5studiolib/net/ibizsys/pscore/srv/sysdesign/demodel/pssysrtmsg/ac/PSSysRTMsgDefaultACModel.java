/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysrtmsg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2b6b4fa9a55004bc461f505dd07b3f7d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSRTMSGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSRTMSGNAME", format="")})})
public class PSSysRTMsgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysRTMsgDefaultACModel() {
        this.initAnnotation(PSSysRTMsgDefaultACModel.class);
    }
}

