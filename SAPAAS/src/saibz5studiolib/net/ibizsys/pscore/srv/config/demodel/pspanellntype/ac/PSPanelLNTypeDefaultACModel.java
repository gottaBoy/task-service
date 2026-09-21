/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspanellntype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1efa6187e5625f7e1a8cb34d8156d9d2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPANELLNTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPANELLNTYPENAME", format="")})})
public class PSPanelLNTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPanelLNTypeDefaultACModel() {
        this.initAnnotation(PSPanelLNTypeDefaultACModel.class);
    }
}

