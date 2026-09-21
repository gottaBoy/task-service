/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbobj.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="bea7e6388274283e3a157194a491993d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCDBOBJID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCDBOBJNAME", format="")})})
public class PSDCDBObjDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCDBObjDefaultACModel() {
        this.initAnnotation(PSDCDBObjDefaultACModel.class);
    }
}

