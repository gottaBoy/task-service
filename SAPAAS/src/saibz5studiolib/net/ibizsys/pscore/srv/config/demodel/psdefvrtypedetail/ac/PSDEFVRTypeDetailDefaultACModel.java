/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdefvrtypedetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0a25cd6c8351cca9e4c0991ef0021b5c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFVRTYPEDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFVRTYPEDETAILNAME", format="")})})
public class PSDEFVRTypeDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFVRTypeDetailDefaultACModel() {
        this.initAnnotation(PSDEFVRTypeDetailDefaultACModel.class);
    }
}

