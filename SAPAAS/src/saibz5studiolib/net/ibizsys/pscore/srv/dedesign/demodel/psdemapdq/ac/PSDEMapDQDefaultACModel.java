/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemapdq.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a8186b608f6a7613552b757c85605160", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMAPDQID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEMAPDQNAME", format="")})})
public class PSDEMapDQDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEMapDQDefaultACModel() {
        this.initAnnotation(PSDEMapDQDefaultACModel.class);
    }
}

