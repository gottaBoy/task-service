/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsysas.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2102b6ddb683e8520d2d6624e98ffad3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSLNSYSASID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSLNSYSASNAME", format="")})})
public class PSDepSlnSysASDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSlnSysASDefaultACModel() {
        this.initAnnotation(PSDepSlnSysASDefaultACModel.class);
    }
}

