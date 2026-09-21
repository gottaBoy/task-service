/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psmsplatformfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0e1679d2d72011a9236fbe6959ef4bf3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMSPLATFORMFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMSPLATFORMFUNCNAME", format="")})})
public class PSMSPlatformFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMSPlatformFuncDefaultACModel() {
        this.initAnnotation(PSMSPlatformFuncDefaultACModel.class);
    }
}

