/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcrobotability.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f762c0e3a337f8d82157c443884d8362", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCROBOTABILITYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCROBOTABILITYNAME", format="")})})
public class PSDCRobotAbilityDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCRobotAbilityDefaultACModel() {
        this.initAnnotation(PSDCRobotAbilityDefaultACModel.class);
    }
}

