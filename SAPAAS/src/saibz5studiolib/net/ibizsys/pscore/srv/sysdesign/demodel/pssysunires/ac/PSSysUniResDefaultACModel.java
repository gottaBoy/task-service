/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysunires.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9c39c823997965027c55f5553cbbe8b7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUNIRESID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUNIRESNAME", format="")})})
public class PSSysUniResDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUniResDefaultACModel() {
        this.initAnnotation(PSSysUniResDefaultACModel.class);
    }
}

