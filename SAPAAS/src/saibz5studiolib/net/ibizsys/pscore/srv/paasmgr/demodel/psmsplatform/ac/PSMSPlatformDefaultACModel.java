/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psmsplatform.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3627c246a4bac01a851e8df0cbda5e30", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMSPLATFORMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMSPLATFORMNAME", format="")})})
public class PSMSPlatformDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMSPlatformDefaultACModel() {
        this.initAnnotation(PSMSPlatformDefaultACModel.class);
    }
}

