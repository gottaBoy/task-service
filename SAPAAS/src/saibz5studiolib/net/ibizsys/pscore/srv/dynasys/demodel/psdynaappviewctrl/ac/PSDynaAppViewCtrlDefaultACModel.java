/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynaappviewctrl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="39c36f74b771abb0e93fd23a3dbf3a98", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNAAPPVIEWCTRLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNAAPPVIEWCTRLNAME", format="")})})
public class PSDynaAppViewCtrlDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaAppViewCtrlDefaultACModel() {
        this.initAnnotation(PSDynaAppViewCtrlDefaultACModel.class);
    }
}

