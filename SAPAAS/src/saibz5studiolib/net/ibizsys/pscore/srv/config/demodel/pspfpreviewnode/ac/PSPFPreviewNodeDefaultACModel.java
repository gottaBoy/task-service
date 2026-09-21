/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpreviewnode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cad369dadb9824aad282f4c65401efd4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPREVIEWNODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPREVIEWNODENAME", format="")})})
public class PSPFPreviewNodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPreviewNodeDefaultACModel() {
        this.initAnnotation(PSPFPreviewNodeDefaultACModel.class);
    }
}

