/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdcorgsecusertype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="54c5ba519fa55537aa41a6136c6e0ba2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCORGSECUSERTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCORGSECUSERTYPENAME", format="")})})
public class PSDCOrgSecUserTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCOrgSecUserTypeDefaultACModel() {
        this.initAnnotation(PSDCOrgSecUserTypeDefaultACModel.class);
    }
}

