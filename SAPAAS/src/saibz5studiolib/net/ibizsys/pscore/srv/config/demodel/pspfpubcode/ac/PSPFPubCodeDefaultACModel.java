/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpubcode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d177c6db75b5c1854452d4c7c029f9a6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPUBCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPUBCODENAME", format="")})})
public class PSPFPubCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPubCodeDefaultACModel() {
        this.initAnnotation(PSPFPubCodeDefaultACModel.class);
    }
}

