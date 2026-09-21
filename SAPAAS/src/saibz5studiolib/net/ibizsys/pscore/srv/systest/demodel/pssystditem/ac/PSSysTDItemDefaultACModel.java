/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.systest.demodel.pssystditem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0b0876acd7438e6d9ca255ba632686de", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTDITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTDITEMNAME", format="")})})
public class PSSysTDItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTDItemDefaultACModel() {
        this.initAnnotation(PSSysTDItemDefaultACModel.class);
    }
}

