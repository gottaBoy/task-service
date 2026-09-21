/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pstaskserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3166706f62c6c5b08418c13bb7f4d748", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSTASKSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSTASKSERVERNAME", format="")})})
public class PSTaskServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSTaskServerDefaultACModel() {
        this.initAnnotation(PSTaskServerDefaultACModel.class);
    }
}

