/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcreshours.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="535c40a64511ea8ae94f2d845104705e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCRESHOURSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCRESHOURSNAME", format="")})})
public class PSDCResHoursDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCResHoursDefaultACModel() {
        this.initAnnotation(PSDCResHoursDefaultACModel.class);
    }
}

