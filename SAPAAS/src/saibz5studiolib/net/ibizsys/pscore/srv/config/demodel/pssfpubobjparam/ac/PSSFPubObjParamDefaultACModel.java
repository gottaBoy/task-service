/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfpubobjparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9c413ad0a76c475428379bf357bfd03a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFPUBOBJPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFPUBOBJPARAMNAME", format="")})})
public class PSSFPubObjParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFPubObjParamDefaultACModel() {
        this.initAnnotation(PSSFPubObjParamDefaultACModel.class);
    }
}

