/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcreshourslog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b9787ad05c0caac0447778567f19b7c1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCRESHOURSLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCRESHOURSLOGNAME", format="")})})
public class PSDCResHoursLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCResHoursLogDefaultACModel() {
        this.initAnnotation(PSDCResHoursLogDefaultACModel.class);
    }
}

