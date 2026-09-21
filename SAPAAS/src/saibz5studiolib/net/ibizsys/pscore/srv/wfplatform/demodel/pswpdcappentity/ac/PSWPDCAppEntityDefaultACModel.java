/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpdcappentity.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="89da2930486f10b4cec4579ed3eb620a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWPDCAPPENTITYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWPDCAPPENTITYNAME", format="")})})
public class PSWPDCAppEntityDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWPDCAppEntityDefaultACModel() {
        this.initAnnotation(PSWPDCAppEntityDefaultACModel.class);
    }
}

