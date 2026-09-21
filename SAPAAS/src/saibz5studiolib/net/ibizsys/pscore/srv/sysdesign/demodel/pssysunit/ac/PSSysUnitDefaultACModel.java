/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysunit.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2fbf32d50f505600b325565866ca0cfe", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUNITID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUNITNAME", format="")})})
public class PSSysUnitDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUnitDefaultACModel() {
        this.initAnnotation(PSSysUnitDefaultACModel.class);
    }
}

