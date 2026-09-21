/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pssyswfsetting.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1766c06cb05d7710b405c52cca69e800", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSWFSETTINGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSWFSETTINGNAME", format="")})})
public class PSSysWFSettingDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysWFSettingDefaultACModel() {
        this.initAnnotation(PSSysWFSettingDefaultACModel.class);
    }
}

