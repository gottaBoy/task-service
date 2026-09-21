/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedataimp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d3bbbb7ded915efd636841f296bc41ee", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDATAIMPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDATAIMPNAME", format="")})})
public class PSDEDataImpDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDataImpDefaultACModel() {
        this.initAnnotation(PSDEDataImpDefaultACModel.class);
    }
}

