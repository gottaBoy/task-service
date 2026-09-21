/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psviewmsggroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cc49a74f48bdf39bd0b7b98418691b4b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWMSGGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWMSGGROUPNAME", format="")})})
public class PSViewMsgGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewMsgGroupDefaultACModel() {
        this.initAnnotation(PSViewMsgGroupDefaultACModel.class);
    }
}

