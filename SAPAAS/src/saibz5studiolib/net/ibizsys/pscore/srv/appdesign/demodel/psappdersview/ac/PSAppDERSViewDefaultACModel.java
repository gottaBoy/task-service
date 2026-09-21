/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappdersview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="855148af854b631f33e5bf2d85ebdbb7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPDERSVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPDERSVIEWNAME", format="")})})
public class PSAppDERSViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppDERSViewDefaultACModel() {
        this.initAnnotation(PSAppDERSViewDefaultACModel.class);
    }
}

