/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvtctrl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2681e967c688c4a0eded96ed5a74ba3c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVTCTRLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVTCTRLNAME", format="")})})
public class PSVTCtrlDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSVTCtrlDefaultACModel() {
        this.initAnnotation(PSVTCtrlDefaultACModel.class);
    }
}

