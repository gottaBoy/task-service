/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynacodelistinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b38dd7061e337a8dcaa30c5b89764b43", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNACODELISTINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNACODELISTINSTNAME", format="")})})
public class PSDynaCodeListInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaCodeListInstDefaultACModel() {
        this.initAnnotation(PSDynaCodeListInstDefaultACModel.class);
    }
}

