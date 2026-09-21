/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.unisys.demodel.psusdcmoduleinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="641ab56ee21e81db4ce3108b88db43f5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUSDCMODULEINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUSDCMODULEINSTNAME", format="")})})
public class PSUSDCModuleInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUSDCModuleInstDefaultACModel() {
        this.initAnnotation(PSUSDCModuleInstDefaultACModel.class);
    }
}

