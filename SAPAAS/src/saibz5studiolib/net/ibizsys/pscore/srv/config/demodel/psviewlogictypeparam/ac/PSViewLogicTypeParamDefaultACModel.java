/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewlogictypeparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5842ee31f4b84da2e24dbd8166f00925", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWLOGICTYPEPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWLOGICTYPEPARAMNAME", format="")})})
public class PSViewLogicTypeParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewLogicTypeParamDefaultACModel() {
        this.initAnnotation(PSViewLogicTypeParamDefaultACModel.class);
    }
}

