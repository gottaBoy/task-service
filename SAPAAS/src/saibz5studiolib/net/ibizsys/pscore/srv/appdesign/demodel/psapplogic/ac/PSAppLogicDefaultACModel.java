/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapplogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b671c0986fd9a4e640fdf439b791e5b6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPLOGICNAME", format="")})})
public class PSAppLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppLogicDefaultACModel() {
        this.initAnnotation(PSAppLogicDefaultACModel.class);
    }
}

