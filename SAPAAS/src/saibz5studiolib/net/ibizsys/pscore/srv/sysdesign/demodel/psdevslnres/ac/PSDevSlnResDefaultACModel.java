/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnres.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f3df935761e12f6d7d5b5b92fe8ed7b2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNRESID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNRESNAME", format="")})})
public class PSDevSlnResDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnResDefaultACModel() {
        this.initAnnotation(PSDevSlnResDefaultACModel.class);
    }
}

