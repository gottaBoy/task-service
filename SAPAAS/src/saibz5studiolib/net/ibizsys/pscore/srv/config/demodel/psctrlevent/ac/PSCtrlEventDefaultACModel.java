/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psctrlevent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a08660cb0f5d408d9d985cca03bf7c23", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLEVENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLEVENTNAME", format="")})})
public class PSCtrlEventDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlEventDefaultACModel() {
        this.initAnnotation(PSCtrlEventDefaultACModel.class);
    }
}

