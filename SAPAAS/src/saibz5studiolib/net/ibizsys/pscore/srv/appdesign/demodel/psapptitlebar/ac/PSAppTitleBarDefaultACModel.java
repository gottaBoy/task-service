/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapptitlebar.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="699d327ade550c9aea46fce6b90ea65b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPTITLEBARID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPTITLEBARNAME", format="")})})
public class PSAppTitleBarDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppTitleBarDefaultACModel() {
        this.initAnnotation(PSAppTitleBarDefaultACModel.class);
    }
}

