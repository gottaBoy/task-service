/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pslanguageitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="130fd63d613975420cbc948df5921ad5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSLANGUAGEITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSLANGUAGEITEMNAME", format="")})})
public class PSLanguageItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSLanguageItemDefaultACModel() {
        this.initAnnotation(PSLanguageItemDefaultACModel.class);
    }
}

