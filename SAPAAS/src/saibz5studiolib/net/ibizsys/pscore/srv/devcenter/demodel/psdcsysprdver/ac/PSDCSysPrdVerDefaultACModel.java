/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsysprdver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="711db5ee1bf01d66466839dab1512dbb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSYSPRDVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSYSPRDVERNAME", format="")})})
public class PSDCSysPrdVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCSysPrdVerDefaultACModel() {
        this.initAnnotation(PSDCSysPrdVerDefaultACModel.class);
    }
}

