/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pscoreprdcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8f5fd7cc46a33e359a43ce19be37246b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCOREPRDCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCOREPRDCATNAME", format="")})})
public class PSCorePrdCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCorePrdCatDefaultACModel() {
        this.initAnnotation(PSCorePrdCatDefaultACModel.class);
    }
}

