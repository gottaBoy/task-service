/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcwfengineinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="80315eb492bfb7bf7f6e365112fb7908", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCWFENGINEINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCWFENGINEINSTNAME", format="")})})
public class PSDCWFEngineInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCWFEngineInstDefaultACModel() {
        this.initAnnotation(PSDCWFEngineInstDefaultACModel.class);
    }
}

