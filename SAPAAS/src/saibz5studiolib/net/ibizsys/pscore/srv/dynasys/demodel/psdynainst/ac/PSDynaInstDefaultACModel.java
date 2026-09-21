/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynainst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b7b600c138f3b877db02e277b8059966", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNAINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNAINSTNAME", format="")})})
public class PSDynaInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaInstDefaultACModel() {
        this.initAnnotation(PSDynaInstDefaultACModel.class);
    }
}

