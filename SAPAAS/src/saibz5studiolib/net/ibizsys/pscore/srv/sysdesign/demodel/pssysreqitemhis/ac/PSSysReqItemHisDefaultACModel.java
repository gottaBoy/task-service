/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysreqitemhis.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ad8153498a5287ada638c07944922451", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSREQITEMHISID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSREQITEMHISNAME", format="")})})
public class PSSysReqItemHisDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysReqItemHisDefaultACModel() {
        this.initAnnotation(PSSysReqItemHisDefaultACModel.class);
    }
}

