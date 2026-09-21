/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewlogictype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7b14e6a3dc05c791e2200eeaedb55087", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWLOGICTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWLOGICTYPENAME", format="")})})
public class PSViewLogicTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewLogicTypeDefaultACModel() {
        this.initAnnotation(PSViewLogicTypeDefaultACModel.class);
    }
}

