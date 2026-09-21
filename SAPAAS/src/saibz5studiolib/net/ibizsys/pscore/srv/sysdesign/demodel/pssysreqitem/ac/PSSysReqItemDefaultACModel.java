/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysreqitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="82dc548dac8f08cbba682fbdd3fd786e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSREQITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSREQITEMNAME", format="")})})
public class PSSysReqItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysReqItemDefaultACModel() {
        this.initAnnotation(PSSysReqItemDefaultACModel.class);
    }
}

