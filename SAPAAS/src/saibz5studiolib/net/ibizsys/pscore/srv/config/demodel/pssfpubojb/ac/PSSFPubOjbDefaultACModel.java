/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfpubojb.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3cc12c0fca33927d19da70b1bf5ae606", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFPUBOBJID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFPUBOBJNAME", format="")})})
public class PSSFPubOjbDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFPubOjbDefaultACModel() {
        this.initAnnotation(PSSFPubOjbDefaultACModel.class);
    }
}

