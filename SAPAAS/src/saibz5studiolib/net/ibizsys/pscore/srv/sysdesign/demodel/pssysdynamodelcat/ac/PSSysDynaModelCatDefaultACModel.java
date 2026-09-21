/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdynamodelcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c7e3225f34b69b2ede42704dcbc6f977", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDYNAMODELCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDYNAMODELCATNAME", format="")})})
public class PSSysDynaModelCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDynaModelCatDefaultACModel() {
        this.initAnnotation(PSSysDynaModelCatDefaultACModel.class);
    }
}

