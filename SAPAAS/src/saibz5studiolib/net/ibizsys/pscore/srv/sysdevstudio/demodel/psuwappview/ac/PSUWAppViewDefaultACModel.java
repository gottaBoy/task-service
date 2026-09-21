/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwappview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d748c048f3536a6372d715b385820bb9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWAPPVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWAPPVIEWNAME", format="")})})
public class PSUWAppViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWAppViewDefaultACModel() {
        this.initAnnotation(PSUWAppViewDefaultACModel.class);
    }
}

