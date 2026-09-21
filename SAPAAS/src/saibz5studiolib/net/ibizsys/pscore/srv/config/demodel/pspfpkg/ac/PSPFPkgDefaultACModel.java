/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpkg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1e3eefcc7e8a780bf6915fe2927c628e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPKGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPKGNAME", format="")})})
public class PSPFPkgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPkgDefaultACModel() {
        this.initAnnotation(PSPFPkgDefaultACModel.class);
    }
}

