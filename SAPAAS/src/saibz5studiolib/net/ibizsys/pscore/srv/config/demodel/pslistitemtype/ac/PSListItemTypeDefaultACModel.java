/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pslistitemtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cb2f41bea6a334013148fb2ef491ec50", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSLISTITEMTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSLISTITEMTYPENAME", format="")})})
public class PSListItemTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSListItemTypeDefaultACModel() {
        this.initAnnotation(PSListItemTypeDefaultACModel.class);
    }
}

