/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefvrdsparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4240ef4114a8cd325fc52462f10d50cb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFVRDSPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFVRDSPARAMNAME", format="")})})
public class PSDEFVRDSParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFVRDSParamDefaultACModel() {
        this.initAnnotation(PSDEFVRDSParamDefaultACModel.class);
    }
}

