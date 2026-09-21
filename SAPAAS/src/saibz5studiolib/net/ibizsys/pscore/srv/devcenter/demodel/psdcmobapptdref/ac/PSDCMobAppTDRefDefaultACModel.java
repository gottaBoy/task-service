/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmobapptdref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eddb7cf3afe305a32ea9a7a9fa944177", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMOBAPPTDREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMOBAPPTDREFNAME", format="")})})
public class PSDCMobAppTDRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCMobAppTDRefDefaultACModel() {
        this.initAnnotation(PSDCMobAppTDRefDefaultACModel.class);
    }
}

