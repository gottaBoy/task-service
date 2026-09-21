/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdegeivr.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="272af8794de9bbea12f9cb21e3ebafda", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEGEIVRID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEGEIVRNAME", format="")})})
public class PSDEGEIVRDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEGEIVRDefaultACModel() {
        this.initAnnotation(PSDEGEIVRDefaultACModel.class);
    }
}

