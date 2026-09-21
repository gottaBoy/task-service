/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pstaskserverlog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6d0985e0a5370b909ec095eb48ae0037", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSTASKSERVERLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSTASKSERVERLOGNAME", format="")})})
public class PSTaskServerLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSTaskServerLogDefaultACModel() {
        this.initAnnotation(PSTaskServerLogDefaultACModel.class);
    }
}

