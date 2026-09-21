/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfctdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7c198dae5dad3bcff164a014141a6010", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFCTDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFCTDETAILNAME", format="")})})
public class PSPFCTDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFCTDetailDefaultACModel() {
        this.initAnnotation(PSPFCTDetailDefaultACModel.class);
    }
}

