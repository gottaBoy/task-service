/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdashboardlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fbe60e4b09c2f51d7d1182a786cfa24f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDASHBOARDLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDASHBOARDLOGICNAME", format="")})})
public class PSSysDashboardLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDashboardLogicDefaultACModel() {
        this.initAnnotation(PSSysDashboardLogicDefaultACModel.class);
    }
}

