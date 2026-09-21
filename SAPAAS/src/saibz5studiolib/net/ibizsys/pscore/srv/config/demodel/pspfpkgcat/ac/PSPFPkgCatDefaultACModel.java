/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpkgcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="001f01475571feeb5a7e7613ee0ff832", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPKGCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPKGCATNAME", format="")})})
public class PSPFPkgCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPkgCatDefaultACModel() {
        this.initAnnotation(PSPFPkgCatDefaultACModel.class);
    }
}

