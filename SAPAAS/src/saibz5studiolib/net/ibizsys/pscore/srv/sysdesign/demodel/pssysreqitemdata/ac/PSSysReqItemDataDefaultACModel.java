/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysreqitemdata.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="714e1530e819a3cfc7af911d9aa8d506", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSREQITEMDATAID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSREQITEMDATANAME", format="")})})
public class PSSysReqItemDataDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysReqItemDataDefaultACModel() {
        this.initAnnotation(PSSysReqItemDataDefaultACModel.class);
    }
}

