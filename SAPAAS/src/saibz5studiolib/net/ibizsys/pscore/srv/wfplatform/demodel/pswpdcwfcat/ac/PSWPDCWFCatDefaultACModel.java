/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpdcwfcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6baf3d3653622d1cc7aa1c16969d7ee8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWPDCWFCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWPDCWFCATNAME", format="")})})
public class PSWPDCWFCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWPDCWFCatDefaultACModel() {
        this.initAnnotation(PSWPDCWFCatDefaultACModel.class);
    }
}

