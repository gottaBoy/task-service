/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psderdefmap.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3ff677b656430375ba93343b385f7955", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDERDEFMAPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDERDEFMAPNAME", format="")})})
public class PSDERDEFMapDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDERDEFMapDefaultACModel() {
        this.initAnnotation(PSDERDEFMapDefaultACModel.class);
    }
}

