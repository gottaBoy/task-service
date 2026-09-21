/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsysres.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ac49a9da492472c3d78d9771faf6858f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSYSRESID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSYSRESNAME", format="")})})
public class PSDCSysResDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCSysResDefaultACModel() {
        this.initAnnotation(PSDCSysResDefaultACModel.class);
    }
}

