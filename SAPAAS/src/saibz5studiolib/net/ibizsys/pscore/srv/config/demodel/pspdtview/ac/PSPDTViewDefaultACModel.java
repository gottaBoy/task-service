/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspdtview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="41e0ba2e2de5e089354b16bd7cd60dd0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPDTVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPDTVIEWNAME", format="")})})
public class PSPDTViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPDTViewDefaultACModel() {
        this.initAnnotation(PSPDTViewDefaultACModel.class);
    }
}

