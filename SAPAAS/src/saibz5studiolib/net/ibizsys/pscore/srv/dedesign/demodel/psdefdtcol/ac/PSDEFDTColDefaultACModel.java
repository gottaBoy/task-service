/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefdtcol.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="08b8e71384f0c3d45ac791433703116c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFDTCOLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFDTCOLNAME", format="")})})
public class PSDEFDTColDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFDTColDefaultACModel() {
        this.initAnnotation(PSDEFDTColDefaultACModel.class);
    }
}

