/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapplan.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3278041794b55e8cacf041cde63e48ee", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPLANID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPLANNAME", format="")})})
public class PSAppLanDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppLanDefaultACModel() {
        this.initAnnotation(PSAppLanDefaultACModel.class);
    }
}

