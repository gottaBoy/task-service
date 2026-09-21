/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcentersrv.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="aec94319fc243bbf697377fa96e2948a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVCENTERSRVID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVCENTERSRVNAME", format="")})})
public class PSDevCenterSrvDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevCenterSrvDefaultACModel() {
        this.initAnnotation(PSDevCenterSrvDefaultACModel.class);
    }
}

