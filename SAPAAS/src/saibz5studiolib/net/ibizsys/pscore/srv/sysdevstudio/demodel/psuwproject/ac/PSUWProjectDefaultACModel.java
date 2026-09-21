/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwproject.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fbf19d0638212bcc2ae8ca4b9bc0105f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWPROJECTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWPROJECTNAME", format="")})})
public class PSUWProjectDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWProjectDefaultACModel() {
        this.initAnnotation(PSUWProjectDefaultACModel.class);
    }
}

