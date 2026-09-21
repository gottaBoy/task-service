/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapputilview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="aa1df850a31555d1119dcb26f390e730", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPUTILVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPUTILVIEWNAME", format="")})})
public class PSAppUtilViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppUtilViewDefaultACModel() {
        this.initAnnotation(PSAppUtilViewDefaultACModel.class);
    }
}

