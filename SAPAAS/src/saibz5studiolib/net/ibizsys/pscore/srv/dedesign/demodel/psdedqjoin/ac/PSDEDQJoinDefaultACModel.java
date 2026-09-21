/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedqjoin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="86dca81427cd4060905a2dab73458b16", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDQJOINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDQJOINNAME", format="")})})
public class PSDEDQJoinDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDQJoinDefaultACModel() {
        this.initAnnotation(PSDEDQJoinDefaultACModel.class);
    }
}

