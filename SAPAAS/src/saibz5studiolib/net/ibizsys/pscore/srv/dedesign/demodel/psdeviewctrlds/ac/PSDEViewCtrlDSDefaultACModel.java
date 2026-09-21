/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewctrlds.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f85d6edb18b3fc5d8e250f8b2e12e5b9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVIEWCTRLDSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVIEWCTRLDSNAME", format="")})})
public class PSDEViewCtrlDSDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEViewCtrlDSDefaultACModel() {
        this.initAnnotation(PSDEViewCtrlDSDefaultACModel.class);
    }
}

