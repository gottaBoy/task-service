/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappmenulogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f24a3208345b6e2fb296ab56647e6994", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPMENULOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPMENULOGICNAME", format="")})})
public class PSAppMenuLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppMenuLogicDefaultACModel() {
        this.initAnnotation(PSAppMenuLogicDefaultACModel.class);
    }
}

