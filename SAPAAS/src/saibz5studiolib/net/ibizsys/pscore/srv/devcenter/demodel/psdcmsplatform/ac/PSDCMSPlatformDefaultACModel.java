/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatform.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5148aae0e15f80cd79e8f5ad1b16bdbb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMSPLATFORMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMSPLATFORMNAME", format="")})})
public class PSDCMSPlatformDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCMSPlatformDefaultACModel() {
        this.initAnnotation(PSDCMSPlatformDefaultACModel.class);
    }
}

