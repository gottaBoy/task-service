/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdcinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f55211767db188cbae85a1fc3da79e70", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCINSTNAME", format="")})})
public class PSDCInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCInstDefaultACModel() {
        this.initAnnotation(PSDCInstDefaultACModel.class);
    }
}

