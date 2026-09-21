/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevslnsysbaklink.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b8e4360174b40a39b34fdc3963909868", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNSYSBAKLINKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNSYSBAKLINKNAME", format="")})})
public class PSDevSlnSysBakLinkDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnSysBakLinkDefaultACModel() {
        this.initAnnotation(PSDevSlnSysBakLinkDefaultACModel.class);
    }
}

