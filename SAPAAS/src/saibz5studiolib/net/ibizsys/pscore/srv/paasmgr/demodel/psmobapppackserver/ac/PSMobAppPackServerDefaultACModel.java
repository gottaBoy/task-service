/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psmobapppackserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5fdd3eee4edff653fa25bdca2dc5828c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMOBAPPPACKSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMOBAPPPACKSERVERNAME", format="")})})
public class PSMobAppPackServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMobAppPackServerDefaultACModel() {
        this.initAnnotation(PSMobAppPackServerDefaultACModel.class);
    }
}

