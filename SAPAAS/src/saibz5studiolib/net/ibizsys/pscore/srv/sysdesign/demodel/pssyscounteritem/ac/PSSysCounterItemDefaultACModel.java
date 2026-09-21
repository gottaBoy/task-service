/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscounteritem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1ff2b032422dc0fbe7c46af89fad878c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCOUNTERITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCOUNTERITEMNAME", format="")})})
public class PSSysCounterItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCounterItemDefaultACModel() {
        this.initAnnotation(PSSysCounterItemDefaultACModel.class);
    }
}

