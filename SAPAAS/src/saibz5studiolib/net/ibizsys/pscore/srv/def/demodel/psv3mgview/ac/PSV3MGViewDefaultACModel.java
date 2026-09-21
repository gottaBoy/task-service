/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psv3mgview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3371f48981b4442303404f6adf3679dc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSV3MGVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSV3MGVIEWNAME", format="")})})
public class PSV3MGViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSV3MGViewDefaultACModel() {
        this.initAnnotation(PSV3MGViewDefaultACModel.class);
    }
}

