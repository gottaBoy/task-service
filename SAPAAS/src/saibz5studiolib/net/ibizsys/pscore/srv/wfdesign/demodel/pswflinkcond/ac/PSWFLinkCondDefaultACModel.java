/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswflinkcond.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ada60d1006720390bf27b0e79d48b0b7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFLINKCONDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFLINKCONDNAME", format="")})})
public class PSWFLinkCondDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFLinkCondDefaultACModel() {
        this.initAnnotation(PSWFLinkCondDefaultACModel.class);
    }
}

