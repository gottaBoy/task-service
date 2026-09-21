/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psrobottype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2f72e5ef9f26e0ed81323329ce543f42", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSROBOTTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSROBOTTYPENAME", format="")})})
public class PSRobotTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRobotTypeDefaultACModel() {
        this.initAnnotation(PSRobotTypeDefaultACModel.class);
    }
}

