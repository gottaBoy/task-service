/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbproc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="333d97d64b9331ba6b24bc54c30a790d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCDBPROCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCDBPROCNAME", format="")})})
public class PSDCDBProcDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCDBProcDefaultACModel() {
        this.initAnnotation(PSDCDBProcDefaultACModel.class);
    }
}

