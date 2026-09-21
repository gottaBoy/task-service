/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappmenuitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d51ba6ec923e697e7177b2b383d603f8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPMENUITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPMENUITEMNAME", format="")})})
public class PSAppMenuItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppMenuItemDefaultACModel() {
        this.initAnnotation(PSAppMenuItemDefaultACModel.class);
    }
}

