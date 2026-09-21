/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsys.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8a63393edec4e576e370bef422d59ebc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSYSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSYSNAME", format="")})})
public class PSDepSysDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSysDefaultACModel() {
        this.initAnnotation(PSDepSysDefaultACModel.class);
    }
}

