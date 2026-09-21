/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pscodepreviewaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="af320362d5bb1945b4bc4be1df30a7b3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCODEPREVIEWACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCODEPREVIEWACTIONNAME", format="")})})
public class PSCodePreviewActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCodePreviewActionDefaultACModel() {
        this.initAnnotation(PSCodePreviewActionDefaultACModel.class);
    }
}

