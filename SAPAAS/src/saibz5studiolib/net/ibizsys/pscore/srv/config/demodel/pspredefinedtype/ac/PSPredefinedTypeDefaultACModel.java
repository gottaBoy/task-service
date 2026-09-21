/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspredefinedtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="db620b9adbb8fcd2c5788f730fdf009c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPREDEFINEDTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPREDEFINEDTYPENAME", format="")})})
public class PSPredefinedTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPredefinedTypeDefaultACModel() {
        this.initAnnotation(PSPredefinedTypeDefaultACModel.class);
    }
}

