/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdespcode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eb1dd830b94eb6dad45b086a9f92fec4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDESPCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDESPCODENAME", format="")})})
public class PSDESPCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDESPCodeDefaultACModel() {
        this.initAnnotation(PSDESPCodeDefaultACModel.class);
    }
}

