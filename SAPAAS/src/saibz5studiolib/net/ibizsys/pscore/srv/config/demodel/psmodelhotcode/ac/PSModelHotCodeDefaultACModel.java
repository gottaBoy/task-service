/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelhotcode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2372bc16fab0b6ac26fbab3de82da33d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELHOTCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELHOTCODENAME", format="")})})
public class PSModelHotCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelHotCodeDefaultACModel() {
        this.initAnnotation(PSModelHotCodeDefaultACModel.class);
    }
}

