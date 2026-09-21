/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssyspolicymodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0e6af35c10589f28db9343895d209f6c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSPOLICYMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSPOLICYMODELNAME", format="")})})
public class PSSysPolicyModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysPolicyModelDefaultACModel() {
        this.initAnnotation(PSSysPolicyModelDefaultACModel.class);
    }
}

