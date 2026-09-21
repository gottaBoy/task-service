/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfprocparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6a0c1fd6273287e14a955cc08ceef389", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFPROCPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFPROCPARAMNAME", format="")})})
public class PSWFProcParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFProcParamDefaultACModel() {
        this.initAnnotation(PSWFProcParamDefaultACModel.class);
    }
}

