/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a3c8619f2aeba65f6f5a605da6389bc3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMSPLATFORMFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMSPLATFORMFUNCNAME", format="")})})
public class PSDCMSPlatformFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCMSPlatformFuncDefaultACModel() {
        this.initAnnotation(PSDCMSPlatformFuncDefaultACModel.class);
    }
}

