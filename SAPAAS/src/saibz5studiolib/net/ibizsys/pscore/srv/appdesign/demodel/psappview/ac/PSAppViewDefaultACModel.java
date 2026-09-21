/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7fb7186bc74741fbe7ee72bd472c5aa3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPVIEWNAME", format="")}), @DataItem(name="logicname", dataitemparams={@DataItemParam(name="PSDEVIEWBASENAME", format="%1$s")})})
public class PSAppViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppViewDefaultACModel() {
        this.initAnnotation(PSAppViewDefaultACModel.class);
    }
}

