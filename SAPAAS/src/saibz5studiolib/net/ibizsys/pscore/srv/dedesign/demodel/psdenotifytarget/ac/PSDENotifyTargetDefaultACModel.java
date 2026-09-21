/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdenotifytarget.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="97aa9dc266c5c05b5cbb9525ca702948", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDENOTIFYTARGETID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDENOTIFYTARGETNAME", format="")})})
public class PSDENotifyTargetDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDENotifyTargetDefaultACModel() {
        this.initAnnotation(PSDENotifyTargetDefaultACModel.class);
    }
}

