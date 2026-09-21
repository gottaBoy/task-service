/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapppkg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="33feec3eaa8bbe4598a92ff77f20a9c8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPPKGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPPKGNAME", format="")})})
public class PSAppPkgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppPkgDefaultACModel() {
        this.initAnnotation(PSAppPkgDefaultACModel.class);
    }
}

