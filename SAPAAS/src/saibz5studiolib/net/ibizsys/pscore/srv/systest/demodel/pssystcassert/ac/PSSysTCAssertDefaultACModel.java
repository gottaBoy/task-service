/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.systest.demodel.pssystcassert.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c4f41b189c5975989ae1cf74271baca3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTCASSERTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTCASSERTNAME", format="")})})
public class PSSysTCAssertDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTCAssertDefaultACModel() {
        this.initAnnotation(PSSysTCAssertDefaultACModel.class);
    }
}

