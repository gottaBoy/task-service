/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedbindex.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="700e29505cf19c33ccf4ca7415d7d105", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDBINDEXID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDBINDEXNAME", format="")})})
public class PSDEDBIndexDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDBIndexDefaultACModel() {
        this.initAnnotation(PSDEDBIndexDefaultACModel.class);
    }
}

