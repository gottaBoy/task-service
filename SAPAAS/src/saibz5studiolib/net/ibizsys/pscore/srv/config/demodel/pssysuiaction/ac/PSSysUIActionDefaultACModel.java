/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysuiaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0128e9d91bf38785d5f1b7cf2cf41466", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUIACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUIACTIONNAME", format="")})})
public class PSSysUIActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUIActionDefaultACModel() {
        this.initAnnotation(PSSysUIActionDefaultACModel.class);
    }
}

