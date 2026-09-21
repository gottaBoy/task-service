/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedsdq.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="349ed753b7f6303cc412d1f5bde24665", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDSDQID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDSDQNAME", format="")})})
public class PSDEDSDQDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDSDQDefaultACModel() {
        this.initAnnotation(PSDEDSDQDefaultACModel.class);
    }
}

