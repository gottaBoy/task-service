/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelapi.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8dc086fd65f5f2e63b7a3047a5df21ea", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELAPIID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELAPINAME", format="")})})
public class PSModelAPIDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelAPIDefaultACModel() {
        this.initAnnotation(PSModelAPIDefaultACModel.class);
    }
}

