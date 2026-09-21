/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="791adf643d54237810f0c4f0f4248c39", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEMODELNAME", format="")})})
public class PSDEModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEModelDefaultACModel() {
        this.initAnnotation(PSDEModelDefaultACModel.class);
    }
}

