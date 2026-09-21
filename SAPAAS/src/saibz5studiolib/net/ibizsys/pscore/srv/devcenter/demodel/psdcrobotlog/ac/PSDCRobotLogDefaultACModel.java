/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcrobotlog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fb88a0a1dc794fd9990ed9a6ab094351", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCROBOTLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCROBOTLOGNAME", format="")})})
public class PSDCRobotLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCRobotLogDefaultACModel() {
        this.initAnnotation(PSDCRobotLogDefaultACModel.class);
    }
}

