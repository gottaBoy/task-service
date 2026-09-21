/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psmsplatformnode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f90a406cb30da8b9ce31bd2a3e1ceefe", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMSPLATFORMNODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMSPLATFORMNODENAME", format="")})})
public class PSMSPlatformNodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMSPlatformNodeDefaultACModel() {
        this.initAnnotation(PSMSPlatformNodeDefaultACModel.class);
    }
}

