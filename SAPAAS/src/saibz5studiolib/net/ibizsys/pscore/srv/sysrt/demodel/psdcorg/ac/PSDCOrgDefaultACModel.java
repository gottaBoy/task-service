/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysrt.demodel.psdcorg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ed3e6a5df948a018e7d3a98057e2a4c9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCORGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCORGNAME", format="")})})
public class PSDCOrgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCOrgDefaultACModel() {
        this.initAnnotation(PSDCOrgDefaultACModel.class);
    }
}

