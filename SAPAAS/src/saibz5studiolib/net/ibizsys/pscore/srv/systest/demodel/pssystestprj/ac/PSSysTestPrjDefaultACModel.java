/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.systest.demodel.pssystestprj.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="24322c4f11298acbf16332ecb2989bf9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTESTPRJID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTESTPRJNAME", format="")})})
public class PSSysTestPrjDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTestPrjDefaultACModel() {
        this.initAnnotation(PSSysTestPrjDefaultACModel.class);
    }
}

