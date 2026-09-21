/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsyslic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="09b0111498ca70e15ea75545ac2bf0e9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSYSLICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSYSLICNAME", format="")})})
public class PSDCSysLicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCSysLicDefaultACModel() {
        this.initAnnotation(PSDCSysLicDefaultACModel.class);
    }
}

