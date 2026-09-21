/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pscpvfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5ef1b4b31131c40be9d4a44bd0d9ebba", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCPVFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCPVFUNCNAME", format="")})})
public class PSCPVFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCPVFuncDefaultACModel() {
        this.initAnnotation(PSCPVFuncDefaultACModel.class);
    }
}

