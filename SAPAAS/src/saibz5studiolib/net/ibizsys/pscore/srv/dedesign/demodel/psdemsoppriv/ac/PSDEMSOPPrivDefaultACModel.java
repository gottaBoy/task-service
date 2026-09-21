/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemsoppriv.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="15dbe33c3a320aac61450f40dca253a0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMSOPPRIVID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEOPPRIVNAME", format="")})})
public class PSDEMSOPPrivDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEMSOPPrivDefaultACModel() {
        this.initAnnotation(PSDEMSOPPrivDefaultACModel.class);
    }
}

