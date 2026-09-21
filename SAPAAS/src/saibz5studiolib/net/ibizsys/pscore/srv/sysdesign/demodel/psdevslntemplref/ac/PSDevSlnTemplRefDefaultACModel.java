/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntemplref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="24fea21f49a872d8fc5ac24f65d8a609", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNTEMPLREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNTEMPLREFNAME", format="")})})
public class PSDevSlnTemplRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnTemplRefDefaultACModel() {
        this.initAnnotation(PSDevSlnTemplRefDefaultACModel.class);
    }
}

