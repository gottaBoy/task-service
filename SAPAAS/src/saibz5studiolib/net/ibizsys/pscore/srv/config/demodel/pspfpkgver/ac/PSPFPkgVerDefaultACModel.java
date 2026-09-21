/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpkgver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1e42876935dca48c12c714b390f42858", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPKGVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPKGVERNAME", format="")})})
public class PSPFPkgVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPkgVerDefaultACModel() {
        this.initAnnotation(PSPFPkgVerDefaultACModel.class);
    }
}

