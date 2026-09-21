/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdesavr.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f52c7fa8b151996d1fdb913ebc54e436", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDESAVRID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDESAVRNAME", format="")})})
public class PSDESAVRDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDESAVRDefaultACModel() {
        this.initAnnotation(PSDESAVRDefaultACModel.class);
    }
}

