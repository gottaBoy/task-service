/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pspfpreviewaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="79c3600eaec6a3f8485f4bd8f2539ae5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPREVIEWACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPREVIEWACTIONNAME", format="")})})
public class PSPFPreviewActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPreviewActionDefaultACModel() {
        this.initAnnotation(PSPFPreviewActionDefaultACModel.class);
    }
}

