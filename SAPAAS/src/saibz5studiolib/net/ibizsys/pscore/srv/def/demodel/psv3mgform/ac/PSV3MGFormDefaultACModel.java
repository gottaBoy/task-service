/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psv3mgform.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a9781e14a79ccf06c3a75a11346b50a6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSV3MGFORMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSV3MGFORMNAME", format="")})})
public class PSV3MGFormDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSV3MGFormDefaultACModel() {
        this.initAnnotation(PSV3MGFormDefaultACModel.class);
    }
}

