/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynaapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="337bdd8d1e9397bb59e694a4145fa6bf", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNAAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNAAPPNAME", format="")})})
public class PSDynaAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaAppDefaultACModel() {
        this.initAnnotation(PSDynaAppDefaultACModel.class);
    }
}

