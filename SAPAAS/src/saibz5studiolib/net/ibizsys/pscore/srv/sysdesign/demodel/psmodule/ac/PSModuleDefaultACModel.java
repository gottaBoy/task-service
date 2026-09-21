/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f61888bc642dfe40712fcb9103001143", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODULENAME", format="")})})
public class PSModuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModuleDefaultACModel() {
        this.initAnnotation(PSModuleDefaultACModel.class);
    }
}

