/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsysdynainst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c2eeb46d38637d96a1613d388e0e1e76", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSLNSYSDYNAINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSLNSYSDYNAINSTNAME", format="")})})
public class PSDepSlnSysDynaInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSlnSysDynaInstDefaultACModel() {
        this.initAnnotation(PSDepSlnSysDynaInstDefaultACModel.class);
    }
}

