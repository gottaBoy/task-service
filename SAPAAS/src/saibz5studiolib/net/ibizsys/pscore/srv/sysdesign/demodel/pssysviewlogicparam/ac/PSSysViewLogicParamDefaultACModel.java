/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysviewlogicparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3a5dc777f755e76bfc7bef9be8f4c450", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSVIEWLOGICPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSVIEWLOGICPARAMNAME", format="")})})
public class PSSysViewLogicParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysViewLogicParamDefaultACModel() {
        this.initAnnotation(PSSysViewLogicParamDefaultACModel.class);
    }
}

