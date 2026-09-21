/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdectrl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5b64c3e972d9778f5b16fb4703f076f5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDECTRLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDECTRLNAME", format="")})})
public class PSDECtrlDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDECtrlDefaultACModel() {
        this.initAnnotation(PSDECtrlDefaultACModel.class);
    }
}

