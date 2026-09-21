/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuiaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a3fac1fb8fd949b07336e3bc763e545f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEUIACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEUIACTIONNAME", format="")})})
public class PSDEUIActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEUIActionDefaultACModel() {
        this.initAnnotation(PSDEUIActionDefaultACModel.class);
    }
}

