/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefivr.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d40562a838579fe59a29ba74cbb91e27", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFIVRID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFIVRNAME", format="")})})
public class PSDEFIVRDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFIVRDefaultACModel() {
        this.initAnnotation(PSDEFIVRDefaultACModel.class);
    }
}

