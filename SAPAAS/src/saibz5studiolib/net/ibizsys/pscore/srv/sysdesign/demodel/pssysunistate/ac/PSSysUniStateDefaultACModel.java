/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysunistate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="679d4b593fd7e1305dc815439372fe17", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUNISTATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUNISTATENAME", format="")})})
public class PSSysUniStateDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUniStateDefaultACModel() {
        this.initAnnotation(PSSysUniStateDefaultACModel.class);
    }
}

