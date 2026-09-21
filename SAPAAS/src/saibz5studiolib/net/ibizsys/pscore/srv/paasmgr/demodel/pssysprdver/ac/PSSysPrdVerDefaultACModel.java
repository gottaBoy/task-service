/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pssysprdver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="651a8bc050e328a6c05f298bd0c192ed", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSPRDVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSPRDVERNAME", format="")})})
public class PSSysPrdVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysPrdVerDefaultACModel() {
        this.initAnnotation(PSSysPrdVerDefaultACModel.class);
    }
}

