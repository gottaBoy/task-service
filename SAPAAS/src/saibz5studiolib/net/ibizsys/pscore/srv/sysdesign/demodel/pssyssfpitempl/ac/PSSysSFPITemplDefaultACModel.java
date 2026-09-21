/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssfpitempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="86d861aeeeb058676a65af9b990bfa8c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSFPITEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSFPITEMPLNAME", format="")})})
public class PSSysSFPITemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSFPITemplDefaultACModel() {
        this.initAnnotation(PSSysSFPITemplDefaultACModel.class);
    }
}

