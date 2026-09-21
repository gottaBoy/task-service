/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcrobot.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="00bbf68011ccbb7d4b1cafe46625b3d0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCROBOTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCROBOTNAME", format="")})})
public class PSDCRobotDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCRobotDefaultACModel() {
        this.initAnnotation(PSDCRobotDefaultACModel.class);
    }
}

