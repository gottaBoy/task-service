/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedqcodecond.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a63ba29a6a13297f39887a66a86f3d3a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDQCODECONDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDQCODECONDNAME", format="")})})
public class PSDEDQCodeCondDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDQCodeCondDefaultACModel() {
        this.initAnnotation(PSDEDQCodeCondDefaultACModel.class);
    }
}

