/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnrunlog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5bd29ada2bdcd9b385069df5dae896ef", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSLNRUNLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSLNRUNLOGNAME", format="")})})
public class PSDepSlnRunLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSlnRunLogDefaultACModel() {
        this.initAnnotation(PSDepSlnRunLogDefaultACModel.class);
    }
}

