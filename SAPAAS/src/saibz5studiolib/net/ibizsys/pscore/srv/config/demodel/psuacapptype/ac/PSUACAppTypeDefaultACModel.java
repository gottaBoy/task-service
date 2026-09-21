/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psuacapptype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5351ae7782a2eda22331a5ab211569d0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUACAPPTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUACAPPTYPENAME", format="")})})
public class PSUACAppTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUACAppTypeDefaultACModel() {
        this.initAnnotation(PSUACAppTypeDefaultACModel.class);
    }
}

