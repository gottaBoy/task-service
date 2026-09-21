/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappdynadeview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="efe6728764b00fc1cf403a4d44e72f1f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPDYNADEVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPDYNADEVIEWNAME", format="")})})
public class PSAppDynaDEViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppDynaDEViewDefaultACModel() {
        this.initAnnotation(PSAppDynaDEViewDefaultACModel.class);
    }
}

