/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevuserrecent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="62d958c5be14a90e453a596c10627313", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVUSERRECENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVUSERRECENTNAME", format="")})})
public class PSDevUserRecentDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevUserRecentDefaultACModel() {
        this.initAnnotation(PSDevUserRecentDefaultACModel.class);
    }
}

