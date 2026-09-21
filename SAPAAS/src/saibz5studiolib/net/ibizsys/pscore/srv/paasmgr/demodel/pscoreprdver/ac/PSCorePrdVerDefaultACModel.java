/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pscoreprdver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="39c221367330a0bd63b5c3ef2ec9d540", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCOREPRDVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCOREPRDVERNAME", format="")})})
public class PSCorePrdVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCorePrdVerDefaultACModel() {
        this.initAnnotation(PSCorePrdVerDefaultACModel.class);
    }
}

