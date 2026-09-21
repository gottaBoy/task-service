/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwdelogicnode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4840d72eda73bbf1c123e51d4715bf23", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELOGICNODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELOGICNODENAME", format="")})})
public class PSUWDELogicNodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWDELogicNodeDefaultACModel() {
        this.initAnnotation(PSUWDELogicNodeDefaultACModel.class);
    }
}

