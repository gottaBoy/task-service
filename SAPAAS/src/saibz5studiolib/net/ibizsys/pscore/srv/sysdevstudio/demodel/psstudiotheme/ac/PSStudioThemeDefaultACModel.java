/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psstudiotheme.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="df8a49dd4b30b8dedce78ed400d29f42", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSTUDIOTHEMEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSTUDIOTHEMENAME", format="")})})
public class PSStudioThemeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSStudioThemeDefaultACModel() {
        this.initAnnotation(PSStudioThemeDefaultACModel.class);
    }
}

