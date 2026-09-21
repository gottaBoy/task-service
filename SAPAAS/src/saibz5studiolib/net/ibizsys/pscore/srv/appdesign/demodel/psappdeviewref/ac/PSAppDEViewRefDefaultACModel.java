/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappdeviewref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0798709314ed83cb9571af14653a309a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPDEVIEWREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPDEVIEWREFNAME", format="")})})
public class PSAppDEViewRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppDEViewRefDefaultACModel() {
        this.initAnnotation(PSAppDEViewRefDefaultACModel.class);
    }
}

