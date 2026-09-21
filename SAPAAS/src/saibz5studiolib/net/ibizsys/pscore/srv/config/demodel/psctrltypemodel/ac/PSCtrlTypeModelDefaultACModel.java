/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psctrltypemodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e7b445c8eabb4b2d4d3192944098dc42", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLTYPEMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLTYPEMODELNAME", format="")})})
public class PSCtrlTypeModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlTypeModelDefaultACModel() {
        this.initAnnotation(PSCtrlTypeModelDefaultACModel.class);
    }
}

