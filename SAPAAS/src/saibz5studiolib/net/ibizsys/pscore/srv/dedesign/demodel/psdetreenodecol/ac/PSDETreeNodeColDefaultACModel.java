/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetreenodecol.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fab245b69a5a0348ed5c4a45af51fb6d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDETREENODECOLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDETREENODECOLNAME", format="")})})
public class PSDETreeNodeColDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDETreeNodeColDefaultACModel() {
        this.initAnnotation(PSDETreeNodeColDefaultACModel.class);
    }
}

