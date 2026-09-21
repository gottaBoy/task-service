/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeacmodeitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="154f28d178438ee5c916c381f209bbfa", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEACMODEITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEACMODEITEMNAME", format="")})})
public class PSDEACModeItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEACModeItemDefaultACModel() {
        this.initAnnotation(PSDEACModeItemDefaultACModel.class);
    }
}

