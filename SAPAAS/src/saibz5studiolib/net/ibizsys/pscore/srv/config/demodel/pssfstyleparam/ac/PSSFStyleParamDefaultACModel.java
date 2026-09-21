/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstyleparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8bc054e3aaf8ac0bbee1f69e7812c6e0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFSTYLEPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFSTYLEPARAMNAME", format="")})})
public class PSSFStyleParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFStyleParamDefaultACModel() {
        this.initAnnotation(PSSFStyleParamDefaultACModel.class);
    }
}

