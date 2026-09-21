/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdctasklog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a59e10652b208ef60e7bbc392888e5fd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCTASKLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCTASKLOGNAME", format="")})})
public class PSDCTaskLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCTaskLogDefaultACModel() {
        this.initAnnotation(PSDCTaskLogDefaultACModel.class);
    }
}

