/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcbulletin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a09819b2f9b338e7e9ebb625c538cc2e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCBULLETINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCBULLETINNAME", format="")})})
public class PSDCBulletinDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCBulletinDefaultACModel() {
        this.initAnnotation(PSDCBulletinDefaultACModel.class);
    }
}

