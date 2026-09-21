/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysmodelfunctempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="748c50879a85cb6235d81f2be275856e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMODELFUNCTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMODELFUNCTEMPLNAME", format="")})})
public class PSSysModelFuncTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysModelFuncTemplDefaultACModel() {
        this.initAnnotation(PSSysModelFuncTemplDefaultACModel.class);
    }
}

