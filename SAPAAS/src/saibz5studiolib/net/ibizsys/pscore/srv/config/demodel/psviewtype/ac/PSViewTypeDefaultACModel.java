/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="951a4159e3541b4385a93fafadfd2e40", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWTYPENAME", format="")})})
public class PSViewTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewTypeDefaultACModel() {
        this.initAnnotation(PSViewTypeDefaultACModel.class);
    }
}

