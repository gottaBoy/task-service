/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmsgaccount.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="77afdefb92b3ab246da3cc3bb22c4f6b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMSGACCOUNTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMSGACCOUNTNAME", format="")})})
public class PSDCMsgAccountDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCMsgAccountDefaultACModel() {
        this.initAnnotation(PSDCMsgAccountDefaultACModel.class);
    }
}

