/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwcreatededef.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b497c4da23eadcd4371bd7dac03a1402", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWCREATEDEDEFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWCREATEDEDEFNAME", format="")})})
public class PSUWCreateDEDEFDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWCreateDEDEFDefaultACModel() {
        this.initAnnotation(PSUWCreateDEDEFDefaultACModel.class);
    }
}

