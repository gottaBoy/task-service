/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewengine.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2ea4acddfbb7e950ba3f96d4d75b7e0b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVIEWENGINEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVIEWENGINENAME", format="")})})
public class PSDEViewEngineDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEViewEngineDefaultACModel() {
        this.initAnnotation(PSDEViewEngineDefaultACModel.class);
    }
}

