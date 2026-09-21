/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysmsgtarget.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eb363bda3b0b4ea5a656303fa7e069ca", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMSGTARGETID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMSGTARGETNAME", format="")})})
public class PSSysMsgTargetDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysMsgTargetDefaultACModel() {
        this.initAnnotation(PSSysMsgTargetDefaultACModel.class);
    }
}

