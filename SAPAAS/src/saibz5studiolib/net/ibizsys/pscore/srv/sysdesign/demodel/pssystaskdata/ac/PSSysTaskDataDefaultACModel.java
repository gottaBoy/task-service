/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystaskdata.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="69580ec8164afabdaf692010d45cfae9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTASKDATAID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTASKDATANAME", format="")})})
public class PSSysTaskDataDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTaskDataDefaultACModel() {
        this.initAnnotation(PSSysTaskDataDefaultACModel.class);
    }
}

