/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbaselite.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2d4a437244bb2f326bb1119e8b431647", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVIEWBASEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVIEWBASENAME", format="")})})
public class PSDEViewBaseLiteDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEViewBaseLiteDefaultACModel() {
        this.initAnnotation(PSDEViewBaseLiteDefaultACModel.class);
    }
}

