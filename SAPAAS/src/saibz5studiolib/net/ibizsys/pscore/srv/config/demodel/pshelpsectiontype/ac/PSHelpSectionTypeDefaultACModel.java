/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pshelpsectiontype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="20652ed524279ba41d328aa0ee0ecb3b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPSECTIONTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPSECTIONTYPENAME", format="")})})
public class PSHelpSectionTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpSectionTypeDefaultACModel() {
        this.initAnnotation(PSHelpSectionTypeDefaultACModel.class);
    }
}

