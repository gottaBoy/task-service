/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psbdserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="66273213ad05aae7347ac0b662a7d93d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSBDSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSBDSERVERNAME", format="")})})
public class PSBDServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSBDServerDefaultACModel() {
        this.initAnnotation(PSBDServerDefaultACModel.class);
    }
}

