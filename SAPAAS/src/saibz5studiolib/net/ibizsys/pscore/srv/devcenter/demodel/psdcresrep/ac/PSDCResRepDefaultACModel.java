/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcresrep.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f16b74c38110018be8073e89472e04be", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCRESREPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCRESREPNAME", format="")})})
public class PSDCResRepDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCResRepDefaultACModel() {
        this.initAnnotation(PSDCResRepDefaultACModel.class);
    }
}

