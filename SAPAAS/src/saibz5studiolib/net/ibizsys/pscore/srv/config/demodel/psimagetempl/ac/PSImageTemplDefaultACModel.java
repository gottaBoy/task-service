/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psimagetempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8a3309bbdc9a2fdf34d4c111493557f8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSIMAGETEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSIMAGETEMPLNAME", format="")})})
public class PSImageTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSImageTemplDefaultACModel() {
        this.initAnnotation(PSImageTemplDefaultACModel.class);
    }
}

