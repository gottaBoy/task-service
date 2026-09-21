/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvtcatdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d7bfeb538ae0d008a03e27e0ef036d45", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVTCATDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVTCATDETAILNAME", format="")})})
public class PSVTCatDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSVTCatDetailDefaultACModel() {
        this.initAnnotation(PSVTCatDetailDefaultACModel.class);
    }
}

