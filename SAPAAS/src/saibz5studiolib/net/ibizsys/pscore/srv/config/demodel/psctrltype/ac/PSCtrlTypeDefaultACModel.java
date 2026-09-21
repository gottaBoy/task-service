/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psctrltype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="701b7e8faf7d2a49f3cde932458419d4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLTYPENAME", format="")})})
public class PSCtrlTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlTypeDefaultACModel() {
        this.initAnnotation(PSCtrlTypeDefaultACModel.class);
    }
}

