/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcpfpitempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d6f1862bc3c38b22f0868465bee4f08a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCPFPITEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCPFPITEMPLNAME", format="")})})
public class PSDCPFPITemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCPFPITemplDefaultACModel() {
        this.initAnnotation(PSDCPFPITemplDefaultACModel.class);
    }
}

