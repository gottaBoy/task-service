/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynaappview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b973ac2172e9703cab5ea2167af1d107", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNAAPPVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNAAPPVIEWNAME", format="")})})
public class PSDynaAppViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaAppViewDefaultACModel() {
        this.initAnnotation(PSDynaAppViewDefaultACModel.class);
    }
}

