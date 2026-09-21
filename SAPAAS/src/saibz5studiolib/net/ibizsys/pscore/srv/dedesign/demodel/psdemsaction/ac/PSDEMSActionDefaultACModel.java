/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemsaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a44e33aefb5e877ff47edff770d59021", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMSACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEACTIONNAME", format="")})})
public class PSDEMSActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEMSActionDefaultACModel() {
        this.initAnnotation(PSDEMSActionDefaultACModel.class);
    }
}

