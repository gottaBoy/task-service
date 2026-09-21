/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdetempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="443b087f7bfe4895e8a48849a22785cf", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCDETEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCDETEMPLNAME", format="")})})
public class PSDCDETemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCDETemplDefaultACModel() {
        this.initAnnotation(PSDCDETemplDefaultACModel.class);
    }
}

