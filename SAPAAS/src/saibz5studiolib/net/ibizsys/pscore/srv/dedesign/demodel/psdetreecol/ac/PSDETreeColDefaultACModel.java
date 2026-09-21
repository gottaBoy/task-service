/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetreecol.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cc051052b723c599282be6c02f78c136", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDETREECOLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDETREECOLNAME", format="")})})
public class PSDETreeColDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDETreeColDefaultACModel() {
        this.initAnnotation(PSDETreeColDefaultACModel.class);
    }
}

