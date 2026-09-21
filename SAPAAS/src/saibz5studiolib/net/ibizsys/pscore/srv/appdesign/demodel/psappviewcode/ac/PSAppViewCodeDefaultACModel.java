/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappviewcode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7178c85181dbbd33ca5013c1c48354a5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPVIEWCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPVIEWCODENAME", format="")})})
public class PSAppViewCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppViewCodeDefaultACModel() {
        this.initAnnotation(PSAppViewCodeDefaultACModel.class);
    }
}

