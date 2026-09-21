/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefgroupdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ec0baf36a92b8e2e2c445f40558b5503", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFGROUPDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFGROUPDETAILNAME", format="")})})
public class PSDEFGroupDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFGroupDetailDefaultACModel() {
        this.initAnnotation(PSDEFGroupDetailDefaultACModel.class);
    }
}

