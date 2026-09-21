/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscounter.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c7744102675e7a1f4777cd1516c5259e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCOUNTERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCOUNTERNAME", format="")})})
public class PSSysCounterDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCounterDefaultACModel() {
        this.initAnnotation(PSSysCounterDefaultACModel.class);
    }
}

