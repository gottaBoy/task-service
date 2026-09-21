/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfprocess.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8187422fc9b94fc127d18d949dd0a57e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFPROCESSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFPROCESSNAME", format="")})})
public class PSWFProcessDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFProcessDefaultACModel() {
        this.initAnnotation(PSWFProcessDefaultACModel.class);
    }
}

