/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdynamodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6b05f6eb5b3541f64f8b53f3a2733a5d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDYNAMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDYNAMODELNAME", format="")})})
public class PSSysDynaModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDynaModelDefaultACModel() {
        this.initAnnotation(PSSysDynaModelDefaultACModel.class);
    }
}

