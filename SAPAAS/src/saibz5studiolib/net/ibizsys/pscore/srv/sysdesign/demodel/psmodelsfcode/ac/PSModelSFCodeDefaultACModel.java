/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelsfcode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="015c2fd16e5e84c2126c2c6878137d20", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELSFCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELSFCODENAME", format="")})})
public class PSModelSFCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelSFCodeDefaultACModel() {
        this.initAnnotation(PSModelSFCodeDefaultACModel.class);
    }
}

