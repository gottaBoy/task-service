/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psformdetailtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="15e40a5d342c8aa864ee4233383eae7f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSFORMDETAILTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSFORMDETAILTYPENAME", format="")})})
public class PSFormDetailTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSFormDetailTypeDefaultACModel() {
        this.initAnnotation(PSFormDetailTypeDefaultACModel.class);
    }
}

