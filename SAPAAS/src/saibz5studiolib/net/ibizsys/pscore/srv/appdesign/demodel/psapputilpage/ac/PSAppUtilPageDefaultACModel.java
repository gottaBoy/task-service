/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapputilpage.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="782f7eb8dd808766de73c1cd1633e5c8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPUTILPAGEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPUTILPAGENAME", format="")})})
public class PSAppUtilPageDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppUtilPageDefaultACModel() {
        this.initAnnotation(PSAppUtilPageDefaultACModel.class);
    }
}

