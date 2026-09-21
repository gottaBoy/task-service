/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5f02d39fdbee15412466cfd0cc54ab52", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCDBFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCDBFUNCNAME", format="")})})
public class PSDCDBFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCDBFuncDefaultACModel() {
        this.initAnnotation(PSDCDBFuncDefaultACModel.class);
    }
}

