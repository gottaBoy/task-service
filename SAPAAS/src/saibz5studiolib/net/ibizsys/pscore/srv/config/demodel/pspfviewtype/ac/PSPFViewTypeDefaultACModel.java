/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfviewtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4d83f7640f76cf1bc2289b06128e5879", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFVIEWTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFVIEWTYPENAME", format="")})})
public class PSPFViewTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFViewTypeDefaultACModel() {
        this.initAnnotation(PSPFViewTypeDefaultACModel.class);
    }
}

