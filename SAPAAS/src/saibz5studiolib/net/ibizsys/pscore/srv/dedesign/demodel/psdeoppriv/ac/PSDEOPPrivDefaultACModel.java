/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeoppriv.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fe37ce32f226c612351e02be34505636", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEOPPRIVID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEOPPRIVNAME", format="")})})
public class PSDEOPPrivDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEOPPrivDefaultACModel() {
        this.initAnnotation(PSDEOPPrivDefaultACModel.class);
    }
}

