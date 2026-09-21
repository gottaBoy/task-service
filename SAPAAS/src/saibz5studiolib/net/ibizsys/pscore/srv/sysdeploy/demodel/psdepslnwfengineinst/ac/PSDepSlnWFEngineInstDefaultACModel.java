/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnwfengineinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a4729f65a3e2548ae9c78256ce79eb75", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSLNWFENGINEINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSLNWFENGINEINSTNAME", format="")})})
public class PSDepSlnWFEngineInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSlnWFEngineInstDefaultACModel() {
        this.initAnnotation(PSDepSlnWFEngineInstDefaultACModel.class);
    }
}

