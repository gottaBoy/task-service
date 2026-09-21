/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsaassysver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ab06f851954050b950b3df5d362fb5b6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSAASSYSVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSAASSYSVERNAME", format="")})})
public class PSDepSaaSSysVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSaaSSysVerDefaultACModel() {
        this.initAnnotation(PSDepSaaSSysVerDefaultACModel.class);
    }
}

