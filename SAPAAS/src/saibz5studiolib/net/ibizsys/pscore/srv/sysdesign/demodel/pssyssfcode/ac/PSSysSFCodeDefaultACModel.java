/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssfcode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6d25c0d8fc1e24a209402dcdc6ef6407", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSFCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSFCODENAME", format="")})})
public class PSSysSFCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSFCodeDefaultACModel() {
        this.initAnnotation(PSSysSFCodeDefaultACModel.class);
    }
}

