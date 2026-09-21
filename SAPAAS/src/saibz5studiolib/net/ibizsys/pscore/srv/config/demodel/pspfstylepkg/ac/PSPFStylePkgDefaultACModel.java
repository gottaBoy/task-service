/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfstylepkg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="554286ff677e4d2d8dcd029a2343f9e2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFSTYLEPKGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFSTYLEPKGNAME", format="")})})
public class PSPFStylePkgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFStylePkgDefaultACModel() {
        this.initAnnotation(PSPFStylePkgDefaultACModel.class);
    }
}

