/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetbitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="35d6211dd58885b4b8908feceb4cbb31", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDETBITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDETBITEMNAME", format="")})})
public class PSDETBItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDETBItemDefaultACModel() {
        this.initAnnotation(PSDETBItemDefaultACModel.class);
    }
}

