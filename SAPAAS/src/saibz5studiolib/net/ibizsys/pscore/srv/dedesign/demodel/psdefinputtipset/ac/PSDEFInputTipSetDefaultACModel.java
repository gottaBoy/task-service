/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefinputtipset.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fd5145c0290156985a69b99308580de9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFINPUTTIPSETID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFINPUTTIPSETNAME", format="")})})
public class PSDEFInputTipSetDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFInputTipSetDefaultACModel() {
        this.initAnnotation(PSDEFInputTipSetDefaultACModel.class);
    }
}

