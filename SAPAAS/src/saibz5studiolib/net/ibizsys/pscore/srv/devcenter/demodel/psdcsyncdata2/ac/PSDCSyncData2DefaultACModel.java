/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsyncdata2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7b20696be0c942ef07809f6dc0e74873", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSYNCDATA2ID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSYNCDATA2NAME", format="")})})
public class PSDCSyncData2DefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCSyncData2DefaultACModel() {
        this.initAnnotation(PSDCSyncData2DefaultACModel.class);
    }
}

