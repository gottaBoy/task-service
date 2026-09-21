/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynaworkflow.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="08e7dd4329758a1e07d9fdbc1862c4f5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNAWORKFLOWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNAWORKFLOWNAME", format="")})})
public class PSDynaWorkflowDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaWorkflowDefaultACModel() {
        this.initAnnotation(PSDynaWorkflowDefaultACModel.class);
    }
}

