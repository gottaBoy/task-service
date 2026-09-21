/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psproduct.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d3cbd8107f3df079b78277988af85151", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPRODUCTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPRODUCTNAME", format="")})})
public class PSProductDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSProductDefaultACModel() {
        this.initAnnotation(PSProductDefaultACModel.class);
    }
}

