/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pswfengineinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="643e0349cc8b5ca3c237f822d53b3b71", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFENGINEINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFENGINEINSTNAME", format="")})})
public class PSWFEngineInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFEngineInstDefaultACModel() {
        this.initAnnotation(PSWFEngineInstDefaultACModel.class);
    }
}

