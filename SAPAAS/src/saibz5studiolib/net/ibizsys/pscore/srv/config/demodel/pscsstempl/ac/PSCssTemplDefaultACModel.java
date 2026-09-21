/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscsstempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="287929663eb9c3701c9e9523f9087682", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCSSTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCSSTEMPLNAME", format="")})})
public class PSCssTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCssTemplDefaultACModel() {
        this.initAnnotation(PSCssTemplDefaultACModel.class);
    }
}

