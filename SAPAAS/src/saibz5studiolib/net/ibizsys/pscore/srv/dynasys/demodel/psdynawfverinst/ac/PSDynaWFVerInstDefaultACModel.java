/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynawfverinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="73f34b86b0523c11bc55d6db3e9ae4b7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNAWFVERINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNAWFVERINSTNAME", format="")})})
public class PSDynaWFVerInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaWFVerInstDefaultACModel() {
        this.initAnnotation(PSDynaWFVerInstDefaultACModel.class);
    }
}

