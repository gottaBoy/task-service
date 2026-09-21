/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemodelcnt.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cfe1aceed462e736e4f409d052a3d9cf", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMODELCNTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEMODELCNTNAME", format="")})})
public class PSDEModelCntDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEModelCntDefaultACModel() {
        this.initAnnotation(PSDEModelCntDefaultACModel.class);
    }
}

