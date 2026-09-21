/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfapptempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="be136e9da318d106593914293f301bf9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFAPPTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFAPPTEMPLNAME", format="")})})
public class PSPFAppTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFAppTemplDefaultACModel() {
        this.initAnnotation(PSPFAppTemplDefaultACModel.class);
    }
}

