/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdbserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9ba47ad76b51f822ec35564d8475e09a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBSERVERNAME", format="")})})
public class PSDBServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBServerDefaultACModel() {
        this.initAnnotation(PSDBServerDefaultACModel.class);
    }
}

