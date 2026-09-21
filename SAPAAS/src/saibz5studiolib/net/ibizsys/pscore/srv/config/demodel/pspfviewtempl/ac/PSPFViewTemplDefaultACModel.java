/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfviewtempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3a1d9a34e1688f10f31a0632dbd1b039", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFVIEWTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFVIEWTEMPLNAME", format="")})})
public class PSPFViewTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFViewTemplDefaultACModel() {
        this.initAnnotation(PSPFViewTemplDefaultACModel.class);
    }
}

