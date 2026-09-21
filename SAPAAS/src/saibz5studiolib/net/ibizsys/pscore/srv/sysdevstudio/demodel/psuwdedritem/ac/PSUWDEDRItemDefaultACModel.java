/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwdedritem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b5afd90a3237b9e75b1fef50bc67dc2c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWDEDRITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWDEDRITEMNAME", format="")})})
public class PSUWDEDRItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWDEDRItemDefaultACModel() {
        this.initAnnotation(PSUWDEDRItemDefaultACModel.class);
    }
}

