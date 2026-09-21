/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psmodelimport.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="818159f431aaac4ce6cf7f9df2174822", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELIMPORTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELIMPORTNAME", format="")})})
public class PSModelImportDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelImportDefaultACModel() {
        this.initAnnotation(PSModelImportDefaultACModel.class);
    }
}

