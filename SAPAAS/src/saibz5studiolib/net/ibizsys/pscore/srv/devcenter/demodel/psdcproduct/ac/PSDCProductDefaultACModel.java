/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcproduct.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4c27376235988247fa22e3525cc65ed5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCPRODUCTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCPRODUCTNAME", format="")})})
public class PSDCProductDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCProductDefaultACModel() {
        this.initAnnotation(PSDCProductDefaultACModel.class);
    }
}

