/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevsysdiffitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0a269ba05dab8d05117955868b1384a2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSYSDIFFITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSYSDIFFITEMNAME", format="")})})
public class PSDevSysDiffItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSysDiffItemDefaultACModel() {
        this.initAnnotation(PSDevSysDiffItemDefaultACModel.class);
    }
}

