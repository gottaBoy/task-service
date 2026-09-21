/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewtypelogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="31ce80fc886a1aa4e47a81f61d247510", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWTYPELOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWTYPELOGICNAME", format="")})})
public class PSViewTypeLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewTypeLogicDefaultACModel() {
        this.initAnnotation(PSViewTypeLogicDefaultACModel.class);
    }
}

