/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspilogictype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="69aab710bcfb9e8e7af5c1398c749b01", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPILOGICTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPILOGICTYPENAME", format="")})})
public class PSPILogicTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPILogicTypeDefaultACModel() {
        this.initAnnotation(PSPILogicTypeDefaultACModel.class);
    }
}

