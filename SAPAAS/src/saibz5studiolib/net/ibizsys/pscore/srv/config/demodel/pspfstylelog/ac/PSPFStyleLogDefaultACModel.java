/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfstylelog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="085c318437efc30fbe26473b0956dba6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFSTYLELOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFSTYLELOGNAME", format="")})})
public class PSPFStyleLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFStyleLogDefaultACModel() {
        this.initAnnotation(PSPFStyleLogDefaultACModel.class);
    }
}

