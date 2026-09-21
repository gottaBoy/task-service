/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewctrl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c84a350acbaeea9fde2edfdcd61208c2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVIEWCTRLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVIEWCTRLNAME", format="")})})
public class PSDEViewCtrlDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEViewCtrlDefaultACModel() {
        this.initAnnotation(PSDEViewCtrlDefaultACModel.class);
    }
}

