/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmobapptestdevice.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c1c0ddee6bb08f43be6824f71c8454eb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMOBAPPTESTDEVICEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMOBAPPTESTDEVICENAME", format="")})})
public class PSDCMobAppTestDeviceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCMobAppTestDeviceDefaultACModel() {
        this.initAnnotation(PSDCMobAppTestDeviceDefaultACModel.class);
    }
}

