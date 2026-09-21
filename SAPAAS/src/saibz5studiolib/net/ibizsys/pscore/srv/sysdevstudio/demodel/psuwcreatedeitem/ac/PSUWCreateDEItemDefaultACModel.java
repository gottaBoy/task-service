/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwcreatedeitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c86ca374c38b454c2d053a078465e685", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWCREATEDEITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWCREATEDEITEMNAME", format="")})})
public class PSUWCreateDEItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWCreateDEItemDefaultACModel() {
        this.initAnnotation(PSUWCreateDEItemDefaultACModel.class);
    }
}

