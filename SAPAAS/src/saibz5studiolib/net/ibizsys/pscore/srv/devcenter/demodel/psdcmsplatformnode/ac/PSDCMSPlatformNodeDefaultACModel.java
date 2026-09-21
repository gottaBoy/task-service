/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1a72fe085dcd86a1ff94801c812a20be", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMSPLATFORMNODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMSPLATFORMNODENAME", format="")})})
public class PSDCMSPlatformNodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCMSPlatformNodeDefaultACModel() {
        this.initAnnotation(PSDCMSPlatformNodeDefaultACModel.class);
    }
}

