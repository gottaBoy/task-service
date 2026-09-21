/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfstyle.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2276c87099e1b11b73b83501edbab9b8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFSTYLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFSTYLENAME", format="")})})
public class PSPFStyleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFStyleDefaultACModel() {
        this.initAnnotation(PSPFStyleDefaultACModel.class);
    }
}

