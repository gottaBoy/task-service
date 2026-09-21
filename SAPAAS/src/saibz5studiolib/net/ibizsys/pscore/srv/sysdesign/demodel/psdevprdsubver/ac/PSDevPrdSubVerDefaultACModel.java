/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdsubver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0a84ce8bb67849a767b9b93f93fb64cc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVPRDSUBVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVPRDSUBVERNAME", format="")})})
public class PSDevPrdSubVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevPrdSubVerDefaultACModel() {
        this.initAnnotation(PSDevPrdSubVerDefaultACModel.class);
    }
}

