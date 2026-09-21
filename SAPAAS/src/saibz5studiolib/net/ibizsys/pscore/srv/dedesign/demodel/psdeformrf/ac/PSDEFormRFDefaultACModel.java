/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeformrf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d5949861cd1af461326b94d7432f816c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFORMRFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFORMRFNAME", format="")})})
public class PSDEFormRFDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFormRFDefaultACModel() {
        this.initAnnotation(PSDEFormRFDefaultACModel.class);
    }
}

