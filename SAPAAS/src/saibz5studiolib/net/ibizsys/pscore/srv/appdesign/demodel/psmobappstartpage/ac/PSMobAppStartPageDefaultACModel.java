/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psmobappstartpage.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="745b56c4e9feafcdaa38faf071d4e69e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMOBAPPSTARTPAGEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMOBAPPSTARTPAGENAME", format="")})})
public class PSMobAppStartPageDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMobAppStartPageDefaultACModel() {
        this.initAnnotation(PSMobAppStartPageDefaultACModel.class);
    }
}

