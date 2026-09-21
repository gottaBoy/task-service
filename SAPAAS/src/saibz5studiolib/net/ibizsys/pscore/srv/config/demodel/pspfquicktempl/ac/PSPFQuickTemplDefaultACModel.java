/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfquicktempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="82c205492bda2bcca8a9c6e123f1b1b7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFQUICKTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFQUICKTEMPLNAME", format="")})})
public class PSPFQuickTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFQuickTemplDefaultACModel() {
        this.initAnnotation(PSPFQuickTemplDefaultACModel.class);
    }
}

