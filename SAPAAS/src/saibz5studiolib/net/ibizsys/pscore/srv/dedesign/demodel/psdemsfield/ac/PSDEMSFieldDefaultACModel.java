/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemsfield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a2fceae98bffea2b051fb0d275bf3690", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMSFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEMSFIELDNAME", format="")})})
public class PSDEMSFieldDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEMSFieldDefaultACModel() {
        this.initAnnotation(PSDEMSFieldDefaultACModel.class);
    }
}

