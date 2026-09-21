/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapppdtview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4f210bae8c61d01735d11c2819deebcd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPPDTVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPPDTVIEWNAME", format="")})})
public class PSAppPDTViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppPDTViewDefaultACModel() {
        this.initAnnotation(PSAppPDTViewDefaultACModel.class);
    }
}

