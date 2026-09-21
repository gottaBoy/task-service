/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspanellltype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2b74a3cb31a3b7acb92fd1c3d6b042b0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPANELLLTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPANELLLTYPENAME", format="")})})
public class PSPanelLLTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPanelLLTypeDefaultACModel() {
        this.initAnnotation(PSPanelLLTypeDefaultACModel.class);
    }
}

