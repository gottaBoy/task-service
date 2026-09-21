/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdegeiudetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c1774fb5e27bdd628a2be653a5fd42d7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEGEIUDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEGRIDCOLNAME", format="")})})
public class PSDEGEIUDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEGEIUDetailDefaultACModel() {
        this.initAnnotation(PSDEGEIUDetailDefaultACModel.class);
    }
}

