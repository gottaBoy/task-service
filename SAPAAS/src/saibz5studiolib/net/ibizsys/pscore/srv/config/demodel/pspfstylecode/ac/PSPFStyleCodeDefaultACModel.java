/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfstylecode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="da4aefabc95fdb62c7f992e93559aa64", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFSTYLECODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFSTYLECODENAME", format="")})})
public class PSPFStyleCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFStyleCodeDefaultACModel() {
        this.initAnnotation(PSPFStyleCodeDefaultACModel.class);
    }
}

