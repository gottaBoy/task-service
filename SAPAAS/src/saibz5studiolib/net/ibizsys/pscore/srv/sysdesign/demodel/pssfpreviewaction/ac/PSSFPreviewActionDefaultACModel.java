/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssfpreviewaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="04ef13102fed555138c511e3be5b970e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFPREVIEWACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFPREVIEWACTIONNAME", format="")})})
public class PSSFPreviewActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFPreviewActionDefaultACModel() {
        this.initAnnotation(PSSFPreviewActionDefaultACModel.class);
    }
}

