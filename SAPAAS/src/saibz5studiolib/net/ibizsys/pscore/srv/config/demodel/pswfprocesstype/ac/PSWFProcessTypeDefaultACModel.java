/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pswfprocesstype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b3b264c13ed2d4caf7b82123c652ae34", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFPROCESSTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFPROCESSTYPENAME", format="")})})
public class PSWFProcessTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFProcessTypeDefaultACModel() {
        this.initAnnotation(PSWFProcessTypeDefaultACModel.class);
    }
}

