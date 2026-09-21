/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpubobjparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9ffa0cb1bc2ca78902b75dcf72cb2131", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPUBOBJPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPUBOBJPARAMNAME", format="")})})
public class PSPFPubObjParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPubObjParamDefaultACModel() {
        this.initAnnotation(PSPFPubObjParamDefaultACModel.class);
    }
}

