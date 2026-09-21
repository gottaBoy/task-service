/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psmobapppacksession.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="997699bc04c7965a9e36833efd7a3c4d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMOBAPPPACKSESSIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMOBAPPPACKSESSIONNAME", format="")})})
public class PSMobAppPackSessionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMobAppPackSessionDefaultACModel() {
        this.initAnnotation(PSMobAppPackSessionDefaultACModel.class);
    }
}

