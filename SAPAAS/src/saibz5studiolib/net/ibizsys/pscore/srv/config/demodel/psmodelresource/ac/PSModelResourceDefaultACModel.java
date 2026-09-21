/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelresource.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="98222bfea551fe89bad7c2fe700150c3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELRESOURCEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELRESOURCENAME", format="")})})
public class PSModelResourceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelResourceDefaultACModel() {
        this.initAnnotation(PSModelResourceDefaultACModel.class);
    }
}

