/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="SUBSYS", id="980E52B1-2156-4283-A785-33B146BE33B4", dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBSYSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBSYSNAME", format="")})})
public class PSSysRefSubSysACModel
extends DEACModelBase {
    public static final String NAME = "SUBSYS";

    public PSSysRefSubSysACModel() {
        this.initAnnotation(PSSysRefSubSysACModel.class);
    }
}

