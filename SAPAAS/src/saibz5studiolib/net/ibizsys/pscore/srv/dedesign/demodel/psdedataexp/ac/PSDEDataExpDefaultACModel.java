/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedataexp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1c119f1d22ea522999d382566c7bc0f9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDATAEXPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDATAEXPNAME", format="")})})
public class PSDEDataExpDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDataExpDefaultACModel() {
        this.initAnnotation(PSDEDataExpDefaultACModel.class);
    }
}

