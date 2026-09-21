/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnrecent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3ef65d3fd56820e508eb4711e4e234d9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNRECENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNRECENTNAME", format="")})})
public class PSDevSlnRecentDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnRecentDefaultACModel() {
        this.initAnnotation(PSDevSlnRecentDefaultACModel.class);
    }
}

